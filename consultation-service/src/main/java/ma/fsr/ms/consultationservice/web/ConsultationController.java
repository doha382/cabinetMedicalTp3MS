package ma.fsr.ms.consultationservice.web;

import ma.fsr.ms.consultationservice.model.Consultation;
import ma.fsr.ms.consultationservice.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/api/v1/consultations") // Retiré "internal" pour correspondre à l'usage standard
public class ConsultationController {

    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping
    public Consultation createConsultation(@RequestBody Consultation consultation) {
        return consultationService.save(consultation);
    }

    @GetMapping
    public List<Consultation> getAllConsultations() {
        // CORRECTION : findAll() au lieu de finalize()
        return consultationService.findAll();
    }

    @GetMapping("/{id}")
    public Consultation getConsultationById(@PathVariable Long id) {
        return consultationService.findById(id);
    }

    @GetMapping("/rendezvous/{rdvId}")
    public List<Consultation> getConsultationsByRendezVous(@PathVariable Long rdvId) {
        // CORRECTION : Assurez-vous que le nom matche la méthode du Service
        return consultationService.findByRendezvousId(rdvId);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultation(@PathVariable Long id) {
        consultationService.delete(id);
    }
}