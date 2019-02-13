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
comment on column UserInfo.userId is '�������û�ID';
comment on column UserInfo.deptId is '���������ID';
comment on column UserInfo.loginName is '��¼��';
comment on column UserInfo.loginPwd is '��¼����';
comment on column UserInfo.name is '�û�����';
comment on column UserInfo.sex is '�û��Ա�';
comment on column UserInfo.age is '�û�����';
comment on column UserInfo.phone is '�û��绰����';
comment on column UserInfo.idCard is '�û����֤��';
comment on column UserInfo.weChat is '�û�΢�ź�';
comment on column UserInfo.address is '�û���ַ';
comment on column UserInfo.isDelete is '�û��Ƿ����';
comment on column UserInfo.isEnable is '�û��Ƿ�����';
comment on column UserInfo.createDate is '��������';
comment on column UserInfo.createUser is '�����˵�ID';
comment on column UserInfo.lastUpdateDate is '����޸�����';
comment on column UserInfo.lastUpdateUser is '����޸���ID';

create sequence S_UserInfo;
--drop sequence S_UserInfo;

insert into UserInfo (userId,deptId,loginName,loginPwd,name,sex,age,phone,idCard,weChat,address,createUser,lastUpdateUser)
values (S_UserInfo.Nextval,4,'system','888888','����Ա','y',25,'13567678989','132245199901013434','dahuang111','ɽ��̫ԭ',S_UserInfo.Currval,S_UserInfo.Currval);
insert into UserInfo (userId,deptId,loginName,loginPwd,name,sex,age,phone,idCard,weChat,address,createUser,lastUpdateUser)
values (S_UserInfo.Nextval,3,'admin','888888','����','x',20,'15733445566','33123419791212379x','dahuang222','�����ϲ�',2,2);
insert into UserInfo (userId,deptId,loginName,loginPwd,name,sex,age,phone,idCard,weChat,address,createUser,lastUpdateUser)
values (S_UserInfo.Nextval,2,'zs','888888','����','y',20,'15733445566','33123419791212379x','dahuang222','�����ϲ�',2,2);
commit;
