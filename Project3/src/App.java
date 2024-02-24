import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.*;

public class App{
    public static void main(String[] args) {
        try {
            Connection c=ConnectionProvider.getConnection();

            String sql = "insert into images(picture) values(?)";
            PreparedStatement st = c.prepareStatement(sql);
            
           JFileChooser jfc=new JFileChooser();
           jfc.showOpenDialog(null);
           File file=jfc.getSelectedFile();
           InputStream fis=new FileInputStream(file);

            st.setBinaryStream(1, fis, fis.available());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                 JOptionPane.showMessageDialog(null,"Sucess!!");      
            }
                          else {
                            JOptionPane.showMessageDialog(null,"OOPS! retry");      
                        }

            // Close the resources
            st.close();
            fis.close();
            c.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
