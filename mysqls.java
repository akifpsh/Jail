import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class mysqls {

    String dbURL="jdbc:mysql://localhost:3306/hapishane";
    Connection con;
    ResultSet rs;
java.sql.Statement st;
    public void mysqlss() throws SQLException{
        con=DriverManager.getConnection(dbURL,"root","akif123");
        st=con.createStatement();
        rs= st.executeQuery("SELECT *FROM suclu");   
    } 

    public void ekleme(int tc,String isim,String soyisim,String infaz)throws SQLException{
        con=DriverManager.getConnection(dbURL,"root","akif123");
        st=con.createStatement();
        PreparedStatement statement=null;
        try {
            String sql="insert into suclu (tc,isim,soyisim,infaz)"+"values (?,?,?,?)";
            statement=con.prepareStatement(sql);
            statement.setInt(1, tc);
            statement.setString(2, isim);
            statement.setString(3, soyisim);
            statement.setString(4, infaz);
            statement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Suclu Kaydi Eklendi","Basarili",JOptionPane.NO_OPTION);
        } catch (Exception e) {
        }
    }  

    public void silme(String isim) throws SQLException{
        con=DriverManager.getConnection(dbURL,"root","akif123");
        st=con.createStatement();
        try {
            String sql="DELETE FROM suclu WHERE isim = ?";
            PreparedStatement statement=null;
            statement=con.prepareStatement(sql);
            statement.setString(1, isim);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Suclu Kaydi Silindi","Basarili",JOptionPane.NO_OPTION);
        } catch (Exception e) {
        }
    }
}