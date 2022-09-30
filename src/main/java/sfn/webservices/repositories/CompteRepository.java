package sfn.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import sfn.webservices.entities.Compte;
import sfn.webservices.entities.TypeCompte;

import java.util.List;


@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
    @RestResource(path = "byType")
    public List<Compte>  findByType(@Param("t") TypeCompte type);
    //http://localhost:8082/api/comptes/search/findByType?type=COURANT
    //http://localhost:8082/api/comptes/search/byType?t=COURANT
}
