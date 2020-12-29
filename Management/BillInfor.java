package bookgui.Management;
import bookgui.Algorithms.DB;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BillInfor extends JFrame {
    private JPanel contentPane;
    private JTable table;
    //private JPanel pane;

    public static void main(int x) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BillInfor frame = new BillInfor(x);
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
    public BillInfor(int x) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 650, 600);
        contentPane = new JPanel();
        // pane=new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        //  this.pane.setBorder(new EmptyBorder(400, 300, 100, 250));
        //this.pane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffSuccess.main(new String[]{});
            }
        });
        //this.pane.add(btnBack);

        String data[][]=null;
        String column[]=null;
        try{
            Connection con= DB.getConnection();
            PreparedStatement ps=con.prepareStatement("select billid,customer.name,title,contain.amount,price,priceunit,cost from book,contain,customer,bill,discount where book.isbn=contain.isbn and contain.billid=bill.id and bill.customer_id=customer.id and book.discount_id=discount.id and contain.billid=(?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1,x);
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

        contentPane.add(sp, BorderLayout.CENTER);
    }
}
