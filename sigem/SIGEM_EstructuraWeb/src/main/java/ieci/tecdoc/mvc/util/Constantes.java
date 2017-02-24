/*
 * Created on 15-mar-2005
 *
 */
package ieci.tecdoc.mvc.util;


/**
 * @author Antonio Mar�a
 *
 */
public class Constantes {
    
    public static final byte PERSON = 1;
    public static final byte GROUP = 2;
    public static final byte ORGANIZATIONAL_UNIT = 4;
    public static final byte OTHER = 16;
    public static final byte DEPARTAMENT = 32;
    
    public static final byte REPOSITORIES = 1;
    public static final byte LIST = 2;
    public static final byte VOLUME = 4;
    
    public static final byte DIRECTORY = 1;
    public static final byte ARCHIVE = 2;
    
    public static final String TOKEN_ICON_PERSON_BD= "/StaticEstructuraWeb/resources/include/images/userBd.gif"; 
    public static final String TOKEN_ICON_GROUP_BD= "/StaticEstructuraWeb/resources/include/images/groupBd.gif";
    public static final String TOKEN_ICON_DEPARTAMENTS= "/StaticEstructuraWeb/resources/include/images/departament.gif";
    
    public static final String TOKEN_ICON_PERSON_LDAP ="/StaticEstructuraWeb/resources/include/images/person.gif";
    public static final String TOKEN_ICON_GROUP_LDAP ="/StaticEstructuraWeb/resources/include/images/group.gif";
    public static final String TOKEN_ICON_ORGANIZATIONAL_UNIT="/StaticEstructuraWeb/resources/include/images/ou.gif";
    public static final String TOKEN_ICON_OTHER="/StaticEstructuraWeb/resources/include/images/other.gif";

    public static final String TOKEN_ICON_REPOSITORIES = "/StaticEstructuraWeb/resources/include/images/repositorio.gif";
    public static final String TOKEN_ICON_LIST = "/StaticEstructuraWeb/resources/include/images/lista.gif";
    public static final String TOKEN_ICON_VOLUME = "/StaticEstructuraWeb/resources/include/images/volumen.gif";
    
    public static final String TOKEN_ICON_ARCH_ROOT= "/StaticEstructuraWeb/resources/include/images/ArchRoot.gif";
    public static final String TOKEN_ICON_ARCH_DIR= "/StaticEstructuraWeb/resources/include/images/ArchDir.gif";
    public static final String TOKEN_ICON_ARCH_ARCH= "/StaticEstructuraWeb/resources/include/images/ArchArch.gif";
    
    public static final String TOKEN_USER_CONNECTED = "user";
    
    public static final String SHORT_TEXT_TOKEN    = "Texto";   
    public static final String LONG_TEXT_TOKEN     = "Texto largo";
    
    public static final String SHORT_INTEGER_TOKEN = "Entero";   
    public static final String LONG_INTEGER_TOKEN  = "Entero largo";
    
    public static final String SHORT_DECIMAL_TOKEN = "Decimal";
    public static final String LONG_DECIMAL_TOKEN  = "Decimal largo";
    public static final String DATE_TIME_TOKEN     = "Fecha y hora";
    public static final String DATE_TOKEN  = "Fecha";
    public static final String TIME_TOKEN  = "Hora";
     
    
    public static final int DATE = 7;
    public static final int TIME = 8;
    public static final int DATE_TIME  = 9;
    public static final String VOL_LIST_TYPE_NONE= "Sin almacenamiento";
    public static final String VOL_LIST_TYPE_STATIC = "Est�tico";
    public static final String VOL_LIST_TYPE_DYNAMIC = "Din�mico";
    
    public static final String TOKEN_PERM_QUERY = "Consulta";
    public static final String TOKEN_PERM_UPDATE = "Modificaci�n";
    public static final String TOKEN_PERM_CREATION = "Creaci�n";
    public static final String TOKEN_PERM_DELETION = "Borrado";
    
    // Resources
    public static final String MESSAGES_API_ERRORS = "api_errors";
    public static final String MESSAGES_GENERAL_ERRORS = "general_errors";
    
    
    
    // public static final int EC_OBJ_NOT_EXITS = 3001069;
    public static final String MAX_CHILDREN_LDAP = "maxChildrenLdap";
    public static final String HAS_FTS_CONFIG = "hasFtsConfig";
    public static final String USE_CERTIFICATE = "useCertificate";
    public static final String MULTISESSION_CERT_ERROR = "multisessionCertError";
    
    
    public static final int PROPERTIES = 1;
    public static final int EDITION = 2;
    public static final int NEW = 4;
    
    public static final String LDAP_SERVICE_USER_TREE = "serviceTreeUserLdap";
    public static final String LDAP_SERVICE_GROUP_TREE = "serviceTreeGroupLdap";
    public static final String LDAP_SERVICE_PROPERTIES_TREE_USER = "serviceTreePropertiesUserLdap";
    public static final String LDAP_SERVICE_PROPERTIES_TREE_GROUP = "serviceTreePropertiesGroupLdap";
    public static final String LDAP_START_USERS = "CN=Users";
    public static final int LDAP_TYPE_TREE_USER = 1;
    public static final int LDAP_TYPE_TREE_GROUP = 2;
    
}
