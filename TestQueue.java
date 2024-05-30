import java.util.*;
import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;
public class TestQueue
{
    public static void main(String[]args) throws IOException
    {
        File file = new File("student.txt");
        Scanner scan = new Scanner(file);
        Queue studList = new Queue();
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while(scan.hasNext())
        {
            String data = scan.nextLine();
            StringTokenizer st = new StringTokenizer(data,";");
            
            int studentId = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            String phone = st.nextToken();
            double cgpa = Double.parseDouble(st.nextToken());
            int subAmt = Integer.parseInt(st.nextToken());
            String[] subName = new String[subAmt];
             for (int i = 0; i < subAmt; i++) {
                subName[i] = st.nextToken();
            }
            double fee = Double.parseDouble(st.nextToken());
            
            Student obj = new Student(studentId, name, phone, cgpa, subAmt, subName,fee);
            studList.enqueue(obj);
        }
        
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t        --**{[BRIGHT MINDS ACADEMY]}**--");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        //output b4 update fee
        System.out.println("\n\t\t\t\t\t\tTHE PRICE BEFORE UPDATE THE FEE ");
        System.out.println("===================================================================================================================================");
        System.out.println(String.format("|%-7s|%-12s|%-17s|%-14s|%-6s|%-16s|%-39s|%-11s|","NO","STUDENT ID","NAME","PHONE NUMBER",
                                           "CGPA","SUBJECT AMOUNT","SUBJECT NAMES","TOTAL FEE"));
        System.out.println("===================================================================================================================================");
        int n = 1;
        Queue temp = new Queue();
        while(!studList.isEmpty())
        {                            
            System.out.println("|"+n + "\t" + studList.front().toString());         
            temp.enqueue(studList.dequeue());
            n++;              
        }
        System.out.println("===================================================================================================================================");
        
        while(!temp.isEmpty())
        {
            studList.enqueue(temp.dequeue());        
        }
        
        //calculation fee
        Queue updatedList = new Queue();
        while (!studList.isEmpty()) {
            Student currentStudent =(Student) studList.dequeue();
            double totalFee = 0.0;

            // Calculating fees for each subject enrolled by the student
            for (int i = 0; i < currentStudent.getSubAmt(); i++) {
                String subject = currentStudent.getSubName()[i];
                double subjectFee = currentStudent.calculateSubjectFee(subject);
                totalFee += subjectFee;
            }
            currentStudent.setStudentFee(totalFee);
            updatedList.enqueue(currentStudent);
        }
                
        while(!updatedList.isEmpty())
        {
            studList.enqueue(updatedList.dequeue());        
        }
        
        System.out.println("\n\t\t\t\t\t\t    ======================");
        System.out.println("\t\t\t\t\t\t    PRICE FOR EACH SUBJECT");
        System.out.println("\t\t\t\t\t\t    ======================");
        System.out.println(String.format("\t\t\t\t\t\t    |%-8s|%-11s|","ICT200","RM 114.90"));
        System.out.println(String.format("\t\t\t\t\t\t    |%-8s|%-11s|","MAT210","RM 122.30"));
        System.out.println(String.format("\t\t\t\t\t\t    |%-8s|%-11s|","CSC248","RM 190.10"));
        System.out.println(String.format("\t\t\t\t\t\t    |%-8s|%-11s|","CSC301","RM 117.21"));
        System.out.println(String.format("\t\t\t\t\t\t    |%-8s|%-11s|","CSC207","RM 136.70"));
        System.out.println("\t\t\t\t\t\t    ======================");
        
        //after update the fee
        System.out.println();
        System.out.println("\t\t\t\t\t\tTHE PRICE AFTER UPDATE THE FEE ");
        System.out.println("===================================================================================================================================");
        System.out.println(String.format("|%-7s|%-12s|%-17s|%-14s|%-6s|%-16s|%-39s|%-11s|","NO","STUDENT ID","NAME","PHONE NUMBER",
                                           "CGPA","SUBJECT AMOUNT","SUBJECT NAMES","TOTAL FEE"));
        System.out.println("===================================================================================================================================");
        int k = 1;
        while(!studList.isEmpty())
        {                                          
            System.out.println("|"+ k + "\t" + studList.front().toString());         
            temp.enqueue(studList.dequeue());
            k++;         
        }
        while (!temp.isEmpty()) {
            studList.enqueue(temp.dequeue());
        }
        System.out.println("===================================================================================================================================");
        System.out.println();
        
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("TASK CAN BE PERFORMED");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("[1] - Search ID and display details");
        System.out.println("[2] - Search the subject name, display the information of the students who took the subject, and count the number of");
        System.out.println("      people who took that subject. ");
        System.out.println("[3] - Calculate a 10% discount for the first five students with IDs starting in 2022****");
        System.out.println("[4] - Calculate the average fee for students and the total fee for each year.");
        System.out.println("[5] - Display dean list and not dean list student");
        System.out.println("[6] - Stop");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Please select task to perform :");
        int ans = sc.nextInt();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        
        while(ans != 6){
            if(ans == 1){
                //1.search id and display details
                System.out.print("\nPLEASE ENTER AN ID TO BE SEARCHED :");
                int idSearch = sc.nextInt();
                System.out.println();
                System.out.println("===================================================================================================================================");
                System.out.println(String.format("|%-7s|%-12s|%-17s|%-14s|%-6s|%-16s|%-39s|%-11s|","NO","STUDENT ID","NAME","PHONE NUMBER",
                                                   "CGPA","SUBJECT AMOUNT","SUBJECT NAMES","TOTAL FEE"));
                System.out.println("===================================================================================================================================");
                
                boolean found = false;
                int h = 1;
                while(!studList.isEmpty())
                {        
                    Student currentStudent =(Student) studList.dequeue();
               
                    if(currentStudent.getId() == idSearch){
                        System.out.println("|"+ h + "\t" + currentStudent.toString());         
                        found = true;
                    }                   
                    h++; 
                    temp.enqueue(currentStudent);
                }
                if(!found){
                    System.out.println("ID NOT FOUND!!!");
                }
                while (!temp.isEmpty()) {
                    studList.enqueue(temp.dequeue());
                }
                System.out.println("===================================================================================================================================");
                System.out.println();
            }
            else if(ans == 2){
                //2.search subject name and display the information and count number of person taken that subject
                System.out.print("\nENTER THE NAME OF THE SUBJECT :");
                String subSearch = sc.next();
                System.out.println();
                System.out.println("===================================================================================================================================");
                System.out.println(String.format("|%-7s|%-12s|%-17s|%-14s|%-6s|%-16s|%-39s|%-11s|","NO","STUDENT ID","NAME","PHONE NUMBER",
                                                   "CGPA","SUBJECT AMOUNT","SUBJECT NAMES","TOTAL FEE"));
                System.out.println("===================================================================================================================================");
                int count = 0;
                boolean found = false;
                int j = 1;
                while(!studList.isEmpty())
                {         
                    Student currentStudent =(Student) studList.dequeue();   
                    String[] subject = currentStudent.getSubName();
                    found = false;
                    for(int i = 0 ; i < subject.length ; i++)
                    {
                        if(subject[i].equalsIgnoreCase(subSearch))
                        {
                            System.out.println("|"+ j + "\t" + currentStudent.toString());         
                            j++;  
                            count++;
                            temp.enqueue(currentStudent);
                            found = true;
                        }
                    }
                    if(!found){
                        temp.enqueue(currentStudent);
                    }
                }
                System.out.println("===================================================================================================================================");
                if(count == 0)
                {
                    System.out.println("THERE ARE NO STUDENTS FOR THIS SUBJECT");
                }
                else
                {
                    System.out.println("NUMBER OF STUDENT TAKEN FOR SUBJECT " + subSearch + ":" + count);
                }
                while (!temp.isEmpty()) {
                    studList.enqueue(temp.dequeue());
                }
                System.out.println("===================================================================================================================================");
                System.out.println();
            }
            else if(ans == 3){
                //3.calculate 10% discount for the first 5 student with id start with 2022****      
                System.out.println("\n\t\t\t\tTHE PRICE AFTER DISCOUNT FOR FIRST 5 STUDENTS FROM BATCH 2022");
                System.out.println("===================================================================================================================================");
                System.out.println(String.format("|%-7s|%-12s|%-17s|%-14s|%-6s|%-16s|%-39s|%-11s|","NO","STUDENT ID","NAME","PHONE NUMBER",
                                                   "CGPA","SUBJECT AMOUNT","SUBJECT NAMES","TOTAL FEE"));
                System.out.println("===================================================================================================================================");
                int p = 1;
                int count2 = 0;
                while(!studList.isEmpty() )
                {         
                    Student currentStudent =(Student) studList.dequeue();   
                    String id = String.valueOf(currentStudent.getId());            
                    if(id.length() >= 4 && id.substring(0,4).equals("2022")&& count2<5)
                    {     
                        double afterDisc = currentStudent.getFee() * 0.90;
                        currentStudent.setStudentFee(afterDisc); 
                        System.out.println("|"+ p + "\t" + currentStudent.toString());  
                        count2++;                      
                    }      
                    temp.enqueue(currentStudent);
                    p++;
                }
        
                while (!temp.isEmpty()) {
                    studList.enqueue(temp.dequeue());
                }
                System.out.println("===================================================================================================================================");
                
                System.out.println();
                System.out.println("\t\t\t\t\t\tTHE PRICE AFTER UPDATE THE FEE ");
                System.out.println("===================================================================================================================================");
                System.out.println(String.format("|%-7s|%-12s|%-17s|%-14s|%-6s|%-16s|%-39s|%-11s|","NO","STUDENT ID","NAME","PHONE NUMBER",
                                                   "CGPA","SUBJECT AMOUNT","SUBJECT NAMES","TOTAL FEE"));
                System.out.println("===================================================================================================================================");
                k = 1;
                while(!studList.isEmpty())
                {                                          
                    System.out.println("|"+ k + "\t" + studList.front().toString());         
                    temp.enqueue(studList.dequeue());
                    k++;         
                }
                while (!temp.isEmpty()) {
                    studList.enqueue(temp.dequeue());
                }
                System.out.println("===================================================================================================================================");
                System.out.println();
            }
            else if(ans ==4){
                //4.calculate average and total fee for each year based on first 4 number of student id
                System.out.println();
                System.out.println("     TOTAL FEE AND AVERAGE BASED ON EACH BATCH");
                System.out.println("====================================================");
                System.out.println(String.format("|%-15s|%-7s|%-12s|%-13s|","TOTAL STUDENT","BATCH","TOTAL FEE","AVERAGE FEE"));
                System.out.println("====================================================");
                double total1 = 0.0 , total2 = 0.0, total3 = 0.0,average1 = 0.0,average2 = 0.0,average3 = 0.0, grandTotal = 0.0;
                int countA1 = 0,countA2 = 0,countA3 = 0;
        
                while(!studList.isEmpty())
                {         
                    Student currentStudent =(Student) studList.dequeue();   
                    String id = String.valueOf(currentStudent.getId());    
                    if(id.substring(0,4).equals("2021"))
                    {                    
                         total1 += currentStudent.getFee();              
                         temp.enqueue(currentStudent);
                         countA1++;
                    }      
                    else if(id.substring(0,4).equals("2022"))
                    {
                        total2 += currentStudent.getFee();              
                        temp.enqueue(currentStudent);
                        countA2++;
                    }           
                    else if(id.substring(0,4).equals("2023"))
                    {
                        total3 += currentStudent.getFee();         
                        temp.enqueue(currentStudent);
                        countA3++;
                    }            
                }
                while (!temp.isEmpty()) {
                    studList.enqueue(temp.dequeue());
                }       
                
                average1 = total1 / countA1;
                average2 = total2 / countA2;
                average3 = total3 / countA3;
                grandTotal = total1 + total2 + total3;
                
                System.out.println(String.format("|%-15s|%-7s|%-12s|%-13s|",countA1,"2021","RM"+df.format(total1),"RM"+df.format(average1))); 
                System.out.println(String.format("|%-15s|%-7s|%-12s|%-13s|",countA2,"2022","RM"+df.format(total2),"RM"+df.format(average2)));
                System.out.println(String.format("|%-15s|%-7s|%-12s|%-13s|",countA3,"2023","RM"+df.format(total3),"RM"+df.format(average3)));
                System.out.println("====================================================");
                System.out.println("|TOTAL PRICE :RM" + df.format(grandTotal) +"                           |");
                System.out.println("====================================================");
                System.out.println();
            }
            else if(ans == 5){
                //5.remove all students with cgpa higher than 3.5 to new queue named as deanList
                Queue deanList = new Queue();
                int d = 1;
                int nd = 1;
                System.out.println("\n\t\t\t\t\t\t\t DEAN LIST");
                System.out.println("===================================================================================================================================");
                System.out.println(String.format("|%-7s|%-12s|%-17s|%-14s|%-6s|%-16s|%-39s|%-11s|","NO","STUDENT ID","NAME","PHONE NUMBER",
                                                           "CGPA","SUBJECT AMOUNT","SUBJECT NAMES","TOTAL FEE"));
                System.out.println("===================================================================================================================================");
                while(!studList.isEmpty())
                {
                    Student currentStudent =(Student) studList.dequeue();  
                    if(currentStudent.getCgpa() >= 3.5)
                    {
                        System.out.println("|"+ d + "\t" + currentStudent.toString());         
                        d++; 
                        temp.enqueue(currentStudent);
                    }
                    else
                        temp.enqueue(currentStudent);
                }
                while (!temp.isEmpty()) {
                    studList.enqueue(temp.dequeue());
                }   
                System.out.println("===================================================================================================================================");
                System.out.println("\n\t\t\t\t\t\t\t NOT DEAN LIST");
                System.out.println("===================================================================================================================================");
                System.out.println(String.format("|%-7s|%-12s|%-17s|%-14s|%-6s|%-16s|%-39s|%-11s|","NO","STUDENT ID","NAME","PHONE NUMBER",
                                                           "CGPA","SUBJECT AMOUNT","SUBJECT NAMES","TOTAL FEE"));
                System.out.println("===================================================================================================================================");
                while(!studList.isEmpty())
                {
                    Student currentStudent =(Student) studList.dequeue();  
                    if(currentStudent.getCgpa() < 3.5){
                        System.out.println("|"+ nd + "\t" + currentStudent.toString());         
                        nd++; 
                        temp.enqueue(currentStudent);
                    }      
                    else
                        temp.enqueue(currentStudent);
                }
                while (!temp.isEmpty()) {
                    studList.enqueue(temp.dequeue());
                }       
                System.out.println("===================================================================================================================================");
                System.out.println();
            }
            
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("TASK CAN BE PERFORMED");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("[1] - Search ID and display details");
            System.out.println("[2] - Search the subject name, display the information of the students who took the subject, and count the number of");
            System.out.println("      people who took that subject. ");
            System.out.println("[3] - Calculate a 10% discount for the first five students with IDs starting in 2022****");
            System.out.println("[4] - Calculate the average fee for students and the total fee for each year.");
            System.out.println("[5] - Display dean list and not dean list student");
            System.out.println("[6] - Stop");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Please select task to perform :");
            ans = sc.nextInt();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}