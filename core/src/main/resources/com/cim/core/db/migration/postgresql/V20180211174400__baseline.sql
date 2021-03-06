CREATE TABLE graveowner (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	old_id BIGINT,
	cnp VARCHAR(32),
	nume VARCHAR(128) NOT NULL,
	prenume VARCHAR(128) NOT NULL,
	adresa VARCHAR(256) NOT NULL,
	cod_loc INT,
	localitate VARCHAR(128),
	judet VARCHAR(64),
	tara VARCHAR(64),
	str VARCHAR(128),
	nr VARCHAR(32),
	bl VARCHAR(32),
	sc VARCHAR(32),
	et VARCHAR(32),
	ap VARCHAR(32),
	cod_post VARCHAR(64),
	tel VARCHAR(64),
	fax VARCHAR(64),
	mail VARCHAR(128),
	nr_contr VARCHAR(64),
	data_contr TIMESTAMP,
	contract VARCHAR(64),
	act VARCHAR(32),
	seria VARCHAR(32),
	nr_act VARCHAR(64),
	emitator VARCHAR(128),
	data_act TIMESTAMP,
	dubiu VARCHAR(64),
	data_dubiu TIMESTAMP,
	avans VARCHAR(64),
	an_debut INT,
	an_final INT,
	modif VARCHAR(64),
	avizat VARCHAR(64),
	data_aviz TIMESTAMP
);

CREATE TABLE graveyard (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	nume VARCHAR(128) NOT NULL,
	localitate VARCHAR(128) NOT NULL,
	judet VARCHAR(64) NOT NULL,
	tara VARCHAR(64) NOT NULL,
	str VARCHAR(128) NOT NULL,
	nr VARCHAR(32) NOT NULL
);

CREATE TABLE exempt (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	cod INT NOT NULL,
	nume VARCHAR(128) NOT NULL
);

CREATE TABLE grave (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	old_id BIGINT,
	graveyard_id BIGINT NOT NULL,
	contract_id BIGINT NULL,
	cod_zona INT,
	sector VARCHAR(32),
	rind VARCHAR(32),
	pozitie VARCHAR(32),
	nr_locuri INT
);

CREATE TABLE contract (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	old_id BIGINT,
	graveowner_id BIGINT NOT NULL,
	grave_id BIGINT NOT NULL,
	exempt_id BIGINT NULL,
	ani INT,
	data_incep TIMESTAMP,
	data_exp TIMESTAMP,
	nr_ch VARCHAR(32),
	data_ch TIMESTAMP,
	suma DECIMAL,
	contract VARCHAR(32),
	nr_contr VARCHAR(32),
	data_contr TIMESTAMP,
	ind INT,
	stare VARCHAR(32),
	data_stare TIMESTAMP,
	transe INT,
	cod_cs INT,
	matricola INT,
	modif VARCHAR(32)
);

ALTER TABLE grave ADD FOREIGN KEY (graveyard_id) REFERENCES graveyard(id);
ALTER TABLE grave ADD FOREIGN KEY (contract_id) REFERENCES contract(id);
CREATE INDEX graveyard_id_idx ON grave(graveyard_id);
CREATE INDEX contract_id_idx ON grave(contract_id);

ALTER TABLE contract ADD FOREIGN KEY (graveowner_id) REFERENCES graveowner(id);
ALTER TABLE contract ADD FOREIGN KEY (grave_id) REFERENCES grave(id);
ALTER TABLE contract ADD FOREIGN KEY (exempt_id) REFERENCES exempt(id);
CREATE INDEX graveowner_id_idx ON contract(graveowner_id);
CREATE INDEX grave_id_idx ON contract(grave_id);
CREATE INDEX exempt_id_idx ON contract(exempt_id);
