/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author User
 */
public class ApplianceTest extends TestCase {
    private Appliance appTest1, appTest2;
    
    @BeforeEach
    public void setUp(){
        appTest1 = new Appliance();
        appTest2 = new Appliance("4", "user1", "", "Fűnyíró", "kert", 4100, "bérelhető", "új eszköz");
    }
    
    @Test
    public void testGetNameShouldBeNullWhenDefaultConstructorCalled(){
        Assertions.assertNull(appTest1.getName());
    }
    
    @Test
    public void testGetNameShouldNotBeNullWhenDefaultConstructorCalled(){
        Assertions.assertNotNull(appTest2.getName(), "Null excepted value returned...");
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
