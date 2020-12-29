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
import bookgui.Controller.BillDao;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Enterbill1 extends JFrame {
    static Enterbill1 frame;
    private JLabel contentPane;
    private JTextField textField1;
//    private JTextField textField2;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new Enterbill1();
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
    public Enterbill1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 700);
        contentPane = new JLabel(new ImageIcon("C:\\Users\\DELL\\Pictures\\book.jpeg"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblbill = new JLabel("Add Bill");
        lblbill.setForeground(Color.GRAY);
        lblbill.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblcustomer_id = new JLabel("Customer_id:");

      

        textField1 = new JTextField();
        textField1.setColumns(15);


        JButton btnAddBill = new JButton("Add Bill");
        btnAddBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //      int id=Integer.parseInt(textField1.getText());
                int customer_id=Integer.parseInt(textField1.getText());

                int i=BillDao.save(customer_id);
                if(i>0){
                    Connection con=DB.getConnection();
                    try {
                        PreparedStatement ps=con.prepareStatement("select max(id) from bill");
                        ResultSet rs=ps.executeQuery();
                        ResultSetMetaData rsmd=rs.getMetaData();
                        int cols=rsmd.getColumnCount();
                        String[]column=new String[cols];
                        for(int a=1;a<=cols;a++){
                            column[a-1]=rsmd.getColumnName(a);
                        }

                        rs.last();
                        int rows=rs.getRow();
                        rs.beforeFirst();

                        String[][]data=new String[rows][cols];
                        int count=0;
                        while(rs.next()){
                            for(int b=1;b<=cols;b++){
                                data[count][b-1]=rs.getString(b);
                            }
                            count++;
                        }
                        con.close();
                        int x =Integer.parseInt(data[count-1][cols-1]);
                        JOptionPane.showMessageDialog(Enterbill1.this,"Bill added successfully!");
                        Enterbilldetail.main(x);
                        frame.dispose();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }


                    //frame.dispose();

                }else{
                    JOptionPane.showMessageDialog(Enterbill1.this,"Sorry, unable to add bill!");
                }
            }
        });
        JButton back=new JButton("back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(150)
                                                .addComponent(lblbill))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(lblcustomer_id, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                                .addGap(47)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(125, Short.MAX_VALUE))
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(161)
                                .addComponent(btnAddBill, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addComponent(back, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(162, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(359, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lblbill)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblcustomer_id)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(btnAddBill, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(back, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}