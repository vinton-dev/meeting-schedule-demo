package com.calendardemo.entity;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.calendardemo.dto.Attendies;
import com.calendardemo.utility.AttendiesConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meetings")
@EqualsAndHashCode(callSuper = false)
public class MeetingEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "organizer")
	private String organizer;
	
	
	
	@Column(name = "start_time")
	//@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Kolkata")
	private Date startTime;
	
	@Column(name = "end_time")
	//@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Kolkata")
	private Date endTime;
	
	@Column(name = "meeting_location")
	private String meetingLocation;
	
	@Column(name = "meeting_description")
	private String meetingDescription;
	
//	@Column(name = "status")
//	private String priorityStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="m_aid",referencedColumnName = "id")
	private List<Attendies> attendees;


}
