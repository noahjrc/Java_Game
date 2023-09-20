package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPr, downPr, leftPr, rightPr;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPr = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPr = true;
        }
        if (code == KeyEvent.VK_S) {
            downPr = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPr = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPr = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPr = false;
        }
        if (code == KeyEvent.VK_S) {
            downPr = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPr = false;
        }
    }

}
