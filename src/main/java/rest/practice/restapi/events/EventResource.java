package rest.practice.restapi.events;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class EventResource extends EntityModel {
    // 자동 upwrapped 처리됨.
    // unwrapped 처리 방법 @JsonUnwrapped
    public EventResource(Event event, Link... links) {
        super(event, links);
        // 요청 받은 링크 추가
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }
}
