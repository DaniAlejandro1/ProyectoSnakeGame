package principal;

import inputs.KeyBoardinputs;
import inputs.Mouseinputs;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SnakeClass extends JPanel {

    private Mouseinputs mouseinputs;
    private KeyBoardinputs keyBoardinputs;
    private final int Pantalla = 600;
    private final int cuadrosSize = 30;
    private final int cantCuadros = (int) Pantalla / cuadrosSize;
    private String direccion = "der";
    ManejodeHilos manejodeHilos;
    Thread hilo;
    private ArrayList<int[]> body;
    private int[] comida;
    private HashMap<String, Runnable> direcciones = new HashMap<>();

    public SnakeClass() {

        keyBoardinputs = new KeyBoardinputs(this);
        addKeyListener(keyBoardinputs);
        iniDirecciones();

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(Pantalla, Pantalla));
        body = new ArrayList<>();
        comida = new int[2];
        generarComida();

        iniSnakeInicial(10);

        mouseinputs = new Mouseinputs();
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);

        manejodeHilos = new ManejodeHilos(this);
        hilo = new Thread(manejodeHilos);
        hilo.start();


    }


    public void iniDirecciones() {
        direcciones.put("arr", this::moverArriba);
        direcciones.put("ab", this::moverAbajo);
        direcciones.put("iz", this::moverIzquierda);
        direcciones.put("der", this::moverDerecha);
    }

    public void iniSnakeInicial(int largo) {
        for (int i = 0; i < largo; i++) {
            body.add(new int[]{i * cuadrosSize, 0});
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        direcciones.get(direccion).run();
        pintarSerpiente(g);
        pintarComida(g);

    }

    public void pintarSerpiente(Graphics g) {
        g.setColor(Color.blue);
        for (int[] par : body) {
            g.fillRect(par[0], par[1], cuadrosSize - 1, cuadrosSize - 1);

        }
    }

    public void pintarComida(Graphics g) {
        g.setColor(Color.red);
        for (int com : comida) {
            g.fillOval(comida[0], comida[1], cuadrosSize, cuadrosSize);
        }
    }

    public void avanzar(int[] avance) {
        int[] aux = avance;
        if (verContacto(avance)) {
            manejodeHilos.stop();
            JOptionPane.showMessageDialog(this, "Perdiste");

        } else if (comida[0] == aux[0] && comida[1] == aux[1]) {
            body.add(comida.clone());
            generarComida();
        } else {
            body.add(aux);
            body.remove(body.get(0));
        }


    }

    public boolean verContacto(int[] cabeza) {

        for (int[] ints : body) {
            if (cabeza[0] == ints[0] && cabeza[1] == ints[1]) {

                return true;
            }
        }
        return false;
    }

    public void generarComida() {
        Random ranndom = new Random();

        int[] aux = new int[]{ranndom.nextInt(cantCuadros) * cuadrosSize, ranndom.nextInt(cantCuadros) * cuadrosSize};
        if (verContacto(aux)) {
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

    public void setDirecciones(String direcciones) {
        this.direccion = direcciones;
    }

    public String getDireccion(){
        return this.direccion;
    }
    public void moverDerecha() {
        if (!direccion.equals("iz")) {

            int x = getXPosiCabeza() + getCuadrosSize();
            int y = getYPosiCabeza();
            avanzar(new int[]{Math.floorMod(x, Pantalla), Math.floorMod(y, Pantalla)});
        }
    }

    public void moverIzquierda() {
        if (!direccion.equals("der")) {
            int x = getXPosiCabeza() - getCuadrosSize();
            int y = getYPosiCabeza();
            avanzar(new int[]{Math.floorMod(x, Pantalla), Math.floorMod(y, Pantalla)});
        }
    }

    public void moverArriba() {
        if (!direccion.equals("aba")) {
            int x = getXPosiCabeza();
            int y = getYPosiCabeza() - getCuadrosSize();
            avanzar(new int[]{Math.floorMod(x, Pantalla), Math.floorMod(y, Pantalla)});
        }
    }

    public void moverAbajo() {

        if (!direccion.equals("arr")) {
            int x = getXPosiCabeza();
            int y = getYPosiCabeza() + getCuadrosSize();
            avanzar(new int[]{Math.floorMod(x, Pantalla), Math.floorMod(y, Pantalla)});
        }
    }


}
