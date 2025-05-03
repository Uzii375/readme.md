# readme.md
Employee Management System Based On Java with GUI 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

public class Employee_Add extends JFrame {
    private JTextField idField, nameField, fatherField, contactField, emailField, positionField, salaryField;

    public Employee_Add() {
        super("Add Employee");
        setSize(400, 400);
        setLayout(new GridLayout(8, 2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("Employee ID:"));      idField     = new JTextField(); add(idField);
        add(new JLabel("Name:"));             nameField   = new JTextField(); add(nameField);
        add(new JLabel("Father's Name:"));    fatherField = new JTextField(); add(fatherField);
        add(new JLabel("Contact:"));          contactField= new JTextField(); add(contactField);
        add(new JLabel("Email:"));            emailField  = new JTextField(); add(emailField);
        add(new JLabel("Position:"));         positionField=new JTextField(); add(positionField);
        add(new JLabel("Salary:"));           salaryField = new JTextField(); add(salaryField);

        JButton save = new JButton("Save");
        add(new JLabel()); // spacer
        add(save);
        save.addActionListener(e -> saveEmployee());

        setVisible(true);
    }

    private void saveEmployee() {
        try {
            // Get the data from the fields
            String id       = idField.getText().trim();
            String name     = nameField.getText().trim();
            String father   = fatherField.getText().trim();
            String contact  = contactField.getText().trim();
            String email    = emailField.getText().trim();
            String position = positionField.getText().trim();
            String salary   = salaryField.getText().trim();

            // Basic validation for empty fields
            if (id.isEmpty() || name.isEmpty() || father.isEmpty() || contact.isEmpty() || email.isEmpty() || position.isEmpty() || salary.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            // Create a file for the employee
            File f = new File("employee_data/" + id + ".txt"); // Specify a folder for employee files
            if (!f.exists()) {
                f.getParentFile().mkdirs(); // Create the directory if it doesn't exist
                try (FileWriter fw = new FileWriter(f)) {
                    fw.write("Employee ID:   " + id + "\n");
                    fw.write("Name:          " + name + "\n");
                    fw.write("Father's Name: " + father + "\n");
                    fw.write("Contact:       " + contact + "\n");
                    fw.write("Email:         " + email + "\n");
                    fw.write("Position:      " + position + "\n");
                    fw.write("Salary:        " + salary + "\n");
                }
                JOptionPane.showMessageDialog(this, "Employee added successfully!");
                clearFields(); // Clear fields after saving
                dispose(); // Close the form
            } else {
                JOptionPane.showMessageDialog(this, "Employee already exists.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // Clear the fields after successful data entry
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        fatherField.setText("");
        contactField.setText("");
        emailField.setText("");
        positionField.setText("");
        salaryField.setText("");
    }

    // Method to display the form
    public void createFile() {
        this.setVisible(true);  // Shows the "Add Employee" form
    }
}
