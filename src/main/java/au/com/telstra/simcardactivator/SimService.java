package au.com.telstra.simcardactivator;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SimService {
    private final RestTemplate restTemplate;

    public SimService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void sendPostRequest(String iccid) {
        // url to activate sim card
        String url = "http://localhost:8444/actuate";
        
        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request Body with the the variable iccid
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("iccid", iccid);

        // Create request entity
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        if (response.getStatusCode().is2xxSuccessful()){
            System.out.println("Sim card activated successfully");
        }
        else {
            System.out.println("Error activating sim card");
        }
    }
}
