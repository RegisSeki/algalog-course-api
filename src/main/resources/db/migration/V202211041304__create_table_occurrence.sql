CREATE TABLE occurrence (
	id 	BIGINT NOT NULL AUTO_INCREMENT,
	delivery_id BIGINT NOT NULL,
	description TEXT NOT NULL,
	register_date DATETIME NOT NULL,
	
	primary key (id)
);

ALTER TABLE occurrence ADD CONSTRAINT fk_occurrence_delivery
FOREIGN KEY (delivery_id) REFERENCES delivery(id);