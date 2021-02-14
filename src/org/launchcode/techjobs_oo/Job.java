package org.launchcode.techjobs_oo;

import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // Two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // Custom equals and hashCode methods. Two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job that = (Job) o;
        return id == that.id;
    }

    // toString method: goes through each field - if field is null, updates value to noData string and returns
    // Job Listing at the bottom.

    public String toString(){
        String noData = "Data not available";
        String jobListing;

        if (name.isEmpty()){
            name = noData;
        }

        if (employer.getValue() == null || employer.getValue().equals("")){
            employer.setValue(noData);
        }

        if (location.getValue() == null || location.getValue().equals("")){
            location.setValue(noData);
        }

        if (positionType.getValue() == null || positionType.getValue().equals("")){
            positionType.setValue(noData);
        }

        if (coreCompetency.getValue() == null || coreCompetency.getValue().equals("")){
            coreCompetency.setValue(noData);
        }

        jobListing = "\n ID: " + this.getId() + "\n Name: " + this.getName() + "\n Employer: "
                + this.getEmployer() + "\n Location: " + this.getLocation() + "\n Position Type: " + this.getPositionType()
                + "\n Core Competency: " + this.getCoreCompetency() + "\n";

        if (name.equals(noData) && employer.getValue().equals(noData) && location.getValue().equals(noData) &&
                positionType.getValue().equals(noData) && coreCompetency.getValue().equals(noData)) {
            jobListing = "OOPS! This job does not seem to exist.";
            return jobListing;
        }

        return jobListing;
    }

    // Getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
