package system.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import system.library.model.Book;
import system.library.model.BookItem;
import system.library.model.Location;
import system.library.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
	
	
	
}
