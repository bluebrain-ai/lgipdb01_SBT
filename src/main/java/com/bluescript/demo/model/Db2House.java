package com.bluescript.demo.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Db2House {
    private String db2HPropertytype;
    private int db2HBedrooms;
    private int db2HValue;
    private String db2HHousename;
    private String db2HHousenumber;
    private String db2HPostcode;
}
