create table usuarios
(
    id               int auto_increment
        primary key,
    nombre           varchar(50)                                                      not null,
    apellido         varchar(50)                                                      null,
    num_id           bigint                                                           not null,
    tipo_doc         enum ('CC', 'TI', 'CE', 'RC')                                    not null,
    fecha_nac        date                                                             not null,
    sexo             enum ('M', 'F')                                                  not null,
    estado_civil     enum ('CASADO', 'SOLTERO', 'UNION LIBRE', 'DIVORCIADO', 'VIUDO') not null,
    direccion        varchar(70)                                                      not null,
    municipio_res    varchar(50)                                                      not null,
    departamento_res varchar(50)                                                      not null,
    tel_1            varchar(20)                                                      not null,
    tel_2            varchar(20)                                                      not null,
    email            varchar(70)                                                      not null,
    password         text                                                             not null,
    constraint usuarios_num_id_uindex
        unique (num_id)
);

create table administrativo
(
    id           int auto_increment
        primary key,
    nombre_cargo varchar(50) not null,
    codigo_cargo varchar(20) not null,
    usuario_id   int         not null,
    constraint administrativo_usuarios_id_fk
        foreign key (usuario_id) references usuarios (id)
            on update cascade on delete cascade
);

create table medico
(
    id               int auto_increment
        primary key,
    num_tarjeta_prof varchar(20)                   not null,
    grupo_sang       enum ('A', 'B', 'AB', 'O')    not null,
    RH               enum ('POSITIVO', 'NEGATIVO') not null,
    especialidad_med varchar(60)                   not null,
    EPS              varchar(50)                   not null,
    usuario_id       int                           not null,
    constraint medico_num_tarjeta_prof_uindex
        unique (num_tarjeta_prof),
    constraint medico_usuarios_id_fk
        foreign key (usuario_id) references usuarios (id)
            on update cascade on delete cascade
);

create table horarios
(
    id            int auto_increment
        primary key,
    fecha_horario date not null,
    hora_entrada  time not null,
    hora_salida   time not null,
    fecha_inicio  date not null,
    fecha_final   date not null,
    id_medico     int  not null,
    constraint horarios_medico_usuario_id_fk
        foreign key (id_medico) references medico (usuario_id)
            on update cascade on delete cascade
);

create table paciente
(
    id                int auto_increment
        primary key,
    grupo_sang        enum ('A', 'B', 'AB', 'O')    not null,
    RH                enum ('POSITIVO', 'NEGATIVO') not null,
    profesion         varchar(60)                   not null,
    ocupacion         varchar(60)                   not null,
    tipo_afiliacion   varchar(50)                   not null,
    estado_afiliacion tinyint(1)                    not null,
    usuario_id        int                           not null,
    constraint paciente_usuarios_id_fk
        foreign key (usuario_id) references usuarios (id)
            on update cascade on delete cascade
);

create table citas
(
    id          int auto_increment
        primary key,
    fecha       date not null,
    hora_inicio time not null,
    hora_final  time not null,
    id_medico   int  not null,
    id_paciente int  not null,
    constraint citas_medico_usuario_id_fk
        foreign key (id_medico) references medico (usuario_id)
            on update cascade on delete cascade,
    constraint citas_paciente_usuario_id_fk
        foreign key (id_paciente) references paciente (usuario_id)
            on update cascade on delete cascade
);

create
    definer = root@localhost procedure op_administrativo(IN _id int, IN _nombre varchar(50), IN _apellido varchar(50),
                                                         IN _num_id bigint, IN _tipo_doc varchar(2), IN _fecha_nac date,
                                                         IN _sexo varchar(1), IN _estado_civil varchar(20),
                                                         IN _direccion varchar(70), IN _municipio_res varchar(50),
                                                         IN _departamento_res varchar(50), IN _tel_1 varchar(20),
                                                         IN _tel_2 varchar(20), IN _email varchar(70),
                                                         IN _password text, IN _nombre_cargo varchar(50),
                                                         IN _codigo_cargo varchar(50), IN _case int)
BEGIN
    declare id_user int;
    if _case = 1 then
        insert into usuarios
        (nombre, apellido, num_id, tipo_doc, fecha_nac, sexo, estado_civil, direccion, municipio_res, departamento_res,
         tel_1, tel_2, email, password)
        values (_nombre, _apellido, _num_id, _tipo_doc, _fecha_nac, _sexo, _estado_civil, _direccion, _municipio_res,
                _departamento_res, _tel_1, _tel_2, _email, _password);
        select id into id_user from usuarios order by id desc limit 1;
        insert into administrativo (nombre_cargo, codigo_cargo, usuario_id)
        values (_nombre_cargo, _codigo_cargo, id_user);
    end if;
    if _case = 2 then
        update usuarios
        set nombre           = _nombre,
            apellido         = _apellido,
            num_id           = _num_id,
            tipo_doc         = _tipo_doc,
            fecha_nac        = _fecha_nac,
            sexo             = _sexo,
            estado_civil     = _estado_civil,
            direccion        = _direccion,
            municipio_res    = _municipio_res,
            departamento_res = _departamento_res,
            tel_1            = _tel_1,
            tel_2            = _tel_2,
            email            = _email,
            password         = _password
        where id = _id;
        update administrativo
        set nombre_cargo = _nombre_cargo,
            codigo_cargo = _codigo_cargo
        where usuario_id = _id;
    end if;
    if _case = 3 then
        delete from usuarios where id = _id;
        delete from paciente where usuario_id = _id;
    end if;
end;

create
    definer = root@localhost procedure op_medico(IN _id int, IN _nombre varchar(50), IN _apellido varchar(50),
                                                 IN _num_id bigint, IN _tipo_doc varchar(2), IN _fecha_nac date,
                                                 IN _sexo varchar(1), IN _estado_civil varchar(20),
                                                 IN _direccion varchar(70), IN _municipio_res varchar(50),
                                                 IN _departamento_res varchar(50), IN _tel_1 varchar(20),
                                                 IN _tel_2 varchar(20), IN _email varchar(70), IN _password text,
                                                 IN _num_tarjeta_prof varchar(20), IN _grupo_sang varchar(2),
                                                 IN _RH varchar(8), IN _especialidad_med varchar(60),
                                                 IN _EPS varchar(50), IN _case int)
BEGIN
    declare id_user int;
    if _case = 1 then
        insert into usuarios
        (nombre, apellido, num_id, tipo_doc, fecha_nac, sexo, estado_civil, direccion, municipio_res, departamento_res,
         tel_1, tel_2, email, password)
        values (_nombre, _apellido, _num_id, _tipo_doc, _fecha_nac, _sexo, _estado_civil, _direccion, _municipio_res,
                _departamento_res, _tel_1, _tel_2, _email, _password);
        select id into id_user from usuarios order by id desc limit 1;
        insert into medico (num_tarjeta_prof, grupo_sang, RH, especialidad_med, EPS, usuario_id)
        values (_num_tarjeta_prof, _grupo_sang, _RH, _especialidad_med, _EPS, id_user);
    end if;
    if _case = 2 then
        update usuarios
        set nombre           = _nombre,
            apellido         = _apellido,
            num_id           = _num_id,
            tipo_doc         = _tipo_doc,
            fecha_nac        = _fecha_nac,
            sexo             = _sexo,
            estado_civil     = _estado_civil,
            direccion        = _direccion,
            municipio_res    = _municipio_res,
            departamento_res = _departamento_res,
            tel_1            = _tel_1,
            tel_2            = _tel_2,
            email            = _email,
            password         = _password
        where id = _id;
        update medico
        set num_tarjeta_prof = _num_tarjeta_prof,
            grupo_sang       = _grupo_sang,
            RH               = _RH,
            especialidad_med = _especialidad_med,
            EPS              = _EPS
        where usuario_id = _id;
    end if;
    if _case = 3 then
        delete from usuarios where id = _id;
        delete from medico where usuario_id = _id;
    end if;
end;

create
    definer = root@localhost procedure op_paciente(IN _id int, IN _nombre varchar(50), IN _apellido varchar(50),
                                                   IN _num_id bigint, IN _tipo_doc varchar(2), IN _fecha_nac date,
                                                   IN _sexo varchar(1), IN _estado_civil varchar(20),
                                                   IN _direccion varchar(70), IN _municipio_res varchar(50),
                                                   IN _departamento_res varchar(50), IN _tel_1 varchar(20),
                                                   IN _tel_2 varchar(20), IN _email varchar(70), IN _password text,
                                                   IN _grupo_sang varchar(2), IN _RH varchar(8),
                                                   IN _profesion varchar(60), IN _ocupacion varchar(60),
                                                   IN _tipo_afiliacion varchar(50), IN _estado_afiliacion tinyint(1),
                                                   IN _case int)
BEGIN
    declare id_user int;

    if _case = 1 then
        insert into usuarios
        (nombre, apellido, num_id, tipo_doc, fecha_nac, sexo, estado_civil, direccion, municipio_res, departamento_res,
         tel_1, tel_2, email, password)
        values (_nombre, _apellido, _num_id, _tipo_doc, _fecha_nac, _sexo, _estado_civil, _direccion, _municipio_res,
                _departamento_res, _tel_1, _tel_2, _email, _password);
        select id into id_user from usuarios order by id desc limit 1;
        insert into paciente (grupo_sang, RH, profesion, ocupacion, tipo_afiliacion, estado_afiliacion, usuario_id)
        values (_grupo_sang, _RH, _profesion, _ocupacion, _tipo_afiliacion, _estado_afiliacion, id_user);
    end if;
    if _case = 2 then
        update usuarios
        set nombre           = _nombre,
            apellido         = _apellido,
            num_id           = _num_id,
            tipo_doc         = _tipo_doc,
            fecha_nac        = _fecha_nac,
            sexo             = _sexo,
            estado_civil     = _estado_civil,
            direccion        = _direccion,
            municipio_res    = _municipio_res,
            departamento_res = _departamento_res,
            tel_1            = _tel_1,
            tel_2            = _tel_2,
            email            = _email,
            password         = _password
        where id = _id;
        update paciente
        set grupo_sang        = _grupo_sang,
            RH                = _RH,
            profesion         = _profesion,
            ocupacion         = _ocupacion,
            tipo_afiliacion   = _tipo_afiliacion,
            estado_afiliacion = _estado_afiliacion
        where usuario_id = _id;
    end if;
    if _case = 3 then
        delete from usuarios where id = _id;
        delete from paciente where usuario_id = _id;
    end if;


end;


