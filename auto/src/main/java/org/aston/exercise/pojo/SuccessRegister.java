package org.aston.exercise.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessRegister {
    private Integer id;
    private String token;
}
