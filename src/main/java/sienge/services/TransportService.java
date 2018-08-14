package sienge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import sienge.models.RequestWrapper;
import sienge.models.Transport;
import sienge.models.Vehicle;

@Service
public class TransportService implements TransportServiceInterface {

  @Value("${transport.paved.cost}")
  private String pavedCost;
	
  @Autowired
  public TransportService() {
  }

  public Float shippingCalculation(RequestWrapper req) {
	  Vehicle v = new Vehicle((float) 10, 5);
	  Transport t = new Transport();
	  t.setVehicle(v);
	  Float distancePavedCost = t.costByDistance((float) 1, (float) 1);
	  Float distanceDirtCost = t.costByDistance((float) 10, (float) 2);
	  Float vehicleCost = t.costByDistance((float) 100, (float) 3);
	  Float payloadCost = t.costByPayload(5, (float) 4);
	  return distancePavedCost + distanceDirtCost + vehicleCost + payloadCost;
  }
}
