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


    private int tamano = 25;
    private int tamanoMax = 500;

    private ArrayList<int[]> body;
    private int[] comida;
    private HashMap<String, Runnable> direcciones;

    public SnakePanel() {
        this.setBounds(0,0,tamanoMax,tamanoMax);
        addKeyListener(new KeyBoardinputs(this));
        body = new ArrayList<>();
        comida = new int[2];
        generarComida();
        comida[0]=100;
        comida[1] = 0;
        body.add(new int[]{0, 0});
        body.add(new int[]{25, 0});
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
        g.setColor(Color.red);
        for (int com : comida){
            g.fillRect(comida[0],comida[1],tamano,tamano);
        }


    }

    public void avanzar(int[] avance) {
        if (body.contains(avance)){
            JOptionPane.showMessageDialog(this,"Perdiste");
        } else if (comida[0]==avance[0] && comida[1]==avance[1]) {
            body.add(comida.clone());
            generarComida();
        }else {
            body.add(avance);
            body.remove(body.get(0));
        }


    }

    public void generarComida(){
        int x = (int) (Math.random()*(tamanoMax/tamano));
        int y = (int) (Math.random()*(tamanoMax/tamano));

        if (body.contains(new int[]{x,y})){
            generarComida();
        }else {
            comida[0]=x;
            comida[1]=y;
        }
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
