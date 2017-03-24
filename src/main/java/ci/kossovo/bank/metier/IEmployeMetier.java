package ci.kossovo.bank.metier;

import java.util.List;

import ci.kossovo.bank.entites.Employe;


public interface IEmployeMetier {

	public Employe saveEmploye(Employe emp);

	public List<Employe> listDesEmployes();

	public List<Employe> trouverLesEmpDuSup(long idSup);

	public Employe trouverEmpParCode(Long codeEmp);

}
