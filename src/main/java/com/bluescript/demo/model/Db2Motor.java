package com.bluescript.demo.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Db2Motor {
    private String db2MMake;
    private String db2MModel;
    private int db2MValue;
    private String db2MRegnumber;
    private String db2MColour;
    private int db2MCc;
    private String db2MManufactured;
    private int db2MPremium;
    private int db2MAccidents;
}
