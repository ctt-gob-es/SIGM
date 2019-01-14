package es.minhap.seap.ssweb.demoorve;

public class WSExportacionPortTypeProxy implements es.minhap.seap.ssweb.demoorve.WSExportacionPortType {
  private String _endpoint = null;
  private es.minhap.seap.ssweb.demoorve.WSExportacionPortType wSExportacionPortType = null;
  
  public WSExportacionPortTypeProxy() {
    _initWSExportacionPortTypeProxy();
  }
  
  public WSExportacionPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSExportacionPortTypeProxy();
  }
  
  private void _initWSExportacionPortTypeProxy() {
    try {
      wSExportacionPortType = (new es.minhap.seap.ssweb.demoorve.WSExportacionServiceLocator()).getWSExportacionPort();
      if (wSExportacionPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSExportacionPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSExportacionPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSExportacionPortType != null)
      ((javax.xml.rpc.Stub)wSExportacionPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public es.minhap.seap.ssweb.demoorve.WSExportacionPortType getWSExportacionPortType() {
    if (wSExportacionPortType == null)
      _initWSExportacionPortTypeProxy();
    return wSExportacionPortType;
  }
  
  public es.minhap.seap.ssweb.demoorve.ObtenerIdentificaoresRespuestaWS obtenerIdentificadores(es.minhap.seap.ssweb.demoorve.holders.SecurityHolder security, es.minhap.seap.ssweb.demoorve.FiltrosIdentificadores filtros) throws java.rmi.RemoteException{
    if (wSExportacionPortType == null)
      _initWSExportacionPortTypeProxy();
    return wSExportacionPortType.obtenerIdentificadores(security, filtros);
  }
  
  public es.minhap.seap.ssweb.demoorve.ObtenerRegistroRespuestaWS obtenerRegistro(es.minhap.seap.ssweb.demoorve.holders.SecurityHolder security, int identificador) throws java.rmi.RemoteException{
    if (wSExportacionPortType == null)
      _initWSExportacionPortTypeProxy();
    return wSExportacionPortType.obtenerRegistro(security, identificador);
  }
  
  
}