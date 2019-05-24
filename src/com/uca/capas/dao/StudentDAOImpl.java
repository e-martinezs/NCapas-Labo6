package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@PersistenceContext(unitName="persistencia")
	private EntityManager entityManager;

	@Override
	public List<Student> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.student");
		Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
		List<Student> resultset = query.getResultList();
		return resultset;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		Student student = entityManager.find(Student.class, code);
		return student;
	}

	@Override
	@Transactional
	public int insert(Student s) throws DataAccessException {
		try {
			entityManager.persist(s);
			entityManager.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	@Override
	@Transactional
	public int update(Student s) throws DataAccessException{
		try {
			entityManager.merge(s);
			entityManager.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	@Transactional
	public int delete(String name) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM public.student WHERE s_name = ?1");
		Query query = entityManager.createNativeQuery(sb.toString());
		query.setParameter(1, name);
		query.executeUpdate();
		return 1;
	}

}
