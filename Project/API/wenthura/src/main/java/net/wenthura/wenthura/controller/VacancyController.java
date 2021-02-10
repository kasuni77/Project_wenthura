package net.wenthura.wenthura.controller;


import net.wenthura.wenthura.exception.ResourceNotFoundException;
import net.wenthura.wenthura.model.Vacancy;
import net.wenthura.wenthura.repository.VacancyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/vac")
public class VacancyController {
    @Autowired
    private VacancyRepository vacancyRepository;

    @GetMapping("/vacancy/all")
    public List<Vacancy> getAllVacancy(){
        return vacancyRepository.findAll();
    }

    @GetMapping("/vacancy/{id}")
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable(value = "id") Long vacancyId)
        throws ResourceNotFoundException {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new ResourceNotFoundException("Vacancy not found for this id :: " + vacancyId));
        return ResponseEntity.ok().body(vacancy);
    }

    @PostMapping("/vacancy")
    public Vacancy createVacancy(@Valid @RequestBody Vacancy vacancy) {

        return vacancyRepository.save(vacancy);
    }

    @PutMapping("/vacancy/{id}")
    public ResponseEntity<Vacancy> updateVacancy(@PathVariable(value = "id") Long vacancyId,
                                                   @Valid @RequestBody Vacancy vacancyDetails) throws ResourceNotFoundException {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new ResourceNotFoundException("Vacancy not found for this id :: " + vacancyId));

        vacancy.setVname(vacancyDetails.getVname());
        vacancy.setVdesc(vacancyDetails.getVdesc());
        vacancy.setVplace(vacancyDetails.getVplace());
        vacancy.setEdate(vacancyDetails.getEdate());
        vacancy.setSdate(vacancyDetails.getSdate());
        vacancy.setWorktime(vacancyDetails.getWorktime());

        final Vacancy updatedVacancy = vacancyRepository.save(vacancy);
        return ResponseEntity.ok(updatedVacancy);
    }

    @DeleteMapping("/vacancy/{id}")
    public Map<String, Boolean> deleteVacancy(@PathVariable(value = "id") Long vacancyId)
            throws ResourceNotFoundException {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new ResourceNotFoundException("Vacancy not found for this id :: " + vacancyId));

        vacancyRepository.delete(vacancy);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
