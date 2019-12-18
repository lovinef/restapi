package rest.practice.restapi.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventsTest {
    @Test
    public void builder(){
        Event event = Event.builder()
                .name("event")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean(){
        String name = "event";
        String description = "spring";

        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }
}