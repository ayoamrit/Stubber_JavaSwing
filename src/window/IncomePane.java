package window;
import action.ButtonsAction;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class IncomePane {

    //text fields
    public static JTextField hoursField = new JTextField();
    public static JTextField payRateField = new JTextField();

    public void incomeLabels(JPanel ip){

        //labels
        JLabel taxesInfo = new JLabel("<html> * Payroll deductions required by law are the following<br>" +
                "1. Canada Pension Plan (CPP) contribution<br> " +
                "2. Employment Insurance (EI) premiums<br> " +
                "3. Income Tax deductions</html>");
        JLabel hours = new JLabel("Hours");
        JLabel payRate = new JLabel("Pay Rate");

        //setting bounds and color of labels
        taxesInfo.setBounds(20,10,800,100);
        taxesInfo.setForeground(Color.GRAY);

        hours.setBounds(20,120,60,50);
        payRate.setBounds(250,120,60,50);

        //adding labels to an array
        JLabel[] incomeLabelsArray = {taxesInfo,hours,payRate};

        //adding labels to incomePane
        for (JLabel x : incomeLabelsArray) {
            ip.add(x);
        }

    }

    public void incomeTextField(JPanel ip){

        //setting text fields bounds
        hoursField.setBounds(20,155,160,25);
        payRateField.setBounds(250,155,160,25);

        //adding text fields to incomePane
        ip.add(hoursField);
        ip.add(payRateField);

    }

    public void incomeButton(JPanel ip){

        JButton createPayStub = new JButton("Create pay stub");  //button
        createPayStub.setBackground(new Color(200,221,242,255));  //setting background of button
        createPayStub.setBounds(20,250,160,25);  //setting bounds of the button
        createPayStub.setFocusable(false);  //setting focus to false
        createPayStub.addActionListener(this::actionPerformed);  //adding actionListener
        ip.add(createPayStub);  //adding the button to incomePane
    }

    //button action
    public void actionPerformed(ActionEvent e){
        new ButtonsAction().checkTextFields();
    }

}
