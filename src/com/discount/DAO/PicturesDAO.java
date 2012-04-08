/**
 * 
 */
package com.discount.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.discount.model.Pictures;

/**
 * @author han
 *
 */
public class PicturesDAO {
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	 */
	public PicturesDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Returns the list of all Picture instances from the database.
	 * @return the list of all Picture instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Pictures> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Pictures> list = session.selectList("Pictures.getAll");
			return list;
		} finally {
			session.close();
		}
	}

	/**
	 * Returns a Contact instance from the database.
	 * @param id primary key value used for lookup.
	 * @return A Contact instance with a primary key value equals to pk. null if there is no matching row.
	 */
	public Pictures selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Pictures picture = (Pictures) session.selectOne("Pictures.getById",id);
			return picture;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	public void update(Pictures picture){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Pictures.update", picture);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	public void insert(Pictures picture){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Pictures.insert", picture);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int picId){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("Pictures.deleteById", picId);
			session.commit();
		} finally {
			session.close();
		}
	}

}
