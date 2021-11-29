package com.bluescript.demo.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Db2EndowFixed {

    private String db2EWithprofits;
    private String db2EEquities;
    private String db2EManagedfund;
    private String db2EFundname;
    private int db2ETerm;
    private int db2ESumassured;
    private String db2ELifeassured;

}
