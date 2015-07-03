package com.tq.dao.impl;

import java.util.List;

import com.tq.dao.IStudentDao;
import com.tq.entity.Student;

public class StudentDaoImpl extends BaseDAOHibernate4<Student> implements
		IStudentDao {

	@Override
	public List<Student> findStudentByName(String name) {
		return find("from Student s where s.name=?0", name);
	}

	@Override
	public Student findStudentBySNoandName(String sno, String name) {
		List<Student> l = find("from Student s where s.name=?0 and s.sno=?1",
				name, sno);
		if (l != null && l.size() >= 1) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public List<Student> findStudentBySexandPageandPageSize(String sex,
			int page, int pageSize) {
		String hql;
		if (sex.equals("Å®")) {
			hql = "from Student s where s.card like '________________0_' or card like '________________2_' or card like '________________4_' or card like '________________6_' "
					+ "or card like '________________8_'";
		} else if (sex.equals("ÄÐ")) {
			hql = "from Student s where s.card like '________________1_' or card like '________________3_' or card like '________________5_' or card like '________________7_' "
					+ "or card like '________________9_'";

		} else {
			return null;
		}
		return findByPage(hql, page, pageSize);
	}
}
