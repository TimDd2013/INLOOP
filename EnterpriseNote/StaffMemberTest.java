import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StaffMemberTest {
    private StaffMember member;
    private List<StaffMember> subordinates;

    @Before
    public void setUp() {
        member = new StaffMember("Mike", "Supervisor");
        subordinates = new ArrayList<>();
        subordinates.add(new StaffMember("Member 1", "Executive 1"));
        subordinates.add(new StaffMember("Member 2", "Executive 2"));
        subordinates.add(new StaffMember("Member 3", "Executive 3"));
        subordinates.add(new StaffMember("Member 4", "Executive 4"));
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new StaffMember(null, "Supervisor");
            fail("StaffMember.StaffMember() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new StaffMember("Mike", null);
            fail("StaffMember.StaffMember() should throw a NullPointerException if the job argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new StaffMember("", "Supervisor");
            fail("StaffMember.StaffMember() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new StaffMember("Mike", "");
            fail("StaffMember.StaffMember() should throw an IllegalArgumentException if the job argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetName() {
        assertEquals("StaffMember.getName() should return the correct value!", "Mike", member.getName());
    }

    @Test
    public void testGetJob() {
        assertEquals("StaffMember.getJob() should return the correct value!", "Supervisor", member.getJob());
    }

    @Test
    public void testCompareTo() {
        assertTrue("StaffMember.compareTo() should return a positive integer if the given value is smaller!",
                member.compareTo(new StaffMember("Marc", "CEO")) > 0);
        assertTrue("StaffMember.compareTo() should return the integer zero if the given value is equal!",
                member.compareTo(new StaffMember("Mike", "Chief Supervisor")) == 0);
        assertTrue("StaffMember.compareTo() should return a negative integer if the given value is greater!",
                member.compareTo(new StaffMember("Monique", "CFO")) < 0);
    }

    @Test
    public void testAddDirectSubordinateNullArgument() {
        try {
            member.addDirectSubordinate(null);
            fail("StaffMember.addDirectSubordinate() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddDirectSubordinate() {
        for (int i = 0; i < subordinates.size(); i++) {
            assertTrue("StaffMember.addDirectSubordinate() should return true if the member is to be added!",
                    member.addDirectSubordinate(subordinates.get(i)));
            assertTrue(
                    "StaffMember.addDirectSubordinate() should add the member if it was not a direct subordinate previously!",
                    member.getDirectSubordinates().contains(subordinates.get(i)));

            assertFalse("StaffMember.addDirectSubordinate() should return false if the member is not to be added!",
                    member.addDirectSubordinate(subordinates.get(i)));
            assertTrue("StaffMember.addDirectSubordinate() should not add the member if it is a direct subordinate!",
                    member.getDirectSubordinates().size() == i + 1);
        }
    }

    @Test
    public void testRemoveDirectSubordinate() {
        for (int i = 0; i < subordinates.size(); i++) {
            member.addDirectSubordinate(subordinates.get(i));
        }

        for (int i = 0; i < subordinates.size(); i++) {
            assertTrue(
                    "StaffMember.removeDirectSubordinate() should return true if the member was a direct subordinate!",
                    member.removeDirectSubordinate(subordinates.get(i)));
            assertFalse(
                    "StaffMember.removeDirectSubordinate() should remove the member if it is a direct subordinate!",
                    member.getDirectSubordinates().contains(subordinates.get(i)));
            assertFalse(
                    "StaffMember.removeDirectSubordinate() should return false if the member is not a direct subordinate!",
                    member.removeDirectSubordinate(subordinates.get(i)));
        }
    }

    @Test
    public void testRemoveIndirectSubordinate() {
        for (int i = 0; i < subordinates.size(); i++) {
            member.addDirectSubordinate(subordinates.get(i));
        }

        StaffMember newMember = new StaffMember("New Guy", "New Stuff");
        subordinates.get(0).addDirectSubordinate(newMember);

        assertFalse(
                "StaffMember.removeDirectSubordinate() should return false if the member is not a direct subordinate!",
                member.removeDirectSubordinate(newMember));
        assertTrue("StaffMember.removeDirectSubordinate() should not remove an indirect subordinate!",
                subordinates.get(0).getDirectSubordinates().contains(newMember));
    }

    @Test
    public void testGetDirectSubordinates() {
        assertTrue(
                "StaffMember.getDirectSubordinates() should return an empty List if no direct subordinates have been added!",
                member.getDirectSubordinates().isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals("StaffMember.toString() should return the correct value!", "Mike", member.toString());
    }
}
