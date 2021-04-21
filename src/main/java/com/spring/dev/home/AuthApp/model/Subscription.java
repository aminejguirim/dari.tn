package com.spring.dev.home.AuthApp.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="T_SUBSCRIPTION")
public class Subscription {
	

    @Id
    @Column(nullable = false, updatable = false , name="id_Subscription")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubscription;

    @Column
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    @Column
    @CreatedDate
    private LocalDate stratingDate =  LocalDate.now();

    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;

    @Column
    private float price = 20 ;
    
    @Column
	private boolean renewal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "subscription_id")
    private SubPaiementDetails subscription;
    
    public Subscription() {
		super();
    }

	public Subscription(Long idSubscription, SubscriptionType subscriptionType, LocalDate stratingDate, Date expirationDate,
			float price, User user, SubPaiementDetails subscription) {
		super();
		this.idSubscription = idSubscription;
		this.subscriptionType = subscriptionType;
		this.stratingDate = stratingDate;
		this.expirationDate = expirationDate;
		this.price = price;
		this.user = user;
		this.subscription = subscription;
	}



	public Long getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(final Long idSubscription) {
        this.idSubscription = idSubscription;
    }

   

    public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public LocalDate getStratingDate() {
        return stratingDate;
    }

    public void setStratingDate(final LocalDate stratingDate) {
        this.stratingDate = stratingDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(final Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice( float price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public SubPaiementDetails getSubscription() {
        return subscription;
    }

    public void setSubscription(final SubPaiementDetails subscription) {
        this.subscription = subscription;
    }
    
    

	public boolean isRenewal() {
		return renewal;
	}

	public void setRenewal(boolean renewal) {
		this.renewal = renewal;
	}

	@Override
	public String toString() {
		return "Subscription [idSubscription=" + idSubscription + ", subscriptionType=" + subscriptionType + ", stratingDate="
				+ stratingDate + ", expirationDate=" + expirationDate + ", price=" + price + ", renewal=" + renewal
				+ ", user=" + user + ", subscription=" + subscription + "]";
	}    
    
	
}
