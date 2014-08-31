package com.company.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Created by tillkrischer on 6/6/14.
 */
public abstract class ChessPiece {

    final static public int BLACK = 0;
    final static public int WHITE = 1;
    final static public int BISHOP = 0;
    final static public int KING = 1;
    final static public int KNIGHT = 2;
    final static public int PAWN = 3;
    final static public int QUEEN = 4;
    final static public int ROCK = 5;

    protected int color;
    protected Point position;
    protected ChessBoard board;
    protected boolean hasMoved;

    public ChessPiece(ChessBoard board, int color, int x, int y)
    {
        this.color = color;
        position = new Point(x, y);
        this.board = board;
        hasMoved = false;
    }

    public int getColor() {
        return this.color;
    }

    public abstract int getType();

    public abstract ArrayList<Point> getMoves();

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}

