create table Room (

  building char(2),

  no int(4),

  doorOpen boolean,

  isUsing boolean,

  isProject boolean,

  posiMen int(4)
);

create table Student (

  sno int(8),

  spw char(20),

  sname char(10),

  department char(40),

  email char(40),

  phone char(16)

);

create table Manager (

  mid char(20),

  mpw char(20),

  mname char(10)

);

create table Notification (

  nno int(10),

  nwriter char(10),

  nname char(30),

  ncontent TEXT(500),

  ntime date

);


