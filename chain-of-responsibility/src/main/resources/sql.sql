DROP TABLE stock;
DROP TABLE fund;
DROP TABLE exchange;

CREATE TABLE stock
(
  item      CHAR(10) NOT NULL,
  current   INT      NOT NULL,
  upndwn    FLOAT    NOT NULL,
  upndwnper FLOAT    NOT NULL
);

INSERT INTO stock VALUES ('Samsung', 10000, 300, -9);
INSERT INTO stock VALUES ('Daewoo', 20000, 400, -12);
INSERT INTO stock VALUES ('Sun', 15000, 500, 10);
INSERT INTO stock VALUES ('MS', 23000, 100, -10);
INSERT INTO stock VALUES ('Oracle', 18300, 150, 21);
INSERT INTO stock VALUES ('IBM', 21000, 100, 12);

CREATE TABLE fund
(
  item         CHAR(10) NOT NULL,
  current      INT      NOT NULL,
  commision    FLOAT    NOT NULL,
  daycommision FLOAT    NOT NULL
);

INSERT INTO fund VALUES ('Samsung', 20000, 10, 3);
INSERT INTO fund VALUES ('Daewoo', 15000, 20, 4);
INSERT INTO fund VALUES ('Sun', 21000, 10, 5);
INSERT INTO fund VALUES ('MS', 18000, 5, 10);
INSERT INTO fund VALUES ('Oracle', 31000, 8, 11);
INSERT INTO fund VALUES ('IBM', 24000, 14, 12);


CREATE TABLE exchange
(
  item CHAR(10) NOT NULL,
  buy  FLOAT    NOT NULL,
  sell FLOAT    NOT NULL,
  rate FLOAT    NOT NULL
);

INSERT INTO exchange VALUES ('Dollar', 1300, 1280, 1270);
INSERT INTO exchange VALUES ('Marc', 700, 660, 680);
INSERT INTO exchange VALUES ('Yen', 1010, 1050, 1090);
INSERT INTO exchange VALUES ('Pound', 2300, 2240, 2269);

