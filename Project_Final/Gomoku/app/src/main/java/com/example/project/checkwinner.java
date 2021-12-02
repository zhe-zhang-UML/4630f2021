package com.example.project;

import android.graphics.Point;
import java.util.List;

public class checkwinner {
    private Point point1, point2;
    private int checkModel = -1;
    private boolean checkWin(int x, int y, List<Point> points, int conditions) {
        int five_pieces_counter = 1;
        for (int i=1; i<5; i++) {
            switch (conditions) {
                case 0:
                    point1 = new Point(x - i, y);
                    break;
                case 1:
                    point1 = new Point(x, y - i);
                    break;
                case 2:
                    point1 = new Point(x - i, y + i);
                    break;
                case 3:
                    point1 = new Point(x + i, y + i);
                    break;
            }
            if (points.contains(point1)) {
                five_pieces_counter++;
            } else {
                break;
            }
        }
        for (int i=1; i<5; i++) {
            switch (conditions) {
                case 0:
                    point2 = new Point(x + i, y);
                    break;
                case 1:
                    point2 = new Point(x, y + i);
                    break;
                case 2:
                    point2 = new Point(x + i, y - i);
                    break;
                case 3:
                    point2 = new Point(x - i, y - i);
                    break;
            }
            if (points.contains(point2)) {
                five_pieces_counter++;
            } else {
                break;
            }
        }
        if (five_pieces_counter == 5) {
            return true;
        }
        return false;
    }
    private boolean checkHorizontal(int x, int y, List<Point> points) {
        checkModel = 0;
        return checkWin(x, y, points, checkModel);
    }
    private boolean checkVertical(int x, int y, List<Point> points) {
        checkModel = 1;
        return checkWin(x, y, points, checkModel);
    }
    private boolean checkDiagonalLeft(int x, int y, List<Point> points) {
        checkModel = 2;
        return checkWin(x, y, points, checkModel);
    }
    private boolean checkDiagonalRight(int x, int y, List<Point> points) {
        checkModel = 3;
        return checkWin(x, y, points, checkModel);
    }
    public boolean checkFivePieces(List<Point> points) {
        for (Point point : points) {
            int x = point.x;
            int y = point.y;
            if (checkHorizontal(x, y, points)) {
                return true;
            }
            else if (checkVertical(x, y, points)) {
                return true;
            }
            else if (checkDiagonalLeft(x, y, points)) {
                return true;
            }
            else if (checkDiagonalRight(x, y, points)) {
                return true;
            }
        }
        return false;
    }
}