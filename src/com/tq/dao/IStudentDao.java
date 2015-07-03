package com.tq.dao;

import java.util.List;

import com.tq.entity.Student;

public interface IStudentDao extends BaseDAO<Student> {
	/**
	 * �������ֲ�ѧ��
	 * 
	 * @return
	 */
	public List<Student> findStudentByName(String name);

	/**
	 * ����ѧ��������ѧ��
	 * 
	 * @param sno
	 * @param name
	 * @return
	 */
	public Student findStudentBySNoandName(String sno, String name);

	/**
	 * ����ѧ�ŷ�ҳ����
	 * 
	 * @param sex
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Student> findStudentBySexandPageandPageSize(String sex,
			int page, int pageSize);
}
