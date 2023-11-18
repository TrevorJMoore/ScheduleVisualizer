/* Design of the SCHEDULES db.
    INTEGER primary_key - used to lookup a specific worker's schedule
    INTEGER day_of_week - day of week starting from 0-6 (0 - Saturday, 1 - Sunday, ... 6 - Friday)
    I

    A schedule consists of days with unique start and end times.
    Each schedule belongs to a specific person.

 */

package com.web.schedulevisualizer.models;

// The javax.persistence API has been moved to jakarta.persistence.
import jakarta.persistence.*;

@Entity
@Table(name="SCHEDULE")
public class Schedule {
    // Establish unique id for each schedule entry in db
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer scheduleID;

    // Many schedules to one associate
    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    private Associate associate;

    // Design moment:
    // Integer vs String?
    // Integer -> 24 hour time to represent start and end time. Save space. Ex: 1430 would be 2:30pm
    // String -> 12 hour times to represent start and end time. Larger space, less conversion (not necessarily true). Ex. '2:00pm'
    // I believe Integer will hold up better and cause less of a headache. (Famous last words? Maybe.)

    // Shift day (DDMMYYYY)
    @Column
    private Integer scheduleDay;

    // Shift start time
    @Column
    private Integer startTime;

    // Shift end time
    @Column
    private Integer endTime;

}
