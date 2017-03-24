package ci.kossovo.bank.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ci.kossovo.bank.entites.Employe;


@Service
public class EmployeMetierImpl implements IEmployeMetier {
	@Autowired
	IEmployeMetier employeRepository;

	@Override
	public Employe saveEmploye(Employe emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> listDesEmployes() {
		
		return null;
	}

	@Override
	public List<Employe> trouverLesEmpDuSup(long idSup) {
		
		return null;
	}

	@Override
	public Employe trouverEmpParCode(Long codeEmp) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
