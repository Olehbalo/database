CREATE DATABASE IF NOT EXISTS projectlab;
USE projectlab;

DROP TABLE IF EXISTS site;
DROP TABLE IF EXISTS car_dealership;
DROP TABLE IF EXISTS addres;
DROP TABLE IF EXISTS car_type;
DROP TABLE IF EXISTS characteristic;
DROP TABLE IF EXISTS test_drive;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS seller;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS customer;



CREATE TABLE addres (
                        id INT NOT NULL AUTO_INCREMENT,
                        city VARCHAR(45) NOT NULL,
                        street VARCHAR(45) NOT NULL,
                        PRIMARY KEY (id));

CREATE TABLE customer (
                          id INT NOT NULL AUTO_INCREMENT,
                          first_name VARCHAR(45) NOT NULL,
                          last_name VARCHAR(45) NOT NULL,
                          email VARCHAR(45) NOT NULL,
                          PRIMARY KEY (id));

CREATE TABLE comment (
                         id INT NOT NULL AUTO_INCREMENT,
                         name VARCHAR(45) NOT NULL,
                         message VARCHAR(45) NOT NULL,
                         customer_id INT NOT NULL,
                         PRIMARY KEY (id),
                         INDEX idx_fk_comment_customer (customer_id ASC),
                         CONSTRAINT FK_comment_customer
                             FOREIGN KEY (customer_id)
                                 REFERENCES customer (id));

CREATE TABLE seller (
                        id INT NOT NULL AUTO_INCREMENT,
                        first_name VARCHAR(45) NOT NULL,
                        email VARCHAR(45) NOT NULL,
                        last_name VARCHAR(45) NOT NULL,
                        phone_number VARCHAR(45) NOT NULL,
                        PRIMARY KEY (id));

CREATE TABLE car (
                     id INT NOT NULL AUTO_INCREMENT,
                     brand VARCHAR(45) NOT NULL,
                     graduathion_year VARCHAR(45) NOT NULL,
                     ser_num INT(10) NOT NULL,
                     is_new BOOL NOT NULL,
                     is_sold BOOL NOT NULL,
                     comment_id INT NOT NULL,
                     seller_id INT NOT NULL,
                     PRIMARY KEY (id),
                     INDEX idx_fk_car_comment (comment_id ASC),
                     CONSTRAINT FK_car_comment
                         FOREIGN KEY (comment_id)
                             REFERENCES comment (id),
                     INDEX idx_fk_car_seller (seller_id ASC),
                     CONSTRAINT FK_car_seller
                         FOREIGN KEY (seller_id)
                             REFERENCES seller (id)
);

CREATE TABLE car_dealership (
                                id INT NOT NULL AUTO_INCREMENT ,
                                site VARCHAR(45) NOT NULL,
                                email VARCHAR(45) NOT NULL,
                                car_id INT NOT NULL,
                                addres_id INT NOT NULL,
                                PRIMARY KEY (id),
                                INDEX idx_fk_car_dealership_car (car_id ASC) ,
                                INDEX idx_fk_car_dealership_address (addres_id ASC) ,
                                CONSTRAINT FK_car_dealership_car
                                    FOREIGN KEY (car_id)
                                        REFERENCES car(id),
                                CONSTRAINT FK_car_dealership_addres
                                    FOREIGN KEY (addres_id)
                                        REFERENCES addres(id));

CREATE TABLE site (
                      id INT NOT NULL AUTO_INCREMENT,
                      car_dealership_id INT NOT NULL,
                      car_id INT NOT NULL,
                      PRIMARY KEY (id),
                      INDEX idx_fk_site_car_dealership (car_dealership_id ASC),
                      INDEX idx_fk_site_car (car_id ASC) ,
                      CONSTRAINT FK_site_car_dealership
                          FOREIGN KEY (car_dealership_id)
                              REFERENCES car_dealership(id),
                      CONSTRAINT FK_site_car
                          FOREIGN KEY (car_id)
                              REFERENCES car(id));

CREATE TABLE car_type (
                          id INT NOT NULL AUTO_INCREMENT,
                          type VARCHAR(45) NOT NULL,
                          car_id INT NOT NULL,
                          PRIMARY KEY (id),
                          INDEX idx_fk_car_type_car (id ASC),
                          CONSTRAINT FK_car_type_car
                              FOREIGN KEY (car_id)
                                  REFERENCES car (id)
);

CREATE TABLE characteristic (
                                id INT NOT NULL AUTO_INCREMENT,
                                drive VARCHAR(45) NOT NULL,
                                color VARCHAR(45) NOT NULL,
                                car_body VARCHAR(45) NOT NULL,
                                transmission VARCHAR(45) NOT NULL,
                                car_id INT NOT NULL,
                                PRIMARY KEY (id),
                                INDEX idx_fk_characteristic_car (car_id ASC),
                                CONSTRAINT FK_characteristic_car
                                    FOREIGN KEY (car_id)
                                        REFERENCES car (id));


CREATE TABLE test_drive (
                            id INT NOT NULL AUTO_INCREMENT,
                            brand VARCHAR(45) NOT NULL,
                            car_id INT NOT NULL,
                            PRIMARY KEY (id),
                            INDEX idx_fk_test_drive_car (car_id ASC),
                            CONSTRAINT FK_test_drive_car
                                FOREIGN KEY (car_id)
                                    REFERENCES car (id));




INSERT INTO addres(`city`, `street`) VALUES
                                         ('london', 'shevcenka'),
                                         ('kyiv', 'banderu'),
                                         ('lviv', 'mazepu'),
                                         ('stryi', 'franka');


INSERT INTO seller( `first_name`, `last_name`, `email`, `phone_number`) VALUES
                                                                            ('Oleh', 'Fedorov', 'oleh.fedorov@gmail.com', '3809564743'),
                                                                            ('Vitaliy', 'Leva' ,  'Vitali@gmail.com', '3809564743' ),
                                                                            ('Stiven', 'Poni' ,  'poni0809@gmail.com', '3809523743' );

INSERT INTO customer( `first_name`, `last_name`, `email`) VALUES
                                                              ('Oleh', 'Fedorov', 'oleh.fedorov@gmail.com'),
                                                              ('Ivan', 'Fedoriv', 'fedoriv@gmail.com');
INSERT INTO comment( `name`, `message`, `customer_id`) VALUES
                                                           ('oleh', 'good car', '1'),
                                                           ('ivan', 'you need go to doctor', '2');

INSERT INTO car(`brand`, `graduathion_year`, `ser_num`, `is_new`, `is_sold`, `comment_id`, `seller_id`) VALUES
                                                                                                            ('mersedes', '2021', '21334224', '1', '0', '1', '1' ),
                                                                                                            ('bmv', '2020', '21336724', '1', '0', '2', '2' );

INSERT INTO characteristic( `drive`, `color`, `car_body`, `transmission`, `car_id`) VALUES
                                                                                        ( 'front', 'black', 'iron','mechanic', '1' ),
                                                                                        ('front','yelov', 'iron', 'automatic', '2');




INSERT INTO car_dealership(`site`,`email`, `car_id`, `addres_id`) VALUES
                                                                      ('motors.com', 'motors@gmail.com', '1', '1'),
                                                                      ('lvivhluch', 'haluch@gmail.com', '2', '2');


INSERT INTO test_drive(`brand`, `car_id`) VALUES
                                              ('mersedes', '1'),
                                              ('bmv', '2');

INSERT INTO site(`car_dealership_Id`, `car_id`) VALUES
                                                    ('1', '1'),
                                                    ('2', '2');


INSERT INTO  car_type(`type`, `car_id`) VALUES
                                            ('hecback','1'),
                                            ('universal','2');


