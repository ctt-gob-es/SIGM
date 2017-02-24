package ieci.tecdoc.sgm.core.services.catalogo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Conetendor de �rganos destinatarios
 *
 */
public class OrganosDestinatarios implements Serializable
{
    private ArrayList addressees;

    /**
     * Constructor de la clase OrganosDestinatarios
     *
     */
    public OrganosDestinatarios()
    {
      addressees = new ArrayList();
    }

    /**
     * Devuelve el n�mero de �rganos destinatarios de la colecci�n
     * @return
     */
    public int count() {
       return addressees.size();
    }

    /**
     * Devuelve el �rgano destinatario que se encuentra en la posici�n indicada.
     * @param index Posici�n del �rgano destinatario dentro de la colecci�n.
     * @return DocumentExt Documento.
     */
    public OrganoDestinatario get(int index) {
       return (OrganoDestinatario) addressees.get(index);
    }

    /**
     * A�ade un nuevo �rgano destinatario a la colecci�n
     * @param document Nuevo �rgano destinatario a a�adir.
     */
    public void add(OrganoDestinatario addressee) {
      addressees.add(addressee);
    }
  
}
