package com.ge.atracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ge.atracker.model.Attendance;

@Repository
public interface AttendanceRepoImpl extends JpaRepository<Attendance, String> {

	public List<Attendance> findByUSN(String usn);

	@Query(value = "SELECT count(*) FROM attendance  WHERE usn =:usn and DATE(entry_date)=DATE(now()) ", nativeQuery = true)
	public Long checkStudentDetails(@Param("usn") String usn);

	@Query(value = "SELECT * FROM attendance  WHERE cast( DATE(entry_date) as text ) =:date ", nativeQuery = true)
	public List<Attendance> findByDate(@Param("date") String date);

	@Query(value = "SELECT * FROM attendance  WHERE usn =:usn  and DATE(entry_date)=DATE(now()) limit 1 ", nativeQuery = true)
	public Attendance findByUsnForToday(@Param("usn") String usn);

}
