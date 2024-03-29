package org.example.pr06vmapi;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReqDTO {
    private String name;
    private Integer price;
    private String limit_date;
}
