package ci.kossovo.bank.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employe_Superieur implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
@ManyToOne
@JoinColumn(name="CODE_EMPLOYE")
private Employe employe;
@Column(name="CODE_EMPLOYE",insertable=false,updatable=false)
private long idEmpl;
@ManyToOne
@JoinColumn(name="CODEEMPLOYE_SUP")
private Employe employeSup;
@Column(name="CODEEMPLOYE_SUP",insertable=false,updatable=false)
private long idEmplSup;
public Employe_Superieur() {
	super();
}

public Employe_Superieur(Employe employe, Employe employeSup) {
	super();
	this.employe = employe;
	this.employeSup = employeSup;
}

public Employe_Superieur(Employe employe, long idEmpl, Employe employeSup, long idEmplSup) {
	super();
	this.employe = employe;
	this.idEmpl = idEmpl;
	this.employeSup = employeSup;
	this.idEmplSup = idEmplSup;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Employe getEmploye() {
	return employe;
}
public void setEmploye(Employe employe) {
	this.employe = employe;
}
public long getIdEmpl() {
	return idEmpl;
}
public void setIdEmpl(long idEmpl) {
	this.idEmpl = idEmpl;
}
public Employe getEmployeSup() {
	return employeSup;
}
public void setEmployeSup(Employe employeSup) {
	this.employeSup = employeSup;
}
public long getIdEmplSup() {
	return idEmplSup;
}
public void setIdEmplSup(long idEmplSup) {
	this.idEmplSup = idEmplSup;
}


}
