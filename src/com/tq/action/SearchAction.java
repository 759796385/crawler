package com.tq.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Student;
import com.tq.service.StuManage;

public class SearchAction extends ActionSupport {
	private Student student;
	private StuManage service;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StuManage getService() {
		return service;
	}

	public void setService(StuManage service) {
		this.service = service;
	}

	/**
	 * 根据名字查询学生
	 * 
	 * @return
	 */
	public String searchNameAndSNo() {
		Student student = service.findStudentBySNoandName(
				getStudent().getSno(), getStudent().getName());
		ActionContext.getContext().getSession().put("student", student);
		return SUCCESS;
	}

	/**
	 * 根据名字查询学生
	 * 
	 * @return
	 */
	public String searchName() {
		List<Student> students = service.findStudentByName(getStudent()
				.getName());
		ActionContext.getContext().getSession().put("students", students);
		return SUCCESS;
	}
}
