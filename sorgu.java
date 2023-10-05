import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class sorgu extends mysqls{

    String aranan,isim,soyisim,infaz;
    int tc;
    JLabel label=new JLabel("ISIM GİRİNİZ :");
    JLabel label2=new JLabel("SORGULAMA PANELI");
    JLabel label3=new JLabel("  ");
    JLabel label4=new JLabel("Suclu Giris");
    JLabel label5=new JLabel("Suclu cikis");
    JLabel label6=new JLabel("TC");
    JLabel label7=new JLabel("I.Neden");
    JLabel label8=new JLabel("Isim");
    JLabel label9=new JLabel("SoyIsim");
    JLabel label10=new JLabel("TC");
    JLabel label12=new JLabel("Isim");
    JLabel label13=new JLabel("SoyIsim");
    JTextField tf=new JTextField();
    JTextField tfx=new JTextField();
    JTextField tf3=new JTextField();
    JTextField tf4=new JTextField();
    JTextField tf5=new JTextField();
    JTextField tf6=new JTextField();
    JTextField tf7=new JTextField();
    JTextField tf9=new JTextField();
    JTextField tf10=new JTextField();
    JButton button=new JButton("ARA");
    JButton button2=new JButton("ONAY");
    JButton button3=new JButton("ONAY");
    JButton button4=new JButton("MENU");

    public void frames() throws SQLException{
        JFrame frame=new JFrame("Suclu Sorgu");

        String [] data=new String[10];
        String [] column={"TC","İSİM","SOYİSİM","INFAZ NEDENI"};

        JTable table=new JTable();
        DefaultTableModel tablo=new DefaultTableModel();
        tablo.setColumnIdentifiers(column);
        
        JScrollPane scroll=new JScrollPane();
        scroll.setBounds(80,100,400,300);
        frame.add(scroll);
        scroll.setViewportView(table);
        table.setModel(tablo);
        
        label.setBounds(80,30,150,30);
        label.setFont(new Font("font",Font.ITALIC,20));
        frame.add(label);
        
        button.setBounds(400,30,80,30);
        button.setBackground(Color.WHITE);
        frame.add(button);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ 
                aranan=tf.getText();
                System.out.println("Aranan isim :"+aranan);
                tablo.setRowCount(0);
                try {
                mysqlss();
                while(rs.next()){
                    if(aranan.equals(rs.getString("isim"))){
                        data[0]=rs.getString("tc");
                        data[1]=rs.getString("isim");
                        data[2]=rs.getString("soyisim");
                        data[3]=rs.getString("infaz");
                        tablo.addRow(data);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Suclu Bulunamadi","Basarisiz",JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } 
        }
        });

        button2.setBounds(810, 250, 80, 20);
        button2.setForeground(Color.red);
        frame.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tc=Integer.parseInt(tf3.getText());
                infaz=tf4.getText();
                isim=tf5.getText();
                soyisim=tf6.getText();
                mysqls my=new mysqls();
                try {
                    my.ekleme(tc, isim, soyisim, infaz);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        button3.setBounds(810, 450, 80, 20);
        button3.setForeground(Color.red);
        frame.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            mysqls my=new mysqls();
            isim=tf9.getText();
            System.out.println(isim);
            try {
                my.silme(isim);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            }
        });
        
        button4.setBounds(80, 450, 80, 20);
        button4.setForeground(Color.red);
        frame.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                menu menu=new menu();
                JOptionPane.showMessageDialog(null,"Menuye Donuyorsunuz","Basarili",JOptionPane.NO_OPTION);
                try {
                    menu.frames();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.setVisible(false);
            }
        });

        label2.setFont(new Font("font",Font.ITALIC,20));
        label2.setBounds(600,30,300,30);
        label2.setForeground(Color.blue);
        frame.add(label2);

        label3.setFont(new Font("font",Font.ITALIC,20));
        label3.setBounds(700,100,300,30);
        frame.add(label3);

        label4.setFont(new Font("font",Font.ITALIC,20));
        label4.setBounds(650,100,300,30);
        frame.add(label4);

        label5.setFont(new Font("font",Font.ITALIC,20));
        label5.setBounds(650,300,300,30);
        frame.add(label5);

        tf.setBounds(230,30,135,30);
        tf.setForeground(Color.black);
        tf.setFont(new Font("font",Font.PLAIN,20));
        frame.add(tf);
        
        tf3.setBounds(600,150,100,30);
        tf3.setForeground(Color.black);
        tf3.setFont(new Font("font",Font.PLAIN,20));
        frame.add(tf3);

        tf4.setBounds(800,150,100,30);
        tf4.setForeground(Color.black);
        tf4.setFont(new Font("font",Font.PLAIN,20));
        frame.add(tf4);

        tf5.setBounds(600,200,100,30);
        tf5.setForeground(Color.black);
        tf5.setFont(new Font("font",Font.PLAIN,20));
        frame.add(tf5);

        tf6.setBounds(800,200,100,30);
        tf6.setForeground(Color.black);
        tf6.setFont(new Font("font",Font.PLAIN,20));
        frame.add(tf6);

        tf7.setBounds(600,350,100,30);
        tf7.setForeground(Color.black);
        tf7.setFont(new Font("font",Font.PLAIN,20));
        frame.add(tf7);

        tf9.setBounds(600,400,100,30);
        tf9.setForeground(Color.black);
        tf9.setFont(new Font("font",Font.PLAIN,20));
        frame.add(tf9);

        tf10.setBounds(800,400,100,30);
        tf10.setForeground(Color.black);
        tf10.setFont(new Font("font",Font.PLAIN,20));
        frame.add(tf10);

        label6.setFont(new Font("font",Font.ITALIC,20));
        label6.setBounds(550,150,100,30);
        frame.add(label6);

        label7.setFont(new Font("font",Font.ITALIC,20));
        label7.setBounds(720,150,100,30);
        frame.add(label7);

        label8.setFont(new Font("font",Font.ITALIC,20));
        label8.setBounds(550,200,100,30);
        frame.add(label8);

        label9.setFont(new Font("font",Font.ITALIC,20));
        label9.setBounds(720,200,100,30);
        frame.add(label9);

        label10.setFont(new Font("font",Font.ITALIC,20));
        label10.setBounds(550,350,100,30);
        frame.add(label10);

        label12.setFont(new Font("font",Font.ITALIC,20));
        label12.setBounds(550,400,100,30);
        frame.add(label12);

        label13.setFont(new Font("font",Font.ITALIC,20));
        label13.setBounds(720,400,100,30);
        frame.add(label13);

        tfx.setBounds(10,20,40,50);
        frame.add(tfx);
        tfx.setVisible(false);
        
        frame.setSize(960,540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
   


