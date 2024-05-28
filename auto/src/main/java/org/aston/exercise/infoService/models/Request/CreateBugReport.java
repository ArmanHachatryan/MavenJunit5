package org.aston.exercise.infoService.models.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBugReport {
    private String message;
    private String userEmail;
}