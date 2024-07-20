package gurvender;
import java.time.LocalTime;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Book {
    public static Book[] BookList = new Book[1000];
    String BookName;
    String AuthorName;
    int BookId;
    int copyes;
    static int currentCopys;

    static Scanner sc = new Scanner(System.in);


        //checking string can convert in int or not
    public static int safeStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            // Handle the exception gracefully
            System.err.println("Invalid input. Couldn't parse the string to an integer.");
            return -1; // Default value or some other appropriate action
        }
    }

        //adding book
        static int bookCounter =0;
        public static void AddBooks() {
            System.out.print("Enter Book name: ");
            String BookNaam = sc.nextLine();
            System.out.print("Enter the Author name: ");
            String AuhterNaam = sc.nextLine();
            System.out.print("Enter the Number of copies: ");
            String copiesSting = sc.nextLine();
            int copies = safeStringToInt(copiesSting);
            if(copies>0){
                for(int i = 0; i<copies; i++){
                    Book b1 = new Book(BookNaam, AuhterNaam, copies);
                    BookList[bookCounter++] = b1;
                }
            }else{
                System.out.println("wrong input for copies...");
            }
    
        }

        //remmoving book
        public static void removeBook(){
            System.out.print("Enter Book Id: ");
            String StingId = sc.nextLine();
            int checking_Id = safeStringToInt(StingId);

            if(checking_Id>=0 && BookList[checking_Id]!=null){
                Book b1 = BookList[checking_Id];
                System.out.println("Name : " + b1.BookName);
                System.out.println("Member Id : " + b1.BookId);
                BookList[checking_Id] = null;
                System.out.println("Member Removed Scuccefully");
            
            }else{
                System.out.println("Book Id does not exit...");
            }
        }

        //issubook
        public static void issubook(){
            System.out.print("Enter Book Id: ");
            String BookIdString = sc.nextLine();
            System.out.print("Enter book Name: ");
            String bookName = sc.nextLine();
            int checking_Id = safeStringToInt(BookIdString);
            Student s = Student.studentList[Student.memberSinginId];
            if(s.fine>0){
                System.out.println("first Pay your due fine " + s.fine);
            }else{
                if(s.book1Adres==null){
                if(checking_Id>=0 && BookList[checking_Id]!=null && s.book1Adres ==null){
                Book b1 = BookList[checking_Id];
                s.Book1 = b1.BookName;
                s.book1Adres =b1;
                s.book1BorrowTime = LocalTime.now();
                System.out.println("Name : " + b1.BookName);
                System.out.println("Book1 Id : " + b1.BookId);
                BookList[checking_Id] = null;
                System.out.println("Book issued Scuccefully at 1");               

                }else{
                    System.out.println("Book Id does not exit...");
                }
            }else if(s.book2Adres==null){
                    if(checking_Id>=0 && BookList[checking_Id]!=null && s.book2Adres ==null){
                        Book b1 = BookList[checking_Id];
                        s.Book1 = b1.BookName;
                        s.book2Adres = b1;
                        s.book2BorrowTime = LocalTime.now();
                        System.out.println("Name : " + b1.BookName);
                        System.out.println("Member Id : " + b1.BookId);
                        BookList[checking_Id] = null;
                        System.out.println("Book issued Scuccefully at 2");
                    }else{
                        System.out.println("Book Id does not exit...");
                    }

            }else{
                System.out.println("You already have borrowed 2 book ");
                System.out.println("return a book first to issue another book ");
                }
            }
        }

        //returnBook
        public static void returnBook(){
            System.out.print("Enter Book Id: ");
            String BookIdString = sc.nextLine();
            System.out.print("Enter book Name: ");
            String bookName = sc.nextLine();
            int checking_Id = safeStringToInt(BookIdString);
            Student s = Student.studentList[Student.memberSinginId];
            if(checking_Id>=0 && BookList[checking_Id]==null){
                if(s.Book1!=null && s.Book1.equals(bookName)==true){
                    BookList[checking_Id] = s.book1Adres;
                    s.book1ReturnTime = LocalTime.now();
                    System.out.println(s.Book1+ " return successfully");
                    s.Book1 = null;
                    s.book1Adres =null;
                    s.fine = s.fine + Student.fine(s.book1BorrowTime, s.book1ReturnTime);
                    

                }else if(s.Book2!=null && s.Book2.equals(bookName)==true){
                    BookList[checking_Id] = s.book2Adres;
                    s.book2ReturnTime = LocalTime.now();
                    System.out.println(s.Book2+ " return successfully");
                    s.Book2 =null;
                    s.book2Adres = null;
                    s.fine = s.fine + Student.fine(s.book2BorrowTime, s.book2ReturnTime);
                }else{
                    System.out.println("book id does not match with student Borrowing books");
                }
                
            }else{
                System.out.println("Wrong Book Id ");
            }
        }

        //print all Books
        public static void printAllbook(){
            int x =0;
            
            while(x<1000==true){
                Book booktoPrint = Book.BookList[x];
                if(booktoPrint!=null){
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                System.out.println("Book Name : " + booktoPrint.BookName);
                System.out.println("Book Author : " + booktoPrint.AuthorName);
                System.out.println("Book Id : " + booktoPrint.BookId);
                System.out.println("Copies :  " + booktoPrint.copyes);
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                x++;
                }else{
                    x++;
                }
            
            }   
        }   
       
        //book constructor
        static  int  bookIdCounter=0;
        public Book(String bkname, String Authername,int copys){
            this.BookName = bkname;
            this.AuthorName = Authername;
            this.BookId = bookIdCounter++;
            this.copyes = copys;
            
            System.out.println("succefully added the book with Book Id " + this.BookId);

        }
}
