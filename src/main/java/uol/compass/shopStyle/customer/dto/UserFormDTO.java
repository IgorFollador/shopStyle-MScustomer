package uol.compass.shopStyle.customer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import uol.compass.shopStyle.customer.constant.Sex;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Data
public class UserFormDTO {

    @NotEmpty(message = "name is required")
    @Size(min = 3, max = 14)
    private String firstName;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String lastName;

    @Getter
    private Sex sex;

    @NotEmpty
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    LocalDate birthdate;

    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 8)
    private String password;

    private Boolean active = true;

    public void setSex(String sexStr) { this.sex = Sex.valueOf(sexStr.toUpperCase()); }

}
