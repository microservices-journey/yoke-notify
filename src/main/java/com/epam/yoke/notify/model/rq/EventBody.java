package com.epam.yoke.notify.model.rq;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(description = "Body for create event")
public class EventBody {

    @NotNull(message = "EventId is mandatory")
    @Schema(required = true, description = "Requested eventId")
    private String eventId;

    @Schema(description = "Requested event description")
    private String description;
}
