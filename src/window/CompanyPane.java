package window;
import action.ButtonsAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class CompanyPane {

    //text fields
    public static JTextField companyName = new JTextField();
    public static JTextField companyEmail = new JTextField();
    public static JTextField companyAddress = new JTextField();
    public static JTextField companyCity = new JTextField();
    public static JTextField companyPostalCode = new JTextField();
    public static JTextField companyCountry = new JTextField();
    public static JTextField companyProvince = new JTextField();

    //buttons
    JButton saveCompanyButton = new JButton("Save");
    JButton autofillButton = new JButton("Autofill");


    public void companyLabels(JPanel cp){

        //company pane labels
        JLabel name = new JLabel("Name");
        JLabel email = new JLabel("Email");
        JLabel address = new JLabel("Address");
        JLabel city = new JLabel("City");
        JLabel country = new JLabel("Country");
        JLabel province = new JLabel("State/Province");
        JLabel postalCode = new JLabel("Postal Code");
        JLabel loadData = new JLabel("Enter Email To Autofill");
        JLabel saveCompany = new JLabel("Save Company");

        //setting bounds of labels
        name.setBounds(20,10,40,50);
        email.setBounds(280,10,40,50);
        address.setBounds(20,70,60,50);
        city.setBounds(350,70,60,50);
        postalCode.setBounds(20,130,80,50);
        country.setBounds(20,190,60,50);
        province.setBounds(280,190,90,50);
        loadData.setBounds(20,250,200,50);
        saveCompany.setBounds(280,250,120,50);

        //adding labels to array
        JLabel [] array = {name,email,address,city,country,province,postalCode,loadData,saveCompany};

        //adding the array to the mainWindow
        for(int x =0;x<array.length;x++){
            cp.add(array[x]);  //adding
        }


    }

    public void companyTextFields(JPanel cp){

        //setting bounds of labels
        companyName.setBounds(20,45,200,25);
        companyEmail.setBounds(280,45,200,25);
        companyAddress.setBounds(20,105,300,25);
        companyCity.setBounds(350,105,130,25);
        companyPostalCode.setBounds(20,165,200,25);
        companyCountry.setBounds(20,225,200,25);
        companyProvince.setBounds(280,225,200,25);

        //adding text fields to array
        JTextField[] textFieldArray = {companyName,companyEmail,companyAddress,companyCity,companyPostalCode,companyCountry,
                                        companyProvince};

        //adding text fields to mainWindow
        for(int x =0;x<textFieldArray.length;x++){
            cp.add(textFieldArray[x]);  //adding
        }
    }

    public void companyButton(JPanel cp){

        //autofillCompany Button
        autofillButton.setBackground(new Color(200,221,242,255));  //setting background color
        autofillButton.setBounds(20,285,160,25);  //setting bounds
        autofillButton.setFocusable(false);  //setting focus-false
        autofillButton.addActionListener(this::actionPerformed);  //adding action listener

        //saveCompany Button
        saveCompanyButton.setBackground(new Color(200,221,242,255));  //setting background color
        saveCompanyButton.setBounds(280,285,160,25);  //setting bounds
        saveCompanyButton.setFocusable(false);  //setting focus-false
        saveCompanyButton.addActionListener(this::actionPerformed);  //adding action listener

        //adding buttons to mainWindow
        cp.add(autofillButton);
        cp.add(saveCompanyButton);
    }

    //buttons action
    private void actionPerformed(ActionEvent e){

        //if the button clicked is saveCompanyButton
        if(e.getSource()==saveCompanyButton){

            //calling method from ButtonAction class
            new ButtonsAction().saveCompany();
        }

        //if the button clicked is autofillCompanyButton
        else{
            //calling method from ButtonAction class
            new ButtonsAction().autofillCompany();
        }

    }
}
