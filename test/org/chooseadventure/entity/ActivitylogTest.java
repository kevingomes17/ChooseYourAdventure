/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class ActivitylogTest {
    
    public ActivitylogTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Activitylog.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Activitylog instance = new Activitylog();
        BigDecimal expResult = null;
        BigDecimal result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Activitylog.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        BigDecimal id = null;
        Activitylog instance = new Activitylog();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Activitylog.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Activitylog instance = new Activitylog();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Activitylog.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Activitylog instance = new Activitylog();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedby method, of class Activitylog.
     */
    @Test
    public void testGetCreatedby() {
        System.out.println("getCreatedby");
        Activitylog instance = new Activitylog();
        BigInteger expResult = null;
        BigInteger result = instance.getCreatedby();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedby method, of class Activitylog.
     */
    @Test
    public void testSetCreatedby() {
        System.out.println("setCreatedby");
        BigInteger createdby = null;
        Activitylog instance = new Activitylog();
        instance.setCreatedby(createdby);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedon method, of class Activitylog.
     */
    @Test
    public void testGetCreatedon() {
        System.out.println("getCreatedon");
        Activitylog instance = new Activitylog();
        Date expResult = null;
        Date result = instance.getCreatedon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedon method, of class Activitylog.
     */
    @Test
    public void testSetCreatedon() {
        System.out.println("setCreatedon");
        Date createdon = null;
        Activitylog instance = new Activitylog();
        instance.setCreatedon(createdon);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModifiedby method, of class Activitylog.
     */
    @Test
    public void testGetModifiedby() {
        System.out.println("getModifiedby");
        Activitylog instance = new Activitylog();
        BigInteger expResult = null;
        BigInteger result = instance.getModifiedby();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModifiedby method, of class Activitylog.
     */
    @Test
    public void testSetModifiedby() {
        System.out.println("setModifiedby");
        BigInteger modifiedby = null;
        Activitylog instance = new Activitylog();
        instance.setModifiedby(modifiedby);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModifiedon method, of class Activitylog.
     */
    @Test
    public void testGetModifiedon() {
        System.out.println("getModifiedon");
        Activitylog instance = new Activitylog();
        Date expResult = null;
        Date result = instance.getModifiedon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModifiedon method, of class Activitylog.
     */
    @Test
    public void testSetModifiedon() {
        System.out.println("setModifiedon");
        Date modifiedon = null;
        Activitylog instance = new Activitylog();
        instance.setModifiedon(modifiedon);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserid method, of class Activitylog.
     */
    @Test
    public void testGetUserid() {
        System.out.println("getUserid");
        Activitylog instance = new Activitylog();
        Userbase expResult = null;
        Userbase result = instance.getUserid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserid method, of class Activitylog.
     */
    @Test
    public void testSetUserid() {
        System.out.println("setUserid");
        Userbase userid = null;
        Activitylog instance = new Activitylog();
        instance.setUserid(userid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivitytypeid method, of class Activitylog.
     */
    @Test
    public void testGetActivitytypeid() {
        System.out.println("getActivitytypeid");
        Activitylog instance = new Activitylog();
        Activitytype expResult = null;
        Activitytype result = instance.getActivitytypeid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActivitytypeid method, of class Activitylog.
     */
    @Test
    public void testSetActivitytypeid() {
        System.out.println("setActivitytypeid");
        Activitytype activitytypeid = null;
        Activitylog instance = new Activitylog();
        instance.setActivitytypeid(activitytypeid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Activitylog.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Activitylog instance = new Activitylog();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Activitylog.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Activitylog instance = new Activitylog();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Activitylog.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Activitylog instance = new Activitylog();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
