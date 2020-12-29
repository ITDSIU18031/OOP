package bookgui.Algorithms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    public static boolean checkAuthentication(String user, String password){
        boolean flag=false;
        try{
            Connection con = DB.getConnection();
            Statement statement = con.createStatement();

            String sql ="Select * from account";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String userName = rs.getString("userName");
                String passWord =rs.getString("password");
               ;
              if(user.equals(userName) && password.equals(passWord)){
                    flag = true;

                     }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static String checkRole(String name){
        String role ="";
        try{
            Connection con = DB.getConnection();
            Statement statement = con.createStatement();

            String sql ="Select * from account";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                    String temp = rs.getString("role");
                    String user = rs.getString("userName");
                    if(user.equals(name)){
                        role= temp;
                    }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return role;
   }

    public static void main(String[] args) {
        System.out.println(checkRole("kiethuynh"));
    }
}
