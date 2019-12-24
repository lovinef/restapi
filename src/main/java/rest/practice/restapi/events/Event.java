package rest.practice.restapi.events;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.util.StringUtils;
import rest.practice.restapi.accounts.Account;
import rest.practice.restapi.accounts.AccountSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Event {
    @Id @GeneratedValue
    private Integer id;

    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional)이게 없으면 온라인 모임
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    @ManyToOne
    @JsonSerialize(using = AccountSerializer.class) // 특정 정보만 전달하도록 serializer 재설정
    private Account manager;

    public void update() {
        // update free
        this.free = this.basePrice == 0 && this.maxPrice == 0;
        this.offline = !StringUtils.isEmpty(this.location);
    }
}
