import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridCalculator extends JFrame implements ActionListener {

    // Дисплей калькулятора
    private JTextField display;

    // Переменные для хранения операндов и операции
    private String firstOperand = "";
    private String secondOperand = "";
    private String operator = "";

    public GridCalculator() {
        super("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        // --- Дисплей ---
        display = new JTextField();
        display.setEditable(false); // Запрещаем ввод с клавиатуры
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // --- Панель с кнопками ---
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5)); // Сетка 4x4 с отступами

        // Создаем кнопки и добавляем их на панель
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this); // Устанавливаем единый слушатель
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Получаем текст с нажатой кнопки

        // --- Логика калькулятора ---
        // Если нажата цифра
        if ("0123456789".contains(command)) {
            if (operator.isEmpty()) {
                firstOperand += command;
                display.setText(firstOperand);
            } else {
                secondOperand += command;
                display.setText(secondOperand);
            }
        }
        // Если нажат оператор
        else if ("/*-+".contains(command)) {
            operator = command;
        }
        // Если нажато "="
        else if ("=".equals(command)) {
            if (!firstOperand.isEmpty() && !secondOperand.isEmpty()) {
                double num1 = Double.parseDouble(firstOperand);
                double num2 = Double.parseDouble(secondOperand);
                double result = 0;

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            display.setText("Error");
                            return;
                        }
                        break;
                }
                display.setText(String.valueOf(result));
                // Сбрасываем для следующих вычислений
                firstOperand = String.valueOf(result);
                secondOperand = "";
                operator = "";
            }
        }
        // Если нажата кнопка "C" (Clear)
        else if ("C".equals(command)) {
            firstOperand = "";
            secondOperand = "";
            operator = "";
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new GridCalculator();
    }
}