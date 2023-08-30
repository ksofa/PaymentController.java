package forhack.hack.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToOne
    private PersonalAccount personalAccount;
    private Double count;

}
