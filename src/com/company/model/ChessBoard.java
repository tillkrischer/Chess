package com.company.model;

import com.company.model.figures.*;

import java.awt.*;

/**
 * Created by tillkrischer on 6/13/14.
 */
public class ChessBoard {

    //pieces[x][y]

    private ChessPiece[][] pieces;

    public ChessBoard(int width, int height) {
        pieces = new ChessPiece[width][height];
    }

    public boolean isOnBoard(int x, int y) {
        return (x >= 0 && x < getWidth() && y >= 0 && y < getHeight());
    }

    public boolean isOccupied(int x, int y) {
        if(isOnBoard(x, y))
            return (pieces[x][y] != null);
        else {
            System.out.println("isOccupied: point not on board");
            return false;
        }
    }

    public ChessPiece getPiece(int x, int y) {
        if(isOnBoard(x, y))
            return pieces[x][y];
        else {
            System.out.println("getPiece: point not on board");
            return null;
        }
    }

    public int getHeight() {
        return pieces[0].length;
    }

    public int getWidth() {
        return pieces.length;
    }

    public void addPiece(int type, int color, int x, int y) {
        if(isOnBoard(x, y)) {
            if (!isOccupied(x, y)) {
                switch (type) {
                    case ChessPiece.BISHOP:
                        pieces[x][y] = new Bishop(this, color, x, y);
                        break;
                    case ChessPiece.KING:
                        pieces[x][y] = new King(this, color, x, y);
                        break;
                    case ChessPiece.KNIGHT:
                        pieces[x][y] = new Knight(this, color, x, y);
                        break;
                    case ChessPiece.PAWN:
                        pieces[x][y] = new Pawn(this, color, x, y);
                        break;
                    case ChessPiece.QUEEN:
                        pieces[x][y] = new Queen(this, color, x, y);
                        break;
                    case ChessPiece.ROCK:
                        pieces[x][y] = new Rock(this, color, x, y);
                        break;
                }
            } else
                System.out.println("unable to add, cell already occupied");
        } else
            System.out.println("addPiece: point not on board");
    }

    public void removePiece(int x, int y) {
        if(isOnBoard(x, y))
            pieces[x][y] = null;
        else
            System.out.println("removePiece: point not on board");
    }

    public void performMove(int ox, int oy, int dx, int dy) {
        System.out.println("move from " + ox + "-" + oy + " to " + dx + "-" + dy);
        if(isOccupied(ox, oy)) {
            if(isOccupied(dx, dy))
                System.out.println("piece at " + dx + "-" + dy + " captured");
            pieces[dx][dy] = getPiece(ox, oy);
            pieces[dx][dy].setHasMoved(true);
            pieces[dx][dy].setPosition(new Point(dx, dy));
            removePiece(ox, oy);
        }
    }


}
