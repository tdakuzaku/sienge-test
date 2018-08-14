package sienge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sienge.models.Transport;
import sienge.services.TransportService;

@RequestMapping("/transports")
@RestController
public class TransportController {
  private TransportService transportService;

  /**
   * Setup the TransportController
   *
   * @param transportService TransportService
   */
  @Autowired
  public TransportController(TransportService transportService) {
    this.transportService = transportService;
  }

  @PostMapping
  public Float calculate(@RequestBody Transport input) {
    return transportService.shippingCalculation();
  }
}
