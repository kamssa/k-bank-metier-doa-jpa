package ci.kossovo.bank.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CC")
@XmlType(name="CC")
public class CompteCourant extends Compte {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Double decouvert;

public CompteCourant() {
	super();
	// TODO Auto-generated constructor stub
}

public CompteCourant(String codeCompte, Date dateCreation, Double solde, Double decouvert) {
	super(codeCompte, dateCreation, solde);
	this.decouvert = decouvert;
}

public Double getDecouvert() {
	return decouvert;
}

public void setDecouvert(Double decouvert) {
	this.decouvert = decouvert;
}



}
