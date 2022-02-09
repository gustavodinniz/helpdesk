package br.com.gustavodiniz.helpdesk.controllers;

import br.com.gustavodiniz.helpdesk.domain.Called;
import br.com.gustavodiniz.helpdesk.domain.dto.CalledDTO;
import br.com.gustavodiniz.helpdesk.services.CalledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calleds")
public class CalledController {

    @Autowired
    private CalledService service;

    @GetMapping(value = "{id}")
    public ResponseEntity<CalledDTO> findById(@PathVariable Integer id) {
        Called entity = service.findById(id);
        return ResponseEntity.ok().body(new CalledDTO(entity));
    }
}
