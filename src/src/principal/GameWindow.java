package principal;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private JFrame jFrame;


    public GameWindow(JPanel panel){
        jFrame = new JFrame();

        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(600,600);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);

        jFrame.add(panel, BorderLayout.CENTER);
        jFrame.pack();
    }
}
