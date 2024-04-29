-- 创建数据库
CREATE DATABASE ECommerceDB ;

-- 使用数据库
USE ECommerceDB;

-- drop database ECommerceDB

-- 1用户信息表（users）
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    user_nickname VARCHAR(50) COMMENT '昵称',
    phone VARCHAR(11) NOT NULL COMMENT '手机号',
    user_password VARCHAR(20) NOT NULL COMMENT '密码',
    head_sculpture VARCHAR(255) COMMENT '头像地址',
    birth DATE COMMENT '生日',
    sex INT DEFAULT 0 COMMENT '性别 0:男 默认为0 1:女',
    create_time TIMESTAMP NOT NULL COMMENT '创建时间 那java里面的时间，比如会取值的时候会比现实中慢8小时',
    state INT DEFAULT 1 COMMENT '0:不可用 1:可用'
);
-- ALTER TABLE users MODIFY sex INT
-- ALTER TABLE users DROP COLUMN user_account
-- ALTER TABLE users MODIFY sex INT DEFAULT 0 COMMENT '性别 0:男 默认为0 1:女';
SELECT * FROM users;
DESC users;
SELECT COUNT(*) FROM users


-- 2管理员信息表（administrator）
CREATE TABLE administrator (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    admin_nickname VARCHAR(50) COMMENT '昵称',
    admin_account VARCHAR(20) NOT NULL COMMENT '账号',
    admin_password VARCHAR(20) NOT NULL COMMENT '密码',
    state INT DEFAULT 1 COMMENT '0:不可用 1:可用'
);
SELECT * FROM administrator;
DESC administrator;

SELECT * FROM administrator WHERE admin_account ='anmin' AND admin_password = '123456' AND state=1


-- 3用户登录时间表（user_login_time）
CREATE TABLE user_login_time (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    user_id INT NOT NULL COMMENT '用户id 外键',
    FOREIGN KEY (user_id) REFERENCES users(id),
    login_time  TIMESTAMP NOT NULL COMMENT '登录时间 那java里面拿时间'
	);
	SELECT * FROM user_login_time;
DESC user_login_time;



-- 4商品类别表（category）       
CREATE TABLE category (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    category_type VARCHAR(100) NOT NULL COMMENT '商品型号类别',
    state INT DEFAULT 1 COMMENT '0:不可用 1:可用'
);
SELECT * FROM category;
DESC category;

INSERT INTO category (category_type) VALUES ('X系列');

INSERT INTO category (category_type) VALUES ('S系列');

INSERT INTO category (category_type) VALUES ('Y系列');

INSERT INTO category (category_type) VALUES ('IQOO手机');


-- 5商品表（product）	
CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    products_name VARCHAR(100) NOT NULL COMMENT '商品名称',
    category_id INT NOT NULL COMMENT '类别表id',
    FOREIGN KEY (category_id) REFERENCES category(id),
    description VARCHAR(255) COMMENT '商品描述',
    hits BIGINT DEFAULT 0 COMMENT '点击量',
    purchase_limit INT DEFAULT 1 COMMENT '购买限制 默认1台',
    listing_time TIMESTAMP COMMENT '上架时间 当状态变成1的时候，就更改',
    state INT DEFAULT 0 COMMENT '0：待上架 1：上架 2：下架/缺货'
);
SELECT * FROM product;
DESC product;

SELECT pi.image_url FROM product p
JOIN product_specifications ps ON p.id = ps.product_id
JOIN specification_value sv ON ps.id = sv.specifications_id
JOIN product_image PI ON sv.id = pi.value_id
WHERE p.id = 1 LIMIT 1;

INSERT INTO product (products_name, category_id, description,listing_time) VALUES
('X Fold3 Pro', 1, '236g机身超轻薄设计|等效5700mAh蓝海电池|超可靠铠羽架构|蔡司超级长焦|100W双芯闪充+50W无线闪充|第三代骁龙8 SPU旗舰芯片','2024-4-3 12:00:00'),
('X Fold3', 1, '219g机身超轻薄设计|等效5500mAh蓝海电池|超可靠铠羽架构|蔡司超级长焦|2K+ E7超感巨幕|80W超快闪充','2024-4-3 12:00:00')

INSERT INTO product (products_name, category_id, description,listing_time,state) VALUES
('S18 Pro', 2, '前后5000万旗舰三主摄|专业长焦人像镜头|天玑9200+超旗舰芯','2024-4-3 12:00:00',1)

INSERT INTO product (products_name, category_id, description,listing_time,state) VALUES
('Y100', 3, '琉璃质感工艺|6400万OIS光学防抖|至高12GB+512GB大内存','2024-4-3 12:00:00',1)



-- 6商品规格表(product_specifications)
CREATE TABLE product_specifications (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    product_id INT NOT NULL COMMENT '商品表id',
    FOREIGN KEY (product_id) REFERENCES product(id),
    specifications_name VARCHAR(100) NOT NULL COMMENT '规格名称'
);
INSERT INTO product_specifications (product_id, specifications_name) VALUES
(1, '版本'),
(1, '颜色'),
(2, '版本'),
(2, '颜色')

INSERT INTO product_specifications (product_id, specifications_name) VALUES
(3, '版本'),
(3, '颜色')

INSERT INTO product_specifications (product_id, specifications_name) VALUES
(4, '版本'),
(4, '颜色')

SELECT * FROM product_specifications;
SELECT * FROM product_specifications WHERE product_id = 4;
DESC product_specifications;


-- 7商品规格值表（specification_value）
CREATE TABLE specification_value (
    id INT PRIMARY KEY auto_incrementREMENT COMMENT 'id',
    specifications_id INT NOT NULL COMMENT '规格表id',
    FOREIGN KEY (specifications_id) REFERENCES product_specifications(id),
    `value` VARCHAR(255) NOT NULL COMMENT '规格值'
);
INSERT INTO specification_value (specifications_id, `value`) VALUES
(1, '16GB+512GB'),
(1, '16GB+1TB'),
(2, '薄翼黑'),
(2, '轻羽白'),


(3, '12GB+256GB'),
(3, '16GB+256GB'),
(3, '16GB+512GB'),
(3, '16GB+1TB'),
(4, '薄翼黑'),
(4, '轻羽白')

INSERT INTO specification_value (specifications_id, `value`) VALUES
(5, '12GB+256GB'),
(5, '16GB+256GB'),
(5, '16GB+512GB'),
(6, '玄黑'),
(6, '清澈'),
(6, '花似锦')

INSERT INTO specification_value (specifications_id, `value`) VALUES
(7, '8GB+128GB'),
(7, '8GB+256GB'),
(7, '12GB+256GB'),
(7, '12GB+512GB'),
(8, '星夜黑'),
(8, '璃光蓝'),
(8, '琉云青')

SELECT * FROM product p
LEFT JOIN product_specifications ps ON p.id = ps.product_id
LEFT JOIN specification_value s ON ps.id = s.specifications_id
LEFT JOIN product_image pim ON pim.value_id = s.id

SELECT * FROM specification_value WHERE specifications_id = 6;
DESC specification_value;


-- 8商品规格图片（product_image）
CREATE TABLE product_image (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    value_id INT NOT NULL COMMENT '规格值表id',
    FOREIGN KEY (value_id) REFERENCES specification_value(id),
    image_url VARCHAR(255) NOT NULL COMMENT '图片路径'
);
INSERT INTO product_image (value_id, image_url) VALUES
(3, 'X Fold3 Pro.png'),
(4, 'tu2.png'),
(9, 'X Fold3.png'),
(10, 'tu4.png')

INSERT INTO product_image (value_id, image_url) VALUES
(14, 'S18 Pro.png'),
(15, 'tu'),
(16, 'tu')
INSERT INTO product_image (value_id, image_url) VALUES
(21, 'Y100.png'),
(22, 'tu'),
(23, 'tu')

INSERT INTO product_image (value_id, image_url) VALUES
(3, 'X Fold3 Pro_2.png'),
(3, 'X Fold3 Pro_3.png'),
(3, 'X Fold3 Pro_4.png')

INSERT INTO product_image (value_id, image_url) VALUES
(4, 'X Fold3 Pro_5.png'),
(4, 'X Fold3 Pro_6.png'),
(4, 'X Fold3 Pro_7.png'),
(4, 'X Fold3 Pro_8.png')

SELECT * FROM 	 WHERE value_id =3;
DESC product_image;


-- 9价格表（commodity_price）
CREATE TABLE commodity_price (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    price DECIMAL(10,2) NOT NULL COMMENT '价格',
    product_id INT NOT NULL COMMENT '商品表id',
    FOREIGN KEY (product_id) REFERENCES product(id),
    is_recommended INT DEFAULT 0 COMMENT '是否推荐商品 0不是 1是',
);

ALTER TABLE commodity_price
ADD FOREIGN KEY (product_id) REFERENCES product(id);

INSERT INTO commodity_price (price) VALUES
(9999.00),
(10999.00),
(6999.00),
(7499.00),
(7999.00),
(8999.00)

INSERT INTO commodity_price (price) VALUES
(2899.00),
(3499.00),
(3649.00)

INSERT INTO commodity_price (product_id,price) VALUES
(4,1140.00),
(4,1599.00),
(4,1799.00),
(4,1999.00)





SELECT * FROM commodity_price;
DESC commodity_price;




-- 10价格组合表（price_combination）
CREATE TABLE price_combination (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    price_id INT NOT NULL COMMENT '商品(组合)价格id',
    FOREIGN KEY (price_id) REFERENCES commodity_price(id),
    value_id INT NOT NULL COMMENT '规格值id',
    FOREIGN KEY (value_id) REFERENCES specification_value(id)
);

INSERT INTO price_combination (price_id,value_id) VALUES
(1,1),
(1,3),
(1,4),
(2,2),
(2,3),
(2,4),

(3,5),
(3,9),
(3,10),
(4,6),
(4,9),
(4,10),
(5,7),
(5,9),
(5,10),
(6,8),
(6,9),
(6,10)


INSERT INTO price_combination (price_id,value_id) VALUES
(7,11),
(7,14),
(7,15),
(7,16),
(8,12),
(8,14),
(8,15),
(8,16),
(9,13),
(9,14),
(9,15),
(9,16)


INSERT INTO price_combination (price_id,value_id) VALUES
(10,17),
(10,21),
(10,22),
(10,23),

(11,18),
(11,21),
(11,22),
(11,23),

(12,19),
(12,21),
(12,22),
(12,23),

(13,20),
(13,21),
(13,22),
(13,23)


SELECT * FROM price_combination WHERE price_id = 1;
DESC price_combination;

SELECT cp.price
FROM commodity_price cp
INNER JOIN price_combination pc ON cp.id = pc.price_id
WHERE pc.value_id IN (, 3)
GROUP BY cp.price,cp.id
HAVING COUNT(DISTINCT pc.value_id) = 2

-- 11用户商品浏览足迹(user_product_footprint)
CREATE TABLE user_product_footprint (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    user_id INT NOT NULL COMMENT '用户id',
    FOREIGN KEY (user_id) REFERENCES users(id),
    products_id INT NOT NULL COMMENT '商品id',
    FOREIGN KEY (products_id) REFERENCES product(id),
    browse_time TIMESTAMP NOT NULL COMMENT '浏览时间 java时间'
);
SELECT * FROM user_product_footprint;
DESC user_product_footprint;

-- 在有价格表里添加颜色的规格
-- 12购物车(shopping_cart)
CREATE TABLE shopping_cart (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    user_id INT NOT NULL COMMENT '用户表id',
    FOREIGN KEY (user_id) REFERENCES users(id),
    product_id INT NOT NULL COMMENT '商品表id',
    FOREIGN KEY (product_id) REFERENCES product(id),
    sku VARCHAR(255) NOT NULL COMMENT '组合信息',
    quantity INT NOT NULL COMMENT '购买数量',
    add_time TIMESTAMP COMMENT '加入购物车时间 java',
    state INT DEFAULT 0 COMMENT '0：未结算 1：已结算 2：已删除'
);
SELECT * FROM shopping_cart;
DESC shopping_cart;
UPDATE shopping_cart SET sku = JSON_REPLACE(sku, '$.number', '2') WHERE id = 20


ALTER TABLE shopping_cart DROP FOREIGN KEY shopping_cart_ibfk_3;
ALTER TABLE shopping_cart DROP COLUMN price_id;
ALTER TABLE shopping_cart ADD sku VARCHAR(255) NOT NULL COMMENT '组合信息';


ALTER TABLE shopping_cart DROP COLUMN total_price;


	UPDATE shopping_cart SET state=0 WHERE id IN (19) AND user_id = 3


-- 13收藏表（collection）
CREATE TABLE collection (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    user_id INT NOT NULL COMMENT '用户表id',
    FOREIGN KEY (user_id) REFERENCES users(id),
    product_id INT NOT NULL COMMENT '商品表id',
    FOREIGN KEY (product_id) REFERENCES product(id),
    sku VARCHAR(255) NOT NULL COMMENT '组合信息',
    add_time TIMESTAMP COMMENT '收藏加入时间',
    state INT DEFAULT 1 COMMENT '0：删除 1：未删除 '
);
SELECT * FROM collection;
DESC collection;

SELECT * FROM collection WHERE user_id = 3 AND product_id = 3 AND sku = '{"sku_price":7,"pageType":11,"color":14,"number":1}' AND state = 1;


 SELECT COUNT(*) AS collection_count
FROM collection
WHERE state = 1 AND product_id = 1
GROUP BY product_id;

ALTER TABLE collection DROP FOREIGN KEY collection_ibfk_3;
ALTER TABLE collection DROP COLUMN price_id;
ALTER TABLE collection ADD sku VARCHAR(255) NOT NULL COMMENT '组合信息';


-- 14收货地址(address）   
CREATE TABLE address (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    user_id INT NOT NULL COMMENT '用户表id',
    FOREIGN KEY (user_id) REFERENCES users(id),
    consignee VARCHAR(100) NOT NULL COMMENT '收货人',
    phone VARCHAR(11) NOT NULL COMMENT '手机号',
    receiving_region VARCHAR(200) NOT NULL COMMENT '收货地址',
    default_address INT NOT NULL COMMENT '默认地址 1默认 2不是默认',
    detailed_region VARCHAR(200) COMMENT '详细地址',
    state INT DEFAULT 1 COMMENT '0：不可用 1：可以 '
);
SELECT * FROM address;
DESC address;

INSERT INTO address VALUES(NULL,3,'111','19312341234',' 福建省 莆田市 仙游县','2','xxxx','1'),(NULL,3,'22222','19312341234',' 湖南省 株洲市 荷塘区','1','1059号','1')

SELECT * FROM city

-- 15订单表(orders）      
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    order_number VARCHAR(50) UNIQUE KEY NOT NULL COMMENT '订单号 dd00000000001',
    user_id INT NOT NULL COMMENT '用户表id',
    FOREIGN KEY (user_id) REFERENCES users(id),
    consignee VARCHAR(100) NOT NULL COMMENT '收货人',
    phone VARCHAR(11) NOT NULL COMMENT '手机号',
    receiving_region VARCHAR(200) NOT NULL COMMENT '收货地址',
    order_time TIMESTAMP NOT NULL COMMENT '订单时间',
    state INT NOT NULL COMMENT '订单状态 1:已付款2：未付款 半小时未付款，就取消3：已取消4：退款款5：已退款6：已发货7：已完成'
);
SELECT * FROM orders;
DESC orders;
INSERT INTO orders (order_number, user_id, consignee, phone, receiving_region,order_time,state) 
VALUES ('20240400000001',3,'11','1234567890','zzs',NOW(),7)
INSERT INTO orders (order_number, user_id, consignee, phone, receiving_region,order_time,state) 
VALUES ('20240400000002',2,'122221','1234567890','zzs',NOW(),7)

SELECT COUNT(*) FROM orders WHERE state = 2 AND user_id = 3

INSERT INTO address VALUES(NULL,'202404000000003',3,'pp','19312341234','广东省 中山市 大涌镇     xxx','2024-04-19 00:15:49.6',2)

-- 16订单详细表（order_details）
CREATE TABLE order_details (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    order_number VARCHAR(50) NOT NULL COMMENT '订单号 外联',
    FOREIGN KEY (order_number) REFERENCES orders(order_number),
    product_id INT NOT NULL COMMENT '商品表id',
    FOREIGN KEY (product_id) REFERENCES product(id),
    sku VARCHAR(255) NOT NULL COMMENT '组合信息',
    product_quantity INT NOT NULL COMMENT '商品数量',
    product_total DECIMAL(10,2) NOT NULL COMMENT '商品总价'
);
SELECT * FROM order_details;
DESC order_details;
INSERT INTO order_details (order_number, product_id, sku, product_quantity, product_total) 
VALUES ('20240400000001',1,'{"sku_price":1,"pageType":1,"color":3,"number":1}',1,2000)
INSERT INTO order_details (order_number, product_id, sku, product_quantity, product_total) 
VALUES ('20240400000002',1,'{"sku_price":1,"pageType":1,"color":3,"number":1}',1,2000)

ALTER TABLE order_details DROP FOREIGN KEY order_details_ibfk_3;
ALTER TABLE order_details DROP COLUMN price_id;
ALTER TABLE order_details ADD sku VARCHAR(255) NOT NULL COMMENT '组合信息';

insert INTO order_details VALUES(null,'202404000000004',3,'{"sku_price":7,"pageType":11,"color":14,"number":1}',1,2899)

-- SELECT product_id, COUNT(*) as count FROM order_details GROUP BY product_id;


-- 17退款表（refund）
CREATE TABLE refund (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    user_id INT NOT NULL COMMENT '用户表id',
    FOREIGN KEY (user_id) REFERENCES users(id),
    order_number VARCHAR(50) NOT NULL COMMENT '订单号',
    FOREIGN KEY (order_number) REFERENCES orders(order_number),
    refund_amount DECIMAL(10,2) NOT NULL COMMENT '退款金额',
    refund_reason VARCHAR(255) NOT NULL COMMENT '退款原因',
    state INT DEFAULT 0 COMMENT '退款状态 0:待审核（退款中默认）1：审核通过2：审核拒绝3：已取消',
    create_time TIMESTAMP NOT NULL COMMENT '退款时间',
    update_time TIMESTAMP COMMENT '更新时间',
    remark VARCHAR(500) COMMENT '备注'
);
SELECT * FROM refund;
DESC refund;



-- 18广告表（advertisement）   
CREATE TABLE advertisement (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    advertisement_url VARCHAR(255) NOT NULL COMMENT '广告图片地址',
    product_id INT NOT NULL COMMENT '商品表id',
    FOREIGN KEY (product_id) REFERENCES product(id),
    state INT DEFAULT 1 COMMENT '广告状态 0不摆放 1摆放'
);
SELECT * FROM advertisement where state =1;
DESC advertisement;

INSERT INTO advertisement VALUE (NULL,'tu',1,1);
INSERT INTO advertisement VALUE (NULL,'tu',2,1);
INSERT INTO advertisement VALUE (NULL,'tu',3,1);
INSERT INTO advertisement VALUE (NULL,'tu',4,1);



-- 19评论表（comments）
CREATE TABLE comments (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    user_id INT NOT NULL COMMENT '用户id',
    FOREIGN KEY (user_id) REFERENCES users(id),
    user_com VARCHAR(500) NOT NULL COMMENT '用户评论',
    product_id INT NOT NULL COMMENT '商品表id',
    FOREIGN KEY (product_id) REFERENCES product(id),
    state INT NOT NULL COMMENT '审核状态 0：未审核 默认 1：已审核2：审核未通过 3:已删除',
    com_grade INT NOT NULL COMMENT '评论等级'
);
SELECT * FROM comments WHERE product_id = 1 AND state IN (0,1);

SELECT * FROM comments c 
LEFT JOIN users u ON c.`user_id` = u.`id`



DESC comments;

INSERT INTO comments (user_id, user_com, product_id, state, com_grade) 
VALUES 
(3,'111111111111',1,0,5),
(2,'111111111111',1,1,5),
(3,'111111111111',1,1,3),
(3,'111111111111',1,1,3),
(3,'111111111111',1,1,5),
(2,'111111111111',1,1,5),
(3,'111111111111',1,1,5),
(3,'111111111111',1,1,5),
(3,'111111111111',1,1,5),
(3,'111111111111',1,1,5),
(3,'323423423',1,1,1),
(3,'111123423423411111111',1,1,2)

SELECT 
    u.head_sculpture,
    u.user_nickname,
    u.phone,
    c.user_com ,
    od.sku AS purchased_sku
FROM 
    comments c
JOIN 
    users u ON c.user_id = u.id
JOIN 
    orders o ON o.user_id = u.id
JOIN 
    order_details od ON o.order_number = od.order_number
WHERE 
    c.product_id = 1 AND
    od.product_id = c.product_id
    AND o.state = 7 AND c.state IN (0,1)
    ORDER BY c.id DESC
    LIMIT 0,1









SELECT id, products_name, hits
FROM product
ORDER BY hits DESC
LIMIT 10;

SELECT * FROM commodity_price

SELECT 
    p.id, 
    p.products_name, 
    p.description, 
    cp.price,
    (SELECT image_url 
     FROM product_image PI 
     JOIN specification_value sv ON pi.value_id = sv.id
     JOIN product_specifications ps ON sv.specifications_id = ps.id
     WHERE ps.product_id = p.id
     LIMIT 1) AS image_url
FROM 
    product p
JOIN commodity_price cp ON p.id = cp.product_id
WHERE 
    cp.is_recommended = 1
ORDER BY p.id DESC LIMIT 3;

SELECT 
    p.id,
    p.products_name,
    p.description,
    p.hits,
    (SELECT MIN(cp.price) 
     FROM commodity_price cp 
     WHERE cp.product_id = p.id) AS min_price,
    (SELECT pi.image_url 
     FROM product_image PI 
     JOIN specification_value sv ON pi.value_id = sv.id
     JOIN product_specifications ps ON sv.specifications_id = ps.id 
     WHERE ps.product_id = p.id 
     LIMIT 1) AS image_url
FROM 
    product p
ORDER BY p.hits DESC LIMIT 8;


-- 查询商品的图片集
SELECT pi.image_url FROM product p
JOIN product_specifications ps ON p.id = ps.product_id
JOIN specification_value sv ON ps.id = sv.specifications_id
JOIN product_image PI ON sv.id = pi.value_id
WHERE p.id = 1 ;






SELECT 
    sv.value AS 'Specification Value'
FROM 
    commodity_price cp
JOIN 
    price_combination pc ON cp.id = pc.price_id
JOIN 
    specification_value sv ON pc.value_id = sv.id
JOIN 
    product_specifications ps ON sv.specifications_id = ps.id
WHERE 
    cp.id = 1 AND cp.product_id = 1 AND ps.product_id = cp.product_id;
    
    
UPDATE product, (SELECT hits FROM product WHERE id = 1) AS temp_table
SET product.hits = temp_table.hits + 1
WHERE product.id = 1;






SELECT pi.image_url 
FROM product_image PI
JOIN specification_value sv ON pi.value_id = sv.id
JOIN product_specifications ps ON sv.specifications_id = ps.id
JOIN product p ON ps.product_id = p.id
WHERE sv.id IN (5, 10)
GROUP BY p.id,pi.image_url
LIMIT 1;



SELECT  u.head_sculpture,u.user_nickname,    c.user_com ,  od.sku,c.com_grade FROM comments c 
JOIN  users u ON c.user_id = u.id
    			JOIN 
    			   orders o ON o.user_id = u.id
    			JOIN 
    			   order_details od ON o.order_number = od.order_number
    			WHERE 
    			 c.product_id = 1 AND
    			   od.product_id = c.product_id
    			  AND o.state = 7 AND c.state IN (0,1)
    			   ORDER BY c.id DESC
    			  LIMIT 5,5
