import java.io.*;
import java.util.*;
public class assigment13 {
     public static void main(String[] args){
         String input;
         System.out.println("Writing Content into the File:");
         System.out.println();
         System.out.println("Step 1: Creating File..");
         File fileObj = new File("/Users/soorya/Desktop/3rd sem/JAVA ASSIGNMENT/input.txt"); 
         
         try{
            if (fileObj.createNewFile()) 
                {
                System.out.println("File created: " + fileObj.getName());
                }
            else
            {
                System.out.println("File already exists.");
            }
                }
        catch(Exception e)
        {
            System.out.println(e);
        }
         System.out.println();
         System.out.println("Step 2: Writing data into the File..");
         try {
        FileWriter fileWriter = new FileWriter("/Users/soorya/Desktop/3rd sem/JAVA ASSIGNMENT/input.txt");
         // Writes this content into the specified file
        fileWriter.write("Java is an Object Oriented programming language "); 
         
        // Closing is necessary to retrieve the resources allocated
        fileWriter.close(); 
        System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    
    catch(Exception e)
    {
        System.out.println(e);
    }
         System.out.println();
         System.out.println("Step 3: Reading the data from created  File..");
        try{
         File fileObj1 = new File("/Users/soorya/Desktop/3rd sem/JAVA ASSIGNMENT/input.txt"); 
        Scanner sc1 = new Scanner(fileObj1);
        while(sc1.hasNextLine())
        {
            input = sc1.nextLine();
            System.out.println(input);
        }
        }
        catch(Exception e)
        {
                   System.out.println(e); 
                }
     }
    
}