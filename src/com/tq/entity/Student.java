package com.tq.entity;

public class Student {
	private Integer id;// id
	private String name;// 姓名
	private String xi;
	private String sno;// 学号
	private String card;// 身份证号
	private String pic;// 图片

	public Student() {
	}

	public Student(Integer id, String name, String xi, String sno, String card,
			String pic) {
		this.id = id;
		this.xi = xi;
		this.name = name;
		this.sno = sno;
		this.card = card;
		this.pic = pic;
	}

	public String getXi() {
		return xi;
	}

	public void setXi(String xi) {
		this.xi = xi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}
