/**
 * 
 */
package com.discount.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.discount.model.PreferenceTags;

/**
 * @author han
 *
 */
public class PreferenceTagsDAO {
	private SqlSessionFactory sqlSessionFactory;


	public PreferenceTagsDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<PreferenceTags> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<PreferenceTags> list = session.selectList("PreferenceTags.getAll");
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
	public PreferenceTags selectById(int tagId){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			PreferenceTags preferenceTag = (PreferenceTags) session.selectOne("PreferenceTags.getById", tagId);
			return preferenceTag;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	public void update(PreferenceTags preferenceTag){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("PreferenceTags.update", preferenceTag);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	public void insert(PreferenceTags preferenceTag){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("PreferenceTags.insert", preferenceTag);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int tagId){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("PreferenceTags.deleteById", tagId);
			session.commit();
		} finally {
			session.close();
		}
	}

	
}
