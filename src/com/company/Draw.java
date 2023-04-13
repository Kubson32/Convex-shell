package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.*;

public class Draw extends Line{

    int n;
    Scanner scanner = new Scanner(System.in);

    Point N = new Point();
    ArrayList<Point> points = new ArrayList<>();
    public Point head = new Point();
    public Point tail = new Point();
    private Line line = new Line(head,tail);
    ArrayList<Line> lines = new ArrayList<>();

    Draw() {
        System.out.println("Number of points");
        n = scanner.nextInt();

        System.out.println("Points:");

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point point = new Point(x, y);

            points.add(point);
        }

        Comparator<Point> comparator = (b1, b2) -> b1.getY() - b2.getY();
        Collections.sort(points, comparator);

        System.out.println("Points after sort: " + points);

        System.out.println("Convex shell:");

        if (n <= 2) {
            System.out.println(points);
        } else {
            ArrayList<Integer> next = new ArrayList<>();
            int leftMost = 0;
            for (int i = 1; i < n; i++) {
                if (points.get(i).x < points.get(leftMost).x) {
                    leftMost = i;
                }
            }
            int p = leftMost;
            int q = p;

            next.add(p);

            do {
                q = (p + 1) % n;
                for (int i = 0; i < n; i++) {
                    if (N.CCW(points.get(p), points.get(i), points.get(q))) {
                        q = i;
                    }
                }
                next.add(q);
                p = q;
            } while (p != leftMost);

            for (int i = 0; i < next.size(); i++) {
                System.out.println(points.get(next.get(i)));
            }
        }

        for(int i=0; i<points.size()-1;i++){

            line.tail = points.get(i);
            line.head = points.get(i+1);

            lines.add(line);

        }
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }

}

