/**
 * 
 */
package com.ge.atracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 212601185
 *
 */

@Entity
@Table(name = "attendance", schema = "public")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "usn")
	private String uSN;

	@Column(name = "entry_date", nullable = false)
	public Date entryDate;

	@Column(name = "exit_date")
	public Date exit_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getuSN() {
		return uSN;
	}

	public void setuSN(String uSN) {
		this.uSN = uSN;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate() {
		this.entryDate = new Date();
	}

	public void setExit_date() {
		this.exit_date = new Date();
	}

	public Date getExit_date() {
		return exit_date;
	}

	public void setExit_date(Date exit_date) {
		this.exit_date = exit_date;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

}
