/**
 * 
 */
package com.discount.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.discount.model.Deals;

/**
 * @author han
 *
 */
public class DealsDAO {

	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	 */
	public DealsDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Returns the list of all Deals instances from the database.
	 * @return the list of all Deals instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Deals> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Deals> list = session.selectList("Deals.getAll");
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
	public Deals selectById(int id){
		
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Deals deal = (Deals) session.selectOne("Deals.getById",id);
			return deal;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	public void update(Deals deal){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Deals.update", deal);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	public void insert(Deals deal){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Deals.insert", deal);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("Deals.deleteById", id);
			session.commit();
		} finally {
			session.close();
		}
	}
	

}
