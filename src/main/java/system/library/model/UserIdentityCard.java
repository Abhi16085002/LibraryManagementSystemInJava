package system.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserIdentityCard")
public class UserIdentityCard {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "userIdentityCardId")
	private int userIdentityCardId;
	private String password;
	@Column(name = "maxBookCanBeIssue")
	private int maxBookCanBeIssue;
	@Column(name = "maxLendingDay")
	private int maxLendingDay;
	private double fine;
	private double balance;
	@Column(name = "expiryDateOfCard")
	private Date expiryDateOfCard;
	private String status;
	private String role;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
//	@MapsId
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserIdentityCardId() {
		return userIdentityCardId;
	}
	public void setUserIdentityCardId(int userIdentityCardId) {
		this.userIdentityCardId = userIdentityCardId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getExpiryDateOfCard() {
		return expiryDateOfCard;
	}
	public void setExpiryDateOfCard(Date expiryDateOfCard) {
		this.expiryDateOfCard = expiryDateOfCard;
	}
	public int getMaxBookCanBeIssue() {
		return maxBookCanBeIssue;
	}
	public void setMaxBookCanBeIssue(int maxBookCanBeIssue) {
		this.maxBookCanBeIssue = maxBookCanBeIssue;
	}
	public int getMaxLendingDay() {
		return maxLendingDay;
	}
	public void setMaxLendingDay(int maxLendingDay) {
		this.maxLendingDay = maxLendingDay;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserIdentityCard [userIdentityCardId=" + userIdentityCardId + ", password=" + password
				+ ", maxBookCanBeIssue=" + maxBookCanBeIssue + ", maxLendingDay=" + maxLendingDay + ", fine=" + fine
				+ ", balance=" + balance + ", expiryDateOfCard=" + expiryDateOfCard + ", status=" + status + ", Role="
				+ role + "]";
	}
	
}