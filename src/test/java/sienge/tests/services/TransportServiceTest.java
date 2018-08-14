package sienge.tests.services;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import sienge.models.RequestWrapper;
import sienge.models.Transport;
import sienge.models.Vehicle;
import sienge.services.TransportService;

@RunWith(SpringRunner.class)
public class TransportServiceTest {

	@MockBean
    private Transport t;
    
    @Before
    public void setUp() {
    }

    private final Vehicle v1 = new Vehicle("bucket_truck", 8);
    private final Vehicle v2 = new Vehicle("truck_trunk", 4);
    private final Transport t1 = new Transport();
    private final TransportService ts1 = new TransportService();
    
    @Test
    public void checkEx1Shipping() {
    	RequestWrapper req = new RequestWrapper(v1, t1, 100f, 0f);
        assertThat(ts1.shippingCalculation(req))
            .isEqualTo(62.7f);
    }
    
    @Test
    public void checkEx2Shipping() {
    	RequestWrapper req = new RequestWrapper(v2, t1, 0f, 60f);
        assertThat(ts1.shippingCalculation(req))
            .isEqualTo(37.2f);
    }
}
