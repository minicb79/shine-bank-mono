create sequence customer_seq start with 1 increment by 50;
create table customer (dob date not null, id integer not null, postcode varchar(4) not null, state varchar(3) not null, phone varchar(10), name varchar(40) not null, city varchar(50) not null, surname varchar(80) not null, address_line1 varchar(120) not null, address_line2 varchar(120), email varchar(255), primary key (id));
create sequence customer_seq start with 1 increment by 50;
create table customer (dob date not null, id integer not null, postcode varchar(4) not null, state varchar(3) not null, phone varchar(10), name varchar(40) not null, city varchar(50) not null, surname varchar(80) not null, address_line1 varchar(120) not null, address_line2 varchar(120), email varchar(255), primary key (id));
