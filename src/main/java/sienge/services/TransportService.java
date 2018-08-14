package sienge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sienge.models.Transport;

@Service
public class TransportService implements TransportServiceInterface {

  @Autowired
  public TransportService() {
  }

  public Float shippingCalculation(Transport t) {
	  System.out.print(t);
	  return (float) 123.45;
  }
}
