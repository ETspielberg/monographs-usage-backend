package unidue.ub.services.data.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Service {

    @Id
    private String id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "short_description", columnDefinition = "TEXT")
    private String shortDescription;

    @Column(name = "catchy_phrase", columnDefinition = "TEXT")
    private String catchyPhrase;

    @Column(name="targeted_audience")
    private String[] targetedAudience;

    @Column(name="audience_level")
    private String[] audienceLevel;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name = "service_contactperson",
            joinColumns = { @JoinColumn(name = "service_id") },
            inverseJoinColumns = { @JoinColumn(name = "contactperson_id") }
    )
    private Set<Contactperson> contactpersons;

    @ManyToOne
    private Servicecategory servicecategory;

    private String[] requirements;

    private String[] categories;

    private boolean activeService;

    private String imageFile;

    private String href;

    public Servicecategory getServicecategory() {
        return servicecategory;
    }

    public void setServicecategory(Servicecategory servicecategory) {
        this.servicecategory = servicecategory;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String[] getTargetedAudience() {
        return targetedAudience;
    }

    public void setTargetedAudience(String[] targetedAudience) {
        this.targetedAudience = targetedAudience;
    }

    public String[] getAudienceLevel() {
        return audienceLevel;
    }

    public void setAudienceLevel(String[] audienceLevel) {
        this.audienceLevel = audienceLevel;
    }

    public Set<Contactperson> getContactpersons() {
        return contactpersons;
    }

    public void setContactpersons(Set<Contactperson> contactpersons) {
        this.contactpersons = contactpersons;
    }

    public String[] getRequirements() {
        return requirements;
    }

    public void setRequirements(String[] requirements) {
        this.requirements = requirements;
    }

    public boolean isActiveService() {
        return activeService;
    }

    public void setActiveService(boolean activeService) {
        this.activeService = activeService;
    }

    public String getAudienceLevelAsString() {
        StringBuilder levels = new StringBuilder();
        for (String level : this.audienceLevel)
            levels.append(" ").append(level);
        return levels.toString();
    }

    public String getTargetedAudienceAsString() {
        StringBuilder audiences = new StringBuilder();
        for (String audience : this.targetedAudience)
            audiences.append(" ").append(audience);
        return audiences.toString();
    }
}
