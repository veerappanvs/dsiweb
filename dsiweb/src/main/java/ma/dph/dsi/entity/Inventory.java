/**
 * 
 */
package ma.dph.dsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author vsubramaniyan
 *
 */
@Entity(name = "Inventory") 
public class Inventory {


		@Id
		@Column(name = "App_Id") 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		Integer id;
		
		@Column(name = "Bureau") 
		String bureau;
		
		@Column(name= "Application_Name")
		String appName;
		
		@Column(name= "App_Acronym")
		String appAcronym;
		
		@Column(name= "Data_Owner")
		String dataOwner;
		
		@Column(name= "Business_Application_Owner")
		String businessApplicationOwner;
		
		@Column(name= "Technical_Support_Lead")
		String technicalSupportLead;
		
		@Column(name= "IT_Program_Manager")
		String iTProgramManager;
		
		@Column(name= "Vendor")
		String vendor;
		
		@Column(name= "Web_Application_Yes_Or_No")
		String webApplicationYesOrNo;
		
		@Column(name= "Access_Database_Y_Or_N")
		String accessDatabaseYOrN;
		
		@Column(name= "Non_Access_Database_Type")
		String nonAccessDatabaseType;
		
		@Column(name= "Mission_Critical")
		String missionCritical;
		
		@Column(name= "Inidcator504")
		String inidcator504;
		
		@Column(name= "Data_Classification")
		String dataClassification;
		
		@Column(name= "Active_Ind")
		String activeInd;
		
		@Column(name= "App_Description")
		String appDescription;
		
		@Column(name= "Requires_24x7_Support")
		String requires24x7Support;
		
		@Column(name= "Audience")
		String audience;
		
		@Column(name= "Number_of_Users")
		String numberOfUsers;
		
		@Column(name= "Contact_person")
		String contactPerson;
		
		@Column(name= "Server_Details")
		String serverDetails;
		
		@Column(name= "Physical_Location")
		String physicalLocation;
		
		@Column(name= "Platform")
		String platform;
		
		@Column(name= "Platform_notes")
		String platformnotes;
		
		@Column(name= "Bureau_Application_Notes")
		String bureauApplicationNotes;

		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * @return the bureauOrOffice
		 */
		public String getBureau() {
			return bureau;
		}

		/**
		 * @param bureauOrOffice the bureauOrOffice to set
		 */
		public void setBureau(String bureau) {
			this.bureau = bureau;
		}

		/**
		 * @return the appName
		 */
		public String getAppName() {
			return appName;
		}

		/**
		 * @param appName the appName to set
		 */
		public void setAppName(String appName) {
			this.appName = appName;
		}

		/**
		 * @return the appAcronym
		 */
		public String getAppAcronym() {
			return appAcronym;
		}

		/**
		 * @param appAcronym the appAcronym to set
		 */
		public void setAppAcronym(String appAcronym) {
			this.appAcronym = appAcronym;
		}

		/**
		 * @return the data_Owner
		 */
		public String getDataOwner() {
			return dataOwner;
		}

		/**
		 * @param data_Owner the data_Owner to set
		 */
		public void setDataOwner(String data_Owner) {
			dataOwner = data_Owner;
		}

		/**
		 * @return the businessApplicationOwner
		 */
		public String getBusinessApplicationOwner() {
			return businessApplicationOwner;
		}

		/**
		 * @param businessApplicationOwner the businessApplicationOwner to set
		 */
		public void setBusinessApplicationOwner(String businessApplicationOwner) {
			this.businessApplicationOwner = businessApplicationOwner;
		}

		/**
		 * @return the technicalSupportLead
		 */
		public String getTechnicalSupportLead() {
			return technicalSupportLead;
		}

		/**
		 * @param technicalSupportLead the technicalSupportLead to set
		 */
		public void setTechnicalSupportLead(String technicalSupportLead) {
			this.technicalSupportLead = technicalSupportLead;
		}

		/**
		 * @return the iTProgramManager
		 */
		public String getiTProgramManager() {
			return iTProgramManager;
		}

		/**
		 * @param iTProgramManager the iTProgramManager to set
		 */
		public void setiTProgramManager(String iTProgramManager) {
			this.iTProgramManager = iTProgramManager;
		}

		/**
		 * @return the vendor
		 */
		public String getVendor() {
			return vendor;
		}

		/**
		 * @param vendor the vendor to set
		 */
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}

		/**
		 * @return the webApplicationYesOrNo
		 */
		public String getWebApplicationYesOrNo() {
			return webApplicationYesOrNo;
		}

		/**
		 * @param webApplicationYesOrNo the webApplicationYesOrNo to set
		 */
		public void setWebApplicationYesOrNo(String webApplicationYesOrNo) {
			this.webApplicationYesOrNo = webApplicationYesOrNo;
		}

		/**
		 * @return the accessDatabaseYOrN
		 */
		public String getAccessDatabaseYOrN() {
			return accessDatabaseYOrN;
		}

		/**
		 * @param accessDatabaseYOrN the accessDatabaseYOrN to set
		 */
		public void setAccessDatabaseYOrN(String accessDatabaseYOrN) {
			this.accessDatabaseYOrN = accessDatabaseYOrN;
		}

		/**
		 * @return the nonAccessDatabaseType
		 */
		public String getNonAccessDatabaseType() {
			return nonAccessDatabaseType;
		}

		/**
		 * @param nonAccessDatabaseType the nonAccessDatabaseType to set
		 */
		public void setNonAccessDatabaseType(String nonAccessDatabaseType) {
			this.nonAccessDatabaseType = nonAccessDatabaseType;
		}

		/**
		 * @return the missionCritical
		 */
		public String getMissionCritical() {
			return missionCritical;
		}

		/**
		 * @param missionCritical the missionCritical to set
		 */
		public void setMissionCritical(String missionCritical) {
			this.missionCritical = missionCritical;
		}

		/**
		 * @return the inidcator504
		 */
		public String getInidcator504() {
			return inidcator504;
		}

		/**
		 * @param inidcator504 the inidcator504 to set
		 */
		public void setInidcator504(String inidcator504) {
			this.inidcator504 = inidcator504;
		}

		/**
		 * @return the dataClassification
		 */
		public String getDataClassification() {
			return dataClassification;
		}

		/**
		 * @param dataClassification the dataClassification to set
		 */
		public void setDataClassification(String dataClassification) {
			this.dataClassification = dataClassification;
		}

		/**
		 * @return the activeInd
		 */
		public String getActiveInd() {
			return activeInd;
		}

		/**
		 * @param activeInd the activeInd to set
		 */
		public void setActiveInd(String activeInd) {
			this.activeInd = activeInd;
		}

		/**
		 * @return the appDescription
		 */
		public String getAppDescription() {
			return appDescription;
		}

		/**
		 * @param appDescription the appDescription to set
		 */
		public void setAppDescription(String appDescription) {
			this.appDescription = appDescription;
		}

		/**
		 * @return the requires24x7Support
		 */
		public String getRequires24x7Support() {
			return requires24x7Support;
		}

		/**
		 * @param requires24x7Support the requires24x7Support to set
		 */
		public void setRequires24x7Support(String requires24x7Support) {
			this.requires24x7Support = requires24x7Support;
		}

		/**
		 * @return the audience
		 */
		public String getAudience() {
			return audience;
		}

		/**
		 * @param audience the audience to set
		 */
		public void setAudience(String audience) {
			this.audience = audience;
		}

		/**
		 * @return the numberOfUsers
		 */
		public String getNumberOfUsers() {
			return numberOfUsers;
		}

		/**
		 * @param numberOfUsers the numberOfUsers to set
		 */
		public void setNumberOfUsers(String numberOfUsers) {
			this.numberOfUsers = numberOfUsers;
		}

		/**
		 * @return the contactPerson
		 */
		public String getContactPerson() {
			return contactPerson;
		}

		/**
		 * @param contactPerson the contactPerson to set
		 */
		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
		}

		/**
		 * @return the serverDetails
		 */
		public String getServerDetails() {
			return serverDetails;
		}

		/**
		 * @param serverDetails the serverDetails to set
		 */
		public void setServerDetails(String serverDetails) {
			this.serverDetails = serverDetails;
		}

		/**
		 * @return the physicalLocation
		 */
		public String getPhysicalLocation() {
			return physicalLocation;
		}

		/**
		 * @param physicalLocation the physicalLocation to set
		 */
		public void setPhysicalLocation(String physicalLocation) {
			this.physicalLocation = physicalLocation;
		}

		/**
		 * @return the platform
		 */
		public String getPlatform() {
			return platform;
		}

		/**
		 * @param platform the platform to set
		 */
		public void setPlatform(String platform) {
			this.platform = platform;
		}

		/**
		 * @return the platformnotes
		 */
		public String getPlatformnotes() {
			return platformnotes;
		}

		/**
		 * @param platformnotes the platformnotes to set
		 */
		public void setPlatformnotes(String platformnotes) {
			this.platformnotes = platformnotes;
		}

		/**
		 * @return the bureauApplicationNotes
		 */
		public String getBureauApplicationNotes() {
			return bureauApplicationNotes;
		}

		/**
		 * @param bureauApplicationNotes the bureauApplicationNotes to set
		 */
		public void setBureauApplicationNotes(String bureauApplicationNotes) {
			this.bureauApplicationNotes = bureauApplicationNotes;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((accessDatabaseYOrN == null) ? 0 : accessDatabaseYOrN.hashCode());
			result = prime * result + ((activeInd == null) ? 0 : activeInd.hashCode());
			result = prime * result + ((appAcronym == null) ? 0 : appAcronym.hashCode());
			result = prime * result + ((appDescription == null) ? 0 : appDescription.hashCode());
			result = prime * result + ((appName == null) ? 0 : appName.hashCode());
			result = prime * result + ((audience == null) ? 0 : audience.hashCode());
			result = prime * result + ((bureau == null) ? 0 : bureau.hashCode());
			result = prime * result + ((bureauApplicationNotes == null) ? 0 : bureauApplicationNotes.hashCode());
			result = prime * result + ((businessApplicationOwner == null) ? 0 : businessApplicationOwner.hashCode());
			result = prime * result + ((contactPerson == null) ? 0 : contactPerson.hashCode());
			result = prime * result + ((dataClassification == null) ? 0 : dataClassification.hashCode());
			result = prime * result + ((dataOwner == null) ? 0 : dataOwner.hashCode());
			result = prime * result + ((iTProgramManager == null) ? 0 : iTProgramManager.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((inidcator504 == null) ? 0 : inidcator504.hashCode());
			result = prime * result + ((missionCritical == null) ? 0 : missionCritical.hashCode());
			result = prime * result + ((nonAccessDatabaseType == null) ? 0 : nonAccessDatabaseType.hashCode());
			result = prime * result + ((numberOfUsers == null) ? 0 : numberOfUsers.hashCode());
			result = prime * result + ((physicalLocation == null) ? 0 : physicalLocation.hashCode());
			result = prime * result + ((platform == null) ? 0 : platform.hashCode());
			result = prime * result + ((platformnotes == null) ? 0 : platformnotes.hashCode());
			result = prime * result + ((requires24x7Support == null) ? 0 : requires24x7Support.hashCode());
			result = prime * result + ((serverDetails == null) ? 0 : serverDetails.hashCode());
			result = prime * result + ((technicalSupportLead == null) ? 0 : technicalSupportLead.hashCode());
			result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
			result = prime * result + ((webApplicationYesOrNo == null) ? 0 : webApplicationYesOrNo.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Inventory other = (Inventory) obj;
			if (accessDatabaseYOrN == null) {
				if (other.accessDatabaseYOrN != null)
					return false;
			} else if (!accessDatabaseYOrN.equals(other.accessDatabaseYOrN))
				return false;
			if (activeInd == null) {
				if (other.activeInd != null)
					return false;
			} else if (!activeInd.equals(other.activeInd))
				return false;
			if (appAcronym == null) {
				if (other.appAcronym != null)
					return false;
			} else if (!appAcronym.equals(other.appAcronym))
				return false;
			if (appDescription == null) {
				if (other.appDescription != null)
					return false;
			} else if (!appDescription.equals(other.appDescription))
				return false;
			if (appName == null) {
				if (other.appName != null)
					return false;
			} else if (!appName.equals(other.appName))
				return false;
			if (audience == null) {
				if (other.audience != null)
					return false;
			} else if (!audience.equals(other.audience))
				return false;
			if (bureau == null) {
				if (other.bureau != null)
					return false;
			} else if (!bureau.equals(other.bureau))
				return false;
			if (bureauApplicationNotes == null) {
				if (other.bureauApplicationNotes != null)
					return false;
			} else if (!bureauApplicationNotes.equals(other.bureauApplicationNotes))
				return false;
			if (businessApplicationOwner == null) {
				if (other.businessApplicationOwner != null)
					return false;
			} else if (!businessApplicationOwner.equals(other.businessApplicationOwner))
				return false;
			if (contactPerson == null) {
				if (other.contactPerson != null)
					return false;
			} else if (!contactPerson.equals(other.contactPerson))
				return false;
			if (dataClassification == null) {
				if (other.dataClassification != null)
					return false;
			} else if (!dataClassification.equals(other.dataClassification))
				return false;
			if (dataOwner == null) {
				if (other.dataOwner != null)
					return false;
			} else if (!dataOwner.equals(other.dataOwner))
				return false;
			if (iTProgramManager == null) {
				if (other.iTProgramManager != null)
					return false;
			} else if (!iTProgramManager.equals(other.iTProgramManager))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (inidcator504 == null) {
				if (other.inidcator504 != null)
					return false;
			} else if (!inidcator504.equals(other.inidcator504))
				return false;
			if (missionCritical == null) {
				if (other.missionCritical != null)
					return false;
			} else if (!missionCritical.equals(other.missionCritical))
				return false;
			if (nonAccessDatabaseType == null) {
				if (other.nonAccessDatabaseType != null)
					return false;
			} else if (!nonAccessDatabaseType.equals(other.nonAccessDatabaseType))
				return false;
			if (numberOfUsers == null) {
				if (other.numberOfUsers != null)
					return false;
			} else if (!numberOfUsers.equals(other.numberOfUsers))
				return false;
			if (physicalLocation == null) {
				if (other.physicalLocation != null)
					return false;
			} else if (!physicalLocation.equals(other.physicalLocation))
				return false;
			if (platform == null) {
				if (other.platform != null)
					return false;
			} else if (!platform.equals(other.platform))
				return false;
			if (platformnotes == null) {
				if (other.platformnotes != null)
					return false;
			} else if (!platformnotes.equals(other.platformnotes))
				return false;
			if (requires24x7Support == null) {
				if (other.requires24x7Support != null)
					return false;
			} else if (!requires24x7Support.equals(other.requires24x7Support))
				return false;
			if (serverDetails == null) {
				if (other.serverDetails != null)
					return false;
			} else if (!serverDetails.equals(other.serverDetails))
				return false;
			if (technicalSupportLead == null) {
				if (other.technicalSupportLead != null)
					return false;
			} else if (!technicalSupportLead.equals(other.technicalSupportLead))
				return false;
			if (vendor == null) {
				if (other.vendor != null)
					return false;
			} else if (!vendor.equals(other.vendor))
				return false;
			if (webApplicationYesOrNo == null) {
				if (other.webApplicationYesOrNo != null)
					return false;
			} else if (!webApplicationYesOrNo.equals(other.webApplicationYesOrNo))
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Inventory [id=" + id + ", bureau=" + bureau + ", appName=" + appName + ", appAcronym=" + appAcronym
					+ ", dataOwner=" + dataOwner + ", businessApplicationOwner=" + businessApplicationOwner
					+ ", technicalSupportLead=" + technicalSupportLead + ", iTProgramManager=" + iTProgramManager
					+ ", vendor=" + vendor + ", webApplicationYesOrNo=" + webApplicationYesOrNo
					+ ", accessDatabaseYOrN=" + accessDatabaseYOrN + ", nonAccessDatabaseType=" + nonAccessDatabaseType
					+ ", missionCritical=" + missionCritical + ", inidcator504=" + inidcator504
					+ ", dataClassification=" + dataClassification + ", activeInd=" + activeInd + ", appDescription="
					+ appDescription + ", requires24x7Support=" + requires24x7Support + ", audience=" + audience
					+ ", numberOfUsers=" + numberOfUsers + ", contactPerson=" + contactPerson + ", serverDetails="
					+ serverDetails + ", physicalLocation=" + physicalLocation + ", platform=" + platform
					+ ", platformnotes=" + platformnotes + ", bureauApplicationNotes=" + bureauApplicationNotes + "]";
		}



}
