package com.aurionpro.entity;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Transactional
@Table(name = "adress")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "add_id")
	private Long addressId;
	private String city;
	private String addressType;
	
	@OneToOne(mappedBy = "address")  //one to one bidirectional
	private Employee employee;

	public Address() {
		super();
	}

	public Address(Long addressId, String city, String addressType) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.addressType = addressType;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", addressType=" + addressType + "]";
	}

}
