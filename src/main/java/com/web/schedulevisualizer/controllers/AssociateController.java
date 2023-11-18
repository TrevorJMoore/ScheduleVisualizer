package com.web.schedulevisualizer.controllers;

import com.web.schedulevisualizer.models.Associate;
import com.web.schedulevisualizer.repositories.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associate")
public class AssociateController {

    @Autowired
    private AssociateRepository associateRepository;

    @GetMapping
    public List<Associate> getAssociatesByFirstName(@RequestParam String first_name) {
        return associateRepository.findByFirstNameIgnoreCase(first_name);
    }

    @GetMapping
    public List<Associate> getAssociatesByLastName(@RequestParam String last_name) {
        return associateRepository.findByLastNameIgnoreCase(last_name);
    }

    @GetMapping
    public List<Associate> getAssociatesByFirstNameAndLastName(@RequestParam String first_name, @RequestParam String last_name) {
        return associateRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(first_name, last_name);
    }


}
