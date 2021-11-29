package com.bluescript.demo.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Db2Commercial {
    private String db2BAddress;
    private String db2BPostcode;
    private String db2BLatitude;
    private String db2BLongitude;
    private String db2BCustomer;
    private String db2BProptype;
    private int db2BFireperil;
    private int db2BFirepremium;
    private int db2BCrimeperil;
    private int db2BCrimepremium;
    private int db2BFloodperil;
    private int db2BFloodpremium;
    private int db2BWeatherperil;
    private int db2BWeatherpremium;
    private int db2BStatus;
    private String db2BRejectreason;
}
