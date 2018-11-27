CREATE TABLE user
(
user_id character varying(45) NOT NULL,
phone_number character varying(20),
email character varying(255),
first_name character varying(100),
last_name character varying(100),
date_of_birth character varying(45),
national_id character varying(15),
phone_validated boolean NOT NULL DEFAULT true,
email_confirmed boolean NOT NULL DEFAULT true,
create_time timestamp with time zone,
password_enc character varying(100),
password_salt character varying(50),
CONSTRAINT user_pkey PRIMARY KEY (user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user
  OWNER TO postgres;
