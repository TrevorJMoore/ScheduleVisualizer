package com.web.schedulevisualizer.repositories;

import com.web.schedulevisualizer.models.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

    // Schedule has Integer scheduleID, startTime, endTime

    // Single Searches
    public Schedule findByScheduleID(Integer scheduleID);
    public List<Schedule> findByScheduleDay(Integer scheduleDay);
    public List<Schedule> findByStartTime(Integer startTime);
    public List<Schedule> findByEndTime(Integer endTime);

    // Multi Searches
    public List<Schedule> findByStartTimeAndEndTime(Integer startTime, Integer endTime);
    public List<Schedule> findByScheduleDayAndStartTime(Integer scheduleDay, Integer startTime);
    public List<Schedule> findByScheduleDayAndEndTime(Integer scheduleDay, Integer endTime);
    public List<Schedule> findByScheduleDayAndStartTimeAndEndTime(Integer scheduleDay, Integer startTime, Integer endTime);

}
