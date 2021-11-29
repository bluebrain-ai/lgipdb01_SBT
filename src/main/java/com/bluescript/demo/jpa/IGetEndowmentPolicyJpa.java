package com.bluescript.demo.jpa;

import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.bluescript.demo.dto.IGetEndowmentPolicyJpaDto;
import com.bluescript.demo.entity.PolicyEntity;

public interface IGetEndowmentPolicyJpa extends JpaRepository<PolicyEntity, Integer> {
    @QueryHints(value = { @QueryHint(name = org.hibernate.annotations.QueryHints.FETCH_SIZE, value = "100"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "false"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.READ_ONLY, value = "true") })
    @Query(value = "SELECT  ISSUEDATE as db2Issuedate,EXPIRYDATE as db2Expirydate,LASTCHANGED as db2Lastchanged,BROKERID as db2BrokeridInt,BROKERSREFERENCE as db2Brokersref,PAYMENT as db2PaymentInt,WITHPROFITS as db2EWithprofits,EQUITIES as db2EEquities,MANAGEDFUND as db2EManagedfund,FUNDNAME as db2EFundname,TERM as db2ETermSint,SUMASSURED as db2ESumassuredInt,LIFEASSURED as db2ELifeassured,PADDINGDATA as db2EPaddingdata,LENGTH(PADDINGDATA) as db2EPaddingLen FROM POLICY , ENDOWMENT WHERE ( POLICY.POLICYNUMBER = ENDOWMENT.POLICYNUMBER AND POLICY.CUSTOMERNUMBER = :db2CustomernumInt AND POLICY.POLICYNUMBER = :db2PolicynumInt )", nativeQuery = true)
    IGetEndowmentPolicyJpaDto getPolicyByDb2CustomernumIntAndDb2PolicynumInt(
            @Param("db2CustomernumInt") int db2CustomernumInt, @Param("db2PolicynumInt") int db2PolicynumInt);
}
