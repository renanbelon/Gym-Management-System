import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;

public class FindStudents extends JPanel implements ActionListener
{
    //panels and border
    JPanel panel,findPanel; 
    TitledBorder title;
       
    // Labels, Textfields and buttons
    JLabel sNameL;
    JTextField sNameT;
    JButton findB;
    
    //table
    JTable table;
    JScrollPane tableScroll;
    Queries queries = new Queries();
    ArrayList<Student> studentList = null;
    JPanel container1;
    CardLayout card1;
    public FindStudents(){
        createGUI();
    }
    
    public FindStudents(JPanel container, CardLayout card)
    {
        this.container1 = container;
        this.card1 = card;
        createGUI();
    }
    
    public void createGUI(){
         setSize(850,420);
        //setLocation(20,70);
        setLayout(new FlowLayout());
        
        
        //main panel
        panel = new JPanel();
        //panel.setBounds(20,20,550,250);
        panel.setPreferredSize(new Dimension(850,420));
        panel.setLayout(null);
        add(panel);
        
        // Top panel
        findPanel= new JPanel();
        findPanel.setBounds(10,20,310,35);
        findPanel.setLayout(new FlowLayout());
        //findPanel.setBackground(new Color(50,200,0));
        panel.add(findPanel);
        
        //labels, textfields and buttons of findPanel
        sNameL = new JLabel("Last Name");
        sNameT= new JTextField();
        sNameT.setPreferredSize(new Dimension(100,25));     
        findB = new JButton("Find");
        findB.addActionListener(this);
        findB.setPreferredSize(new Dimension(60,25));
        
        //Adding labels and textfield to findpanel
        findPanel.add(sNameL);
        findPanel.add(sNameT);
        findPanel.add(findB);
        
        //table
        table = new JTable();
        table.setBounds(10,55,830,150);
        tableScroll = new JScrollPane(table);
        tableScroll.setBounds(10,55,830,150);
        panel.add(tableScroll);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == findB){
            String lastname ="%";
            lastname += sNameT.getText();
            
            queries.connect();
            queries.searchStudent(lastname,table);
            queries.disconnect();
        }
     }
}
