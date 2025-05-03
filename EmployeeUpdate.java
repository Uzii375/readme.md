import javax.swing.*;
import java.io.*;

public class Employee_Update {
    public void updateFile() {
        String id = JOptionPane.showInputDialog("Enter Employee ID to update:");
        if (id == null || id.trim().isEmpty()) return;

        File f = new File("employee_data/" + id.trim() + ".txt");
        if (!f.exists()) {
            JOptionPane.showMessageDialog(null, "Employee not found.");
            return;
        }

        try {
            // 1. Read old data first
            BufferedReader reader = new BufferedReader(new FileReader(f));
            StringBuilder oldData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                oldData.append(line).append("\n");
            }
            reader.close();

            // 2. Split lines to get old values
            String[] lines = oldData.toString().split("\n");
            String oldName = lines[1].split(":")[1].trim();
            String oldFather = lines[2].split(":")[1].trim();
            String oldContact = lines[3].split(":")[1].trim();
            String oldEmail = lines[4].split(":")[1].trim();
            String oldPosition = lines[5].split(":")[1].trim();
            String oldSalary = lines[6].split(":")[1].trim();

            // 3. New values from user (default filled with old values)
            String name = JOptionPane.showInputDialog("New Name:", oldName);
            String father = JOptionPane.showInputDialog("New Father's Name:", oldFather);
            String contact = JOptionPane.showInputDialog("New Contact:", oldContact);
            String email = JOptionPane.showInputDialog("New Email:", oldEmail);
            String position = JOptionPane.showInputDialog("New Position:", oldPosition);
            String salary = JOptionPane.showInputDialog("New Salary:", oldSalary);

            // 4. Write updated data
            FileWriter fw = new FileWriter(f);
            fw.write("Employee ID:   " + id + "\n");
            fw.write("Name:          " + (name != null && !name.trim().isEmpty() ? name : oldName) + "\n");
            fw.write("Father's Name: " + (father != null && !father.trim().isEmpty() ? father : oldFather) + "\n");
            fw.write("Contact:       " + (contact != null && !contact.trim().isEmpty() ? contact : oldContact) + "\n");
            fw.write("Email:         " + (email != null && !email.trim().isEmpty() ? email : oldEmail) + "\n");
            fw.write("Position:      " + (position != null && !position.trim().isEmpty() ? position : oldPosition) + "\n");
            fw.write("Salary:        " + (salary != null && !salary.trim().isEmpty() ? salary : oldSalary) + "\n");
            fw.close();

            JOptionPane.showMessageDialog(null, "Employee updated successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
