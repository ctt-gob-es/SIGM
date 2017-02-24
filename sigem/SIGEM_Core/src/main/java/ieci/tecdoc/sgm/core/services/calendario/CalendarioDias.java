package ieci.tecdoc.sgm.core.services.calendario;

import java.util.ArrayList;

/**
 * Contenedor de dias festivos
 *
 */
public class CalendarioDias
{
    private ArrayList dias;

    /**
     * Constructor de la clase CalendarioDias
     *
     */
    public CalendarioDias()
    {
    	dias = new ArrayList();
    }

    /**
     * Devuelve el n�mero de dias festivos de la colecci�n
     * @return
     */
    public int count() {
       return dias.size();
    }

    /**
     * Devuelve el dia festivo que se encuentra en la posici�n indicada.
     * @param index Posici�n del conector dentro de la colecci�n.
     * @return CalendarioDia Dia festivo.
     */
    public CalendarioDia get(int index) {
       return (CalendarioDia) dias.get(index);
    }

    /**
     * A�ade un nuevo dia festivo a la colecci�n
     * @param dia Nuevo dia festivo a a�adir.
     */
    public void add(CalendarioDia dia) {
      dias.add(dia);
    }
}

