package com.spring.dev.home.AuthApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_SUBPAIEMENTDETAILS")
public class SubPaiementDetails {
	
	@Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardNym;

    @Column
    private String cardType;

    @Column
    @Temporal(TemporalType.DATE)
    private Date cardExpiry;
    
    @Column
    private float price ;

    @OneToOne(mappedBy = "subscription", fetch = FetchType.LAZY)
    private Subscription subscription;
    
    public SubPaiementDetails() {
		super();

    }
    
    public SubPaiementDetails(Long cardNym, String cardType, Date cardExpiry, float price, Subscription subscription) {
		super();
		this.cardNym = cardNym;
		this.cardType = cardType;
		this.cardExpiry = cardExpiry;
		this.price = price;
		this.subscription = subscription;
	}

	public Long getCardNym() {
        return cardNym;
    }

    public void setCardNym(final Long cardNym) {
        this.cardNym = cardNym;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(final String cardType) {
        this.cardType = cardType;
    }

    public Date getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(final Date cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(final Subscription subscription) {
        this.subscription = subscription;
    }

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
    
    

}
