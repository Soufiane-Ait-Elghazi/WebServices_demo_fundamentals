package sfn.webservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sfn.webservices.entities.Compte;
import sfn.webservices.repositories.CompteRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRS {

    @Autowired
    private CompteRepository compteRepository;

    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Compte> compteList(){
     return compteRepository.findAll() ;
    }

    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam(value = "id") Long id){
        return compteRepository.findById(id).get() ;
    }


    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte saveOne(Compte compte){
        return compteRepository.save(compte) ;
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte updateOne(Compte compte,@PathParam(value = "id")Long id){
        compte.setId(id);
        return compteRepository.save(compte) ;
    }


    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void updateOne(@PathParam(value = "id")Long id){
        compteRepository.deleteById(id) ;
    }
}
