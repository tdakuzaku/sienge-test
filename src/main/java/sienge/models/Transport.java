package sienge.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transports")
public class Transport implements Serializable {
  private static final long serialVersionUID = 1709299723906950395L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Vehicle vehicle;

  public Transport() {
  }

  public Transport(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public Vehicle getVehicle() {
	return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
  }

public String toString() {
    return "Transport[" + vehicle + "]";
  }
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
  
  public Float costByDistance(Float km, Float cost) {
	  return km * cost;
  }
  
  public Float costByVehicleType(Float cost) {
	  return this.vehicle.getCostByKm() * cost;
  }
  
  public Float costByPayload(Integer max, Float cost) {
	  return (max - this.vehicle.getPayload()) * cost;
  }
}
