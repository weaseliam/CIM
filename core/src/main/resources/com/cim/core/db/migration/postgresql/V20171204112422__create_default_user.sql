CREATE TABLE app_user (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	user_name VARCHAR(128) NOT NULL UNIQUE,
	password VARCHAR(128) NOT NULL,
	first_name VARCHAR(128) NOT NULL,
	last_name VARCHAR(128) NOT NULL,
	email VARCHAR(128)
);

INSERT INTO app_user (user_name, password, first_name, last_name)
VALUES ('admin', 'admin', 'Administrator', 'System');
