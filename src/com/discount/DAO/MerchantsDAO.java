/**
 * 
 */
package com.discount.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.discount.model.Merchants;

/**
 * @author han
 *
 */
public class MerchantsDAO {

	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	 */
	public MerchantsDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	/**
	 * Returns the list of all Merchants instances from the database.
	 * @return the list of all Merchants instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Merchants> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Merchants> list = session.selectList("Merchants.getAll");
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
	public Merchants selectById(int merId){
		
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Merchants merchant = (Merchants) session.selectOne("Merchants.getById",merId);
			return merchant;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	public void update(Merchants merchant){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Merchants.update", merchant);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	public void insert(Merchants merchant){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Merchants.insert", merchant);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int merId){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("Merchants.deleteById", merId);
			session.commit();
		} finally {
			session.close();
		}
	}
	
}
