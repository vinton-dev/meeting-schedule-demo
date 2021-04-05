package com.calendardemo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.calendardemo.dto.ConflictsDto;
import com.calendardemo.dto.UserConflictMeetings;
import com.calendardemo.entity.MeetingEntity;
import com.calendardemo.repository.MeetingsRepository;
import com.calendardemo.utility.DateFormatter;

@Service
public class MeetingsService {

	@Autowired
	private MeetingsRepository meetingsRepository;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ResponseEntity<?> saveMeeting(MeetingEntity meeting) {
		try {
//			MeetingEntity	meetingCheck=meetingsRepository.findByTitle(meeting.getTitle());
//			if(meetingCheck!=null) 	return new ResponseEntity<>("Meeting with same title exist,choose different", HttpStatus.OK);

			meeting = meetingsRepository.save(meeting);
			if (meeting != null)
				return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	public ResponseEntity<?> meetings() {
		try {
			List<MeetingEntity> meetings = meetingsRepository.findAll();
			System.out.println(meetings);
			return new ResponseEntity<>(meetings, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	public ResponseEntity<?> getMeetingConflicts(MeetingEntity meeting) {
		try {
			List<ConflictsDto> conflicts = new ArrayList<>();
			logger.info("start time"+meeting.getStartTime() + "end time"+meeting.getEndTime());
			List<Object[]> conflictsData = meetingsRepository.findConflictMettinds(meeting.getStartTime(),meeting.getEndTime());
			//List<Object[]> conflictsData = meetingsRepository.findConflictMettinds(DateFormatter.getDateFormatter(meeting.getStartTime()), DateFormatter.getDateFormatter(meeting.getEndTime()));
			if (conflictsData.size() <= 0) {
				return new ResponseEntity<>("No Conflicts meetings found", HttpStatus.NOT_FOUND);
			} else {
				conflictsData.stream().forEach((o) -> {
					conflicts.add(new ConflictsDto(o[0].toString(), o[1].toString()));
				});
				return new ResponseEntity<>(conflicts, HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> getUserMeetingConflicts(String firstUser, String secondUser, String date) {
		try {
			List<UserConflictMeetings> conflicts = new ArrayList<>();
			logger.info(date);
			List<Object[]> userConflicts = meetingsRepository.findUserConflictMettings(date, firstUser, secondUser);
			if (userConflicts.size() <= 0) {
				return new ResponseEntity<>("No Conflicts meetings found", HttpStatus.NOT_FOUND);
			} else {
				userConflicts.stream().forEach((o) -> {
					conflicts.add(new UserConflictMeetings(o[0].toString(), o[1].toString(),o[2].toString(), o[3].toString()));
				 });
				return new ResponseEntity<>(conflicts, HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
