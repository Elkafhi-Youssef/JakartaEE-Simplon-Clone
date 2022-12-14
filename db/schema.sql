create table if not exists trainers (
      trainer_id serial PRIMARY KEY,
      username VARCHAR ( 50 ) UNIQUE NOT NULL,
      psswd VARCHAR ( 50 ) NOT NULL,
      email VARCHAR ( 255 ) UNIQUE NOT NULL,
      trainer_image VARCHAR ( 255 ) UNIQUE NULL,
      delete_at date
);
create table if not exists promos (
    promo_id serial PRIMARY KEY,
    promo_name VARCHAR ( 50 ) UNIQUE NOT NULL,
    created_on date NOT NULL,
    trainer_id int references trainers (trainer_id)
);
create table if not exists students (
      student_id serial PRIMARY KEY,
      username VARCHAR ( 50 ) UNIQUE NOT NULL,
      psswd VARCHAR ( 50 ) NOT NULL,
      email VARCHAR ( 255 ) UNIQUE NOT NULL,
      student_image VARCHAR ( 255 ) UNIQUE  NULL,
      created_on TIMESTAMP NOT NULL,
      delete_at TIMESTAMP,
      promo_id int references promos (promo_id) null
);
create  table if not exists briefs(
    brief_id serial PRIMARY KEY,
    brief_title varchar(255) not null ,
    description text not null ,
    image varchar(255) not null,
    date_started date not null ,
    date_end date not null ,
    technologies TEXT [] not null ,
    repository TEXT [] not null ,
    trainer_id int references trainers (trainer_id) not null,
    promo_id int references promos (promo_id) not null
);

create table if not exists delivers(
                                       deliver_id serial PRIMARY KEY,
                                       message VARCHAR ( 255) not null ,
                                       repo_link varchar(255) not null,
                                       student_id int  references students (student_id),
                                       brief_id int references briefs (brief_id),
                                       created_on TIMESTAMP NOT NULL
);

create table if not exists admins(
     admin_id serial PRIMARY KEY,
     username VARCHAR ( 50 ) UNIQUE NOT NULL,
     psswd VARCHAR ( 50 ) NOT NULL,
     email VARCHAR ( 255 ) UNIQUE NOT NULL,
     admin_image VARCHAR ( 255 ) UNIQUE NULL,
     created_on TIMESTAMP NOT NULL,
     last_login TIMESTAMP
)
