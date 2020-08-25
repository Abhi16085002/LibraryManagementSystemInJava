package system.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import system.library.model.UserIdentityCard;
@Repository
public interface UserIdentitycardRepository extends JpaRepository<UserIdentityCard, Integer> {

	@Query("update UserIdentityCard d set d.fine = d.fine + :amount where d.userIdentityCardId = :userId ")
	void updateBalance(@Param("userId") int userId, @Param("amount") double amount);
		
	@Query("update UserIdentityCard d set d.fine = d.fine - :fineAmount where d.userIdentityCardId = :userId ")
	void updateFine(@Param("userId") int userId, double fineAmount);
	
	
	
}
