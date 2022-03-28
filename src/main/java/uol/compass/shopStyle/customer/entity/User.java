package uol.compass.shopStyle.customer.entity;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;
import uol.compass.shopStyle.customer.constant.Sex;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String cpf;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    private String email;

    private String password;

    private Boolean active;

}
