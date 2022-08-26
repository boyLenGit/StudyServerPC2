package len.cloud02.front.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {
    private Long id;

    private String name;

    private String author;

    private String publisher;

    private String introduce;

    private String first_picture;

    private Integer view_time;

    private String file_path;
}
