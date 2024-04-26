package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Product_image;
import com.util.BaseDAO;
import com.util.Mapper;

/**
* @Description: 
* @author: 铭
* @date 2024年4月25日 下午6:47:43
*/

public class Product_ImageDAO extends BaseDAO{
	//根据规格规格值id查询图片
	public List<Product_image> selectProduct_Image_id(Integer value_id){
		String sql = "SELECT * FROM product_image WHERE value_id =?";
		return executeQuery(sql, new Mapper<Product_image>() {

			@Override
			public List<Product_image> map(ResultSet rs) throws SQLException {
				List<Product_image> list = new ArrayList<Product_image>();
				while(rs.next()) {
					list.add(new Product_image(rs.getInt("id"), rs.getInt("value_id"), rs.getString("image_url")));
				}
				return list;
			}
		},value_id);
	}
	
	//添加图片
	public Integer insertProduct_image(Product_image p) {
		String sql = "INSERT INTO product_image (value_id, image_url) VALUES (?,?)";
		return executeUpdate(sql, p.getValue_id(),p.getImage_url());
	}

	//删除图片
	public Integer delectProduct_image(Integer img_id) {
		String sql = "delete from product_image where id =?";
		return executeUpdate(sql, img_id);
	}
	
	//修改图片
	public Integer updateProduct_image(Product_image p) {
		String sql = "update product_image set image_url=? where id =?";
		return executeUpdate(sql, p.getImage_url(),p.getId());
	}
	
	public static void main(String[] args) {
		System.out.println(new Product_ImageDAO().selectProduct_Image_id(3));
	}
}
