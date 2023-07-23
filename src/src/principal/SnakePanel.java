package principal;

import inputs.KeyBoardinputs;
import inputs.Mouseinputs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SnakePanel extends JPanel {

    private Mouseinputs mouseinputs;
    private int xDelta = 0;
    private int yDelta = 0;


    private int tamaño = 50;

    private ArrayList<int[]> body;
    private HashMap<String, Runnable> direcciones;

    public SnakePanel() {
        body = new ArrayList<>();
        direcciones = new HashMap<>();

        body.add(new int[]{0, 0});
        body.add(new int[]{50, 0});
        mouseinputs = new Mouseinputs();
        addKeyListener(new KeyBoardinputs(this));
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);


    }

    public void setBody() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < body.size(); i++) {
            g.fillRect(body.get(i)[0] + xDelta, body.get(i)[1] + yDelta, tamaño, tamaño);
            repaint();
        }

    }

    public void avanzar(int[] avance) {
        body.add(avance);
        body.remove(body.size() - 1);
    }

    public int getXPosiCabeza() {
        return body.get(0)[0];
    }

    public int getYPosiCabeza() {
        return body.get(0)[1];
    }
    public int getTamaño() {
        return tamaño;
    }




    public void changeXDelta(int value) {
        this.xDelta += value;

    }

    public void changeYDelta(int value) {
        this.yDelta += value;

    }
}
