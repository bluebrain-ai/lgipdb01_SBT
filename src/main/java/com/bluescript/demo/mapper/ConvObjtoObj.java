package com.bluescript.demo.mapper;

import com.bluescript.demo.dto.IGetPolicyJpaDto;
import com.bluescript.demo.dto.IgetHousePolicyJpaDto;
import com.bluescript.demo.model.CaEndowment;
import com.bluescript.demo.model.CaHouse;
import com.bluescript.demo.model.CaPolicyCommon;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ConvObjtoObj {

    @Mapping(target = "caIssueDate", source = "db2Issuedate")
    @Mapping(target = "caExpiryDate", source = "db2Expirydate")
    @Mapping(target = "caLastchanged", source = "db2Lastchanged")
    @Mapping(target = "caBrokerid", source = "db2BrokeridInt")
    @Mapping(target = "caBrokersref", source = "db2Brokersref")
    CaPolicyCommon db2CommonToCaPolicyCommon(IGetPolicyJpaDto policy);

    CaPolicyCommon db2HCommonToCaPolicyCommon(IgetHousePolicyJpaDto policy);

    @Mapping(target = "caEWithProfits", source = "db2EWithprofits")
    @Mapping(target = "caEEquities", source = "db2EEquities")
    @Mapping(target = "caEManagedFund", source = "db2EManagedfund")
    @Mapping(target = "caEFundName", source = "db2EFundname")
    @Mapping(target = "caETerm", source = "db2ETermSint")
    @Mapping(target = "caESumAssured", source = "db2ESumassuredInt")
    @Mapping(target = "caELifeAssured", source = "db2ELifeassured")
    @Mapping(target = "caEPaddingData", source = "db2EPaddingdata")
    CaEndowment db2EndowToCaEndowment(IGetPolicyJpaDto endowDto);



    /** House */
    // @Mapping(target = "caIssueDate", source = "db2Issuedate")
    // @Mapping(target = "caExpiryDate", source = "db2Expirydate")
    // @Mapping(target = "caLastchanged", source = "db2Lastchanged")
    // @Mapping(target = "caBrokerid", source = "db2BrokeridInt")
    // @Mapping(target = "caBrokersref", source = "db2Brokersref")
    // CaPolicyCommon db2CommonToCaPolicyCommon(IgetHousePolicyJpaDto policy);
//--- completed

    @Mapping(target = "caEWithProfits", source = "db2HPropertytype")
    @Mapping(target = "caEEquities", source = "db2HBedrooms")
    @Mapping(target = "caEManagedFund", source = "db2HValue")
    @Mapping(target = "caEFundName", source = "db2HHousename")
    @Mapping(target = "caETerm", source = "db2HHousenumber")
    @Mapping(target = "caESumAssured", source = "db2HPostcode")
   
    CaHouse db2HouseToCaHouse(IgetHousePolicyJpaDto houseDto);



    @Mapping(target = "caEWithProfits", source = "db2HPropertytype")
    @Mapping(target = "caEEquities", source = "db2HBedrooms")
    @Mapping(target = "caEManagedFund", source = "db2HValue")
    @Mapping(target = "caEFundName", source = "db2HHousename")
    @Mapping(target = "caETerm", source = "db2HHousenumber")
    @Mapping(target = "caESumAssured", source = "db2HPostcode")
    @Mapping(target = "caESumAssured", source = "db2HPostcode")
    @Mapping(target = "caESumAssured", source = "db2HPostcode")
    CaHouse db2MotorToCaMotor(IgetHousePolicyJpaDto houseDto);

}
