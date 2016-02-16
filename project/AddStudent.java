import org.jfree.ui.ExtensionFileFilter; 
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AddStudent extends JPanel implements ActionListener,FocusListener
{
    JFileChooser fileChooser;
    File file;
    FileInputStream sPhoto;
    int returnVal;
    int tWidth =320;
    int height= 25;
    
    
    
    
    JLabel id,photo, title, address,
    town, country, postcode,email,phone,
    mobile,nok,obs,branch,gender,dob, beltL,
    categories,joinL,informationL;
    
    JTextField idt,titlet, fNamet,lNamet,adresst,
    townt,countryt,postcodet,emailt,phonet,
    mobilet,nokNameT,nokRelationT,
    nokPhoneT,genderT,dobT,beltT,joinT;
    
    JTextArea obst;
    JScrollPane scroll;
    JComboBox categoriesT,brancht;
    JButton saveB,backB,insertPhotoB;
    
    Queries queries = new Queries();

    public AddStudent()
    { 
        
        setSize(850,420);
        setLocation(20,70);
        setLayout(null);
        //setBackground(Color.BLUE);
        
        informationL = new JLabel(/*"<html>Text color: <font color='red'>red</font></html>"*/);
        informationL.setBounds(20,395,800,25);
        informationL.setForeground(Color.RED);
        informationL.setFont( new Font("Arial", Font.BOLD, 18) );
        add(informationL);
               
        id = new JLabel("ID");
        add(id);
        id.setSize(20,height);
        id.setLocation(20,10);
    
        idt = new JTextField("New");
        idt.setSize(70,height);
        idt.setLocation(42,10);
        idt.setEditable(false);
        add(idt);
    
        photo = new JLabel();
        photo.setSize(150,200);
        photo.setLocation(5,37);
        photo.setIcon(new ImageIcon("C:\\Users\\renan belon\\Documents\\java\\no-image.png"));
    
        add(photo);
        validate();
        
        title = new JLabel("Title");
        title.setSize(25,height);
        title.setLocation(200,37);
        add(title);
    
        titlet= new JTextField();
        titlet.setSize(50,height);
        titlet.setLocation(227,37);
        add(titlet);
        
        fNamet= new JTextField();
        fNamet.setSize(132,height);
        fNamet.setLocation(280,37);
        fNamet.addFocusListener(this);
        add(fNamet);
        
        lNamet= new JTextField();
        lNamet.setSize(132,height);
        lNamet.setLocation(415,37);
        lNamet.addFocusListener(this);
        add(lNamet);
        
        address = new JLabel("Adress");
        address.setSize(43,height);
        address.setLocation(184,65);
        add(address);
        
        adresst = new JTextField();
        adresst.setSize(tWidth,height);
        adresst.setLocation(227,65);
        add(adresst);
        
        town = new JLabel("Town");
        town.setSize(32,height);
        town.setLocation(193,93);
        add(town);
        
        townt = new JTextField();
        townt.setSize(tWidth,height);
        townt.setLocation(227,93);
        add(townt);
        
        country = new JLabel("Country");
        country.setSize(44,height);
        country.setLocation(180,121);
        add(country);
    
        countryt = new JTextField();
        countryt.setSize(tWidth,height);   
        countryt.setLocation(227,121);
        add(countryt);
     
        postcode = new JLabel("Post Code");
        postcode.setSize(58,height);
        postcode.setLocation(164,149);
        add(postcode);
        
        postcodet= new JTextField();
        postcodet.setSize(tWidth,height);
        postcodet.setLocation(227,149);
        add(postcodet);
    
        email = new JLabel("Email");
        email.setSize(31,height);
        email.setLocation(190,177);
        add(email);
        
        emailt= new JTextField();
        emailt.setSize(tWidth,height);
        emailt.setLocation(227,177);
        add(emailt);
        
        phone  = new JLabel("Phone");
        phone.setSize(36,height);
        phone.setLocation(187,205);
        add(phone);
    
        phonet = new JTextField();
        phonet.setSize(138,height);
        phonet.setLocation(227,205);
        add(phonet);
        
        mobile = new JLabel("Mobile");
        mobile.setSize(37,height);
        mobile.setLocation(368,205);
        add(mobile);
        
        mobilet = new JTextField();
        mobilet.setSize(139,height);
        mobilet.setLocation(408,205);
        add(mobilet);
        
        nok  = new JLabel("Next of kin");
        nok.setSize(60,height);
        nok.setLocation(163,233);
        add(nok);
        
        nokNameT = new JTextField();
        nokNameT.setSize(100,height);
        nokNameT.setLocation(226,233);
        nokNameT.addFocusListener(this);
        add(nokNameT);
        
        nokRelationT = new JTextField();
        nokRelationT.setSize(100,height);
        nokRelationT.setLocation(329,233);
        nokRelationT.addFocusListener(this);
        add(nokRelationT);
        
        nokPhoneT = new JTextField();
        nokPhoneT.setSize(115,height);
        nokPhoneT.setLocation(432,233);
        nokPhoneT.addFocusListener(this);
        add(nokPhoneT);
        
        obs  = new JLabel("Obs");
        obs.setSize(25,height);
        obs.setLocation(198,261);
        add(obs);
        
        //Text area with the scroll bar
        obst = new JTextArea();
        obst.setSize(tWidth,75);
        obst.setLocation(226,261);
        
        scroll= new JScrollPane(obst);
        scroll.setSize(320,75);
        scroll.setLocation(226,261);
        
        obst.setLineWrap(true);
        obst.setWrapStyleWord(true);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll);
        //*****************************************
        categories =new JLabel("Category");
        categories.setBounds(590,10,80,25);
        add(categories);
        
        categoriesT = new JComboBox();
        categoriesT.setBounds(644,10,133,height);
        add(categoriesT);
        
        branch = new JLabel("Branch");
        branch.setSize(41,height);
        branch.setLocation(600,37);
        add(branch);
        
        brancht = new JComboBox();
        brancht.setSize(133,height);
        brancht.setLocation(644,37);
        add(brancht);
        
        gender= new JLabel("Gender");
        gender.setSize(41,height);
        gender.setLocation(600,65);
        add(gender);
        
        genderT = new JTextField();
        genderT.setSize(133,height);
        genderT.setLocation(644,65);
        add(genderT);
        
        dob = new JLabel("DOB");
        dob.setSize(25,height);
        dob.setLocation(616,93);
        add(dob);
        
        dobT = new JTextField("YYYY/MM/DD");
        dobT.setSize(133,height);
        dobT.setLocation(644,93);
        add(dobT);
        
        beltL = new JLabel("Belt");
        beltL.setSize(46,height);
        beltL.setLocation(618,121);
        add(beltL);
        
        beltT = new JTextField();
        beltT.setSize(133,height);
        beltT.setLocation(644,121);
        add(beltT);
        
        joinL = new JLabel("Join Date");
        joinL.setBounds(588,149,133,height);
        add(joinL);
        
        joinT = new JTextField();
        joinT.setBounds(644,149,133,height);
        add(joinT);
        
        
        saveB = new JButton("Save");
        saveB.setSize(90,height);
        saveB.setLocation(227,341);
        saveB.addActionListener(this);
        add(saveB);
        
//         backB = new JButton("Back");
//         backB.setSize(90,height);
//         backB.setLocation(319,341);
//         backB.setVisible(true);
//         //backB.addActionListener(this);
//         add(backB);
       
        fileChooser = new JFileChooser(); 
        FileFilter filter1 = new ExtensionFileFilter("JPG and JPEG","jpg");
        fileChooser.setFileFilter(filter1);
        insertPhotoB = new JButton("Insert Photo");
        insertPhotoB.setSize(110,height);
        insertPhotoB.setLocation(20,240);
        insertPhotoB.addActionListener(this);
        add(insertPhotoB);
    }
    public void clear(){
        titlet.setText("");
        fNamet.setText("");
        lNamet.setText("");
        adresst.setText("");
        townt.setText("");
        countryt.setText("");
        postcodet.setText("");
        emailt.setText("");
        phonet.setText("");
        mobilet.setText("");
        nokNameT.setText("");
        nokRelationT.setText("");
        nokPhoneT.setText("");
        genderT.setText("");
        dobT.setText("");
        beltT.setText("");
        joinT.setText("");
        obst.setText("");
        photo.setIcon(new ImageIcon("C:\\Users\\renan belon\\Documents\\java\\no-image.png"));
        file =null;
    }
        String getFileSize = null;
        int fileSize = 0;
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==insertPhotoB)
        {   
            // opens the filechooser
            returnVal = fileChooser.showOpenDialog(null);
            // if someone choose a file
            if(returnVal == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            getFileSize = ""+file.length();
            fileSize = Integer.parseInt(getFileSize);
            try{
            sPhoto= new FileInputStream(file);
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),
                    "FileInputSteam error",JOptionPane.WARNING_MESSAGE); 
            }
            photo.setIcon(new ImageIcon(""+file));
            }
    
        }
    
        else if (e.getSource()==saveB){
            String title = titlet.getText();
            String fname = fNamet.getText();
            String sname = lNamet.getText();
            String address = adresst.getText();
            String town = townt.getText();
            String country = countryt.getText();
            String postcode = postcodet.getText();
            String pohone = phonet.getText();
            String mobile = mobilet.getText();
            String nokname = nokNameT.getText();
            String nokrelation = nokRelationT.getText();
            String nokphone = nokPhoneT.getText();
            String  gender = genderT.getText();
            String dob = dobT.getText();
            String join =joinT.getText();
            
            if(title.trim().equals("")||fname.trim().equals("")||sname.trim().equals("")||address.trim().equals("")||town.trim().equals("")||country.trim().equals("")||
            postcode.trim().equals("")||pohone.trim().equals("")||mobile.trim().equals("")||nokname.trim().equals("")||nokrelation.trim().equals("")||nokphone.trim().equals("")
            ||gender.trim().equals("")||dob.trim().equals("")||join.trim().equals(""))
            {
                JOptionPane.showMessageDialog(this,"Please fill all textboxes","Validation Warning",JOptionPane.WARNING_MESSAGE);
                 
            }
            else if(fileSize>= 16777000){
                JOptionPane.showMessageDialog(this,"Image is too big!/nImage size must no be bigger than 15MB","Image Error",JOptionPane.ERROR_MESSAGE);
            
            }
            else{
                   //gets selected value text
                   //String value=categoriesT.getSelectedItem().toString();
                   //get selectedvalue index
                   int catID=categoriesT.getSelectedIndex();
                   int bNo = brancht.getSelectedIndex();
                   bNo +=1;
                   queries.connect();
                   queries.insertStudents(bNo,catID,sPhoto,titlet.getText(),fNamet.getText(),lNamet.getText(),
                   dobT.getText(),genderT.getText(),adresst.getText(),postcodet.getText(),townt.getText(),countryt.getText(),
                   emailt.getText(),phonet.getText(),mobilet.getText(),joinT.getText(),beltT.getText(),nokNameT.getText(),
                   nokRelationT.getText(),nokPhoneT.getText(),obst.getText());
                   queries.disconnect();
                   clear();
            }
        }
    }
    
    @Override 
    public void focusLost(FocusEvent e){
        if(e.getSource()==fNamet){
            informationL.setText("");
        }
        
        if(e.getSource()==lNamet){
            informationL.setText("");
        }
        
        if(e.getSource()==nokNameT){
            informationL.setText("");
        }
        
        if(e.getSource()==nokRelationT){
            informationL.setText("");
        }
        
        if(e.getSource()== nokPhoneT){
            informationL.setText("");
        }
    }
    
    @Override 
    public void focusGained(FocusEvent e){
        if(e.getSource()==fNamet){
            informationL.setText("Enter student first name");
                   
        }
        
        if(e.getSource()==lNamet){
            informationL.setText("Enter student last name");
        }
        
        if(e.getSource()==nokNameT){
            informationL.setText("Enter next of kin's name");
        }
        
        if(e.getSource()==nokRelationT){
             informationL.setText("Enter next of kin relation to Student");
        }
        
        if(e.getSource()== nokPhoneT){
             informationL.setText("Enter next of kin's contact number");
        }
    
        
    
    }
}

