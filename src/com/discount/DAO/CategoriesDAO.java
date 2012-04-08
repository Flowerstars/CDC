/**
 * 
 */
package com.discount.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.discount.model.Categories;

/**
 * @author han
 *
 */
public class CategoriesDAO {
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	 */
	public CategoriesDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	/**
	 * Returns the list of all Picture instances from the database.
	 * @return the list of all Picture instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Categories> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Categories> list = session.selectList("Categories.getAll");
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
	public Categories selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Categories category = (Categories) session.selectOne("Categories.getById",id);
			return category;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	public void update(Categories category){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Categories.update", category);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	public void insert(Categories category){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Categories.insert", category);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int catId){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("Categories.deleteById", catId);
			session.commit();
		} finally {
			session.close();
		}
	}

	
}
