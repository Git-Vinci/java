CREATE DATABASE IF NOT EXISTS `ProductDB`;
USE `ProductDB`;
CREATE TABLE IF NOT EXISTS `Product`(
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(255),
  price double,
  stock int
);

INSERT INTO Product VALUES('1','惠普笔记本电脑','4680.00','100');
INSERT INTO Product VALUES('2','长虹LED电视','3200.00','50');
INSERT INTO Product VALUES('3','DELL台式电脑','4500.00','300');
INSERT INTO Product VALUES('4','苹果IPhone手机','6999.00','1000');
INSERT INTO Product VALUES('5','美的微波炉','430.00','230');

