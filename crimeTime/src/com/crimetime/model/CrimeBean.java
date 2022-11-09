package com.crimetime.model;

public class CrimeBean {
		private int crime_id;
		private String crime_date;
		private String short_desc;
		private String detailed_desc;
		private String area_of_crime;
		private String policestation_code;
		private int victim_id;
		
		public int getCrime_id() {
			return crime_id;
		}
		public void setCrime_id(int crime_id) {
			this.crime_id = crime_id;
		}
		public String getCrime_date() {
			return crime_date;
		}
		public void setCrime_date(String crime_date) {
			this.crime_date = crime_date;
		}
		public String getShort_desc() {
			return short_desc;
		}
		public void setShort_desc(String short_desc) {
			this.short_desc = short_desc;
		}
		public String getDetailed_desc() {
			return detailed_desc;
		}
		public void setDetailed_desc(String detailed_desc) {
			this.detailed_desc = detailed_desc;
		}
		public String getArea_of_crime() {
			return area_of_crime;
		}
		public void setArea_of_crime(String area_of_crime) {
			this.area_of_crime = area_of_crime;
		}
		public String getPolicestation_code() {
			return policestation_code;
		}
		public void setPolicestation_code(String policestation_code) {
			this.policestation_code = policestation_code;
		}
		public int getVictim_id() {
			return victim_id;
		}
		public void setVictim_id(int victim_id) {
			this.victim_id = victim_id;
		}
		
		@Override
		public String toString() {
			return "CrimeBean [crime_id=" + crime_id + ", crime_date=" + crime_date + ", short_desc=" + short_desc
					+ ", detailed_desc=" + detailed_desc + ", area_of_crime=" + area_of_crime + ", policestation_code="
					+ policestation_code + ", victim_id=" + victim_id + "]";
		}
		public CrimeBean(int crime_id, String crime_date, String short_desc, String detailed_desc, String area_of_crime,
			String policestation_code, int victim_id) {
			super();
			this.crime_id = crime_id;
			this.crime_date = crime_date;
			this.short_desc = short_desc;
			this.detailed_desc = detailed_desc;
			this.area_of_crime = area_of_crime;
			this.policestation_code = policestation_code;
			this.victim_id = victim_id;
		}
		
		
		public CrimeBean() {
			//empty constructor
		}
		
		
		
}
