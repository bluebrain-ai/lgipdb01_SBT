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

    @Mapping(target = "caEWithProfits", source = "db2EWithprofits")
    @Mapping(target = "caEEquities", source = "db2EEquities")
    @Mapping(target = "caEManagedFund", source = "db2EManagedfund")
    @Mapping(target = "caEFundName", source = "db2EFundname")
    @Mapping(target = "caETerm", source = "db2ETermSint")
    @Mapping(target = "caESumAssured", source = "db2ESumassuredInt")
    @Mapping(target = "caELifeAssured", source = "db2ELifeassured")
    @Mapping(target = "caEPaddingData", source = "db2EPaddingdata")
    CaEndowment db2EndowToCaEndowment(IGetPolicyJpaDto endowDto);

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

}
