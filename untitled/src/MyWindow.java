import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class MyWindow extends JFrame {
    public MyWindow() {
        setVisible(true);
        setLocation(650,650);
        setSize(500,500);
        setTitle("Моё крутое окошко!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JPanel panel = new JPanel(new GridLayout(2,2));
        JButton btn1 = new JButton("Выход");
        panel.add(btn1);

        ActionListener actionListener = new closeActionListener();

        btn1.addActionListener(actionListener);

        JButton btn2 = new JButton("Кнопка");
        panel.add(btn2);
        add(panel,BorderLayout.SOUTH);

    }
}
