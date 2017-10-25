/**
 * 
 */
package ma.dph.dsi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.dph.dsi.entity.Person;

/**
 * @author pmishra
 *
 */
public interface PersonRepository extends JpaRepository<Person, Integer>{

	//@Query("SELECT  t.firstName,    t.lastName,    t.suffix,     t.sex,    t.dateOfBirth,     t.createdDate,     t.createdUser,      t.modifyDate,    t.modifyUser  FROM Person t where t.firstName like  %:firstName% ")
	List<Person> findByFirstNameIgnoreCaseContaining(String firstName);
	Person findTopByOrderByFirstNameAsc() ;
	Person findTopByOrderByLastNameAsc() ;
	List<Person> findByLastNameIgnoreCaseContaining(String lasttName);
	Person findById(String  id);
	List<Person> findByDateOfBirth(Date  date); 
	List<Person> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(String firstName, String lastName);  
	
	
}
