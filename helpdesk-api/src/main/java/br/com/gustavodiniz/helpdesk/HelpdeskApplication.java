package br.com.gustavodiniz.helpdesk;

import br.com.gustavodiniz.helpdesk.domain.Called;
import br.com.gustavodiniz.helpdesk.domain.Client;
import br.com.gustavodiniz.helpdesk.domain.Technician;
import br.com.gustavodiniz.helpdesk.domain.enums.Priority;
import br.com.gustavodiniz.helpdesk.domain.enums.Profile;
import br.com.gustavodiniz.helpdesk.domain.enums.Status;
import br.com.gustavodiniz.helpdesk.repositories.CalledRepository;
import br.com.gustavodiniz.helpdesk.repositories.ClientRepository;
import br.com.gustavodiniz.helpdesk.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CalledRepository calledRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Technician technician1 = new Technician(null, "Gustavo Diniz", "616.452.220-04", "gustavo@gmail.com", "123");
        technician1.addProfile(Profile.ADMIN);

        Client client1 = new Client(null, "Alberto Chaves", "753.597.110-51", "alberto@gmail.com", "123");

        Called called1 = new Called(null, Priority.MEDIUM, Status.IN_PROGRESS, "Chamado 01", "Primeiro Chamado", technician1, client1);

        technicianRepository.saveAll(Arrays.asList(technician1));
        clientRepository.saveAll(Arrays.asList(client1));
        calledRepository.saveAll(Arrays.asList(called1));
    }
}
