package principal;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private JFrame jFrame;


    public GameWindow(JPanel panel){
        jFrame = new JFrame();
        //jFrame.setSize(800, 800);
        jFrame.setLayout(new BorderLayout());
        jFrame.setBounds(10,10,500,500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(panel, BorderLayout.CENTER);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);

    }
}
