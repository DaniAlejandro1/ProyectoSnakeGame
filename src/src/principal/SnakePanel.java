package principal;

import inputs.KeyBoardinputs;
import inputs.Mouseinputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SnakePanel extends JPanel {

    private Mouseinputs mouseinputs;
    private final int Pantalla = 600;
    private final int cuadrosSize = 25;
    private final int Delay = 100;
    private final int cantCuadros = (int) Pantalla / cuadrosSize;
    private String direccion = "der";
    Timer timer;


    private ArrayList<int[]> body;
    private int[] comida;
    private HashMap<String, Runnable> direcciones = new HashMap<>();

    public SnakePanel() {

        direcciones.put("arr", this::moverArriba);
        direcciones.put("ab", this::moverAbajo);
        direcciones.put("iz", this::moverIzquierda);
        direcciones.put("der", this::moverDerecha);
        addKeyListener(new KeyBoardinputs(this));
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(Pantalla, Pantalla));
        body = new ArrayList<>();
        comida = new int[2];
        generarComida();
        comida[0] = cuadrosSize * 3;
        comida[1] = 0;
        body.add(new int[]{0, 0});
        body.add(new int[]{25, 0});
        mouseinputs = new Mouseinputs();
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);

        timer = new Timer(150, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                direcciones.get(direccion).run();

                repaint();
            }
        });
        timer.start();



    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        direcciones.get(direccion).run();
        for (int i = 0; i < cantCuadros; i++) {
            g.drawLine(0, cuadrosSize * i, Pantalla, cuadrosSize * i);
            g.drawRect(cuadrosSize * i, 0, cuadrosSize * i, Pantalla);

        }
        g.setColor(Color.blue);
        for (int[] par : body) {
            g.fillRect(par[0], par[1], cuadrosSize, cuadrosSize);

        }
        g.setColor(Color.red);
        for (int com : comida) {
            g.fillOval(comida[0], comida[1], cuadrosSize, cuadrosSize);
        }


    }

    public boolean verContacto() {
        for (int[] ints : body) {
            return getXPosiCabeza() == ints[0] && getYPosiCabeza() == ints[1];
        }
        return false;
    }

    public void avanzar(int[] avance) {
        int[] aux = avance;
        if (verContacto()) {
            JOptionPane.showMessageDialog(this, "Perdiste");

        } else if (comida[0] == aux[0] && comida[1] == aux[1]) {
            body.add(comida.clone());
            generarComida();
        } else {
            body.add(aux);
            body.remove(body.get(0));
        }


    }

    public void generarComida() {
        Random ranndom = new Random();

        int[] aux = new int[]{ranndom.nextInt(cantCuadros) * cuadrosSize, ranndom.nextInt(cantCuadros) * cuadrosSize};
        if (body.contains(aux)) {
            generarComida();
        } else {
            comida = aux;
        }
    }

    public int getXPosiCabeza() {
        return body.get(body.size() - 1)[0];
    }

    public int getYPosiCabeza() {
        return body.get(body.size() - 1)[1];
    }

    public int getCuadrosSize() {
        return cuadrosSize;
    }

    public void setDirecciones(String direcciones){
        this.direccion = direcciones;
    }
    public void moverDerecha() {

            int x = getXPosiCabeza() + getCuadrosSize();
            int y = getYPosiCabeza();
            avanzar(new int[]{Math.floorMod(x, Pantalla), Math.floorMod(y, Pantalla)});
            System.out.println("Moviendo hacia la derecha" + " x: " + x + " y: " + y);

    }

    public void moverIzquierda() {

            int x = getXPosiCabeza() - getCuadrosSize();
            int y = getYPosiCabeza();
            avanzar(new int[]{Math.floorMod(x, Pantalla), Math.floorMod(y, Pantalla)});
            System.out.println("Moviendo a la izquierda" + " x: " + x + " y: " + y);

    }

    public void moverArriba() {

            int x = getXPosiCabeza();
            int y = getYPosiCabeza() - getCuadrosSize();
            avanzar(new int[]{Math.floorMod(x, Pantalla), Math.floorMod(y, Pantalla)});
            System.out.println("Moviendo hacia arriba" + " x: " + x + " y: " + y);

    }

    public void moverAbajo() {


            int x = getXPosiCabeza();
            int y = getYPosiCabeza() + getCuadrosSize();
            avanzar(new int[]{Math.floorMod(x, Pantalla), Math.floorMod(y, Pantalla)});
            System.out.println("Moviendo hacia abajo" + " x: " + x + " y: " + y);

    }


}
