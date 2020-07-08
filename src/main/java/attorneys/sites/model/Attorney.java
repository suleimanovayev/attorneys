package attorneys.sites.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Attorney {
    private String biography;
    private String title;
    private String[] locations;
    private String email;
    private String phone;
    private String fullBiography;
    private String education;
    private String barAdmissions;
    private String name;

    public Attorney(String biography, String title, String[] locations, String email, String phone, String fullBiography, String education, String barAdmissions, String name) {
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

    public Attorney() {
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getLocations() {
        return locations;
    }

    public void setLocations(String[] locations) {
        this.locations = locations;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullBiography() {
        return fullBiography;
    }

    public void setFullBiography(String fullBiography) {
        this.fullBiography = fullBiography;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBarAdmissions() {
        return barAdmissions;
    }

    public void setBarAdmissions(String barAdmissions) {
        this.barAdmissions = barAdmissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
