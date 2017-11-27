DROP DATABASE IF EXISTS cars_database;
CREATE DATABASE cars_database;
USE cars_database;

CREATE TABLE car_numbers(
id INT NOT NULL AUTO_INCREMENT,
car_number VARCHAR(16) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE cars(
    id INT NOT NULL AUTO_INCREMENT,
    mark VARCHAR(32) NOT NULL,
    model VARCHAR(32) NOT NULL,
    color VARCHAR(32) NOT NULL,
    year YEAR(4) NOT NULL,
    owner VARCHAR(32),
    body_number VARCHAR(32),
    car_number_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (car_number_id) REFERENCES car_numbers (id)
);
