package gurvender;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalTime;
public class Student {
    
    public static Student[] studentList = new Student[100];
    String Name;
    int id;
    String Age;
    String Book1;
    String Book2;
    String PhoneNumber;
    Book book1Adres;
    Book book2Adres;
    LocalTime book1BorrowTime;
    LocalTime book2BorrowTime;
    LocalTime book1ReturnTime;
    LocalTime book2ReturnTime;

    int fine;

    static Scanner sc = new Scanner(System.in);



    //registerMember
    static int  studentCounter =0;
    public static void registerMember(){
        System.out.print("Enter Name: ");
        String SName = sc.nextLine();
        System.out.print("Enter Age: ");
        String SAge = sc.nextLine();

        System.out.print("Enter Phone no: ");
        String SPhoneNo = sc.nextLine();
        Student s1 = new Student(SName, SAge, SPhoneNo);
        studentList[studentCounter++] = s1;
        System.out.println("Member Registered Successfully with Member id " + s1.id) ;
    }
    //checking string can convert in int or not
    public static int safeStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            // Handle the exception gracefully
            System.err.println("Invalid input. Couldn't parse the string to an integer.");
            return 0; // Default value or some other appropriate action
        }
    }

    //removeMember
    public static void reoveMember(){
        System.out.print("Enter Member Id ");
        String StingId = sc.nextLine();
        int checking_Id = safeStringToInt(StingId);
        if(checking_Id>=0 && studentList[checking_Id]!=null){
            Student s1 = studentList[checking_Id];
            System.out.println("Name : " + s1.Name);
            System.out.println("Member Id : " + s1.id);
            System.out.println("Phone No : " + s1.PhoneNumber);
            studentList[checking_Id] = null;
            System.out.println("Member Removed Scuccefully");
            
        }else{
            System.out.println("Id does not exit...");
        }

    }   
    
    //enter as a member;
    public static int memberSinginId =0;
    public static int EnterAsMember(){
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter your PhoneNo: ");
        String Phoneno = sc.nextLine();
        int  i =0;
        
        while(i!=100){
            Student s1 = Student.studentList[i];
            if(s1!=null){
                if(name.equals(s1.Name) && Phoneno.equals(s1.PhoneNumber)){
                    memberSinginId = s1.id;
                    i++;
                    System.out.println("Welcome! " + s1.Name + ". Your user Id " + s1.id);
                    return 1;
                }
                else{
                    i++;
                }

            }else{
                i++;
            }
        }  
        return 0; 
    }   


    //print all book list
    public static void mybookList(){
        Student student_for_Mybooklist = Student.studentList[Student.memberSinginId];
        Book b1 = student_for_Mybooklist.book1Adres;
        Book b2 = student_for_Mybooklist.book2Adres;
        if(b1!=null){
            System.out.println("Book1: " + b1.BookName);
            System.out.println("Book Author: " + b1.AuthorName);
            System.out.println("Book Id " + b1.BookId);
        }
        if(b2!=null){
             System.out.println("Book1: " + b2.BookName);
            System.out.println("Book Author: " + b2.AuthorName);
            System.out.println("Book Id " + b2.BookId);
        }
        if(b2==null && b1 ==null){
            System.out.println("You haven't a book yet...");
        }    
    }

    //fine calcuation
    public static int fine(LocalTime borrowing, LocalTime returning){
        int finetobe =0;
        Duration timetaken = Duration.between(borrowing, returning);
        long timetaken_in_sec = (long)timetaken.getSeconds();
        if(timetaken_in_sec>10){
            finetobe = (int)(timetaken_in_sec -10)*3;
            return finetobe;
        }else{
            return finetobe;
        }
    }
  
    //print all member
    public static void printallmember(){
        int y =0; 
        
        while(y<100){
            Student s = Student.studentList[y];
            if(s!=null){
                System.out.println("-------------------------------------------------------------------------------------------------------------------");
                System.out.println("Name: " + s.Name);
                System.out.println("Member Id : " + s.id);
                System.out.println("Book1: " + s.Book1);
                System.out.println("Book2 " +  s.Book2);
                System.out.println("Fine: " + s.fine);
                
                System.out.println("-------------------------------------------------------------------------------------------------------------------");
                y++;
            }else{
                y++;
            }
            
        }
        return;
    }

    public static void payfine(){
        Student studentWannaPayfine = Student.studentList[Student.memberSinginId];

        if(studentWannaPayfine.fine>0){
            System.out.println("Your due fine: " + studentWannaPayfine.fine );
            System.out.print("Pay your fine : Y/n");
            String Studentresponce = sc.nextLine();
            if(Studentresponce.equals("Y") || Studentresponce.equals("y") ){
                studentWannaPayfine.fine = 0;
                System.out.println("You have paid fine scusfully");
            }else{
                System.out.println("you have due fine ");
            }  
        }else{
            System.out.println("You dont have fine yet...");
        }
    }
    static int idCounter=0;
    Student(String name, String age, String phoneNo){
        this.Name =name;
        this.Age = age;
        this.PhoneNumber = phoneNo;
        this.id = idCounter++;
    }
}
