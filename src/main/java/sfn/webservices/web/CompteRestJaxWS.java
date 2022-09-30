package sfn.webservices.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sfn.webservices.entities.Compte;
import sfn.webservices.repositories.CompteRepository;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS")
public class CompteRestJaxWS {

    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> compteList(){
     return compteRepository.findAll() ;
    }

    @WebMethod
    public Compte getOne(@WebParam(name = "id") Long id){
        return compteRepository.findById(id).get() ;
    }


}
