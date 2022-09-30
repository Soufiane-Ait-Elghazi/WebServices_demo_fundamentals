package sfn.webservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sfn.webservices.entities.Compte;
import sfn.webservices.repositories.CompteRepository;
import java.util.List;

//@RestController
@RequestMapping("/banque")
public class CompteRestRestController {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(path = "/comptes",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Compte> compteList(){
     return compteRepository.findAll() ;
    }

    @GetMapping(path = "/comptes/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Compte getOne(@PathVariable(value = "id") Long id){
        return compteRepository.findById(id).get() ;
    }


    @PostMapping(path = "/comptes",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Compte saveOne(@RequestBody Compte compte){
        return compteRepository.save(compte) ;
    }


    @PutMapping(path = "/comptes/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Compte updateOne(@RequestBody Compte compte,@PathVariable(value = "id")Long id){
        compte.setId(id);
        return compteRepository.save(compte) ;
    }


    @DeleteMapping(path="/comptes/{id}",produces =MediaType.APPLICATION_JSON_VALUE )
    public void updateOne(@PathVariable(value = "id")Long id){
        compteRepository.deleteById(id) ;
    }
}
