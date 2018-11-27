CREATE TABLE states(
cd_id bigserial NOT NULL,
country_code bigint,
state_name character varying (45),
CONSTRAINT states_pkey PRIMARY KEY (cd_id),
  CONSTRAINT states_countries_cd_id_fkey FOREIGN KEY (country_code)
      REFERENCES countries (cd_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

WITH (
  OIDS=FALSE
);
ALTER TABLE states
  OWNER TO postgres;
