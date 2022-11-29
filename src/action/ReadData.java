package action;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class ReadData extends TextFields implements Runnable{

    //reading company and employee data in different thread
    public void run(){

        readCompanyData();  //reading company data method
        readEmployeeData();  //reading employee data method
    }

    //hashmap to store all the companies data
    public static HashMap<String, String[]> companyData = new HashMap<String, String[]>();

    //hashmap to store all the employees data
    public static HashMap<String,String[]> employeeData = new HashMap<>();


    //reading company data from the text file
    public void readCompanyData(){

        try{

            //scanner to read text file
            Scanner reader = new Scanner(new File("company.txt"));

            //using while loop to read all the lines from the text file
            while(reader.hasNextLine()){

                //splitting string and storing in an array
                String[] companyDataArray = reader.nextLine().split(",");

                //adding key and value to hashmap
                companyData.put(companyDataArray[0],companyDataArray);
            }

            reader.close(); //closing reader

        }catch(Exception e){  //throwing exception
            errorMessageDialog("An error occurred while reading company Data");
        }
    }

    //reading employees data from the text file
    public void readEmployeeData(){

        try{
            //scanner to read text file
            Scanner reader = new Scanner(new File("employee.txt"));

            //while loop to read all the lines from the text file
            while(reader.hasNextLine()){

                //splitting string and storing in an array
                String[] employeeDataArray = reader.nextLine().split(",");

                //adding key and value to hashmap
                employeeData.put(employeeDataArray[0],employeeDataArray);
            }

            reader.close();  //closing reader

        }catch(Exception e){  //throwing exception
            errorMessageDialog("An error occurred while reading employee Data");
        }
    }
}
