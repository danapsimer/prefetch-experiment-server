package com.bluesoft.test.prefetch;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author danap
 */
@WebService(name="PrefetchExperiment",targetNamespace="http://bluesoft.com/ws/prefetch")
@SOAPBinding(
  style=SOAPBinding.Style.DOCUMENT,
  use=SOAPBinding.Use.LITERAL,
  parameterStyle=SOAPBinding.ParameterStyle.BARE)
public interface PrefetchExperimentService {
  @WebMethod
  PrefetchExperimentResponse ping(@WebParam(name="request") PrefetchExperimentRequest request);
}
