package sfn.webservices.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile",types = Compte.class)
 public interface CompteProjectionSolde{
    public double getSolde();
    public TypeCompte getType();
}