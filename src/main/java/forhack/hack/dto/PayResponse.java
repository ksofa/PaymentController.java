package forhack.hack.dto;

import lombok.Data;

@Data
public class PayResponse {

    private String account;
    private Double amount;

    public PayResponse(String account, Double amount) {
        this.account = account;
        this.amount = amount;
    }
}
