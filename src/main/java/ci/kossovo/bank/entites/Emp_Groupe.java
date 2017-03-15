package ci.kossovo.bank.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emp_Groupe implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_Emp_Groupe;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="ID_EMP")
   private Employe employe;
   @Column(name="ID_EMP",insertable=false,updatable=false)
   private long idEmp;
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="ID_GROUPE")
   private Groupe groupe;
   @Column(name="ID_GROUPE",insertable=false,updatable=false)
   private long idGroupe;
public Employe getEmploye() {
	return employe;
}
public void setEmploye(Employe employe) {
	this.employe = employe;
}
public Groupe getGroupe() {
	return groupe;
}
public void setGroupe(Groupe groupe) {
	this.groupe = groupe;
}
public Long getId_Emp_Groupe() {
	return id_Emp_Groupe;
}
public long getIdEmp() {
	return idEmp;
}
   
}
