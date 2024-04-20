CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE person (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4()
);

CREATE TABLE vaccination_place (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    company VARCHAR(255) NOT NULL
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