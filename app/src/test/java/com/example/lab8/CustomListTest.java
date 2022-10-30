package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CustomListTest {

    private CustomList list;

//    @Before
//    public void createList() {
//        list = new CustomList(null, new ArrayList<City>());
//    }

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList mockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        list = mockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = mockCityList();
        City cCity = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(cCity);
        // we added cCity to the cityList so the cityList should contain it and hasCity should return true
        assertTrue(cityList.hasCity(cCity));
        City ykCity = new City("Yellowknife", "Northwest Territories");
        // we did not add ykCity (Yellowknife) to the cityList so the cityList should not contain it and hasCity should return false
        assertFalse(cityList.hasCity(ykCity));
    }
    /*
    @Test
    void testDelete() {
        CustomList cityList = mockCityList();
        City cCity = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(cCity);
        // we added cCity to the cityList so the cityList should contain it

        City ykCity = new City("Yellowknife", "Northwest Territories");
        // delete mockCity Edmonton from the cityList and check if it was removed by checking if hasCity returns false
        // check if citylist first has edmonton then check after we delete if it was successfully removed
        assertTrue(cityList.hasCity(cCity));
        cityList.delete(cCity);
        assertFalse(cityList.hasCity(cCity));
        // cityList does not contain yellowknife so should throw NSEE when we try to delete it from the arraylist
        assertThrows( NoSuchElementException.class, () -> {
            cityList.delete(ykCity);
        });
    }

    @Test
    void testCount() {
        CustomList cityList = mockCityList();
        City cCity = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(cCity);
        // we added cCity to the cityList so the cityList should contain it
        // check if citylist first has cCity then check if the length of the arraylist is 2
        assertTrue(cityList.hasCity(cCity));
        assertEquals(2, cityList.getCount());
    }
     */

}
