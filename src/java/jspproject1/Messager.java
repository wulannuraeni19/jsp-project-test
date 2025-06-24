package jspproject1;

import java.sql.*;
import java.util.ArrayList;

public class Messager {
    private String tujuan;
    
    public Messager(String tujuan) {
        this.tujuan = tujuan;
    }
    
    public String getTujuan() {
        return this.tujuan;
    }
    
    public ArrayList<Message> getList() {
        String DBDRIVER = "com.mysql.cj.jdbc.Driver";
        String DBCONNECTION = "jdbc:mysql://localhost:3306/wall";
        String DBUSER = "root";
        String DBPASS = "";
        
        Connection conn = null;
        PreparedStatement st;
        ResultSet rs;
        ArrayList<Message> hasil = new ArrayList<Message>();

        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBCONNECTION, DBUSER, DBPASS);

            // prepare select statement
            String sql = "SELECT * from percakapan where tujuan=? order by id desc";
            st = conn.prepareStatement(sql);
            st.setString(1, this.tujuan);
            rs = st.executeQuery();

            while (rs.next()) {
                Message msg = new Message();
                msg.pengirim = rs.getString("pengirim");
                msg.pesan = rs.getString("pesan");
                hasil.add(msg);
            }
            
            conn.close();

            return hasil;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public void addMessage(String pengirim, String pesan) {
        String DBDRIVER = "com.mysql.cj.jdbc.Driver";
        String DBCONNECTION = "jdbc:mysql://localhost:3306/wall";
        String DBUSER = "root";
        String DBPASS = "";
        
        Connection conn = null;
        PreparedStatement st;
        ArrayList<Message> hasil = new ArrayList<Message>();

        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBCONNECTION, DBUSER, DBPASS);

            // prepare select statement
            String sql = "INSERT INTO percakapan (tujuan,pengirim,pesan) values (?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, this.tujuan);
            st.setString(2, pengirim);
            st.setString(3, pesan);
            st.executeUpdate();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
