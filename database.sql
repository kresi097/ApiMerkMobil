CREATE DATABASE db_merk_mobil;
CREATE TABLE merk_mobil (
   id SERIAL PRIMARY KEY,
   nama VARCHAR(255) NOT NULL,
   tahun_berdiri INT,
   negara_asal VARCHAR(255)
);

