package rest.practice.restapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors){
        // rejectValue filed error
        // reject global error

        if(eventDto.getMaxPrice() > eventDto.getBasePrice() && eventDto.getMaxPrice() != 0){
            errors.rejectValue("basePrice", "wrongValue", "basePrice is wrong");
            errors.rejectValue("maxPrice", "wrongValue", "maxPrice is wrong");
            errors.reject("wrongPrices", "Values of Price is wrong");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if(endEventDateTime.isBefore(eventDto.getBeginEventDateTime())
            || endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime())
                || endEventDateTime.isBefore((eventDto.getBeginEnrollmentDateTime()))
        ){
            errors.rejectValue("endEventDateTime", "wrongValue", "dateTime is wrong");
        }

    }

}
