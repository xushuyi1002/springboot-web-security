--数据库环境
-- localhost sinosoft root 123456

/*==============================================================*/
/* Table: sysuser                                               */
/*==============================================================*/
create table sysuser
(
   id                   bigint not null auto_increment comment '主键ID',
   username             varchar(50) comment '用户名',
   password             varchar(50) comment '密码',
   primary key (id)
)CHARACTER SET utf8;
alter table sysuser comment '用户表';

INSERT INTO `sysuser` (`id`,`username`,`password`) VALUES (1,'admin','21232F297A57A5A743894A0E4A801FC3');
INSERT INTO `sysuser` (`id`,`username`,`password`) VALUES (2,'xushuyi','969D3ED14F404575F34C3AC7BAFE9739');

/*==============================================================*/
/* Table: sysrole                                               */
/*==============================================================*/
create table sysrole
(
   id                   bigint not null auto_increment comment '主键ID',
   name                 varchar(50) comment '角色名称',
   primary key (id)
)CHARACTER SET utf8;
alter table sysrole comment '角色表';

INSERT INTO `sysrole` (`id`,`name`) VALUES (1,'ROLE_ADMIN');
INSERT INTO `sysrole` (`id`,`name`) VALUES (2,'ROLE_USER');

/*==============================================================*/
/* Table: sysuserrole                                           */
/*==============================================================*/
create table sysuserrole
(
   id                   bigint not null auto_increment comment '主键ID',
   userid               bigint comment '权限名称',
   roleid               bigint comment '权限描述',
   primary key (id)
)CHARACTER SET utf8;
alter table sysuserrole comment '用户角色表';

INSERT INTO `sysuserrole` (`id`,`userid`,`roleid`) VALUES (1,1,1);
INSERT INTO `sysuserrole` (`id`,`userid`,`roleid`) VALUES (2,2,2);


/*==============================================================*/
/* Table: SysRolePermissions                                    */
/*==============================================================*/
create table SysRolePermissions
(
   id                   bigint not null auto_increment comment '主键Id',
   RoleId               bigint comment '角色Id',
   PermissionPath       varchar(255) comment '权限路径',
   primary key (id)
);
alter table SysRolePermissions comment '角色权限表';

INSERT INTO `SysRolePermissions` (`id`,`RoleId`,`PermissionPath`) VALUES (1,2,'/login');
INSERT INTO `SysRolePermissions` (`id`,`RoleId`,`PermissionPath`) VALUES (2,2,'/home');


/*=================================================================== ****以上脚本已经废弃**** ===================================================================*/

/*==============================================================*/
/* Table: UserInfo                                              */
/*==============================================================*/
drop table if exists UserInfo;
create table UserInfo
(
   Id                   bigint not null auto_increment comment '主键Id',
   UserCode             varchar(32) not null comment '用户编码',
   UserName             varchar(255) not null comment '用户名称',
   PassWord             varchar(50) not null comment '密码',
   Phone                varchar(20) not null comment '手机号',
   IdCardNo             varchar(32) not null comment '身份证号',
   Email                varchar(50) comment '公司邮箱',
   AccountCode          varchar(50) comment '账户编码',
   DeptCode             varchar(50) comment '部门编码',
   CompanyCode          varchar(50) comment '公司编码',
   BankCode             varchar(50) comment '银行账户编码',
   BankName             varchar(255) comment '银行账户名称',
   CreateTime           timestamp not null comment '创建时间',
   ModifyTime           timestamp null comment '修改时间',
   primary key (Id)
)CHARACTER SET utf8;
alter table UserInfo comment '用户信息表';
INSERT INTO `UserInfo` (`Id`,`UserCode`,`UserName`,`PassWord`,`Phone`,`IdCardNo`,`Email`,`AccountCode`,`DeptCode`,`CompanyCode`,`BankCode`,`BankName`,`CreateTime`,`ModifyTime`) VALUES (1,'10001','xushuyi','969D3ED14F404575F34C3AC7BAFE9739','18210436032','412829199003070812','xushuyi@sinosoft.com.cn','10001','10001','10000','6225880172209876','神码银行','2018-05-20 22:25:23',NULL);

/*==============================================================*/
/* Table: RoleInfo                                              */
/*==============================================================*/
drop table if exists RoleInfo;
create table RoleInfo
(
   Id                   bigint not null auto_increment comment '主键Id',
   RoleCode             varchar(50) not null comment '角色组编码',
   RoleName             varchar(255) not null comment '角色组名称',
   CreateTime           timestamp not null comment '创建时间',
   ModifyTime           timestamp null comment '修改时间',
   primary key (Id)
)CHARACTER SET utf8;
ALTER TABLE RoleInfo ADD CONSTRAINT unique_id_rolecode_rolename UNIQUE (Id, RoleCode, RoleName);
alter table RoleInfo comment '角色组信息表';
INSERT INTO `roleinfo` (`Id`,`RoleCode`,`RoleName`,`CreateTime`,`ModifyTime`) VALUES (1,'1001','角色组1','2018-05-20 22:27:47',NULL);


/*==============================================================*/
/* Table: MenuInfo                                              */
/*==============================================================*/
drop table if exists MenuInfo;
create table MenuInfo
(
   Id                   bigint not null auto_increment comment '菜单组Id',
   MenuCode             varchar(50) not null comment '菜单编码',
   MenuName             varchar(255) not null comment '菜单名称',
   MenuIcon             varchar(255) not null comment '菜单图片',
   MenuAddress          varchar(255) not null comment '菜单地址',
   SuperMenu            varchar(50) comment '父菜单编码',
   ChildCount           int comment '子节点个数',
   CreateTime           timestamp not null comment '创建时间',
   ModifyTime           timestamp null comment '修改时间',
   primary key (Id)
)CHARACTER SET utf8;
ALTER TABLE MenuInfo ADD CONSTRAINT unique_id_menucode_menuname UNIQUE (Id, MenuCode, MenuName);
alter table MenuInfo comment '菜单组信息表';
INSERT INTO `menuinfo` (`Id`,`MenuCode`,`MenuName`,`MenuIcon`,`MenuAddress`,`SuperMenu`,`ChildCount`,`CreateTime`,`ModifyTime`) VALUES (1,'100001','登录','icon','/login','000000',0,'2018-05-20 22:26:46',NULL);
INSERT INTO `menuinfo` (`Id`,`MenuCode`,`MenuName`,`MenuIcon`,`MenuAddress`,`SuperMenu`,`ChildCount`,`CreateTime`,`ModifyTime`) VALUES (2,'100001','主页','icon','/home','000000',0,'2018-05-20 22:27:10',NULL);


/*==============================================================*/
/* Table: UserRole                                              */
/*==============================================================*/
drop table if exists UserRole;
create table UserRole
(
   Id                   bigint not null auto_increment comment '主键Id',
   UserId               bigint not null comment '用户Id',
   RoleId               bigint not null comment '角色Id',
   CreateTime           timestamp not null comment '创建时间',
   ModifyTime           timestamp null comment '修改时间',
   primary key (Id)
)CHARACTER SET utf8;
ALTER TABLE UserRole ADD CONSTRAINT unique_id_userid_roleid UNIQUE (Id, UserId, RoleId);
alter table UserRole comment '用户角色关联表';
INSERT INTO `userrole` (`Id`,`UserId`,`RoleId`,`CreateTime`,`ModifyTime`) VALUES (1,1,1,'2018-05-20 22:28:34',NULL);



/*==============================================================*/
/* Table: RoleMenuLinkInfo                                      */
/*==============================================================*/
drop table if exists RoleMenu;
create table RoleMenu
(
   Id                   bigint not null auto_increment comment '主键Id',
   RoleId               bigint not null comment '角色Id',
   MenuId               bigint not null comment '菜单Id',
   CreateTime           timestamp not null comment '创建时间',
   ModifyTime           timestamp null comment '修改时间',
   primary key (Id)
)CHARACTER SET utf8;
ALTER TABLE RoleMenu ADD CONSTRAINT unique_id_roleid_menuid UNIQUE (Id, RoleId, MenuId);
alter table RoleMenu comment '角色菜单组权限表';
INSERT INTO `rolemenu` (`Id`,`RoleId`,`MenuId`,`CreateTime`,`ModifyTime`) VALUES (1,1,1,'2018-05-20 22:28:15',NULL);
INSERT INTO `rolemenu` (`Id`,`RoleId`,`MenuId`,`CreateTime`,`ModifyTime`) VALUES (2,1,2,'2018-05-20 22:28:15',NULL);

/*==============================================================*/
/* Table: CodeType                                              */
/*==============================================================*/
drop table if exists CodeType;
create table CodeType
(
   Id                   bigint not null auto_increment comment '主键Id',
   CodeType             varchar(50) not null comment '编码类型',
   CodeTypeDesc         varchar(500) not null comment '简体描述',
   BusinessArea         varchar(2) comment '业务领域',
   Flag                 varchar(1) not null comment '启用状态（0 未启用 1 启用）',
   CreateTime           timestamp not null comment '创建日期',
   ModifyTime           timestamp null comment '修改日期',
   primary key (Id)
)CHARACTER SET utf8;
alter table CodeType comment '字典类型';

/*==============================================================*/
/* Table: CodeManage                                            */
/*==============================================================*/
drop table if exists CodeManage;
create table CodeManage
(
   Id                   bigint not null auto_increment comment '主键Id',
   CodeType             varchar(50) not null comment '编码类型',
   CodeCode             varchar(50) not null comment '编码',
   CodeName             varchar(500) not null comment '编码名称',
   Flag                 varchar(1) not null comment '启用状态（0 未启用 1 启用）',
   CreateTime           timestamp not null comment '创建时间',
   ModifyTime           timestamp null comment '修改时间',
   primary key (Id)
) CHARACTER SET utf8;
alter table CodeManage comment '字典信息表';