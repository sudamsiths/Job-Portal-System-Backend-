package main.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
    private Integer job_id;
    private String title;
    private String description;
    private Double salary;
    private LocalDate salary_date;

}
