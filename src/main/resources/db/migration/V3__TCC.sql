CREATE TABLE role (  id INT NOT NULL,name VARCHAR(45) NOT NULL,PRIMARY KEY (id));
CREATE TABLE users (  id INT NOT NULL,name VARCHAR(45) NOT NULL,password VARCHAR(200) NOT NULL,email VARCHAR(45) NOT NULL,PRIMARY KEY (id));