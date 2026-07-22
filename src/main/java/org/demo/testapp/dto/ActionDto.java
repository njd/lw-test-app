package org.demo.testapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ActionDto {
    private String moduleId;
    private String context;
    private String activity;
    private LocalDateTime whenRecorded;
}
