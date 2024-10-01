package ma.fpl.tp2ex11.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import ma.fpl.tp2ex11.entity.Compte;
import ma.fpl.tp2ex11.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestion des Comptes Bancaires API",
                description = "Cette API permet de gérer les comptes bancaires avec des opérations CRUD et des fonctionnalités supplémentaires comme le crédit et le débit.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Ayoub Ajdour",
                        email = "ayoubajdour20@gmail.com",
                        url = "https://www.linkedin.com/in/ayoub-ajdour-422198244/"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8296",
                        description = "Serveur Local"
                ),
                @Server(
                        url = "https://api.ajdour.com",
                        description = "Serveur de Production"
                )
        }
)
@RestController
@RequestMapping("/api/v1/")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping("/afficher")
    public ResponseEntity<List<Compte>> afficherComptes() {
        return ResponseEntity.ok(compteService.afficherComptes());
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Compte> ajouterCompte(@RequestBody Compte compte) {
        return ResponseEntity.ok(compteService.ajouterCompte(compte));
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerCompte(@PathVariable Long id) {
        compteService.supprimerCompte(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/mettreAJour")
    public ResponseEntity<Compte> mettreAJourCompte(@RequestBody Compte compte) {
        return ResponseEntity.ok(compteService.mettreAJourCompte(compte));
    }

    @GetMapping("/consulter/{id}")
    public ResponseEntity<Compte> consulterCompte(@PathVariable Long id) {
        return ResponseEntity.ok(compteService.consulterCompte(id));
    }

    @PostMapping("/crediter/{id}")
    public ResponseEntity<Compte> crediterCompte(@PathVariable Long id, @RequestParam double montant) {
        return ResponseEntity.ok(compteService.crediterCompte(id, montant));
    }

    @PostMapping("/debiter/{id}")
    public ResponseEntity<Compte> debiterCompte(@PathVariable Long id, @RequestParam double montant) {
        return ResponseEntity.ok(compteService.debiterCompte(id, montant));
    }
}
