create table gid.id_segment
(
    id          bigint       not null
        primary key,
    tag         varchar(20)  not null,
    start_id    bigint       not null,
    step        bigint       not null,
    comment     varchar(100) null,
    create_time datetime     not null,
    update_time datetime     not null,
    constraint tag_idx
        unique (tag)
);

