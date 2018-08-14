package sienge.tests.services;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import sienge.models.Transport;

@RunWith(SpringRunner.class)
public class TransportServiceTest {

	@MockBean
    private Transport t;
    
    @Before
    public void setUp() {
    }

    private final Transport t1 = new Transport("paved");
    private final Transport t2 = new Transport("dirt");
    
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
}
