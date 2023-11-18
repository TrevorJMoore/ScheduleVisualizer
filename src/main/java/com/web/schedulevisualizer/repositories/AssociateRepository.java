package com.web.schedulevisualizer.repositories;

import com.web.schedulevisualizer.models.Associate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssociateRepository extends CrudRepository<Associate, Integer> {
    // Associate has Integer personID, String lastName, firstName.

    // Single Searches
    public Associate findByPersonID(Integer personID);
    public List<Associate> findByFirstNameIgnoreCase(String firstName);
    public List<Associate> findByLastNameIgnoreCase(String lastName);

    // Multi Searches
    public List<Associate> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
}
