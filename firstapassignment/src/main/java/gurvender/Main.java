package gurvender;
import java.util.Scanner;

public class Main{
    static void welcomeMemeber() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. List Available Books: ");
        System.out.println("2. List My Books");
        System.out.println("3. Issue book");
        System.out.println("4. Return book");
        System.out.println("5. Pay Fine");
        System.out.println("6. exit");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
    }

    static void welcomeLibarina() {
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. Register a member: ");
        System.out.println("2. Remove a member: ");
        System.out.println("3. Add a book: ");
        System.out.println("4. Remove a book: ");
        System.out.println("5. View all members along with their books and fines to be paid ");
        System.out.println("6. View all books");
        System.out.println("7. Back");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------");
    }

    static void welcome() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Library Portal: ");
        System.out.println("1. Enter as Librarian: ");
        System.out.println("2. Enter as memeber: ");
        System.out.println("3. Exit: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // static Scanner sc = new Scanner(System.in);
    
    //enter as amember


    public static void main(String[] args) {
        int x = 1;
        while (x == 1) {
            welcome();
            System.out.print("Input : ");
            Scanner sc = new Scanner(System.in);
            String responce = sc.nextLine();
            switch (responce) {
                // 1. Enter as Librarian:
                case "1":
                    int rx = 1;
                    while (rx == 1) {
                        welcomeLibarina();
                        System.out.print("Input : ");
                        String resLib = sc.nextLine();
                        // sc.nextLine();
                        switch (resLib) {
                            // 1. Register a member:
                            case "1":
                                Student.registerMember();
                                break;
                                
                            // 2. Remove a member:
                            case "2":
                                Student.reoveMember();
                                break;

                            // 3. Add a book:
                            case "3":
                                Book.AddBooks();
                                break;

                            // 4. Remove a book:
                            case "4":
                                Book.removeBook();
                                // System.out.println(" ");
                                break;
                            // View all members along with their books and fines to be paid
                            case "5":
                        
                                Student.printallmember();

                                // System.out.println("Implimented succefully")
                                break;
                            // 6. View all books
                            case "6":
                                System.out.println("List of books: ");
                                Book.printAllbook();

                                break;
                            // 7. Back
                            case "7":
                                rx++;
                                break;

                            default:
                                System.out.println("Wrong input... ");
                                break;
                        }
                    }
                    break;
                // 2. Enter as memeber:
                case "2":
                    int Loyal_member = Student.EnterAsMember();
                    if(Loyal_member ==1){
                        int ms = 1;
                        while (ms == 1) {
                        welcomeMemeber();
                        System.out.print("Input: ");
                        String memResp = sc.nextLine();
                        switch (memResp) {
                            // 1. List Available Books
                            case "1":
                                Book.printAllbook();
                                System.out.println();
                                break;
                            // 2. List My Books
                            case "2":
                                Student.mybookList();
                                // System.out.println("need to implenet");3
                                break;
                            // 3. Issue book
                            case "3":
                                Book.issubook();
                                System.out.println();
                                break;

                            // 4. Return book
                            case "4":
                                Book.returnBook();
                                System.out.println();
                                break;
                            // 5. Pay fine
                            case "5":
                                Student.payfine();
                                // System.out.println();
                                break;
                            // 6. break
                            case "6":
                                ms++;
                                // System.out.println();
                                break;
                            default:
                                System.out.println("Wrong input given ");
                                break;
                            }
                        }
                        break;

                    }else if (Loyal_member ==0){
                        System.out.println("Invalid id or phone number:");
                        break;
                    }else{
                        System.out.println("Something is wrong");
                    }
                 

                // 3. to exit
                case "3":
                    x++;
                    System.out.println("Thank you visiting ");
                    break;
                default:
                    System.out.println("Wrong intput ");
                    break;
            }

        }
    }
}
