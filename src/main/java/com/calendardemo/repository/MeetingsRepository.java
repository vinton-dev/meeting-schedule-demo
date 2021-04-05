package com.calendardemo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.calendardemo.entity.MeetingEntity;

@Repository
public interface MeetingsRepository extends JpaRepository<MeetingEntity, Long>{
	
	public MeetingEntity findByTitle(String title);
	
	
//	@Query(value ="SELECT NEW com.calendardemo.dto.ConflictsDto(a.name,m.meetingDescription) from MeetingEntity m ,Attendies a where m.id =a.id and (m.startTime BETWEEN :startdate AND :enddate )")
//	public List<ConflictsDto> getUserConflictMeetings(@Param("startdate") Date startdate,@Param("enddate") Date enddate );
//	
//	@Query(value ="SELECT NEW com.calendardemo.dto.ConflictsDto(a.name,m.meetingDescription) from MeetingEntity m ,Attendies a where m.id =a.m_aid and (m.startTime BETWEEN :startTime AND :endTime )")
//	public List<ConflictsDto> findByAttendees_StartTimeAndEndTime(@Param("startTime") Date startTime,@Param("endTime") Date endTime );
	
//	@Query(value ="SELECT  a.name,m.meeting_description  from meetings m ,attendies a where m.id =a.m_aid and (start_time BETWEEN ?1 AND ?2 )",nativeQuery = true)
//	public List<Object[]> findConflictMettinds( Date startTime, Date endTime );
//	
	
//	@Query(value ="SELECT  a.name,m.title  from meetings m ,attendies a where m.id =a.m_aid and (start_time BETWEEN '?1' AND '?2' )",nativeQuery = true)
//	public List<Object[]> findConflictMettinds( Date startTime, Date endTime );
//	
//	@Query(value ="SELECT  a.name,m.title  from meetings m ,attendies a where m.id =a.m_aid and (start_time BETWEEN '2021-04-03 11:00:16' AND '2021-04-03 11:30:15' )",nativeQuery = true)
//	public List<Object[]> findConflictMettinds( Date startTime, Date endTime );
//	
//	@Query(value ="SELECT  a.name,m.title  from meetings m ,attendies a where m.id =a.m_aid and (m.start_time BETWEEN :startTime AND :endTime )",nativeQuery = true)
//	public List<Object[]> findConflictMettinds(@Param("startTime") Date startTime,@Param("endTime") Date endTime );
//	
	
	@Query(value ="SELECT  a.name,m.title  from meetings m ,attendies a where m.id =a.m_aid and (m.start_time BETWEEN ?1 AND ?2 )",nativeQuery = true)
	public List<Object[]> findConflictMettinds(@Param("startTime") Date startTime,@Param("endTime") Date endTime );
//	
//	@Query(value ="SELECT  a.name,m.title  from meetings m ,attendies a where m.id =a.m_aid and (m.start_time >=:startTime AND m.end_time <=:endTime )",nativeQuery = true)
//	public List<Object[]> findConflictMettinds(@Param("startTime") Date startTime,@Param("endTime") Date endTime );
//	
	
//	@Query(value ="SELECT  a.name,m.title  from meetings m ,attendies a where m.id =a.m_aid and (m.start_time BETWEEN :startTime AND :endTime )",nativeQuery = true)
//	public List<Object[]> findConflictMettinds(@Param("startTime") String startTime,@Param("endTime") String endTime );

	
	
//	@Query(value ="SELECT m.title,a.name,m.start_time,m.end_time from attendies a inner join meetings m on a.m_aid=m.id and m.start_time  LIKE ?1 and (a.name=?2 or a.name=?3)",nativeQuery = true)
//	public List<Object[]> findUserConflictMettings( String date,String firstUser,String secondUser );
	
	
	@Query(value ="SELECT m.title,a.name,m.start_time,m.end_time from attendies a inner join meetings m on a.m_aid=m.id and m.start_time  LIKE %:starTime% and (a.name =:firstName or a.name =:secondName)",nativeQuery = true)
	public List<Object[]> findUserConflictMettings(@Param("starTime") String starTime,@Param("firstName") String firstName,@Param("secondName") String secondName );


	
	
}
