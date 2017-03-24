package ci.kossovo.bank.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.kossovo.bank.dao.CompteRepository;
import ci.kossovo.bank.entites.Compte;

@Service
public class CompteMetierImpl implements CompteMetier{
 @Autowired
	private CompteRepository compteRepository;
	@Override
	public Compte saveCompte(Compte cp) {
		// TODO Auto-generated method stub
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	@Override
	public Compte getCompte(String code) {
		// TODO Auto-generated method stub
        Compte cp = compteRepository.findOne(code);
		if(cp==null)throw new RuntimeException("compte innexistant");
        return cp; 
	}

}
