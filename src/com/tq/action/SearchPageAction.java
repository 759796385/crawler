package com.tq.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Student;
import com.tq.service.StuManage;

public class SearchPageAction extends ActionSupport {
	private int pagesize = 20;
	private int page;
	private String sex;
	private StuManage service;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public StuManage getService() {
		return service;
	}

	public void setService(StuManage service) {
		this.service = service;
	}

	public int getPagesize() {
		return pagesize;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String execute() throws Exception {
		if (!getSex().equals("ÄÐ") && !getSex().equals("Å®")) {
			return ERROR;
		}
		ActionContext context = ActionContext.getContext();
		List<Student> students = service.findStudentBySexandPageandPageSize(
				sex, page, pagesize);
		context.getSession().put("students", students);
		return SUCCESS;
	}
}
