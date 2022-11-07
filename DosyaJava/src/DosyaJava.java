
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DosyaJava implements ActionListener{
   
    JFrame window=new JFrame("Giris Formu");
    JTextField nameSurname=new JTextField();
    JTextField bolum =new JTextField();
    JTextField userName=new JTextField();
    JPasswordField password=new JPasswordField();
    JLabel nameLabel=new JLabel("Ad Soyad: ");
    JLabel bolumLabel=new JLabel("Bolum: ");
    JLabel userNameLabel=new JLabel("Kullanici Adi");
    JLabel passwordLabel=new JLabel("Sifre");
    JButton signUpButton=new JButton("Giris Yap");
    JLabel blank=new JLabel();
    FileWriter fileWriter;
    
    public DosyaJava()
    {
     //tanımlanan butonları frame ekleme ve konum belirleme
       
        signUpButton.addActionListener(this);
        
        window.add(userNameLabel);
        userNameLabel.setBounds(50, 150, 100, 30);
        window.add(userName);
        userName.setBounds(150, 150, 150, 30);
      
        
        window.add(nameLabel);
        nameLabel.setBounds(50, 280, 100, 30);
        window.add(nameSurname);
        nameSurname.setBounds(150, 280, 150, 30);
        
        window.add(bolumLabel);
        bolumLabel.setBounds(50, 310, 100, 30);
        window.add(bolum);
        bolum.setBounds(150, 310, 150, 30);
       
        window.add(signUpButton);
        signUpButton.setBounds(50, 500, 100, 30);
        
        window.add(passwordLabel);
        passwordLabel.setBounds(50, 220, 100, 30);
        window.add(password);
        password.setBounds(150, 220, 150, 30);
        
        window.add(blank);
     
        window.setSize(500,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);

    }

    public static void main(String[] args) {
       new DosyaJava();
      
    
    }
    File file=new File("dosya.txt");

    @Override
    public void actionPerformed(ActionEvent e) {
        //kullanıcıdan alınan verileri yazdırma
         if (e.getActionCommand()==signUpButton.getActionCommand())
        {
            try{
                fileWriter =new FileWriter("C:\\Users\\Aybala\\Desktop/dosya.txt");
                fileWriter.write("\n"+userNameLabel.getText()+":"+userName.getText()+" ");
                fileWriter.write(passwordLabel.getText()+":"+password.getText()+" ");
                fileWriter.write(nameLabel.getText()+":"+nameSurname.getText()+" ");
                fileWriter.write(bolumLabel.getText()+":"+bolum.getText()+"");
             
                fileWriter.close();
                
            }catch (Exception ev)
            {
                System.out.println("hata");


            }
            
          //Liste tanımlayıp dosyadakileri listeleme işlemi  
       ArrayList<String>listOfStrings;
       listOfStrings =new ArrayList();
       
         try {
        // list that holds strings of a file
       
       
        // load data from file
        BufferedReader bf = new BufferedReader(
            new FileReader("C:\\Users\\Aybala\\Desktop/dosya.txt"));
       
        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
       
        // closing bufferreader object
        bf.close();
       
        // storing the data in arraylist to array
        String[] array
            = listOfStrings.toArray(new String[0]);
       
        // printing each line of file
        // which is stored in array
        for (String str : array) {
            System.out.println(str);
        }
    }catch(Exception ev){
             System.out.println("hata");
    }
            
        }
         
         
    }
}
