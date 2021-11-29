package com.bluescript.demo.mapper;

import com.bluescript.demo.dto.IGetClaimPolicyJpaDto;
import com.bluescript.demo.dto.IGetCommercialPolicy2JpaDto;
import com.bluescript.demo.dto.IGetCommercialPolicyJpaDto;
import com.bluescript.demo.dto.IGetEndowmentPolicyJpaDto;
import com.bluescript.demo.dto.IGetMotorPolicyJpaDto;
import com.bluescript.demo.dto.IgetHousePolicyJpaDto;
import com.bluescript.demo.jpa.IGetMotorPolicyJpa;
import com.bluescript.demo.model.CaClaim;
import com.bluescript.demo.model.CaCommercial;
import com.bluescript.demo.model.CaEndowment;
import com.bluescript.demo.model.CaHouse;
import com.bluescript.demo.model.CaMotor;
import com.bluescript.demo.model.CaPolicyCommon;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ConvObjtoObj {

    /* Endowment */
    @Mapping(target = "caIssueDate", source = "db2Issuedate")
    @Mapping(target = "caExpiryDate", source = "db2Expirydate")
    @Mapping(target = "caLastchanged", source = "db2Lastchanged")
    @Mapping(target = "caBrokerid", source = "db2BrokeridInt")
    @Mapping(target = "caBrokersref", source = "db2Brokersref")
    CaPolicyCommon db2CommonToCaPolicyCommon(IGetEndowmentPolicyJpaDto policy);

    @Mapping(target = "caEWithProfits", source = "db2EWithprofits")
    @Mapping(target = "caEEquities", source = "db2EEquities")
    @Mapping(target = "caEManagedFund", source = "db2EManagedfund")
    @Mapping(target = "caEFundName", source = "db2EFundname")
    @Mapping(target = "caETerm", source = "db2ETermSint")
    @Mapping(target = "caESumAssured", source = "db2ESumassuredInt")
    @Mapping(target = "caELifeAssured", source = "db2ELifeassured")
    @Mapping(target = "caEPaddingData", source = "db2EPaddingdata")
    CaEndowment db2EndowToCaEndowment(IGetEndowmentPolicyJpaDto endowDto);

    /* House */

    @Mapping(target = "caIssueDate", source = "db2Issuedate")
    @Mapping(target = "caExpiryDate", source = "db2Expirydate")
    @Mapping(target = "caLastchanged", source = "db2Lastchanged")
    @Mapping(target = "caBrokerid", source = "db2BrokeridInt")
    @Mapping(target = "caBrokersref", source = "db2Brokersref")
    CaPolicyCommon db2HCommonToCaPolicyCommon(IgetHousePolicyJpaDto house);

    @Mapping(target = "caHPropertyType", source = "db2HPropertytype")
    @Mapping(target = "caHBedrooms", source = "db2HBedroomsSint")
    @Mapping(target = "caHValue", source = "db2HValueInt")
    @Mapping(target = "caHHouseName", source = "db2HHousename")
    @Mapping(target = "caHHouseNumber", source = "db2HHousenumber")
    @Mapping(target = "caHPostcode", source = "db2HPostcode")
    CaHouse db2HouseToCaHouse(IgetHousePolicyJpaDto houseDto);

    /* Motor */
    @Mapping(target = "caIssueDate", source = "db2Issuedate")
    @Mapping(target = "caExpiryDate", source = "db2Expirydate")
    @Mapping(target = "caLastchanged", source = "db2Lastchanged")
    @Mapping(target = "caBrokerid", source = "db2BrokeridInt")
    @Mapping(target = "caBrokersref", source = "db2Brokersref")
    CaPolicyCommon db2MCommonToCaPolicyCommon(IGetMotorPolicyJpaDto motorpolicy);

    @Mapping(target = "caMMake", source = "db2MMake")
    @Mapping(target = "caMModel", source = "db2MModel")
    @Mapping(target = "caMValue", source = "db2MValueInt")
    @Mapping(target = "caMRegnumber", source = "db2MRegnumber")
    @Mapping(target = "caMColour", source = "db2MColour")
    @Mapping(target = "caMCc", source = "db2MCcSint")
    @Mapping(target = "caMManufactured", source = "db2MManufactured")
    @Mapping(target = "caMPremium", source = "db2MPremiumInt")
    @Mapping(target = "caMAccidents", source = "db2MAccidentsInt")
    CaMotor db2MotorToCaMotor(IGetMotorPolicyJpaDto getMotorPolicyJpaDto);

    /* commercial **/
    @Mapping(target = "caIssueDate", source = "db2Issuedate")
    @Mapping(target = "caExpiryDate", source = "db2Expirydate")
    @Mapping(target = "caLastchanged", source = "db2Lastchanged")
    CaPolicyCommon db2CommercialCommonToCaPolicyCommon(IGetCommercialPolicy2JpaDto commpolicy);

    @Mapping(target = "caBAddress", source = "db2BAddress")
    @Mapping(target = "caBPostcode", source = "db2BPostcode")
    @Mapping(target = "caBLatitude", source = "db2BLatitude")
    @Mapping(target = "caBLongitude", source = "db2BLongitude")
    @Mapping(target = "caBCustomer", source = "db2BCustomer")
    @Mapping(target = "caBProptype", source = "db2BProptype")
    @Mapping(target = "caBFireperil", source = "db2BFireperilInt")
    @Mapping(target = "caBFirepremium", source = "db2BFirepremiumInt")
    @Mapping(target = "caBCrimeperil", source = "db2BCrimeperilInt")
    @Mapping(target = "caBCrimepremium", source = "db2BCrimepremiumInt")
    @Mapping(target = "caBFloodperil", source = "db2BFloodperilInt")
    @Mapping(target = "caBFloodpremium", source = "db2BFloodpremiumInt")
    @Mapping(target = "caBWeatherperil", source = "db2BWeatherperilInt")
    @Mapping(target = "caBWeatherpremium", source = "db2BWeatherpremiumInt")
    @Mapping(target = "caBStatus", source = "db2BStatusInt")
    @Mapping(target = "caBRejectreason", source = "db2BRejectreason")
    CaCommercial db2CommercialToCaCommercial(IGetCommercialPolicy2JpaDto commercialDto);

    /** claim */
    // @Mapping(target = "caIssueDate", source = "db2Issuedate")
    // @Mapping(target = "caExpiryDate", source = "db2Expirydate")
    // @Mapping(target = "caLastchanged", source = "db2Lastchanged")
    // CaPolicyCommon db2ClaimCommonToCaPolicyCommon(IGetClaimPolicyJpaDto claimpolicy);

    @Mapping(target = "caCNum", source = "db2ClaimnumInt")
    @Mapping(target = "caCDate", source = "db2CDate")
    @Mapping(target = "caCPaid", source = "db2CPaidInt")
    @Mapping(target = "caCValue", source = "db2CValueInt")
    @Mapping(target = "caCCause", source = "db2CCause")
    @Mapping(target = "caCObservations", source = "db2CObservations")
    CaClaim db2ClaimToCaClaim(IGetClaimPolicyJpaDto claimDto);

}
