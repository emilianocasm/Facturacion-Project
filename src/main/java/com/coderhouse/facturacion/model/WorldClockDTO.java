package com.coderhouse.facturacion.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WorldClockDTO {
    private String id;
    private String currentDateTime;
    private String utcOffset;
    private String isDayLightSavingsTime;
    private String dayOfTheWeek;
    private String timeZoneName;
    private BigDecimal currentFileTime;
    private String ordinalDate;
    private String serviceResponse;
}
