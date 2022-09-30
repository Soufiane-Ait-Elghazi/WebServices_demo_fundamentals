package sfn.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sfn.webservices.entities.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
}
