
--
-- Asientos registrales
--

CREATE SEQUENCE sir_aregs_seq;

CREATE TABLE sir_asientos_registrales (
  id integer NOT NULL,
  cd_ent_reg varchar(21) NOT NULL,
  cd_intercambio varchar(33),
  cd_estado integer NOT NULL,
  fe_estado timestamp NOT NULL,
  fe_envio timestamp,
  fe_recepcion timestamp,
  num_reintentos integer DEFAULT 0,
  num_registro varchar(20) ,
  fe_registro timestamp ,
  num_registro_inicial varchar(20) NOT NULL,
  fe_registro_inicial timestamp NOT NULL,
  ts_registro_inicial blob,
  num_exp varchar(80),
  referencia_externa varchar(16),
  ts_entrada blob,
  cd_ent_reg_origen varchar(21) NOT NULL,
  ds_ent_reg_origen varchar(80),
  cd_org_origen varchar(21),
  ds_org_origen varchar(80),
  cd_ent_reg_destino varchar(21) NOT NULL,
  ds_ent_reg_destino varchar(80),
  cd_org_destino varchar(21),
  ds_org_destino varchar(80),
  ds_resumen varchar(240),
  cd_asunto_destino varchar(16),
  cd_tipo_transporte varchar(2),
  ds_num_transporte varchar(20),
  ds_nombre_usuario varchar(80),
  ds_contacto_usuario varchar(160),
  cd_app_emisora varchar(4),
  cd_tipo_anotacion varchar(2),
  ds_tipo_anotacion varchar(80),
  cd_tipo_registro varchar(1) NOT NULL,
  cd_doc_fisica varchar(2) NOT NULL,
  ds_observaciones varchar(50),
  cd_prueba varchar(1) NOT NULL,
  cd_ent_reg_inicio varchar(21) NOT NULL,
  ds_ent_reg_inicio varchar(80),
  ds_expone varchar(4000),
  ds_solicita varchar(4000),
  cd_error varchar(4),
  ds_error varchar(4000)
);

COMMENT ON COLUMN sir_asientos_registrales.id IS 'Identificador �nico del asiento registral';
COMMENT ON COLUMN sir_asientos_registrales.cd_intercambio IS 'Identificador de intercambio';
COMMENT ON COLUMN sir_asientos_registrales.cd_estado IS 'C�digo de estado';
COMMENT ON COLUMN sir_asientos_registrales.fe_estado IS 'Fecha de estado';
COMMENT ON COLUMN sir_asientos_registrales.fe_envio IS 'Fecha de env�o';
COMMENT ON COLUMN sir_asientos_registrales.fe_recepcion IS 'Fecha de recepci�n';
COMMENT ON COLUMN sir_asientos_registrales.num_reintentos IS 'N�mero de reintentos de env�o';
COMMENT ON COLUMN sir_asientos_registrales.num_registro IS 'N�mero de registro de entrada (en origen)';
COMMENT ON COLUMN sir_asientos_registrales.fe_registro IS 'Fecha y hora de entrada (en origen)';
COMMENT ON COLUMN sir_asientos_registrales.num_registro_inicial IS 'N�mero de registro inicial';
COMMENT ON COLUMN sir_asientos_registrales.fe_registro_inicial IS 'Fecha y hora del registro inicial';
COMMENT ON COLUMN sir_asientos_registrales.ts_registro_inicial IS 'Timestamp del registro inicial';
COMMENT ON COLUMN sir_asientos_registrales.num_exp IS 'N�mero de expediente objeto de la tramitaci�n administrativa';
COMMENT ON COLUMN sir_asientos_registrales.referencia_externa IS 'Referencia que el destino precise conocer y sea conocida por el solicitante';
COMMENT ON COLUMN sir_asientos_registrales.ts_entrada IS 'Sello de tiempo (timestamp) del registro de entrada (en origen)';
COMMENT ON COLUMN sir_asientos_registrales.cd_ent_reg_origen IS 'C�digo de la entidad registral de origen';
COMMENT ON COLUMN sir_asientos_registrales.ds_ent_reg_origen IS 'Descripci�n de la entidad registral de origen';
COMMENT ON COLUMN sir_asientos_registrales.cd_org_origen IS 'C�digo de la unidad de tramitaci�n de origen';
COMMENT ON COLUMN sir_asientos_registrales.ds_org_origen IS 'Descripci�n de la unidad de tramitaci�n de origen';
COMMENT ON COLUMN sir_asientos_registrales.cd_ent_reg_destino IS 'C�digo de la entidad registral de destino';
COMMENT ON COLUMN sir_asientos_registrales.ds_ent_reg_destino IS 'Descripci�n de la entidad registral de destino';
COMMENT ON COLUMN sir_asientos_registrales.cd_org_destino IS 'C�digo de la unidad de tramitaci�n de destino';
COMMENT ON COLUMN sir_asientos_registrales.ds_org_destino IS 'Descripci�n de la unidad de tramitaci�n de destino';
COMMENT ON COLUMN sir_asientos_registrales.ds_resumen IS 'Abstract o resumen';
COMMENT ON COLUMN sir_asientos_registrales.cd_asunto_destino IS 'C�digo de asunto en destino';
COMMENT ON COLUMN sir_asientos_registrales.cd_tipo_transporte IS 'Tipo de transporte de entrada';
COMMENT ON COLUMN sir_asientos_registrales.ds_num_transporte IS 'N�mero de transporte de entrada';
COMMENT ON COLUMN sir_asientos_registrales.ds_nombre_usuario IS 'Nombre de usuario de origen';
COMMENT ON COLUMN sir_asientos_registrales.ds_contacto_usuario IS 'Contacto del usuario de origen (tel�fono o direcci�n de correo electr�nico)';
COMMENT ON COLUMN sir_asientos_registrales.cd_app_emisora IS 'Identifica la aplicaci�n emisora y su versi�n';
COMMENT ON COLUMN sir_asientos_registrales.cd_tipo_anotacion IS 'Tipo de la anotaci�n';
COMMENT ON COLUMN sir_asientos_registrales.ds_tipo_anotacion IS 'Descripci�n del tipo de anotaci�n';
COMMENT ON COLUMN sir_asientos_registrales.cd_tipo_registro IS 'Tipo de registro';
COMMENT ON COLUMN sir_asientos_registrales.cd_doc_fisica IS 'Indica si el fichero va acompa�ado de documentaci�n f�sica';
COMMENT ON COLUMN sir_asientos_registrales.ds_observaciones IS 'Observaciones recogidas por el funcionario del registro';
COMMENT ON COLUMN sir_asientos_registrales.cd_prueba IS 'Indica si el asiento registral es una prueba';
COMMENT ON COLUMN sir_asientos_registrales.cd_ent_reg_inicio IS 'C�digo de la entidad registral de inicio';
COMMENT ON COLUMN sir_asientos_registrales.ds_ent_reg_inicio IS 'Descripci�n de la entidad registral de inicio';
COMMENT ON COLUMN sir_asientos_registrales.ds_expone IS 'Exposici�n de los hechos y antecedentes relacionados con la solicitud';
COMMENT ON COLUMN sir_asientos_registrales.ds_solicita IS 'Descripci�n del objeto de la solicitud';
COMMENT ON COLUMN sir_asientos_registrales.cd_error IS 'C�digo del error';
COMMENT ON COLUMN sir_asientos_registrales.ds_error IS 'Descripci�n del error';

ALTER TABLE sir_asientos_registrales ADD CONSTRAINT pk_areg PRIMARY KEY(id);
CREATE INDEX ix_aregs_erint ON sir_asientos_registrales(cd_ent_reg, cd_intercambio);

--
-- Interesados de asientos registrales
--

CREATE SEQUENCE sir_interesados_seq;

CREATE TABLE sir_interesados (
  id integer NOT NULL,
  id_asiento_registral integer NOT NULL,
  cd_tipo_identificador varchar(1),
  ds_identificador varchar(17),
  ds_razon_social varchar(80),
  ds_nombre varchar(30),
  ds_apellido1 varchar(30),
  ds_apellido2 varchar(30),
  cd_pais varchar(4),
  cd_provincia varchar(2),
  cd_municipio varchar(5),
  ds_direccion varchar(160),
  cd_postal varchar(5),
  ds_email varchar(160),
  ds_telefono varchar(20),
  ds_deu varchar(160),
  cd_canal_pref varchar(2),
  cd_tipo_identificador_rep varchar(1),
  ds_identificador_rep varchar(17),
  ds_razon_social_rep varchar(80),
  ds_nombre_rep varchar(30),
  ds_apellido1_rep varchar(30),
  ds_apellido2_rep varchar(30),
  cd_pais_rep varchar(4),
  cd_provincia_rep varchar(2),
  cd_municipio_rep varchar(5),
  ds_direccion_rep varchar(160),
  cd_postal_rep varchar(5),
  ds_email_rep varchar(160),
  ds_telefono_rep varchar(20),
  ds_deu_rep varchar(160),
  cd_canal_pref_rep varchar(2),
  ds_observaciones varchar(160)
);

COMMENT ON COLUMN sir_interesados.id IS 'Identificador del interesado';
COMMENT ON COLUMN sir_interesados.id_asiento_registral IS 'Identificador del asiento registral';
COMMENT ON COLUMN sir_interesados.cd_tipo_identificador IS 'C�digo del tipo de identificador del interesado';
COMMENT ON COLUMN sir_interesados.ds_identificador IS 'Identificador del interesado';
COMMENT ON COLUMN sir_interesados.ds_razon_social IS 'Raz�n social para el caso en el que el interesado sea persona jur�dica';
COMMENT ON COLUMN sir_interesados.ds_nombre IS 'Nombre del interesado';
COMMENT ON COLUMN sir_interesados.ds_apellido1 IS 'Primer apellido del interesado';
COMMENT ON COLUMN sir_interesados.ds_apellido2 IS 'Segundo apellido del interesado';
COMMENT ON COLUMN sir_interesados.cd_pais IS 'C�digo del pa�s del interesado';
COMMENT ON COLUMN sir_interesados.cd_provincia IS 'C�digo de la provincia del interesado';
COMMENT ON COLUMN sir_interesados.cd_municipio IS 'C�digo del municipio del interesado';
COMMENT ON COLUMN sir_interesados.ds_direccion IS 'Direcci�n postal del interesado';
COMMENT ON COLUMN sir_interesados.cd_postal IS 'C�digo postal del interesado';
COMMENT ON COLUMN sir_interesados.ds_email IS 'Direcci�n de correo electr�nico del interesado';
COMMENT ON COLUMN sir_interesados.ds_telefono IS 'Tel�fono de contacto del interesado';
COMMENT ON COLUMN sir_interesados.ds_deu IS 'Direcci�n electr�nica habilitada del interesado';
COMMENT ON COLUMN sir_interesados.cd_canal_pref IS 'Canal preferente de notificaci�n del interesado';
COMMENT ON COLUMN sir_interesados.cd_tipo_identificador_rep IS 'C�digo del tipo de identificador del representante';
COMMENT ON COLUMN sir_interesados.ds_identificador_rep IS 'Identificador del representante';
COMMENT ON COLUMN sir_interesados.ds_razon_social_rep IS 'Raz�n social para el caso en el que el representante sea persona jur�dica';
COMMENT ON COLUMN sir_interesados.ds_nombre_rep IS 'Nombre del representante';
COMMENT ON COLUMN sir_interesados.ds_apellido1_rep IS 'Primer apellido del representante';
COMMENT ON COLUMN sir_interesados.ds_apellido2_rep IS 'Segundo apellido del representante';
COMMENT ON COLUMN sir_interesados.cd_pais_rep IS 'C�digo del pa�s del representante';
COMMENT ON COLUMN sir_interesados.cd_provincia_rep IS 'C�digo de la provincia del representante';
COMMENT ON COLUMN sir_interesados.cd_municipio_rep IS 'C�digo del municipio del representante';
COMMENT ON COLUMN sir_interesados.ds_direccion_rep IS 'Direcci�n postal del representante';
COMMENT ON COLUMN sir_interesados.cd_postal_rep IS 'C�digo postal del representante';
COMMENT ON COLUMN sir_interesados.ds_email_rep IS 'Direcci�n de correo electr�nico del representante';
COMMENT ON COLUMN sir_interesados.ds_telefono_rep IS 'Tel�fono de contacto del representante';
COMMENT ON COLUMN sir_interesados.ds_deu_rep IS 'Direcci�n electr�nica habilitada del representante';
COMMENT ON COLUMN sir_interesados.cd_canal_pref_rep IS 'Canal preferente de notificaci�n del representante';
COMMENT ON COLUMN sir_interesados.ds_observaciones IS 'Observaciones del interesado y/o del representante';

ALTER TABLE sir_interesados ADD CONSTRAINT pk_int PRIMARY KEY(id);
ALTER TABLE sir_interesados ADD CONSTRAINT fk_int_areg FOREIGN KEY (id_asiento_registral) REFERENCES sir_asientos_registrales (id);
CREATE INDEX fki_int_areg ON sir_interesados(id_asiento_registral);


--
-- Anexos de asientos registrales
--

CREATE SEQUENCE sir_anexos_seq;

CREATE TABLE sir_anexos (
  id integer NOT NULL,
  id_asiento_registral integer NOT NULL,
  cd_id_fichero varchar(50),
  ds_nombre_fichero varchar(80) NOT NULL,
  cd_validez varchar(2),
  cd_tipo_documento varchar(2) NOT NULL,
  certificado blob,
  validacion_ocsp blob,
  firma blob,
  ts_fichero blob,
  hash blob,
  tipo_mime varchar(128),
  --contenido clob,
  uid_dm varchar(128),
  id_fichero_firmado integer,
  cd_id_documento_firmado varchar(50),
  ds_observaciones varchar(50)
);

COMMENT ON COLUMN sir_anexos.id IS 'Identificador del anexo';
COMMENT ON COLUMN sir_anexos.id_asiento_registral IS 'Identificador del asiento registral';
COMMENT ON COLUMN sir_anexos.cd_id_fichero IS 'Identificador del fichero intercambiado';
COMMENT ON COLUMN sir_anexos.ds_nombre_fichero IS 'Nombre del fichero original del documento';
COMMENT ON COLUMN sir_anexos.cd_validez IS 'Validez del documento';
COMMENT ON COLUMN sir_anexos.cd_tipo_documento IS 'C�digo del tipo de documento';
COMMENT ON COLUMN sir_anexos.certificado IS 'Certificado del fichero anexo';
COMMENT ON COLUMN sir_anexos.validacion_ocsp IS 'Validaci�n OCSP del certificado';
COMMENT ON COLUMN sir_anexos.firma IS 'Firma electr�nica del fichero anexo';
COMMENT ON COLUMN sir_anexos.ts_fichero IS 'Sello de tiempo del fichero anexo';
COMMENT ON COLUMN sir_anexos.hash IS 'Huella binaria del fichero anexo';
COMMENT ON COLUMN sir_anexos.tipo_mime IS 'Tipo MIME del fichero anexo';
--COMMENT ON COLUMN sir_anexos.contenido IS 'Contenido del anexo';
COMMENT ON COLUMN sir_anexos.uid_dm IS 'UID del contenido del anexo en el gestor documental';
COMMENT ON COLUMN sir_anexos.id_fichero_firmado IS 'Identificador (id) del fichero firmado';
COMMENT ON COLUMN sir_anexos.cd_id_documento_firmado IS 'Identificador (cd_id_fichero) del documento firmado';
COMMENT ON COLUMN sir_anexos.ds_observaciones IS 'Observaciones del fichero adjunto';

ALTER TABLE sir_anexos ADD CONSTRAINT pk_sir_anexos PRIMARY KEY(id);
ALTER TABLE sir_anexos ADD CONSTRAINT fk_sir_anexos_areg FOREIGN KEY (id_asiento_registral) REFERENCES sir_asientos_registrales (id);
CREATE INDEX fki_sir_anexos_asiento ON sir_anexos(id_asiento_registral);


--
-- Contadores para los c�digos
--

CREATE TABLE sir_contadores (
  cd_ent_reg varchar(21) NOT NULL,
  tipo integer NOT NULL,
  contador integer NOT NULL
);

COMMENT ON COLUMN sir_contadores.cd_ent_reg IS 'C�digo de la entidad registral';
COMMENT ON COLUMN sir_contadores.tipo IS 'Tipo de contador';
COMMENT ON COLUMN sir_contadores.contador IS 'Contador';

ALTER TABLE sir_contadores ADD CONSTRAINT pk_sir_contadores PRIMARY KEY(cd_ent_reg,tipo);


--
-- Configuraci�n
--

CREATE SEQUENCE sir_config_seq;

CREATE TABLE sir_configuracion (
  id integer NOT NULL,
  nombre varchar(250) NOT NULL,
  descripcion clob,
  valor clob
);

COMMENT ON COLUMN sir_configuracion.id IS 'Identificador �nico del par�metro de configuraci�n';
COMMENT ON COLUMN sir_configuracion.nombre IS 'Nombre del par�metro de configuraci�n';
COMMENT ON COLUMN sir_configuracion.descripcion IS 'Descripci�n del par�metro de configuraci�n';
COMMENT ON COLUMN sir_configuracion.valor IS 'Valor del par�metro de configuraci�n';

ALTER TABLE sir_configuracion ADD CONSTRAINT pk_conf PRIMARY KEY(id);
CREATE UNIQUE INDEX ix_conf_n ON sir_configuracion(nombre);
