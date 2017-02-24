package ieci.tecdoc.sgm.core.services.catalogo;

import java.util.ArrayList;

/**
 * Contenedor de tipos de conectores
 *
 */
public class TiposConectores
{
    private ArrayList hooktypes;

    /**
     * Constructor de la clase TiposConectores
     *
     */
    public TiposConectores()
    {
      hooktypes = new ArrayList();
    }

    /**
     * Devuelve el n�mero de tipos de conectores de la colecci�n
     * @return
     */
    public int count() {
       return hooktypes.size();
    }

    /**
     * Devuelve el tipo de conector que se encuentra en la posici�n indicada.
     * @param index Posici�n del tipo de conector dentro de la colecci�n.
     * @return Hook Conector.
     */
    public TipoConector get(int index) {
       return (TipoConector) hooktypes.get(index);
    }

    /**
     * A�ade un nuevo tipo de conector a la colecci�n
     * @param hook Nuevo tipo de conector a a�adir.
     */
    public void add(TipoConector hookType) {
      hooktypes.add(hookType);
    }

}

