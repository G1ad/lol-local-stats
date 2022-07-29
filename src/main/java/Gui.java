import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui extends JFrame {
    private JTextField textHereTextField;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;

    public Gui() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(640,480);
        this.setLayout(new GridLayout());
        this.add(button1);
        this.add(button2);




        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });


        button2.addMouseListener (new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Ciao");
            }
        });


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
