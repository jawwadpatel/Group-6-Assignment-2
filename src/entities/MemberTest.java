package entities;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import library.daos.LoanHelper;
import library.daos.LoanMapDAO;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.entities.EBookState;
import library.interfaces.entities.EMemberState;
import library.interfaces.entities.ILoan;

public class MemberTest {

	ILoanDAO loanDAO = new LoanMapDAO(new LoanHelper());
	
	Book book1 = new Book("author1", "title1", "callNo1", 1);
	Book book2 = new Book("author2", "title2", "callNo2", 2);
	Book book3 = new Book("author3", "title3", "callNo3", 3);
	Book book4 = new Book("author4", "title4", "callNo4", 4);
	Book book5 = new Book("author5", "title5", "callNo5", 5);
	Book book6 = new Book("author6", "title6", "callNo6", 6);
	
	Member member1 = new Member("John", "JohnLast", "1234", "email@john.com",1);
	Member member2 = new Member("Sara", "SaraLast", "5678", "email@sara.com",2);
	Member member3 = new Member("Louse", "LouseLast", "9012", "email@Louse.com",3);
	Member member4 = new Member("Louren", "LourenLast", "3456", "email@Louren.com",4);
	
	
	Loan loan1,loan2,loan3,loan4,loan5,loan6;
	//ILoan loan1 = this.loanDAO.createLoan(member1, book1);
	//ILoan loan2 = this.loanDAO.createLoan(member2, book2);
//	ILoan loan3 = this.loanDAO.createLoan(member3, book3);
//	ILoan loan4 = this.loanDAO.createLoan(member4, book4);
		
	
	@Test
	public void test() {
		        
		System.out.println("Step 1 to 6...");
		assertEquals(1,member1.getID());
		assertEquals(2,member2.getID());
		assertEquals(3,member3.getID());
		assertEquals(4,member4.getID());
		
		assertEquals("John",member1.getFirstName());
		assertEquals("Sara",member2.getFirstName());
		assertEquals("Louse",member3.getFirstName());
		assertEquals("Louren",member4.getFirstName());
		
		assertEquals("JohnLast",member1.getLastName());
		assertEquals("SaraLast",member2.getLastName());
		assertEquals("LouseLast",member3.getLastName());
		assertEquals("LourenLast",member4.getLastName());
		
		assertEquals("1234",member1.getContactPhone());
		assertEquals("5678",member2.getContactPhone());
		assertEquals("9012",member3.getContactPhone());
		assertEquals("3456",member4.getContactPhone());
		
		assertEquals("email@john.com",member1.getEmailAddress());
		assertEquals("email@sara.com",member2.getEmailAddress());
		assertEquals("email@Louse.com",member3.getEmailAddress());
		assertEquals("email@Louren.com",member4.getEmailAddress());
		
		System.out.println("Step 1 to 6 are successful...");
		
		// set Dates
		Calendar cal = Calendar.getInstance();
		Date borrowDate = new Date();
		cal.setTime(borrowDate);
        cal.add(5, Loan.LOAN_PERIOD);
        Date dueDate = cal.getTime();
        
        System.out.println("Start assign books to a member");
		loan1 = new Loan(book1,member1,borrowDate,borrowDate);
//		loan2 = new Loan(book1,member1,borrowDate,borrowDate);
		loan2 = new Loan(book2,member1,borrowDate,borrowDate);
		loan3 = new Loan(book3,member1,borrowDate,borrowDate);
		loan4 = new Loan(book4,member1,borrowDate,borrowDate);
		loan5 = new Loan(book5,member1,borrowDate,borrowDate);
		loan6 = new Loan(book6,member1,borrowDate,borrowDate);
		
		List<ILoan> loanList = new ArrayList<ILoan>();
		  
		book1.borrow(loan1);
		book2.borrow(loan2);
		book3.borrow(loan3);
		book4.borrow(loan4);
		
		member1.addLoan(loan1);
		member1.addLoan(loan2);
		member1.addLoan(loan3);
		member1.addLoan(loan4);
		
		loanList.add(loan1);
	    // Adding a correct object to list
	    //loan2 = new Loan(book2,member1,borrowDate,borrowDate);
	    loanList.add(loan2);
	    loanList.add(loan3);
	    loanList.add(loan4);
	    
	    assertEquals(loanList,member1.getLoans());
	    System.out.println("Assign books was successful.");
	    
	    System.out.println("Member stat: " + member1.getState());
	    assertEquals(EMemberState.BORROWING_ALLOWED,member1.getState());
	    
	    float fineAmt = 5.5f;
	    
		member1.addFine(fineAmt);
		
		System.out.println("Current fine: " + member1.getFineAmount());		
		assertEquals(fineAmt,member1.getFineAmount(),0.0);
		
		System.out.println("hasReachedFineLimit(>10): " + member1.hasReachedFineLimit());
		assertEquals(false,member1.hasReachedFineLimit());
		
		// Increase fine to reach the limit	
		
		System.out.println("Increase the fine by two");
		fineAmt*=2;
		
		System.out.println(fineAmt);
		
		member1.addFine(fineAmt);
		
		System.out.println("hasReachedFineLimit(>10): " + member1.hasReachedFineLimit());
		assertEquals(true,member1.hasReachedFineLimit());
		
		//Number of books can be loaned LOAN_PERIOD = 14
		//System.out.println(member1.hasOverDueLoans());
		
		System.out.println("Has memeber any fine to pay? " + member1.hasFinesPayable());
		assertEquals(true,member1.hasFinesPayable());
		
		System.out.println("What is the amount(5.5 + 11.0)?" + member1.getFineAmount());
		assertEquals(16.5,member1.getFineAmount(),0.0);
		
		System.out.println("Pay partial amount(11.0)");
		
		member1.payFine(fineAmt);
		
		System.out.println("Outstanding balance after payment: " + member1.getFineAmount());
		assertEquals(5.5,member1.getFineAmount(),0.0);
		
		System.out.println("Pay remaining outstanding amount(5.5).");
		
		member1.payFine(member1.getFineAmount());
		
		System.out.println("Outstanding balance after complete settlement: " + member1.getFineAmount());
		assertEquals(0.0,member1.getFineAmount(),0.0);
		
		System.out.println("Has memeber any fine to pay? " + member1.hasFinesPayable());
		assertEquals(false,member1.hasFinesPayable());
				
		// Testing member status:BORROWING_DISALLOWED
		// Due date should be +14 of borrow date
		// Number of loans should exceed 4 loans
		// Fine exceeds 10.0
		// Any of above conditions is met, then status should be BORROWING_DISALLOWED
		
		
		// Condition1: Fine exceeds 10.0
		member1.addFine(1000.0f);
		
		System.out.println("Condition-fine exceeds 10.0." +
						"Status of member is: " + member1.getState());
		assertEquals(EMemberState.BORROWING_DISALLOWED,member1.getState());
		
		// Reverse Condition1
		System.out.println("Reverse Condition1...");
		member1.payFine(1000.0f);
		
		// Condition2: Due date exceeds +14 after borrow date
		// Put program on standby and change the system date to +14 day of current date
		
		System.out.println("Start Condition2...");
		
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Change system's date to +14.");
//		scanner.next();
//		
//		System.out.println("Date has changed, but still overdue flag is unset: " + 
//		loan2.isOverDue() +", \n Moreover, it allows loaning more books, while it shouldn't");
		//assertEquals(EMemberState.BORROWING_DISALLOWED,member1.getState());		
//		
		// Uncomment code above for Condition 2

		System.out.println("Condition 2 has succeful.");
        
		
		System.out.println("Start Condition3 - Max number of loans is 5.");
		
		book5.borrow(loan5);
		member1.addLoan(loan5);
		loanList.add(loan5);
		
		System.out.println("Member reached MAX borrowing book? " + member1.hasReachedLoanLimit());
		assertEquals(true,member1.hasReachedLoanLimit());
		
		System.out.println("User status after MAX borrowing reached: " + member1.getState());
		assertEquals(EMemberState.BORROWING_DISALLOWED,member1.getState());
		
		System.out.println("Condition 3 is successful.");

		// Memeber returns book1 which is loan 1
		System.out.println("Memeber returns book1 which is loan1 object");
		member1.removeLoan(loan1);
				
		// List all the loans member1 has
		// Validate member1 loans
		loanList.remove(loan1);
		assertEquals(loanList,member1.getLoans());
		
	}

}
