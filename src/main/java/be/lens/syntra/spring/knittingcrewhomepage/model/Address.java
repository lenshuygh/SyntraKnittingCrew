package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address {
    @NotEmpty
    private String street;
    @NotEmpty
    private String houseNumber;
    private String poBox;
    @NotEmpty
    private String zipCode;
    @NotEmpty
    private String city;
}
