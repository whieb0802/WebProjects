package com.scs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="report")
public class Report  implements java.io.Serializable {

     private Integer reportid;
     private Currentime currentime;
     private User user;
     private Integer currentmoney;
     private Integer saleincome;
     private Integer directcost;
     private Integer storagerentcost;
     private Integer productstoragecost;
     private Integer fundcost;
     private Integer tax;
     private Integer productstoragevalue;
     private Integer storagevalue;
     private Integer growlinevalue;
     private Integer totalloan;
     private Integer initialcapital;
     private Integer profitleft;
     private Integer currentprofit;
     private Integer receivablemoney;
     
	@Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="reportid", unique=true, nullable=false)

    public Integer getReportid() {
        return this.reportid;
    }
    
    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="currentime", nullable=false)

    public Currentime getCurrentime() {
        return this.currentime;
    }
    
    public void setCurrentime(Currentime currentime) {
        this.currentime = currentime;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="userid", nullable=false)

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="currentmoney", nullable=false)

    public Integer getCurrentmoney() {
        return this.currentmoney;
    }
    
    public void setCurrentmoney(Integer currentmoney) {
        this.currentmoney = currentmoney;
    }
    
    @Column(name="saleincome", nullable=false)

    public Integer getSaleincome() {
        return this.saleincome;
    }
    
    public void setSaleincome(Integer saleincome) {
        this.saleincome = saleincome;
    }
    
    @Column(name="directcost", nullable=false)

    public Integer getDirectcost() {
        return this.directcost;
    }
    
    public void setDirectcost(Integer directcost) {
        this.directcost = directcost;
    }
    
    @Column(name="storagerentcost", nullable=false)

    public Integer getStoragerentcost() {
        return this.storagerentcost;
    }
    
    public void setStoragerentcost(Integer storagerentcost) {
        this.storagerentcost = storagerentcost;
    }
    
    @Column(name="productstoragecost", nullable=false)

    public Integer getProductstoragecost() {
        return this.productstoragecost;
    }
    
    public void setProductstoragecost(Integer productstoragecost) {
        this.productstoragecost = productstoragecost;
    }
    
    @Column(name="fundcost", nullable=false)

    public Integer getFundcost() {
        return this.fundcost;
    }
    
    public void setFundcost(Integer fundcost) {
        this.fundcost = fundcost;
    }
    
    @Column(name="tax", nullable=false)

    public Integer getTax() {
        return this.tax;
    }
    
    public void setTax(Integer tax) {
        this.tax = tax;
    }
    
    @Column(name="productstoragevalue", nullable=false)

    public Integer getProductstoragevalue() {
        return this.productstoragevalue;
    }
    
    public void setProductstoragevalue(Integer productstoragevalue) {
        this.productstoragevalue = productstoragevalue;
    }
    
    @Column(name="storagevalue", nullable=false)

    public Integer getStoragevalue() {
        return this.storagevalue;
    }
    
    public void setStoragevalue(Integer storagevalue) {
        this.storagevalue = storagevalue;
    }
    
    @Column(name="growlinevalue", nullable=false)

    public Integer getGrowlinevalue() {
        return this.growlinevalue;
    }
    
    public void setGrowlinevalue(Integer growlinevalue) {
        this.growlinevalue = growlinevalue;
    }
    
    @Column(name="totalloan", nullable=false)

    public Integer getTotalloan() {
        return this.totalloan;
    }
    
    public void setTotalloan(Integer totalloan) {
        this.totalloan = totalloan;
    }
    
    @Column(name="initialcapital", nullable=false)

    public Integer getInitialcapital() {
        return this.initialcapital;
    }
    
    public void setInitialcapital(Integer initialcapital) {
        this.initialcapital = initialcapital;
    }
    
    @Column(name="profitleft", nullable=false)

    public Integer getProfitleft() {
        return this.profitleft;
    }
    
    public void setProfitleft(Integer profitleft) {
        this.profitleft = profitleft;
    }
    
    @Column(name="currentprofit", nullable=false)

    public Integer getCurrentprofit() {
        return this.currentprofit;
    }
    
    public void setCurrentprofit(Integer currentprofit) {
        this.currentprofit = currentprofit;
    }
    
    @Column(name="receivablemoney", nullable=false)
    public Integer getReceivableMoney() {
		return receivablemoney;
	}

	public void setReceivableMoney(Integer receivablemoney) {
		this.receivablemoney = receivablemoney;
	}
}