CREATE TABLE MONITOR ( id      int AUTO_INCREMENT PRIMARY KEY,
                       nome    VARCHAR(100)       NOT NULL,
                       tipo    VARCHAR(100)       NOT NULL,
                       tamanho DOUBLE             NOT NULL,
                       preco   DOUBLE             NOT NULL);



INSERT INTO MONITOR (nome, tipo, tamanho, preco)
VALUES
    ('Samsung UltraWide', 'LED', 27.0, 1299.99),
    ('Dell UltraSharp', 'IPS', 24.0, 899.50),
    ('LG Gaming Monitor', 'OLED', 32.0, 1999.00),
    ('Acer Predator', 'TN', 27.0, 1499.75),
    ('HP Pavilion', 'VA', 21.5, 799.00);