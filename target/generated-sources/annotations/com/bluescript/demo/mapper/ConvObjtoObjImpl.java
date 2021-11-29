package com.bluescript.demo.mapper;

import com.bluescript.demo.dto.IGetPolicyJpaDto;
import com.bluescript.demo.dto.IgetHousePolicyJpaDto;
import com.bluescript.demo.model.CaEndowment;
import com.bluescript.demo.model.CaHouse;
import com.bluescript.demo.model.CaPolicyCommon;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 14 (Oracle Corporation)"
)
@Component
public class ConvObjtoObjImpl implements ConvObjtoObj {

    @Override
    public CaPolicyCommon db2CommonToCaPolicyCommon(IGetPolicyJpaDto policy) {
        if ( policy == null ) {
            return null;
        }

        CaPolicyCommon caPolicyCommon = new CaPolicyCommon();

        caPolicyCommon.setCaIssueDate( policy.getDb2Issuedate() );
        caPolicyCommon.setCaExpiryDate( policy.getDb2Expirydate() );
        caPolicyCommon.setCaLastchanged( policy.getDb2Lastchanged() );
        caPolicyCommon.setCaBrokerid( policy.getDb2BrokeridInt() );
        caPolicyCommon.setCaBrokersref( policy.getDb2Brokersref() );

        return caPolicyCommon;
    }

    @Override
    public CaEndowment db2EndowToCaEndowment(IGetPolicyJpaDto endowDto) {
        if ( endowDto == null ) {
            return null;
        }

        CaEndowment caEndowment = new CaEndowment();

        caEndowment.setCaEWithProfits( endowDto.getDb2EWithprofits() );
        caEndowment.setCaEEquities( endowDto.getDb2EEquities() );
        caEndowment.setCaEManagedFund( endowDto.getDb2EManagedfund() );
        caEndowment.setCaEFundName( endowDto.getDb2EFundname() );
        caEndowment.setCaETerm( endowDto.getDb2ETermSint() );
        caEndowment.setCaESumAssured( endowDto.getDb2ESumassuredInt() );
        caEndowment.setCaELifeAssured( endowDto.getDb2ELifeassured() );
        caEndowment.setCaEPaddingData( endowDto.getDb2EPaddingdata() );

        return caEndowment;
    }

    @Override
    public CaPolicyCommon db2HCommonToCaPolicyCommon(IgetHousePolicyJpaDto house) {
        if ( house == null ) {
            return null;
        }

        CaPolicyCommon caPolicyCommon = new CaPolicyCommon();

        caPolicyCommon.setCaIssueDate( house.getDb2Issuedate() );
        caPolicyCommon.setCaExpiryDate( house.getDb2Expirydate() );
        caPolicyCommon.setCaLastchanged( house.getDb2Lastchanged() );
        if ( house.getDb2BrokeridInt() != null ) {
            caPolicyCommon.setCaBrokerid( house.getDb2BrokeridInt() );
        }
        caPolicyCommon.setCaBrokersref( house.getDb2Brokersref() );

        return caPolicyCommon;
    }

    @Override
    public CaHouse db2HouseToCaHouse(IgetHousePolicyJpaDto houseDto) {
        if ( houseDto == null ) {
            return null;
        }

        CaHouse caHouse = new CaHouse();

        caHouse.setCaHPropertyType( houseDto.getDb2HPropertytype() );
        if ( houseDto.getDb2HBedroomsSint() != null ) {
            caHouse.setCaHBedrooms( houseDto.getDb2HBedroomsSint() );
        }
        if ( houseDto.getDb2HValueInt() != null ) {
            caHouse.setCaHValue( houseDto.getDb2HValueInt() );
        }
        caHouse.setCaHHouseName( houseDto.getDb2HHousename() );
        caHouse.setCaHHouseNumber( houseDto.getDb2HHousenumber() );
        caHouse.setCaHPostcode( houseDto.getDb2HPostcode() );

        return caHouse;
    }
}
