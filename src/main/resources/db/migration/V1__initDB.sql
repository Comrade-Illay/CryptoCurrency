CREATE TABLE IF NOT EXISTS crypto_currency (
 id BIGINT PRIMARY KEY,
 symbol VARCHAR(200),
 price NUMERIC(8,2)
);

CREATE TABLE IF NOT EXISTS users (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(200),
  code VARCHAR(200),
  price NUMERIC(8,2)
);

INSERT INTO crypto_currency (id, symbol, price)
VALUES (90, 'BTC', 1.00);
INSERT INTO crypto_currency (id, symbol, price)
VALUES (80, 'ETH', 1.00);
INSERT INTO crypto_currency (id, symbol, price)
VALUES (48543, 'SOL', 1.00);