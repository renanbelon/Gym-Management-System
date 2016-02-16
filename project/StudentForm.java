import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class StudentForm extends JPanel implements ActionListener
{
    int tWidth =320;
    int height= 25;
    JLabel id,photo,status, title, address,
    town, country, postcode,email,phone,
    mobile,nok,obs,branch,gender,dob, belt,categories,joinL,fsNameL;
    
    JTextField idt,statust, titlet, fNamet,lNamet,adresst,
    townt,countryt,postcodet,emailt,phonet,
    mobilet,nokNameT,nokRelationT,nokPhoneT,genderT,dobT,beltT,
    joinT,fsNameT;
    
    JComboBox categoriesT,brancht;
    
    JTextArea obst;
    JScrollPane scroll;
    
    JButton previousB,nextB,findStudentB,deleteB,updateB,
    saveB,cancelB,insertPhotoB,findB,selectB,goBackB;
    
    JFileChooser fileChooser;
    File file;
    FileInputStream sPhoto;
    int returnVal;
    JPanel container1;
    CardLayout card1;
    JTable table;
    JScrollPane tableScroll;
    
    public StudentForm(){
        createGUI();
        
    }
    public StudentForm(JPanel container, CardLayout card)
    {
        this.container1 = container;
        this.card1 = card;
        createGUI();
    }
    public void createGUI(){
           setSize(850,410);
        setLocation(20,70);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        id = new JLabel("ID");
        id.setSize(20,height);
        id.setLocation(20,10);
        add(id);
        
        idt = new JTextField();
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
        
        status = new JLabel("Status");
        status.setSize(40,height);
        status.setLocation(55,235);
        add(status);
        
        statust = new JTextField("   Active");
        statust.setSize(55,height);
        statust.setLocation(48,259);
        statust.setBackground(Color.green);
        add(statust);
        
        title = new JLabel("Title");
        title.setSize(25,height);
        title.setLocation(200,37);
        add(title);
    
        titlet= new JTextField();
        titlet.setSize(50,height);
        titlet.setLocation(227,37);
        add(titlet);
        
        fNamet= new JTextField("  First Name");
        fNamet.setSize(132,height);
        fNamet.setLocation(280,37);
        add(fNamet);
        
        lNamet= new JTextField("  Last Name");
        lNamet.setSize(132,height);
        lNamet.setLocation(415,37);
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
        
        nokNameT = new JTextField("  Name");
        nokNameT.setSize(100,height);
        nokNameT.setLocation(226,233);
        add(nokNameT);
        
        nokRelationT = new JTextField("  Relation");
        nokRelationT.setSize(100,height);
        nokRelationT.setLocation(329,233);
        add(nokRelationT);
        
        nokPhoneT = new JTextField(" Phone");
        nokPhoneT.setSize(115,height);
        nokPhoneT.setLocation(432,233);
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
        
        dobT = new JTextField("  YYYY/MM/DD");
        dobT.setSize(133,height);
        dobT.setLocation(644,93);
        add(dobT);
        
        belt = new JLabel("Belt");
        belt.setSize(26,height);
        belt.setLocation(618,121);
        add(belt);
        
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
        
        previousB = new JButton("Previous");
        previousB.setSize(90,height);
        previousB.setLocation(227,341);
        previousB.addActionListener(this);
        add(previousB);
        
        nextB = new JButton("Next");
        nextB.setSize(90,height);
        nextB.setLocation(320,341);
        nextB.addActionListener(this);
        add(nextB);
                      
        findStudentB = new JButton("Find Student");
        findStudentB.setSize(133,height);
        findStudentB.setLocation(644,177);
        findStudentB.addActionListener(this);
        add(findStudentB);
        
        deleteB = new JButton("Delete");
        deleteB.setSize(133,height);
        deleteB.setLocation(644,205);
        deleteB.addActionListener(this);
        add(deleteB);
        
        updateB =new JButton("Update");
        updateB.setSize(133,height);
        updateB.setLocation(644,233);
        updateB.addActionListener(this);
        add(updateB);
        
        saveB = new JButton("Save");
        saveB.setSize(90,height);
        saveB.setLocation(227,341);
        saveB.addActionListener(this);
        add(saveB);
        saveB.setVisible(false);
        
        cancelB = new JButton("Cancel");
        cancelB.setSize(90,height);
        cancelB.setLocation(320,341);
        cancelB.addActionListener(this);
        add(cancelB);
        cancelB.setVisible(false);
                
        fileChooser = new JFileChooser(); 
        insertPhotoB = new JButton("Insert Photo");
        insertPhotoB.setSize(110,height);
        insertPhotoB.setLocation(20,240);
        insertPhotoB.addActionListener(this);
        add(insertPhotoB);
        insertPhotoB.setVisible(false);
        
        fsNameL = new JLabel("Last Name");
        fsNameL.setBounds(550,10,120,25);
        add(fsNameL);
        fsNameL.setVisible(false);
        
        fsNameT= new JTextField();
        fsNameT.setBounds(623,10,133,height);
        add(fsNameT);
        fsNameT.setVisible(false);
        
        findB = new JButton("Find");
        findB.setBounds(758,10,80,25);
        findB.addActionListener(this);
        add(findB);
        findB.setVisible(false);
                
        table = new JTable();
        tableScroll = new JScrollPane(table);
        tableScroll.setBounds(550,37,400,150);
        add(tableScroll);
        tableScroll.setVisible(false);
        
        selectB = new JButton("Select");
        selectB.setBounds(550,190,80,25);
        selectB.addActionListener(this);
        add(selectB);
        selectB.setVisible(false);
        
        goBackB = new JButton("Back");
        goBackB.setBounds(633,190,80,25);
        goBackB.addActionListener(this);
        add(goBackB);
        goBackB.setVisible(false);
        
        
        
        
        disableTFields();
        //setVisible(true);
    
    }
    Queries queries = new Queries();
    ArrayList<Student> studentList = null;   
    int counter = 0;
 
    int recordsNum;
    Image image;
    
    boolean tf;
    //GetStudents getStdnt = new GetStudents();
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==nextB){
            try{
                queries.connect();
                studentList=queries.getStudents();
                recordsNum =studentList.size() ;
                if(counter >= recordsNum-1){
                    counter = 0;
                }
                else{
                    counter++;
                }
                updateForm(); 
                queries.disconnect();
               }
            catch(Exception sqle){
                System.out.println(sqle);
            }
            
        }
        else if(e.getSource() ==previousB){
          
            try{
                queries.connect();
                studentList=queries.getStudents();
                recordsNum =studentList.size() ;
                counter--;
                if(counter <0){
                    counter = recordsNum-1;
                }
                updateForm();
                
                queries.disconnect();
                
               }
            catch(Exception sqle){
                System.out.println(sqle);
            }
        }
        else if(e.getSource()==deleteB){
             int response = JOptionPane.showConfirmDialog(null,"Do you Really want to delete this record?","Delete Confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
             if(response == JOptionPane.NO_OPTION){
             }
             else if (response == JOptionPane.YES_OPTION){
                int studentID = Integer.parseInt(idt.getText());
                System.out.println("aaaa");
                try{
                    queries.connect();
                    queries.deleteStudentByID(studentID);
                    counter--;
                    if(counter <0){
                        counter = recordsNum-1;
                    }
                    updateForm();
                    queries.disconnect();
                }
                catch(Exception sqle){
                 System.out.println("Deleting error: "+sqle);
                }
                
                }
                
                else if (response == JOptionPane.CLOSED_OPTION){
                }
            
            }
        
        else if(e.getSource()==updateB)
         {
            hideButtons();
            saveB.setVisible(true);
            cancelB.setVisible(true);
            //insertPhotoB.setVisible(true);
            enableTFields();
         }
        
        else if(e.getSource()==saveB){
            int bNo = brancht.getSelectedIndex();
            bNo +=1;
            int catID =categoriesT.getSelectedIndex();
            int sID= Integer.parseInt(idt.getText());
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
            else{
                 try{
                    queries.connect();
                    queries.updateStudent(bNo,catID,titlet.getText(),fNamet.getText(),lNamet.getText(),
                    dobT.getText(),genderT.getText(),adresst.getText(),postcodet.getText(),townt.getText(),countryt.getText(),
                    emailt.getText(),phonet.getText(),mobilet.getText(),joinT.getText(),beltT.getText(),nokNameT.getText(),
                    nokRelationT.getText(),nokPhoneT.getText(),obst.getText(),sID);
                    queries.disconnect();
                    
                    saveB.setVisible(false);
                    cancelB.setVisible(false);
                    insertPhotoB.setVisible(false);
                    showButtons();
                    updateForm();
                    disableTFields();
                }
                catch(Exception ex){
                System.out.println(ex); 
                }
            }
         }
         
         else if(e.getSource()==cancelB){
                saveB.setVisible(false);
                cancelB.setVisible(false);
                insertPhotoB.setVisible(false);
                showButtons();
                updateForm();
                disableTFields();
            
         }
        else if(e.getSource()==findStudentB){
            
             //card1.show(container1,"card5");
             tf = false;
             hide(tf);
             hideButtons();
             fsNameT.setVisible(true);
             fsNameL.setVisible(true);
             findB.setVisible(true);
             tableScroll.setVisible(true);
             selectB.setVisible(true);
             goBackB.setVisible(true);
             
             String empity = "";
             queries.connect();
             queries.searchStudent(empity,table);
             queries.disconnect();
        }
         else if(e.getSource()==goBackB){
             tf = true;
             hide(tf);
             showButtons();
             fsNameT.setVisible(false);
             fsNameL.setVisible(false);
             findB.setVisible(false);
             tableScroll.setVisible(false);
             selectB.setVisible(false);
             goBackB.setVisible(false);
         }
        else if(e.getSource()==findB){
            String lastname ="%";
            lastname += fsNameT.getText();
            queries.connect();
            queries.searchStudent(lastname,table);
            queries.disconnect();
            
             
         }
        
         else if(e.getSource()==selectB){
            int getStudentIDInt =(Integer)table.getValueAt(table.getSelectedRow(),0);
            setStudentsByID(getStudentIDInt);
            
         }
    }
    
    public void hide(boolean tf){
        tf = tf;
        brancht.setVisible(tf);
        genderT.setVisible(tf);
        dobT.setVisible(tf);
        beltT.setVisible(tf);
        categoriesT.setVisible(tf);
        joinT.setVisible(tf);
        branch.setVisible(tf);
        gender.setVisible(tf);
        dob.setVisible(tf);
        belt.setVisible(tf);
        categories.setVisible(tf);
        joinL.setVisible(tf);
    }
    
    
    public void disableTFields(){
    statust.setEditable(false);
    titlet.setEditable(false);
    fNamet.setEditable(false);
    lNamet.setEditable(false);
    adresst.setEditable(false);
    townt.setEditable(false);
    countryt.setEditable(false);
    postcodet.setEditable(false);
    emailt.setEditable(false);
    phonet.setEditable(false);
    mobilet.setEditable(false);
    nokNameT.setEditable(false);
    nokRelationT.setEditable(false);
    nokPhoneT.setEditable(false);
    brancht.setEditable(false);
    genderT.setEditable(false);
    dobT.setEditable(false);
    beltT.setEditable(false);
    categoriesT.setEditable(false);
    joinT.setEditable(false);
    obst.setEditable(false);
    
    }
    
    public void enableTFields(){
     statust.setEditable(true);
    titlet.setEditable(true);
    fNamet.setEditable(true);
    lNamet.setEditable(true);
    adresst.setEditable(true);
    townt.setEditable(true);
    countryt.setEditable(true);
    postcodet.setEditable(true);
    emailt.setEditable(true);
    phonet.setEditable(true);
    mobilet.setEditable(true);
    nokNameT.setEditable(true);
    nokRelationT.setEditable(true);
    nokPhoneT.setEditable(true);
    brancht.setEditable(true);
    genderT.setEditable(true);
    dobT.setEditable(true);
    beltT.setEditable(true);
    categoriesT.setEditable(true);
    joinT.setEditable(true);
    obst.setEditable(true);
    
    }
    
    public void hideButtons(){
   
    previousB.setVisible(false);
    nextB.setVisible(false);
    findStudentB.setVisible(false);
    deleteB.setVisible(false);
    updateB.setVisible(false);
    statust.setVisible(false);
    status.setVisible(false);
    }
    
    public void showButtons(){
  
    previousB.setVisible(true);
    nextB.setVisible(true);
    findStudentB.setVisible(true);
    deleteB.setVisible(true);
    updateB.setVisible(true);
    statust.setVisible(true);
    status.setVisible(true);
    }
    String getBranchNO = null;
    String getCatNO = null;
    public void updateForm(){
          try{
          queries.connect();
          studentList=queries.getStudents();
          Student stdnt = studentList.get(counter);
          idt.setText(""+stdnt.getSID());
          titlet.setText(stdnt.getSTitle());
          fNamet.setText(stdnt.getSFName());
          lNamet.setText(stdnt.getSSName());
          adresst.setText(stdnt.getSFLAdress());
          townt.setText(stdnt.getSTown());
          countryt.setText(stdnt.getSCountry());
          postcodet.setText(stdnt.getSPostcode());
          emailt.setText(stdnt.getSEmail());
          phonet.setText(stdnt.getSTelephone());
          mobilet.setText(stdnt.getSMobile());
          nokNameT.setText(stdnt.getSNOKName());
          nokRelationT.setText(stdnt.getSNOKRelation());
          nokPhoneT.setText(stdnt.getSNOKTelephone());
          obst.setText(stdnt.getSObservation());
          //ComboBoxes
          getBranchNO = stdnt.getBNo();
          brancht.setSelectedItem(getBranchNO);
          getCatNO = stdnt.getCNo();
          categoriesT.setSelectedItem(getCatNO);
          
          
          genderT.setText(stdnt.getSGender());
          dobT.setText(stdnt.getSDOB());
          beltT.setText(stdnt.getSBelt());
          joinT.setText(stdnt.getSEnrolDate());
          //convert value from textfield to integer
          int studentID = Integer.parseInt(idt.getText());
          //gets current student photo.
          image = queries.getImageByID(studentID);
          photo.setIcon(new ImageIcon(image));
                
          }
          catch(Exception ex){
          System.out.println("1"+ex);
            }
    
    }
    int ssid;
   public void setStudentsByID(int ssid){
            this.ssid = ssid;
            queries.connect();
            studentList = queries.getStdntByID(ssid);
            Student stdnt = studentList.get(0);         
            //stdntForm = new StudentForm();
       
            idt.setText(""+stdnt.getSID());
            titlet.setText(stdnt.getSTitle());
            fNamet.setText(stdnt.getSFName());
            lNamet.setText(stdnt.getSSName());
            adresst.setText(stdnt.getSFLAdress());
            townt.setText(stdnt.getSTown());
            countryt.setText(stdnt.getSCountry());
            postcodet.setText(stdnt.getSPostcode());
            emailt.setText(stdnt.getSEmail());
            phonet.setText(stdnt.getSTelephone());
            mobilet.setText(stdnt.getSMobile());
            nokNameT.setText(stdnt.getSNOKName());
            nokRelationT.setText(stdnt.getSNOKRelation());
            nokPhoneT.setText(stdnt.getSNOKTelephone());
            obst.setText(stdnt.getSObservation());
             //ComboBoxes
            getBranchNO = stdnt.getBNo();
            brancht.setSelectedItem(getBranchNO);
            getCatNO = stdnt.getCNo();
            categoriesT.setSelectedItem(getCatNO);
                        
            genderT.setText(stdnt.getSGender());
            dobT.setText(stdnt.getSDOB());
            beltT.setText(stdnt.getSBelt());
            joinT.setText(stdnt.getSEnrolDate());
             //gets current student photo.
            Image image;
            int studentID = Integer.parseInt(idt.getText());
            image = queries.getImageByID(studentID);
            photo.setIcon(new ImageIcon(image));
            queries.disconnect();
            
    
    
    }
  
}
