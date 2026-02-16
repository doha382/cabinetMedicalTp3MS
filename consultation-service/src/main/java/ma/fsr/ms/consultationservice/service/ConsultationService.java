package ma.fsr.ms.consultationservice.service;

import ma.fsr.ms.consultationservice.client.RendezVousClient;
import ma.fsr.ms.consultationservice.model.Consultation;
import ma.fsr.ms.consultationservice.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    private final ConsultationRepository repository;
    private final RendezVousClient rdvClient;

    public ConsultationService(ConsultationRepository repository, RendezVousClient rdvClient) {
        this.repository = repository;
        this.rdvClient = rdvClient;
    }

    // 1. Enregistrer une consultation avec validation
    public Consultation save(Consultation c) {
        // Le client lève une exception si le RDV n'existe pas
        rdvClient.checkRendezVousExists(c.getRendezvousId());

        if (c.getRapport() == null || c.getRapport().length() < 10) {
            throw new RuntimeException("Le rapport doit contenir au moins 10 caractères.");
        }

        return repository.save(c);
    }

    // 2. Récupérer toutes les consultations
    public List<Consultation> findAll() {
        return repository.findAll();
    }

    // 3. Récupérer par ID (Correction : gestion de l'Optional)
    public Consultation findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation introuvable avec l'ID : " + id));
    }

    // 4. Récupérer par ID de Rendez-vous (Doit être déclaré dans le Repository)
    public List<Consultation> findByRendezvousId(Long rendezvousId) {
        return repository.findByRendezvousId(rendezvousId);
    }

    // 5. Supprimer (Correction : le nom correct est deleteById)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : Consultation inexistante.");
        }
        repository.deleteById(id);
    }
}