package com.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Administrator;
import com.util.BaseDAO;


public class AdministratorDAO extends BaseDAO{
	//登录
		public Administrator dengLu(String account,String password) {
			String sql = "select * from administrator where admin_account =? and admin_password = ? and state=1";
			Administrator a = null;
			try {
				System.out.println(account);
				System.out.println(password);
				stmt =getConn().prepareStatement(sql);
				stmt.setObject(1, account);
				stmt.setObject(2, password);
				rs = stmt.executeQuery();
				if(rs.next()) {
					a = new Administrator(rs.getInt("id"), 
							rs.getString("admin_nickname"), 
							rs.getString("admin_account"),
							rs.getString("admin_password"),
							rs.getInt("state")
				);}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeAll();
			}
			return a;
		}
	//注册
		public Integer zhuCe(String nikename,String account,String password) {
			
			String sql = "insert into administrator(admin_nickname,admin_account,admin_password)"
					+ "	  values(?,?,?)";
			System.out.println(nikename);
			System.out.println(account);
			System.out.println(password);
			return executeUpdate(sql,nikename,account,password);
		}
	//查询所有
		public List<Administrator> selectAll(){
			String sql="select * from administrator ";
			try {
				stmt=getConn().prepareStatement(sql);
				rs = stmt.executeQuery();
				List<Administrator> list=new ArrayList<Administrator>();
				if (rs!=null) {
					list =new ArrayList<>();
					while(rs.next()) {
						Administrator p= new Administrator(
						rs.getInt("id"),rs.getString("admin_nickname"),
						rs.getString("admin_account"),rs.getString("admin_password"),
						rs.getInt("state"));
						list.add(p);
					}
				}
				return list;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				super.closeAll();
			}
			return null;

		}
	//根据昵称来搜索
	public List<Administrator> selectpart(String nikename) {
		String sql="select * from administrator where nikename=? order by id desc";
		try {
			stmt=getConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Administrator> list=null;
			if (rs!=null) {
				list =new ArrayList<>();
				while(rs.next()) {
					Administrator p= new Administrator(
					rs.getInt("id"),rs.getString("admin_nickname"),
					rs.getString("admin_account"),rs.getString("admin_password"),
					rs.getInt("state"));
					System.out.println(rs.getInt("id")+"\t"+rs.getString("admin_nickname")+"\t \t"
							+rs.getString("admin_account")+"\t \t"+rs.getInt("admin_password")+"\t \t"+
							rs.getString("state"));
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		return null;
		
	}	
		
	//修改密码
		public Integer douUpdate(Integer id,String password ) {
			String sql ="update administrator set admin_password=? where id=?";
			try {
				//2、获取连接对象
				conn = super.getConn();
				//3、预编译SQL语句
				stmt = conn.prepareStatement(sql);
				//4、填充参数
				stmt.setObject(1,password);
				stmt.setObject(2,id);
				//5、执行SQL语句
				return stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				super.closeAll();
			}
			return -1;//最后返回-1，表示代码运行到治理，新增失败
		}
		//删除（更具id调为不可以）
		public Integer doDelet(Administrator obj) {
			String sql ="update administrator set state=? where id=?";
			try {
				//2、获取连接对象
				conn = super.getConn();
				//3、预编译SQL语句
				stmt = conn.prepareStatement(sql);
				//4、填充参数
				stmt.setObject(1, obj.getState());
				stmt.setObject(2, obj.getId());
				//5、执行SQL语句
				return stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				super.closeAll();
			}
			return -1;//最后返回-1，表示代码运行到治理，新增失败
		}
		
		
		
		
	public static void main(String[] args) {
		new AdministratorDAO().zhuCe("黄同学", "18890212428", "123456");
		System.out.println(new AdministratorDAO().dengLu("18890212428","123456" ));

	}
}
