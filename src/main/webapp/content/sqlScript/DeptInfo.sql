create table DeptInfo
(
    deptId number(20) primary key,
    deptCode nvarchar2(20) unique,
    deptName nvarchar2(15) not null
);
comment on column DeptInfo.deptId is '����������ID';
comment on column DeptInfo.deptCode is '����';
comment on column DeptInfo.deptName is '��������';

create sequence S_DeptInfo;
--drop sequence S_DeptInfo;

insert into DeptInfo (deptId,deptCode,deptName)
values (S_DeptInfo.Nextval,'student','ѧ��');
insert into DeptInfo (deptId,deptCode,deptName)
values (S_DeptInfo.Nextval,'teacher','��ʦ');
insert into DeptInfo (deptId,deptCode,deptName)
values (S_DeptInfo.Nextval,'system','����Ա');
commit;
