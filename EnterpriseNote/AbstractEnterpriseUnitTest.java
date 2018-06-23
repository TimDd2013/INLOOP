import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.Test;

public class AbstractEnterpriseUnitTest {
    private static class AbstractEnterpriseUnitImpl extends AbstractEnterpriseUnit {
        public AbstractEnterpriseUnitImpl(String name) {
            super(name);
        }
    }

    @Test
    public void testAbstract() {
        assertTrue("AbstractEnterpriseUnit should be abstract!",
                Modifier.isAbstract(AbstractEnterpriseUnit.class.getModifiers()));
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new AbstractEnterpriseUnitImpl(null);
            fail("AbstractEnterpriseUnit.AbstractEnterpriseUnit() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Holding(null);
            fail("Holding.Holding() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Company(null);
            fail("Company.Company() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Division(null);
            fail("Division.Division() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Team(null, new StaffMember("Mike", "Supervisor"));
            fail("Team.Team() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Team("A-Team", null);
            fail("Team.Team() should throw a NullPointerException if the teamLeader argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetName() {
        EnterpriseNode node = new AbstractEnterpriseUnitImpl("Abstract Enterprise Unit");
        assertTrue("AbstractEnterpriseUnit.getName() should return the correct value!",
                node.getName().equals("Abstract Enterprise Unit"));

        node = new Holding("AEU Holding");
        assertTrue("Holding.getName() should return the correct value!", node.getName().equals("AEU Holding"));

        node = new Company("AEU Company");
        assertTrue("Company.getName() should return the correct value!", node.getName().equals("AEU Company"));

        node = new Company("AEU Division");
        assertTrue("Division.getName() should return the correct value!", node.getName().equals("AEU Division"));

        node = new Company("AEU Team");
        assertTrue("Team.getName() should return the correct value!", node.getName().equals("AEU Team"));
    }
}
