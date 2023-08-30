package forhack.hack.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    private Provider sender;
    @OneToOne
    private User recipient;
    private String description;

    public Notification(Provider provider, User user, String description) {
        this.sender = provider;
        this.recipient = user;
        this.description = description;
    }

    public Notification() {

    }
}
