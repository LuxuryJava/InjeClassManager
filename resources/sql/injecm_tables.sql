create table Room (

                      rinfo char(10),

                      doorOpen boolean,

                      isUsing boolean,

                      isProject boolean,

                      posiMen int(4),

                      PRIMARY KEY(rinfo)
);

create table user (
                      uno VARCHAR(20),

                      upw VARCHAR(500),

                      uname char(10),

                      department char(40),

                      email char(40),

                      phone char(16),

                      isManager boolean,

                      PRIMARY KEY(uno)
);

create table Notification (
                              ntitle char(30),

                              ncontent TEXT(500),

                              PRIMARY KEY(ntitle)
);

create table Reservation(
                                uno varchar(20),

                                rinfo char(10),

                                mencnt int(3),

<<<<<<< HEAD
                            useday char(2),

                            usetime char(100),
=======
                                useday char(2),

                                usetime char(100),
>>>>>>> 29bf59fc4890c54f36b2b2ff3cfb2318dd38bb5b

                                purpose char(100),

<<<<<<< HEAD
                            accept boolean,

                            PRIMARY KEY(rinfo, uno),
=======
                                accept boolean,
>>>>>>> 29bf59fc4890c54f36b2b2ff3cfb2318dd38bb5b

                                PRIMARY KEY(rinfo, uno),

                                foreign key(rinfo) references Room(rinfo) ON DELETE CASCADE,

                                foreign key(uno) references User(uno)ON DELETE CASCADE
 );