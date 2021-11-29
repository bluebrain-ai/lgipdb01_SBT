package com.bluescript.demo.dto;

import org.springframework.stereotype.Component;

@Component
public interface IGetPolicyJpaDto {
    public String getDb2Issuedate();

    public String getDb2Expirydate();

    public String getDb2Lastchanged();

    public int getDb2BrokeridInt();

    public String getDb2Brokersref();

    public int getDb2PaymentInt();

    public String getDb2EWithprofits();

    public String getDb2EEquities();

    public String getDb2EManagedfund();

    public String getDb2EFundname();

    public int getDb2ETermSint();

    public int getDb2ESumassuredInt();

    public String getDb2ELifeassured();

    public String getDb2EPaddingdata();

    public Integer getDb2EPaddingLen();
}
