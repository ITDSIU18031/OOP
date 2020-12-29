/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookgui.Controller;

/**
 *
 * @author ASUS
 */
import bookgui.Algorithms.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillDetailDao {
    public static int save(int billid,int isbn,int amount)
    {
        int status=0;
        try
        {
            Connection conn=DB.getConnection();
            PreparedStatement st=conn.prepareStatement("Insert into contain(billid,isbn,amount) values(?,?,?)");
            st.setInt(1,billid);
            st.setInt(2,isbn);
            st.setInt(3,amount);
            status=st.executeUpdate();
        } catch (SQLException e) {
        }
        return status;
    }
}
