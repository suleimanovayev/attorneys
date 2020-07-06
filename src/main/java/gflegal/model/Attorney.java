package gflegal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Attorney {
    private String biography;
    private String title;
    private String[] locations;
    private String email;
    private String[] phones;
    private String fullBiography;
    private String[] Education;
    private String[] barAdmissions;
    private String name;
}
