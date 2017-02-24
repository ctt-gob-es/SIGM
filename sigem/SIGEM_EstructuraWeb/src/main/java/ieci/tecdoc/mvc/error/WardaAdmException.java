/*
 * Created on 21-oct-2005
 *
 */
package ieci.tecdoc.mvc.error;

import ieci.tecdoc.core.exception.IeciTdException;
import ieci.tecdoc.idoc.core.exception.ResourceMessage;

/**
 * @author Antonio Mar�a
 *
 */
public class WardaAdmException {

    public static void throwException(long errorCode) throws IeciTdException
    {
       throw new IeciTdException(Long.toString(errorCode), ResourceMessage.getMessage(errorCode, "resources.errors"));
    }
    private WardaAdmException()
    {
    }
}
