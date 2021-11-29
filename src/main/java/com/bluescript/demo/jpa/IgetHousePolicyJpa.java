package com.bluescript.demo.jpa;

import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.bluescript.demo.dto.IgetHousePolicyJpaDto;
import com.bluescript.demo.entity.PolicyEntity;

public interface IgetHousePolicyJpa extends JpaRepository<PolicyEntity, Integer> {
    @QueryHints(value = { @QueryHint(name = org.hibernate.annotations.QueryHints.FETCH_SIZE, value = "100"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "false"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.READ_ONLY, value = "true") })
    @Query(value = "SELECT  ISSUEDATE as db2Issuedate,EXPIRYDATE as db2Expirydate,LASTCHANGED as db2Lastchanged,BROKERID as db2BrokeridIntindicator,BROKERSREFERENCE as db2Brokersrefindicator,PAYMENT as db2PaymentIntindicator,PROPERTYTYPE as db2HPropertytype,BEDROOMS as db2HBedroomsSint,VALUE as db2HValueInt,HOUSENAME as db2HHousename,HOUSENUMBER as db2HHousenumber,POSTCODE as db2HPostcode FROM POLICY , HOUSE WHERE ( POLICY.POLICYNUMBER = HOUSE.POLICYNUMBER AND POLICY.CUSTOMERNUMBER = :db2CustomernumInt AND POLICY.POLICYNUMBER = :db2PolicynumInt )", nativeQuery = true)
    IgetHousePolicyJpaDto getHousePolicyByDb2CustomernumIntAndDb2PolicynumInt(
            @Param("db2CustomernumInt") int db2CustomernumInt, @Param("db2PolicynumInt") int db2PolicynumInt);
}
