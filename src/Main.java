import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, moduloButton, clearButton;

    public Main() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberField = new JTextField();

        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberField = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        moduloButton = new JButton("%");
        clearButton = new JButton("Clear");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        moduloButton.addActionListener(this);
        clearButton.addActionListener(this);

        add(firstNumberLabel);
        add(firstNumberField);
        add(secondNumberLabel);
        add(secondNumberField);
        add(resultLabel);
        add(resultField);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(moduloButton);
        add(clearButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = firstNumber + secondNumber;
            } else if (e.getSource() == subtractButton) {
                result = firstNumber - secondNumber;
            } else if (e.getSource() == multiplyButton) {
                result = firstNumber * secondNumber;
            } else if (e.getSource() == divideButton) {
                result = firstNumber / secondNumber;
            } else if (e.getSource() == moduloButton) {
                result = firstNumber % secondNumber;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main calculatorApp = new Main();
            calculatorApp.setVisible(true);
        });
    }
}
