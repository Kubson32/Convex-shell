package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Line extends Point
{

    public Point head = new Point();
    public Point tail = new Point();

    Point v = new Point();

    public Line(Point head, Point tail) {
        this.head = head;
        this.tail = tail;
    }

    public Line(){}

    public String toString(){
        return "head: (" + head + "), tail: (" + tail + ")";
    }

    Point vec = new Point(x,y);

    public String vector(Point vec){
        head.x += vec.x;
        head.y += vec.y;
        tail.x += vec.x;
        tail.y += vec.y;
        return "After translation: ";
    }

    public Point vect(Point a,Point b){
        int x,y;

        x = b.x - a.x;
        y = b.y - a.y;
        Point p = new Point(x,y);
        return p;
    }

    public Point whichPoint(Point vec1, Point S, Point N, ArrayList<Point> w)
    {
        double d1, d2,iS,degree,cos,angleX;

        for(int i=1;i<w.size();i++) {
            v = vect(S, w.get(i));
            iS = (v.x * vec1.x) + (v.y * vec1.y);
            d1 = sqrt((v.x) * (v.x) + (v.y) * (v.y));
            d2 = sqrt((vec1.x) * (vec1.x) + (vec1.y) * (vec1.y));

            cos = (iS/(d1*d2));
            angleX = Math.toDegrees(cos);
            System.out.println(v);
            System.out.println(angleX);

        }

        return N;
    }





}
