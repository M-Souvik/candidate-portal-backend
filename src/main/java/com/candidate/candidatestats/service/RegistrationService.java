package com.candidate.candidatestats.service;

import com.candidate.candidatestats.model.Registrations;
import com.candidate.candidatestats.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistrationService {
    private final RegistrationRepository repo;

    public RegistrationService(RegistrationRepository repo) {
        this.repo = repo;
    }

    public Long getCount(){
        long total = repo.count();
        return total;

    }
    public List<Registrations> getAll() { return repo.findAll(); }

    public Optional<Registrations> getById(Integer id) { return repo.findById(id); }

    public Optional<Registrations> getByMobile(Long mobileNo) { return repo.findByMobileNo(mobileNo); }

    public List<Map<String, Object>> getStateWiseStats() {
        List<Object[]> results = repo.getRegistrationsCountByState();
        System.out.print(results);
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> data = new HashMap<>();
            data.put("state", row[0]);
            data.put("total", row[1]);
            response.add(data);
        }
        return response;
    }

    public List<Map<String, Object>> getMonthlyRegistrationStats() {
        List<Object[]> result = repo.getMonthlyRegistrationStats();
        System.out.print(result);
        List<Map<String, Object>> stats = new ArrayList<>();

        for (Object[] row : result) {
            Map<String, Object> map = new HashMap<>();
            map.put("month", ((String) row[0]).trim()); // remove extra spaces
            map.put("count", ((Number) row[1]).intValue());
            stats.add(map);
        }
        return stats;
    }
}
