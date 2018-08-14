package sienge.tests.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import sienge.models.Transport;
import sienge.models.Vehicle;

@RunWith(SpringRunner.class)
public class TransportTest {

    @MockBean
    private Transport t;
    
    @Before
    public void setUp() {
    }

    private final Transport t1 = new Transport("paved");
    private final Transport t2 = new Transport("dirt");
    private final Transport t3 = new Transport("dirt");    
    private final Transport t4 = new Transport("dirt");
    private final Vehicle v3 = new Vehicle("truck_trunk", 5);
    private final Vehicle v4 = new Vehicle("truck_trunk", 8);
    
    @Test
    public void checkPavedCost() {
    		Float cost = 100f;
        assertThat(t1.costByDistance(cost))
            .isEqualTo(54.000004f); //wtf
    }
    
    @Test
    public void checkDirtCost() {
    		Float cost = 100f;
        assertThat(t2.costByDistance(cost))
            .isEqualTo(62f);
    }
    
    @Test
    public void checkNormalPaylodCost() {
    		Float km = 100f;    		
    		t3.setVehicle(v3);
        assertThat(t3.costByPayload(km))
            .isEqualTo(0f);
    }
    
    @Test
    public void checkAbovePaylodCost() {
		Float km = 100f;
    		t4.setVehicle(v4);
        assertThat(t4.costByPayload(km))
            .isEqualTo(6.0f);
    }
}
