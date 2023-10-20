CREATE TABLE
  Order_product (
    order_product_id INT IDENTITY(1, 1) PRIMARY KEY,
    payment_id INT FOREIGN KEY(payment_id) REFERENCES Payment(payment_id) ON DELETE CASCADE NOT NULL,
    product_id INT FOREIGN KEY(product_id) REFERENCES Product(product_id) ON DELETE CASCADE NOT NULL,
    quantity INT NOT NULL,
    product_price DECIMAL NOT NULL,
  );


USE Online_Shopping;


DROP TABLE
  Order_product;


CREATE PROCEDURE InsertOrderProduct 
@ payment_id INT,
@ product_id INT,
@ quantity INT,
@ product_price INT AS
BEGIN
INSERT INTO
  Order_product (payment_id, product_id, quantity, product_price)
VALUES
  (@ payment_id, @ product_id, @ quantity, @ product_price);
END