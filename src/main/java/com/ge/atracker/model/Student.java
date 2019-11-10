/**
 * 
 */
package com.ge.atracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 212601185
 *
 */

@Entity
@Table(name = "student", schema = "public")
public class Student {

	@Id
	@Column(name = "usn")
	String uSN;

	@Column(name = "student_name")
	String studentName;

	@Column(name = "phone_number")
	String phoneNumber;

	
}
