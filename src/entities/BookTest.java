package entities;

import static org.junit.Assert.*;

import library.daos.LoanHelper;
import library.daos.LoanMapDAO;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.entities.*;
import org.junit.Test;

public class BookTest {
	
	ILoanDAO loanDAO = new LoanMapDAO(new LoanHelper());
	
	// Main object
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
	
	ILoan loan1 = this.loanDAO.createLoan(member1, book1);
	ILoan loan2 = this.loanDAO.createLoan(member2, book2);
	ILoan loan3 = this.loanDAO.createLoan(member3, book3);
	ILoan loan4 = this.loanDAO.createLoan(member4, book4);
	ILoan loan6 = this.loanDAO.createLoan(member4, book6);
	
	
	@Test
	public void test() {
		
		book1.borrow(loan1);
		book2.borrow(loan2);
		book3.borrow(loan3);
		book4.borrow(loan4);
		book6.borrow(loan6);
			
		assertEquals("author1",book1.getAuthor());
		assertEquals("author2",book2.getAuthor());
		assertEquals("author3",book3.getAuthor());
		assertEquals("author4",book4.getAuthor());
		
		assertEquals("callNo1",book1.getCallNumber());
		assertEquals("callNo2",book2.getCallNumber());
		assertEquals("callNo3",book3.getCallNumber());
		assertEquals("callNo4",book4.getCallNumber());
		
		assertEquals(1,book1.getID());
		assertEquals(2,book2.getID());
		assertEquals(3,book3.getID());
		assertEquals(4,book4.getID());
		
		assertEquals("title1",book1.getTitle());
		assertEquals("title2",book2.getTitle());
		assertEquals("title3",book3.getTitle());
		assertEquals("title4",book4.getTitle());
		
		assertEquals(loan1,book1.getLoan());
		
		//book2.lose();
		//book3.returnBook(true);
		//book4.returnBook(true);
		//book6.returnBook(false);
		//book4.repair();
		
		//book5.dispose();
		book2.dispose();
		//book2.returnBook(false);
		
		System.out.println("Book1 Status: " + book1.getState());
		System.out.println("Book2 Status: " + book2.getState());
		System.out.println("Book3 Status: " + book3.getState());
		System.out.println("Book4 Status: " + book4.getState());
		System.out.println("Book5 Status: " + book5.getState());
		System.out.println("Book6 Status: " + book6.getState());
		
		assertEquals(EBookState.ON_LOAN,book1.getState());
		assertEquals(EBookState.LOST,book2.getState());
		assertEquals(EBookState.DAMAGED,book3.getState());
		assertEquals(EBookState.AVAILABLE,book4.getState());
		assertEquals(EBookState.DISPOSED,book5.getState());
		assertEquals(EBookState.AVAILABLE,book6.getState());
		
	}

}
