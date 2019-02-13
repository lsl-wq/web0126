create table TCourse(
      cId number primary key,
      cNo varchar2(10) not null unique,
      cName varchar2(20) not null,
      createDate date default(sysdate)
);

create sequence S_TCourse;

insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C000','高等数学');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C001','数学分析');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C002','高等代数');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C003','概率论');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C004','数理统计');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C005','实变函数');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C006','泛函分析');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C007','数值代数');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C008','数值分析');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C009','离散数学');
commit;

--select * from TCourse;