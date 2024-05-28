package org.aston.exercise.infoService.models.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessCreatedBug {
    private String bugId;
    private String mailingDate;
}