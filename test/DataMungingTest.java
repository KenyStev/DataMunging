/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kenystev
 */
public class DataMungingTest {
    
    public DataMungingTest() {
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

    @Test
    public void weatherTest() throws FileNotFoundException{
        RowSelector rowSelector = new RowSelector();
        DataMunging dm = new DataMunging(rowSelector);
        
        System.out.println("-------------weather-------------");
        dm.setDelimiters(" \t\r\n\\*");
        assertArrayEquals(new int[]{2}, dm.weather("weather.dat"));
    }
    
    @Test
    public void footballTest() throws FileNotFoundException{
        RowSelector rowSelector = new RowSelector();
        DataMunging dm = new DataMunging(rowSelector);
        
        System.out.println("-------------football-------------");
        dm.setDelimiters(" \t\r\n\\.-");
        assertArrayEquals(new int[]{2}, dm.weather("football.dat"));
    }
}
