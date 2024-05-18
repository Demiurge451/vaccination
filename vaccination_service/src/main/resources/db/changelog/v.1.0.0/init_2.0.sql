drop table if exists person, vaccination_place, vaccination, region;

create table region (
    id uuid primary key default uuid_generate_v4(),
    country varchar(255) not null,
    administrative_division varchar(255)
);

CREATE TABLE person (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4()
);

CREATE TABLE vaccination_place (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    company VARCHAR(255) NOT NULL,
    city varchar(255) not null,
    street varchar(255),
    building_number varchar(255),
    region_id uuid not null,
    foreign key (region_id) references region (id)
);

CREATE TABLE vaccination (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    vaccine_type VARCHAR(50) NOT NULL,
    vaccination_date DATE,
    person_id UUID NOT NULL,
    vaccination_place_id UUID NOT NULL UNIQUE,
    FOREIGN KEY (person_id) REFERENCES person (id),
    FOREIGN KEY (vaccination_place_id) REFERENCES vaccination_place (id)
);