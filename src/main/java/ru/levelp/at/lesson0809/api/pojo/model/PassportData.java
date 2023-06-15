package ru.levelp.at.lesson0809.api.pojo.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class PassportData {

    private String series;
    private String number;
    private String placeOfIssue;
    private LocalDate dateOfIssue;
    private String departmentCode;
}
