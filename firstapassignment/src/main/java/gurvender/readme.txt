Library Management System:

there is main three classes: 
1) main classe
2) Student class
3) Book class

#main class
This is a simple command-line Library Management System implemented in Java. It allows librarians to manage members, books, and fines, and members to browse and borrow books.

Features

Main Class (Main.java)
Librarian Features
Register a member
Remove a member
Add a book
Remove a book
View all members along with their books and fines
View all books
Member Features
List available books
List owned books
Issue a book
Return a book
Pay fines

here i used to swtich cases to move to diffrent opetion provided in the manu: o


Book Class (Book.java)
Maintains information about books, including their name, author, ID, and copies.
Provides methods to add, remove, issue, and return books.
Tracks book borrowing and return times.
Displays a list of all available books.
Student Class (Student.java)
Manages member information, including name, age, phone number, and book borrowing.
Allows members to register, sign in, view their book list, pay fines, and more.
Usage
Compile the Java program:


You will be prompted to enter as a Librarian or Member. Choose the appropriate option by entering '1' or '2'.

Librarian
Choose the librarian option and perform librarian-specific actions as described in the menu.
Member
To enter as a member, you'll need to provide your member credentials (e.g., ID or phone number) to access member-specific actions. If the credentials are valid, you can perform member-specific actions as described in the menu.
To exit the program, choose option '3' from the main menu.
Implementation Notes
The system ensures that members provide valid credentials to access member-specific actions.
Librarians can manage members and books, while members can browse, borrow, return books, and pay fines.
Fines are calculated based on the return time of borrowed books.