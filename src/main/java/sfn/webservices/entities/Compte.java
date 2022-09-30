package sfn.webservices.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity

@XmlRootElement
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private TypeCompte type ;
    @ManyToOne
    Client client;

}
