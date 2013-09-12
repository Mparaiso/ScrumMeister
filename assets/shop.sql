create table eshop_categories(
    id integer not null auto_increment,
    name varchar(70),
    primary key(id)
);

create table eshop_books(
    id integer not null auto_increment,
    title varchar(70),
    author varchar(70),
    price double precision,
    category_id integer,
    primary key(id)
);

create index book_id_key on eshop_books(id);
create index category_id_key on eshop_categories(id);

alter table eshop_books add index category_id (category_id),
    add constraint category_id foreign key(category_id)
    references eshop_categories(id);

