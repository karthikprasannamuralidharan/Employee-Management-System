
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back;
    
    public ViewEmployee() {
        
        // Set up the frame properties
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee ID");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                cemployeeId.add(rs.getString("empId"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        //Search Button
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        //Print Button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        //Update Button
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        //Back Button
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        // Set frame size, location, and visibility
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search) {
            String query = "Select * from employee where empId = '"+cemployeeId.getSelectedItem()+"' ";
            try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        } else if (ae.getSource() == update) {
            
            
        } else if (ae.getSource() == print) {
            
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    
    public static void main(String[] args) {
        new ViewEmployee();
    }
    
}
