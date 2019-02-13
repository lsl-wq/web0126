create table TCourse(
      cId number primary key,
      cNo varchar2(10) not null unique,
      cName varchar2(20) not null,
      createDate date default(sysdate)
);

create sequence S_TCourse;

insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C000','�ߵ���ѧ');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C001','��ѧ����');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C002','�ߵȴ���');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C003','������');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C004','����ͳ��');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C005','ʵ�亯��');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C006','��������');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C007','��ֵ����');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C008','��ֵ����');
insert into TCourse (cId,cNo,cName) values(S_TCourse.nextval,'C009','��ɢ��ѧ');
commit;

--select * from TCourse;