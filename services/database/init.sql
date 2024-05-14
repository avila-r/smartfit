create table units
(
    id                 bigint      not null
        constraint locations_pkey
            primary key,
    title              varchar(50) not null,
    content            text        not null,
    is_opened          boolean     not null,
    mask_status        varchar(15) not null,
    towel_status       varchar(15) not null,
    fountain_status    varchar(15) not null,
    locker_room_status varchar(15) not null
);

create table schedules
(
    id       serial
        primary key,
    unit_id  bigint
        constraint schedules_location_id_fkey
            references units,
    weekdays text not null,
    hour     text not null
);

create table addresses
(
    id         bigint       not null
        primary key,
    title      varchar(50)  not null,
    street     varchar(100) not null,
    region     varchar(50)  not null,
    city_name  varchar(50)  not null,
    state_name varchar(50)  not null,
    uf         varchar(4)   not null
);
