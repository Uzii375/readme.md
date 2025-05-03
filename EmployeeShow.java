// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Employee_Show {
   public Employee_Show() {
   }

   public void showAll() {
      StringBuilder var1 = new StringBuilder();
      File var2 = new File("employee_data");
      if (var2.exists() && var2.isDirectory()) {
         boolean var3 = false;
         File[] var4 = var2.listFiles((var0, var1x) -> {
            return var1x.endsWith(".txt");
         });
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            File var7 = var4[var6];
            var3 = true;
            var1.append("=== ").append(var7.getName()).append(" ===\n");

            try {
               BufferedReader var8 = new BufferedReader(new FileReader(var7));

               try {
                  String var9;
                  while((var9 = var8.readLine()) != null) {
                     var1.append(var9).append("\n");
                  }

                  var1.append("\n");
               } catch (Throwable var12) {
                  try {
                     var8.close();
                  } catch (Throwable var11) {
                     var12.addSuppressed(var11);
                  }

                  throw var12;
               }

               var8.close();
            } catch (IOException var13) {
               var1.append("Error reading file: ").append(var7.getName()).append("\n");
            }
         }

         if (!var3) {
            var1.append("No employee records available.");
         }

         JTextArea var14 = new JTextArea(var1.toString());
         var14.setEditable(false);
         JOptionPane.showMessageDialog((Component)null, new JScrollPane(var14), "All Employees", 1);
      } else {
         JOptionPane.showMessageDialog((Component)null, "No employee records found.");
      }
   }
}
