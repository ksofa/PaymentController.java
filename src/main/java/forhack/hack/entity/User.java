package forhack.hack.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usrs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToOne
    private PersonalAccount personalAccount;
    private Double money;
    @OneToOne
    private Notification notification;

    public void setNotification(Provider provider, User userFromDb, String description) {
    }
}