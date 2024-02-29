import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGenerator extends JFrame implements ActionListener {
    private JTextField usernameField, passwordLengthField, generatedPasswordField;
    private JButton generateButton, acceptButton, resetButton;

    public PasswordGenerator() {
        setTitle("Password Generator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        add(usernameLabel);
        add(usernameField);

        JLabel passwordLengthLabel = new JLabel("Password Length:");
        passwordLengthField = new JTextField();
        add(passwordLengthLabel);
        add(passwordLengthField);

        JLabel generatedPasswordLabel = new JLabel("Generated Password:");
        generatedPasswordField = new JTextField();
        generatedPasswordField.setEditable(false);
        add(generatedPasswordLabel);
        add(generatedPasswordField);

        generateButton = new JButton("Generate Password");
        generateButton.addActionListener(this);
        add(generateButton);

        acceptButton = new JButton("Accept");
        acceptButton.addActionListener(this);
        add(acceptButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        add(resetButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            generatePassword();
        } else if (e.getSource() == acceptButton) {
            // Implement acceptance logic here
            JOptionPane.showMessageDialog(this, "Password Accepted");
        } else if (e.getSource() == resetButton) {
            usernameField.setText("");
            passwordLengthField.setText("");
            generatedPasswordField.setText("");
        }
    }

    private void generatePassword() {
        String username = usernameField.getText();
        int length = Integer.parseInt(passwordLengthField.getText());
        String generatedPassword = generateRandomPassword(length);
        generatedPasswordField.setText(generatedPassword);
    }

    private String generateRandomPassword(int length) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+";
        String combinedChars = upperCase + lowerCase + numbers + specialCharacters;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(combinedChars.charAt(random.nextInt(combinedChars.length())));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        new PasswordGenerator();
    }
}
