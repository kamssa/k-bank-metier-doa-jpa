package ci.kossovo.bank.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.kossovo.bank.dao.CompteRepository;
import ci.kossovo.bank.dao.EmployeRepository;
import ci.kossovo.bank.dao.OperationRepository;
import ci.kossovo.bank.entites.Compte;
import ci.kossovo.bank.entites.Employe;
import ci.kossovo.bank.entites.Operation;
import ci.kossovo.bank.entites.Retrait;
import ci.kossovo.bank.entites.Versement;

@Service
public class OperationMetierImpl implements OperationMetier {
@Autowired
	private OperationRepository operationRepository;
@Autowired
private CompteRepository compteRepository;
@Autowired
private EmployeRepository employeRepository;



@Transactional
	@Override
	public boolean verser(String code, double montant, Long codeEmp) {
		// TODO Auto-generated method stub
		Compte cp = compteRepository.findOne(code);
		Employe e =employeRepository.findOne(codeEmp);
		Operation o = new Versement();
		o.setDateCreation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}
   @Transactional
	@Override
	public boolean retirer(String code,double montant,Long codeEmp) {
		// TODO Auto-generated method stub
	   Compte cp = compteRepository.findOne(code);
	   if (cp.getSolde()<montant) throw new RuntimeException("solde insuffisant");
		
	
		Employe e =employeRepository.findOne(codeEmp);
		Operation o = new Retrait();
		o.setDateCreation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}
   @Transactional
	@Override
	public boolean virement(String cpte1,String cpte2,double montant,Long codeEmp) {
		// TODO Auto-generated method stub
		retirer(cpte1, montant, codeEmp);
		verser(cpte2, montant, codeEmp);
	   return true;
	}


}
