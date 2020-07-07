package gflegal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
public class Attorney {
    private String biography;
    private String title;
    private String[] locations;
    private String email;
    private String phone;
    private String fullBiography;
    private String[] education;
    private String[] barAdmissions;
    private String name;

    public Attorney(String biography, String title, String[] locations, String email, String phone, String fullBiography, String[] education, String[] barAdmissions, String name) {
        this.biography = biography;
        this.title = title;
        this.locations = locations;
        this.email = email;
        this.phone = phone;
        this.fullBiography = fullBiography;
        this.education = education;
        this.barAdmissions = barAdmissions;
        this.name = name;
    }
}
