CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table region (
    id uuid primary key default uuid_generate_v4(),
    country varchar(255) not null,
    administrative_division varchar(255)
);

create table address (
    id uuid primary key default uuid_generate_v4(),
    city varchar(255),
    street varchar(255),
    building_number varchar(255),
    region_id UUID,
    foreign key (region_id) references region (id)
);

create table person (
    id UUID primary key default uuid_generate_v4(),
    login varchar(50) not null unique,
    password varchar(50) not null,
    full_name varchar(255) not null,
    birth_date date not null,
    address_id UUID,
    foreign key (address_id) references address (id)
);

create table contact (
    id uuid primary key default uuid_generate_v4(),
    type varchar(50) not null,
    person_id UUID not null,
    foreign key (person_id) references person (id)
);

create table document (
    id uuid primary key default uuid_generate_v4(),
    type varchar(50) not null,
    person_id UUID not null,
    foreign key (person_id) references person (id)
);

