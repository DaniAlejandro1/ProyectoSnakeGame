package principal;

public class Movimiento {



    public void moverDerecha(SnakePanel snakePanel){
        int x = snakePanel.getXPosiCabeza() + snakePanel.getTamano();
        int y = snakePanel.getYPosiCabeza();
        System.out.println("Moviendo hacia la derecha");
        snakePanel.avanzar(new int[]{x,y});
    }
    public void moverIzquierda(SnakePanel snakePanel){
        int x = snakePanel.getXPosiCabeza() - snakePanel.getTamano();
        int y = snakePanel.getYPosiCabeza();
        snakePanel.avanzar(new int[]{x,y});
        System.out.println("Moviendo a la izquierda");

    }

    public void moverArriba(SnakePanel snakePanel) {
        int x = snakePanel.getXPosiCabeza();
        int y = snakePanel.getYPosiCabeza() - snakePanel.getTamano();
        snakePanel.avanzar(new int[]{x,y});
        System.out.println("Moviendo hacia arriba");
    }
    public void moverAbajo(SnakePanel snakePanel){
        int x = snakePanel.getXPosiCabeza();
        int y = snakePanel.getYPosiCabeza() + snakePanel.getTamano();
        snakePanel.avanzar(new int[]{x,y});
        System.out.println("Moviendo hacia abajo");
    }
}
