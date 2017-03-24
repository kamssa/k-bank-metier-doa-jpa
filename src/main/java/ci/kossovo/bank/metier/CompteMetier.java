package ci.kossovo.bank.metier;

import ci.kossovo.bank.entites.Compte;

public interface CompteMetier {
	public Compte saveCompte(Compte cp);
	public Compte getCompte(String code);

}
