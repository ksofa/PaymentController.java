package forhack.hack.dto;

import lombok.Data;

@Data
public class NotificationRequest {

    private String providerName;
    private String account;
    private String description;

}
