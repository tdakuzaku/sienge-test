package sienge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sienge.repos.UserRepository;

@Service
public class TransportDAO implements TransportService {
  private UserRepository transportRepo;

  @Autowired
  public TransportDAO(UserRepository userRepo) {
    this.transportRepo = userRepo;
  }

  public Float shippingCalculation() {
	  return (float) 100;
  }
}
