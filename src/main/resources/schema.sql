CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL
);

-- Insertion de données de jeu d'essai dans la table "users"
INSERT INTO users (name, age) VALUES ('riri', 14);
INSERT INTO users (name, age) VALUES ('fifi', 25);
INSERT INTO users (name, age) VALUES ('loulou', 72);
