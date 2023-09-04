drop table if exists appium_client;

-- auto-generated definition
create table appium_client
(
    id                  bigint auto_increment
        primary key,
    device_name         varchar(32)                        null comment '设备名称',
    platform            int                                null comment '平台类型：1-iOS, 2-Android',
    platform_version    varchar(16)                        null comment '版本号',
    udid                varchar(64)                        null comment 'iOS udid',
    bundle_id           varchar(32)                        null comment 'iOS应用包名',
    app_package         varchar(64)                        null comment 'Android应用包名',
    app_activity        varchar(64)                        null comment 'Android启动应用活动页',
    no_reset            int      default 1                 null comment '是否不重置应用数据',
    new_command_timeout int      default 6000              null comment '服务端与驱动连接超时时间',
    implicitly_wait     int      default 10                null comment '查找元素隐式等待时间',
    description         varchar(256)                       null comment '客户端描述',
    create_by           varchar(32)                        null comment '创建者',
    created_at          datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by           varchar(32)                        null comment '更新者',
    updated_at          datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted             tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '客户端参数表';

INSERT INTO appium.appium_client (id, device_name, platform, platform_version, udid, bundle_id, app_package, app_activity, no_reset, new_command_timeout, implicitly_wait, description, create_by, created_at, update_by, updated_at, deleted) VALUES (2, 'iPhone 13 Pro Max', 1, '15.5', '00008110-0005390401D3801E', 'com.zeekrlife.mobile', null, null, 1, 6000, 10, 'YueNan''s iPhone', 'chengmo', '2022-10-21 14:44:50', 'chengmo', '2022-10-21 16:28:56', 0);
INSERT INTO appium.appium_client (id, device_name, platform, platform_version, udid, bundle_id, app_package, app_activity, no_reset, new_command_timeout, implicitly_wait, description, create_by, created_at, update_by, updated_at, deleted) VALUES (3, 'HUAWEI Mate 40 Pro', 2, '10', null, null, 'com.zeekrlife.mobile', 'com.zeekrlife.main.SplashActivity', 1, 6000, 10, 'Chengmo''s HUAWEI', 'chengmo', '2022-10-21 14:44:50', 'chengmo', '2022-10-21 16:28:56', 0);
INSERT INTO appium.appium_client (id, device_name, platform, platform_version, udid, bundle_id, app_package, app_activity, no_reset, new_command_timeout, implicitly_wait, description, create_by, created_at, update_by, updated_at, deleted) VALUES (1, 'iPhone 13 Pro Max', 1, '16.0', '00008110-000134190C13801E', 'com.zeekrlife.mobile', null, null, 1, 6000, 10, 'ChengMo''s iPhone', 'chengmo', '2022-10-21 14:44:50', 'chengmo', '2022-10-21 16:28:56', 0);
INSERT INTO appium.appium_client (id, device_name, platform, platform_version, udid, bundle_id, app_package, app_activity, no_reset, new_command_timeout, implicitly_wait, description, create_by, created_at, update_by, updated_at, deleted) VALUES (4, 'iPhone 14 Pro Max', 1, '17.0', '00008110-0005390401D3801E', 'com.zeekrlife.mobile', null, null, 0, 3600, 20, 'ChengMo''s TestModify', 'chengmo', '2022-10-21 16:30:02', 'chengmo', '2022-10-21 16:35:56', 0);
INSERT INTO appium.appium_client (id, device_name, platform, platform_version, udid, bundle_id, app_package, app_activity, no_reset, new_command_timeout, implicitly_wait, description, create_by, created_at, update_by, updated_at, deleted) VALUES (5, 'iPhone 13 Pro Max', 1, '16.0', '00008110-0005390401D3801E', 'com.zeekrlife.mobile', null, null, 1, 6000, 10, 'ChengMo''s Test', 'chengmo', '2022-10-21 16:30:02', null, '2022-10-21 16:32:52', 0);


drop table if exists app_project;

-- auto-generated definition
create table app_project
(
    id           bigint auto_increment
        primary key,
    project_name varchar(32)                        null comment '项目名称',
    project_type int                                null comment '项目类型：0-App，1-Web',
    description  varchar(256)                       null comment '描述',
    create_by    varchar(32)                        null comment '创建者',
    created_at   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by    varchar(32)                        null comment '更新者',
    updated_at   datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted      tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '项目表';

drop table if exists app_module;

-- auto-generated definition
create table app_module
(
    id          bigint auto_increment
        primary key,
    module_name varchar(32)                        null comment '模块名称',
    order_num   int                                null comment '显示顺序',
    project_id  bigint                             null comment '项目id',
    description varchar(256)                       null comment '描述',
    create_by   varchar(32)                        null comment '创建者',
    created_at  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   varchar(32)                        null comment '更新者',
    updated_at  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted     tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '模块表';

drop table if exists app_page;

-- auto-generated definition
create table app_page
(
    id           bigint auto_increment
        primary key,
    page_name    varchar(32)                        null comment '页面名称',
    page_index   int                                null comment '页面层级',
    order_num   int                                null comment '显示顺序',
    has_menu_bar int      default 0                 not null comment '是否含菜单',
    has_tab_bar  int      default 0                 not null comment '是否含页签',
    module_id    bigint                             null comment '模块id',
    description  varchar(256)                       null comment '描述',
    create_by    varchar(32)                        null comment '创建者',
    created_at   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by    varchar(32)                        null comment '更新者',
    updated_at   datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted      tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '页面表';

drop table if exists app_element;

-- auto-generated definition
create table app_element
(
    id            bigint auto_increment
        primary key,
    platform      int                                null comment '平台类型：1-iOS, 2-Android',
    element_name  varchar(256)                       null comment '元素名称',
    locator_type  varchar(256)                       not null comment '定位器类型',
    locator_value varchar(256)                       not null comment '定位器内容',
    order_num   int                                null comment '显示顺序',
    page_id       bigint                             null comment '页面id',
    status        int                                null comment '元素状态',
    description   varchar(256)                       null comment '描述',
    create_by     varchar(32)                        null comment '创建者',
    created_at    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by     varchar(32)                        null comment '更新者',
    updated_at    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted       tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '元素表';
