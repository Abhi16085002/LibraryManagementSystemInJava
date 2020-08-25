package system.library.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.library.enumurated.BookItemStatus;
import system.library.enumurated.IdentityCardStatus;
import system.library.enumurated.Role;
import system.library.model.Address;
import system.library.model.Book;
import system.library.model.BookItem;
import system.library.model.IssuedBook;
import system.library.model.Location;
import system.library.model.User;
import system.library.model.UserIdentityCard;
import system.library.repository.BookItemRepository;
import system.library.repository.BookRepository;
import system.library.repository.IssuedBookRepository;
import system.library.repository.UserIdentitycardRepository;
import system.library.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookItemRepository bookItemRepository;
	@Autowired
	private UserIdentitycardRepository userIdentitycardRepository;
	@Autowired
	private IssuedBookRepository issuedBookRepository;
	
	@Override
	public void fun() {
		
		Address address = new Address();
		address.setCity("patna");
		address.setCountry("india");
		address.setHouseNo(12);
		address.setPinCode(81L);
		address.setState("Bihar");
		address.setStreet("hello");
		
		User user = new User();
		user.setName("hello there");
		user.setMobileNo( 8512828343L);
		user.setDateOfBirth(new Date());
		user.setAddress(address);
		System.out.println("before saved");
		userRepository.save(user);
		System.out.println("user id is :-  "+ user.getUserId());
		System.out.println(user);
		
		UserIdentityCard userIdentityCard = new UserIdentityCard();
		userIdentityCard.setBalance(15);
		userIdentityCard.setFine(20);
		userIdentityCard.setMaxBookCanBeIssue(5);
		userIdentityCard.setUser(user);
		userIdentityCard.setUserIdentityCardId(user.getUserId());
		userIdentityCard.setStatus(IdentityCardStatus.ACTIVE.name());
		userIdentityCard.setRole(Role.MEMBER.name());
		System.out.println(userIdentityCard.toString());
		userIdentitycardRepository.save(userIdentityCard);
		System.out.println(" ");
		
		Book book = new Book();
		book.setToalItem(5);
		book.setTitle("HarryPotter");
		book.setAvailableItem(2);
		book.setNoOfPages(200);
		book.setPublisher("hello there");
		book.setSubject("fiction");
		book.setISBN("dczxxbjkbsdc");
		System.out.println(book.toString());
		bookRepository.save(book);
		System.out.println(" ");
		
		
		BookItem bookItem = new BookItem();
		bookItem.setBook(book);
		bookItem.setEdition(3);
		bookItem.setFine(12);
		bookItem.setFormat("format");
		bookItem.setLanguage("hindi");
		bookItem.setLoaction(null);
		bookItem.setPrice(25);
		bookItem.setStatus(BookItemStatus.AVAILABLE.name());
		System.out.println(bookItem);
		bookItemRepository.save(bookItem);
		System.out.println(" ");
		
		IssuedBook issuedBook = new IssuedBook();
		issuedBook.setBookItem(bookItem);
		issuedBook.setUser(user);
		issuedBook.setIssueDate(new Date());
		System.out.println(issuedBook);
		issuedBookRepository.save(issuedBook);
		
		System.out.println("afterSaved");
	}

	@Override
	public void fun2() {
		UserIdentityCard userIdentityCard = new UserIdentityCard();
		userIdentityCard.setBalance(15);
		userIdentityCard.setFine(20);
		userIdentityCard.setMaxBookCanBeIssue(5);
//		userIdentityCard.setUser(user);
	}
	
	@Override
	public List<Book> findAllBookByTitle(String title) {
		return bookRepository.findAllByTitle(title);
	}

	@Override
	public List<Book> findBookByISBN(String ISBN) {
		return bookRepository.findAllByISBN(ISBN);
	}

	@Override
	public List<Book> findBookBySubject(String subject) {
		return bookRepository.findAllBySubject(subject);
	}

//	@Override
//	public List<BookItem> findBookByAuthor(String author) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Location findBookItemLocation(int bookItemId) {
		BookItem bookItem = viewBookItem(bookItemId);
		return bookItem.getLoaction();
	}

	@Override
	public BookItem checkOutBookItem(int bookItemId, int userId) {
		IssuedBook issuedBook = new IssuedBook();
		issuedBook.setExpiryDate(new Date());
		issuedBook.setIssueDate(new Date());
		issuedBook.setReturnDate(new Date());
		issuedBook.setUser(findUserByUserId(userId));
		changeBookItemStatus(bookItemId, BookItemStatus.CHECKOUT.name());
		BookItem bookItem = viewBookItem(bookItemId);
		issuedBook.setBookItem(bookItem);
		issuedBookRepository.save(issuedBook);
		return bookItem;
	}

	@Override
	public BookItem viewBookItem(int bookItemId) {
		return bookItemRepository.findById(bookItemId).get();
	}

	@Override
	public String checkBookItemStatus(int bookItemId) {
		return bookItemRepository.findStatusByBookItemId(bookItemId);
	}

	@Override
	public List<IssuedBook> findAllIssuedBookByUserId(int userId) {
		User user = findUserByUserId(userId);
		return issuedBookRepository.findAllByUser(user);
	}

	@Override
	public User findUserByUserId(int userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public void cancelMembership(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public UserIdentityCard issueUserIdentityCard(int userId, String password) {
		User user = userRepository.findById(userId).get();
		UserIdentityCard userIdentityCard = new UserIdentityCard();
		userIdentityCard.setUser(user);
		userIdentityCard.setUserIdentityCardId(userId);
		userIdentityCard.setBalance(0);
		userIdentityCard.setPassword(password);
		return userIdentitycardRepository.save(userIdentityCard);
	}

	@Override
	public void payFine(int userId, double fineAmount) {
		userIdentitycardRepository.updateFine(userId,fineAmount);
	}

	@Override
	public void addBalance(int userId, double amount) {
		userIdentitycardRepository.updateBalance(userId,amount);
	}

	@Override
	public IssuedBook issueBookItem(int bookItemId, int userId) {
		IssuedBook issuedBook = new IssuedBook();
		changeBookItemStatus(bookItemId, BookItemStatus.BORROW.name());
		BookItem bookItem = bookItemRepository.findById(bookItemId).get();
		User user = userRepository.findById(userId).get();
		issuedBook.setBookItem(bookItem);
		issuedBook.setUser(user);
		issuedBook.setIssueDate(new Date());
		return issuedBookRepository.save(issuedBook);
	}

	@Override
	public void returnBookItem(int bookItemId, int userid) {
		changeBookItemStatus(bookItemId, BookItemStatus.AVAILABLE.name());
	}

	@Override
	public BookItem saveBookItem(BookItem bookItem) {
		return bookItemRepository.save(bookItem);
	}

	@Override
	public BookItem updateBookItem(BookItem bookItem) {
		return saveBookItem(bookItem);
	}

	@Override
	public List<IssuedBook> findAllIssuedBook() {
		return issuedBookRepository.findAll();
	}

	@Override
	public void changeBookItemStatus(int bookItemId,String status) {
//		BookItem bookItem = viewBookItem(bookItemId);
//		bookItem.setStatus(status);
//		saveBookItem(bookItem);
//		status = BookItemStatus.LOST.name();
		bookItemRepository.updateStatus(bookItemId, status);
	}
	
	
	
	
	
}
