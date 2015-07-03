package com.tq.service.impl;

import java.util.List;

import com.tq.dao.IStudentDao;
import com.tq.entity.Student;
import com.tq.service.StuManage;

public class StudentManaggImpl implements StuManage {
	private IStudentDao dao;

	public IStudentDao getDao() {
		return dao;
	}

	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Student> findStudentByName(String name) {
		List<Student> student = dao.findStudentByName(name);
		return student;
	}

	@Override
	public Student findStudentBySNoandName(String sno, String name) {
		return dao.findStudentBySNoandName(sno, name);
	}

	@Override
	public List<Student> findStudentBySexandPageandPageSize(String sex,
			int page, int pageSize) {
		return getDao().findStudentBySexandPageandPageSize(sex, page, pageSize);
	}

}
