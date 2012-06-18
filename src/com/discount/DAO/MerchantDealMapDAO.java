/**
 * 
 */
package com.discount.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.discount.model.Deals;
import com.discount.model.MerchantDealMap;

/**
 * @author Mai
 *
 */
public class MerchantDealMapDAO {

	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	 */
	public MerchantDealMapDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	public List<MerchantDealMap> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<MerchantDealMap> list = session.selectList("MerchantDealMap.getAll");
			return list;
		} finally {
			session.close();
		}
	}
	
	public int getMerchantIdByDealId(int dealId){
		
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			int merIds = (Integer)session.selectOne("MerchantDealMap.getMerchantIdByDealId",dealId);
			return merIds;
		} finally {
			session.close();
		}
	}
}
