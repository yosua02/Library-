package tes2;
import java.util.Scanner;
import java.util.ArrayList;

public class Tes2 {

    
    public static void main(String[] args) 
    {
        ArrayList<studentPin> studentList = new ArrayList<>();
        
        boolean bool = true;
        String enterID;
        
        while (bool == true)
        {            
            Scanner keyboard = new Scanner(System.in);
            Scanner numberinput = new Scanner(System.in);

            int number;            
            String question;

            System.out.println("\n" + "Welcome to KOI Library");
            System.out.println("-----------------------------");
            System.out.println("1. Register Account");
            System.out.println("2. Print registered list");
            System.out.println("3. Log in");
            System.out.println("4. Exit");

            do
            {
                System.out.println("Choose which number");
                number = numberinput.nextInt();
                
            }while(number <= 0 || number >= 5);

            
            
            switch (number)
            {
                case 1 :
                                        
                    do{                       
                        int k;
                        System.out.println("Register account");
                        System.out.println("----------------");
                         
                        
                       if (studentList.isEmpty())
                            {
                                System.out.println("Enter ID");
                                enterID = keyboard.nextLine();
                            } 
                       else
                       {
                            System.out.println("Enter ID");
                            enterID = keyboard.nextLine();
                            
                            for (k=0;k<studentList.size();k++)
                            {   
                                                                                                 
                                while (enterID.equals(studentList.get(k).getID()))
                                {                                         
                                    System.out.println("ID has been registered");
                                    System.out.println("Please enter a new ID");
                                    enterID = keyboard.nextLine();                                       
                                }                                
                            }
                       }
                                            
                        System.out.println("Enter Pin");
                        String enterPin = keyboard.nextLine();
                        
                        studentPin student = new studentPin(enterID, enterPin);
                        studentList.add(student);
                        
                        System.out.println("Enter more pin ? (y/n) ");
                        question = keyboard.nextLine();
                        
                    }while(question.equals("yes") || question.equals("y"));

                    System.out.println("You have succesfully registered");
                    System.out.println("-------------------------------");                   
                    break;


                case 2 :
                    
                    if (studentList.isEmpty())
                            {
                                System.out.println("Please register an account before you log in");
                                break;
                            }
                    
                    System.out.printf("Student ID");
                    System.out.printf("\t Student Pin");

                    for (int i = 0; i < studentList.size();i++)
                        {   
                            System.out.printf("\n" + studentList.get(i).getID());
                            System.out.printf("\t \t  "+"%s", studentList.get(i).getPin());
                        }
                    System.out.println("\n" + "------------------------------");
                    break;

                case 3 :
                                      
                    String studentid,studentpin;
                    boolean trial = true;
                    int idindex = 0;
                    
                    if (studentList.isEmpty())
                    {
                        System.out.println("Please register an account before you log in");
                        break;
                    }
                    
                    System.out.println("Enter ID");
                    studentid = keyboard.nextLine();

                    do
                    {       
                        for (int l = 0; l < studentList.size(); l++) 
                        {                                  
                            if (studentid.equals(studentList.get(l).getID()))
                            {
                                trial = false;
                                idindex = l;
                                break;
                            }                            
                        }
                        if (trial == false)
                            {
                                break;
                            }
                        System.out.println("ID is not registered");
                        System.out.println("Please register your ID");
                        studentid = keyboard.nextLine();
                    }while(trial == true);
                    
                    System.out.println("Enter Pin");
                    studentpin = keyboard.nextLine();
                    
                    while(!studentpin.equals(studentList.get(idindex).getPin()))
                    {
                        System.out.println("Wrong pin");
                        System.out.println("Re-enter pin");
                        studentpin = keyboard.nextLine();
                    }
                    System.out.println("Succesfully logged in");
                    break;
                            
                case 4:
                    System.out.println("Thank you");
                    bool = false;
                    break;
            }
        }    
    }
}    

    
class studentPin
{
    String ID;
    String Pin;
    
    public studentPin (String id, String pi)
    {
        ID = id;
        Pin = pi;
    }
    
    public void setID(String id)
    {
        ID = id;
    }
    
    public String getID()
    {
        return ID;
    }
    
    public void setPin(String pi)
    {
        Pin = pi;
    }
    
    public String getPin()
    {
        return Pin;
    }
}
