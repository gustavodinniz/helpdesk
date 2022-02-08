package br.com.gustavodiniz.helpdesk.controllers;

import br.com.gustavodiniz.helpdesk.domain.Technician;
import br.com.gustavodiniz.helpdesk.domain.dto.TechnicianDTO;
import br.com.gustavodiniz.helpdesk.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/technical")
public class TechnicianController {

    @Autowired
    private TechnicianService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id) {
        Technician technician = service.findById(id);
        return ResponseEntity.ok().body(new TechnicianDTO(technician));
    }

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll() {
        List<Technician> list = service.findAll();
        List<TechnicianDTO> listDTO = list.stream().map(TechnicianDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
