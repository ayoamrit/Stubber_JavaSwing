package window;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    //mainWindow frame
    protected static JFrame mainWindow = new JFrame();

    //object of classes
    CompanyPane companyPane = new CompanyPane();
    EmployeePane employeePane = new EmployeePane();
    IncomePane incomePane = new IncomePane();

    public Window(){
        windowProperties();

        windowPane();//adding window pane

        mainWindow.setVisible(true);
    }

    //mainWindow properties
    private void windowProperties(){
        mainWindow.setTitle("Stubber");  //title of the window
        mainWindow.setSize(700,500);  //size of the window

        ImageIcon windowIcon = new ImageIcon("ref/windowIcon.jpg");
        mainWindow.setIconImage(windowIcon.getImage());  //setting mainWindow icon
        mainWindow.setResizable(false);  //non-resizable
        mainWindow.setLayout(null);  //null-layout
        mainWindow.getContentPane().setBackground(new Color(200,221,242,255));  //background color of the window
        mainWindow.setLocationRelativeTo(null);  //opening position of the window-null
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //exiting window on close
    }

    private void windowPane(){
        JTabbedPane windowPane = new JTabbedPane();  //window pane
        windowPane.setBounds(40,50,600,350);  //position and size of window pane
        windowPane.setFocusable(false);  //setting windowPane focus to false
        windowPanel(windowPane);  //calling function
    }

    private void windowPanel(JTabbedPane windowPane){

        //mainWindow panels
        JPanel companyPanel = new JPanel();
        JPanel employeePanel = new JPanel();
        JPanel incomePanel = new JPanel();

        //setting layout to null
        companyPanel.setLayout(null);
        employeePanel.setLayout(null);
        incomePanel.setLayout(null);

        //calling method from companyPane class
        companyPane.companyLabels(companyPanel);
        companyPane.companyTextFields(companyPanel);
        companyPane.companyButton(companyPanel);

        //calling method from employeePane class
        employeePane.employeeLabels(employeePanel);
        employeePane.employeeTextField(employeePanel);
        employeePane.employeeButton(employeePanel);

        //calling method from incomePane class
        incomePane.incomeLabels(incomePanel);
        incomePane.incomeTextField(incomePanel);
        incomePane.incomeButton(incomePanel);

        //adding panels to mainWindow pane
        windowPane.add("Company",companyPanel);
        windowPane.add("Employee",employeePanel);
        windowPane.add("Income",incomePanel);

        //adding pane to mainWindow
        mainWindow.add(windowPane);
    }

}
