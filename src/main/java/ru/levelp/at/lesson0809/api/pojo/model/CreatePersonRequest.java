package ru.levelp.at.lesson0809.api.pojo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter(AccessLevel.PRIVATE)
@Builder
public class CreatePersonRequest {

    private String role;
    private String email;
    private String phoneNumber;
    private String placeOfWork;
    private IdentityData identity;

    @JsonProperty("address")
    private AddressData addressData;
}
