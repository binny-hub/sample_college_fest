package com.college.fest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Students {
	/*
	 * AUTO: Hibernate selects the generation strategy based on the used dialect,
       IDENTITY: Hibernate relies on an auto-incremented database column to generate the primary key,
       SEQUENCE: Hibernate requests the primary key value from a database sequence,
       TABLE: Hibernate uses a database table to simulate a sequence.

	 */
	
	

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="StudentsId")
		private int StudentsId;


		@Column(name="firstName")
		private String firstName;

		@Column(name="lastName")
		private String lastName;

		@Column(name="departmenet")
		private String Departmenet;


		@Column(name="Country")
		private String country;


		// define constructors

		public Students()
		{

		}

		
		public Students( String firstName, String lastName, String departmenet, String country) {
			super();
	
			this.firstName = firstName;
			this.lastName = lastName;
			this.Departmenet = departmenet;
			this.country = country;
		}


		public int getId() {
			return StudentsId;
		}

		public void setId(int id) {
			this.StudentsId = id;
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

		public String getDepartmenet() {
			return Departmenet;
		}

		public void setDepartmenet(String departmenet) {
			this.Departmenet = departmenet;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		@Override
		public String toString() {
			return "Students [id=" + StudentsId + ", firstName=" + firstName + ", lastName=" + lastName + ", Departmenet="
					+ Departmenet + ", country=" + country + "]";
		}

		
}
