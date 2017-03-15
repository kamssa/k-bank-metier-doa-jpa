package ci.kossovo.bank.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CE")
@XmlType(name="CE")
public class CompteEpargne extends Compte {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public CompteEpargne(String codeCompte, Date dateCreation, Double solde, Double taux) {
		super(codeCompte, dateCreation, solde);
		this.taux = taux;
	}

private Double taux;

public CompteEpargne() {
	super();
	// TODO Auto-generated constructor stub
}

public Double getTaux() {
	return taux;
}

public void setTaux(Double taux) {
	this.taux = taux;
}


}
