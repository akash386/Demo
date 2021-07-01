DROP TABLE IF EXISTS billionaires;

CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL
);

INSERT INTO user (id, first_name, last_name, email, password) VALUES
  (1, 'Aliko', 'Dangote','abc@abc.com','12345'),
  (2, 'Bill', 'Gates','abc@abc.com','12345'),
  (3, 'Folrunsho', 'Alakija','abc@abc.com','12345');
  
commit;