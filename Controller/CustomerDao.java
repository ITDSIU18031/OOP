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
public class CustomerDao {
         public static int save(String name,String address,String email){
        int status=0;
        //Connection connect=DB.getConnection();
        try{
            Connection connect= DB.getConnection();
            PreparedStatement st=connect.prepareStatement("Insert into customer(name,address,email) values(?,?,?)");
            //st.setInt(1,id);
            st.setString(1,name);
            st.setString(2,address);
            st.setString(3,email);
            status=st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }
}
