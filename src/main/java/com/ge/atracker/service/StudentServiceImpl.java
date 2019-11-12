package com.ge.atracker.service;

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
			Long count = attendanceRepoInterface.checkStudentDetails(usn);
			if (count == 0) {
				Attendance att = new Attendance();
				att.setuSN(usn);
				att.setEntryDate();
				attendanceRepoInterface.saveAndFlush(att);
				res.setResponseDetail("Attendance inserted, Studenet Entered campus");
				res.setCode("200");
				res.setStatus("sucess");
			} else if (count == 1) {
				Attendance att = attendanceRepoInterface.findByUsnForToday(usn);
				if (att.getExit_date() != null) {
					res.setStatus("fail");
					res.setCode("400");
					res.setResponseDetail("Student already exited campus");
				} else {
					att.setExit_date();
					attendanceRepoInterface.saveAndFlush(att);
					res.setResponseDetail("Attendance inserted, Studenet Exited campus");
					res.setCode("200");
					res.setStatus("sucess");
				}

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

	@Override
	public List<Attendance> getDetailsOfDay(String date) {
		LOGGER.info("Fetching Details for " + date);

		return attendanceRepoInterface.findByDate(date);

	}

}
