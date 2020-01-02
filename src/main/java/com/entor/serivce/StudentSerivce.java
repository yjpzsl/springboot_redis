package com.entor.serivce;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entor.entity.Student;

public interface StudentSerivce {

	public void add(Student student);
	
	public void update(Student student);
	
	public void deleteById(int id);
	
	public Student queryById(int id);
	
	public List<Student> queryByPage(@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
	
	public List<Student> queryAll();
}
