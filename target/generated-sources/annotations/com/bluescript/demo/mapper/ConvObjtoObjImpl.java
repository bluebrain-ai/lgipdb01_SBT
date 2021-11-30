package com.bluescript.demo.mapper;

import com.bluescript.demo.dto.IGetClaimPolicyJpaDto;
import com.bluescript.demo.dto.IGetCommercialPolicy2JpaDto;
import com.bluescript.demo.dto.IGetEndowmentPolicyJpaDto;
import com.bluescript.demo.dto.IGetMotorPolicyJpaDto;
import com.bluescript.demo.dto.IgetHousePolicyJpaDto;
import com.bluescript.demo.model.CaClaim;
import com.bluescript.demo.model.CaCommercial;
import com.bluescript.demo.model.CaEndowment;
import com.bluescript.demo.model.CaHouse;
import com.bluescript.demo.model.CaMotor;
import com.bluescript.demo.model.CaPolicyCommon;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 14 (Oracle Corporation)"
)
@Component
public class ConvObjtoObjImpl implements ConvObjtoObj {

    @Override
    public CaPolicyCommon db2CommonToCaPolicyCommon(IGetEndowmentPolicyJpaDto policy) {
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
    public CaEndowment db2EndowToCaEndowment(IGetEndowmentPolicyJpaDto endowDto) {
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

    @Override
    public CaPolicyCommon db2MCommonToCaPolicyCommon(IGetMotorPolicyJpaDto motorpolicy) {
        if ( motorpolicy == null ) {
            return null;
        }

        CaPolicyCommon caPolicyCommon = new CaPolicyCommon();

        caPolicyCommon.setCaIssueDate( motorpolicy.getDb2Issuedate() );
        caPolicyCommon.setCaExpiryDate( motorpolicy.getDb2Expirydate() );
        caPolicyCommon.setCaLastchanged( motorpolicy.getDb2Lastchanged() );
        if ( motorpolicy.getDb2BrokeridInt() != null ) {
            caPolicyCommon.setCaBrokerid( motorpolicy.getDb2BrokeridInt() );
        }
        caPolicyCommon.setCaBrokersref( motorpolicy.getDb2Brokersref() );

        return caPolicyCommon;
    }

    @Override
    public CaMotor db2MotorToCaMotor(IGetMotorPolicyJpaDto getMotorPolicyJpaDto) {
        if ( getMotorPolicyJpaDto == null ) {
            return null;
        }

        CaMotor caMotor = new CaMotor();

        caMotor.setCaMMake( getMotorPolicyJpaDto.getDb2MMake() );
        caMotor.setCaMModel( getMotorPolicyJpaDto.getDb2MModel() );
        if ( getMotorPolicyJpaDto.getDb2MValueInt() != null ) {
            caMotor.setCaMValue( getMotorPolicyJpaDto.getDb2MValueInt() );
        }
        caMotor.setCaMRegnumber( getMotorPolicyJpaDto.getDb2MRegnumber() );
        caMotor.setCaMColour( getMotorPolicyJpaDto.getDb2MColour() );
        if ( getMotorPolicyJpaDto.getDb2MCcSint() != null ) {
            caMotor.setCaMCc( getMotorPolicyJpaDto.getDb2MCcSint() );
        }
        caMotor.setCaMManufactured( getMotorPolicyJpaDto.getDb2MManufactured() );
        if ( getMotorPolicyJpaDto.getDb2MPremiumInt() != null ) {
            caMotor.setCaMPremium( getMotorPolicyJpaDto.getDb2MPremiumInt() );
        }
        if ( getMotorPolicyJpaDto.getDb2MAccidentsInt() != null ) {
            caMotor.setCaMAccidents( getMotorPolicyJpaDto.getDb2MAccidentsInt() );
        }

        return caMotor;
    }

    @Override
    public CaPolicyCommon db2CommercialCommonToCaPolicyCommon(IGetCommercialPolicy2JpaDto commpolicy) {
        if ( commpolicy == null ) {
            return null;
        }

        CaPolicyCommon caPolicyCommon = new CaPolicyCommon();

        caPolicyCommon.setCaIssueDate( commpolicy.getdb2Issuedate() );
        caPolicyCommon.setCaExpiryDate( commpolicy.getdb2Expirydate() );
        caPolicyCommon.setCaLastchanged( commpolicy.getdb2Lastchanged() );

        return caPolicyCommon;
    }

    @Override
    public CaCommercial db2CommercialToCaCommercial(IGetCommercialPolicy2JpaDto commercialDto) {
        if ( commercialDto == null ) {
            return null;
        }

        CaCommercial caCommercial = new CaCommercial();

        caCommercial.setCaBAddress( commercialDto.getdb2BAddress() );
        caCommercial.setCaBPostcode( commercialDto.getdb2BPostcode() );
        caCommercial.setCaBLatitude( commercialDto.getdb2BLatitude() );
        caCommercial.setCaBLongitude( commercialDto.getdb2BLongitude() );
        caCommercial.setCaBCustomer( commercialDto.getdb2BCustomer() );
        caCommercial.setCaBProptype( commercialDto.getdb2BProptype() );
        if ( commercialDto.getDb2BFireperilInt() != null ) {
            caCommercial.setCaBFireperil( commercialDto.getDb2BFireperilInt() );
        }
        if ( commercialDto.getDb2BFirepremiumInt() != null ) {
            caCommercial.setCaBFirepremium( commercialDto.getDb2BFirepremiumInt() );
        }
        if ( commercialDto.getDb2BCrimeperilInt() != null ) {
            caCommercial.setCaBCrimeperil( commercialDto.getDb2BCrimeperilInt() );
        }
        if ( commercialDto.getDb2BCrimepremiumInt() != null ) {
            caCommercial.setCaBCrimepremium( commercialDto.getDb2BCrimepremiumInt() );
        }
        if ( commercialDto.getDb2BFloodperilInt() != null ) {
            caCommercial.setCaBFloodperil( commercialDto.getDb2BFloodperilInt() );
        }
        if ( commercialDto.getDb2BFloodpremiumInt() != null ) {
            caCommercial.setCaBFloodpremium( commercialDto.getDb2BFloodpremiumInt() );
        }
        if ( commercialDto.getDb2BWeatherperilInt() != null ) {
            caCommercial.setCaBWeatherperil( commercialDto.getDb2BWeatherperilInt() );
        }
        if ( commercialDto.getDb2BWeatherpremiumInt() != null ) {
            caCommercial.setCaBWeatherpremium( commercialDto.getDb2BWeatherpremiumInt() );
        }
        if ( commercialDto.getDb2BStatusInt() != null ) {
            caCommercial.setCaBStatus( commercialDto.getDb2BStatusInt() );
        }
        caCommercial.setCaBRejectreason( commercialDto.getdb2BRejectreason() );

        return caCommercial;
    }

    @Override
    public CaClaim db2ClaimToCaClaim(IGetClaimPolicyJpaDto claimDto) {
        if ( claimDto == null ) {
            return null;
        }

        CaClaim caClaim = new CaClaim();

        caClaim.setCaCNum( claimDto.getDb2ClaimnumInt() );
        caClaim.setCaCDate( claimDto.getdb2CDate() );
        caClaim.setCaCPaid( claimDto.getDb2CPaidInt() );
        caClaim.setCaCValue( claimDto.getDb2CValueInt() );
        caClaim.setCaCCause( claimDto.getdb2CCause() );
        caClaim.setCaCObservations( claimDto.getdb2CObservations() );

        return caClaim;
    }
}
