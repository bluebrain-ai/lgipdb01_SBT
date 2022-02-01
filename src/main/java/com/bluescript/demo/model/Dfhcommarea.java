package com.bluescript.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import java.util.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import com.bluescript.demo.model.CaCustomerRequest;
import com.bluescript.demo.model.CaCustsecrRequest;
import com.bluescript.demo.model.CaPolicyRequest;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dfhcommarea {
    @NotBlank

    private String caRequestId;
    private int caReturnCode;
    @NotNull(message = "Field can't be null")
    @Digits(integer = 3, fraction = 0)
    private long caCustomerNum;
    private String caRequestSpecific;
    private CaCustomerRequest caCustomerRequest;
    private CaCustsecrRequest caCustsecrRequest;
    private CaPolicyRequest caPolicyRequest;

    public String toFixedWidthString() {
        return caRequestId + caReturnCode + caCustomerNum + caRequestSpecific + caCustomerRequest.toFixedWidthString()
                + caCustsecrRequest.toFixedWidthString() + caPolicyRequest.toFixedWidthString();
    }

}