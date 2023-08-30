create sequence notification_seq start with 1 increment by 50;
create sequence personal_account_seq start with 1 increment by 50;
create sequence provider_seq start with 1 increment by 50;
create sequence usrs_seq start with 1 increment by 50;

create table notification
(
    id           bigint not null,
    recipient_id bigint unique,
    sender_id    bigint unique,
    description  varchar(255),
    primary key (id)
);
create table personal_account
(
    id      bigint not null,
    account varchar(255),
    primary key (id)
);
create table provider
(
    count               float(53),
    id                  bigint not null,
    personal_account_id bigint unique,
    name                varchar(255),
    primary key (id)
);
create table usrs
(
    money               float(53),
    id                  bigint not null,
    notification_id     bigint unique,
    personal_account_id bigint unique,
    email               varchar(255),
    firstname           varchar(255),
    lastname            varchar(255),
    password            varchar(255),
    primary key (id)
);
alter table if exists notification
    add constraint FKmctpjmsehhoo66yyjcy2mkkwb foreign key (recipient_id) references usrs;
alter table if exists notification
    add constraint FKeo0sk1moj22iw6isk5xn09tja foreign key (sender_id) references provider;
alter table if exists provider
    add constraint FK31wpxo6x8tvw6hxck2befyk1v foreign key (personal_account_id) references personal_account;
alter table if exists usrs
    add constraint FK4vym3l7222wfcyd7mn9blwilv foreign key (notification_id) references notification;
alter table if exists usrs
    add constraint FKs6u3npmhfyx5ywfr5s1abqxjf foreign key (personal_account_id) references personal_account;


insert into personal_account (id, account)
values ('1', '52456254');
insert into provider (id, count, personal_account_id, name)
values ('1', '5000', '1', 'mosenergybit');
insert into usrs(money, id, personal_account_id, email, firstname, lastname, password, notification_id)
values ('1000000', '1', '1', 'usr@gmail.com', 'Fino', 'Finovich',
        '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', null);
insert into notification(id, recipient_id, sender_id, description)
values ('1', '1', '1', 'Оплати счёт');

