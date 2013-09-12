use test;
create table eshop_order_details(
id integer auto_increment primary key,
order_id integer,
title varchar(70),
author varchar(70),
quantity integer,
price double precision
);

create table eshop_orders(
id integer auto_increment,
delivery_name varchar(70),
delivery_address varchar(70),
cc_name varchar(70),
cc_number varchar(32),
cc_expiry varchar(20),
primary key(id)
);

alter table eshop_order_details add constraint order_id foreign key (order_id) references eshop_orders (order_id);

create  index order_id_key on eshop_orders (id);



