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
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {
//    public static int save(int isbn,String title,String genre,float price,int year,int amount,int discount_id,String publisher_name){
//        int status=0;
//        try{
//            Connection con=DB.getConnection();
//            PreparedStatement ps=con.prepareStatement("insert into book(isbn,title,genre,price,year,amount,discount_id,publisher_name) values(?,?,?,?,?,?,?,?)");
//            ps.setInt(1,isbn);
//            ps.setString(2,title);
//            ps.setString(3,genre);
//            ps.setFloat(4,price);
//            ps.setInt(5,year);
//            ps.setInt(6,amount);
//            ps.setInt(7,discount_id);
//            ps.setString(8,publisher_name);
//            status=ps.executeUpdate();
//            con.close();
//        }catch(Exception e){System.out.println(e);}
//        return status;
//    }
    
     public static int save(String title,String genre,float price,int year,int amount,int discount_id,String publisher_name){
        int status=0;
        try{
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into book(title,genre,price,year,amount,discount_id,publisher_name) values(?,?,?,?,?,?,?)");
            
            ps.setString(1,title);
            ps.setString(2,genre);
            ps.setFloat(3,price);
            ps.setInt(4,year);
            ps.setInt(5,amount);
            ps.setInt(6,discount_id);
            ps.setString(7,publisher_name);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
      public static boolean checkValidBook(String title){
        boolean flag = true;
        try{
            Connection connect= DB.getConnection();
            PreparedStatement st=connect.prepareStatement("Select * from book");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String User = rs.getString("title");
                if(title.equals(User)){
                    flag = false;
                }
            }
        connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}