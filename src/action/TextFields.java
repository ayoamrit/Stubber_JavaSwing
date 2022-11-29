package action;

import window.CompanyPane;
import window.EmployeePane;
import window.IncomePane;

import javax.swing.*;

public class TextFields {

    //storing all the text fields from employee pane in an array
    public JTextField[] epTextFields = {EmployeePane.employeeEmail, EmployeePane.employeeFirstname, EmployeePane.employeeLastname,
            EmployeePane.employeeNumber, EmployeePane.employeeAddress, EmployeePane.employeeCity,
            EmployeePane.employeePostalCode, EmployeePane.employeeCountry, EmployeePane.employeeProvince};

    //storing all the text fields from company pane in an array
    public JTextField[] cpTextFields = {CompanyPane.companyEmail, CompanyPane.companyName, CompanyPane.companyAddress,
            CompanyPane.companyCity, CompanyPane.companyPostalCode, CompanyPane.companyCountry,
            CompanyPane.companyProvince};

    //storing all the text fields from income pane in an array
    public JTextField[] ipTextFields = {IncomePane.hoursField, IncomePane.payRateField};


    //error message dialog box
    protected void errorMessageDialog(String message){

        //using JOptionPane to display a message dialog box
        JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
    }

    protected void messageDialog(String message){

        JOptionPane.showMessageDialog(null,message, "Done",JOptionPane.INFORMATION_MESSAGE);
    }

}
