create table TSC(
       scId number primary key,
       stuId number,
       cId number,
       score number(4,1) default 0 check(score>=0 and score<=100),
       createDate date default(sysdate),
       constraint SC_UserInfo foreign key (stuId) references UserInfo(userId),
       constraint SC_Tcourse foreign key (cId) references Tcourse(cId)
);

create sequence S_TSC;