package io.github.aggumati.jdummy.model;

import java.util.Date;

public class TestModelBlank {
	private String test1;
	private String test2;
	private Integer test3;
	private Integer test4;
	private Date test5;
	private Date test6;

	public String getTest1() {
		return test1;
	}

	public void setTest1(String test1) {
		this.test1 = test1;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}

	public Integer getTest3() {
		return test3;
	}

	public void setTest3(Integer test3) {
		this.test3 = test3;
	}

	public Integer getTest4() {
		return test4;
	}

	public void setTest4(Integer test4) {
		this.test4 = test4;
	}

	public Date getTest5() {
		return test5;
	}

	public void setTest5(Date test5) {
		this.test5 = test5;
	}

	public Date getTest6() {
		return test6;
	}

	public void setTest6(Date test6) {
		this.test6 = test6;
	}
	
	@Override
	public String toString() {
		return test1 + "\n" + test2 + "\n" + test3 + "\n" + test4 + "\n"
				+ test5 + "\n" + test6;
	}
}
