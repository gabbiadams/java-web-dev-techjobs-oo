package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {
    Job testJob;
    Job testJob2;

    @Before
    public void createJobs(){
        testJob = new Job();
        testJob2 = new Job();
    }

    @Test
    public void testSettingJobId(){
        assertFalse(testJob.getId() == testJob2.getId());
    }

    @Test
    public void testJobConstructorSetAllFields(){
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(test.getName(), "Product tester");
        assertTrue(test.getEmployer() instanceof Employer);
        assertTrue(test.getLocation() instanceof Location);
        assertTrue(test.getPositionType() instanceof PositionType);
        assertTrue(test.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){

        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Boolean compare = test.equals(test2);
        assertFalse(compare);
    }

    @Test
    public void testToString(){
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Boolean expectedBeginning = test.toString().startsWith("\n");
        Boolean expectedEnd = test.toString().endsWith("\n");
        Boolean compare = expectedBeginning == expectedEnd;

        assertEquals(true, compare);
    }

    @Test
    public void testStringContainsLabelsAndFields(){
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = "\n ID: " + test.getId() + "\n Name: " + test.getName() + "\n Employer: "
                + test.getEmployer() + "\n Location: " + test.getLocation() + "\n Position Type: " + test.getPositionType()
                + "\n Core Competency: " + test.getCoreCompetency() + "\n";

        assertEquals(test.toString(), expected);
    }

    @Test
    public void testToStringMissingOneField(){
        Job test = new Job("Product Tester", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = "\n ID: " + test.getId() + "\n Name: " + test.getName() + "\n Employer: Data not available"
                + "\n Location: " + test.getLocation() + "\n Position Type: " + test.getPositionType()
                + "\n Core Competency: " + test.getCoreCompetency() + "\n";

        assertEquals(expected, test.toString());

    }

    @Test
    public void testToStringMissingAllFields(){
        Job test = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        String expected = "OOPS! This job does not seem to exist.";

        assertEquals(expected, test.toString());
    }

}
