package org.aston.exercise.infoService.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bug_report")
public class BugReport {
    @Id
    @Column(name = "bug_id")
    private String bug_id;
    @Column(name = "user_id")
    private String user_id;
    @Column(name = "user_email")
    private String user_email;
    @Column(name = "mailing_date")
    private String mailing_date;
    @Column(name = "message")
    private String message;
    @Column(name = "has_attachment")
    private Boolean has_attachment;
}
