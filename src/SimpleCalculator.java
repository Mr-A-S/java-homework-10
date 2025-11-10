import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    // Объявляем все компоненты интерфейса (поля ввода, кнопки)
    JTextField numField1, numField2;
    JButton addButton, subButton, mulButton, divButton;

    // Конструктор класса, в котором создается весь интерфейс
    public SimpleCalculator() {
        super("Простой калькулятор"); // Заголовок окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Поведение при закрытии
        setSize(300, 150); // Размер окна
        setLayout(new FlowLayout()); // Менеджер расположения компонентов

        // Создаем и добавляем компоненты
        add(new JLabel("Число 1:"));
        numField1 = new JTextField(10);
        add(numField1);

        add(new JLabel("Число 2:"));
        numField2 = new JTextField(10);
        add(numField2);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        // Создаем "слушателей" для каждой кнопки с помощью анонимных классов
        addButton.addActionListener(e -> performCalculation('+'));
        subButton.addActionListener(e -> performCalculation('-'));
        mulButton.addActionListener(e -> performCalculation('*'));
        divButton.addActionListener(e -> performCalculation('/'));

        // Делаем окно видимым
        setVisible(true);
    }

    // Общий метод для выполнения вычислений, чтобы не дублировать код
    private void performCalculation(char operator) {
        try {
            // Считываем текст из полей и превращаем его в числа
            double num1 = Double.parseDouble(numField1.getText().trim());
            double num2 = Double.parseDouble(numField2.getText().trim());
            double result = 0;

            // Выполняем нужную операцию в зависимости от нажатой кнопки
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    // Проверяем деление на ноль
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Ошибка: Деление на ноль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        return; // Выходим из метода
                    }
                    result = num1 / num2;
                    break;
            }
            // Показываем результат в диалоговом окне
            JOptionPane.showMessageDialog(this, "Результат: " + result, "Результат", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            // Если в полях ввода не числа, показываем ошибку
            JOptionPane.showMessageDialog(this, "Ошибка: Введите корректные числа!", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Точка входа в программу
    public static void main(String[] args) {
        // Создаем экземпляр нашего калькулятора
        new SimpleCalculator();
    }
}