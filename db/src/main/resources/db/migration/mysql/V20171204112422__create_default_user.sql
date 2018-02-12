CREATE TABLE app_user (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	user_name VARCHAR(128) NOT NULL,
	password VARCHAR(128) NOT NULL,
	first_name VARCHAR(128) NOT NULL,
	last_name VARCHAR(128) NOT NULL,
	email VARCHAR(128)
);

ALTER TABLE app_user
ADD CONSTRAINT unique_user UNIQUE (user_name);

INSERT INTO app_user (user_name, password, first_name, last_name) 
VALUES ('admin', 'admin', 'Administrator', 'System');
