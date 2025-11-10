import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountrySelector extends JFrame {

    // Объявляем компоненты
    JComboBox<String> countryComboBox;
    JLabel infoLabel;

    // Массив со странами для списка
    String[] countries = {"Australia", "China", "England", "Russia"};

    // Массив с информацией, соответствующей странам
    String[] countryInfo = {
            "Австралия: Столица - Канберра, Континент - Австралия.",
            "Китай: Столица - Пекин, Континент - Азия.",
            "Англия: Столица - Лондон, Континент - Европа.",
            "Россия: Столица - Москва, Континент - Европа/Азия."
    };

    public CountrySelector() {
        super("Выбор страны"); // Заголовок окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLayout(new FlowLayout());

        // Создаем выпадающий список с нашими странами
        countryComboBox = new JComboBox<>(countries);

        // Создаем метку для вывода информации.
        // Сразу устанавливаем текст для первого элемента (Австралия).
        infoLabel = new JLabel(countryInfo[0]);

        // Добавляем компоненты в окно
        add(countryComboBox);
        add(infoLabel);

        // Добавляем слушателя к выпадающему списку
        countryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получаем индекс выбранного элемента
                int selectedIndex = countryComboBox.getSelectedIndex();
                // Устанавливаем в метку текст из массива информации
                // с тем же индексом
                infoLabel.setText(countryInfo[selectedIndex]);
            }
        });

        // Делаем окно видимым
        setVisible(true);
    }

    public static void main(String[] args) {
        new CountrySelector();
    }
}