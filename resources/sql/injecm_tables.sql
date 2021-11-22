create table Room (

                      rinfo char(10),

                      doorOpen boolean,

                      isUsing boolean,

                      isProject boolean,

                      posiMen int(4),

                      PRIMARY KEY(rinfo)
);

create table Student (

                         sno int(8),

                         spw VARCHAR(500),

                         sname char(10),

                         department char(40),

                         email char(40),

                         phone char(16),

                         PRIMARY KEY(sno)
);

create table Manager (

                         mid char(20),

                         mpw char(20),

                         mname char(10),

                         PRIMARY KEY(mid)
);

create table Notification (

                              nno int(10),

                              nwriter char(10),

                              nname char(30),

                              ncontent TEXT(500),

                              ntime date,

                              PRIMARY KEY(nno)
);

create table Reservation(

                            sno int(8),

                            rinfo char(10),

                            mencnt int(3),

                            stime TIMESTAMP,

                            ftime TIMESTAMP,

                            purpose char(100),

                            PRIMARY KEY(rinfo, sno),

                            foreign key(rinfo) references Room(rinfo) ON DELETE CASCADE,

                            foreign key(sno) references Student(sno)ON DELETE CASCADE
);