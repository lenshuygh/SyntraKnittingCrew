package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
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
