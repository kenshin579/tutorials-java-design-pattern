DROP TABLE subdepart;
DROP TABLE depart;

CREATE TABLE depart
(
  title CHAR(10) PRIMARY KEY
);

CREATE TABLE subdepart
(
  title    CHAR(10) REFERENCES depart (title),
  subtitle CHAR(10) NOT NULL,
  invest   INT      NOT NULL,
  loss     INT      NOT NULL
);

INSERT INTO depart VALUES ('sales');
INSERT INTO depart VALUES ('planning');

INSERT INTO subdepart VALUES ('sales', 'no enemy', 1000, 200);
INSERT INTO subdepart VALUES ('sales', 'big deal', 500, 600);
INSERT INTO subdepart VALUES ('planning', 'no enemy', 800, 800);
INSERT INTO subdepart VALUES ('planning', 'big deal', 500, 100);
INSERT INTO subdepart VALUES ('marketing', 'no enemy', 300, 150);
INSERT INTO subdepart VALUES ('marketing', 'big deal', 2000, 500);
