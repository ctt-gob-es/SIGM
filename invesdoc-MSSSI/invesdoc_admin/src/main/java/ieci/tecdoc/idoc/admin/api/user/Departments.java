package ieci.tecdoc.idoc.admin.api.user;

import ieci.tecdoc.idoc.admin.internal.DepartmentsImpl;


/**
 * Maneja la lista de departamentos invesDoc.
 */
public class Departments
{
	/**
    * Construye un objeto de la clase.
    *  
    */

   public Departments()
   {
   	_departmentsImpl = new DepartmentsImpl();
   }

   /**
    * Devuelve el n�mero de departamentos.
    * 
    * @return El n�mero de departamento mencionado.
    */

   public int count() 
   {
      return _departmentsImpl.count();
   }

   /**
    * Carga la lista de departamentos con su informaci�n b�sica.
    * 
    * @throws Exception Si se produce alg�n error en la carga de los departamentos.
    */

   public void loadLite() throws Exception 
   {
   	_departmentsImpl.load();
   }

   /**
    * Carga la lista de departamentos de un mismo padre con su informaci�n
    * b�sica.
    *  
    * @param parentId Identificador de padre
    * @throws Exception  Si se produce alg�n error en la carga de los departamentos.
    */
   public void loadLite(int parentId) throws Exception
   {
      _departmentsImpl.load(parentId);
   }
   /**
    * Devuelve un departamento de la lista.
    * 
    * @param index Indice del departamento que se desea recuperar.
    * 
    * @return El departamento mencionado.
    */

   public Department getDepartment(int index) 
   {
      return _departmentsImpl.get(index);
   }
   
   /**
    * Obtiene la informaci�n de la lista de departamentos en formato XML.
    *  
    * @return La lista de departamentos mencionada.
    */

   public String toXML()
   {
      return _departmentsImpl.toXML(true);
   }

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *  
    * @return La representaci�n mencionada.
    */

	public String toString()
   {
      return _departmentsImpl.toString();
   }


   private DepartmentsImpl _departmentsImpl;
}
