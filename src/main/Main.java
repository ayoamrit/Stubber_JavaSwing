package main;
import window.Window;
import action.ReadData;

//The application is created by Amrit Dhaliwal
//Github: ayoamrit

public class Main {

    //main method
    public static void main(String[] args) {

        //object of class ReadData
        ReadData readData = new ReadData();

        Thread thread = new Thread(readData);
        thread.start();  //starting thread created in class ReadData

        new Window(); //calling constructor

    }
}
