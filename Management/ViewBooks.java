/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookgui.Management;

import static bookgui.Algorithms.DB.getConnection;
import bookgui.Model.Book;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ViewBooks extends javax.swing.JFrame {
    static ViewBooks frame;
    /**
     * Creates new form ViewBooks
     */
    public ViewBooks() {
        initComponents();
  
        findBooks();
        jTable_Search.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 20 ));
        jTable_Search.getTableHeader().setOpaque(false);
        jTable_Search.getTableHeader().setBackground(new Color(175, 139, 175));
        jTable_Search.getTableHeader().setForeground(new Color(88, 65, 83));
        jTable_Search.setRowHeight(25);
        jTable_Search.getColumnModel().getColumn(1).setPreferredWidth(120);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public ArrayList<Book> listBooks (String valToFind){
        ArrayList<Book> booksList = new ArrayList<Book>();

        Statement st;
        ResultSet rs;

        try {
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuerry ="SELECT * from book WHERE CONCAT(ISBN,title,genre,price,year,amount,discount_id,publisher_name) LIKE '%"+valToFind+"%'";
            rs = st.executeQuery(searchQuerry);

            Book book;

            while(rs.next()){
                book = new Book( rs.getInt("ISBN"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getFloat("price"),
                        rs.getInt("year"),
                        rs.getInt("amount"),
                        rs.getInt("discount_id"),
                        rs.getString("publisher_name"));
                booksList.add(book);
            }
        } catch (Exception e) {
        }
        return booksList;
    }
   
    public void findBooks(){
        ArrayList<Book> books = listBooks(txt_Search.getText());
        DefaultTableModel model = new DefaultTableModel(){
          public boolean isCellEditable(int row, int column){
              return false;
          }
        };  
       
        model.setColumnIdentifiers(new Object[]{"ISBN","title","genre","price","year","amount","discount_id","publisher_name"});
        Object[] row = new Object[10];
        for (int i=0;i<books.size();i++){
            row[0] =books.get(i).getISBN();
            row[1] =books.get(i).getTitle();
            row[2] = books.get(i).getGenre();
            row[3] = books.get(i).getPrice();
            row[4] =books.get(i).getYear();
            row[5] = books.get(i).getAmount();
            row[6] = books.get(i).getDiscount_id();
            row[7] = books.get(i).getPublisher_name();
            model.addRow(row);
        };
        jTable_Search.setModel(model);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jText_search = new javax.swing.JTextField();
        txt_Search = new javax.swing.JTextField();
        jLabel_back = new javax.swing.JLabel();
        jButton_search = new javax.swing.JLabel();
        btnBuy = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Search = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 200));
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(88, 65, 83));

        jText_search.setBackground(new java.awt.Color(88, 65, 83));
        jText_search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jText_search.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        txt_Search.setBackground(new java.awt.Color(88, 65, 83));
        txt_Search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Search.setForeground(new java.awt.Color(255, 255, 255));
        txt_Search.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchActionPerformed(evt);
            }
        });

        jLabel_back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_back.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookgui/image/icons8_back_30px.png"))); // NOI18N
        jLabel_back.setText("Back");
        jLabel_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_backMousePressed(evt);
            }
        });

        jButton_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookgui/image/icons8_search_50px.png"))); // NOI18N
        jButton_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_searchMouseClicked(evt);
            }
        });

        btnBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookgui/image/icons8_buy_50px.png"))); // NOI18N
        btnBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuyMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Searching your Book...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuy)
                .addGap(35, 35, 35))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(451, 451, 451)
                .addComponent(jText_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257)
                .addComponent(jButton_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(459, 459, 459))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(377, 377, 377))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_back, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jText_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_search)
                        .addGap(49, 49, 49))))
        );

        jTable_Search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable_Search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Search.setCellSelectionEnabled(true);
        jTable_Search.setFocusable(false);
        jTable_Search.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable_Search.setRowHeight(25);
        jTable_Search.setSelectionBackground(new java.awt.Color(175, 139, 175));
        jTable_Search.setShowHorizontalLines(false);
        jTable_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SearchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Search);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1032, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchActionPerformed
        // TODO add your handling code here:
        findBooks();
    }//GEN-LAST:event_txt_SearchActionPerformed

    private void jLabel_backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_backMousePressed

        frame.dispose();
    }//GEN-LAST:event_jLabel_backMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0;i = i + 0.1)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(Exception e)
            {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseClicked
        Enterbill.main(new String[]{});
    }//GEN-LAST:event_btnBuyMouseClicked

    private void jButton_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_searchMouseClicked
        findBooks();
    }//GEN-LAST:event_jButton_searchMouseClicked

    private void jTable_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SearchMouseClicked
       // jTable_Search = (JTable)evt.getsource();
        int row = jTable_Search.getSelectedRow();
        int column = jTable_Search.getSelectedColumn();
        String o = (String)jTable_Search.getValueAt(row, column);
        txt_Search.setText(o);

    }//GEN-LAST:event_jTable_SearchMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame =new ViewBooks();
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuy;
    private javax.swing.JLabel jButton_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Search;
    private javax.swing.JTextField jText_search;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
