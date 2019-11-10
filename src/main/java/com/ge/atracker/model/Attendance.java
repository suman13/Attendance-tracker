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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.TIMESTAMP)
	public Date entryDate;

	@PrePersist
	protected void onCreate() {
		entryDate = new Date();
	}

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

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

}
