package game.view;


import javax.swing.*;

public class MyJButton extends JButton {
    private int x;
    private int y;

    MyJButton(String s, int x, int y) {
        super(s);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
