package sienge.models;

public class RequestWrapper {
  public Vehicle vehicle;
  public Transport transport;
  public Float pavedDistanceKm;
  public Float dirtDistanceKm;
  
  public RequestWrapper(Vehicle vehicle, Transport transportation, Float pavedDistanceKm, Float dirtDistanceKm) {
	super();
	this.vehicle = vehicle;
	this.transport = transportation;
	this.pavedDistanceKm = pavedDistanceKm;
	this.dirtDistanceKm = dirtDistanceKm;
  }
}
