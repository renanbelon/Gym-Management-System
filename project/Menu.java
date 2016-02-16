import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class Menu extends JFrame  implements ActionListener
{
    JComboBox studentscb,staffscb;
    JButton logout;
    JPanel menu,container;
    CardLayout card;
    FindStudents findStudent;
    StudentForm stdntForm;// = new StudentForm();
    AddStudent addStudent = new AddStudent();
    //FindStudents findStdnt = new FindStudents();
    StaffForm staffInfo = new StaffForm();
    AddStaff addStaff = new AddStaff();
    Queries queries = new Queries();
    ArrayList<Student> studentList = null;
    ArrayList<Staff> staffList = null;
    int counter = 0;
    String getBranchNO= null;
    String getCatNO = null;
   public Menu(){
        super("Main");
        setSize(1010,700);
        setLocationRelativeTo(null);
        setLayout(null);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menu = new JPanel();
        menu.setBounds(5,5,980,50);
        //menu.setBackground(Color.RED);
        add(menu);
        
        studentscb = new JComboBox();
        studentscb.addItem("Student");
        studentscb.addItem("Add Student");
        studentscb.addItem("Find student");
        studentscb.addActionListener(this);
        menu.add(studentscb);
    
        staffscb = new JComboBox();
        staffscb.addItem("Staff Info");
        staffscb.addItem("Add Staff");
        staffscb.addItem("Find staff");
        staffscb.addActionListener(this);
        menu.add(staffscb);
           
        logout = new JButton("Logout");
        logout.addActionListener(this);
        menu.add(logout);
    
        container = new JPanel();
        container.setBounds(20,65,950,420);
        container.setBackground(Color.BLUE);
        card = new CardLayout();
        container.setLayout(card);
        add(container);
        
        stdntForm = new StudentForm(container,card);
        findStudent= new FindStudents(container,card);
        container.add(stdntForm,"card1");
        container.add(addStudent,"card2");
        container.add(staffInfo,"card3");
        container.add(addStaff,"card4");
        container.add(findStudent,"card5");
         
       // setVisible(true);
   }
   
   
  
    public void arangestudents(){
        try{
            queries.connect();
            // DB values to comboboxes
            ArrayList<String>cbValues = queries.getCategory();
            ArrayList<String>branchValues = queries.getBranch();
            DefaultComboBoxModel cModel = new DefaultComboBoxModel(cbValues.toArray());
            DefaultComboBoxModel bModel = new DefaultComboBoxModel(branchValues.toArray());
            stdntForm.categoriesT.setModel(cModel);
            stdntForm.brancht.setModel(bModel);
            
            studentList=queries.getStudents();
            Student stdnt = studentList.get(counter);
            stdntForm.idt.setText(""+stdnt.getSID());
            stdntForm.titlet.setText(stdnt.getSTitle());
            stdntForm.fNamet.setText(stdnt.getSFName());
            stdntForm.lNamet.setText(stdnt.getSSName());
            stdntForm.adresst.setText(stdnt.getSFLAdress());
            stdntForm.townt.setText(stdnt.getSTown());
            stdntForm.countryt.setText(stdnt.getSCountry());
            stdntForm.postcodet.setText(stdnt.getSPostcode());
            stdntForm.emailt.setText(stdnt.getSEmail());
            stdntForm.phonet.setText(stdnt.getSTelephone());
            stdntForm.mobilet.setText(stdnt.getSMobile());
            stdntForm.nokNameT.setText(stdnt.getSNOKName());
            stdntForm.nokRelationT.setText(stdnt.getSNOKRelation());
            stdntForm.nokPhoneT.setText(stdnt.getSNOKTelephone());
            stdntForm.obst.setText(stdnt.getSObservation());
            //ComboBoxes
            getBranchNO = stdnt.getBNo();
            stdntForm.brancht.setSelectedItem(getBranchNO);
            getCatNO = stdnt.getCNo();
            stdntForm.categoriesT.setSelectedItem(getCatNO);
            
            stdntForm.genderT.setText(stdnt.getSGender());
            stdntForm.dobT.setText(stdnt.getSDOB());
            stdntForm.beltT.setText(stdnt.getSBelt());
            stdntForm.joinT.setText(stdnt.getSEnrolDate());
             //gets current student photo.
            Image image;
            int studentID = Integer.parseInt(stdntForm.idt.getText());
            image = queries.getImageByID(studentID);
            stdntForm.photo.setIcon(new ImageIcon(image));
            queries.disconnect();
           }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public void arangeStaffs(){
        try{
            queries.connect();
            //DB values to combobox
            ArrayList<String>branchValues = queries.getBranch();
            DefaultComboBoxModel bModel = new DefaultComboBoxModel(branchValues.toArray());
            staffInfo.brancht.setModel(bModel);
            
            staffList=queries.getStaffs();
            Staff staff = staffList.get(counter);
            staffInfo.idt.setText(""+staff.getSID());
            staffInfo.titlet.setText(staff.getSTitle());
            staffInfo.fNamet.setText(staff.getSFName());
            staffInfo.lNamet.setText(staff.getSSName());
            staffInfo.adresst.setText(staff.getSFLAdress());
            staffInfo.townt.setText(staff.getSTown());
            staffInfo.countryt.setText(staff.getSCountry());
            staffInfo.postcodet.setText(staff.getSPostcode());
            staffInfo.emailt.setText(staff.getSEmail());
            staffInfo.phonet.setText(staff.getSTelephone());
            staffInfo.mobilet.setText(staff.getSMobile());
            staffInfo.positionT.setText(staff.getSPosition());
            staffInfo.nokNameT.setText(staff.getSNOKName());
            staffInfo.nokRelationT.setText(staff.getSNOKRelation());
            staffInfo.nokPhoneT.setText(staff.getSNOKTelephone());
            staffInfo.obst.setText(staff.getSObservation());
          
            getBranchNO = staff.getBNo();
            staffInfo.brancht.setSelectedItem(getBranchNO);
            
            staffInfo.genderT.setText(staff.getSGender());
            staffInfo.dobT.setText(staff.getSDOB());
            staffInfo.startDateT.setText(staff.getStartDate());
             //gets current student photo.
            Image image;
            int staffID = Integer.parseInt(staffInfo.idt.getText());
            image = queries.getStaffImageByID(staffID);
            staffInfo.photo.setIcon(new ImageIcon(image));
            queries.disconnect();
           }
        catch(Exception e){
            System.out.println(e);
        }
    }

       public void actionPerformed(ActionEvent e)
       {
            if(e.getSource()== studentscb)
            {
                if(studentscb.getSelectedItem().toString().equals("Student"))
                {   
                    
                    card.show(container,"card1");
                }
                else if (studentscb.getSelectedItem().toString().equals("Add Student"))
                {
                    card.show(container,"card2");
                    queries.connect();
                    ArrayList<String>cbValues = queries.getCategory();
                    ArrayList<String>branchValues = queries.getBranch();
                    queries.disconnect();
                    
                    DefaultComboBoxModel cModel = new DefaultComboBoxModel(cbValues.toArray());
                    DefaultComboBoxModel bModel = new DefaultComboBoxModel(branchValues.toArray());
                    addStudent.categoriesT.setModel(cModel);
                    addStudent.brancht.setModel(bModel);
                }
                
                else if (studentscb.getSelectedItem().toString().equals("Find student"))
                {
                    card.show(container,"card5");
                    String empity = "";
                    queries.connect();
                    queries.searchStudent(empity,findStudent.table);
                    queries.disconnect();
                }
                
            }
            
            //**************************************************************************
            if (e.getSource()== staffscb){
                if(staffscb.getSelectedItem().toString().equals("Staff Info"))
                {
                    card.show(container,"card3");
                }
                if(staffscb.getSelectedItem().toString().equals("Add Staff"))
                {
                    card.show(container,"card4");
                    queries.connect();
                    ArrayList<String>branchValues = queries.getBranch();
                    queries.disconnect();
                    
                    DefaultComboBoxModel bModel = new DefaultComboBoxModel(branchValues.toArray());
                    addStaff.brancht.setModel(bModel);
                }
            }
            
            if(e.getSource()== logout){
                   Login login = new Login();
                   login.setVisible(true);
                   setVisible(false);
            }

}
   
   }
