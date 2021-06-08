/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Sinethemba Sithela (219112940)
 */
public class ReadFromFile 
{
    private ObjectInputStream input;
      
    public void openFile() throws ClassNotFoundException
    {
        ArrayList<Customer> list = new ArrayList<Customer>();
        list.add(new Customer("C150", "Luke", "Atmyass", "Bellville", "27 Jan 1981", 1520.50, false));
        list.add(new Customer("C130", "Stu", "Padassol", "Sea Point", "18 May 1987", 645.25, true));
        list.add(new Customer("C100", "Mike", "Rohsopht", "Bellville", "21 Jan 1993", 975.10, true));
        list.add(new Customer("C300", "Ivana.B", "Withew", "Langa", "16 July 1998", 1190.50, false));
        list.add(new Customer("C250", "Eileen", "Sideways", "Nyanga", "27 Nov 1999", 190.85, true));
        list.add(new Customer("C260", "Ima", "Stewpidas", "Atlantis", "27 jan 2001", 1890.70, true));
        
        ArrayList<Supplier> ss = new ArrayList<Supplier>();
        ss.add(new Supplier("S270", "Grand Theft Auto", "Toyota", "Mid-size sedan"));
        ss.add(new Supplier("S400", "Prime Motors", "Lexus", "Luxury sedan"));
        ss.add(new Supplier("S300", "We got Cars", "Toyota", "10-seater minibus"));
        ss.add(new Supplier("S350", "Auto Delight", "BMW", "Luxury SUV"));
        ss.add(new Supplier("S290", "MotorMania", "Hyundai", "compact budget"));
        
       try
       {
        input = new ObjectInputStream( new FileInputStream("stakeholder.ser") );
        System.out.println("**** ser file opened for reading ****" );
        
        Customer s = (Customer)input.readObject();
        
           System.out.println("============================================== Customer ===================================================");
           System.out.println("ID              Name            Surname          address        Date of birth   Credit         Can rent");
           System.out.println("===========================================================================================================");
           list.forEach(System.out::println);
           
        Supplier a = (Supplier)input.readObject();
        
           System.out.println("============================================== Supplier ===================================================");
           System.out.println("ID       Name                   Product type    Product desccription ");
           System.out.println("===========================================================================================================");
           ss.forEach(System.out::println);
       } 
       catch(IOException ioe){
           System.out.println("error opening ser file" + ioe.getMessage());
       }
    }
    public void closeFile()
    {
    try 
    {
      input.close();  
    }
    catch(IOException ioe)
    {
    System.out.println("error closing ser file" + ioe.getMessage());
    }
    }
    public void writeToFile() throws IOException{
            File customer = new File("customerOutFile.txt");
            FileWriter fw = new FileWriter(customer);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println("====================== Customer ======================");
            pw.println("ID      Name      Surname     Date of birth     Age");
            pw.println("======================================================");
            pw.println("C100    Mike      Rohsopht     21 Jan 1993      28");
            pw.println("C130    Stu       Padassol     18 May 1987      34");
            pw.println("C150    Luke      Atmyass      27 Jan 1981      40");
            pw.println("C250    Eileen    Sideways     27 Nov 1999      21");
            pw.println("C26     Ima       Stewpidas    27 jan 2001      20");
            pw.println("C300    Ivana.B   Withew       16 July 1998     22");
                 
        pw.close();
        
        File supplier = new File("supplierOutFile.txt");
        FileWriter sw = new FileWriter(supplier);
        PrintWriter qw = new PrintWriter(sw);
        
        qw.println("======================= Supplier ==============================");
        qw.println("ID      Name              Product type    Product desccription ");
        qw.println("===============================================================");
        qw.println("S350    Auto Delight      BMW             Luxury SUV");
        qw.println("S270    Grand Theft Auto  Toyota          Mid-size sedan");
        qw.println("S290    MotorMania        Hyundai         compact budget");
        qw.println("S400    Prime Motors      Lexus           Luxury sedan");
        qw.println("S300    We got Cars       Toyota          10-seater minibus");
        
        qw.close();
   }
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ReadFromFile obj = new ReadFromFile();
        obj.openFile();
        obj.closeFile();
        obj.writeToFile();
    }

   
}