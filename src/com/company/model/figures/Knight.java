package com.company.model.figures;

import com.company.model.ChessBoard;
import com.company.model.ChessPiece;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends ChessPiece {

    public Knight(ChessBoard board, int color, int x, int y) {
        super(board, color, x, y);
    }

    public int getType() {
        return KNIGHT;
    }

    public ArrayList<Point> getMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();

        int x = position.x - 1;
        int y = position.y - 2;
        if(board.isOnBoard(x, y) && ( ! board.isOccupied(x, y)  ||  board.getPiece(x, y).getColor() != this.getColor()) )
            moves.add(new Point(x, y));
        x = position.x + 1;
        y = position.y - 2;
        if(board.isOnBoard(x, y) && ( ! board.isOccupied(x, y)  ||  board.getPiece(x, y).getColor() != this.getColor()) )
            moves.add(new Point(x, y));
        x = position.x + 2;
        y = position.y - 1;
        if(board.isOnBoard(x, y) && ( ! board.isOccupied(x, y)  ||  board.getPiece(x, y).getColor() != this.getColor()) )
            moves.add(new Point(x, y));
        x = position.x + 2;
        y = position.y + 1;
        if(board.isOnBoard(x, y) && ( ! board.isOccupied(x, y)  ||  board.getPiece(x, y).getColor() != this.getColor()) )
            moves.add(new Point(x, y));
        x = position.x + 1;
        y = position.y + 2;
        if(board.isOnBoard(x, y) && ( ! board.isOccupied(x, y)  ||  board.getPiece(x, y).getColor() != this.getColor()) )
            moves.add(new Point(x, y));
        x = position.x - 1;
        y = position.y + 2;
        if(board.isOnBoard(x, y) && ( ! board.isOccupied(x, y)  ||  board.getPiece(x, y).getColor() != this.getColor()) )
            moves.add(new Point(x, y));
        x = position.x - 2;
        y = position.y + 1;
        if(board.isOnBoard(x, y) && ( ! board.isOccupied(x, y)  ||  board.getPiece(x, y).getColor() != this.getColor()) )
            moves.add(new Point(x, y));
        x = position.x - 2;
        y = position.y - 1;
        if(board.isOnBoard(x, y) && ( ! board.isOccupied(x, y)  ||  board.getPiece(x, y).getColor() != this.getColor()) )
            moves.add(new Point(x, y));





        return moves;
    }
}
