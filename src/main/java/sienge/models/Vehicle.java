package sienge.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {
  private static final long serialVersionUID = 1709299723906950395L;

  // TODO: dynamic properties read
  @Value("${vehicle.truck_trunk.cost}")
  private Float truckTrunkCost;  
  
  @Value("${vehicle.bucket_truck.cost}")
  private Float bucketTruckCost;
  
  @Value("${vehicle.cart.cost}")
  private Float cartCost;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  @NotEmpty
  @Column
  private String vehicleType;
  
  @Positive
  @NotNull
  @NotEmpty
  @Column
  private Float multiplier;

  @Positive
  @NotNull
  @NotEmpty
  @Column
  private Integer payload;

  public Vehicle() {
  }

  public Vehicle(String type, Integer payload) {
    this.setVehicleType(type);
    this.payload = payload;
  }

  public String toString() {
    return "Vehicle[" + vehicleType + ", " + payload + "]";
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
    // TODO: dynamic properties
    switch (vehicleType) {
    		case "truck_trunk":
	    		this.multiplier = 1f;
	    		break;
    		case "bucket_truck":
	    		this.multiplier = 1.05f;
	    		break;
    		case "cart":
	    		this.multiplier = 1.12f;
	    		break;
    		default:
            throw new IllegalArgumentException("Invalid vehicle type " + vehicleType);
    }
  }

  public Integer getPayload() {
	return payload;
  }

  public void setPayload(Integer payload) {
	this.payload = payload;
  }  
  
  public Float getVehicleCost(Float cost) {
	return this.multiplier * cost;
  }

  public void setVehicleMultiplier(Float multiplier) {
	this.multiplier = multiplier;
  }
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
