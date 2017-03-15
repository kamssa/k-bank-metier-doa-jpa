package ci.kossovo.bank.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(length=1)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
@Type(name="V",value=Versement.class),
@Type(name="R",value= Retrait.class)
})
@XmlSeeAlso({Retrait.class,Versement.class})
public class Operation implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long numOperation;
private Date dateCreation;
private Double montant;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CODE_CPTE")
private Compte compte;
@Column(name="CODE_CPTE",insertable=false,updatable=false)
private String codeCompte;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CODE_EMP")
private Employe employe;
@Column(name="CODE_EMP",insertable=false,updatable=false)
private long idEmp;
@Temporal(TemporalType.DATE)
private Date dateOperation;
public Date getDateOperation() {
	return dateOperation;
}
public void setDateOperation(Date dateOperation) {
	this.dateOperation = dateOperation;
}
@PrePersist
private void dateOp(){
	setDateOperation(dateCreation);
}
public long getIdEmp() {
	return idEmp;
}
public Operation() {
	super();
}
public Operation(Date dateCreation, Double montant) {
	super();
	this.dateCreation = dateCreation;
	this.montant = montant;
}
public String getCodeCompte() {
	return codeCompte;
}
public Long getNumOperation() {
	return numOperation;
}
public void setNumOperation(Long numOperation) {
	this.numOperation = numOperation;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public Double getMontant() {
	return montant;
}
public void setMontant(Double montant) {
	this.montant = montant;
}
@JsonIgnore
@XmlTransient
public Compte getCompte() {
	return compte;
}
@JsonSetter
public void setCompte(Compte compte) {
	this.compte = compte;
}
@JsonIgnore
@XmlTransient
public Employe getEmploye() {
	return employe;
}
@JsonSetter
public void setEmploye(Employe employe) {
	this.employe = employe;
}




}
