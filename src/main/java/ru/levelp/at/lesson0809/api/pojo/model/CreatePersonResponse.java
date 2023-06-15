package ru.levelp.at.lesson0809.api.pojo.model;

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
public class CreatePersonResponse {

    private PersonData data;

    public static CreatePersonResponse from(CreatePersonRequest request) {
        return CreatePersonResponse
            .builder()
            .data(PersonData
                .builder()
                .role(request.getRole())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .placeOfWork(request.getPlaceOfWork())
                .identity(IdentityData
                    .builder()
                    .gender(request.getIdentity().getGender())
                    .placeOfBirth(request.getIdentity().getPlaceOfBirth())
                    .dateOfBirth(request.getIdentity().getDateOfBirth())
                    .lastName(request.getIdentity().getLastName())
                    .firstName(request.getIdentity().getFirstName())
                    .middleName(request.getIdentity().getMiddleName())
                    .passport(request.getIdentity().getPassport() == null
                        ? PassportData.builder().build()
                        : request.getIdentity().getPassport())
                    .build())
                .addressData(request.getAddressData() == null
                    ? AddressData.builder().build()
                    : request.getAddressData())
                .build())
            .build();
    }
}
