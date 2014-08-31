package com.company.model.figures;

import com.company.model.ChessBoard;
import com.company.model.ChessPiece;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends ChessPiece {

    public Queen(ChessBoard board, int color, int x, int y) {
        super(board, color, x, y);
    }
    public int getType() {
        return QUEEN;
    }

    public ArrayList<Point> getMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();

        //go up-left
        int x = position.x - 1;
        int y = position.y - 1;
        while(board.isOnBoard(x, y) && ! board.isOccupied(x, y)) {
            moves.add(new Point(x, y));
            x--;
            y--;
        }
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != this.getColor())
            moves.add(new Point(x, y));
        //go down-left
        x = position.x - 1;
        y = position.y + 1;
        while(board.isOnBoard(x, y) && ! board.isOccupied(x, y)) {
            moves.add(new Point(x, y));
            x--;
            y++;
        }
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != this.getColor())
            moves.add(new Point(x, y));
        //go up-right
        x = position.x + 1;
        y = position.y - 1;
        while(board.isOnBoard(x, y) && ! board.isOccupied(x, y)) {
            moves.add(new Point(x, y));
            x++;
            y--;
        }
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != this.getColor())
            moves.add(new Point(x, y));
        //go down-right
        x = position.x + 1;
        y = position.y + 1;
        while(board.isOnBoard(x, y) && ! board.isOccupied(x, y)) {
            moves.add(new Point(x, y));
            x++;
            y++;
        }
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != this.getColor())
            moves.add(new Point(x, y));

        //go right
        x = position.x + 1;
        y = position.y;
        while(board.isOnBoard(x, y) && ! board.isOccupied(x, y)) {
            moves.add(new Point(x, y));
            x++;
        }
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != this.getColor())
            moves.add(new Point(x, y));
        //go left
        x = position.x - 1;
        y = position.y;
        while(board.isOnBoard(x, y) && ! board.isOccupied(x, y)) {
            moves.add(new Point(x, y));
            x--;
        }
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != this.getColor())
            moves.add(new Point(x, y));
        //go up
        x = position.x;
        y = position.y - 1;
        while(board.isOnBoard(x, y) && ! board.isOccupied(x, y)) {
            moves.add(new Point(x, y));
            y--;
        }
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != this.getColor())
            moves.add(new Point(x, y));
        //go down
        x = position.x;
        y = position.y + 1;
        while(board.isOnBoard(x, y) && ! board.isOccupied(x, y)) {
            moves.add(new Point(x, y));
            y++;
        }
        if(board.isOnBoard(x, y) && board.isOccupied(x, y) && board.getPiece(x, y).getColor() != this.getColor())
            moves.add(new Point(x, y));

        return moves;
    }
}
