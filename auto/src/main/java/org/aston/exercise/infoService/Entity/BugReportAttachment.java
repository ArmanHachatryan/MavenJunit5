package org.aston.exercise.infoService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bug_report_attachments")
public class BugReportAttachment {
    @Id
    String attachment_id;
    String bug_id;
    String path_to_content;
}
