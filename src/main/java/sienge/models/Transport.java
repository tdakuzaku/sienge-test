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
public class Transport implements Serializable {
  private static final long serialVersionUID = 1709299723906950395L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @NotEmpty
  @Column
  private String roadType;

  @NotNull
  @NotEmpty
  @Column
  private String vehicleType;
  
  @Positive
  @NotNull
  @NotEmpty
  @Column
  private Integer payload;

  public Transport() {
  }

  public Transport(String roadType, String vehicleType, Integer payload) {
    this.roadType = roadType;
    this.vehicleType = vehicleType;
    this.payload = payload;
  }

  public String toString() {
    return "Transport[" + roadType + ", " + vehicleType + ", " + payload + "]";
  }

  public String getRoadType() {
    return roadType;
  }

  public void setRoadType(String roadType) {
    this.roadType = roadType;
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
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
