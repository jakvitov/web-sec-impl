--Script that sets up the database for the app
create table web_sec_user(
                             web_sec_user_id NUMERIC PRIMARY KEY,
                             web_sec_user_name VARCHAR UNIQUE NOT NULL,
                             web_sec_user_password VARCHAR NOT NULL,
                             web_sec_user_role VARCHAR NOT NULL
);

create sequence web_sec_user_seq increment by 50;