/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookgui.Management;

/**
 *
 * @author ASUS
 */
import bookgui.Algorithms.DB;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ViewCustomer extends JFrame {
    static ViewCustomer frame;
    private JPanel contentPane;
    private JPanel Pane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ViewCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewCustomer() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 650, 600);
        contentPane = new JPanel();
        Pane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        String data[][]=null;
        String column[]=null;
        //JButton btnaddCustomer =new JButton("add customer");

        /*btnaddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerForm1.main(new String[]{});
                frame.dispose();
            }
        });*/
        JButton btnBack =new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //StaffSuccess.main(new String[]{});
                frame.dispose();
            }
        });
        JButton btnbill=new JButton("customer and sumcost");
        btnbill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customerandbill.main(new String[]{});
                frame.dispose();
            }
        });

        try{
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from customer",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=ps.executeQuery();

            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                column[i-1]=rsmd.getColumnName(i);
            }

            rs.last();
            int rows=rs.getRow();
            rs.beforeFirst();

            data=new String[rows][cols];
            int count=0;
            while(rs.next()){
                for(int i=1;i<=cols;i++){
                    data[count][i-1]=rs.getString(i);
                }
                count++;
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        table = new JTable(data,column);
        JScrollPane sp=new JScrollPane(table);
        table.setSize(550,500);

        //contentPane.add(btnaddCustomer,BorderLayout.CENTER);
        //contentPane.add(btnBack,BorderLayout.SOUTH);
        //contentPane.add(sp, BorderLayout.CENTER);
        contentPane.setLayout(new FlowLayout());
//        contentPane.add(btnaddCustomer);
        contentPane.add(btnBack);
        contentPane.add(btnbill);
        contentPane.add(sp, BorderLayout.SOUTH);
    }

}

