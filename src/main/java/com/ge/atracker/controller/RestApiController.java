package com.ge.atracker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ge.atracker.model.Attendance;
import com.ge.atracker.model.ResponseModel;
import com.ge.atracker.service.IStudentServiceInterface;

import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class RestApiController {

	public static final Logger LOGGER = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	IStudentServiceInterface attendance;

	@RequestMapping(value = "/getAttendanceOfStudent/{usn}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Attendance>> get(@PathVariable(value = "usn") String usn) {
		System.out.println("get attendance details ");

		List<Attendance> result = attendance.getDetails(usn);
		return new ResponseEntity<List<Attendance>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAttendanceforDay/{date}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Attendance>> getAttendanceforDay(
			@PathVariable @ApiParam("Date format in yyyy-mm-dd") String date) {
		System.out.println("get attendance details daywise ");

		List<Attendance> result = attendance.getDetailsOfDay(date);
		return new ResponseEntity<List<Attendance>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/putAttendance/{usn}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseModel> put(@PathVariable(value = "usn") String usn) {
		ResponseModel res = attendance.insertRecord(usn);
		LOGGER.info(res.toString());
		if (res.getcode().equals("200")) {
			return new ResponseEntity<ResponseModel>(res, HttpStatus.OK);
		}
		return new ResponseEntity<ResponseModel>(res, HttpStatus.BAD_REQUEST);
	}

}
