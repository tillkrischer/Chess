package com.company.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by tillkrischer on 6/12/14.
 */
public class ChessButton extends JButton {
    private BufferedImage highlight;
    private BufferedImage icon;

    public ChessButton() {
        super();
        setBorderPainted(false);
        setOpaque(true);
        setPreferredSize(new Dimension(50, 50));
    }

    private void update() {
        ImageIcon image = null;
        if (icon != null && highlight == null)
            image = new ImageIcon(icon);
        else if (icon == null && highlight != null)
            image = new ImageIcon(highlight);
        else if (icon != null && highlight != null) {
            BufferedImage c = new BufferedImage(icon.getWidth(), icon.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g = c.getGraphics();
            g.drawImage(icon, 0, 0, null);
            g.drawImage(highlight, 0, 0, null);
            image = new ImageIcon(c);
        }
        this.setIcon(image);
        this.setDisabledIcon(image);
    }


    public void setHighlight(BufferedImage highlight) {
        this.highlight = highlight;
        update();
    }

    public void setImage(BufferedImage icon) {
        this.icon = icon;
        update();
    }

    public void clearImage() {
        this.icon = null;
        update();
    }

    public void clearHighlight() {
        this.highlight = null;
        update();
    }
}
