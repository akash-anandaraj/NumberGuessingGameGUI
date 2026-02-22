import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameGUI extends JFrame implements ActionListener {

    private JTextField guessField;
    private JLabel resultLabel, attemptsLabel;
    private JButton guessButton;

    private int randomNumber;
    private int attempts = 0;

    public NumberGuessingGameGUI() {

        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;

        setTitle("Number Guessing Game");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel titleLabel = new JLabel("Guess a number between 1 and 100", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        guessField = new JTextField();
        guessButton = new JButton("Guess");

        resultLabel = new JLabel(" ", JLabel.CENTER);
        attemptsLabel = new JLabel("Attempts: 0", JLabel.CENTER);

        guessButton.addActionListener(this);

        add(titleLabel);
        add(guessField);
        add(guessButton);
        add(resultLabel);
        add(attemptsLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(guessField.getText());
            attempts++;

            if (guess > randomNumber) {
                resultLabel.setText("Too High!");
            } else if (guess < randomNumber) {
                resultLabel.setText("Too Low!");
            } else {
                resultLabel.setText("🎉 Correct! You won!");
                guessButton.setEnabled(false);
            }

            attemptsLabel.setText("Attempts: " + attempts);

        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGameGUI();
    }
}