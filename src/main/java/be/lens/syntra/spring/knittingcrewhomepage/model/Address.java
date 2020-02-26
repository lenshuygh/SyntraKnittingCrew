package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address {
    @NotEmpty(message = "Please enter a street")
    private String street;
    @NotEmpty(message = "Please enter a number")
    private String houseNumber;
    @Builder.Default
    private String poBox = "/";
    @NotEmpty(message = "Please enter a zip code")
    private String zipCode;
    @NotEmpty(message = "Please enter a city")
    private String city;
}
