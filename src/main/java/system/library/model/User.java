package system.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private int userId;
	private String name;
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	private String email;
	@Column(name = "mobileNo")
	private Long mobileNo;
	private String gender;
	
	@Embedded
	private Address address;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@MapsId
//	private UserIdentityCard userIdentityCard;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long i) {
		this.mobileNo = i;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
//	public UserIdentityCard getUserIdentityCard() {
//		return userIdentityCard;
//	}
//	public void setUserIdentityCard(UserIdentityCard userIdentityCard) {
//		this.userIdentityCard = userIdentityCard;
//	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", gender=" + gender + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
}
