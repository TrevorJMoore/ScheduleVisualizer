package com.web.schedulevisualizer.controllers;

import com.web.schedulevisualizer.exceptions.QueryNotSupportedException;
import com.web.schedulevisualizer.models.Schedule;
import com.web.schedulevisualizer.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping
    public List<Schedule> getSchedules(
            @RequestParam(name="start_time", required=false) Integer startTime,
            @RequestParam(name="end_time", required=false) Integer endTime,
            @RequestParam(name="schedule_day", required=false) Integer scheduleDay
    ) throws QueryNotSupportedException {

        if (Objects.nonNull(startTime)) {
            // Search on start time, end time, and scheduled day
            if (Objects.nonNull(endTime) && Objects.nonNull(scheduleDay)) {
                return scheduleRepository.findByScheduleDayAndStartTimeAndEndTime(scheduleDay, startTime, endTime);
            }
            // Search on start time and end time
            else if (Objects.nonNull(endTime)) {
                return scheduleRepository.findByStartTimeAndEndTime(startTime, endTime);
            }
            // Search on start time and scheduled day
            else if (Objects.nonNull(scheduleDay)) {
                return scheduleRepository.findByScheduleDayAndStartTime(scheduleDay, startTime);
            }
            // Search on start time
            else {
                return scheduleRepository.findByStartTime(startTime);
            }
        } else if (Objects.nonNull(endTime)) {
            // Search on end time and scheduled day
            if (Objects.nonNull(scheduleDay)) {
                return scheduleRepository.findByScheduleDayAndEndTime(scheduleDay, endTime);
            }
            // Search on end time
            else {
                return scheduleRepository.findByEndTime(endTime);
            }

        } else if (Objects.nonNull(scheduleDay)) {
            // Search on scheduled day
            return scheduleRepository.findByScheduleDay(scheduleDay);
        } else {
            // Error, query is not supported.
            throw new QueryNotSupportedException("This query is not supported. " +
                    "Please try a different combination of search parameters.");
        }
    }
}
