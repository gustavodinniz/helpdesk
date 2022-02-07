package br.com.gustavodiniz.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Technician extends Person {

    private List<Called> calleds = new ArrayList<>();

    public Technician() {
        super();
    }

    public Technician(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
    }
}
