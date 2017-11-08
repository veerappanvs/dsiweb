/**
 * 
 */
package ma.dph.dsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dph.dsi.entity.User;


/**
 * @author vsubramaniyan
 *
 */

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
}
