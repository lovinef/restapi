package rest.practice.restapi.events;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EventBsTest {

    @Test
    @Parameters(method = "paramsForTestFree")
    public void testFree(int basePrice, int maxPrice, boolean isFree){
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build()
                ;
        event.update();

        assertThat(event.isFree()).isEqualTo(isFree);
    }

    private Object[] paramsForTestFree(){
        return new Object[]{
                new Object[]{0, 0, true},
                new Object[]{100, 0, false},
                new Object[]{0, 100, false},
                new Object[]{100, 200, false}
        };
    }


    @Test
    @Parameters(method = "paramsForTestOffLine")
    public void testOffline(String location, boolean isOffline){
        Event event = Event.builder()
                .location(location)
                .build();
        event.update();

        assertThat(event.isOffline()).isEqualTo(isOffline);
    }

    private Object[] paramsForTestOffLine(){
        return new Object[]{
                new Object[]{"aa", true},
                new Object[]{"", false},
                new Object[]{null, false},
                new Object[]{"   ", false}
        };
    }
}
