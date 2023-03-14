-- patient

create table Patient(
    id serial primary key,
    firstName varchar(100) not null,
    lastName varchar(100) not null,
    identityNumber int(13) not null,
    email varchar(255) not null,

)