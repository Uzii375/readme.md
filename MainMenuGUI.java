import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Import your classes
// (no need to use 'import' if all files are in same folder and no packages are used)

public class MainMenuGUI extends JFrame {

    public MainMenuGUI() {
        setTitle("Employee Management System");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Welcome to Employee Management System", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(new Color(0, 102, 204));
        add(heading, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton addButton = new JButton("Add Employee");
        JButton removeButton = new JButton("Remove Employee");
        JButton updateButton = new JButton("Update Employee");
        JButton showButton = new JButton("Show All Employees");
        JButton exitButton = new JButton("Exit");

        styleButton(addButton);
        styleButton(removeButton);
        styleButton(updateButton);
        styleButton(showButton);
        styleButton(exitButton);

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(showButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Button actions
        addButton.addActionListener(e -> new Employee_Add());
        removeButton.addActionListener(e -> new Employee_Remove().removeFile());
        updateButton.addActionListener(e -> new Employee_Update().updateFile());
        showButton.addActionListener(e -> new Employee_Show().showAll());
        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(0, 153, 255));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
    }

    public static void main(String[] args) {
        new MainMenuGUI();
    }
}
