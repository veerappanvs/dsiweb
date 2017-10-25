/**
 * 
 */
package ma.dph.dsi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ma.dph.dsi.entity.Inventory;


/**
 * @author vsubramaniyan
 *
 */

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	//@Query("SELECT  t.firstName,    t.lastName,    t.suffix,     t.sex,    t.dateOfBirth,     t.createdDate,     t.createdUser,      t.modifyDate,    t.modifyUser  FROM Person t where t.firstName like  %:firstName% ")
	List<Inventory> findByBureauIgnoreCaseContaining(String Bureau);
	//Inventory findTopByOrderByBureauOrOfficeAsc() ;
	//Inventory findTopByOrderByApplication_NameAsc() ;
	List<Inventory> findByAppNameIgnoreCaseContaining(String ApplicationName);
	List<Inventory> findByAppAcronymIgnoreCaseContaining(String AppAcronym);
	List<Inventory> findByAppAcronymIgnoreCaseContainingOrAppNameIgnoreCaseContainingOrBureauIgnoreCaseContaining(String appAcronym, String appName, String bureau);  
	
	
}
