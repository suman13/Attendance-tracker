package com.ge.atracker.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.atracker.model.Attendance;
import com.ge.atracker.model.ResponseModel;
import com.ge.atracker.repository.AttendanceRepoImpl;
import com.ge.atracker.repository.StudentRepoImpl;

@Service
public class StudentServiceImpl implements IStudentServiceInterface {

	@Autowired
	AttendanceRepoImpl attendanceRepoInterface;

	@Autowired
	StudentRepoImpl studentRepoInterface;

	public static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public ResponseModel insertRecord(String usn) {
		LOGGER.info("insertRecord");
		ResponseModel res = new ResponseModel();
		try {
			Date today = Date.valueOf(LocalDate.now());

			Long count = attendanceRepoInterface.checkStudentDetails(usn, today.toString());
			if (count > 0) {
				res.setStatus("fail");
				res.setCode("400");
				res.setResponseDetail("Student already entered");
			} else {
				Attendance att = new Attendance();
				att.setuSN(usn);
				att.setEntryDate(today);
				attendanceRepoInterface.saveAndFlush(att);
				res.setResponseDetail("Attendance inserted");
				res.setCode("200");
				res.setStatus("sucess");
			}
		} catch (Exception e) {
			res.setStatus("fail");
			res.setCode("400");
			e.printStackTrace();
			res.setResponseDetail("Exception:- " + e.getMessage());
		}
		return res;
	}

	@Override
	public List<Attendance> getDetails(String usn) {
		// TODO Auto-generated method stub
		LOGGER.info("Fetching Details of " + usn);

		return attendanceRepoInterface.findByUSN(usn);

	}

}
