

-- DROP TABLE IF EXISTS tasks;


CREATE TABLE tasks
(
  id integer NOT NULL,
  creation_date timestamp NOT NULL,
  author character varying(255) NOT NULL,
  content character varying(255) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);


