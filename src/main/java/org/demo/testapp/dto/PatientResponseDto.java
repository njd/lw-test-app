package org.demo.testapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class PatientResponseDto {

    private Long entityId;
    private String title;
    private String givenName;
    private String familyName;
    private LocalDateTime whenRegistered;
    private LocalDateTime whenInvited;
    private LocalDateTime whenDischarged;
    private List<ActionDto> actions = new ArrayList<>();
}
