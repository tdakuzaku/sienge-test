package sienge.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "transports")
public class Transport implements Serializable {
  private static final long serialVersionUID = 1709299723906950395L;

  // TODO: dynamic properties read
  @Value("${transport.paved.cost}")
  private Float pavedCost;
  
  @Value("${transport.dirt.cost}")
  private Float dirtCost;
 
  @Value("${payload.max}")
  private Integer payloadMax;
  
  @Value("${payload.above.cost}")
  private Float payloadAboveCost;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Vehicle vehicle;
  
  private Float costPerKm;
  
  private String roadType;

  public Transport() {
	// TODO: dynamic properties
	this.payloadMax = 5;
	this.payloadAboveCost = 0.02f;
  }

  public Vehicle getVehicle() {
	return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
  }

  public String toString() {
    return "Transport[" + this.roadType + ", " + this.costPerKm + "]";
  }
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
  
  public Float costByDistance(Float km) {
	  // TODO: dynamic properties
	  switch(roadType) {
	  	case "paved":
	  		this.costPerKm = 0.54f;
	  		break;
	  	case "dirt":
	  		this.costPerKm = 0.62f;
	  		break;
		default:
			throw new IllegalArgumentException("Invalid road type " + roadType);
	  }
	  return km * this.costPerKm;
  }
  
  public Float costByPayload(Float km) {
	  Integer diff = this.vehicle.getPayload() - this.payloadMax;
	  if (diff > 0) {
		  return (this.payloadAboveCost * diff) * km;
	  }
	  return 0f;
  }

  public void setRoadType(String roadType) {
	  this.roadType = roadType;
  }
}
