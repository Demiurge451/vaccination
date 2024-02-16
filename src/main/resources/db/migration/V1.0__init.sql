CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
create table person (
    id UUID primary key default uuid_generate_v4(),
    full_name varchar not null
);

create table address (
    id uuid primary key default uuid_generate_v4()
);

create table contact (
    id uuid primary key default uuid_generate_v4()
);

create table document (
    id uuid primary key default uuid_generate_v4()
);

create table region (
    id uuid primary key default uuid_generate_v4()
);