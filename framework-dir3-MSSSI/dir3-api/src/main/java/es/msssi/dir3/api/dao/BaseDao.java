/*
* Copyright 2016 Ministerio de Sanidad, Servicios Sociales e Igualdad 
* Licencia con arreglo a la EUPL, Versi�n 1.1 o �en cuanto sean aprobadas por laComisi�n Europea� versiones posteriores de la EUPL (la �Licencia�); 
* Solo podr� usarse esta obra si se respeta la Licencia. 
* Puede obtenerse una copia de la Licencia en: 
* http://joinup.ec.europa.eu/software/page/eupl/licence-eupl 
* Salvo cuando lo exija la legislaci�n aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye �TAL CUAL�, SIN GARANT�AS NI CONDICIONES DE NING�N TIPO, ni expresas ni impl�citas. 
* V�ase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia. 
*/

package es.msssi.dir3.api.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import es.msssi.dir3.api.type.CriterionEnum;
import es.msssi.dir3.core.vo.Entity;

/**
 * Interfaz gen�rico para acceso a datos.
 * 
 * @author cmorenog
 * 
 * @param <T>
 *            tipo de entidad a gestionar.
 * @param <tId>
 *            tipo de la clave primaria de la entidad.
 * @param <C>
 *            tipo de criterio para la b�squeda.
 */
public interface BaseDao<T extends Entity, tId, C extends CriterionEnum> {
    /**
     * M�todo gen�rico para guardar un objeto.
     * 
     * @param anEntity
     *            la entidad a guardar.
     * @throws SQLException
     */
    public void save(
	T anEntity)
	throws SQLException;

    /**
     * M�todo gen�rico para actualizar un objeto de la clase dada.
     * 
     * @param anEntity
     *            entidad a guardar.
     * @throws SQLException .
     */
    public void update(
	T anEntity)
	throws SQLException;

    /**
     * M�todo gen�rico para recuperar un objeto bas�ndonos en su clase e
     * identificador.
     * 
     * @param anId
     *            identificador del objeto a recuperar.
     * @return el objeto recuperado de tipo T.
     * @throws SQLException .
     */
    public T get(
	tId anId)
	throws SQLException;

    /**
     * Comprueba la existencia de un objeto de tipo Entity con el identificador
     * dado.
     * 
     * @param anId
     *            identificador del objeto.
     * @return <code>true</code> si el objeto existe, <code>false</code> en caso
     *         contrario.
     * @throws SQLException .
     */
    public boolean exists(
	tId anId)
	throws SQLException;

    /**
     * Inicia una transacci�n.
     * 
     * @throws SQLException .
     */
    public void startTransaction()
	throws SQLException;

    /**
     * Realiza commit en una transacci�n.
     * 
     * @throws SQLException .
     */
    public void commitTransaction()
	throws SQLException;

    /**
     * Cierra una transacci�n.
     */
    public void endTransaction();

    /**
     * Devuelve el objeto sqlMapclient.
     * 
     * @return sqlmapclient.
     */
    public SqlMapClient getSqlMapClient();

    /**
     * Guarda el objeto sqlmapclient.
     */
    public void setSqlMapClient(
	SqlMapClient sqlMapClient);
}