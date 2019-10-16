DROP if exists TABLE user_auth;
DROP if exists TABLE feibonaqi_auth;
DROP if exists TABLE feinonaqi_user;

CREATE TABLE feibonaqi_auth
(
  authid integer NOT NULL,
  auth_name character varying(200),
  authority_name character varying(20),
  CONSTRAINT user_auth_pkey PRIMARY KEY (authid),
  CONSTRAINT user_auth_role_name_key UNIQUE (role_name)
);



CREATE TABLE feinonaqi_user
(
  openid character(36) NOT NULL,
  email  character varying(200),
  login_username  character varying(200),
  showing_username  character varying(200),
  login_password  character varying(200),
  create_time timestamp with time zone,
  CONSTRAINT feinonaqi_user_pkey PRIMARY KEY (openid),
  CONSTRAINT feinonaqi_user_email_key UNIQUE (email),
  CONSTRAINT feinonaqi_user_login_username_key UNIQUE (login_username)
);

CREATE INDEX feinonaqi_user_email_idx
  ON feinonaqi_user
  USING btree
  (email COLLATE pg_catalog."default");

CREATE INDEX feinonaqi_user_login_username_idx
  ON feinonaqi_user
  USING btree
  (login_username COLLATE pg_catalog."default");


CREATE TABLE user_auth
(
  openid character(36) NOT NULL,
  authid integer NOT NULL,
  create_time timestamp with time zone,
  CONSTRAINT user_auth_pkey1 PRIMARY KEY (openid, authid),
  CONSTRAINT user_auth_authid_fkey FOREIGN KEY (authid)
      REFERENCES feibonaqi_auth (authid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_auth_openid_fkey FOREIGN KEY (openid)
      REFERENCES feinonaqi_user (openid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);