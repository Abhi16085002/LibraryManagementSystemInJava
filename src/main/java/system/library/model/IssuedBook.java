package system.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "IssuedBook")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"bookItem", "user"}  )
public class IssuedBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int issuedBookId;
	@Column(name = "issueDate")
	private Date issueDate;
	@Column(name = "returnDate")
	private Date returnDate;
	@Column(name = "expiryDate")
	private Date expiryDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookItemId")
	private BookItem bookItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;

	public int getIssuedBookId() {
		return issuedBookId;
	}

	public void setIssuedBookId(int issuedBookId) {
		this.issuedBookId = issuedBookId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public BookItem getBookItem() {
		return bookItem;
	}

	public void setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "IssuedBook [issuedBookId=" + issuedBookId + ", issueDate=" + issueDate + ", returnDate=" + returnDate
				+ ", expiryDate=" + expiryDate + "]";
	}
	
	
}
