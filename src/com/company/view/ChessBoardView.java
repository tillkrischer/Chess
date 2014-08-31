package com.company.view;

import com.company.model.ChessBoard;
import com.company.model.ChessModel;
import com.company.model.ChessPiece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by tillkrischer on 6/6/14.
 */
public class ChessBoardView extends JPanel {

    public static final int HIGHL_BLUE = 0;
    public static final int HIGHL_RED = 1;

    private BufferedImage redHighlight;
    private BufferedImage blueHighlight;

    //button[x][y]
    private ChessButton[][] buttons;
    private BufferedImage[][] images = new BufferedImage[2][6];

    private ChessModel model;

    public ChessBoardView( int width, int height, ChessModel model, final Main controller) {
        super(new GridBagLayout());
        setPreferredSize(new Dimension(50 * width, 50 * height));
        setBackground(Color.BLACK);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        buttons = new ChessButton[width][height];
        ActionListener al;
        int index = 0;
        for (int i = 0; i < getButtonWidth(); i++, index++)
            for (int j = 0; j < getButtonHeight(); j++, index++) {
                buttons[i][j] = new ChessButton();
                buttons[i][j].setBackground(index % 2 == 0 ? Color.white : Color.gray);
                c.gridx = i;
                c.gridy = j;
                add(buttons[i][j], c);

                final int finalI = i;
                final int finalJ = j;
                al = new ActionListener() {
                    @Override public void actionPerformed( ActionEvent e ) {
                        controller.buttonClicked(finalI, finalJ);
                    }
                };
                buttons[i][j].addActionListener(al);
            }
        readImages();
        this.model = model;
    }

    private void readImages() {
        try {
            images[ChessPiece.BLACK][ChessPiece.BISHOP] = ImageIO.read(new File("res/bishop-black.png"));
            images[ChessPiece.BLACK][ChessPiece.KING] = ImageIO.read(new File("res/king-black.png"));
            images[ChessPiece.BLACK][ChessPiece.KNIGHT] = ImageIO.read(new File("res/knight-black.png"));
            images[ChessPiece.BLACK][ChessPiece.PAWN] = ImageIO.read(new File("res/pawn-black.png"));
            images[ChessPiece.BLACK][ChessPiece.QUEEN] = ImageIO.read(new File("res/queen-black.png"));
            images[ChessPiece.BLACK][ChessPiece.ROCK] = ImageIO.read(new File("res/rock-black.png"));

            images[ChessPiece.WHITE][ChessPiece.BISHOP] = ImageIO.read(new File("res/bishop-white.png"));
            images[ChessPiece.WHITE][ChessPiece.KING] = ImageIO.read(new File("res/king-white.png"));
            images[ChessPiece.WHITE][ChessPiece.KNIGHT] = ImageIO.read(new File("res/knight-white.png"));
            images[ChessPiece.WHITE][ChessPiece.PAWN] = ImageIO.read(new File("res/pawn-white.png"));
            images[ChessPiece.WHITE][ChessPiece.QUEEN] = ImageIO.read(new File("res/queen-white.png"));
            images[ChessPiece.WHITE][ChessPiece.ROCK] = ImageIO.read(new File("res/rock-white.png"));

            redHighlight = ImageIO.read(new File("res/highlight-red.png"));
            blueHighlight = ImageIO.read(new File("res/highlight-blue.png"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void clearImage(int x, int y) {
        buttons[x][y].clearImage();
    }

    public void clearHighlight(int x, int y) {
        buttons[x][y].clearHighlight();
    }

    public void setPiece(int x, int y, int color, int type) {
        buttons[x][y].setImage(images[color][type]);
    }

    public void highlight(int x, int y, int color) {
        buttons[x][y].setHighlight((color == HIGHL_BLUE) ? blueHighlight : redHighlight);
    }

    public void updatePieces() {
        for (int i = 0; i < model.getWidth(); i++)
            for (int j = 0; j < model.getHeight(); j++) {
                if (model.isOccupied(i, j))
                    setPiece(i, j, model.getPiece(i, j).getColor(), model.getPiece(i, j).getType());
                else
                    clearImage(i, j);
            }
        repaint();
    }

    public void removeAllHighlights() {
        for (int i = 0; i < getButtonWidth(); i++) {
            for (int j = 0; j < getButtonHeight(); j++) {
                clearHighlight(i, j);
            }
        }
    }

    public int getButtonHeight() {
        return buttons[0].length;
    }

    public int getButtonWidth() {
        return buttons.length;
    }
}
