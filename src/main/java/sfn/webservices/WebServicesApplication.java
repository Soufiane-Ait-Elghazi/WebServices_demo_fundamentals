package sfn.webservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sfn.webservices.entities.Client;
import sfn.webservices.entities.Compte;
import sfn.webservices.entities.TypeCompte;
import sfn.webservices.repositories.ClientRepository;
import sfn.webservices.repositories.CompteRepository;

import java.util.Date;

@SpringBootApplication
public class WebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            RepositoryRestConfiguration repositoryRestConfiguration,
                            ClientRepository clientRepository){
        return  args -> {
            repositoryRestConfiguration.exposeIdsFor(Compte.class, Client.class);
            Client c1 =clientRepository.save(new Client(null,"C1",null));
            Client c2 = clientRepository.save(new Client(null,"C2",null));
            compteRepository.save(new Compte(null,Math.random()*8000,new Date(), TypeCompte.COURANT,c2));
            compteRepository.save(new Compte(null,Math.random()*8000,new Date(), TypeCompte.EPARGNE,c2));
            compteRepository.save(new Compte(null,Math.random()*8000,new Date(), TypeCompte.COURANT,c1));
            compteRepository.findAll().forEach(c->{
                System.out.println( c.getType());
            });
        };
    }

}
