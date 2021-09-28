package ua.ivan.springtask.dto;

import lombok.*;
import ua.ivan.springtask.entity.Conference;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ConferenceDTO {
    private Long id;
    private String topic;
    private String eventDateTime;
    private String eventAddress;
    private String description;

    public ConferenceDTO(Conference conference) {
        this.id = conference.getId();
        this.topic = conference.getTopic();
        this.eventDateTime = conference.getEventDateTime().toString();
        this.eventAddress = conference.getEventAddress();
        this.description = conference.getDescription();
    }
}
