/**
 * 
 */
package ma.dph.dsi.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author pmishra
 *
 */
@Entity(name = "Person")
public class Person {

	@Id
	@Column(name = "ID")
	private String id;
	// private Integer id;



	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name="Suffix")
	private String suffix;
	
	
	
	@Column(name="Sex")
	private String sex;

	@Column(name = "Birth_Date")
	private Date dateOfBirth;

	@Column(name = "Create_Date")
	private Date createdDate;
	
	@Column(name = "Modify_Date")
	private Date modifiedDate;
	
	@Column(name="Modify_User")
	private String modifyuser;
		
	@Column(name="Create_User")
	private String createduser;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifyuser() {
		return modifyuser;
	}

	public void setModifyuser(String modifyuser) {
		this.modifyuser = modifyuser;
	}

	public String getCreateduser() {
		return createduser;
	}

	public void setCreateduser(String createduser) {
		this.createduser = createduser;
	}
	

	public String getSex() {

		switch ((this.sex != null) ? this.sex : "") {
		case "1":
			this.sex = "Male";
			break;
		case "2":
			this.sex = "Female";
			break;
		default:
			this.sex = "";
			break;
		}
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public static int calculateAge(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}

	public static String calculateAgeInYearMonth(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();
		if ((birthDate != null) && (currentDate != null)) {
			return "" + Period.between(birthDate, currentDate).getYears() + " Y " + Period.between(birthDate, currentDate).getMonths() + " M ";
		} else {
			return "";
		}
	}
	/**
	 * 
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((createduser == null) ? 0 : createduser.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + ((modifyuser == null) ? 0 : modifyuser.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (createduser == null) {
			if (other.createduser != null)
				return false;
		} else if (!createduser.equals(other.createduser))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (modifyuser == null) {
			if (other.modifyuser != null)
				return false;
		} else if (!modifyuser.equals(other.modifyuser))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person2 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", suffix=" + suffix
				+ ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", modifyuser=" + modifyuser + ", createduser=" + createduser + "]";
	}

}
