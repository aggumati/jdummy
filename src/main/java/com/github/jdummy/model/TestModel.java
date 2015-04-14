package com.github.jdummy.model;

import java.util.Date;

import com.github.jdummy.config.DummyAddress;
import com.github.jdummy.config.DummyCity;
import com.github.jdummy.config.DummyDate;
import com.github.jdummy.config.DummyFirstName;
import com.github.jdummy.config.DummyFullName;
import com.github.jdummy.config.DummyLastName;
import com.github.jdummy.config.DummyLongAddress;
import com.github.jdummy.config.DummyNumber;

public class TestModel {
	@DummyFullName
	private String testFullName;
	@DummyFirstName
	private String testFirstName;
	@DummyLastName
	private String testLastName;
	@DummyNumber
	private Integer testNumber;
	@DummyCity
	private String testCity;
	@DummyAddress
	private String testAddress;
	@DummyLongAddress
	private String testLongAddress;
	@DummyDate
	private Date testDate;

	public String getTestFullName() {
		return testFullName;
	}

	public void setTestFullName(String testFullName) {
		this.testFullName = testFullName;
	}

	public String getTestFirstName() {
		return testFirstName;
	}

	public void setTestFirstName(String testFirstName) {
		this.testFirstName = testFirstName;
	}

	public String getTestLastName() {
		return testLastName;
	}

	public void setTestLastName(String testLastName) {
		this.testLastName = testLastName;
	}

	public Integer getTestNumber() {
		return testNumber;
	}

	public void setTestNumber(Integer testNumber) {
		this.testNumber = testNumber;
	}

	public String getTestCity() {
		return testCity;
	}

	public void setTestCity(String testCity) {
		this.testCity = testCity;
	}

	public String getTestAddress() {
		return testAddress;
	}

	public void setTestAddress(String testAddress) {
		this.testAddress = testAddress;
	}

	public String getTestLongAddress() {
		return testLongAddress;
	}

	public void setTestLongAddress(String testLongAddress) {
		this.testLongAddress = testLongAddress;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	@Override
	public String toString() {
		return getTestFullName() + "\n" + getTestFirstName() + "\n"
				+ getTestLastName() + "\n" + getTestNumber() + "\n"
				+ getTestCity() + "\n" + getTestAddress() + "\n"
				+ getTestLongAddress() + "\n" + getTestDate();
	}
}
