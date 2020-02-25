package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Member {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String familyName;
    @NotEmpty
    private String email;
    @NotNull
    private KnittingCrewRole knittingCrewRole;
    @Valid
    private Address address;
    @NotEmpty
    private String phone;
    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    @Size(min = 1)
    private Collection<Stitches> knownStitches;
}
