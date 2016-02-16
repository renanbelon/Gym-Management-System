import java.io.*;

public class Student
{
   private int sID;
   private String bNo;
   private String cNo;
   private String sTitle;
   private String sFName;
   private String sSName;
   private String sDOB;
   private String sGender;
   private String sFLAdress;
   private String sPostcode;
   private String sTown;
   private String sCountry;
   private String sEmail;
   private String sTelephone;
   private String sMobile;
   private String sEnrolDate;
   private String sBelt;
   private String sNOKName;
   private String sNOKRelation;
   private String sNOKTelephone;
   private String sObservation;
   
    public Student(int sID,String bNo, String cNo,String sTitle,String sFName,String sSName,
    String sDOB,String sGender,String sFLAdress,String sPostcode,String sTown,String sCountry,
    String sEmail,String sTelephone,String sMobile,String sEnrolDate,String sBelt,String sNOKName,String sNOKRelation,
    String sNOKTelephone,String sObservation)
      {
        this.sID = sID;
        this.bNo = bNo;
        this.cNo = cNo;
        this.sTitle = sTitle;
        this.sFName = sFName;
        this.sSName = sSName;
        this.sDOB = sDOB;
        this.sGender = sGender;
        this.sFLAdress = sFLAdress;
        this.sPostcode = sPostcode;
        this.sTown = sTown;
        this.sCountry = sCountry;
        this.sEmail = sEmail;
        this.sTelephone = sTelephone;
        this.sMobile = sMobile;
        this.sEnrolDate = sEnrolDate;
        this.sBelt = sBelt;
        this.sNOKName = sNOKName;
        this.sNOKRelation = sNOKRelation;
        this.sNOKTelephone = sNOKTelephone;
        this.sObservation = sObservation;
    }
    
    public void setSID(int sID){
        this.sID = sID;
    }
    
    public int getSID(){
        return sID;
    }
    
    public void setBNo(String bNo){
        this.bNo = bNo;
    }
    
    public String getBNo(){
        return bNo;
    }
    
    public void setCNo(String cNo){
        this.cNo = cNo;
    }
    
    public String getCNo(){
        return cNo;
    }
       
    public void setSTitle(String sTitle){
        this.sTitle = sTitle;
    }
    
    public String getSTitle(){
        return sTitle;
    }
    
    public void setSFName(String sFName){
        this.sFName = sFName;
    }
    
    public String getSFName(){
        return sFName;
    }
    
     public void setSSName(String sSName){
        this.sSName = sSName;
    }
    
    public String getSSName(){
        return sSName;
    }
    
     public void setSDOB(String sDOB){
        this.sDOB = sDOB;
    }
    
    public String getSDOB(){
        return sDOB;
    }
    
    public void setSGender(String sGender){
        this.sGender = sGender;
    }
    
    public String getSGender(){
        return sGender;
    }
    
    public void setSFLAdress(String sFLAdress){
        this.sFLAdress = sFLAdress;
    }
    
    public String getSFLAdress(){
        return sFLAdress;
    }
    
    public void setSPostcode(String sPostcode){
        this.sPostcode = sPostcode;
    }
    
    public String getSPostcode(){
        return sPostcode;
    }
    
    public void setSTown(String sTown){
        this.sTown = sTown;
    }
    
    public String getSTown(){
        return sTown;
    }
    
    public void setSCountry(String sCountry){
        this.sCountry = sCountry;
    }
    
    public String getSCountry(){
        return sCountry;
    }
    
    public void setSEmail(String sEmail){
        this.sEmail = sEmail;
    }
    
    public String getSEmail(){
        return sEmail;
    }
    
    public void setSTelephone(String sTelephone){
        this.sTelephone = sTelephone;
    }
    
    public String getSTelephone(){
        return sTelephone;
    }
    
    public void setSMobile(String sMobile){
        this.sMobile = sMobile;
    }
    
    public String getSMobile(){
        return sMobile;
    }
    
    public void setSEnrolDate(String sEnrolDate){
        this.sEnrolDate = sEnrolDate;
    }
    
    public String getSEnrolDate(){
        return sEnrolDate;
    }
    
    public void setSBelt(String sBelt){
        this.sBelt = sBelt;
    }
    
    public String getSBelt(){
        return sBelt;
    }
    
    public void setSNOKName(String sNOKName){
        this.sNOKName = sNOKName;
    }
    
    public String getSNOKName(){
        return sNOKName;
    }
    
    public void setSNOKRelation(String sNOKRelation){
        this.sNOKRelation = sNOKRelation;
    }
    
    public String getSNOKRelation(){
        return sNOKRelation;
    }
    
    public void setSNOKTelephone(String sNOKTelephone){
        this.sNOKTelephone = sNOKTelephone;
    }
    
    public String getSNOKTelephone(){
        return sNOKTelephone;
    }
    
    public void setSObservation(String sObservation){
        this.sObservation = sObservation;
    }
    
    public String getSObservation(){
        return sObservation;
    }
}

