USE Online_shopping;
INSERT INTO
  Customer (
    customer_id,
    username,
    first_name,
    last_name,
    age,
    email,
    customer_password,
    phone_number
  )
VALUES
  (
    30,
    'hundera',
    'Hundera',
    'Awoke',
    18,
    'hunderaweke@gmail.com',
    HASHBYTES('SHA2_256','1234'),
    '0955969362'
  );