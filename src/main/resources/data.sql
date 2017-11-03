/**
 * CREATE Script for init of DB
 */

-- Create special offers
insert into specialprice (id, OFFER) values (1,'3 for 70');
insert into specialprice (id, OFFER) values (2,'2 for 70');

-- Create products
insert into product (id, PRODUCTNAME, UNITPRICE, SPECIAL_PRICE_ID) values (1, 'A', 100, 1);
insert into product (id, PRODUCTNAME, UNITPRICE, SPECIAL_PRICE_ID) values (2, 'B', 100, 2);
insert into product (id, PRODUCTNAME, UNITPRICE) values (3, 'C', 100);








