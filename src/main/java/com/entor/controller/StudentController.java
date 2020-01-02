package com.entor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.Student;
import com.entor.serivce.StudentSerivce;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class StudentController {

	@Autowired
	private StudentSerivce studentSerivce;
	
	@RequestMapping("/add")
	public void add() {
		
	}
	
	@RequestMapping("/update")
	public void update(Student student){
		studentSerivce.update(student);
		
	}
	
	@RequestMapping("/deleteById")
	public String deleteById(int id){
		studentSerivce.deleteById(id);
		return "数据删除成功";
		
	}
	
	@RequestMapping("/queryById")
	public Student queryById(int id){
		return studentSerivce.queryById(id);
		}
	
	@RequestMapping("/queryByPage")
	public List<Student> queryByPage(int currentPage,int pageSize){
		return studentSerivce.queryByPage(currentPage, pageSize);
		
	}
	@RequestMapping("/queryByPage2")
	public PageInfo<Student> queryByPage2(int currentPage,int pageSize){
		PageHelper.startPage(currentPage,pageSize);
		List<Student> lsit = studentSerivce.queryAll();
		PageInfo<Student> pageInfo = new PageInfo<>(lsit);
		return pageInfo;
		
	}
}
