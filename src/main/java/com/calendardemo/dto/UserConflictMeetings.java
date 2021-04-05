package com.calendardemo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserConflictMeetings {
	
	private String meetingTitle;
	
	private String name;
	
	private String startTime;
	
	private String endTime;

}
