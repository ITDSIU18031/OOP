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

public class BillDao {
    public static int save(int customer_id)
    {
        int status=0;
        //Connection connect=DB.getConnection();
        try{
            Connection connect=DB.getConnection();
            PreparedStatement st=connect.prepareStatement("Insert into bill(customer_id) values(?)");
            st.setInt(1,customer_id);
            //st.setInt(2,customer_id);
            status=st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }
}