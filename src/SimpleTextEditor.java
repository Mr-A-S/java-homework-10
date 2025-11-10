import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleTextEditor extends JFrame {

    // Объявляем компоненты
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, helpMenu;
    private JMenuItem saveItem, exitItem;
    private JMenuItem copyItem, pasteItem, cutItem;
    private JButton button1, button2;

    public SimpleTextEditor() {
        super("Hello Swing"); // Заголовок
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // --- Создание Меню ---
        menuBar = new JMenuBar();

        // -- Меню "Файл" --
        fileMenu = new JMenu("File");
        saveItem = new JMenuItem("Сохранить");
        exitItem = new JMenuItem("Выйти");
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // -- Меню "Правка" --
        editMenu = new JMenu("Edit");
        copyItem = new JMenuItem("Копировать");
        pasteItem = new JMenuItem("Вставить");
        cutItem = new JMenuItem("Вырезать");
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(cutItem);
        menuBar.add(editMenu);

        // -- Меню "Справка" --
        helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        // Устанавливаем меню в окно
        setJMenuBar(menuBar);

        // --- Создание центральной текстовой области ---
        textArea = new JTextArea();
        textArea.setText("This is the area you can write text.");
        // Добавляем прокрутку, если текст будет слишком большим
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // --- Создание нижней панели с кнопками ---
        JPanel buttonPanel = new JPanel();
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Добавление обработчиков событий (ActionListeners) ---
        // Выход из приложения
        exitItem.addActionListener(e -> System.exit(0));

        // Действия для меню "Правка"
        copyItem.addActionListener(e -> textArea.copy());
        pasteItem.addActionListener(e -> textArea.paste());
        cutItem.addActionListener(e -> textArea.cut());

        // Пример действия для кнопки
        button1.addActionListener(e -> JOptionPane.showMessageDialog(this, "Нажата Кнопка 1"));
        button2.addActionListener(e -> JOptionPane.showMessageDialog(this, "Нажата Кнопка 2"));
        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Функция 'Сохранить' еще не реализована."));

        // Делаем окно видимым
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleTextEditor();
    }
}