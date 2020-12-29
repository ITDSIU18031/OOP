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

public class BookUpdateDao {
    public static int saveamount(int isbn,int x)
    {
        int status=0;
        //Connection connect=DB.getConnection();
        try{
            Connection connect=DB.getConnection();
            PreparedStatement st=connect.prepareStatement("Update book set amount=amount+? where isbn=?");
            st.setInt(1,x);
            st.setInt(2,isbn);
            status=st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }
    public static int savediscountid(int isbn,int x)
    {
        int status=0;
        //Connection connect=DB.getConnection();
        try{
            Connection connect=DB.getConnection();
            PreparedStatement st=connect.prepareStatement("Update book set discount_id=? where isbn=?");
            st.setInt(1,x);
            st.setInt(2,isbn);
            status=st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }
}

