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

@Entity
@Table(name = "transports")
public class Vehicle implements Serializable {
  private static final long serialVersionUID = 1709299723906950395L;

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
  private Float costByKm;

  @Positive
  @NotNull
  @NotEmpty
  @Column
  private Integer payload;

  public Vehicle() {
  }

  public Vehicle(String roadType, String vehicleType, Integer payload) {
    this.vehicleType = vehicleType;
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
  }

  public Integer getPayload() {
	return payload;
  }

  public void setPayload(Integer payload) {
	this.payload = payload;
  }  
  
  public Float getCostByKm() {
	return costByKm;
  }

  public void setCostByKm(Float costByKm) {
	this.costByKm = costByKm;
  }
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
