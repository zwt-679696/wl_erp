package com.weiling.wl_erp.bean;

import java.math.BigDecimal;

public class Product {
	private Integer id;
	private String pname;
	private BigDecimal inprice;
	private Integer cid;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String pname, BigDecimal inprice, Integer cid) {
		this.id = id;
		this.pname = pname;
		this.inprice = inprice;
		this.cid = cid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public BigDecimal getInprice() {
		return inprice;
	}

	public void setInprice(BigDecimal inprice) {
		this.inprice = inprice;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", pname='" + pname + '\'' +
				", inprice=" + inprice +
				", cid=" + cid +
				'}';
	}
}

