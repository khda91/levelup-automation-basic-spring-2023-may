package ru.levelp.at.lesson0809.api.pojo.model;

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
public class PaginationData {

    private Integer limit;
    private Integer offset;
    private Integer totalCount;
}