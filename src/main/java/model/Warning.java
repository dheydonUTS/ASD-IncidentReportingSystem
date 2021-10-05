package model;

/**
 *
 * @author joe
 */
public class Warning {
    private int id;
    private int venue_id;
    private String description;
    private int offender_id;

    public Warning(int id, int venue_id, String description, int offender_id) {
        this.id = id;
        this.venue_id = venue_id;
        this.description = description;
        this.offender_id = offender_id;
    }

    public Warning(int venue_id, String description, int offender_id) {
        this.venue_id = venue_id;
        this.description = description;
        this.offender_id = offender_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOffender_id() {
        return offender_id;
    }

    public void setOffender_id(int offender_id) {
        this.offender_id = offender_id;
    }
    
    
}
