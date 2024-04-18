package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Address;
import com.util.BaseDAO;
import com.util.Mapper;

/**
 * @Description:
 * @author: 铭
 * @date 2024年4月17日 下午3:38:35
 */

public class AddressDAO extends BaseDAO {
	// 添加收货地址
	public Integer addAddress(Address a) {
		Integer aid = null;
		String sql = "insert into address value(null,?,?,?,?,?,?,?)";
		try {
			stmt = getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setObject(1, a.getUser_id());
			stmt.setObject(2, a.getConsignee());
			stmt.setObject(3, a.getPhone());
			stmt.setObject(4, a.getReceiving_region());
			stmt.setObject(5, a.getDefault_address());
			stmt.setObject(6, a.getDetailed_region());
			stmt.setObject(7, a.getState());
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

	// 设置是否为默认地址
	public Integer updateDefault(Integer address_id, Integer default_address) {
		String sql = "update address set default_address = ?";
		if (address_id != null) {
			sql += " where id=?";
			return executeUpdate(sql, default_address, address_id);
		} else {
			return executeUpdate(sql, default_address);
		}

	}

	// 查询用户的收货地址
	public List<Address> queryAddress(Integer user_id) {
		String sql = "select * from address where user_id=? and state = 1";
		return executeQuery(sql, new Mapper<Address>() {

			@Override
			public List<Address> map(ResultSet rs) throws SQLException {
				List<Address> list = new ArrayList<Address>();
				while (rs.next()) {
					list.add(new Address(rs.getInt("id"), rs.getInt("user_id"), rs.getString("consignee"),
							rs.getString("phone"), rs.getString("receiving_region"), rs.getInt("default_address"),
							rs.getString("detailed_region"), rs.getInt("state")));
				}
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getDefault_address() == 1) {
						Address address = list.remove(i);
		                list.add(0, address);
					}
				}

				return list;
			}
		}, user_id);
	}
	
	//修改收获地址
	public Integer UpdateAddress(Address a) {
		String sql = "update address set consignee=?,phone=?,receiving_region=?,detailed_region=? where id=?";
		return executeUpdate(sql, a.getConsignee(),a.getPhone(),a.getReceiving_region(),a.getDetailed_region(),a.getId());
	}
	
	//删除收获地址
	public Integer delectAddress(Integer address_id) {
		String sql = "update address set state = 0 where id=?";
		return executeUpdate(sql, address_id);
	}

	public static void main(String[] args) {
		System.out.println(new AddressDAO().queryAddress(3));
	}
}
