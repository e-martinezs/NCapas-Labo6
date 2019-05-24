package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	private static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		log.info("Entrando a funcion init-main "+log.getName());
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			students = studentDao.findAll();
			log.info("Termino de buscar en la base de datos");
		}catch(Exception e) {
			log.log(Level.SEVERE, "Exception occured", e);
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/findStudent")
	public ModelAndView findStudent(int code) {
		ModelAndView mav = new ModelAndView();
		Student student = studentDao.findOne(code);
		mav.addObject("student",student);
		mav.setViewName("student");
		return mav;
	}
	
	@RequestMapping(value="/insertStudent", method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student",new Student());
		mav.addObject("buttonLabel","Agregar estudiante");
		mav.setViewName("form");
		return mav;
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateForm(int code) {
		ModelAndView mav = new ModelAndView();
		Student student = new Student();
		try {
			student = studentDao.findOne(code);
		}catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("student",student);
		mav.addObject("buttonLabel","Actualizar estudiante");
		mav.setViewName("form");
		return mav;
	}
	
	@RequestMapping("/formData")
	public ModelAndView formData(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {; 
			if (s.getcStudent() == null) {
				studentDao.insert(s);

			}else {
				studentDao.update(s);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		students = studentDao.findAll();
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(String name) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {; 
			studentDao.delete(name);
		}catch (Exception e) {
			e.printStackTrace();
		}
		students = studentDao.findAll();
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
}
