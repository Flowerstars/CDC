/**
 * 
 */
package com.discount.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.discount.model.MerchantsFollowed;

/**
 * @author han
 *
 */
public class MerchantsFollowedDAO {
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	 */
	public MerchantsFollowedDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<MerchantsFollowed> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<MerchantsFollowed> list = session.selectList("MerchantsFollowed.getAll");
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
	public MerchantsFollowed selectById(int mfId){
		
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			MerchantsFollowed merchant = (MerchantsFollowed) session.selectOne("MerchantsFollowed.getById",mfId);
			return merchant;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	public void update(MerchantsFollowed merchantFollowed){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("MerchantsFollowed.update", merchantFollowed);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	public void insert(MerchantsFollowed merchantFollowed){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("MerchantsFollowed.insert", merchantFollowed);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int mfId){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("MerchantsFollowed.deleteById", mfId);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	
}
