package com.dao;

import java.sql.SQLException;
import java.sql.Statement;

import com.entity.Address;
import com.util.BaseDAO;

/**
* @Description: 
* @author: 铭
* @date 2024年4月17日 下午3:38:35
*/

public class AddressDAO extends BaseDAO{
	//添加收货地址
	public Integer addAddress(Address a) {
		Integer aid = null;
		String sql = "insert into address value(null,?,?,?,?,?,?,?)";
		try {
			stmt = getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setObject(1,  a.getUser_id());
			stmt.setObject(2, a.getConsignee());
			stmt.setObject(3,a.getPhone());
			stmt.setObject(4,a.getReceiving_region());
			stmt.setObject(5, a.getDefault_address());
			stmt.setObject(6, a.getDetailed_region());
			stmt.setObject(7,a.getState());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				aid = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return aid;
		
	}
	//设置是否为默认地址
	public Integer updateDefault(Integer address_id,Integer default_address) {
		String sql = "update address set default_address = ?";
		if(address_id!=null) {
			sql +=  " where id=?";
			return executeUpdate(sql, default_address,address_id);
		}else {
			return executeUpdate(sql, default_address);
		}
		
	}
}
