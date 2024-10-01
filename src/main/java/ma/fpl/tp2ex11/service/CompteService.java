package ma.fpl.tp2ex11.service;

import ma.fpl.tp2ex11.entity.Compte;
import ma.fpl.tp2ex11.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public Compte ajouterCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public void supprimerCompte(Long id) {
        compteRepository.deleteById(id);
    }

    public Compte mettreAJourCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public List<Compte> afficherComptes() {
        return compteRepository.findAll();
    }

    public Compte consulterCompte(Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    public Compte crediterCompte(Long id, double montant) {
        Compte compte = consulterCompte(id);
        if (compte != null) {
            compte.setSolde(compte.getSolde() + montant);
            return compteRepository.save(compte);
        }
        return null;
    }

    public Compte debiterCompte(Long id, double montant) {
        Compte compte = consulterCompte(id);
        if (compte != null && compte.getSolde() >= montant) {
            compte.setSolde(compte.getSolde() - montant);
            return compteRepository.save(compte);
        }
        return null;
    }
}
