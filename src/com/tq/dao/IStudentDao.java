package com.tq.dao;

import java.util.List;

import com.tq.entity.Student;

public interface IStudentDao extends BaseDAO<Student> {
	/**
	 * 根据名字查学生
	 * 
	 * @return
	 */
	public List<Student> findStudentByName(String name);

	/**
	 * 根据学号姓名查学生
	 * 
	 * @param sno
	 * @param name
	 * @return
	 */
	public Student findStudentBySNoandName(String sno, String name);

	/**
	 * 根据学号分页查找
	 * 
	 * @param sex
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Student> findStudentBySexandPageandPageSize(String sex,
			int page, int pageSize);
}
