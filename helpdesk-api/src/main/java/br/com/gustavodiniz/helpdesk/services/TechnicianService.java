package br.com.gustavodiniz.helpdesk.services;

import br.com.gustavodiniz.helpdesk.domain.Technician;
import br.com.gustavodiniz.helpdesk.repositories.TechnicianRepository;
import br.com.gustavodiniz.helpdesk.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository repository;

    public Technician findById(Integer id) {
        Optional<Technician> technician = repository.findById(id);
        return technician.orElseThrow(() -> new EntityNotFoundException("Technician with id " + id + " not found"));
    }

    public List<Technician> findAll() {
         return repository.findAll();
    }
}
