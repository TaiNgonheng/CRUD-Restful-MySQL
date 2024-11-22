package Restful_Webservice.Spring.Boot.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.stereotype.Service;

@Schema(
        description = "UserDTO model Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    // User first name should not be null or empty
    @Schema(
            description = "User First name"
    )
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstname;

    // User last name should not be null or empty
    @Schema(
            description = "User Last name"
    )
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastname;



    @Schema(
            description = "User Email Address"
    )
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email;
}
