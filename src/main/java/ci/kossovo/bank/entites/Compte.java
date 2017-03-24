package ci.kossovo.bank.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(name = "CC", value = CompteCourant.class), @Type(name = "CE", value = CompteEpargne.class) })
@XmlSeeAlso({ CompteCourant.class, CompteEpargne.class })
public abstract class Compte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String codeCompte;
	private Date dateCreation;
	private Double solde;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_CLI")
	private Client client;
	@Column(name = "CODE_CLI", insertable = false, updatable = false)
	private long idClient;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_EMP")
	private Employe employe;
	@Column(name = "CODE_EMP", insertable = false, updatable = false)
	private long idEmp;
	

	public Compte() {
		super();
		
	}

	public Compte(String codeCompte, Date dateCreation, Double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;

	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public long getIdEmp() {
		return idEmp;
	}

	/*
	 * @JsonIgnore
	 * 
	 * @XmlTransient public Collection<Operation> getOperations() { return
	 * operations; } public void setOperations(Collection<Operation> operations)
	 * { this.operations = operations; }
	 */
	public long getIdClient() {
		return idClient;
	}

}
