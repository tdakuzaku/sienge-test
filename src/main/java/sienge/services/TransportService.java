package sienge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportService implements TransportServiceInterface {

  @Autowired
  public TransportService() {
  }

  public Float shippingCalculation() {
	  return (float) 123.45;
  }
}
