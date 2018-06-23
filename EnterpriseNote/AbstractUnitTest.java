import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AbstractUnitTest {
    private static class AbstractUnitImpl extends AbstractUnit {
        public AbstractUnitImpl(String name) {
            super(name);
        }
    }

    private AbstractUnit unit;
    private List<AbstractUnit> childNodes;

    @Before
    public void setUp() {
        unit = new AbstractUnitImpl("Abstract Unit");
        childNodes = new ArrayList<>();
        childNodes.add(new AbstractUnitImpl("AU1"));
        childNodes.add(new AbstractUnitImpl("AU2"));
        childNodes.add(new AbstractUnitImpl("AU3"));
        childNodes.add(new AbstractUnitImpl("AU4"));
        childNodes.add(new AbstractUnitImpl("AU5"));
    }

    @Test
    public void testAbstract() {
        assertTrue("AbstractUnit should be abstract!", Modifier.isAbstract(AbstractUnit.class.getModifiers()));
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new AbstractUnitImpl(null);
            fail("AbstractUnit.AbstractUnit() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetName() {
        assertEquals("AbstractUnit.getName() should return the correct value!", "Abstract Unit", unit.getName());
    }

    @Test
    public void testAddNullArgument() {
        try {
            unit.add(null);
            fail("AbstractUnitTest.add() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < childNodes.size(); i++) {
            assertTrue("AbstractUnit.add() should return true if the unit is to be added!",
                    unit.add(childNodes.get(i)));
            assertTrue(
                    "AbstractUnit.add() should add the unit if it was not a child node previously!",
                    unit.getChildNodes().contains(childNodes.get(i)));

            assertFalse("AbstractUnit.add() should return false if the unit is not to be added!",
                    unit.add(childNodes.get(i)));
            assertTrue("AbstractUnit.add() should not add the unit if it is a child node!",
                    unit.getChildNodes().size() == i + 1);
        }
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < childNodes.size(); i++) {
            unit.add(childNodes.get(i));
        }

        for (int i = 0; i < childNodes.size(); i++) {
            assertTrue("AbstractUnit.remove() should return true if the unit was a child node!",
                    unit.remove(childNodes.get(i)));
            assertFalse("AbstractUnit.remove() should remove the unit if it is a child node!",
                    unit.getChildNodes().contains(childNodes.get(i)));
            assertFalse("AbstractUnit.remove() should return false if the unit is not a child node!",
                    unit.remove(childNodes.get(i)));
        }
    }

    @Test
    public void testRemoveIndirectChildNode() {
        for (int i = 0; i < childNodes.size(); i++) {
            unit.add(childNodes.get(i));
        }

        AbstractUnit newUnit = new Holding("H1");
        childNodes.get(0).add(newUnit);

        assertFalse("AbstractUnit.remove() should return false if the unit is not a direct child node!",
                unit.remove(newUnit));
        assertTrue("AbstractUnit.remove() should not remove an indirect child node!",
                childNodes.get(0).getChildNodes().contains(newUnit));
    }

    @Test
    public void testGetChildNodes() {
        assertTrue("AbstractUnit.getChildNodes() should return an empty List if no child nodes have been added!",
                unit.getChildNodes().isEmpty());
    }
}
