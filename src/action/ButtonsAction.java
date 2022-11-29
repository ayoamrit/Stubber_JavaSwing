package action;

import pdf.WritePdf;
import javax.swing.JTextField;
import java.io.FileWriter;


public class ButtonsAction extends TextFields{

    //checking whether all the text fields contains text or not
    public void checkTextFields(){
        if(!isEmpty(cpTextFields)){
            if(!isEmpty(epTextFields)){
                if(!isEmpty(ipTextFields)){
                    new WritePdf();

                }else errorMessageDialog("Empty Field");
            }else errorMessageDialog("Empty Field");
        }else errorMessageDialog("Empty Field");
    }


    //method to check whether text field is empty or not
    private boolean isEmpty(JTextField[] fields){
        boolean empty = false;  //initializing boolean

        //reading all the array elements and checking text fields
        for(int x =0;x<fields.length;x++){
            if(fields[x].getText().equals("")){

                empty = true;  //changing variable to true if any of text fields is empty
                break;  //breaking the loop
            }
        }

        return empty;  //returning variable
    }

    //autofillCompanyButton action
    public void autofillCompany(){

        //checking if the email entered exists in hashmap or not
        if(ReadData.companyData.containsKey(cpTextFields[0].getText())){

            //if the key exists in hashmap then value would be read from hashmap
            String[] data = ReadData.companyData.get(cpTextFields[0].getText());

            //values are being set as text in text fields of company pane
            for(int x=0;x<data.length;x++){
                cpTextFields[x].setText(data[x]);
            }
        }
        //if the email does not exist in hashmap as a key
        else{
            errorMessageDialog("Company is not saved");
        }
    }

    //autofillEmployeeButton action
    public void autofillEmployee(){

        //checking whether the email entered exists in hashmap or not
        if(ReadData.employeeData.containsKey(epTextFields[0].getText())){

            //if the key exists in hashmap then value would be read from hashmap
            String[] data = ReadData.employeeData.get(epTextFields[0].getText());

            //values are being set as text in text fields of employee pane
            for(int x =0;x<data.length;x++){
                epTextFields[x].setText(data[x]);
            }
        }
        //if the email does not exist in hashmap as a key
        else{
            errorMessageDialog("Employee is not saved");
        }

    }

    //creating and writing data to a text file
    private void savingData(String fileName, JTextField[] fields){

        try{

            //using FileWriter to write data in a text file and setting append to true
            FileWriter writer = new FileWriter(fileName,true);

            //if text fields are not empty
            if(!isEmpty(fields)){

                //all the text from text fields would be stored in a text file
                for(int x =0;x<fields.length;x++){
                    writer.write(fields[x].getText()+",");
                }

                writer.write("\n");  //leaving a line

                writer.close();  //closing writer after writing text

                //displaying data saved dialog message
                messageDialog("Data successfully saved");

            }
            //if any empty text field detected
            else {
                errorMessageDialog("Empty Field");
            }

            //throwing exception if program is unable to store data
        }catch(Exception e){
            System.out.println("Error while writing data to company file");
        }
    }

    //saveCompanyButton action
    public void saveCompany(){

        //checking if company already exists or not
        if(ReadData.companyData.containsKey(cpTextFields[0].getText())){
            errorMessageDialog("Company is already saved");
        }
        else {
            //calling method savingData to save data and passing parameters
            savingData("company.txt", cpTextFields);

            messageDialog("Company saved successfully");

            //reading data again after writing
            new ReadData().readCompanyData();
        }
    }

    //saveEmployeeButton action
    public void saveEmployee(){

        //checking is employee already exists or not
        if(ReadData.employeeData.containsKey(epTextFields[0].getText())){
            errorMessageDialog("Employee is already saved");
        }
        else {
            //calling method savingData to save data and passing parameters
            savingData("employee.txt", epTextFields);

            messageDialog("Employee saved successfully");

            //reading data again after writing
            new ReadData().readEmployeeData();
        }
    }

}
