package pdf;
import action.TextFields;

//using itext, open source library to write PDF document, to write pdf
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDate;

import java.io.FileOutputStream;

public class WritePdf extends TextFields {

    private final String BOLD = BaseFont.HELVETICA_BOLD;  //bold font
    private final String PLAIN = BaseFont.HELVETICA;  //plain font
    public WritePdf(){

        try {
            Document document = new Document();  //object of class Document

            //creating pdf file
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(epTextFields[0].getText()+".pdf"));
            document.open();  //opening

            companyDetails(writer);  //calling method to add company details to pdf
            pdfLabels(writer);  //calling method to add labels to pdf
            employeeDetails(writer);  //calling method to add employee details to pdf
            calculateTax(writer,document);  //calling method to add calculated taxes to pdf

            //closing document after finishing writing
            document.close();

            //pay stub created message dialog
            messageDialog("Pay stub created successfully");
        }catch(Exception e){  //throwing exception
            errorMessageDialog("Unable to create pay stub");
        }
    }

    private void companyDetails(PdfWriter writer){

        //adding company name to the pdf
        setPosition(String.valueOf(cpTextFields[1].getText()),20,800,20,writer,BOLD);

        //adding company address to the pdf
        setPosition(String.valueOf(cpTextFields[2].getText()),20,780,12,writer,PLAIN);

        //adding company country to the pdf
        setPosition(String.valueOf(cpTextFields[5].getText()),20,760,12,writer,PLAIN);

        //adding company email to the pdf
        setPosition(String.valueOf(cpTextFields[0].getText()),20,740,12,writer,PLAIN);

    }

    private void employeeDetails(PdfWriter writer){
        //adding employee name to the pdf
        String employeeName = epTextFields[1].getText() + " " + epTextFields[2].getText();
        setPosition(employeeName,80,680,12,writer,PLAIN);

        //adding employee email to the pdf
        setPosition(String.valueOf(epTextFields[0].getText()),80,650,12,writer,PLAIN);

        //adding employee number to the pdf
        setPosition(epTextFields[3].getText(),410,680,12,writer,PLAIN);

        //adding current date to the pdf
        setPosition(String.valueOf(LocalDate.now()),410,650,12,writer,PLAIN);
    }

    private void pdfLabels(PdfWriter writer){
        String nameLabel = "Name: ";
        setPosition(nameLabel,20,680,12,writer,BOLD);

        String emailLabel = "Email: ";
        setPosition(emailLabel,20,650,12,writer,BOLD);

        String numberLabel = "Number: ";
        setPosition(numberLabel,350,680,12,writer,BOLD);

        String dateLabel = "Date: ";
        setPosition(dateLabel,350,650,12,writer,BOLD);

        //adding a line in the center of the pdf
        setPosition("_".repeat(42),0,630,26,writer,BOLD);

        String grossPayLabel = "Gross Pay: ";
        setPosition(grossPayLabel,20,600,12,writer,BOLD);

        String hoursWorkedLabel = "Hours: ";
        setPosition(hoursWorkedLabel,350,600,12,writer,BOLD);

        String payRateLabel = "Pay Rate: ";
        setPosition(payRateLabel,350,570,12,writer,BOLD);

        String federalTaxLabel = "Federal Tax: ";
        setPosition(federalTaxLabel,20,550,12,writer,BOLD);

        String cppLabel = "CPP: ";
        setPosition(cppLabel,20,520,12,writer,BOLD);

        String eiLabel = "EI: ";
        setPosition(eiLabel,20,490,12,writer,BOLD);

        String totalTaxLabel = "Total Tax Deducted: ";
        setPosition(totalTaxLabel,20,460,12,writer,BOLD);

        String netPayLabel = "Net Pay: ";
        setPosition(netPayLabel,20,410,12,writer,BOLD);
    }

    //setting position of text string at certain position in the pdf
    private void setPosition(String text, int x, int y,int size, PdfWriter writer,String font){
        try{
            PdfContentByte cb = writer.getDirectContent();  //getting content
            BaseFont bf = BaseFont.createFont(font, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);  //setting font style
            cb.saveState();  //saving state
            cb.beginText();  //starting text
            cb.moveText(x,y);  //moving text to certain position
            cb.setFontAndSize(bf, size);  //setting font style and size
            cb.showText(text);  //showing text in pdf
            cb.endText();  //ending text
            cb.restoreState();  //restoring back to the state

        }catch(Exception e){  //throwing exception
            errorMessageDialog("Runtime exceptional error");
        }
    }

    private void calculateTax(PdfWriter writer, Document document){

        //The taxes deduction rate
        final double federalTaxRate = 6.59;
        final double cppTaxRate = 5.02;
        final double eiTaxRate = 1.63;


        //changing pay rate and hours worked to double
        double employeePayRate = Double.parseDouble(ipTextFields[1].getText());
        double employeeHoursWorked = Double.parseDouble(ipTextFields[0].getText());

        //calculating employee gross pay which is worked hours multiplied by pay rate
        double employeeGrossPay = employeePayRate * employeeHoursWorked;

        //deducting taxes from employee's gross pay
        double federalTaxDeducted = (federalTaxRate * employeeGrossPay)/100;
        double cppTaxDeducted = (cppTaxRate * employeeGrossPay)/100;
        double eiTaxDeducted = (eiTaxRate * employeeGrossPay)/100;
        double totalTaxDeducted = federalTaxDeducted + cppTaxDeducted + eiTaxDeducted;

        //calculating employee net pay
        double employeeNetPay = employeeGrossPay - totalTaxDeducted;


        //adding hours worked to the pdf
        setPosition(String.valueOf(employeeHoursWorked),410,600,12,writer,PLAIN);

        //adding employee pay rate to the pdf
        setPosition(String.valueOf(employeePayRate),410,570,12,writer,PLAIN);

        //adding employee gross pay to the pdf
        setPosition(String.format("%.2f", employeeGrossPay),90,600,12,writer,PLAIN);

        //adding federalTax deducted to the pdf
        setPosition(String.format("%.2f", federalTaxDeducted),150,550,12,writer,PLAIN);

        //adding cpp deducted to the pdf
        setPosition(String.format("%.2f", cppTaxDeducted),150,520,12,writer,PLAIN);

        //adding ei deducted to the pdf
        setPosition(String.format("%.2f", eiTaxDeducted),150,490,12,writer,PLAIN);

        //adding total tax deducted to the pdf
        setPosition(String.format("%.2f", totalTaxDeducted),150,460,12,writer,PLAIN);

        //adding net pay to the pdf
        setPosition(String.format("%.2f",employeeNetPay),80,410,12,writer,BOLD);



    }
}
