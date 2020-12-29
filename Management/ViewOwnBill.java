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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ViewOwnBill extends JFrame {
    static ViewOwnBill frame;
    private JPanel contentPane;
    private JPanel Pane;
    private JTable table;

    public static void main(String name) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ViewOwnBill(name);
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
    public ViewOwnBill(String name) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 650, 600);
        contentPane = new JPanel();
        Pane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        String data[][]=null;
        String column[]=null;


        JButton btnBack =new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerSuccess.main(name);
                frame.dispose();
            }
        });
        try{
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("select bill.id,customer.name,book.title,contain.priceunit,contain.amount,contain.cost from book,contain,account,customer,bill where customer.id=account.id and account.username=? and book.isbn=contain.isbn and customer.id=bill.customer_id and bill.id=contain.billid ",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setString(1,name);
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

        table = new JTable(data,column){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //table.add
        //table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
       // JScrollPane sp=new JScrollPane(table);
        table.setSize(550,500);
         table.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
               int row =table.getSelectedRow();
                int column = table.getSelectedColumn();
                String o = (String)table.getValueAt(row, column);
                int x=Integer.parseInt(o);
                Invoice.main(x, name);
                   
            }

            @Override
            public void mousePressed(MouseEvent e) {
                  

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
               //To change body of generated methods, choose Tools | Templates.
            }
        });
            
       
        
        contentPane.setLayout(new FlowLayout());
        contentPane.add(btnBack);
        contentPane.add(table, BorderLayout.SOUTH);
    }
   

}