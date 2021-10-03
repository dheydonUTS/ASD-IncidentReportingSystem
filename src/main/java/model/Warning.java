package model;

/**
 *
 * @author joe
 */
public class Warning {
    private int warning_id;
    private int venue_id;
    private String description;
    private int offender_id;

    public Warning(int warning_id, int venue_id, String description, int offender_id) {
        this.warning_id = warning_id;
        this.venue_id = venue_id;
        this.description = description;
        this.offender_id = offender_id;
    }

    public Warning(int venue_id, String description, int offender_id) {
        this.venue_id = venue_id;
        this.description = description;
        this.offender_id = offender_id;
    }

    public int getWarning_id() {
        return warning_id;
    }

    public void setWarning_id(int warning_id) {
        this.warning_id = warning_id;
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
