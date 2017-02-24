--
-- Par�metros de configuraci�n por defecto
--

INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'WS_SIR1.url', 'http://pre-cct.redsara.es/services/WS_SIR1', 'URL del servicio web WS_SIR1 del SIR por defecto para todas las entidades registrales');
INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'WS_SIR6_A.url', 'http://localhost/CIR_P2P/services/WS_SIR6_A', 'URL del servicio web WS_SIR6_A del CIR por defecto para todas las entidades registrales');
INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'WS_SIR6_B.url', 'http://localhost/CIR_P2P/services/WS_SIR6_B', 'URL del servicio web WS_SIR6_B del CIR por defecto para todas las entidades registrales');
INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'WS_SIR7.url', 'http://localhost/CIR_P2P/services/WS_SIR7', 'URL del servicio web WS_SIR7 del CIR por defecto para todas las entidades registrales');

INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'envios.time-out', '86400000', 'Time-out (en milisegundos) para recibir el mensaje de respuesta (ACK o ERROR) tras el env�o de ficheros de datos de intercambio (ENV�O, REENV�O o RECHAZO).');
INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'envios.numeroReintentos', '5', 'N�mero de reintentos de env�o si no se recibe respuesta.');

INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'algoritmo.hash', 'SHA-1', 'Algoritmo de generaci�n del c�digo hash. Los valores posibles son: SHA-1, MD5');

INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'auditoria.ficherosIntercambio.activado', 'false', 'Indica si est� activada la auditor�a de ficheros de datos de intercambio entrantes y salientes. Los valores posibles son: true o false.');
INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'auditoria.ficherosIntercambio.contentTypeId', 'fwktdsir-auditoria-ficherosIntercambio', 'Identificador del tipo de contenido utilizado para almacenar los XMLs de los ficheros de intercambio en el gestor documental. Debe est�r configurado en el fichero "fwktd-dm-config.xml".');

INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'auditoria.mensajes.activado', 'false', 'Indica si est� activada la auditor�a de ficheros de datos de control entrantes y salientes. Los valores posibles son: true o false.');
INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'auditoria.mensajes.contentTypeId', 'fwktdsir-auditoria-mensajes', 'Identificador del tipo de contenido utilizado para almacenar los XMLs de los mensajes intercambiados en el gestor documental. Debe est�r configurado en el fichero "fwktd-dm-config.xml".');

INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'anexos.contentTypeId', 'fwktdsir', 'Identificador del tipo de contenido utilizado en la gesti�n documental. Debe est�r configurado en el fichero de configuraci�n fwktd-dm-config.xml.');

INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'validar.codigos.directorio.comun', 'false', 'Indica si hay que validar los c�digos de entidades registrales y unidades de tramitaci�n contra el directorio com�n. Valores: true o false (por defecto)');

INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'max.tama�o.anexos', '3145728', 'Tama�o m�ximo en bytes de cada fichero de intercambio. Si no se indica o el valor es 0, no se aplica l�mite alguno.');
INSERT INTO sir_configuracion (id, nombre, valor, descripcion) values (nextval('sir_config_seq'), 'max.num.anexos', '5', 'N�mero m�ximo de anexos de tipo 02 que puede tener un fichero de intercambio. Si no se indica o el valor es 0, no se aplica l�mite alguno.');
