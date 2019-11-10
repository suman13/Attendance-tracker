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

	@Query("SELECT count(*) FROM attendance  WHERE business_name =:usn and entry_date=:today")
	public Long checkStudentDetails(@Param("usn") String usn, @Param("today") String today);
}
