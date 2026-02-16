package ma.fsr.ms.consultationservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RendezVousClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${rendezvous.service.url}")
    private String rendezvousServiceUrl;

    public void checkRendezVousExists(Long rendezvousId) {
        // L'URL doit être une String
        String url = rendezvousServiceUrl + "/internal/api/v1/rendezvous/" + rendezvousId;

        // getForObject(URL, Type de retour)
        restTemplate.getForObject(url, Object.class);
    }
}

