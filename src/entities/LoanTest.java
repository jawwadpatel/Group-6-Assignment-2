package entities;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import library.interfaces.entities.ELoanState;

public class LoanTest {

	
	Loan loan1,loan2,loan3,loan4,loan5;
	
	Book book1 = new Book("author1", "title1", "callNo1", 1);
	Book book2 = new Book("author2", "title2", "callNo2", 2);
	Book book3 = new Book("author3", "title3", "callNo3", 3);
	Book book4 = new Book("author4", "title4", "callNo4", 4);
	Book book5 = new Book("author5", "title5", "callNo5", 5);
	
	Member member1 = new Member("John", "JohnLast", "1234", "email@john.com",1);
	Member member2 = new Member("Sara", "SaraLast", "5678", "email@sara.com",2);
	Member member3 = new Member("Louse", "LouseLast", "9012", "email@Louse.com",3);
	Member member4 = new Member("Louren", "LourenLast", "3456", "email@Louren.com",4);
	
	@Test
	public void test() {
		// set Dates
		Calendar cal = Calendar.getInstance();
		Date borrowDate = new Date();
		Date currentDate = new Date();
		
		cal.setTime(borrowDate);
		cal.setTime(currentDate);
		
		cal.add(5, Loan.LOAN_PERIOD);
		Date returnDate = cal.getTime();
		
		// With normal due date
		loan1 = new Loan(book1, member1, borrowDate, returnDate);
		loan2 = new Loan(book2, member2, borrowDate, returnDate);
		
		// With overdue date
		// set Dates
		
		System.out.println(borrowDate + " : " + returnDate);
		
		borrowDate = new Date();
		cal.setTime(borrowDate);
		cal.add(5, -25);
		borrowDate = cal.getTime();	
		cal.add(5, Loan.LOAN_PERIOD);
		returnDate = cal.getTime();	
		
		System.out.println("borrowDate" + " : " + borrowDate);
		System.out.println("returnDate" + " : " + returnDate);
		
		loan3 = new Loan(book3, member3, borrowDate, returnDate);
		loan4 = new Loan(book4, member4, borrowDate, returnDate);
		
		member1.addLoan(loan1);
		member2.addLoan(loan2);
		member3.addLoan(loan3);
		member4.addLoan(loan4);
		
		System.out.println("Testing getter methods of Loan Object...");
		
		// ELoanState.PENDING
		assertEquals(ELoanState.PENDING,loan1.getState());
		assertEquals(ELoanState.PENDING,loan2.getState());
		assertEquals(ELoanState.PENDING,loan3.getState());
		assertEquals(ELoanState.PENDING,loan4.getState());
		
		loan1.commit(1);
		loan2.commit(2);
		loan3.commit(3);
		loan4.commit(4);
		
		// ELoanState.CURRENT status
		assertEquals(ELoanState.CURRENT,loan1.getState());
		assertEquals(ELoanState.CURRENT,loan2.getState());
		assertEquals(ELoanState.CURRENT,loan3.getState());
		assertEquals(ELoanState.CURRENT,loan4.getState());
		
		assertEquals(book1,loan1.getBook());
		assertEquals(book2,loan2.getBook());
		assertEquals(book3,loan3.getBook());
		assertEquals(book4,loan4.getBook());
		
		// Get loan ID
		assertEquals(1,loan1.getID());
		assertEquals(2,loan2.getID());
		assertEquals(3,loan3.getID());
		assertEquals(4,loan4.getID());
		
		assertEquals(member1,loan1.getBorrower());
		assertEquals(member2,loan2.getBorrower());
		assertEquals(member3,loan3.getBorrower());
		assertEquals(member4,loan4.getBorrower());
		
		
		
		System.out.println("Getter methods test is successful...");
		
		System.out.println("Start - Testing due date...");
		
		/*
		    ELoanState.PENDING
    		ELoanState.CURRENT
    		ELoanState.OVERDUE
    		ELoanState.COMPLETE
		 */
		loan1.checkOverDue(currentDate);
		loan2.checkOverDue(currentDate);
		loan3.checkOverDue(currentDate);
		loan4.checkOverDue(currentDate);
		
		System.out.println("Loan1 isOverDue: " + loan1.isOverDue() + ", status: " + loan1.getState());
		System.out.println("Loan2 isOverDue: " + loan2.isOverDue() + ", status: " + loan2.getState());
		assertEquals(ELoanState.CURRENT,loan1.getState());
		assertEquals(ELoanState.CURRENT,loan2.getState());
		
		System.out.println("Loan3 isOverDue: " + loan3.isOverDue() + ", status: " + loan3.getState());
		System.out.println("Loan4 isOverDue: " + loan4.isOverDue() + ", status: " + loan4.getState());
		assertEquals(ELoanState.OVERDUE,loan3.getState());
		assertEquals(ELoanState.OVERDUE,loan4.getState());
		
		assertEquals(false,loan1.isOverDue());
		assertEquals(false,loan2.isOverDue());
		assertEquals(true,loan3.isOverDue());
		assertEquals(true,loan4.isOverDue());
		
		loan1.getState();
		loan2.getState();
		loan3.getState();
		loan4.getState();
		
		System.out.println("End - Testing due date...");
		
		
		// Status should be CURRENT/OVERDUE
		loan5 = new Loan(book5, member2, borrowDate, returnDate);
		
		// Change status from PENDING to CURRENT
		loan5.commit(5);
		
		System.out.println("Loan5 status: " + loan5.getState());
		
		System.out.println("Checking complete status...");
		
		loan1.complete();
		loan5.complete();
		
		System.out.println(loan1.getState());
		System.out.println(loan5.getState());

		System.out.println("Finished - complete status...");
		
	}

}
