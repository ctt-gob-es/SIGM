package ieci.tecdoc.sgm.core.services.catalogo;

import java.util.ArrayList;

/**
 * Contenedor de conectores
 *
 */
public class Conectores
{
    private ArrayList hooks;

    /**
     * Constructor de la clase conectores
     *
     */
    public Conectores()
    {
      hooks = new ArrayList();
    }

    /**
     * Devuelve el n�mero de conectores de la colecci�n
     * @return
     */
    public int count() {
       return hooks.size();
    }

    /**
     * Devuelve el conector que se encuentra en la posici�n indicada.
     * @param index Posici�n del conector dentro de la colecci�n.
     * @return Hook Conector.
     */
    public Conector get(int index) {
       return (Conector) hooks.get(index);
    }

    /**
     * A�ade un nuevo conector a la colecci�n
     * @param hook Nuevo conector a a�adir.
     */
    public void add(Conector hook) {
      hooks.add(hook);
    }
}

