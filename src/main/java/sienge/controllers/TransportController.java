package sienge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sienge.models.Transport;
import sienge.services.TransportServiceInterface;

@RequestMapping("/transports")
@RestController
public class TransportController {
  private TransportServiceInterface transportService;

  /**
   * Setup the TransportController
   *
   * @param transportService TransportService
   */
  @Autowired
  public TransportController(TransportServiceInterface transportService) {
    this.transportService = transportService;
  }

  @GetMapping("/calculate")
  public Float calculate() {
    return transportService.shippingCalculation();
  }
}
