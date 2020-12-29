/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookgui.Controller;

import bookgui.Algorithms.DB;
import bookgui.Algorithms.Encript;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class AccountDao {
     public static boolean checkValidUserName(String userName){
        boolean flag = true;
        try{
            Connection connect= DB.getConnection();
            PreparedStatement st=connect.prepareStatement("Select * from account");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String User = rs.getString("userName");
                if(userName.equals(User)){
                    flag = false;
                }
            }
        connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static  int save(int id,String user, String password){
        int status=0;
        try{
            Connection connect= DB.getConnection();
            PreparedStatement st=connect.prepareStatement("Insert into account(id,userName,password,role) values(?,?,?,'Customer')");
            st.setInt(1,id);
            st.setString(2, user);
            st.setString(3, password);
            status= st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public static int findId(String fullname){
        int id =0;
        try{
            Connection connect= DB.getConnection();
            PreparedStatement st=connect.prepareStatement("Select * from customer where name =?");
            st.setString(1,fullname);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                id=rs.getInt("id");
            }
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
