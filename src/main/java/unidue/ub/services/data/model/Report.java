package unidue.ub.services.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {

    @Id
    private String id;

    private int year;

    private long price;

    private String link;

    Report(String id, int year) {
        this.id = id;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
