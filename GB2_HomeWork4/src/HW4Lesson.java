
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


class HW4Lesson extends JFrame implements ActionListener {
    ArrayList ва;

    final String TITLE_OF_PROGRAM = "Чат"; // текст титульника программы
    final int WINDOW_WIDTH = 350;  // параметры ширины окна
    final int WINDOW_HEIGHT = 450; // параметры высоты окна
    final String BTN_ENTER = "Ввод"; // описание( название) кнопки Ввода
    final String LOG_FILE_NAME = "logchat.txt";

    JTextArea dialogue; // зона для диалога
    JTextField message; // messages поля для ввода сообщений

    public static void main(String[] args) {
        new HW4Lesson();
    }

    /**
     * Конструктор:
     * Создание окна и всех необхлдимых элементов
     */
    HW4Lesson() {
        setTitle(TITLE_OF_PROGRAM); // установка титульника
        setDefaultCloseOperation(EXIT_ON_CLOSE); // что делать, после закрытия программы( установлен выход из программы после нажатия закрытия)
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // установка размеров окна программы
        setLocationRelativeTo(null); // установка программы по центру

        dialogue = new JTextArea();
        dialogue.setEditable(false);// устанавливаем, что текст не может быть отредактирован, после отправки.
        JScrollPane scrollBar = new JScrollPane(dialogue);//Специализированный контейнер, который управляет окном просмотра, дополнительными полосами прокрутки и заголовками "
        // panel for checkbox, message field and button
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        message = new JTextField();
        message.addActionListener(this);// создаём возможность вводить с клавиатуры сообщение
        JButton enter = new JButton(BTN_ENTER);// создание кнопки
        enter.addActionListener(this);// активируем кнопку ввода для нажатия с мыши
        //  Добавляем все элементы в окно
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);// отображение окна
    }

    /**
     *
     * Выполнение событий из поля сообщения и кнопки ввода
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (message.getText().trim().length() > 0) {
            dialogue.append(message.getText() + "\n");
            try (PrintWriter pw =
                         new PrintWriter(new FileWriter(LOG_FILE_NAME, true))) {
                pw.println(message.getText());
                pw.flush();
            } catch (IOException ex) { }
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}