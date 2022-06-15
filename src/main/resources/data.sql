INSERT INTO company (created_by, created_time, is_deleted, updated_by, updated_time, address1, address2, company_status, email, enabled, establishment_date, phone, representative, state, title, zip)
VALUES (1, '2022-05-01 00:00:00', FALSE, 1, '2022-05-01 00:00:00', 'Street1 ', 'House Nu: 1', 'ENABLED', 'root@root.com', TRUE, '2020-01-01 00:00:00', '0111222333', 'Representative Root', 'ALABAMA', 'Cydeo', '35242'),
       (1, '2021-05-02 00:00:00', FALSE, 1, '2021-05-02 00:00:00', 'Street2 ', 'House Nu: 2', 'ENABLED', 'admin1@admin.com', TRUE, '2020-01-01 00:00:00', '0222222333', 'Admin1 AdminLName1', 'ARIZONA', 'Company1', '38704'),
       (1, '2021-05-03 00:00:00', FALSE, 1, '2021-05-03 00:00:00', 'Street3 ', 'House Nu: 3', 'ENABLED', 'admin2@admin.com', TRUE, '2020-01-01 00:00:00', '0333222333', 'Admin2 AdminLName2', 'FLORIDA', 'Company2', '33027'),
       (1, '2021-05-03 00:00:00', FALSE, 1, '2021-05-03 00:00:00', 'Street4 ', 'House Nu: 4', 'ENABLED', 'admin3@admin.com', TRUE, '2020-01-01 00:00:00', '0333222444', 'Admin3 AdminLName3', 'FLORIDA', 'Company3', '33027');


INSERT INTO client_vendor (created_by, created_time, is_deleted, updated_by, updated_time, company_name, phone, email, address, zip_code, enabled, type, company_id, state_id)
VALUES (2, '2021-05-02 00:00:00', FALSE, 2, '2021-05-01 00:00:00', 'Vendor1', '1234567890', 'vendor1@email.com', 'Street 1.', '35242', TRUE, 'VENDOR', 1, 'ALABAMA'),
       (2, '2021-05-02 00:00:00', FALSE, 2, '2021-05-02 00:00:00', 'Client1', '0987654321', 'client1@email.com', 'Street 2', '38704', FALSE, 'CLIENT', 2, 'ARIZONA'),
       (3, '2021-05-03 00:00:00', FALSE, 3, '2021-05-03 00:00:00', 'Client2', '7894561230', 'client2@email.com', 'Street 3', '33027', TRUE, 'CLIENT', 3, 'FLORIDA'),
       (3, '2021-05-03 00:00:00', FALSE, 3, '2021-05-03 00:00:00', 'Client3', '7894561230', 'client3@email.com', 'Street 4', '33027', TRUE, 'CLIENT', 3, 'FLORIDA');


INSERT INTO category (created_by, created_time, is_deleted, updated_by, updated_time, description, enabled, company_id)
VALUES (2, '2022-05-11 00:00:00', FALSE, 2, '2022-05-11 00:00:00', 'Electronics', TRUE, 2),
       (2, '2022-05-11 00:00:00', FALSE, 2, '2022-05-11 00:00:00', 'Computers', TRUE, 2),
       (3, '2022-05-11 00:00:00', FALSE, 3, '2022-05-11 00:00:00', 'Sports', TRUE, 3);


INSERT INTO invoice (created_by, created_time, is_deleted, updated_by, updated_time, enabled, invoice_date, invoice_number, invoice_status, invoice_type, sptable_id, company_id)
VALUES (5, '2022-05-16 00:00:00', FALSE, 5, '2022-05-16 00:00:00', TRUE, '05/16/2022', 'P-INV001', 'APPROVED', 'PURCHASE', 1, 2),
       (5, '2022-05-20 00:00:00', FALSE, 5, '2022-05-20 00:00:00', TRUE, '05/20/2022', 'P-INV002', 'APPROVED', 'PURCHASE', 1, 2),
       (5, '2022-06-10 00:00:00', FALSE, 5, '2022-06-10 00:00:00', TRUE, '06/10/2022', 'S-INV003', 'APPROVED', 'SALE', 2, 2),
       (5, '2022-06-10 00:00:00', FALSE, 5, '2022-06-10 00:00:00', TRUE, '06/10/2022', 'S-INV004', 'APPROVED', 'SALE', 3, 2),
       (5, '2022-06-11 00:00:00', FALSE, 5, '2022-06-11 00:00:00', TRUE, '06/10/2022', 'S-INV005', 'APPROVED', 'SALE', 4, 2),
       (7, '2022-05-12 00:00:00', FALSE, 7, '2022-05-12 00:00:00', TRUE, '05/12/2022', 'P-INV001', 'APPROVED', 'PURCHASE', 1, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-10 00:00:00', TRUE, '05/15/2022', 'P-INV002', 'APPROVED', 'PURCHASE', 1, 3),
       (7, '2022-06-11 00:00:00', FALSE, 7, '2022-06-11 00:00:00', TRUE, '06/11/2022', 'S-INV001', 'APPROVED', 'SALE', 2, 2),
       (7, '2022-06-12 00:00:00', FALSE, 7, '2022-06-12 00:00:00', TRUE, '06/12/2022', 'S-INV002', 'APPROVED', 'SALE', 2, 2),
       (7, '2022-06-13 00:00:00', FALSE, 7, '2022-06-13 00:00:00', TRUE, '06/13/2022', 'S-INV003', 'APPROVED', 'SALE', 2, 2),
       (9, '2022-05-12 00:00:00', FALSE, 9, '2022-05-12 00:00:00', TRUE, '05/12/2022', 'P-INV001', 'APPROVED', 'PURCHASE', 1, 4),
       (9, '2022-05-13 00:00:00', FALSE, 9, '2022-05-13 00:00:00', TRUE, '05/13/2022', 'P-INV002', 'APPROVED', 'PURCHASE', 1, 4),
       (9, '2022-06-11 00:00:00', FALSE, 9, '2022-06-11 00:00:00', TRUE, '06/11/2022', 'S-INV001', 'APPROVED', 'SALE', 3, 4),
       (9, '2022-06-12 00:00:00', FALSE, 9, '2022-06-12 00:00:00', TRUE, '06/12/2022', 'S-INV002', 'APPROVED', 'SALE', 3, 4),
       (9, '2022-06-13 00:00:00', FALSE, 9, '2022-06-13 00:00:00', TRUE, '06/13/2022', 'S-INV003', 'APPROVED', 'SALE', 3, 4);


INSERT INTO product (created_by, created_time, is_deleted, updated_by, updated_time, description, enabled, low_limit_alert, name, new_column, product_status, qty, tax, unit, category_id, company_id)
VALUES (5, '2022-01-15 00:00:00', FALSE, 5, '2022-01-15 00:00:00', 'Electronics', TRUE, 10, 'TV', 1, 'ACTIVE', 50, 10, 'PCS', 1, 2),
       (5, '2022-01-15 00:00:00', FALSE, 5, '2022-01-15 00:00:00', 'Electronics', TRUE, 10, 'Dishwasher', 1, 'ACTIVE', 150, 10, 'PCS', 1, 2),
       (5, '2022-01-15 00:00:00', FALSE, 5, '2022-01-15 00:00:00', 'Electronics', TRUE, 10, 'Doorbell Camera', 1, 'ACTIVE', 150, 10, 'PCS', 1, 2),
       (5, '2022-01-15 00:00:00', FALSE, 5, '2022-01-15 00:00:00', 'Electronics', TRUE, 10, 'Safe', 1, 'ACTIVE', 250, 10, 'PCS', 1, 2),
       (5, '2022-01-15 00:00:00', FALSE, 5, '2022-01-15 00:00:00', 'Electronics', TRUE, 10, 'Reading Lamp', 1, 'ACTIVE', 250, 10, 'PCS', 1, 2),
       (5, '2022-01-15 00:00:00', FALSE, 5, '2022-01-15 00:00:00', 'Electronics', TRUE, 10, 'Oven', 1, 'ACTIVE', 50, 10, 'PCS', 1, 2),
       (5, '2022-01-15 00:00:00', FALSE, 5, '2022-01-15 00:00:00', 'Electronics', TRUE, 10, 'Scale', 1, 'ACTIVE', 50, 10, 'PCS', 1, 2),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Computer', TRUE, 10, 'MacBook', 1, 'ACTIVE', 50, 10, 'PCS', 2, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Computer', TRUE, 10, 'Printer', 1, 'ACTIVE', 50, 10, 'PCS', 2, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Computer', TRUE, 10, 'Scanner', 1, 'ACTIVE', 50, 10, 'PCS', 2, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Computer', TRUE, 10, 'Mouse', 1, 'ACTIVE', 50, 10, 'PCS', 2, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Computer', TRUE, 10, 'UPS', 1, 'ACTIVE', 50, 10, 'PCS', 2, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Computer', TRUE, 10, 'Speakers', 1, 'ACTIVE', 50, 10, 'PCS', 2, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Computer', TRUE, 10, 'Keyboard', 1, 'ACTIVE', 250, 10, 'PCS', 2, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Computer', TRUE, 10, 'RAM', 1, 'ACTIVE', 250, 10, 'PCS', 2, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Computer', TRUE, 10, 'CPU', 1, 'ACTIVE', 150, 10, 'PCS', 2, 3),
       (9, '2022-05-15 00:00:00', FALSE, 9, '2022-05-15 00:00:00', 'Sports', TRUE, 10, 'Running Shoes', 1, 'ACTIVE', 150, 10, 'PCS', 3, 4),
       (9, '2022-05-15 00:00:00', FALSE, 9, '2022-05-15 00:00:00', 'Sports', TRUE, 10, 'T-Shorts', 1, 'ACTIVE', 1000, 10, 'PCS', 3, 4),
       (9, '2022-05-15 00:00:00', FALSE, 9, '2022-05-15 00:00:00', 'Sports', TRUE, 10, 'Shorts', 1, 'ACTIVE', 1500, 10, 'PCS', 3, 4),
       (9, '2022-05-15 00:00:00', FALSE, 9, '2022-05-15 00:00:00', 'Sports', TRUE, 10, 'Socks', 1, 'ACTIVE', 1500, 10, 'PCS', 3, 4),
       (9, '2022-05-15 00:00:00', FALSE, 9, '2022-05-15 00:00:00', 'Sports', TRUE, 10, 'Bike', 1, 'ACTIVE', 50, 10, 'PCS', 3, 4),
       (9, '2022-05-15 00:00:00', FALSE, 9, '2022-05-15 00:00:00', 'Sports', TRUE, 10, 'Racket', 1, 'ACTIVE', 50, 10, 'PCS', 3, 4),
       (9, '2022-05-15 00:00:00', FALSE, 9, '2022-05-15 00:00:00', 'Sports', TRUE, 10, 'Kimono', 1, 'ACTIVE', 50, 10, 'PCS', 3, 4),
       (9, '2022-05-15 00:00:00', FALSE, 9, '2022-05-15 00:00:00', 'Sports', TRUE, 10, 'Paddle', 1, 'ACTIVE', 50, 10, 'PCS', 3, 4);


INSERT INTO invoice_product (created_by, created_time, is_deleted, updated_by, updated_time, name, price, profit, qty, tax, invoice_id, product_id)
VALUES (5, '2022-05-16 00:00:00', FALSE, 5, '2022-05-16 00:00:00', 'TV', 1000, 10, 20, 10, 1, 1),
       (5, '2022-05-16 00:00:00', FALSE, 5, '2022-05-16 00:00:00', 'Dishwasher', 1500, 10, 20, 10, 1, 2),
       (5, '2022-05-20 00:00:00', FALSE, 5, '2022-05-20 00:00:00', 'Safe', 300, 10, 10, 10, 2, 3),
       (5, '2022-05-20 00:00:00', FALSE, 5, '2022-05-20 00:00:00', 'Reading Lamp', 20, 10, 20, 10, 2, 4),
       (5, '2022-05-20 00:00:00', FALSE, 5, '2022-05-20 00:00:00', 'Oven', 800, 10, 20, 10, 2, 5),
       (5, '2022-06-10 00:00:00', FALSE, 5, '2022-06-10 00:00:00', 'MacBook', 2000, 20, 5, 10, 3, 8),
       (5, '2022-06-10 00:00:00', FALSE, 5, '2022-06-10 00:00:00', 'Printer', 200, 20, 10, 10, 3, 9),
       (5, '2022-06-10 00:00:00', FALSE, 5, '2022-06-10 00:00:00', 'Scanner', 300, 20, 10, 10, 3, 10),
       (5, '2022-06-10 00:00:00', FALSE, 5, '2022-06-10 00:00:00', 'Safe', 300, 20, 10, 10, 4, 3),
       (5, '2022-06-10 00:00:00', FALSE, 5, '2022-06-10 00:00:00', 'Reading Lamp', 20, 20, 20, 10, 4, 4),
       (5, '2022-06-10 00:00:00', FALSE, 5, '2022-06-10 00:00:00', 'Oven', 800, 20, 20, 10, 4, 5),
       (5, '2022-06-11 00:00:00', FALSE, 5, '2022-05-11 00:00:00', 'Dishwasher', 1500, 20, 20, 10, 5, 2),
       (7, '2022-05-12 00:00:00', FALSE, 7, '2022-05-12 00:00:00', 'Dishwasher', 1500, 10, 10, 10, 6, 2),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Safe', 300, 10, 10, 10, 7, 3),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Reading Lamp', 20, 10, 20, 10, 7, 4),
       (7, '2022-05-15 00:00:00', FALSE, 7, '2022-05-15 00:00:00', 'Oven', 800, 10, 20, 10, 7, 5),
       (7, '2022-06-11 00:00:00', FALSE, 7, '2022-05-11 00:00:00', 'Dishwasher', 1500, 20, 5, 10, 8, 2),
       (7, '2022-06-12 00:00:00', FALSE, 7, '2022-06-12 00:00:00', 'MacBook', 2000, 20, 5, 10, 9, 8),
       (7, '2022-06-12 00:00:00', FALSE, 7, '2022-06-12 00:00:00', 'Printer', 200, 20, 10, 10, 9, 9),
       (7, '2022-06-12 00:00:00', FALSE, 7, '2022-06-12 00:00:00', 'Scanner', 300, 20, 10, 10, 9, 10),
       (7, '2022-06-13 00:00:00', FALSE, 7, '2022-06-12 00:00:00', 'RAM', 80, 20, 100, 10, 10, 15),
       (7, '2022-06-13 00:00:00', FALSE, 7, '2022-06-12 00:00:00', 'Keyboard', 80, 20, 20, 10, 10, 14),
       (9, '2022-05-12 00:00:00', FALSE, 9, '2022-05-12 00:00:00', 'Dishwasher', 1500, 10, 10, 10, 11, 2),
       (9, '2022-05-13 00:00:00', FALSE, 9, '2022-05-13 00:00:00', 'Safe', 300, 10, 10, 10, 12, 3),
       (9, '2022-05-13 00:00:00', FALSE, 9, '2022-05-13 00:00:00', 'Reading Lamp', 20, 10, 20, 10, 12, 4),
       (9, '2022-05-13 00:00:00', FALSE, 9, '2022-05-13 00:00:00', 'Oven', 800, 10, 20, 10, 12, 5),
       (9, '2022-06-11 00:00:00', FALSE, 9, '2022-05-11 00:00:00', 'Dishwasher', 1500, 20, 5, 10, 13, 2),
       (9, '2022-06-12 00:00:00', FALSE, 9, '2022-06-12 00:00:00', 'MacBook', 2000, 20, 5, 10, 14, 8),
       (9, '2022-06-12 00:00:00', FALSE, 9, '2022-06-12 00:00:00', 'Printer', 200, 20, 10, 10, 14, 9),
       (9, '2022-06-12 00:00:00', FALSE, 9, '2022-06-12 00:00:00', 'Scanner', 300, 20, 10, 10, 14, 10),
       (9, '2022-06-13 00:00:00', FALSE, 9, '2022-06-12 00:00:00', 'RAM', 80, 20, 100, 10, 15, 15),
       (9, '2022-06-13 00:00:00', FALSE, 9, '2022-06-12 00:00:00', 'Keyboard', 80, 20, 20, 10, 15, 14);


INSERT INTO stock_details (i_date, quantity, price, remaining_quantity, product_id)
VALUES ('2022-01-15 00:00:00', 50, 1000, 50, 1),
       ('2022-01-15 00:00:00', 150, 1500, 150, 2),
       ('2022-01-15 00:00:00', 150, 100, 150, 3),
       ('2022-01-15 00:00:00', 250, 300, 250, 4),
       ('2022-01-15 00:00:00', 50, 20, 50, 5),
       ('2022-01-15 00:00:00', 50, 800, 50, 6),
       ('2022-01-15 00:00:00', 50, 20, 50, 7),
       ('2022-05-15 00:00:00', 50, 2000, 50, 8),
       ('2022-05-15 00:00:00', 50, 200, 50, 9),
       ('2022-05-15 00:00:00', 50, 300, 50, 10),
       ('2022-05-15 00:00:00', 50, 20, 50, 11),
       ('2022-05-15 00:00:00', 50, 200, 50, 12),
       ('2022-05-15 00:00:00', 50, 20, 50, 13),
       ('2022-05-15 00:00:00', 50, 80, 50, 14),
       ('2022-05-15 00:00:00', 250, 80, 250, 15),
       ('2022-05-15 00:00:00', 250, 80, 250, 16),
       ('2022-05-15 00:00:00', 150, 100, 150, 17),
       ('2022-05-15 00:00:00', 1000, 20, 1000, 18),
       ('2022-05-15 00:00:00', 1500, 20, 1500, 19),
       ('2022-05-15 00:00:00', 1500, 10, 1500, 20),
       ('2022-05-15 00:00:00', 50, 800, 50, 21),
       ('2022-05-15 00:00:00', 50, 100, 50, 22),
       ('2022-05-15 00:00:00', 50, 200, 50, 23),
       ('2022-05-15 00:00:00', 50, 80, 50, 24);


INSERT INTO payment (created_by, created_time, is_deleted, updated_by, updated_time, amount, institution_id, is_paid, month, year, company_id)
VALUES (4, '2022-01-16 00:00:00', FALSE, 4, '2022-01-16 00:00:00', 1000, '2', TRUE, 'JAN', '01/15/2022', 2),
       (4, '2022-02-16 00:00:00', FALSE, 4, '2022-02-16 00:00:00', 1000, '2', TRUE, 'FEB', '02/15/2022', 2),
       (4, '2022-03-16 00:00:00', FALSE, 4, '2022-03-16 00:00:00', 1000, '2', TRUE, 'MAR', '03/15/2022', 2),
       (4, '2022-04-16 00:00:00', FALSE, 4, '2022-04-16 00:00:00', 1000, '2', TRUE, 'APR', '04/15/2022', 2),
       (4, '2022-05-16 00:00:00', FALSE, 4, '2022-05-16 00:00:00', 1000, '2', TRUE, 'MAY', '05/16/2022', 2),
       (4, '2022-06-16 00:00:00', FALSE, 4, '2022-06-16 00:00:00', 1000, '2', TRUE, 'JUN', '06/16/2022', 2),
       (8, '2022-01-16 00:00:00', FALSE, 8, '2022-01-16 00:00:00', 1000, '3', TRUE, 'JAN', '01/16/2022', 3),
       (8, '2022-02-16 00:00:00', FALSE, 8, '2022-02-16 00:00:00', 1000, '3', TRUE, 'FEB', '02/16/2022', 3),
       (8, '2022-03-16 00:00:00', FALSE, 8, '2022-03-16 00:00:00', 1000, '3', TRUE, 'MAR', '03/16/2022', 3),
       (8, '2022-04-16 00:00:00', FALSE, 8, '2022-04-16 00:00:00', 1000, '3', TRUE, 'APR', '04/16/2022', 3),
       (8, '2022-05-16 00:00:00', FALSE, 8, '2022-05-16 00:00:00', 1000, '3', TRUE, 'MAY', '05/16/2022', 3),
       (8, '2022-06-16 00:00:00', FALSE, 8, '2022-06-16 00:00:00', 1000, '3', TRUE, 'JUN', '06/16/2022', 3),
       (9, '2022-01-16 00:00:00', FALSE, 9, '2022-01-16 00:00:00', 1000, '4', TRUE, 'JAN', '01/16/2022', 4),
       (9, '2022-02-16 00:00:00', FALSE, 9, '2022-02-16 00:00:00', 1000, '4', TRUE, 'FEB', '02/16/2022', 4),
       (9, '2022-03-16 00:00:00', FALSE, 9, '2022-03-16 00:00:00', 1000, '4', TRUE, 'MAR', '03/16/2022', 4),
       (9, '2022-04-16 00:00:00', FALSE, 9, '2022-04-16 00:00:00', 1000, '4', TRUE, 'APR', '04/16/2022', 4),
       (9, '2022-05-16 00:00:00', FALSE, 9, '2022-05-16 00:00:00', 1000, '4', TRUE, 'MAY', '05/16/2022', 4),
       (9, '2022-06-16 00:00:00', FALSE, 9, '2022-06-16 00:00:00', 1000, '4', TRUE, 'JUN', '06/16/2022', 4);


INSERT INTO role (enabled, name)
VALUES (TRUE, 'Root'),
       (TRUE, 'Admin'),
       (TRUE, 'Manager'),
       (TRUE, 'Employee');


INSERT INTO users (created_by, created_time, is_deleted, updated_by, updated_time, email, enabled, first_name, last_name, password, phone, user_status, company_id, role_id)
VALUES (1, '2021-05-01 00:00:00', FALSE, 1, '2021-05-01 00:00:00', 'root@cydeo.com', TRUE, 'Root', 'RootSurname', 'Abc1', '0000000000', 'ACTIVE', 1, 1),
       (1, '2021-05-02 00:00:00', FALSE, 1, '2021-05-02 00:00:00', 'admin1@company2.com', TRUE, 'Admin1', 'AdminLName1', 'Abc1', '0000000001', 'ACTIVE', 2, 2),
       (1, '2021-05-03 00:00:00', FALSE, 1, '2021-05-03 00:00:00', 'admin2@company3.com', TRUE, 'Admin2', 'AdminLName2', 'Abc1', '0000000002', 'ACTIVE', 3, 2),
       (1, '2021-05-03 00:00:00', FALSE, 1, '2021-05-03 00:00:00', 'admin3@company4.com', TRUE, 'Admin3', 'AdminLName3', 'Abc1', '0000000003', 'ACTIVE', 4, 2),
       (2, '2021-05-03 00:00:00', FALSE, 2, '2021-05-03 00:00:00', 'manager1@company2.com', TRUE, 'Manager1', 'ManagerLName1', 'Abc1', '0000000004', 'ACTIVE', 2, 3),
       (2, '2021-05-03 00:00:00', FALSE, 2, '2021-05-03 00:00:00', 'manager2@company2.com', TRUE, 'Manager2', 'ManagerLName2', 'Abc1', '0000000005', 'ACTIVE', 2, 3),
       (3, '2021-05-03 00:00:00', FALSE, 3, '2021-05-03 00:00:00', 'manager1@comapny3.com', TRUE, 'Manager3', 'ManagerLName3', 'Abc1', '0000000006', 'ACTIVE', 3, 3),
       (3, '2021-05-03 00:00:00', FALSE, 3, '2021-05-03 00:00:00', 'manager2@company3.com', TRUE, 'Manager4', 'ManagerLName4', 'Abc1', '0000000007', 'ACTIVE', 3, 3),
       (4, '2021-05-13 00:00:00', FALSE, 4, '2021-05-13 00:00:00', 'manager1@company4.com', TRUE, 'Manager5', 'ManagerLName5', 'Abc1', '0000000008', 'ACTIVE', 4, 3),
       (4, '2021-05-13 00:00:00', FALSE, 4, '2021-05-13 00:00:00', 'manager2@company4.com', TRUE, 'Manager6', 'ManagerLName6', 'Abc1', '0000000009', 'ACTIVE', 4, 3),
       (2, '2021-05-04 00:00:00', FALSE, 2, '2021-05-04 00:00:00', 'employee1@company2.com', TRUE, 'Employee1', 'EmployeeLName1', 'Abc1', '0000000010', 'ACTIVE', 2, 4),
       (2, '2021-05-04 00:00:00', FALSE, 2, '2021-05-04 00:00:00', 'employee2@company2.com', TRUE, 'Employee2', 'EmployeeLName2', 'Abc1', '0000000011', 'ACTIVE', 2, 4),
       (2, '2021-04-04 00:00:00', FALSE, 2, '2021-05-04 00:00:00', 'employee3@company2.com', TRUE, 'Employee3', 'EmployeeLName3', 'Abc1', '0000000012', 'ACTIVE', 2, 4),
       (2, '2021-04-04 00:00:00', FALSE, 2, '2021-05-04 00:00:00', 'employee4@company2.com', TRUE, 'Employee4', 'EmployeeLName4', 'Abc1', '0000000013', 'ACTIVE', 2, 4),
       (3, '2021-05-05 00:00:00', FALSE, 3, '2021-05-04 00:00:00', 'employee1@company3.com', TRUE, 'Employee5', 'EmployeeLName5', 'Abc1', '0000000014', 'ACTIVE', 3, 4),
       (3, '2021-05-05 00:00:00', FALSE, 3, '2021-05-04 00:00:00', 'employee2@company3.com', TRUE, 'Employee6', 'EmployeeLName6', 'Abc1', '0000000015', 'ACTIVE', 3, 4),
       (3, '2021-05-05 00:00:00', FALSE, 3, '2021-05-04 00:00:00', 'employee3@company3.com', TRUE, 'Employee7', 'EmployeeLName7', 'Abc1', '0000000016', 'ACTIVE', 3, 4),
       (3, '2021-05-05 00:00:00', FALSE, 3, '2021-05-04 00:00:00', 'employee4@company3.com', TRUE, 'Employee8', 'EmployeeLName8', 'Abc1', '0000000017', 'ACTIVE', 3, 4),
       (4, '2021-05-13 00:00:00', FALSE, 4, '2021-05-13 00:00:00', 'employee1@company4.com', TRUE, 'Employee9', 'EmployeeLName9', 'Abc1', '0000000018', 'ACTIVE', 4, 4),
       (4, '2021-05-13 00:00:00', FALSE, 4, '2021-05-13 00:00:00', 'employee2@company4.com', TRUE, 'Employee10', 'EmployeeLName10', 'Abc1', '0000000019', 'ACTIVE', 4, 4),
       (4, '2021-05-13 00:00:00', FALSE, 4, '2021-05-13 00:00:00', 'employee3@company4.com', TRUE, 'Employee11', 'EmployeeLName11', 'Abc1', '0000000020', 'ACTIVE', 4, 4),
       (4, '2021-05-13 00:00:00', FALSE, 4, '2021-05-13 00:00:00', 'employee4@company4.com', TRUE, 'Employee12', 'EmployeeLName12', 'Abc1', '0000000021', 'ACTIVE', 4, 4);
