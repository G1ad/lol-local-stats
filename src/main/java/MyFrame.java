import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JLabel label1,label2,label3;
    JTextField text1,text2,text3;

    MyFrame(){
        super();
        //INIZIALIZZAZIONE NUOVI J
        button = new JButton("add");

        label1 = new JLabel("AD");
        label1.setBounds(0,0,50,50);
        label2 = new JLabel("Armor");
        label3 = new JLabel("Risultato");

        text1 = new JTextField(10);
        text1.setBounds(0,0,100,20);
        text2 = new JTextField(10);
        text3 = new JTextField(10);

        ImageIcon icon = new ImageIcon("icon1.png");

        //JFRAME
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(640,480);
        this.setResizable(false);

        //BUTTON SETTINGS
        button.setFocusable(false);
        button.setIcon(icon);
        button.setBackground(Color.red);
        button.setForeground(Color.blue);
        button.setBorder(BorderFactory.createEtchedBorder());

        //ADDING THIGS TO JFRAME
        this.add(label1);
        this.add(text1);
        this.add(label2);
        this.add(text2);
        this.add(label3);
        this.add(text3);

        this.add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int attack = Integer.parseInt(text1.getText());
        int armor = Integer.parseInt(text2.getText());
        double realDamage = attack/(1 + (armor / 100f));

        if(e.getSource()==button){
            text3.setText(String.valueOf(String.format("%.2f",realDamage)));
            }
        }
    }

