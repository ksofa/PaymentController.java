package forhack.hack.controller;

import forhack.hack.dto.NotificationRequest;
import forhack.hack.dto.PayRequest;
import forhack.hack.dto.PayResponse;
import forhack.hack.entity.Notification;
import forhack.hack.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService providerService;

    @PostMapping("/pay")
    public ResponseEntity<?> payProvider(@RequestBody PayRequest payRequest) {
        Double amount = providerService.payProvider(payRequest);

        PayResponse payResponse = new PayResponse(payRequest.getAccount(), amount);

        return new ResponseEntity<>(payResponse, HttpStatus.OK);
    }

    @PostMapping("/sendnotification")
    public ResponseEntity<?> sendNotification(@RequestBody NotificationRequest notificationRequest){
        Notification notification = providerService.sendNotification(notificationRequest);

        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

}


