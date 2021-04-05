package com.calendardemo.controller;

import java.util.Date;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calendardemo.entity.AppUsers;
import com.calendardemo.entity.MeetingEntity;
import com.calendardemo.services.MeetingsService;
import com.calendardemo.services.UserService;

@RestController
public class CalenderController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MeetingsService meetingsService;

	@GetMapping("/")
	public String sayHello() {
		return "Hello";
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> registerUser( @RequestBody AppUsers user){
		return userService.saveUser(user);
	}
	
	@PostMapping("/meetings")
	public ResponseEntity<?> meetings(@RequestBody MeetingEntity meeting){
		return meetingsService.saveMeeting(meeting);
	}
	
	@GetMapping("/meetings")
	public ResponseEntity<?> allMeetings(){
		return meetingsService.meetings();
	}
	
	@PostMapping("/meetings/conflicts")
	public ResponseEntity<?> conflictMeetings(@RequestBody MeetingEntity meeting){
		return meetingsService.getMeetingConflicts(meeting);
	}
	
	@GetMapping("/meetings/conflicts/{firstuser}/{seconduser}/{date}")
	public ResponseEntity<?> userConflictMeetings(@PathVariable String firstuser,@PathVariable String seconduser,@PathVariable String date){
		return meetingsService.getUserMeetingConflicts(firstuser,seconduser,date);
	}
}
