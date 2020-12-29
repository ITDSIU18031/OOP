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
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UpdateBooks extends JFrame {
    static UpdateBooks frame;
    private JLabel background;
    Image library;
    ImageIcon librayicon;
    //JLabel background ;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new UpdateBooks();
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
    public UpdateBooks() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        background = new JLabel();
        background = new JLabel(new ImageIcon("C:\\Users\\DELL\\Pictures\\library2.jpg"));
        background.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(background);
       // BufferedImage bf = ImageIO.read(new File("C://Users//DELL//Pictures//library.jpg"));
        // this.setContentPane(new backImage(bf));

        JLabel lblLibrarianSection = new JLabel("Staff Section -software development");
        lblLibrarianSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblLibrarianSection.setForeground(Color.GREEN);

        JButton btnUpdateamount = new JButton("Update amount of book");
        btnUpdateamount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Updateamount.main(new String[]{});
                frame.dispose();
            }
        });
        btnUpdateamount.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnUpdatediscount = new JButton("Update discount:");
        btnUpdatediscount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Updatediscount.main(new String[]{});
            }
        });
        btnUpdatediscount.setFont(new Font("Tahoma", Font.PLAIN, 13));
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //StaffSuccess.main(new String[]{});
                frame.dispose();
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GroupLayout gl_contentPane = new GroupLayout(background);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addContainerGap(81, Short.MAX_VALUE)
                                .addComponent(lblLibrarianSection)
                                .addGap(54))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(132)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdatediscount, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdateamount, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(101, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblLibrarianSection)
                                .addGap(18)
                                .addComponent(btnUpdateamount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnUpdatediscount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        background.setLayout(gl_contentPane);
        //this.setContentPane(new backImage(bf));
    }
}
