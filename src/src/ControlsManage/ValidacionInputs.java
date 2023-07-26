package ControlsManage;

import principal.SnakeClass;

import java.awt.event.KeyEvent;

public class ValidacionInputs {
    public ValidacionInputs(){


    }

    public static boolean giroArr(SnakeClass snakeClass, String key){
        return (snakeClass.getDireccion().equals("der") || snakeClass.getDireccion().equals("iz")) && key.equals("w");
    }

    public static boolean giroAb(SnakeClass snakeClass, String key){
        return (snakeClass.getDireccion().equals("der") || snakeClass.getDireccion().equals("iz")) && key.equals("s");
    }
    public static boolean giroDer(SnakeClass snakeClass, String key){
        //snakeClass.setDirecciones("der");
        return !key.equals("der") && !key.equals("iz") && !snakeClass.getDireccion().equals("iz");
    }
    public static boolean giroIz(SnakeClass snakeClass, String key){
        //snakeClass.setDirecciones("iz");
        return !key.equals("der") && !key.equals("iz") && !snakeClass.getDireccion().equals("der");
    }
}
