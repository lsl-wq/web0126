create table UserInfo
(
    userId number primary key,
    deptId number,
    loginName nvarchar2(16) unique,
    loginPwd nvarchar2(16) not null,
    name nvarchar2(15),
    sex char(1) check(sex = 'x' or sex = 'y'),
    age number(3) check(age > 0 and age < 150),
    phone nvarchar2(11),
    idCard nvarchar2(18),
    weChat nvarchar2(20),
    address nvarchar2(100),
    isDelete number(1) default(0) check(isDelete = 0 or isDelete = 1),
    isEnable number(1) default(1) check(isEnable = 0 or isEnable = 1),
    createDate date default(sysdate),
    createUser number,
    lastUpdateDate date default(sysdate),
    lastUpdateUser number,
    constraint UserInfo_DeptInfo_deptId foreign key (deptId) references DeptInfo(deptId)
);
comment on column UserInfo.userId is '主键，用户ID';
comment on column UserInfo.deptId is '外键，类型ID';
comment on column UserInfo.loginName is '登录名';
comment on column UserInfo.loginPwd is '登录密码';
comment on column UserInfo.name is '用户姓名';
comment on column UserInfo.sex is '用户性别';
comment on column UserInfo.age is '用户年龄';
comment on column UserInfo.phone is '用户电话号码';
comment on column UserInfo.idCard is '用户身份证号';
comment on column UserInfo.weChat is '用户微信号';
comment on column UserInfo.address is '用户地址';
comment on column UserInfo.isDelete is '用户是否存在';
comment on column UserInfo.isEnable is '用户是否锁定';
comment on column UserInfo.createDate is '创建日期';
comment on column UserInfo.createUser is '创建人的ID';
comment on column UserInfo.lastUpdateDate is '最后修改日期';
comment on column UserInfo.lastUpdateUser is '最后修改人ID';

create sequence S_UserInfo;
--drop sequence S_UserInfo;

insert into UserInfo (userId,deptId,loginName,loginPwd,name,sex,age,phone,idCard,weChat,address,createUser,lastUpdateUser)
values (S_UserInfo.Nextval,4,'system','888888','管理员','y',25,'13567678989','132245199901013434','dahuang111','山西太原',S_UserInfo.Currval,S_UserInfo.Currval);
insert into UserInfo (userId,deptId,loginName,loginPwd,name,sex,age,phone,idCard,weChat,address,createUser,lastUpdateUser)
values (S_UserInfo.Nextval,3,'admin','888888','李四','x',20,'15733445566','33123419791212379x','dahuang222','江西南昌',2,2);
insert into UserInfo (userId,deptId,loginName,loginPwd,name,sex,age,phone,idCard,weChat,address,createUser,lastUpdateUser)
values (S_UserInfo.Nextval,2,'zs','888888','张三','y',20,'15733445566','33123419791212379x','dahuang222','江西南昌',2,2);
commit;
