package principal;

public class Movimiento {



    public void doblarDerecha(SnakePanel snakePanel){
        int x = snakePanel.getXPosiCabeza() + snakePanel.getTamaño();
        int y = snakePanel.getXPosiCabeza();
        System.out.println("Moviendo hacia la derecha");
        snakePanel.avanzar(new int[]{x,y});
    }
    public void moverIzquierda(){
        System.out.println("Moviendo a la izquierda");
    }

    public void moverArriba() {
        System.out.println("Moviendo hacia arriba");
    }
    public void moverAbajo(){
        System.out.println("Moviendo hacia abajo");
    }
}
