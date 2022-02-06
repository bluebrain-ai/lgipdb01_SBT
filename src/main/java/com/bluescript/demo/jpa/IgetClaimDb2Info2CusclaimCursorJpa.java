package com.bluescript.demo.jpa;

import java.util.stream.Stream;

import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.bluescript.demo.dto.IGetClaimPolicyJpaDto;
import com.bluescript.demo.entity.PolicyEntity;

public interface IgetClaimDb2Info2CusclaimCursorJpa extends JpaRepository<PolicyEntity, String> {
    @QueryHints(value = 
    { 
            @QueryHint(name = org.hibernate.annotations.QueryHints.FETCH_SIZE, value = "100"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "false"),
            @QueryHint(name = org.hibernate.annotations.QueryHints.READ_ONLY, value = "true") })
    @Query(value = "SELECT  POLICY.CUSTOMERNUMBER as db2CustomernumInt,CLAIMNUMBER as db2ClaimnumInt,CLAIM.POLICYNUMBER as db2PolicynumInt,CLAIMDATE as db2CDate,PAID as db2CPaidInt,VALUE as db2CValueInt,CAUSE as db2CCause,OBSERVATIONS as db2CObservations FROM POLICY , CLAIM WHERE ( POLICY.POLICYNUMBER = CLAIM.POLICYNUMBER AND POLICY.CUSTOMERNUMBER = :db2CustomernumInt )", nativeQuery = true)
    Stream<IGetClaimPolicyJpaDto> getCusclaimCursorByDb2CustomernumInt(
            @Param("db2CustomernumInt") int db2CustomernumInt);
}
