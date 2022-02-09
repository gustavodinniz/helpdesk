package br.com.gustavodiniz.helpdesk.services;

import br.com.gustavodiniz.helpdesk.domain.Called;
import br.com.gustavodiniz.helpdesk.repositories.CalledRepository;
import br.com.gustavodiniz.helpdesk.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalledService {

    @Autowired
    private CalledRepository repository;

    public Called findById(Integer id){
        Optional<Called> entity = repository.findById(id);
        return entity.orElseThrow(() -> new EntityNotFoundException("Called with id " + id + " not found"));
    }
}
