create table DeptInfo
(
    deptId number(20) primary key,
    deptCode nvarchar2(20) unique,
    deptName nvarchar2(15) not null
);
comment on column DeptInfo.deptId is '主键，类型ID';
comment on column DeptInfo.deptCode is '类型';
comment on column DeptInfo.deptName is '类型名称';

create sequence S_DeptInfo;
--drop sequence S_DeptInfo;

insert into DeptInfo (deptId,deptCode,deptName)
values (S_DeptInfo.Nextval,'student','学生');
insert into DeptInfo (deptId,deptCode,deptName)
values (S_DeptInfo.Nextval,'teacher','老师');
insert into DeptInfo (deptId,deptCode,deptName)
values (S_DeptInfo.Nextval,'system','管理员');
commit;
