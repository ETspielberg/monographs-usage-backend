package unidue.ub.services.data.model;

import javax.persistence.Entity;

@Entity
public class JournalUsageReport extends Report {

    private long items;

    private long totalrequests;

    public JournalUsageReport(String id, int year, long items, long totalrequests) {
        super(id,year);
        this.items = items;
        this.totalrequests = totalrequests;
    }

    public long getItems() {
        return items;
    }

    public void setItems(long items) {
        this.items = items;
    }

    public long getTotalrequests() {
        return totalrequests;
    }

    public void setTotalrequests(long totalrequests) {
        this.totalrequests = totalrequests;
    }
}
