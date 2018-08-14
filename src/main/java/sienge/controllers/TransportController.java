package sienge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sienge.models.RequestWrapper;
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

  @PostMapping("/calculate/")
  public Float calculate(@RequestBody RequestWrapper requestWrapper) {
    return transportService.shippingCalculation(requestWrapper);
  }
}
