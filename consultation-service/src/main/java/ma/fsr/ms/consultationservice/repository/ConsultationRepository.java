package ma.fsr.ms.consultationservice.repository;

import ma.fsr.ms.consultationservice.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository; // Utilisez JpaRepository
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    // Cette méthode suffit, Spring génère le SQL automatiquement
    List<Consultation> findByRendezvousId(Long rendezvousId);

    // Pas besoin de redéfinir findAll(), JpaRepository retourne déjà une List<T>
}