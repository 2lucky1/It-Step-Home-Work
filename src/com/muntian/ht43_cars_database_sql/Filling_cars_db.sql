USE cars_database;

-- Filling of car numbers
INSERT INTO car_numbers VALUES (NULL, 'AB4334BA');
INSERT INTO car_numbers VALUES (NULL, 'BH5425XB');
INSERT INTO car_numbers VALUES (NULL, 'AH4334TB');
INSERT INTO car_numbers VALUES (NULL, 'AP1053AA');

-- Filling of cars
INSERT INTO cars VALUES (NULL, 'Infinity', 'G35', 'Black', 2010, 'Sokolov V.I.', 'JN1BBNV36U0400852', (SELECT id FROM car_numbers WHERE car_number = 'AB4334BA'));
INSERT INTO cars VALUES (NULL, 'Mitsubishi', 'Lancer', 'Grey', 2012, 'Sokolov V.I.', 'JMBSRCS3A8U000000', (SELECT id FROM car_numbers WHERE car_number = 'BH5425XB'));
INSERT INTO cars VALUES (NULL, 'Ford', 'Sierra', 'White', 1996, 'Privalov B.N.', 'JT153SV2000011122', (SELECT id FROM car_numbers WHERE car_number = 'AH4334TB'));
INSERT INTO cars VALUES (NULL, 'Mazda', '6', 'Red', 2015, 'Kravchuk A.A.', 'JMZGG82L601697808', (SELECT id FROM car_numbers WHERE car_number = 'AP1053AA'));
