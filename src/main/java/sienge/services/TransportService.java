package sienge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import sienge.models.RequestWrapper;

@Service
public class TransportService implements TransportServiceInterface {

  @Value("${transport.paved.cost}")
  private String pavedCost;
	
  @Autowired
  public TransportService() {
  }


  public Float shippingCalculation(RequestWrapper req) {
	  req.transport.setVehicle(req.vehicle);
	  req.transport.setRoadType("paved");
	  Float pavedCost = req.transport.costByDistance(req.pavedDistanceKm);
	  req.transport.setRoadType("dirt");
	  Float dirtCost = req.transport.costByDistance(req.dirtDistanceKm);
	  Float distanceCost = pavedCost + dirtCost;
	  Float vehicleCost = req.vehicle.getVehicleCost(distanceCost);
	  Float payloadCost = req.transport.costByPayload(req.pavedDistanceKm + req.dirtDistanceKm);
	  return vehicleCost + payloadCost;
  }
}
