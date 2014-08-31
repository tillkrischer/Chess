package com.company.model.figures;

import com.company.model.ChessBoard;
import com.company.model.ChessPiece;

import java.awt.*;
import java.util.ArrayList;

public class Pawn extends ChessPiece {

    public Pawn(ChessBoard board, int color, int x, int y) {
        super(board, color, x, y);
    }

    public int getType() {
        return PAWN;
    }

    public ArrayList<Point> getMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();

        int direction = (color == ChessPiece.WHITE) ? -1 : 1;

        //next field
        int x = position.x;
        int y = position.y + direction;
        if(board.isOnBoard(x, y) && ! board.isOccupied(x, y))
            moves.add(new Point(x, y));
        //two fields up
        if(! hasMoved()) {
            x = position.x;
            y = position.y + (2 * direction);
            if(board.isOnBoard(x, y) && ! board.isOccupied(x, y))
                moves.add(new Point(x, y));
        }
        //beating diagonally left and right
        x = position.x - 1;
        y = position.y + direction;
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != color)
            moves.add(new Point(x, y));
        x = position.x + 1;
        y = position.y + direction;
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != color)
            moves.add(new Point(x, y));

        return moves;
    }
}
