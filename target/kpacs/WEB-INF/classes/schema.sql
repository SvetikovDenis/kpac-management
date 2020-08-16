CREATE TABLE kpac (
	id int auto_increment,
	title varchar(250) not null,
	description varchar (2000) not null ,
	created date not null ,
	primary key (id)
);

CREATE TABLE kpac_set (
	id int auto_increment,
	title VARCHAR(250) not null,
	primary key (id)
);

CREATE TABLE kpac_set_kpac (
	id int auto_increment,
	kpac_set_id int not null,
	kpac_id int not null,
	primary key (id),
	FOREIGN KEY (kpac_set_id) REFERENCES kpac_set (id) ON UPDATE RESTRICT ON DELETE CASCADE,
	FOREIGN KEY (kpac_id) REFERENCES kpac (id) ON UPDATE RESTRICT ON DELETE CASCADE
);


