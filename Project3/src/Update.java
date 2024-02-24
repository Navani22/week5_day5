import java.sql.*;
import java.io.*;

public class Update {
    public static void main(String[] args) {
        try {
           BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Enter id to update name and age: ");
            int id=Integer.parseInt(reader.readLine());
            System.out.print("Enter name: ");
            String name = reader.readLine();

            System.out.print("Enter age: ");
            int age = Integer.parseInt(reader.readLine());


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renocrewwork", "root", "Nh@2218#0112");
            String sql = "Update Table1 set name=?, age=? where id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);
            st.setInt(2, age);
            st.setInt(3, id);


            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inserted successfully!!!");
            } else {
                System.out.println("Oops! Data not inserted.");
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
