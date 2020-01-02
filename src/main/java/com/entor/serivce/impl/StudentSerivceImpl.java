package com.entor.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.entor.entity.Student;
import com.entor.mapper.StudentMapper;
import com.entor.serivce.StudentSerivce;
@Service
@CacheConfig(cacheNames= "students")//这方法里所有的键都放到这个组里
public class StudentSerivceImpl implements StudentSerivce{

	@Autowired
	public StudentMapper studentMapper;
	@Override
	public void add(Student student) {
		studentMapper.add(student);
		
	}

	@Override
	public void update(Student student) {
		studentMapper.update(student);
		
	}

	@Override
	@CacheEvict(allEntries=true)
	public void deleteById(int id) {
		studentMapper.deleteById(id);
		
	}

	@Override
	@Cacheable(key="'student_'+#p0")//把对象保存到缓存里,如果传递的id是20，则保持到redis中键的名称为student_23
	public Student queryById(int id) {
		// TODO Auto-generated method stub
		return studentMapper.queryById(id);
	}

	@Override
	@Cacheable(key="'student_'+#p0+'_'+#p1")
	public List<Student> queryByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return studentMapper.queryByPage((currentPage-1)*pageSize, pageSize);
	}

	@Override
	public List<Student> queryAll() {
		// TODO Auto-generated method stub
		return studentMapper.queryAll();
	}

}
