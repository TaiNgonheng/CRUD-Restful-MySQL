package Restful_Webservice.Spring.Boot.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

}
