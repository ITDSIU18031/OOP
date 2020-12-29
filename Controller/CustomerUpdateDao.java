/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookgui.Controller;

import bookgui.Algorithms.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class CustomerUpdateDao {
     public static int save(int id,String fullname, String email, String address)
    {
        int status=0;
        //Connection connect=DB.getConnection();
        try{
            Connection connect=DB.getConnection();
            PreparedStatement st=connect.prepareStatement("Update customer set name=?, email=?, address=? where id=?");
            st.setString(1,fullname);
            st.setString(2,email);
            st.setString(3,address);
            st.setInt(4,id);
            status=st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }
}
