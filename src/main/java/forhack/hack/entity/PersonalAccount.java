package forhack.hack.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PersonalAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String account;

}
