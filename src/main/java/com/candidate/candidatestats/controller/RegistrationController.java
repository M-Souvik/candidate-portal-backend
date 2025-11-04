package com.candidate.candidatestats.controller;

import com.candidate.candidatestats.model.Registrations;
import com.candidate.candidatestats.service.RegistrationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "https://candidate-portal-frontend.vercel.app", allowCredentials = "true")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Registrations> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Registrations getById(@PathVariable Integer id) {
        return service.getById(id).orElse(null);
    }

    @GetMapping("/mobile/{mobile}")
    public Registrations getByMobile(@PathVariable Long mobile) {
        return service.getByMobile(mobile).orElse(null);
    }

    @GetMapping("/state-wise")
    public List<Map<String, Object>> getStateWiseStats() {
        return service.getStateWiseStats();
    }

    @GetMapping("/month-wise")
    public List<Map<String, Object>> getMonthwiseStats(){
        return service.getMonthlyRegistrationStats();
    }


}
