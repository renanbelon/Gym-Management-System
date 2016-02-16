import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class StaffForm extends JPanel implements ActionListener
{
int tWidth =320;
int height= 25;



JLabel id,photo, title, address,
town, country, postcode,email,phone,
mobile,nok,obs,branch,gender,dob, positionL,startDateL;

JTextField idt,titlet, fNamet,lNamet,adresst,
townt,countryt,postcodet,emailt,phonet,
mobilet,nokNameT,nokRelationT,nokPhoneT,genderT,dobT,positionT,startDateT;

JComboBox brancht;
JTextArea obst;
JScrollPane scroll;

JButton emailB,previousB,nextB,
deleteB,updateB,cancelB,saveB;

Boolean tF;
String getBranchNO = "";

   
    public StaffForm()
    {
        setSize(850,420);
        setLocation(20,70);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    
        id = new JLabel("ID");
        add(id);
        id.setSize(20,height);
        id.setLocation(20,10);
    
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
        
        positionL = new JLabel("Position");
        positionL.setSize(46,height);
        positionL.setLocation(595,121);
        add(positionL);
        
        positionT = new JTextField();
        positionT.setSize(133,height);
        positionT.setLocation(644,121);
        add(positionT); 
        
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
        
        startDateL = new JLabel("Start-date");
        startDateL.setSize(100,height);
        startDateL.setLocation(584,149);
        add(startDateL);
        
        startDateT = new JTextField();
        startDateT.setSize(133,height);
        startDateT.setLocation(644,149);
        add(startDateT);
        
        deleteB = new JButton("Delete");
        deleteB.setSize(133,height);
        deleteB.setLocation(644,177);
        deleteB.addActionListener(this);
        add(deleteB);
        
        updateB =new JButton("Update");
        updateB.setSize(133,height);
        updateB.setLocation(644,205);
        updateB.addActionListener(this);
        add(updateB);
        tF=false;
        changeFields(tF);
        
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
           
    }
    Queries queries = new Queries();
    ArrayList<Staff> staffList = null;   
    int counter = 0;
    int recordsNum;
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == previousB)
        {
            try{
                queries.connect();
                staffList=queries.getStaffs();
                recordsNum =staffList.size() ;
                counter--;
                if(counter <0){
                    counter = recordsNum-1;
                }
                
                updateStaffs();
                queries.disconnect();
               }
            catch(Exception sqle){
                System.out.println(sqle);
            }
        }
        else if(e.getSource()==nextB){
            try{
                queries.connect();
                staffList=queries.getStaffs();
                recordsNum =staffList.size() ;
                if(counter >= recordsNum-1){
                    counter = 0;
                }
                else{
                    counter++;
                }
                
                updateStaffs();
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
                int staffID = Integer.parseInt(idt.getText());
             
                try{
                    queries.connect();
                    queries.deleteStaffByID(staffID);
                    counter--;
                    if(counter <0){
                        counter = recordsNum-1;
                    }
                    updateStaffs();
                    queries.disconnect();
                }
                catch(Exception sqle){
                 System.out.println("Deleting error: "+sqle);
                }
                
                }
        
        }
        else if(e.getSource()==updateB){
             saveB.setVisible(true);
             cancelB.setVisible(true);
             tF= false;
             onAndOffButtons(tF);
             tF= true;
             changeFields(tF);
             
        }
        else if(e.getSource()==cancelB){
             saveB.setVisible(false);
             cancelB.setVisible(false);
             tF= true;
             onAndOffButtons(tF);
             tF= false;
             changeFields(tF);
             updateStaffs();
        }
        else if(e.getSource()==saveB){
            
            
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
            String stdDate =startDateT.getText();
            if(title.trim().equals("")||fname.trim().equals("")||sname.trim().equals("")||address.trim().equals("")||town.trim().equals("")||country.trim().equals("")||
            postcode.trim().equals("")||pohone.trim().equals("")||mobile.trim().equals("")||nokname.trim().equals("")||nokrelation.trim().equals("")||nokphone.trim().equals("")
            ||gender.trim().equals("")||dob.trim().equals("")||stdDate.trim().equals("")){
                     JOptionPane.showMessageDialog(this,"Please fill all textboxes","Validation Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                int bNO = brancht.getSelectedIndex();
                bNO +=1;
                queries.connect();
                queries.editStaff(bNO,titlet.getText(),fNamet.getText(),lNamet.getText(),
                dobT.getText(),genderT.getText(),adresst.getText(),postcodet.getText(),townt.getText(),countryt.getText(),
                emailt.getText(),phonet.getText(),mobilet.getText(),positionT.getText(),startDateT.getText(),nokNameT.getText(),
                nokRelationT.getText(),nokPhoneT.getText(),obst.getText(),sID);
                queries.disconnect();
                
                 saveB.setVisible(false);
                 cancelB.setVisible(false);
                 tF= true;
                 onAndOffButtons(tF);
                 tF= false;
                 changeFields(tF);
                 updateStaffs();
            }
        }
    }
        public void updateStaffs(){
        try{
            queries.connect();
            staffList=queries.getStaffs();
            Staff staff = staffList.get(counter);
            idt.setText(""+staff.getSID());
            titlet.setText(staff.getSTitle());
            fNamet.setText(staff.getSFName());
            lNamet.setText(staff.getSSName());
            adresst.setText(staff.getSFLAdress());
            townt.setText(staff.getSTown());
            countryt.setText(staff.getSCountry());
            postcodet.setText(staff.getSPostcode());
            emailt.setText(staff.getSEmail());
            phonet.setText(staff.getSTelephone());
            mobilet.setText(staff.getSMobile());
            positionT.setText(staff.getSPosition());
            nokNameT.setText(staff.getSNOKName());
            nokRelationT.setText(staff.getSNOKRelation());
            nokPhoneT.setText(staff.getSNOKTelephone());
            obst.setText(staff.getSObservation());
            
            getBranchNO = staff.getBNo();
            brancht.setSelectedItem(getBranchNO);
            genderT.setText(staff.getSGender());
            dobT.setText(staff.getSDOB());
            startDateT.setText(staff.getStartDate());
             //gets current student photo.
            Image image;
            int staffID = Integer.parseInt(idt.getText());
            image = queries.getStaffImageByID(staffID);
            photo.setIcon(new ImageIcon(image));
            queries.disconnect();
           }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void changeFields(boolean tF){
        this.tF = tF;
        titlet.setEditable(tF);
        fNamet.setEditable(tF);
        lNamet.setEditable(tF);
        adresst.setEditable(tF);
        townt.setEditable(tF);
        countryt.setEditable(tF);
        postcodet.setEditable(tF);
        emailt.setEditable(tF);
        phonet.setEditable(tF);
        mobilet.setEditable(tF);
        nokNameT.setEditable(tF);
        nokRelationT.setEditable(tF);
        nokPhoneT.setEditable(tF);
        brancht.setEditable(tF);
        genderT.setEditable(tF);
        dobT.setEditable(tF);
        positionT.setEditable(tF);
        startDateT.setEditable(tF);
        obst.setEditable(tF);
   }
   
   public void onAndOffButtons(boolean tF){
        this.tF = tF;
        previousB.setVisible(tF);
        nextB.setVisible(tF);
        deleteB.setVisible(tF);
        updateB.setVisible(tF);
        
    
    }
   
    
    }
    
    
    
    