drop table if exists appium_client;
-- auto-generated definition
create table appium_client
(
    id                  bigint auto_increment
        primary key,
    device_name         varchar(32)                          null comment '设备名称',
    platform            int                                  null comment '平台类型：1-iOS, 2-Android',
    platform_name       varchar(16)                          null comment '平台名称 iOS Android',
    udid                varchar(64)                          null comment 'iOS udid',
    bundle_id           varchar(32)                          null comment 'iOS应用包名',
    app_package         varchar(64)                          null comment 'Android应用包名',
    app_activity        varchar(64)                          null comment 'Android启动应用活动页',
    no_reset            int        default 1                 null comment '是否不重置应用数据',
    new_command_timeout int        default 6000              null comment '服务端与驱动连接超时时间',
    implicitly_wait     int        default 10                null comment '查找元素隐式等待时间',
    description         varchar(256)                         null comment '描述',
    created_at          datetime   default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at          datetime   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted             tinyint(2) default 0                 not null comment '是否删除：0-否, 1-是'

)
    comment '客户端参数表';


drop table if exists test_case;

-- auto-generated definition
create table test_case
(
    id          bigint auto_increment
        primary key,
    case_name   varchar(32)                        null comment '用例名称',
    order_num   int                                null comment '排序编号',
    description varchar(256)                       null comment '描述',
    create_by   varchar(32)                        null comment '创建者',
    created_at  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   varchar(32)                        null comment '更新者',
    updated_at  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted     tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '用例表';

drop table if exists test_execute;

-- auto-generated definition
create table test_execute
(
    id            bigint auto_increment
        primary key,
    task_id       bigint                             null comment '任务id',
    task_name     varchar(32)                        null comment '任务名称',
    client_info   varchar(32)                        null comment '客户端信息',
    status        int                                null comment '执行状态',
    case_count    int                                null comment '用例数',
    success_count int                                null comment '成功数',
    fail_count    int                                null comment '失败数',
    no_exec_count int                                null comment '未执行数',
    description   varchar(256)                       null comment '描述',
    create_by     varchar(32)                        null comment '创建者',
    created_at    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by     varchar(32)                        null comment '更新者',
    updated_at    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted       tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '任务执行表';


drop table if exists job;

-- auto-generated definition
create table job
(
    id              bigint auto_increment
        primary key,
    job_name        varchar(32)                        null comment '作业名称',
    cron_expression varchar(32)                        null comment 'cron表达式',
    status          int                                null comment '任务状态：0-暂停，1-正常',
    description     varchar(256)                       null comment '描述',
    create_by       varchar(32)                        null comment '创建者',
    created_at      datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by       varchar(32)                        null comment '更新者',
    updated_at      datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted         tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '作业表';


drop table if exists app_module;

-- auto-generated definition
create table app_module
(
    id          bigint auto_increment
        primary key,
    module_name varchar(32)                        null comment '项目名称',
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
    id          bigint auto_increment
        primary key,
    page_name   varchar(32)                        null comment '页面名称',
    page_level  int                                null comment '页面登记',
    module_id   bigint                             null comment '模块id',
    description varchar(256)                       null comment '描述',
    create_by   varchar(32)                        null comment '创建者',
    created_at  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   varchar(32)                        null comment '更新者',
    updated_at  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted     tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '页面表';


drop table if exists test_plan;

-- auto-generated definition
create table test_plan
(
    id          bigint auto_increment
        primary key,
    plan_name   varchar(32)                        null comment '计划名称',
    project_id  bigint                             null comment '项目id',
    description varchar(256)                       null comment '描述',
    create_by   varchar(32)                        null comment '创建者',
    created_at  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   varchar(32)                        null comment '更新者',
    updated_at  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted     tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '计划表';


drop table if exists app_project;

-- auto-generated definition
create table app_project
(
    id           bigint auto_increment
        primary key,
    project_name varchar(32)                        null comment '项目名称',
    project_type int                                null comment '项目类型：0-iOS，1-Android',
    description  varchar(256)                       null comment '描述',
    create_by    varchar(32)                        null comment '创建者',
    created_at   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by    varchar(32)                        null comment '更新者',
    updated_at   datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted      tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '项目表';


drop table if exists test_step;

-- auto-generated definition
create table test_step
(
    id          bigint auto_increment
        primary key,
    page_id     bigint                             null comment '页面id',
    case_id     bigint                             null comment '用例id',
    step_name   varchar(64)                        null comment '步骤名称',
    description varchar(256)                       null comment '描述',
    create_by   varchar(32)                        null comment '创建者',
    created_at  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   varchar(32)                        null comment '更新者',
    updated_at  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted     tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '步骤表';

drop table if exists test_task;

-- auto-generated definition
create table test_task
(
    id               bigint auto_increment
        primary key,
    task_name        varchar(32)                        null comment '任务名称',
    job_id           bigint                             null comment '作业id',
    project_id       bigint                             null comment '项目id',
    plan_id          bigint                             null comment '计划id',
    appium_client_id bigint                             null comment '客户端id',
    timeout          int                                null comment '超时时间',
    notice_type      int                                null comment '通知类型',
    notice_address   varchar(32)                        null comment '通知地址',
    description      varchar(256)                       null comment '描述',
    create_by        varchar(32)                        null comment '创建者',
    created_at       datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by        varchar(32)                        null comment '更新者',
    updated_at       datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted          tinyint  default 0                 not null comment '是否删除：0-否, 1-是'
)
    comment '任务表';
