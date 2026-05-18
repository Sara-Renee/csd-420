// Sara White - CSD-420 - Assignment 10.2

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Mod10_2 extends JFrame {

    // FIELDS

    // buttons
    private JButton displayBtn;
    private JButton updateBtn;
    private JButton quitBtn;

    // text fields
    private JTextField txtID;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtFavTeam;

    // labels
    private JLabel lblID;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblFavTeam;

    
    // BUTTON LISTENER
 
    //create field to hold ActionListener object (btnListener)
    private ActionListener btnListener = new ActionListener() {
        // logic for each button when pushed
        public void actionPerformed(ActionEvent e) {
            //get text displayed (the label) 
            // from the button user clicks
            String btnPushed = ((JButton)e.getSource()).getText();
            // if statements decide which method to call
            // displayRecord(), updateRecord() or shutDown()
            if(btnPushed.equals("Display")) {
                displayRecord();
            }
            if(btnPushed.equals("Update")) {
                updateRecord();
            }
            if(btnPushed.equals("Quit")) {
                shutDown();
            }
        }
    };

    // CONSTRUCTOR
   
    public Mod10_2() {
        // create JFrame window and set title to fan database
        super("Fan Database");
        //create the buttons
        displayBtn = new JButton("Display");
        updateBtn = new JButton("Update");
        quitBtn = new JButton("Quit");
        // create empty text fields
        txtID = new JTextField("");
        txtFirstName = new JTextField("");
        txtLastName = new JTextField("");
        txtFavTeam = new JTextField("");
        // create labels for the text fields
        lblID = new JLabel("ID");
        lblFirstName = new JLabel("First Name");
        lblLastName = new JLabel("Last Name");
        lblFavTeam = new JLabel("Favorite Team");
    }

    // LAUNCH JFRAME

    public void launchJFrame(){
        // set window size
        setSize(400, 400);
        // null = do not use an automatic layout manager
        getContentPane().setLayout(null);
        // set background color of window
        getContentPane().setBackground(Color.lightGray);
        // seting default close operation to do nothing
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // adding windowListener to run shutDown() method
        // so user can either push the 'quit' button or
        // close the window
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                shutDown();
            }
        });
        
        // adding components to the window
        getContentPane().add(lblID);
        getContentPane().add(lblFirstName);
        getContentPane().add(lblLastName);
        getContentPane().add(lblFavTeam);

        getContentPane().add(txtID);
        getContentPane().add(txtFirstName);
        getContentPane().add(txtLastName);
        getContentPane().add(txtFavTeam);

        getContentPane().add(displayBtn);
        getContentPane().add(updateBtn);
        getContentPane().add(quitBtn);

        // positioning for components:
        // labels, text fields, buttons
        lblID.setBounds(new Rectangle(50, 40, 100, 30));
        lblFirstName.setBounds(new Rectangle(50, 80, 100, 30));
        lblLastName.setBounds(new Rectangle(50, 120, 100, 30));
        lblFavTeam.setBounds(new Rectangle(50, 160, 100, 30));

        txtID.setBounds(new Rectangle(175, 40, 150, 30));
        txtFirstName.setBounds(new Rectangle(175, 80, 150, 30));
        txtLastName.setBounds(new Rectangle(175, 120, 150, 30));
        txtFavTeam.setBounds(new Rectangle(175, 160, 150, 30));

        displayBtn.setBounds(new Rectangle(40, 240, 90, 30));
        updateBtn.setBounds(new Rectangle(150, 240, 90, 30));
        quitBtn.setBounds(new Rectangle(260, 240, 90, 30));

        displayBtn.addActionListener(btnListener);
        updateBtn.addActionListener(btnListener);
        quitBtn.addActionListener(btnListener);

        setVisible(true);
    }

    // DISPLAY RECORD
    private void displayRecord() {
    // method to run when user clicks 'display' button
    // .trim() to remove extra spaces
    String idEntered = txtID.getText().trim();
    // display statement if no ID entered when
    // display button is pushed
    if(idEntered.equals("")) {
        JOptionPane.showMessageDialog(this, "Please enter an ID.");
        return;
    }
    try {
        // connect to the database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasedb",
            "student1", "pass");
        // SQL statement to find record where ID matches user's input
        String sql = "SELECT Firstname, Lastname, Favoriteteam FROM fans WHERE ID = ?";

        // put the ID entered by user into the placeholder [?]
        PreparedStatement statement = connection.prepareStatement(sql);
        // convert text/string to integer
        statement.setInt(1, Integer.parseInt(idEntered));
        // returned rows from SELECT statement stored in ResultSet
        ResultSet resultSet = statement.executeQuery();
        // check to see if a record was found
        if(resultSet.next()) {
            txtFirstName.setText(resultSet.getString("Firstname"));
            txtLastName.setText(resultSet.getString("Lastname"));
            txtFavTeam.setText(resultSet.getString("Favoriteteam"));
        }
        // display message to user if no record found for ID entered
        else {
            JOptionPane.showMessageDialog(this, "No record found for ID " + idEntered);
        }

        // close database objects
        resultSet.close();
        statement.close();
        connection.close();
    }
    catch(Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}

  
    // UPDATE RECORD

    private void updateRecord() {
     // same logic for displayRecord
     String idEntered = txtID.getText().trim();

     if(idEntered.equals("")) {
         JOptionPane.showMessageDialog(this, "Please enter an ID.");
         return;
     }

     try {
         Connection connection = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/databasedb",
             "student1", "pass");

         String sql = "UPDATE fans SET Firstname = ?, Lastname = ?, Favoriteteam = ? WHERE ID = ?";

         PreparedStatement statement = connection.prepareStatement(sql);

         statement.setString(1, txtFirstName.getText().trim());
         statement.setString(2, txtLastName.getText().trim());
         statement.setString(3, txtFavTeam.getText().trim());
         statement.setInt(4, Integer.parseInt(idEntered));

         int rowsUpdated = statement.executeUpdate();

         if(rowsUpdated > 0) {
             JOptionPane.showMessageDialog(this, "Record updated successfully.");
         }
         else {
             JOptionPane.showMessageDialog(this, "No record found for ID " + idEntered);
         }

         statement.close();
         connection.close();
     }
     catch(Exception ex) {
         JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
     }
 }

    // SHUT DOWN METHOD

    private void shutDown() {
        // popup to confirm user wants to quit program
        // yes/no/cancel
        int returnVal = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to quit?"
        );
        // end program if yes option is selected by user
        if(returnVal == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // MAIN METHOD

    public static void main(String[] args) {

        Mod10_2 app = new Mod10_2();
        app.launchJFrame();
    }
}