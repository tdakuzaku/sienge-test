package sienge.tests.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import sienge.models.Vehicle;

@RunWith(SpringRunner.class)
public class VehicleTest {

    @MockBean
    private Vehicle v;
    
    @Before
    public void setUp() {
    }

    private final Vehicle v1 = new Vehicle("truck_trunk", 1);
    private final Vehicle v2 = new Vehicle("bucket_truck", 1);
    private final Vehicle v3 = new Vehicle("cart", 1);
    
    @Test
    public void checkTrunkTruckMultiplier() {
    		Float cost = 100f;
        assertThat(v1.getVehicleCost(cost))
            .isEqualTo(cost);
    }
    
    @Test
    public void checkBucketTruckMultiplier() {
        assertThat(v2.getVehicleCost(100.00f))
            .isEqualTo(104.99999f); //wtf
    }
    
    @Test
    public void checkCartMultiplier() {
        assertThat(v3.getVehicleCost(100.0f))
            .isEqualTo(112.0f);
    }
}
