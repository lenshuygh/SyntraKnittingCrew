package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
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
    private Date birthDate;
    private Stitches knownStitches;
}
