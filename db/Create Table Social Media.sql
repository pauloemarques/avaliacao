CREATE TABLE social_media(
cd_id bigserial NOT NULL,
user_id character varying(45) NOT NULL,
social_profile_id character varying(45),
social_provider character varying(45),
authenticate boolean NOT NULL DEFAULT false,
CONSTRAINT social_media_pkey PRIMARY KEY (cd_id),
  CONSTRAINT social_media_user_fkey FOREIGN KEY (user_id)
      REFERENCES user (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
)

WITH (
  OIDS=FALSE
);
ALTER TABLE social_media
  OWNER TO postgres;
