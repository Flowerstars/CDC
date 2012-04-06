/**
 * 
 */
package com.discount.DAO;

import java.util.List;
import com.discount.model.Users;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author haoranguan
 *
 */
public class UsersDAO {
private SqlSessionFactory sqlSessionFactory; 
	
	public UsersDAO(){
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	

	/**
	 * Returns the list of all User instances from the database.
	 * @return the list of all User instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Users> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Users> list = session.selectList("Users.getAll");
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
	public Users selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Users user = (Users) session.selectOne("Users.getById",id);
			return user;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	public void update(Users user){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Users.update", user);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	public void insert(Users user){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Users.insert", user);
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
			session.delete("Users.deleteById", id);
			session.commit();
		} finally {
			session.close();
		}
	}
}
