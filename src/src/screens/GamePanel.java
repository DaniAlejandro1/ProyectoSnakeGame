package screens;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private int tamCuadros;
    private int can;
    private int tamMax;
    private final int resto;
    Color colorFondo = Color.darkGray;
    Color colorCuadros = Color.BLACK;
    Graphics pintor;

    public GamePanel(int tamMax, int can) {

        this.tamCuadros = tamMax/can;
        this.resto = tamMax%can;
        this.can = can;
        this.tamMax = tamMax;


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(colorCuadros);
        g.fillRect(0,0,tamMax,tamMax);
        g.setColor(colorFondo);
        for (int i = 0; i < can-1; i++) {
            for (int j = 0; j < can-1; j++) {
                g.fillRect(resto/2+i*tamCuadros,resto/2+j*tamCuadros,tamCuadros-1,tamCuadros-1);
            }

        }

    }

    public void pintarPanel(Graphics g){
        g.fillRect(0,0,tamMax,tamMax);
        g.setColor(colorFondo);
        for (int i = 0; i < can-1; i++) {
            for (int j = 0; j < can-1; j++) {
                g.fillRect(resto/2+i*tamCuadros,resto/2+j*tamCuadros,tamCuadros-1,tamCuadros-1);
            }
            
        }
    }


}
