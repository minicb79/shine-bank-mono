create table if not exists customer (
    id serial primary key,
    name varchar(40) not null,
    surname varchar(80) not null,
    dob date not null,
    address_line1 varchar(120) not null,
    address_line2 varchar(120),
    city varchar(50) not null,
    state varchar(3) not null,
    postcode varchar(4) not null,
    phone varchar(20),
    email varchar(255));
