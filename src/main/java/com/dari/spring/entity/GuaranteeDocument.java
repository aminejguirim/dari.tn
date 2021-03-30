package com.dari.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="DOCUMENTS")

public class GuaranteeDocument implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public GuaranteeDocument()
	{
		super();
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id; 
	
	@Lob
    @Column(name = "imageCin", length = Integer.MAX_VALUE, nullable = true)
    private byte[] imageCin;
	
	@Lob
    @Column(name = "engagementProof", length = Integer.MAX_VALUE, nullable = true)
    private byte[] engagementProof;
	
	@Lob
    @Column(name = "payProof", length = Integer.MAX_VALUE, nullable = true)
    private byte[] payProof;
	
	@Lob
    @Column(name = "imageJustifPay", length = Integer.MAX_VALUE, nullable = true)
    private byte[] imageJustifPay;
	
	@OneToOne
	private RentGuarantee rentGuarantee;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JsonBackReference(value="guarantee-document")
	public RentGuarantee getRentGuarantee() {
		return rentGuarantee;
	}

	public void setRentGuarantee(RentGuarantee rentGuarantee) {
		this.rentGuarantee = rentGuarantee;
	}

	public byte[] getImageCin() {
		return imageCin;
	}

	public void setImageCin(byte[] imageCin) {
		this.imageCin = imageCin;
	}

	public byte[] getEngagementProof() {
		return engagementProof;
	}

	public void setEngagementProof(byte[] engagementProof) {
		this.engagementProof = engagementProof;
	}

	public byte[] getPayProof() {
		return payProof;
	}

	public void setPayProof(byte[] payProof) {
		this.payProof = payProof;
	}

	public byte[] getImageJustifPay() {
		return imageJustifPay;
	}

	public void setImageJustifPay(byte[] imageJustifPlay) {
		this.imageJustifPay = imageJustifPlay;
	}
	
	public boolean comparer(GuaranteeDocument D) {
		if(this.rentGuarantee.getId()==D.getRentGuarantee().getId())
		{
			if(this.engagementProof==D.getEngagementProof())
				if(this.imageCin==D.getImageCin())
					if(this.imageJustifPay==D.getImageJustifPay())
						if(this.payProof==D.getPayProof())
									return true;
		}
		return false;
	}

}
