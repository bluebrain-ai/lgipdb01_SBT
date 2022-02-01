package com.bluescript.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Entity
@Table(name = "CLAIM")

@Data
@RequiredArgsConstructor
// Schema : CLAIM
public class ClaimEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CLAIMNUMBER")
    private Integer claimNumber;
    @Column(name = "POLICYNUMBER")
    private Integer policynumber;
    @Column(name = "CLAIMDATE")
    private Date claimdate;
    @Column(name = "PAID")
    private Integer paid;
    @Column(name = "VALUE")
    private Integer value;
    @Column(name = "CAUSE")
    private String cause;
    @Column(name = "OBSERVATIONS")
    private String observations;
}
