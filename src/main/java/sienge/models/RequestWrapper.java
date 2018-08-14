package sienge.models;

public class RequestWrapper {
  public Vehicle vehicle;
  public Transport transport;
  public Float pavedDistanceKm;
  public Float dirtDistanceKm;
  
  public RequestWrapper() {
  }
  
  public RequestWrapper(Vehicle vehicle, Transport transport, Float pavedDistanceKm, Float dirtDistanceKm) {
	super();
	this.vehicle = vehicle;
	this.transport = transport;
	this.pavedDistanceKm = pavedDistanceKm;
	this.dirtDistanceKm = dirtDistanceKm;
  }
}
