package com.bluescript.demo;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;

import com.bluescript.demo.jpa.IGetClaimPolicyJpa;
import com.bluescript.demo.jpa.IGetCommercialPolicy2Jpa;
import com.bluescript.demo.jpa.IGetCommercialPolicyJpa;
import com.bluescript.demo.jpa.IGetEndowmentPolicyJpa;
import com.bluescript.demo.jpa.IGetMotorPolicyJpa;

import com.bluescript.demo.jpa.IgetClaimDb2Info2CusclaimCursorJpa;
import com.bluescript.demo.jpa.IgetCommercialDb2Info3CustCursorJpa;
import com.bluescript.demo.jpa.IgetCommercialDb2Info5ZipCursorJpa;
import com.bluescript.demo.jpa.IgetHousePolicyJpa;
import com.bluescript.demo.mapper.ConvObjtoObj;
import com.bluescript.demo.dto.IGetClaimPolicyJpaDto;
import com.bluescript.demo.dto.IGetCommercialPolicy2JpaDto;
import com.bluescript.demo.dto.IGetCommercialPolicyJpaDto;
import com.bluescript.demo.dto.IGetEndowmentPolicyJpaDto;
import com.bluescript.demo.dto.IGetMotorPolicyJpaDto;

import com.bluescript.demo.dto.IgetHousePolicyJpaDto;

import com.bluescript.demo.dto.IzipcursorJpaDto;
import com.bluescript.demo.exception.BreakException;

import com.bluescript.demo.model.ErrorMsg;
import com.bluescript.demo.model.EmVariable;
import com.bluescript.demo.model.Db2OutIntegers;
import com.bluescript.demo.model.Db2PolicyCommon;
import com.bluescript.demo.model.Dfhcommarea;
import com.bluescript.demo.model.CaCustomerRequest;
import com.bluescript.demo.model.CaCustsecrRequest;
import com.bluescript.demo.model.CaPolicyRequest;
import com.bluescript.demo.model.Db2Commercial;
import com.bluescript.demo.model.Db2EndowFixed;
import com.bluescript.demo.model.Db2Endowment;
import com.bluescript.demo.model.Db2House;
import com.bluescript.demo.model.Db2Motor;
import com.bluescript.demo.model.CaPolicyCommon;
import com.bluescript.demo.model.CaEndowment;
import com.bluescript.demo.model.CaHouse;
import com.bluescript.demo.model.CaMotor;
import com.bluescript.demo.model.CaCommercial;
import com.bluescript.demo.model.CaClaim;

@Getter
@Setter
@RequiredArgsConstructor
@Log4j2
@Component

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server/Application is down. Please contact support team.") })

public class Lgipdb01 {

    @Autowired
    private ErrorMsg errorMsg;
    @Autowired
    private EmVariable emVariable;
    @Autowired
    private Db2OutIntegers db2OutIntegers;
    @Autowired
    private Dfhcommarea dfhcommarea;
    @Autowired
    private CaCustomerRequest caCustomerRequest;
    @Autowired
    private CaCustsecrRequest caCustsecrRequest;
    @Autowired
    private CaPolicyRequest caPolicyRequest;
    @Autowired
    private CaPolicyCommon caPolicyCommon;
    @Autowired
    private CaEndowment caEndowment;
    @Autowired
    private CaHouse caHouse;
    @Autowired
    private CaMotor caMotor;
    @Autowired
    private CaCommercial caCommercial;
    @Autowired
    private CaClaim caClaim;
    private String time1;
    private String date1;
    private String caData;
    private int minusOne = 0;
    private int wsCaHeadertrailerLen = 0;
    private int wsRequiredCaLen = +0;
    private int endPolicyPos = 0;
    private int icomRecordCount;
    private int icomDataLength;
    private double icomPointer;
    private double icomPointerStart;
    private String wsRequestId;
    private int wsResp = 0;
    private int db2CustomernumInt = 0;
    private int db2PolicynumInt = 0;
    private int db2ClaimnumInt = 0;
    private int indBrokerid;
    private int indPayment;
    private int indEPaddingdata;
    private int indEPaddingdatal;
    private String icomRecord;
    @Autowired
    private IGetEndowmentPolicyJpa getEndowmentPolicyJpa;

    private int wsFullEndowLen;
    @Autowired
    private Db2EndowFixed db2EndowFixed;
    @Autowired
    private Db2PolicyCommon db2PolicyCommon;
    private Db2Endowment db2Endowment;

    @Autowired
    private IgetHousePolicyJpa getHousePolicyJpa;
    private int wsFullHouseLen;
    private int eibcalen;
    private Db2House db2House;
    private Db2Motor db2Motor;
    @Autowired
    private Db2Commercial db2Commercial;
    private IGetMotorPolicyJpaDto getMotorPolicyJpaDto;

    @Autowired
    private com.bluescript.demo.mapper.ConvObjtoObj convObjToObj;

    private IgetHousePolicyJpaDto getHousePolicyJpaDto;
    @Autowired
    private IGetMotorPolicyJpa getMotorPolicyJpa;
    @Autowired
    private IGetCommercialPolicyJpa getCommercialPolicyJpa;
    @Autowired
    private IGetCommercialPolicy2Jpa getCommercialPolicy2Jpa;
    @Autowired
    private IgetCommercialDb2Info3CustCursorJpa getCommercialDb2Info3CustCursorJpa;
    @Autowired
    private IgetCommercialDb2Info5ZipCursorJpa getCommercialDb2Info5ZipCursorJpa;
    @Autowired
    private IGetClaimPolicyJpa getClaimPolicJpa;
    @Autowired
    private IgetClaimDb2Info2CusclaimCursorJpa getClaimDb2Info2CurCusclaimCursorJpa;

    @Value("${api.LGSTSQ.host}")
    private String LGSTSQ_HOST;
    @Value("${api.LGSTSQ.uri}")
    private String LGSTSQ_URI;
    private String caErrorMsg;

    @PostMapping("/lgipdb01")
    @Transactional
    public ResponseEntity<Dfhcommarea> mainline(@Valid @RequestBody Dfhcommarea payload) {

        log.debug("Methodmainlinestarted..");
        BeanUtils.copyProperties(payload, dfhcommarea);
        dfhcommarea.setCaReturnCode(00);
        db2CustomernumInt = (int) dfhcommarea.getCaCustomerNum();
        db2PolicynumInt = (int) dfhcommarea.getCaPolicyRequest().getCaPolicyNum();
        emVariable.setEmCusnum(String.valueOf(dfhcommarea.getCaCustomerNum()));
        emVariable.setEmPolnum(String.valueOf(caPolicyRequest.getCaPolicyNum()));
        wsRequestId = dfhcommarea.getCaRequestId().toUpperCase();

        switch (wsRequestId) {
        case "01IEND":
            log.warn("wsRequestId:" + wsRequestId);
            getEndowDb2Info();
            break;
        case "01IHOU":
            getHouseDb2Info();
            break;
        case "01IMOT":
            getMotorDb2Info();
            break;
        case "01ICOM":
            getCommercialDb2Info1();
            break;
        case "02ICOM":
            getCommercialDb2Info2();
            break;
        case "03ICOM":
            getCommercialDb2Info3();

            break;
        case "05ICOM":
            getCommercialDb2Info5();
            break;
        case "01ICLM":
            db2ClaimnumInt = (int) dfhcommarea.getCaPolicyRequest().getCaClaim().getCaCNum();
            getClaimDb2Info1();
            break;
        case "02ICLM":
            getClaimDb2Info2();
            break;
        default:
            dfhcommarea.setCaReturnCode(99);
        }
        log.debug("Method mainline completed..");

        return new ResponseEntity<>(dfhcommarea, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public void getEndowDb2Info() {
        log.warn("MethodgetEndowDb2Infostarted..");

        emVariable.setEmSqlreq(" SELECT ENDOW ");

        try {
            log.warn("db2CustomernumInt:" + db2CustomernumInt + " db2PolicynumInt:" + db2PolicynumInt);
            IGetEndowmentPolicyJpaDto getEndowmentPolicyJpaDto = getEndowmentPolicyJpa
                    .getPolicyByDb2CustomernumIntAndDb2PolicynumInt(db2CustomernumInt, db2PolicynumInt);

            if (getEndowmentPolicyJpaDto != null) {

                // all individual moves are taken care directly with mapper .. so explict moves
                // are removed-->Aggresive Data Forcing enforced.
                caPolicyCommon = convObjToObj.db2CommonToCaPolicyCommon(getEndowmentPolicyJpaDto);
                caEndowment = convObjToObj.db2EndowToCaEndowment(getEndowmentPolicyJpaDto);
                dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(caPolicyCommon);
                dfhcommarea.getCaPolicyRequest().setCaEndowment(caEndowment);

                log.warn("caEndowment:" + caEndowment.toString());
                log.warn("caPolicyCommon:" + caPolicyCommon.toString());

                if (getEndowmentPolicyJpaDto.getDb2EPaddingLen() != null) {
                    endPolicyPos = getEndowmentPolicyJpaDto.getDb2EPaddingLen();
                }
                String caPaddingData = dfhcommarea.getCaPolicyRequest().getCaEndowment().getCaEPaddingData();
                dfhcommarea.getCaPolicyRequest().getCaEndowment().setCaEPaddingData(caPaddingData + "FINAL");
            } else {
                dfhcommarea.setCaReturnCode(01);
            }

        } catch (Exception e) {
            // log.error(e);
            dfhcommarea.setCaReturnCode(90);
            writeErrorMessage();
        }

        log.debug("Method getEndowDb2Info completed..");

    }

    @Transactional(readOnly = true)
    public void getHouseDb2Info() {
        log.debug("MethodgetHouseDb2Infostarted..");
        emVariable.setEmSqlreq(" SELECT HOUSE ");

        try {
            getHousePolicyJpaDto = getHousePolicyJpa
                    .getHousePolicyByDb2CustomernumIntAndDb2PolicynumInt(db2CustomernumInt, db2PolicynumInt);

            if (getHousePolicyJpaDto != null) {
                if (getHousePolicyJpaDto.getDb2BrokeridInt() != null) {
                    db2PolicyCommon.setDb2Brokerid(getHousePolicyJpaDto.getDb2BrokeridInt());
                }
                if (getHousePolicyJpaDto.getDb2PaymentInt() != null) {
                    db2PolicyCommon.setDb2Payment(getHousePolicyJpaDto.getDb2PaymentInt());
                }

                caPolicyCommon = convObjToObj.db2HCommonToCaPolicyCommon(getHousePolicyJpaDto);
                caHouse = convObjToObj.db2HouseToCaHouse(getHousePolicyJpaDto);

                log.warn("caHouse:" + caHouse.toString());
                log.warn("caPolicyCommon:" + caPolicyCommon.toString());

                dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(caPolicyCommon);
                dfhcommarea.getCaPolicyRequest().setCaHouse(caHouse);

                caHouse.setCaHFiller("FINAL");
            } else {
                dfhcommarea.setCaReturnCode(01);
            }
        } catch (Exception e) {
            log.error(e);

            dfhcommarea.setCaReturnCode(90);
            writeErrorMessage();
        }
        log.debug("Method getHouseDb2Info completed..");
    }

    @Transactional(readOnly = true)
    public void getMotorDb2Info() {
        log.debug("MethodgetMotorDb2Infostarted..");
        emVariable.setEmSqlreq(" SELECT MOTOR ");

        try {
            IGetMotorPolicyJpaDto getMotorPolicyJpaDto = getMotorPolicyJpa
                    .getMotorPolicyByDb2CustomernumIntAndDb2PolicynumInt(db2CustomernumInt, db2PolicynumInt);

            if (getMotorPolicyJpaDto != null) {
                caPolicyCommon = convObjToObj.db2MCommonToCaPolicyCommon(getMotorPolicyJpaDto);
                caMotor = convObjToObj.db2MotorToCaMotor(getMotorPolicyJpaDto);

                log.warn("caMotor:" + caMotor.toString());
                log.warn("caPolicyCommon:" + caPolicyCommon.toString());

                dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(caPolicyCommon);
                dfhcommarea.getCaPolicyRequest().setCaMotor(caMotor);
                caMotor.setCaMFiller("FINAL");
            } else {
                dfhcommarea.setCaReturnCode(01);
            }
        } catch (Exception e) {
            log.error(e);
            dfhcommarea.setCaReturnCode(90);
            writeErrorMessage();

        }

        log.debug("Method getMotorDb2Info completed..");
    }

    @Transactional(readOnly = true)
    public void getCommercialDb2Info1() {
        log.debug("MethodgetCommercialDb2Info1started..");
        emVariable.setEmSqlreq(" SELECT COMMERCIAL ");

        try {
            IGetCommercialPolicy2JpaDto getCommercialPolicyJpaDto = getCommercialPolicyJpa
                    .getCommercialPolicyByDb2CustomernumIntAndDb2PolicynumInt(db2CustomernumInt, db2PolicynumInt);
            if (getCommercialPolicyJpaDto != null) {

                caPolicyCommon = convObjToObj.db2CommercialCommonToCaPolicyCommon(getCommercialPolicyJpaDto);
                log.warn("caPolicyCommon:" + caPolicyCommon.toString());
                caCommercial = convObjToObj.db2CommercialToCaCommercial(getCommercialPolicyJpaDto);
                log.warn("caCommercial:" + caCommercial.toString());

                dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(caPolicyCommon);
                dfhcommarea.getCaPolicyRequest().setCaCommercial(caCommercial);
                caCommercial.setCaBFiller("FINAL");
            } else {
                dfhcommarea.setCaReturnCode(01);
            }
        } catch (Exception e) {

            dfhcommarea.setCaReturnCode(90);
            writeErrorMessage();
        }

        log.debug("Method getCommercialDb2Info1 completed..");
    }

    @Transactional(readOnly = true)
    public void getCommercialDb2Info2() {
        log.debug("MethodgetCommercialDb2Info2started..");
        emVariable.setEmSqlreq(" SELECT COMMERCIAL ");
        try {
            IGetCommercialPolicy2JpaDto getCommercialPolicy2JpaDto = getCommercialPolicy2Jpa
                    .getCommercialPolicy2ByDb2PolicynumInt(db2PolicynumInt);
            if (getCommercialPolicy2JpaDto != null) {
                dfhcommarea.setCaCustomerNum(db2CustomernumInt);
                caPolicyCommon = convObjToObj.db2CommercialCommonToCaPolicyCommon(getCommercialPolicy2JpaDto);
                log.warn("caPolicyCommon2:" + caPolicyCommon.toString());
                caCommercial = convObjToObj.db2CommercialToCaCommercial(getCommercialPolicy2JpaDto);
                log.warn("caCommercial2:" + caCommercial.toString());

                dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(caPolicyCommon);
                dfhcommarea.getCaPolicyRequest().setCaCommercial(caCommercial);

                log.warn("dfhcommare Response:", dfhcommarea);

                caCommercial.setCaBFiller("FINAL");
            } else {
                dfhcommarea.setCaReturnCode(01);
            }
        } catch (Exception e) {

            dfhcommarea.setCaReturnCode(90);
            writeErrorMessage();
        }
        log.debug("Method getCommercialDb2Info2 completed..");
    }

    @Transactional(readOnly = true)
    public void getCommercialDb2Info3() {
        log.debug("MethodgetCommercialDb2Info3started..");
        emVariable.setEmSqlreq(" SELECT COMMERCIAL ");
        icomRecordCount = 0;
        getCommercialDb2Info3Cur();
        icomDataLength = icomRecordCount * 1202;
        // Put container icomData copied from icomrecord
        // put container icomcount copied from icount record
        int icomCount = icomRecordCount;
        log.warn("icomCount:" + icomCount);
        log.debug("Method getCommercialDb2Info3 completed..");
    }

    @Transactional(readOnly = true)
    public void getCommercialDb2Info3Cur() {
        log.debug("MethodgetCommercialDb2Info3Curstarted..");
        // addressOfDfhcommarea;

        try (Stream<IGetCommercialPolicy2JpaDto> CustCursorData = getCommercialDb2Info3CustCursorJpa
                .getCustCursorByDb2CustomernumInt(db2CustomernumInt)) {
            CustCursorData.forEach(e -> {

                dfhcommarea.setCaCustomerNum(db2CustomernumInt);
                caPolicyRequest.setCaPolicyNum(db2PolicynumInt);
                dfhcommarea.setCaCustomerNum(db2CustomernumInt);
                caPolicyCommon = convObjToObj.db2CommercialCommonToCaPolicyCommon(e);
                log.warn("caPolicyCommon2:" + caPolicyCommon.toString());
                caCommercial = convObjToObj.db2CommercialToCaCommercial(e);
                log.warn("caCommercial2:" + caCommercial.toString());

                dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(caPolicyCommon);
                dfhcommarea.getCaPolicyRequest().setCaCommercial(caCommercial);

                icomRecordCount = 1 + icomRecordCount;
                log.warn("icomRecordCount:" + icomRecordCount);
                // Set icom-pointer to address of CA-B-FILLER
                if (icomRecordCount >= 20) {
                    // sqlcode = 17;
                    throw new BreakException("ForEach Exit");
                }
            });
        } catch (BreakException be) {
            log.warn("ForEach loop exit");
        } catch (Exception e) {
            log.error(e);
        }

        log.debug("Method getCommercialDb2Info3Cur completed..");
    }

    public void getCommercialDb2Info5() {
        log.debug("MethodgetCommercialDb2Info5started..");
        emVariable.setEmSqlreq(" SELECT COMMERCIAL ");

        getCommercialDb2Info5Cur();

        log.debug("Method getCommercialDb2Info5 completed..");
    }

    @Transactional(readOnly = true)
    public void getCommercialDb2Info5Cur() {
        log.debug("MethodgetCommercialDb2Info5Curstarted..");

        try (Stream<IGetCommercialPolicy2JpaDto> ZipCursorData = getCommercialDb2Info5ZipCursorJpa
                .getZipCursorByCaBPostcode(dfhcommarea.getCaPolicyRequest().getCaCommercial().getCaBPostcode())) {

            ZipCursorData.forEach(e -> {

                dfhcommarea.setCaCustomerNum(e.getDb2CustomernumInt());
                dfhcommarea.getCaPolicyRequest().setCaPolicyNum(db2PolicynumInt);

                caPolicyCommon = convObjToObj.db2CommercialCommonToCaPolicyCommon(e);
                log.warn("caPolicyCommon2:" + caPolicyCommon.toString());
                caCommercial = convObjToObj.db2CommercialToCaCommercial(e);
                log.warn("caCommercial2:" + caCommercial.toString());

                dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(caPolicyCommon);
                dfhcommarea.getCaPolicyRequest().setCaCommercial(caCommercial);

            });

        } catch (Exception e) {
            log.error(e);
        }
        log.debug("Method getCommercialDb2Info5Cur completed..");
    }

    @Transactional(readOnly = true)
    public void getClaimDb2Info1() {
        log.debug("MethodgetClaimDb2Info1started..");
        emVariable.setEmSqlreq(" SELECT CLAIM ");
        try {

            IGetClaimPolicyJpaDto getClaimPolicyJpaDto = getClaimPolicJpa.getPolicyByDb2ClaimnumInt(db2ClaimnumInt);
            dfhcommarea.setCaCustomerNum(db2CustomernumInt);
            dfhcommarea.getCaPolicyRequest().setCaPolicyNum(db2PolicynumInt);

            // caPolicyCommon =
            // convObjToObj.db2ClaimCommonToCaPolicyCommon(getClaimPolicyJpaDto);
            // log.warn("caPolicyCommon2:" + caPolicyCommon.toString());
            caClaim = convObjToObj.db2ClaimToCaClaim(getClaimPolicyJpaDto);
            log.warn("caCommercial2:" + caCommercial.toString());

            dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(caPolicyCommon);
            dfhcommarea.getCaPolicyRequest().setCaCommercial(caCommercial);

            caClaim.setCaCFiller("FINAL");
        } catch (Exception e) {
            log.error(e);
        }

        log.debug("Method getClaimDb2Info1 completed..");
    }

    public void getClaimDb2Info2() {
        log.debug("MethodgetClaimDb2Info2started..");
        emVariable.setEmSqlreq(" SELECT CLAIM ");

        getClaimDb2Info2Cur();

        log.debug("Method getClaimDb2Info2 completed..");
    }

    @Transactional(readOnly = true)
    public void getClaimDb2Info2Cur() {
        log.debug("MethodgetClaimDb2Info2Curstarted..");
        try {
            Stream<IGetClaimPolicyJpaDto> CusclaimCursorData = getClaimDb2Info2CurCusclaimCursorJpa
                    .getCusclaimCursorByDb2CustomernumInt(db2CustomernumInt);
            CusclaimCursorData.forEach(e -> {
                dfhcommarea.setCaCustomerNum(db2CustomernumInt);
                caPolicyRequest.setCaPolicyNum(db2PolicynumInt);

                // caPolicyCommon = convObjToObj.db2ClaimCommonToCaPolicyCommon(e);
                // log.warn("caPolicyCommon2:" + caPolicyCommon.toString());
                caClaim = convObjToObj.db2ClaimToCaClaim(e);
                log.warn("caClaim:" + caCommercial.toString());

                dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(caPolicyCommon);
                dfhcommarea.getCaPolicyRequest().setCaCommercial(caCommercial);
                caClaim.setCaCFiller("FINAL");

            });
        } catch (Exception e) {
            log.error(e);
        }

        log.debug("Method getClaimDb2Info2Cur completed..");
    }

    public void writeErrorMessage() {

        log.warn("MethodwriteErrorMessagestarted..", errorMsg.toString());
        String wsAbstime = LocalTime.now().toString();
        String wsDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        // String wsDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        // //yyyyMMdd
        String wsTime = LocalTime.now().toString();
        errorMsg.setEmDate(wsDate);
        errorMsg.setEmTime(wsTime);
        log.warn("ErrorMsg:" + errorMsg.toString());

        WebClient webclientBuilder = WebClient.create(LGSTSQ_HOST);
        errorMsg.setEmVariable(emVariable);
        try {
            Mono<ErrorMsg> lgstsqResp = webclientBuilder.post().uri(LGSTSQ_URI)
                    // .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(errorMsg), ErrorMsg.class).retrieve().bodyToMono(ErrorMsg.class);
            lgstsqResp.block();
        } catch (Exception e) {
            log.error(e);
        }
        if (eibcalen > 0) {
            if (eibcalen < 91) {
                try {
                    Mono<ErrorMsg> lgstsqResp = webclientBuilder.post().uri(LGSTSQ_URI)
                            .body(Mono.just(errorMsg), ErrorMsg.class).retrieve().bodyToMono(ErrorMsg.class);// .timeout(Duration.ofMillis(10_000));
                    errorMsg = lgstsqResp.block();
                } catch (Exception e) {
                    log.error(e);
                }

            } else {
                try {
                    Mono<String> lgstsqResp = webclientBuilder.post().uri(LGSTSQ_URI)
                            .body(Mono.just(caErrorMsg), String.class).retrieve().bodyToMono(String.class);// .timeout(Duration.ofMillis(10_000));
                    caErrorMsg = lgstsqResp.block();
                } catch (Exception e) {
                    log.error(e);
                }

            }

        }

        log.debug("Method writeErrorMessage completed..");

    }

    // /* End of program */

}