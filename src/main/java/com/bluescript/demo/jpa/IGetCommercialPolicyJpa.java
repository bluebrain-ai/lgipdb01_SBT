package com.bluescript.demo.jpa;

import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.bluescript.demo.dto.IGetCommercialPolicy2JpaDto;
import com.bluescript.demo.dto.IGetCommercialPolicyJpaDto;
import com.bluescript.demo.entity.PolicyEntity;

public interface IGetCommercialPolicyJpa extends JpaRepository<PolicyEntity, Integer> {
    @QueryHints(value = { @QueryHint(name = org.hibernate.annotations.QueryHints.FETCH_SIZE, value = "100"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "false"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.READ_ONLY, value = "true") })
    @Query(value = "SELECT  REQUESTDATE as db2Lastchanged,STARTDATE as db2Issuedate,RENEWALDATE as db2Expirydate,ADDRESS as db2BAddress,ZIPCODE as db2BPostcode,LATITUDEN as db2BLatitude,LONGITUDEW as db2BLongitude,CUSTOMER as db2BCustomer,PROPERTYTYPE as db2BProptype,FIREPERIL as db2BFireperilInt,FIREPREMIUM as db2BFirepremiumInt,CRIMEPERIL as db2BCrimeperilInt,CRIMEPREMIUM as db2BCrimepremiumInt,FLOODPERIL as db2BFloodperilInt,FLOODPREMIUM as db2BFloodpremiumInt,WEATHERPERIL as db2BWeatherperilInt,WEATHERPREMIUM as db2BWeatherpremiumInt,STATUS as db2BStatusInt,REJECTIONREASON as db2BRejectreason FROM POLICY , COMMERCIAL WHERE ( POLICY.POLICYNUMBER = COMMERCIAL.POLICYNUMBER AND POLICY.CUSTOMERNUMBER = :db2CustomernumInt AND POLICY.POLICYNUMBER = :db2PolicynumInt )", nativeQuery = true)
    IGetCommercialPolicy2JpaDto getCommercialPolicyByDb2CustomernumIntAndDb2PolicynumInt(
            @Param("db2CustomernumInt") int db2CustomernumInt, @Param("db2PolicynumInt") int db2PolicynumInt);
}
