import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.Component.*;
import net.proteanit.sql.*;

public class Queries extends JFrame
{   
    private final String USERNAME ="dbuser";
    private final String PASSWORD = "dbpassword";
    private final String CONN ="jdbc:mysql://localhost/garciaacademy";
    Connection conn = null;
    Statement st= null;
    ResultSet rs = null;
    PreparedStatement addStudent =null;
    PreparedStatement addStaff =null;
    PreparedStatement getImageByID = null;
    PreparedStatement deleteStudent = null;
    PreparedStatement deleteStaff = null;
    PreparedStatement editStudent= null;
    PreparedStatement editStaff= null;
    PreparedStatement findStudent = null;
    PreparedStatement getStudentByID = null;
    
    public void connect(){
      try{
          conn= DriverManager.getConnection(CONN,USERNAME,PASSWORD);
          addStudent = conn.prepareStatement("insert into Students(B_No,Cat_No,Photo,Title,Fname,Sname,DOB,Gender,FLAddress,PostCode,Town,Country,Email,T_No,M_No,EnrolmentDate,Belt,NOK_Name,NOK_Relation,NOK_Phone,Observation) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          addStaff= conn.prepareStatement("insert into staffs(B_No,Photo,Title,Fname,Sname,DOB,Gender,FLAddress,PostCode,Town,Country,Email,T_No,M_No,position,startingDate,NOK_Name,NOK_Relation,NOK_Phone,Observation) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          deleteStudent= conn.prepareStatement("delete from students where student_id =?");
          deleteStaff= conn.prepareStatement("delete from staffs where staff_id =?");
          editStudent = conn.prepareStatement("UPDATE students set B_No = ?,Cat_No = ?,Title =?,Fname=?,Sname =?,DOB =?,Gender =?,FLAddress =?,PostCode =?,Town =?,Country =?,Email =?,T_No =?,M_No =?,EnrolmentDate =?,Belt =?,NOK_Name =?,NOK_Relation =?,NOK_Phone =?,Observation =? where student_id = ?;");
          editStaff = conn.prepareStatement("UPDATE staffs set B_No = ?,Title =?,Fname=?,Sname =?,DOB =?,Gender =?,FLAddress =?,PostCode =?,Town =?,Country =?,Email =?,T_No =?,M_No =?,position =?,startingDate =?,NOK_Name =?,NOK_Relation =?,NOK_Phone =?,Observation =? where staff_id = ?;");
        }
      catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
        }
    
    }
    
    public void disconnect(){
       try
        {
            conn.close();
        }
        catch(SQLException sqle)
        {
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);        
        }
      
    }
    
    public boolean checkLogin(String username, String pass){
        boolean check= false;
        try{
            conn= DriverManager.getConnection(CONN,USERNAME,PASSWORD);
            st = conn.createStatement();
            String sql = "select * from users where login = '" + username + 
            "' and pass ='" + pass + "'";
            rs = st.executeQuery(sql);
            
            while(rs.next()){
            check = true;
            }
            
            if (check== false){
                JOptionPane.showMessageDialog(this,"User name or password incorrect!","incorrect login",JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
            }
        return check;   
        }
        
    public int insertStudents(int bNo, int cNo,InputStream sPhoto,String sTitle,String sFName,String sSName,
    String sDOB,String sGender,String sFLAdress,String sPostcode,String sTown,String sCountry,
    String sEmail,String sTelephone,String sMobile,String sEnrolDate,String sBelt,String sNOKName,String sNOKRelation,
    String sNOKTelephone,String sObservation){
        int insert = 0;
        try{
        addStudent.setInt(1,bNo);
        addStudent.setInt(2,cNo);
        addStudent.setBinaryStream(3,sPhoto);
        addStudent.setString(4,sTitle);
        addStudent.setString(5,sFName);
        addStudent.setString(6,sSName);
        addStudent.setString(7,sDOB);
        addStudent.setString(8,sGender);
        addStudent.setString(9,sFLAdress);
        addStudent.setString(10,sPostcode);
        addStudent.setString(11,sTown);
        addStudent.setString(12,sCountry);
        addStudent.setString(13,sEmail);
        addStudent.setString(14,sTelephone);
        addStudent.setString(15,sMobile);
        addStudent.setString(16,sEnrolDate);
        addStudent.setString(17,sBelt);
        addStudent.setString(18,sNOKName);
        addStudent.setString(19,sNOKRelation);
        addStudent.setString(20,sNOKTelephone);
        addStudent.setString(21,sObservation);
        
        insert = addStudent.executeUpdate();
        
        if(insert == 1){
            JOptionPane.showMessageDialog(null, "Student details has been sucessfuly inserted"  ," Student Insert", JOptionPane.PLAIN_MESSAGE);
            
        }
        }
        catch(SQLException sqle)
        {
           JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
        }
        
        
        return insert;
        }
        
    public int insertStaffs(int bNo,InputStream sPhoto,String sTitle,String sFName,String sSName,
    String sDOB,String sGender,String sFLAdress,String sPostcode,String sTown,String sCountry,
    String sEmail,String sTelephone,String sMobile,String sPosition, String startDate,String sNOKName,String sNOKRelation,
    String sNOKTelephone,String sObservation){
        int insert = 0;
        try{
        addStaff.setInt(1,bNo);
        addStaff.setBinaryStream(2,sPhoto);
        addStaff.setString(3,sTitle);
        addStaff.setString(4,sFName);
        addStaff.setString(5,sSName);
        addStaff.setString(6,sDOB);
        addStaff.setString(7,sGender);
        addStaff.setString(8,sFLAdress);
        addStaff.setString(9,sPostcode);
        addStaff.setString(10,sTown);
        addStaff.setString(11,sCountry);
        addStaff.setString(12,sEmail);
        addStaff.setString(13,sTelephone);
        addStaff.setString(14,sMobile);
        addStaff.setString(15,sPosition);
        addStaff.setString(16,startDate);
        addStaff.setString(17,sNOKName);
        addStaff.setString(18,sNOKRelation);
        addStaff.setString(19,sNOKTelephone);
        addStaff.setString(20,sObservation);
        
        insert = addStaff.executeUpdate();
        
        if(insert == 1){
            JOptionPane.showMessageDialog(null, "Staff details has been sucessfuly inserted" ," Staff Insert", JOptionPane.PLAIN_MESSAGE);
            
        }
        }
        catch(SQLException sqle)
        {
           JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
        }
        
        
        return insert;
        }
  
    public ArrayList<Student> getStudents() throws Exception{
        ArrayList<Student> list = new ArrayList<>();
        
        InputStream input = null;
        FileOutputStream output = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("select s.Student_ID, b.town,s.Title, s.Fname, s.Sname, s.DOB, s.Gender, s.FLAddress, s.PostCode, s.Town, s.Country, s.Email, s.T_No, s.M_No,s.EnrolmentDate,s.Belt, s.NOK_Name, s.NOK_Relation, s.NOK_Phone, s.Observation, c.cat_name from students s,categories c, branches b where s.cat_no = c.cat_no and s.B_no = b.b_NO order by Student_id");
            
            File theFile = new File("dbimg.jpg");
            output = new FileOutputStream(theFile);
            
            
            while(rs.next()){
                int sID = rs.getInt("Student_id");
                String branch = rs.getString("b.town");
                String title = rs.getString("s.title");
                String fname = rs.getString("s.fname");
                String sname = rs.getString("s.sname");
                String dob = rs.getString("s.dob");
                String gender = rs.getString("s.gender");
                String flAddress = rs.getString("s.fladdress");
                String postCode = rs.getString("s.PostCode");
                String town = rs.getString("s.town");
                String country = rs.getString("s.country");
                String email = rs.getString("s.email");
                String phone = rs.getString("s.t_no");
                String mobile = rs.getString("s.m_no");
                String enrol = rs.getString("s.EnrolmentDate");
                String belt = rs.getString("s.belt");
                String nokname = rs.getString("s.nok_name");
                String nokrelation = rs.getString("s.nok_relation");
                String nokphone = rs.getString("s.nok_phone");
                String observation = rs.getString("s.observation");
                String catname = rs.getString("c.cat_name");
                Student student = new Student(sID,branch,catname,title,fname,sname,dob,gender,flAddress,postCode,town,country,email,phone,mobile,enrol,belt,nokname,nokrelation,nokphone,observation);
                list. add(student);
                
            }
        }
         catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
            }
            return list;
    }
    
    public ArrayList<Staff> getStaffs() throws Exception{
        ArrayList<Staff> list = new ArrayList<>();
        InputStream input = null;
        FileOutputStream output = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("select s.Staff_ID, b.town,s.Title, s.Fname, s.Sname, s.DOB, s.Gender, s.FLAddress, s.PostCode, s.Town, s.Country, s.Email, s.T_No, s.M_No, s.position,s.startingDate, s.NOK_Name, s.NOK_Relation, s.NOK_Phone, s.Observation from staffs s, branches b where s.B_no = b.b_NO order by Staff_id");
            while(rs.next()){
                int sID = rs.getInt("s.Staff_id");
                String branch = rs.getString("b.town");
                String title = rs.getString("s.title");
                String fname = rs.getString("s.fname");
                String sname = rs.getString("s.sname");
                String dob = rs.getString("s.dob");
                String gender = rs.getString("s.gender");
                String flAddress = rs.getString("s.fladdress");
                String postCode = rs.getString("s.PostCode");
                String town = rs.getString("s.town");
                String country = rs.getString("s.country");
                String email = rs.getString("s.email");
                String phone = rs.getString("s.t_no");
                String mobile = rs.getString("s.m_no");
                String position = rs.getString("position");
                String enrol = rs.getString("s.startingDate");
                String nokname = rs.getString("s.nok_name");
                String nokrelation = rs.getString("s.nok_relation");
                String nokphone = rs.getString("s.nok_phone");
                String observation = rs.getString("s.observation");
                Staff staff = new Staff(sID,branch,title,fname,sname,dob,gender,flAddress,postCode,town,country,email,phone,mobile,position,enrol,nokname,nokrelation,nokphone,observation);
                list.add(staff);
            }
        }
         catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
            }
        return list;
    }
    
    public int deleteStudentByID(int stdntID){
    int delete= 0;
        try{
        deleteStudent.setInt(1,stdntID);
        delete = deleteStudent.executeUpdate();
        if(delete==1){
            JOptionPane.showMessageDialog(null, "Student deleted!"  ,"Delete Info", JOptionPane.PLAIN_MESSAGE);
        }
    }
    catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
           
    }
    return delete;
    }
    
    public int deleteStaffByID(int staffID){
    int delete= 0;
        try{
        deleteStaff.setInt(1,staffID);
        delete = deleteStaff.executeUpdate();
        if(delete==1){
            JOptionPane.showMessageDialog(null, "Staff deleted!"  ,"Delete Info", JOptionPane.PLAIN_MESSAGE);
        }
    }
    catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
           
    }
    return delete;
    }
    
    public int updateStudent(int bNo, int cNo,String sTitle,String sFName,String sSName,
    String sDOB,String sGender,String sFLAdress,String sPostcode,String sTown,String sCountry,
    String sEmail,String sTelephone,String sMobile,String sEnrolDate,String sBelt,String sNOKName,String sNOKRelation,
    String sNOKTelephone,String sObservation,int student_id){
    int result = 0;
    
    try{
        
        editStudent.setInt(1,bNo);
        editStudent.setInt(2,cNo);
        editStudent.setString(3,sTitle);
        editStudent.setString(4,sFName);
        editStudent.setString(5,sSName);
        editStudent.setString(6,sDOB);
        editStudent.setString(7,sGender);
        editStudent.setString(8,sFLAdress);
        editStudent.setString(9,sPostcode);
        editStudent.setString(10,sTown);
        editStudent.setString(11,sCountry);
        editStudent.setString(12,sEmail);
        editStudent.setString(13,sTelephone);
        editStudent.setString(14,sMobile);
        editStudent.setString(15,sEnrolDate);
        editStudent.setString(16,sBelt);
        editStudent.setString(17,sNOKName);
        editStudent.setString(18,sNOKRelation);
        editStudent.setString(19,sNOKTelephone);
        editStudent.setString(20,sObservation);
        editStudent.setInt(21,student_id);
        result = editStudent.executeUpdate();
        
        if(result ==1){
        JOptionPane.showMessageDialog(null, "Student record updated!"  ,"Update Information", JOptionPane.PLAIN_MESSAGE);
        }
    
    }
    catch(SQLException sqle){
        JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
    }
    
        return result;
        }
        
        
    public int editStaff(int bNo,String sTitle,String sFName,String sSName,
    String sDOB,String sGender,String sFLAdress,String sPostcode,String sTown,String sCountry,
    String sEmail,String sTelephone,String sMobile,String position,String startDate,String sNOKName,String sNOKRelation,
    String sNOKTelephone,String sObservation,int staff_id){
    int result = 0;
    
    try{
        
        editStaff.setInt(1,bNo);
        editStaff.setString(2,sTitle);
        editStaff.setString(3,sFName);
        editStaff.setString(4,sSName);
        editStaff.setString(5,sDOB);
        editStaff.setString(6,sGender);
        editStaff.setString(7,sFLAdress);
        editStaff.setString(8,sPostcode);
        editStaff.setString(9,sTown);
        editStaff.setString(10,sCountry);
        editStaff.setString(11,sEmail);
        editStaff.setString(12,sTelephone);
        editStaff.setString(13,sMobile);
        editStaff.setString(14,position);
        editStaff.setString(15,startDate);
        editStaff.setString(16,sNOKName);
        editStaff.setString(17,sNOKRelation);
        editStaff.setString(18,sNOKTelephone);
        editStaff.setString(19,sObservation);
        editStaff.setInt(20,staff_id);
        result = editStaff.executeUpdate();
        
        if(result ==1){
        JOptionPane.showMessageDialog(null, "Student record updated!"  ,"Update Information", JOptionPane.PLAIN_MESSAGE);
        }
    
    }
    catch(SQLException sqle){
        JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
    }
    
        return result;
        }
    
    public Image getImageByID(int sID){
        Image image=null;
         
          try{
              
              byte[]imageBytes;
              getImageByID =  conn.prepareStatement("select photo from students where student_id = ?");
              getImageByID.setInt(1,sID);
              rs=getImageByID.executeQuery();
              
              while(rs.next()){
                  imageBytes=rs.getBytes(1);
                  image = getToolkit().createImage(imageBytes);
              }
            }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
       }
       return image;
    }
    
    public Image getStaffImageByID(int sID){
        Image image=null;
         
          try{
              
              byte[]imageBytes;
              getImageByID =  conn.prepareStatement("select photo from staffs where staff_id = ?");
              getImageByID.setInt(1,sID);
              rs=getImageByID.executeQuery();
              
              while(rs.next()){
                  imageBytes=rs.getBytes(1);
                  image = getToolkit().createImage(imageBytes);
              }
            }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
       }
       return image;
    }
    
    public ArrayList<String> getCategory(){
    ArrayList<String> list = new ArrayList();
    try{
        st = conn.createStatement();
        rs = st.executeQuery("select cat_name from categories order by Cat_No");
        
        while (rs.next()){
            //int catID = rs.getInt("cat_NO");
            String catName = rs.getString("cat_name");
            //Categories cat= new Categories(catID,catName);
            list.add(catName);
        
        }
    }
    catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
    }
    return list;
    }
    
    public ArrayList<String> getBranch(){
    ArrayList<String> list = new ArrayList();
    try{
        st = conn.createStatement();
        rs = st.executeQuery("select town from branches order by b_No");
        
        while (rs.next()){
            //int catID = rs.getInt("cat_NO");
            String btown = rs.getString("town");
            //Categories cat= new Categories(catID,catName);
            list.add(btown);
        
        }
    }
    catch(Exception ex){
        System.out.println(ex);
    }
    return list;
    }

     public void searchStudent(String lastName,JTable tb){
         try {
            lastName += "%";
            findStudent = conn.prepareStatement("select s.Student_ID as ID,s.Title,s.Fname as Name, s.Sname as Surname, s.DOB, s.Gender, s.FLAddress as Address, s.PostCode, s.M_No as Mobile, c.cat_name as Category, b.town as Branch from students s,categories c, branches b where s.Sname like ? and s.cat_no = c.cat_no and s.B_no = b.b_NO");
          
            findStudent.setString(1, lastName);
            rs = findStudent.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));
           
        }
         catch(SQLException sqle){
             JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
        }
     }
     
     public  ArrayList<Student> getStdntByID(int stdntID){
        ArrayList<Student> list = new ArrayList();
        
        InputStream input = null;
        FileOutputStream output = null;
        try{
            getStudentByID = conn.prepareStatement("select s.Student_ID, b.town,s.Title, s.Fname, s.Sname, s.DOB, s.Gender, s.FLAddress, s.PostCode, s.Town, s.Country, s.Email, s.T_No, s.M_No,s.EnrolmentDate,s.Belt, s.NOK_Name, s.NOK_Relation, s.NOK_Phone, s.Observation, c.cat_name from students s,categories c, branches b where Student_id like ? and s.cat_no = c.cat_no and s.B_no = b.b_NO order by Student_id");
            getStudentByID.setInt(1,stdntID);
            rs = getStudentByID.executeQuery();
           
                             
            while(rs.next()){
                int sID = rs.getInt("Student_id");
                String branch = rs.getString("b.town");
                String title = rs.getString("s.title");
                String fname = rs.getString("s.fname");
                String sname = rs.getString("s.sname");
                String dob = rs.getString("s.dob");
                String gender = rs.getString("s.gender");
                String flAddress = rs.getString("s.fladdress");
                String postCode = rs.getString("s.PostCode");
                String town = rs.getString("s.town");
                String country = rs.getString("s.country");
                String email = rs.getString("s.email");
                String phone = rs.getString("s.t_no");
                String mobile = rs.getString("s.m_no");
                String enrol = rs.getString("s.EnrolmentDate");
                String belt = rs.getString("s.belt");
                String nokname = rs.getString("s.nok_name");
                String nokrelation = rs.getString("s.nok_relation");
                String nokphone = rs.getString("s.nok_phone");
                String observation = rs.getString("s.observation");
                String catname = rs.getString("c.cat_name");
                Student student = new Student(sID,branch,catname,title,fname,sname,dob,gender,flAddress,postCode,town,country,email,phone,mobile,enrol,belt,nokname,nokrelation,nokphone,observation);
                list.add(student);
                
            }
        }
         catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);    
            }
            return list;
    }

  }
  