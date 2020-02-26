package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Member {
    private int id;
    @NotEmpty(message = "Please enter a name")
    private String name;
    @NotEmpty(message = "Please enter a family name")
    private String familyName;
    @NotEmpty(message = "Please enter an email")
    @Email(message = "Please enter a valid email")
    private String email;
    @NotNull
    private KnittingCrewRole knittingCrewRole;
    @Valid
    private Address address;
    @NotEmpty(message = "Please enter a phone number")
    private String phone;
    @NotNull(message = "Please enter a date")
    @Past(message = "The date must be in the past")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    @Size(min = 1,message = "Please select at least one stitch")
    private Collection<Stitches> knownStitches;
}
