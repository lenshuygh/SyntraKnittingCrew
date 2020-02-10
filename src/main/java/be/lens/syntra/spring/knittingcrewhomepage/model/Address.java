package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Builder
public class Address {
    private String street;
    private String houseNumber;
    private String poBox;
    private String zipCode;
    private String city;
}
