import javax.swing.*;
import java.io.File;

public class Employee_Remove {
    public void removeFile() {
        String id = JOptionPane.showInputDialog("Enter Employee ID to remove:");
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide a valid Employee ID.");
            return;
        }

        // The directory structure is 'employee_data/{id}.txt'
        File f = new File("employee_data/" + id.trim() + ".txt");
        
        if (f.exists() && f.delete()) {
            JOptionPane.showMessageDialog(null, "Employee record deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "Employee not found.");
        }
    }
}
