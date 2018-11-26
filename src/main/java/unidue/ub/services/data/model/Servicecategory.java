package unidue.ub.services.data.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Servicecategory {

    @Id
    private String id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name="short_description")
    private String shortDescription;

    @Column(name="catchy_phrase", columnDefinition="TEXT")
    private String catchyPhrase;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "servicecategory", cascade= CascadeType.ALL)
    @OrderColumn(name = "id")
    private Set<Service> services;

    @Column(name="image_file")
    private String imageFile;

    public Servicecategory() {
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getCatchyPhrase() {
        return catchyPhrase;
    }

    public void setCatchyPhrase(String catchyPhrase) {
        this.catchyPhrase = catchyPhrase;
    }

    public List<Service> getFilteredServices(String targetedAudience, String audienceLevel) {
        List<Service> filteredServices = new ArrayList<>();
        for (Service service : this.services) {
            if (service.getAudienceLevelAsString().contains(audienceLevel) || service.getTargetedAudienceAsString().contains(targetedAudience))
                filteredServices.add(service);
        }
        return filteredServices;
    }
}
