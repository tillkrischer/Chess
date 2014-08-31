package com.company.view;

import com.company.model.ChessModel;
import com.company.model.ChessPiece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by tillkrischer on 6/6/14.
 */
public class Main extends JFrame {

    public static final int HEIGHT = 8;
    public static final int WIDTH = 10;

    private enum Mode {
        Selection, Move, NotListening
    }

    private enum Input {
        User, AI
    }

    private ChessBoardView view;
    private ChessModel model;

    private Mode mode;
    private Point activeFigure, moveDestination;
    int color;

    private Input[] inputs = new Input[2];

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        model = new ChessModel(WIDTH, HEIGHT);
        view = new ChessBoardView(WIDTH, HEIGHT, model, this);

        view.updatePieces();

        add(view);

        pack();
        setVisible(true);

        inputs[ChessPiece.WHITE] = Input.User;
        inputs[ChessPiece.BLACK] = Input.User;

        mode = Mode.NotListening;
        activeFigure = new Point();
        moveDestination = new Point();

        run();
    }

    public static void main(String[] args) {
        new Main();
    }

    public void run() {
        while(true) {
            color = model.getTurn();
            switch (inputs[color]) {
                case User:
                    do
                        getUserInput();
                    while(! model.performMove(activeFigure, moveDestination));
                    break;
            }
            view.updatePieces();
        }
    }

    public void getUserInput() {
        activeFigure.x = activeFigure.y = moveDestination.y = moveDestination.y = -1;
        mode = Mode.Selection;
        while(mode != Mode.NotListening) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end of getUserInput");
    }

    public void buttonClicked(int x, int y) {
        System.out.println("clicked " + x + " " + y);
        switch (mode) {
            case Selection:
                select(x, y);
                break;
            case Move:
                doMove(x, y);
                break;
        }
    }

    public void select(int x, int y) {
        if(model.isOccupied(x, y) && model.getPiece(x, y).getColor() == color) {
            activeFigure.x = x;
            activeFigure.y = y;
            ArrayList<Point> moves = model.getMoves(x, y);
            for(Point move : moves) {
                view.highlight(move.x, move.y, ChessBoardView.HIGHL_RED);
            }
            view.repaint();
            mode = Mode.Move;
        }
    }

    public void doMove(int x, int y) {
        System.out.println("do move");
        moveDestination.x = x;
        moveDestination.y = y;
        view.removeAllHighlights();
        view.repaint();
        mode = Mode.NotListening;
    }
}
