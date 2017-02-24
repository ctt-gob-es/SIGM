package ieci.tecdoc.sgm.core.services.telematico;

import java.util.Date;

/**
 * Bean que representa a un registro del sistema.
 * 
 * @author IECISA
 *
 */
public class Registro
{
   public Registro()
   {
      registryNumber = "";
      registryDate = null;
      effectiveDate = null;
      senderId = "";
      name = "";
      //surName = "";
      eMail = "a";
      topic = "a";
      addressee = "a";
      status = RegistroEstado.STATUS_ERROR;
      senderIdType=0;
      additionalInfo = null;
      
   }

	/**
	 * Establece el n�mero de registro.
	 * @param registryNumber N�mero de registro.
	 */
   public  void setRegistryNumber(String registryNumber)
   {
      this.registryNumber = registryNumber;
   }

   /**
    * Establece la fecha de registro.
    * @param registryDate Fecha de registro.
    */   
   public void setRegistryDate(Date registryDate)
   {
      this.registryDate = registryDate;
   }
   
   /**
    * Establece la fecha efectiva de registro.
    * @param registryDate Fecha efectiva de registro.
    */   
   public void setEffectiveDate(Date effectiveDate)
   {
      this.effectiveDate = effectiveDate;
   }

   /**
    * Establece el identificador (NIF, CIF, etc) del ciudadano.
    * @param senderId Identificador de usuario.
    */
   public void setSenderId(String senderId)
   {
   	  this.senderId = senderId;
   }

   /**
    * Establece el nombre de pila del ciudadano.
    * @param name Nombre de pila del ciudadano.
    */   
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
    * Establece los apellidos del ciudadano.
    * @param surName Apellidos del ciudadano.
    */      
   /*public void setSurName(String surName)
   {
      this.surName = surName;
   }*/
   
   /**
    * Establece el email del cidadano.
    * @param eMail Email del ciudadano.
    */      
   public void setEMail(String eMail)
   {
      this.eMail = eMail;
   }

   /**
    * Objeto del registro.
    * @param topic Objeto del registro.
    */
   public void setTopic(String topic)
   {
      this.topic = topic;
   }

   /**
    * Establece el organismo destinatario del registro.
    * @param addressee Identificador de organismo destinatario.
    */   
   public void setAddressee(String addressee)
   {
   	  this.addressee = addressee;
   }

   /**
    * Establece el estado del registro.
    * @param status Estado del registro.
    */   
   public void setStatus(int status)
   {
   	  this.status = status;
   }
   
   /**
    * Establece el tipo de identificaci�n del ciudadano.
    * @param senderIdType Tipo de identificaci�n del ciudadano.
    */      
   public void setSenderIdType(int senderIdType) {
   	  this.senderIdType = senderIdType;
   }

   /**
    * Establece el n� de documento de identificaci�n del representado.
    * @param representedId N� de documento de identificaci�n del representado.
    */
   public void setRepresentedId(String representedId) {
     this.representedId = representedId;
   }

   /**
    * Establece el nombre del representado.
    * @param representedName Nombre del representado.
    */
   public void setRepresentedName(String representedName) {
      this.representedName = representedName;
   }
   
   /**
    * Establece la oficina del registro.
    * @param oficina Identificador de la oficina del registro.
    */
   public void setOficina(String oficina) {
      this.oficina = oficina;
   }
   
   /**
    * Establece el n�mero de expediente asociado a un registro.
    * @param numeroExpediente N�mero del expediente.
    */
   public void setNumeroExpediente(String numeroExpediente) {
      this.numeroExpediente = numeroExpediente;
   }
   
   /**
    * Devuelve el n�mero de registro.
    * @return String n�mero de registro.
    */   
   public String getRegistryNumber()
   {
      return this.registryNumber;
   }

   /**
    * Devuelve la fecha del registro.
    * @return Timestamp fecha del registro.
    */
   public Date getRegistryDate()
   {
   	  return this.registryDate;
   }
   
   /**
    * Devuelve la fecha efectiva del registro.
    * @return Date fecha efectiva del registro.
    */
   public Date getEffectiveDate()
   {
   	  return this.effectiveDate;
   }

   /**
    * Devuevle el identificador del ciudadano.
    * @return String identificador del ciudadano.
    */   
   public String getSenderId()
   {
   	  return this.senderId;
   }

   /**
    * Devuelve el nombre de pila del ciudadano.
    * @return String Nombre de pila del ciudadano.
    */   
   public String getName()
   {
      return name;
   }
   
   /**
    * Devuelve los apellidos del ciudadano.
    * @return String Apellidos del ciudadano.
    */      
   /*public String getSurName()
   {
      return surName;
   }*/
   
   /**
    * Devuelve el email del ciudadano.
    * @return String Email del ciudadano.
    */      
   public String getEMail()
   {
      return eMail;
   }

   /**
    * Devuelve el objeto del registro.
    * @return String Objeto del registro.
    */   
   public String getTopic()
   {
      return this.topic;
   }

   /**
    * Devuelve el organismo destinatario del registro.
    * @return String identificador del organismo destinatario.
    */   
   public String getAddressee()
   {
   	  return this.addressee;
   }

   /**
    * Devuelve el estado del registro.
    * @return int Estado del registro.
    */   
   public int getStatus()
   {
   	  return this.status;
   }

   /**
    * Devuelve el tipo de identificador del ciudadano.
    * @return int Tipo de identificaci�n del ciudadano.
    */   
   public int getSenderIdType() {
      return senderIdType;
   }
   
   /**
    * Devuelve el n� de documento de identificaci�n del representado.
    * @return String id de documento de identificaci�n del representado.
    */
   public String getRepresentedId() {
     return representedId;
   }
   /**
    * Devuelve el nombre del representado.
    * @return String nombre del representado.
    */
   public String getRepresentedName() {
       return representedName;
   }
   
   /**
    * Establece la info adicional.
    * @param additionalInfo la info adicional.
    */   
   public void setAdittionalInfo(byte[] additionalInfo){
	   this.additionalInfo = additionalInfo;
   }
   
   /**
    * Devuelve la oficina del registro.
    * @return String Identificador de la oficina.
    */
   public String getOficina() {
     return oficina;
   }
   
   /**
    * Devuelve el n�mero de expediente asociado al registro.
    * @return String N�mero de expediente asociado al registro.
    */
   public String getNumeroExpediente() {
     return numeroExpediente;
   }
   
   /**
    * Devuelve la info adicional.
    * @return byte[] La info adicional.
    */   
   public byte[] getAdditionalInfo(){
	   return additionalInfo;
   }
   
   /**
    * Devuelve el idioma del registro
    * @return String Idioma
    */
   public String getIdioma() {
		return idioma;
	}
   /**
    * Establece el idioma del registro
    * @param idioma
    */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

   protected String registryNumber;
   protected Date registryDate;
   protected Date effectiveDate;
   protected String senderId;
   protected String name;
   //protected String surName;
   protected String eMail;
   protected String topic;
   protected String addressee;
   protected int status;
   protected int senderIdType;
   protected String representedName;
   protected String representedId;
   protected byte[] additionalInfo;
   protected String oficina;
   protected String numeroExpediente;
   protected String idioma;


}