import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
public class menu {

    File file=new File("gard.text");
    JLabel labelx=new JLabel();
    JLabel label=new JLabel("HAPISHANE UYGULAMASINA HOS GELDINIZ...");
    JLabel label2=new JLabel("NE YAPMAK ISTERSINIZ");
    JLabel label3=new JLabel("Suclu Sorgulama");
    JButton button1=new JButton();
    JLabel label6=new JLabel("Sifre Giriniz :");
    JPasswordField password=new JPasswordField();
    JMenuBar mb=new JMenuBar();
    JMenu menu=new JMenu("Sifre");
    JMenuItem item=new JMenuItem("***");
    JLabel label7=new JLabel("Gardiyan Adi :");
    JTextArea area=new JTextArea();
    JLabel label8=new JLabel("Gorev Suresi :");
    JTextArea area2=new JTextArea();
    JButton button4=new JButton("Dosyaya Kaydet");
    JLabel label4 =new JLabel("(Sayi giriniz)");

    String truepassword="akif";
    String currpassword;
    String GardIsim;
    int GardSaat;

    public void frames() throws IOException{
        JFrame frame=new JFrame("giris");
    
        label.setBounds(250,30,450,30);
        label.setFont(new Font("font",Font.ITALIC,20));
        frame.add(label);

        label2.setBounds(350,70,450,30);
        label2.setFont(new Font("font",Font.ITALIC,20));
        frame.add(label2);

        label3.setBounds(450,295,450,30);
        label3.setFont(new Font("font",Font.ITALIC,20));
        frame.add(label3);

        label4.setBounds(550,225,450,30);
        label4.setFont(new Font("font",Font.ITALIC,20));
        frame.add(label4);
        label4.setForeground(Color.red);

        button1.setBounds(620, 300, 20, 20);
        frame.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                currpassword=String.valueOf(password.getPassword());

                if(!truepassword.equals(currpassword)){
                   JOptionPane.showMessageDialog(null,"Hatali sifre","hata",JOptionPane.ERROR_MESSAGE);
                }
                if(truepassword.equals(currpassword)){
                    sorgu sorgu=new sorgu();
                    JOptionPane.showMessageDialog(null,"Giris basarili yonlendiriliyorsunuz", null,JOptionPane.INFORMATION_MESSAGE  );
                    try {
                        sorgu.frames();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    frame.setVisible(false);
                }
            }
        });

        label6.setBounds(150,300,450,30);
        label6.setFont(new Font("font",Font.ITALIC,20));
        frame.add(label6);

        password.setBounds(280,300,100,30);
        frame.add(password);
        password.setEchoChar('*');

        frame.add(menu);
        frame.setJMenuBar(mb);
        mb.add(menu);
        menu.add(item);

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"sifre :akif", null,JOptionPane.INFORMATION_MESSAGE  );
            }
        });

        label7.setBounds(100, 200, 450, 30);
        label7.setFont(new Font("font",Font.ITALIC,20));
        frame.add(label7);

        label8.setBounds(400, 200, 450, 30);
        label8.setFont(new Font("font",Font.ITALIC,20));
        frame.add(label8);
        
        area.setBounds(250, 205, 100, 20);
        frame.add(area);

        area2.setBounds(550, 205, 100, 20);
        frame.add(area2);

        if(!file.exists()){
            file.createNewFile();
        }

        button4.setBounds(700, 205, 150, 20);
        frame.add(button4);
        button4.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e){
                try (FileWriter fl = new FileWriter(file)) {
                    GardIsim=area.getText();
                    GardSaat=Integer.parseInt(area2.getText());
                    fl.write("Gardiyan isim :"+GardIsim+"\t"+"Gorev Suresi:"+GardSaat+"dakika");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        labelx.setBounds(250, 35, 450, 30);
        labelx.setFont(new Font("font",Font.ITALIC,20));
        labelx.setVisible(false);
        frame.add(labelx);
        
        frame.setSize(960,540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
