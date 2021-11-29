package com.bluescript.demo.jpa;

import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.bluescript.demo.dto.IGetMotorPolicyJpaDto;
import com.bluescript.demo.entity.PolicyEntity;

public interface IGetMotorPolicyJpa extends JpaRepository<PolicyEntity, Integer> {
    @QueryHints(value = { @QueryHint(name = org.hibernate.annotations.QueryHints.FETCH_SIZE, value = "100"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.READ_ONLY, value = "true") })
    @Query(value = "SELECT  ISSUEDATE as db2Issuedate,EXPIRYDATE as db2Expirydate,LASTCHANGED as db2Lastchanged,BROKERID as db2BrokeridIntindicator,BROKERSREFERENCE as db2Brokersrefindicator,PAYMENT as db2PaymentIntindicator,MAKE as db2MMake,MODEL as db2MModel,VALUE as db2MValueInt,REGNUMBER as db2MRegnumber,COLOUR as db2MColour,CC as db2MCcSint,YEAROFMANUFACTURE as db2MManufactured,PREMIUM as db2MPremiumInt,ACCIDENTS as db2MAccidentsInt FROM POLICY , MOTOR WHERE ( POLICY.POLICYNUMBER = MOTOR .POLICYNUMBER AND POLICY.CUSTOMERNUMBER = :db2CustomernumInt AND POLICY.POLICYNUMBER = :db2PolicynumInt )", nativeQuery = true)
    IGetMotorPolicyJpaDto getMotorPolicyByDb2CustomernumIntAndDb2PolicynumInt(
            @Param("db2CustomernumInt") int db2CustomernumInt, @Param("db2PolicynumInt") int db2PolicynumInt);
}
