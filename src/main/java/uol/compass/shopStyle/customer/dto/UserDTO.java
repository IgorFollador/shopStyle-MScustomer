package uol.compass.shopStyle.customer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import uol.compass.shopStyle.customer.constant.Sex;
import uol.compass.shopStyle.customer.entity.User;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Sex sex;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    LocalDate birthdate;
    private String email;
    private Boolean active;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.sex = user.getSex();
        this.cpf = user.getCpf();
        this.birthdate = user.getBirthdate();
        this.email = user.getEmail();
        this.active = user.getActive();
    }
}
