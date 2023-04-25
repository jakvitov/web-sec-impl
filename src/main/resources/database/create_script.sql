--Script that sets up the database for the app
create table web_sec_user(
                             web_sec_user_id NUMERIC PRIMARY KEY,
                             web_sec_user_name VARCHAR UNIQUE NOT NULL,
                             web_sec_user_password VARCHAR NOT NULL
);

create table web_sec_user_role(
                                  web_sec_user_role_id NUMERIC PRIMARY KEY,
                                  user_role varchar NOT NULL,
                                  web_sec_user_id_reference numeric NOT NULL
);

ALTER TABLE web_sec_user_role ADD CONSTRAINT fk_web_sec_user FOREIGN KEY(web_sec_user_id_reference) REFERENCES web_sec_user(web_sec_user_id);

create sequence web_sec_user_seq increment by 50;
create sequence web_sec_user_role_seq increment by 50;