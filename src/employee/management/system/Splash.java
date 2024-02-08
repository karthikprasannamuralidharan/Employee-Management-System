package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener {

    Splash() {

        // Set up the frame properties
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // Create and customize the heading label
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);

        // Load and display the splash image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        // Create a button on the image for user interaction
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);  //Event Listener
        image.add(clickhere);

        // Set frame size, location, and visibility
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);

        // Display a blinking animation for the heading
        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);

            } catch (Exception e) {

            }
            heading.setVisible(true);
            try {
                Thread.sleep(500);

            } catch (Exception e) {

            }
        }

    }

    //Creates a method which hides splash page and displays login page when button is clicked
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();

    }

    public static void main(String[] args) {
        // Create an instance of the Splash class when the program starts
        new Splash();
    }
}
