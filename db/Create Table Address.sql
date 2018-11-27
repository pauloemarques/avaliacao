CREATE TABLE user
(
cd_id character varying(45) NOT NULL,

CONSTRAINT add_pkey PRIMARY KEY (cd_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user
  OWNER TO postgres;
