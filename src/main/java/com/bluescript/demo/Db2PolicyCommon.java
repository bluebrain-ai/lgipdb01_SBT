package com.bluescript.demo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Db2PolicyCommon {
    private String db2Issuedate;
    private String db2Expirydate;
    private String db2Lastchanged;
    private int db2Brokerid;
    private String db2Brokersref;
    private int db2Payment;
}
