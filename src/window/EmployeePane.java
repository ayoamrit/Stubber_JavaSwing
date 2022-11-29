package window;
import action.ButtonsAction;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class EmployeePane {

    //text fields
    public static JTextField employeeFirstname = new JTextField();
    public static JTextField employeeLastname = new JTextField();
    public static JTextField employeeEmail = new JTextField();
    public static JTextField employeeNumber = new JTextField();
    public static JTextField employeeAddress = new JTextField();
    public static JTextField employeeCity = new JTextField();
    public static JTextField employeePostalCode = new JTextField();
    public static JTextField employeeCountry = new JTextField();
    public static JTextField employeeProvince = new JTextField();


    //buttons
    JButton autofillEmployeeButton = new JButton("Autofill");
    JButton saveEmployeeButton = new JButton("Save");

    public void employeeLabels(JPanel ep){

        //employee pane labels
        JLabel firstname = new JLabel("First Name");
        JLabel lastname = new JLabel("Last Name");
        JLabel email = new JLabel("Email");
        JLabel number = new JLabel("Employee Number");
        JLabel address = new JLabel("Address");
        JLabel city = new JLabel("City");
        JLabel postalCode = new JLabel("Postal Code");
        JLabel country = new JLabel("Country");
        JLabel province = new JLabel("Province");
        JLabel loadEmployee = new JLabel("Enter Email To Autofill");
        JLabel saveEmployee = new JLabel("Save Employee");

        //setting bounds of labels
        firstname.setBounds(20,10,70,50);
        lastname.setBounds(200,10,70,50);
        email.setBounds(380,10,40,50);
        number.setBounds(20,90,110,50);
        address.setBounds(200,90,70,50);
        city.setBounds(380,90,70,50);
        postalCode.setBounds(20,170,70,50);
        country.setBounds(200,170,70,50);
        province.setBounds(380,170,70,50);
        loadEmployee.setBounds(20,250,200,50);
        saveEmployee.setBounds(280,250,120,50);

        //adding labels to array
        JLabel[] employeeLabelsArray = {firstname,lastname,email,number,address,city,postalCode,country,province,
                                        loadEmployee,saveEmployee};

        //adding labels to mainWindow from array
        for(int x =0;x<employeeLabelsArray.length;x++){
            ep.add(employeeLabelsArray[x]);  //adding
        }
    }

    public void employeeTextField(JPanel ep){

        //setting bounds of text fields
        employeeFirstname.setBounds(20,45,150,25);
        employeeLastname.setBounds(200,45,150,25);
        employeeEmail.setBounds(380,45,150,25);
        employeeNumber.setBounds(20,125,150,25);
        employeeAddress.setBounds(200,125,150,25);
        employeeCity.setBounds(380,125,150,25);
        employeePostalCode.setBounds(20,205,150,25);
        employeeCountry.setBounds(200,205,150,25);
        employeeProvince.setBounds(380,205,150,25);

        //adding text fields to array
        JTextField[] employeeTextFieldsArray = {employeeFirstname,employeeLastname,employeeEmail,employeeNumber,
                                                employeeAddress,employeeCity,employeePostalCode,employeeCountry,employeeProvince};

        //adding text fields to mainWindow from array
        for(int x =0;x<employeeTextFieldsArray.length;x++){
            ep.add(employeeTextFieldsArray[x]);  //array
        }
    }

    public void employeeButton(JPanel ep){

        //autofillEmployee Button
        autofillEmployeeButton.setBackground(new Color(200,221,242,255));  //setting background color
        autofillEmployeeButton.setBounds(20,285,160,25);   //setting bounds
        autofillEmployeeButton.addActionListener(this::actionPerformed);  //adding action listener
        autofillEmployeeButton.setFocusable(false);  //setting focus-false

        //saveEmployeeButton
        saveEmployeeButton.setBackground(new Color(200,221,242,255));  //setting background color
        saveEmployeeButton.setBounds(280,285,160,25);  //setting bounds
        saveEmployeeButton.setFocusable(false);  //adding action listener
        saveEmployeeButton.addActionListener(this::actionPerformed);  //setting focus-false

        //adding buttons to mainWindow
        ep.add(autofillEmployeeButton);
        ep.add(saveEmployeeButton);
    }

    //buttons action
    private void actionPerformed(ActionEvent e){

        //if the button clicked is saveEmployeeButton
        if(e.getSource()==saveEmployeeButton){
            //calling method from ButtonsAction class
            new ButtonsAction().saveEmployee();
        }
        //if the button clicked is autofillEmployeeButton
        else {
            //calling method from ButtonsAction class
            new ButtonsAction().autofillEmployee();
        }
    }
}
