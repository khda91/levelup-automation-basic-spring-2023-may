package ru.levelp.at.lesson0809.api.pojo.model;

import java.util.List;
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
public class GetPersonMessengersResponse {

    private List<PersonMessengerData> data;
    private MetaData meta;
}
