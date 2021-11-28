package com.bluescript.demo;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import io.swagger.annotations.ApiResponses;
import com.bluescript.demo.dto.IGetPolicyJpaDto;
import com.bluescript.demo.jpa.IGetPolicyJpa;
import com.bluescript.demo.dto.IGetPolicy1JpaDto;
import com.bluescript.demo.jpa.IGetPolicy1Jpa;
import com.bluescript.demo.dto.IGetPolicy2JpaDto;
import com.bluescript.demo.jpa.IGetPolicy2Jpa;
import com.bluescript.demo.dto.IGetPolicy3JpaDto;
import com.bluescript.demo.jpa.IGetPolicy3Jpa;
import com.bluescript.demo.dto.IGetPolicy4JpaDto;
import com.bluescript.demo.jpa.IGetPolicy4Jpa;
import com.bluescript.demo.dto.Icust_cursorJpaDto;
import com.bluescript.demo.dto.Izip_cursorJpaDto;
import com.bluescript.demo.dto.IGetPolicy5JpaDto;
import com.bluescript.demo.jpa.IGetPolicy5Jpa;
import com.bluescript.demo.dto.Icusclaim_cursorJpaDto;
import com.bluescript.demo.model.WsHeader;
import com.bluescript.demo.model.ErrorMsg;
import com.bluescript.demo.model.EmVariable;
import com.bluescript.demo.model.Db2OutIntegers;
import com.bluescript.demo.model.Dfhcommarea;
import com.bluescript.demo.model.CaCustomerRequest;
import com.bluescript.demo.model.CaCustsecrRequest;
import com.bluescript.demo.model.CaPolicyRequest;
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
      private WsHeader wsHeader;
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
      private static final int minusOne = VALUE;
      private static final int wsCaHeadertrailerLen = VALUE;
      private static final int wsRequiredCaLen = +0;
      private static final int endPolicyPos = VALUE;
      private int icomRecordCount;
      private int icomDataLength;
      private double icomPointer;
      private double icomPointerStart;
      private String wsRequestId;
      private int wsResp;
      private static final int db2CustomernumInt = VALUE;
      private static final int db2PolicynumInt = VALUE;
      private static final int db2ClaimnumInt = VALUE;
      private int indBrokerid;
      private int indPayment;
      private int indEPaddingdata;
      private int indEPaddingdatal;
      private String icomRecord;

      @PostMapping("/lgipdb01")
      public void mainline() {
            log.debug("Methodmainlinestarted..");
            if (wsResp == 0) {
                  wsRequestId = dfhcommarea.getCaRequestId();
                  db2CustomernumInt = dfhcommarea.getCaCustomerNum();
            } else {
                  // if(eibcalen == 0 )
                  // {
                  // errorMsg.setEmVariable(" NO COMMAREA RECEIVED");writeErrorMessage();
                  // log.error("Error code :", LGCA);
                  // throw new LGCAException("LGCA");

                  // }
                  dfhcommarea.setCaReturnCode("00");
                  db2CustomernumInt = dfhcommarea.getCaCustomerNum();
                  db2PolicynumInt = caPolicyRequest.getCaPolicyNum();
                  emVariable.setEmCusnum(dfhcommarea.getCaCustomerNum());
                  emVariable.setEmPolnum(caPolicyRequest.getCaPolicyNum());
                  wsRequestId = dfhcommarea.getCaRequestId().toUpperCase();
            }
            switch (wsRequestId) {
                  case "01IEND":
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
                        db2ClaimnumInt = caClaim.getCaCNum();
                        getClaimDb2Info1();
                        break;
                  case "02ICLM":
                        getClaimDb2Info2();
                        break;
                  default:
                        dfhcommarea.setCaReturnCode("99");
            }
            log.debug("Method mainline completed..");
      }

      @Transactional(readOnly = true)
      public void getEndowDb2Info() {
            log.debug("MethodgetEndowDb2Infostarted..");
            emVariable.setEmSqlreq(" SELECT ENDOW ");

            try {
                  IGetPolicyJpaDto = GetPolicyJpa.getPolicyByDb2CustomernumIntAndDb2PolicynumInt(db2CustomernumInt,
                              db2PolicynumInt);

                  wsRequiredCaLen = wsCaHeadertrailerLen + wsRequiredCaLen;
                  wsRequiredCaLen = wsFullEndowLen + wsRequiredCaLen;
                  if (indEPaddingdatal != minusOne) {
                        wsRequiredCaLen = db2OutIntegers.db2EPaddingLen + wsRequiredCaLen;
                        endPolicyPos = db2OutIntegers.db2EPaddingLen + endPolicyPos;
                  }
                  if (eibcalen < wsRequiredCaLen) {
                        dfhcommarea.setCaReturnCode("98"); /* return */

                  } else {
                        if (indBrokerid != minusOne) {
                              // MOVE DB2-BROKERID-INT TO DB2-BROKERID
                              db2BrokerId = db2OutIntegers.getDb2BrokerId();

                        }
                        if (indPayment != minusOne) {
                              // MOVE DB2-PAYMENT-INT TO DB2-PAYMENT
                              db2Payment = db2OutIntegers.getDb2PaymentInt();
                        }

                        // MOVE DB2-E-TERM-SINT TO DB2-E-TERM
                        // MOVE DB2-E-SUMASSURED-INT TO DB2-E-SUMASSURED

                        // MOVE DB2-POLICY-COMMON TO CA-POLICY-COMMON
                        // MOVE DB2-ENDOW-FIXED
                        // TO CA-ENDOWMENT(1:WS-ENDOW-LEN)

                        db2ETerm = db2OutIntegers.getDb2ETermSint();
                        db2ESummassured = db2OutIntegers.getDb2ESumassuredInt();

                        // convobj to obj
                        dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(db2PolicyCommon);
                        dfhcommarea.getCaPolicyRequest().setCaEndowment(db2EndowFixed);

                        if (indEPaddingdata != minusOne) { // Crete db2Endowment from lgpolicy copybook
                                                           // MOVE DB2-E-PADDINGDATA TO
                                                           // CA-E-PADDING-DATA(1:DB2-E-PADDING-LEN)
                                                           // conv string to object
                              dfhcommarea.getCaPolicyRequest().getCaEndowment()
                                          .setCaEPaddingData(db2Endowment.getDb2PaddingData());

                        }

                  }
                  dfhcommarea.getCaPolicyRequest().getCaEndowment().setCaEPaddingData("FINAL");
            } catch (Exception e) { // no row found 01
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
                  IGetPolicy1JpaDto = GetPolicy1Jpa.getPolicyByDb2CustomernumIntAndDb2PolicynumInt(db2CustomernumInt,
                              db2PolicynumInt);

                  wsRequiredCaLen = wsCaHeadertrailerLen + wsRequiredCaLen;
                  wsRequiredCaLen = wsFullHouseLen + wsRequiredCaLen;
                  if (eibcalen < wsRequiredCaLen) {
                        dfhcommarea.setCaReturnCode(98); /* return */

                  } else {
                        if (indBrokerid != minusOne) {
                              db2BrokerId = db2OutIntegers.getDb2BrokerId();
                        }
                        if (indPayment != minusOne) {
                              db2Payment = db2OutIntegers.getDb2PaymentInt();
                        }
                        // MOVE DB2-H-BEDROOMS-SINT TO DB2-H-BEDROOMS
                        // MOVE DB2-H-VALUE-INT TO DB2-H-VALUE

                        // MOVE DB2-POLICY-COMMON TO CA-POLICY-COMMON
                        // MOVE DB2-HOUSE TO CA-HOUSE(1:WS-HOUSE-LEN)

                        db2HBedrooms = db2OutIntegers.getDb2HBedroomsSint();
                        db2HValue = db2OutIntegers.getDb2HValueInt();

                        // Convobject same as line 221
                        dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(db2PolicyCommon);
                        dfhcommarea.getCaPolicyRequest().setCaHouse(db2House);

                  }
                  caHouse.setCaHFiller("FINAL");
            } catch (Exception e) {
                  log.error(e);
                  dfhcommarea.setCaReturnCode(01); // No row found
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
                  IGetPolicy2JpaDto = GetPolicy2Jpa.getPolicyByDb2CustomernumIntAndDb2PolicynumInt(db2CustomernumInt,
                              db2PolicynumInt);

                  wsRequiredCaLen = wsCaHeadertrailerLen + wsRequiredCaLen;
                  wsRequiredCaLen = wsFullMotorLen + wsRequiredCaLen;
                  if (eibcalen < wsRequiredCaLen) {
                        dfhcommarea.setCaReturnCode("98"); /* return */

                  } else {
                        if (indBrokerid != minusOne) {
                              db2BrokerId = db2OutIntegers.getDb2BrokerId();
                        }
                        if (indPayment != minusOne) {
                              db2Payment = db2OutIntegers.getDb2PaymentInt();
                        }
                        // MOVE DB2-M-CC-SINT TO DB2-M-CC
                        // MOVE DB2-M-VALUE-INT TO DB2-M-VALUE
                        // MOVE DB2-M-PREMIUM-INT TO DB2-M-PREMIUM
                        // MOVE DB2-M-ACCIDENTS-INT TO DB2-M-ACCIDENTS

                        db2Mcc = db2OutIntegers.getDb2MCcSint();
                        db2MValue = db2OutIntegers.getDb2MValueInt();
                        db2MPremium = db2OutIntegers.getDb2MPremiumInt();
                        db2MAccidents = db2OutIntegers.getDb2MAccidentsInt();

                        dfhcommarea.getCaPolicyRequest().getCaMotor().setCaMPremium(db2OutIntegers.getDb2MPremiumInt());
                        dfhcommarea.getCaPolicyRequest().getCaMotor()
                                    .setCaMAccidents(db2OutIntegers.getDb2MAccidentsInt());
                        // Convobject same as line 221
                        dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(db2PolicyCommon);
                        dfhcommarea.getCaPolicyRequest().setCaMototor(db2Motor);
                  }
                  caMotor.setCaMFiller("FINAL");
            } catch (Exception e) {
                  dfhcommarea.setCaReturnCode(01);
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
                  IGetPolicy3JpaDto = GetPolicy3Jpa.getPolicyByDb2CustomernumIntAndDb2PolicynumInt(db2CustomernumInt,
                              db2PolicynumInt);

                  wsRequiredCaLen = wsCaHeadertrailerLen + wsRequiredCaLen;
                  wsRequiredCaLen = wsFullCommLen + wsRequiredCaLen;
                  if (eibcalen < wsRequiredCaLen) {
                        dfhcommarea.setCaReturnCode("98"); /* return */

                  } else {

                        db2BFirePeril = db2OutIntegers.getDb2BFireperilInt();
                        db2BFirePremium = db2OutIntegers.getDb2BFirepremiumInt();
                        db2BCrimePeril = db2OutIntegers.getDb2BCrimeperilInt();
                        db2BCrimePremium = db2OutIntegers.getDb2BCrimepremiumInt();
                        db2BFloodPeril = db2OutIntegers.getDb2BFloodperilInt();
                        db2BFloodPremium = db2OutIntegers.getDb2BFloodpremiumInt();
                        db2BWetherPeril = db2OutIntegers.getDb2BWeatherperilInt();
                        db2BWeatherPremium = db2OutIntegers.getDb2BWeatherpremiumInt();
                        db2BStatus = db2OutIntegers.getDb2BStatusInt();
                        // Convobject same as line 221
                        dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(db2PolicyCommon);
                        dfhcommarea.getCaPolicyRequest().setCaCommercial(db2Commercial);
                  }
                  caCommercial.setCaBFiller("FINAL");
            } catch (Exception e) {
                  dfhcommarea.setCaReturnCode(01);
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
                  IGetPolicy4JpaDto = GetPolicy4Jpa.getPolicyByDb2PolicynumInt(db2PolicynumInt);

                  wsRequiredCaLen = wsCaHeadertrailerLen + wsRequiredCaLen;
                  wsRequiredCaLen = wsFullCommLen + wsRequiredCaLen;
                  if (eibcalen < wsRequiredCaLen) {
                        dfhcommarea.setCaReturnCode("98"); /* return */

                  } else {
                        dfhcommarea.setCaCustomerNum(db2CustomernumInt);
                        db2BFirePeril = db2OutIntegers.getDb2BFireperilInt();
                        db2BFirePremium = db2OutIntegers.getDb2BFirepremiumInt();
                        db2BCrimePeril = db2OutIntegers.getDb2BCrimeperilInt();
                        db2BCrimePremium = db2OutIntegers.getDb2BCrimepremiumInt();
                        db2BFloodPeril = db2OutIntegers.getDb2BFloodperilInt();
                        db2BFloodPremium = db2OutIntegers.getDb2BFloodpremiumInt();
                        db2BWetherPeril = db2OutIntegers.getDb2BWeatherperilInt();
                        db2BWeatherPremium = db2OutIntegers.getDb2BWeatherpremiumInt();
                        db2BStatus = db2OutIntegers.getDb2BStatusInt();
                        // Convobject same as line 221
                        dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(db2PolicyCommon);
                        dfhcommarea.getCaPolicyRequest().setCaCommercial(db2Commercial);

                  }
                  caCommercial.setCaBFiller("FINAL");
            } catch (Exception e) {
                  dfhcommarea.setCaReturnCode(01);
                  dfhcommarea.setCaReturnCode(90);
                  writeErrorMessage();
            }
            log.debug("Method getCommercialDb2Info2 completed..");
      }

      public void getCommercialDb2Info3() {
            log.debug("MethodgetCommercialDb2Info3started..");
            emVariable.setEmSqlreq(" SELECT COMMERCIAL ");
            icomRecordCount = 0;
            do {
                  getCommercialDb2Info3Cur();
                  sqlcode++;
            } while (sqlcode > 0);
            icomDataLength = icomRecordCount * 1202;
            // Put container icomData copied from icomrecord
            // put container icomcount copied from icount record
            icomCount = icomRecordCount;
            log.debug("Method getCommercialDb2Info3 completed..");
      }

      @Transactional(readOnly = true)
      public void getCommercialDb2Info3Cur() {
            log.debug("MethodgetCommercialDb2Info3Curstarted..");
            // addressOfDfhcommarea;
            Stream<IgetCommercialDb2Info3CurCustCursorJpaDto> CustCursorData = getCommercialDb2Info3CurCustCursorJpa
                        .getCustCursorByDb2CustomernumInt(db2CustomernumInt);
            CustCursorData.forEach(e -> {
                  db2BFirePeril = db2OutIntegers.getDb2BFireperilInt();
                  db2BFirePremium = db2OutIntegers.getDb2BFirepremiumInt();
                  db2BCrimePeril = db2OutIntegers.getDb2BCrimeperilInt();
                  db2BCrimePremium = db2OutIntegers.getDb2BCrimepremiumInt();
                  db2BFloodPeril = db2OutIntegers.getDb2BFloodperilInt();
                  db2BFloodPremium = db2OutIntegers.getDb2BFloodpremiumInt();
                  db2BWetherPeril = db2OutIntegers.getDb2BWeatherperilInt();
                  db2BWeatherPremium = db2OutIntegers.getDb2BWeatherpremiumInt();
                  db2BStatus = db2OutIntegers.getDb2BStatusInt();
                  dfhcommarea.setCaCustomerNum(db2CustomernumInt);
                  caPolicyRequest.setCaPolicyNum(db2PolicynumInt);
                  // Convobject same as line 221
                  dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(db2PolicyCommon);
                  dfhcommarea.getCaPolicyRequest().setCaCommercial(db2Commercial);

                  icomRecordCount = 1 + icomRecordCount;
                  // Set icom-pointer to address of CA-B-FILLER
                  if (icomRecordCount > 20) {
                        sqlcode = 17;
                  }
            });

            log.debug("Method getCommercialDb2Info3Cur completed..");
      }

      public void getCommercialDb2Info5() {
            log.debug("MethodgetCommercialDb2Info5started..");
            emVariable.setEmSqlreq(" SELECT COMMERCIAL ");
            do {
                  getCommercialDb2Info5Cur();
                  sqlcode++;
            } while (sqlcode > 0);
            log.debug("Method getCommercialDb2Info5 completed..");
      }

      @Transactional(readOnly = true)
      public void getCommercialDb2Info5Cur() {
            log.debug("MethodgetCommercialDb2Info5Curstarted..");

            Stream<IgetCommercialDb2Info3CurZipCursorJpaDto> ZipCursorData = getCommercialDb2Info3CurZipCursorJpa
                        .getZipCursorByCaBPostcode(caBPostcode);

            ZipCursorData.forEach(e -> {
                  db2BFirePeril = db2OutIntegers.getDb2BFireperilInt();
                  db2BFirePremium = db2OutIntegers.getDb2BFirepremiumInt();
                  db2BCrimePeril = db2OutIntegers.getDb2BCrimeperilInt();
                  db2BCrimePremium = db2OutIntegers.getDb2BCrimepremiumInt();
                  db2BFloodPeril = db2OutIntegers.getDb2BFloodperilInt();
                  db2BFloodPremium = db2OutIntegers.getDb2BFloodpremiumInt();
                  db2BWetherPeril = db2OutIntegers.getDb2BWeatherperilInt();
                  db2BWeatherPremium = db2OutIntegers.getDb2BWeatherpremiumInt();
                  db2BStatus = db2OutIntegers.getDb2BStatusInt();
                  dfhcommarea.setCaCustomerNum(db2CustomernumInt);
                  dfhcommarea.getCaPolicyRequest().setCaPolicyNum(db2PolicynumInt);
                  // Convobject same as line 221
                  dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(db2PolicyCommon);
                  dfhcommarea.getCaPolicyRequest().setCaCommercial(db2Commercial);

            });

            log.debug("Method getCommercialDb2Info5Cur completed..");
      }

      @Transactional(readOnly = true)
      public void getClaimDb2Info1() {
            log.debug("MethodgetClaimDb2Info1started..");
            emVariable.setEmSqlreq(" SELECT CLAIM ");
            try {

                  IGetPolicy5JpaDto = GetPolicy5Jpa.getPolicyByDb2ClaimnumInt(db2ClaimnumInt);

                  wsRequiredCaLen = wsCaHeadertrailerLen + wsRequiredCaLen;
                  wsRequiredCaLen = wsFullClaimLen + wsRequiredCaLen;

                  if (eibcalen < wsRequiredCaLen) {
                        dfhcommarea.setCaReturnCode(98); /* return */

                  } else {
                        dfhcommarea.setCaCustomerNum(db2CustomernumInt);
                        caPolicyRequest.setCaPolicyNum(db2PolicynumInt);
                        db2CNum = dbClaimnumInt;
                        db2CPaid = db2OutIntegers.getDb2CPaidInt();
                        db2CValue = db2OutIntegers.getDb2CValueInt();
                        // Convobject same as line 221
                        dfhcommarea.getCaPolicyRequest().setCaPolicyCommon(db2PolicyCommon);
                        dfhcommarea.getCaPolicyRequest().setCaCommercial(db2Commercial);
                  }

                  caClaim.setCaCFiller("FINAL");
            } catch (Exception e) {
                  log.error(e);
            }

            log.debug("Method getClaimDb2Info1 completed..");
      }

      public void getClaimDb2Info2() {
            log.debug("MethodgetClaimDb2Info2started..");
            emVariable.setEmSqlreq(" SELECT CLAIM ");
            do {
                  getClaimDb2Info2Cur();
                  sqlcode++;
            } while (sqlcode > 0);

            log.debug("Method getClaimDb2Info2 completed..");
      }

      @Transactional(readOnly = true)
      public void getClaimDb2Info2Cur() {
            log.debug("MethodgetClaimDb2Info2Curstarted..");
            try {
                  Stream<IgetClaimDb2Info2CurCusclaimCursorJpaDto> CusclaimCursorData = getClaimDb2Info2CurCusclaimCursorJpa
                              .getCusclaimCursorByDb2CustomernumInt(db2CustomernumInt);
                  CusclaimCursorData.forEach(e -> {
                        dfhcommarea.setCaCustomerNum(db2CustomernumInt);
                        caPolicyRequest.setCaPolicyNum(db2PolicynumInt);
                        caClaim.setCaCFiller("FINAL");
                  });
            } catch (Exception e) {
                  log.error(e);
            }

            log.debug("Method getClaimDb2Info2Cur completed..");
      }

      public void writeErrorMessage() {

            log.debug("Method writeErrorMessage completed..");
      }

      /* End of program */

}