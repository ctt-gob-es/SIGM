/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package ieci.tecdoc.sgm.core.services.telematico;

import java.util.ArrayList;

/**
 * Contenedor de documentos adjuntos a la solicitud de registro.
 * 
 * @author IECISA
 *
 */
public class Solicitantes
{
   private ArrayList solicitantes;

   public Solicitantes()
   {
	   solicitantes = new ArrayList();
   }
   
   /**
    * Devuelve el n�mero de documentos contenidos en la colecci�n.
    * @return int N�mero de documentos de la colecci�n.
    */   
   public int count()
   {
      return solicitantes.size();
   }
   
   /**
    * Devuelve el documento de la posici�n indicada.
    * @param index Posici�n del documento dentro de la colecci�n.
    * @return RequestDocument Documento solicitado.
    */   
   public Solicitante get(int index)
   {
      return (Solicitante)solicitantes.get(index);
   }
   
   /**
    * A�ade un nuevo documento adjunto a la solicitud de registro a la colecci�n.
    * @param document Nuevo documento a a�adir a la colecci�n.
    */   
   public void add(Solicitante solicitante) 
   {
	   solicitantes.add(solicitante);
   }
    
}