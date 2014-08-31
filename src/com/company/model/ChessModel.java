package com.company.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by tillkrischer on 6/6/14.
 */
public class ChessModel {

    private int height, width;
    private int turn;
    private ChessBoard board;
    private final String[][] start = {
            { "br", "bk", "bb", "bq", "bi", "bb", "bk", "br"},
            { "bp", "bp", "bp", "bp", "bp", "bp", "bp", "bp"},
            { "ee", "ee", "ee", "ee", "ee", "ee", "ee", "ee"},
            { "ee", "ee", "ee", "ee", "ee", "ee", "ee", "ee"},
            { "ee", "ee", "ee", "ee", "ee", "ee", "ee", "ee"},
            { "ee", "ee", "ee", "ee", "ee", "ee", "ee", "ee"},
            { "wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp"},
            { "wr", "wk", "wb", "wq", "wi", "wb", "wk", "wr"}
    };

    public ChessModel(int width, int height) {

        this.height = height;
        this.width = width;
        board = new ChessBoard(width, height);

        setFigures();
        turn = ChessPiece.WHITE;
    }

    public boolean performMove(Point origin, Point destination) {
        return performMove(origin.x, origin.y, destination.x, destination.y);
    }

    public boolean performMove(int ox, int oy, int dx, int dy) {
        if(board.isOccupied(ox, oy)) {
            if(board.getPiece(ox, oy).getColor() == turn) {
                ArrayList<Point> moves = getMoves(ox, oy);
                for (Point p : moves) {
                    if (p.x == dx && p.y == dy) {
                        board.performMove(ox, oy, dx, dy);
                        turn = (turn == ChessPiece.WHITE) ? ChessPiece.BLACK : ChessPiece.WHITE;
                        return true;
                    }
                }
                System.out.println("invalid move");
            } else
                System.out.println("wrong color for this turn");
        } else
            System.out.println("spot not occupied");
        return false;
    }

    private void setFigures() {
        if(start.length <= getHeight() && start[0].length <= getWidth()) {
            for (int i = 0; i < start.length; i++) {
                for (int j = 0; j < start[0].length; j++) {
                    if (!start[i][j].equals("ee")) {
                        int color, type;
                        color = type = -1;
                        switch (start[i][j].charAt(0)) {
                            case 'b':
                                color = ChessPiece.BLACK;
                                break;
                            case 'w':
                                color = ChessPiece.WHITE;
                                break;
                        }
                        switch (start[i][j].charAt(1)) {
                            case 'p':
                                type = ChessPiece.PAWN;
                                break;
                            case 'r':
                                type = ChessPiece.ROCK;
                                break;
                            case 'k':
                                type = ChessPiece.KNIGHT;
                                break;
                            case 'b':
                                type = ChessPiece.BISHOP;
                                break;
                            case 'q':
                                type = ChessPiece.QUEEN;
                                break;
                            case 'i':
                                type = ChessPiece.KING;
                                break;
                        }
                        if (color != -1 && type != -1)
                            board.addPiece(type, color, j, i);
                    }
                }
            }
        }
    }

    public ArrayList<Point> getMoves(int x, int y) {
        return board.getPiece(x, y).getMoves();
    }

    public int getTurn() {
        return turn;
    }

    public boolean isOccupied(int x, int y) {
        return board.isOccupied(x, y);
    }

    public ChessPiece getPiece(int x, int y) {
        return board.getPiece(x, y);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
