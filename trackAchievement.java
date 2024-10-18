/**
 * This is a simple Java program that allows the user to manage achievements and display them as a progress bar.
 * It provides options to view achievements, edit them, and quit the application.
 * Achievements are stored in a text file called "data.txt."
 *
 * @author Amro Almaghraba
 * @version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Thread;
import java.io.IOException;
import java.io.FileWriter;

class cobol {
    public static int ReadFile (){
        int data = 0;
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            
            data = myReader.nextInt();
            
            myReader.close();
            
        }catch (FileNotFoundException e) {
             data = 0;   
        }
        return data;
    }
    
    public static String UpdateInfo() {
        File myObj = new File("data.txt");
        String result;
        if (myObj.delete()) {
            try {
                if (myObj.createNewFile()) {
                    FileWriter myWriter = new FileWriter("data.txt");
                    Scanner info = new Scanner(System.in);
                    int a =0;
                    while(a == 0){
                            System.out.println("enter new achivement");
                            String newinfo = info.nextLine();
                            a = check(newinfo);
                            if (a==1){
                                myWriter.write(newinfo);
                            }
                    }
                    myWriter.close();
                    result = "the information update successfully";
                } else {
                    result = "error 1";
                }
            } catch (IOException e) {
                result = "error 2";
            }
        } else {
            result = "error 3";
        }
        return result;
    }
    
    public static int check(String value) {
        // chek is numric?
        int result= 0;
        for (char c : value.toCharArray()) {
            if (Character.isDigit(c)) {
                result = 1;
            } else {
                result = 0;
                break;
            }
        }
        return result;
        
    }
    public static void main(String []args) {
        
        Scanner cho = new Scanner(System.in);
        int q = 0;
        while (q == 0) {
            System.out.println("choose the number");
            System.out.println("1- show the achivement  2- edit the achivment 3- quit");
            int road = cho.nextInt();
            if (road == 1){
                int ach = ReadFile();
                int total = 18;
                int still = total - ach;
                double prec = (ach * 100) / total; 
                System.out.print("[");
                for(int i = 0; i < ach; i++) {
                    System.out.print("█");
                    try
                    {
                        Thread.sleep(250);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                }
                for (int i = 0; i < still; i ++) {
                    System.out.print("░");
                    try
                    {
                        Thread.sleep(250);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                }
                System.out.println("]  " + prec + "%" + ach);
            } else if (road == 2) {
                System.out.println(UpdateInfo());
            }else if (road == 3) {
                System.out.println("Thank you for useing our app");
                q = 1;
            }else {
                System.out.println("Your chois is incorrect");
            }
        }
        
    }
}
