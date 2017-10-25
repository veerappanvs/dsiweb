package ma.dph.dsi.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ma.dph.dsi.entity.Inventory;
import ma.dph.dsi.repository.InventoryRepository;




@RestController
@RequestMapping(path = "/inv")
public class InventoryRestController {

	   static Logger log = Logger.getLogger(InventoryRestController.class.getName());

	
    @Autowired
    private InventoryRepository service;
        
    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public ResponseEntity<List<Inventory>> listAllApplications() {
        List<Inventory> inventories = service.findAll();
        if(inventories.isEmpty()){
            return new ResponseEntity<List<Inventory>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Inventory>>(inventories, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Inventory> findByAppNameById(@PathVariable("id") String id) {

      	Inventory  inventory = service.findOne(Integer.valueOf(id));
      
        if( inventory == null){
            return new ResponseEntity<Inventory>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
    }
    
    
    
    
    @RequestMapping(value = "/inventory/get", params = { "name"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Inventory>> findByAppNameOrAppAcronymOrBureau(@RequestParam("name") String name) {

        List<Inventory>  inventoryAll = service.findByAppAcronymIgnoreCaseContainingOrAppNameIgnoreCaseContainingOrBureauIgnoreCaseContaining(name, name, name); 
      
        if( inventoryAll == null){
            return new ResponseEntity<List<Inventory>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Inventory>>(inventoryAll, HttpStatus.OK);
    }
    
    
    //@RequestMapping(value = "/inventory/", method = RequestMethod.POST)
    @PostMapping(value = "/inventory")
    public ResponseEntity<?> createInventory(@RequestBody Inventory inventory, UriComponentsBuilder ucBuilder) {
    	
        log.debug("Creating inventory :------ "+ inventory);
 
        if (inventory != null  && service.findByAppNameIgnoreCaseContaining(inventory.getAppName()).size() > 0  ) {
            log.error("Unable to create  Application with name" +   inventory.getAppName() + " already exist.");
            return new ResponseEntity<String>(("Unable to create  Application with name " +   inventory.getAppName() + " already exist."),HttpStatus.CONFLICT);
        }
        service.saveAndFlush(inventory);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(inventory.getId()).toUri());
        log.debug("Created Application Succesfully:------ "+ headers.getLocation());
        
        return new ResponseEntity<Inventory>(inventory, HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/inventory")
    public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory, UriComponentsBuilder ucBuilder) {
    	
        log.debug("Updating inventory :------ "+ inventory);
 
        if ( service.findOne(inventory.getId()) == null  ) {
        	log.error("Unable to update Application. Application "+ inventory.getAppName()+" not found.");
            return new ResponseEntity<String>(("Unable to update Application. Application "+ inventory.getAppName()+" not found."),HttpStatus.CONFLICT);
        }
        service.saveAndFlush(inventory);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(inventory.getId()).toUri());
        log.debug("Updated Application Succesfully:------ "+ headers.getLocation()); 
        return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
    }
    
    
    @DeleteMapping(value = "/inventory{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable("id") String id) {
    	
        log.debug("Deleting inventory :------ "+ id);
        Inventory inventory =  service.findOne(Integer.valueOf(id));
        if ( inventory != null ) {
        	log.error("Unable to Delete application. Application "+ inventory.getAppName()+" not found.");
            return new ResponseEntity<String>(("Unable to delete Application. Application "+ inventory.getAppName()+" not found."),HttpStatus.CONFLICT);
        }
        service.delete(inventory);
 
       // HttpHeaders headers = new HttpHeaders();
      //  headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(inventory.getId()).toUri());
        log.debug("Deleted Application Succesfully:------ "); 
        return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
    }



    
    
    
    /*    @RequestMapping(value = "/inventory/gettwo",  method = RequestMethod.GET, produces = "application/json")
   public ResponseEntity<List<Inventory>> findFirstByOrderByFirstNameIgnoreCaseContaining() {

    	Inventory  invetory1 = service.findTopByOrderByBureauOrOfficeAsc();  
    	Inventory  inventory2 = service.findTopByOrderByApplication_NameAsc();
        List<Inventory>  inventories = new ArrayList<Inventory>();
        inventories.add(invetory1);
        inventories.add(inventory2);
        if( invetory1 == null && inventory2 == null){
            return new ResponseEntity<List<Inventory>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Inventory>>(inventories, HttpStatus.OK);
    }
    
    
 */   @RequestMapping(value = "/inventory/getoneaslist", params = { "id" }, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Inventory>> findByIdAsList(@RequestParam("id") String id) {

    	Inventory person = service.findOne(Integer.valueOf(id));
        
        if(person == null){
            return new ResponseEntity<List<Inventory>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        List<Inventory>  persons = new ArrayList<Inventory>();
        persons.add(person);
        return new ResponseEntity<List<Inventory>>(persons, HttpStatus.OK); 
    }
    
    
    @RequestMapping(value = "/inventory/getone", params = { "id" }, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Inventory> findById(@RequestParam("id") String id) {

    	Inventory inventory = service.findOne(Integer.valueOf(id));
        
        if(inventory == null){
            return new ResponseEntity<Inventory>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
 
        return new ResponseEntity<Inventory>(inventory, HttpStatus.OK); 
    }
    
    @RequestMapping(value = "/inventory/get", params = { "appAcronym"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Inventory>> findByBureauOrOfficeorAppName(@RequestParam("appAcronym") String appAcronym) {

        List<Inventory>  inventoryAll = service.findByAppAcronymIgnoreCaseContaining(appAcronym); 
      
        if( inventoryAll == null){
            return new ResponseEntity<List<Inventory>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Inventory>>(inventoryAll, HttpStatus.OK);
    }
    
    
      

}