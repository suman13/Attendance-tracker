package com.ge.atracker.service;

import java.util.List;

import com.ge.atracker.model.Attendance;
import com.ge.atracker.model.ResponseModel;

public interface IStudentServiceInterface {

	List<Attendance> getDetails(String usn);

	ResponseModel insertRecord(String usn);

	List<Attendance> getDetailsOfDay(String date);

}
