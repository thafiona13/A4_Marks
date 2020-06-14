/*
 * Fiona Xie
 * 6/10/2020
 * Program that allows user to enter student name with marks in a class,with the option to add more names and marks, print the list, delete names and marks, graph the marks, search list for name and ability to quit.
 */
package a4_marks;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class A4_Marks {

    private static final Scanner x = new Scanner(System.in); // makes scanner availble in all methods
    static void menu(){
        System.out.println("\nOption 1: Add Names and Marks");
        System.out.println("Option 2: Print List");
        System.out.println("Option 3: Delete Names and Marks");
        System.out.println("Option 4: Graph Marks");
        System.out.println("Option 5: Search List");
        System.out.println("Option 6: Quit Program\n");
        System.out.print("Input: ");
    } //prints main menu options
    static String addName(){
        String answer;
        
        System.out.print("Enter Name: ");
        answer=x.nextLine();
                
        return answer;
    } //adds name to arraylist
    static Integer addMark(){
        int answer;
        
        System.out.print("Enter Mark: ");
        answer=x.nextInt();
        x.nextLine();
        
        return answer;  
    } //adds mark to arraylist
    static Integer Average (int avg,int amount){
        int answer;
        
        answer = avg/amount;
        return answer;
    } //calculates mean mark
    static String UpDown(int num,int avg){
        String answer=" ";
        
        if (num>avg){
            answer = "Above Average";
        }
        else if (num==avg){
            answer = "Average";
        }
        else {
            answer="Below Average";
        }
        return answer;
    } //Determines whatever student's mark is above, below or at mean
    static String Graph(int mark){
        String answer=" ";
        
        for (int i=0;i<mark;i++){
            answer=answer+"*";
        }
        
        return answer;
    } //Prints # of * a mark has

    
    public static void main(String[] args) {
        
        ArrayList<String> names = new ArrayList<>(); // arraylist for names
        ArrayList<Integer> marks = new ArrayList<>(); // arraylist for marks
        String input =" ";
        Boolean run=true; //run programs if true
       
        //runs program while true
        while (run){
        menu(); //runs menu method to print the main menu
        input=x.nextLine(); //collects user input
        
        //Add marks and names program when 1 is inputted
        if (input.equals("1")||input.equals("one")||input.equals("One")){
            names.add(addName()); //calls addName method to collect name for arraylist
            marks.add(addMark()); //calls addMark method to collect mark for arraylist 
        }
        
        //Print program when 2 is inputted
        else if (input.equals("2")||input.equals("two")||input.equals("Two")){ 
            int tot=0;
            int amount,max=0,min=100;
            
            // for loop that runs the length of indexes stored
            for (int i=0;i<names.size();i++){
                //gets total sum of all marks
                tot=(marks.get(i))+tot;
                //finds the max and min mark
                if (max<marks.get(i)){
                    max=marks.get(i);
                }
                else if(min>marks.get(i)){
                    min=marks.get(i);
                }
            }
            //finds number of indexes in array
            amount = names.size();
            
            //prints name, marks above or below average for all users stored in array for
            System.out.println("Name    Mark    Verdict");
            for (int i=0;i<names.size();i++){
                System.out.format("\n%-8.8s %2d %-14s",names.get(i),marks.get(i),UpDown(marks.get(i),Average(tot,amount)));
            }
            //prints average mark
            System.out.println("\nAverage mark is "+Average(tot,amount));
            //prints min and max mark
            System.out.format("Maximum mark was %d and Minimum mark was %d\n",max,min);
        }
        
        //Delete program runs when 3 is inputted
        else if (input.equals("3")||input.equals("three")||input.equals("Three")){
            //prints out a list of the name, mark and index #
            System.out.println("Name        Mark     Index #");
            for (int i=0; i<names.size();i++){
                System.out.format("%-8.8s %6d %8d\n",names.get(i),marks.get(i),i);
            }
            //double checks with the user if they want to delete all names and marks by pressing y
            System.out.println("Are you sure you want to delete all, type \"y\" to confirm");
            input=x.nextLine();
            
            if (input.equals("y")||input.equals("Y")){
                names.clear(); //clears names arraylist
                marks.clear(); //clears marks arraylist
                System.out.println("Cleared");
            }
        }
        //Graph program runs when 4 is inputted 
        else if (input.equals("4")||input.equals("four")||input.equals("Four")){
            System.out.println("Name     Mark");
            for (int i=0;i<names.size();i++){ //runs for the length of the number of items stored
                System.out.format("%-8.8s", names.get(i));//prints name
                System.out.print(Graph(marks.get(i))); //calls program Graph to print the * required
                System.out.println(" "+marks.get(i)); //prints mark
            }
        }
        //Search program when 5 is inputted
        else if (input.equals("5")||input.equals("Five")||input.equals("five")){ 
            System.out.print("Input the name exactly: ");
            input=x.nextLine(); //gets name
            
            //print name, mark, index#
            System.out.println("Name        Mark     Index #");
            System.out.format("%-8.8s %6d %8d\n",input,marks.get(names.indexOf(input)),names.indexOf(input)); 
        }
        //ends program when 6 is inputted
        else if (input.equals("6")||input.equals("six")||input.equals("Six")){
            run=false; //changes boolean to false
        }
        else {
            System.out.println("Input not registered, please select from main menu.");
        }
    }
   System.out.println("Bye");
  }
}

