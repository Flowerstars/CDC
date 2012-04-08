/**
 * 
 */
package com.discount.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.discount.model.FavLocations;

/**
 * @author han
 *
 */
public class FavLocationsDAO {
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	 */
	public FavLocationsDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	/**
	 * Returns the list of all favLocation instances from the database.
	 * @return the list of all favLocation instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<FavLocations> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<FavLocations> list = session.selectList("FavLocations.getAll");
			return list;
		} finally {
			session.close();
		}
	}


	public FavLocations selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			FavLocations favLocation = (FavLocations) session.selectOne("FavLocations.getById",id);
			return favLocation;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	public void update(FavLocations favLocation){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("FavLocations.update", favLocation);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	public void insert(FavLocations favLocation){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("FavLocations.insert", favLocation);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int uId){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("FavLocations.deleteById", uId);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	
}
