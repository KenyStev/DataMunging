/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        Parser rowSelector = new Parser("\\s\\*");
        Indexes indexes = new Indexes(1,2,3);
        Type IntegerType = new IntegerType();
        DataMunging dm = new DataMunging(rowSelector,indexes);
        
        System.out.println("-------------weather-------------");
        assertArrayEquals(new Object[]{14}, dm.smallest("weather.dat",IntegerType));
    }
    
    @Test
    public void footballTest() throws FileNotFoundException{
        Parser rowSelector = new Parser("\\s\\.-");
        Indexes indexes = new Indexes(2,7,8);
        Type StringType = new StringType();
        DataMunging dm = new DataMunging(rowSelector,indexes);
        
        System.out.println("-------------football-------------");
        assertArrayEquals(new Object[]{"Leicester"}, dm.smallest("football.dat",StringType));
    }
    
    @Test
    public void multipleMinTest() throws FileNotFoundException{
        Parser rowSelector = new Parser("\\s\\.-");
        Indexes indexes = new Indexes(2,7,8);
        Type StringType = new StringType();
        DataMunging dm = new DataMunging(rowSelector,indexes);
        
        System.out.println("-------------football 2-------------");
        ArrayList<String> teams = new ArrayList<>();
        Object teamsArr[] = dm.smallest("football2.dat",StringType);
        Object expectedTeams[] = {"Leicester","Arko","Locky","Tuster","Marrok"};
        
        assertTrue(expectedTeams.length == teamsArr.length);
        for (Object team : expectedTeams) {
            teams.add((String) team);
        }
        for (Object team : teamsArr) {
            assertTrue(teams.contains(team));
        }
    }
    
    @Test
    public void emptyFileTest() throws FileNotFoundException{
        Parser rowSelector = new Parser("\\s");
        Indexes indexes = new Indexes(2,7,8);
        Type StringType = new StringType();
        DataMunging dm = new DataMunging(rowSelector,indexes);
        
        Object teamsArr[] = dm.smallest("vacio.dat",StringType);
        
        assertTrue(teamsArr.length==0);
    }
    
    @Test(expected = FileNotFoundException.class)
    public void FileNotFoundTest() throws FileNotFoundException{
        Parser rowSelector = new Parser("");
        Indexes indexes = new Indexes(2,7,8);
        Type StringType = new StringType();
        DataMunging dm = new DataMunging(rowSelector,indexes);
        
        Object teamsArr[] = dm.smallest("NotFound.dat",StringType);
    }
}
