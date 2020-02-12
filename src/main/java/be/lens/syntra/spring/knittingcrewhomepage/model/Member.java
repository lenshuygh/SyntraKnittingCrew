package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Member {
    private int id;
    private String name;
    private String familyName;
    private String email;
    private KnittingCrewRole knittingCrewRole;
    private Address address;
    private String phone;
    private LocalDate birthDate;
    private Collection<Stitches> knownStitches;
}
