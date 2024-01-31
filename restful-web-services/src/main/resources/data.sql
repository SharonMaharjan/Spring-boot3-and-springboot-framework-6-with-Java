insert into user_details(id,birth_date,name)
values(10001,current_date(),'Ranga');
insert into user_details(id,birth_date,name)
values(10002,current_date(),'Aru');
insert into user_details(id,birth_date,name)
values(10003,current_date(),'Manu');

insert into post(id,description,user_id)
values(20001,'Learn something',10001);

insert into post(id,description,user_id)
values(20002,'Learn something AWS',10002);

insert into post(id,description,user_id)
values(20003,'Learn something Azure',10003);