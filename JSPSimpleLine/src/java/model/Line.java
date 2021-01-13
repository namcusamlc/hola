/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author HoaPC
 */
public class Line {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Line() {
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    //Line cy = ax +b
    public double getC() {
        double c = 0;
        if ((x1 - x2) != 0) {
            c = 1.0;
        }
        return c;
    }

    //Line: cy = ax + b;
    public double getA() {
        double a = 1.0;
        if ((x1 - x2) != 0) {
            a = (y1 - y2) * 1.0 / (x1 - x2);
        }
        return a;
    }

    public double getB() {
        double b = 0;
        if ((x1 - x2) != 0) {
            b = y1 - x1 * getA();
        } else {
            b = -x1;
        }
        return b;
    }

    @Override
    public String toString() {
        return "Line{" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + '}';
    }

    //giao điểm P(a,b), trung điểm của đoạn thẳng I(x,y); A(x1,y1): PI<=IA => P trong đoạn AB
    public boolean rightPoint(Point P, Line AB) {
        double a = P.getX();
        double b = P.getY();
        //xác định tọa độ của I(x,y)
        double x = (AB.getX1() + AB.getX2()) * 1.0 / 2;
        double y = (AB.getY1() + AB.getY2()) * 1.0 / 2;
        Point I = new Point(x, y);
        double PI = getLength(a, b, x, y);
        double AI = getLength(AB.getX1(), AB.getY1(), x, y);
        System.out.println(I + " PI: " + PI + ", AI: " + AI);
        return PI <= AI;
    }

    //tính độ dài đoạn thẳng (a,b)-> (x,y)
    public double getLength(double a, double b, double x, double y) {
        double length = Math.sqrt(Math.pow((x - a), 2) + Math.pow((y - b), 2));
        return length;
    }

    //tìm giao điểm của 2 đoạn thẳng, giao diem P(x,y)
    public void getPoints(Line line1, Line line2, ArrayList<Point> list) {
        //giả sử line1: ax - cy +b =0
        //line2: a1x - c1y + b1= 0
        double a = line1.getA();
        double c = line1.getC();
        double b = line1.getB();
        double a1 = line2.getA();
        double c1 = line2.getC();
        double b1 = line2.getB();
        double d = a1 * c - a * c1;
        double dx = b * c1 - b1 * c;
        double dy = a1 * b - b1 * a;
        if ((d != 0)) {
            double x = dx / d;
            double y = dy / d;
            Point p = new Point(x, y);
            System.out.println("P(" + p.getX() + "," + p.getY() + ") with line1" + line1 + "and line2: " + line2);
            if (rightPoint(p, line2) && rightPoint(p, line1)) {
                list.add(p);
            }
        }
    }

//    public static void main(String[] args) {
//        ArrayList<Line> lines = new ArrayList<>();
//        ArrayList<Point> points = new ArrayList<>();
//        lines.add(new Line(100, 0, 100, 70));
//        lines.add(new Line(150, 50, 300, 100));
//        lines.add(new Line(120, 65, 200, 50));
//        lines.add(new Line(20, 62, 500, 80));
//        for (int i = 0; i < lines.size() - 1; i++) {
//            Line line1 = lines.get(i);
//            for (int j = i + 1; j < lines.size(); j++) {
//                Line line2 = lines.get(j);
//                new Line().getPoints(line1, line2, points);
//            }
//        }
//    }
}
