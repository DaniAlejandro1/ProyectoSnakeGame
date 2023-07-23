package principal;

import inputs.KeyBoardinputs;
import inputs.Mouseinputs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SnakePanel extends JPanel {

    private Mouseinputs mouseinputs;


    private int tamano = 50;
    private int tamanoMax = 500;

    private ArrayList<int[]> body;
    private HashMap<String, Runnable> direcciones;

    public SnakePanel() {
        addKeyListener(new KeyBoardinputs(this));
        body = new ArrayList<>();
        body.add(new int[]{0, 0});
        body.add(new int[]{50, 0});
        mouseinputs = new Mouseinputs();
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);


    }

    public void setBody() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int[] par : body) {
            g.fillRect(par[0], par[1], tamano, tamano);
            repaint();
        }


    }

    public void avanzar(int[] avance) {
        body.add(avance);
        body.remove(body.get(0));
    }

    public int getXPosiCabeza() {
        return body.get(body.size() - 1)[0];
    }

    public int getYPosiCabeza() {
        return body.get(body.size() - 1)[1];
    }

    public int getTamano() {
        return tamano;
    }


    public void moverDerecha() {

        int x = getXPosiCabeza() + getTamano();
        int y = getYPosiCabeza();
        avanzar(new int[]{Math.floorMod(x, tamanoMax), Math.floorMod(y, tamanoMax)});
        System.out.println("Moviendo hacia la derecha");
    }

    public void moverIzquierda() {
        int x = getXPosiCabeza() - getTamano();
        int y = getYPosiCabeza();
        avanzar(new int[]{Math.floorMod(x,tamanoMax),Math.floorMod(y,tamanoMax)});
        System.out.println("Moviendo a la izquierda");

    }

    public void moverArriba() {
        int x = getXPosiCabeza();
        int y = getYPosiCabeza() - getTamano();
        avanzar(new int[]{Math.floorMod(x,tamanoMax),Math.floorMod(y,tamanoMax)});
        System.out.println("Moviendo hacia arriba");
    }

    public void moverAbajo() {
        int x = getXPosiCabeza();
        int y = getYPosiCabeza() + getTamano();
        avanzar(new int[]{Math.floorMod(x,tamanoMax),Math.floorMod(y,tamanoMax)});
        System.out.println("Moviendo hacia abajo");
    }


}
