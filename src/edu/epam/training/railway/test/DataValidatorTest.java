package edu.epam.training.railway.test;

import edu.epam.training.railway.main.service.DataValidator;
import edu.epam.training.railway.main.service.FileDataReader;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alexey.valiev on 5/14/19.
 */
public class DataValidatorTest {


    @Test
    @BeforeMethod
    public void testValidateTrain(){

        FileDataReader fileDataReader = new FileDataReader();
        ArrayList<String> inputStrings = fileDataReader.readToStringArrayList("error_train.txt").get();
        DataValidator dataValidator = new DataValidator();
        Optional<ArrayList<String>> actualResult = dataValidator.validateData(Optional.of(inputStrings));
        Optional<ArrayList<String>> expectedResult = Optional.empty();

        assertEquals(actualResult, expectedResult);

    }


    @Test
    @BeforeMethod
    public void testValidateTrainID(){

        FileDataReader fileDataReader = new FileDataReader();
        ArrayList<String> inputStrings = fileDataReader.readToStringArrayList("error_trainID.txt").get();
        DataValidator dataValidator = new DataValidator();
        Optional<ArrayList<String>> actualResult = dataValidator.validateData(Optional.of(inputStrings));
        Optional<ArrayList<String>> expectedResult = Optional.empty();

        assertEquals(actualResult, expectedResult);

    }


    @Test
    @BeforeMethod
    public void testValidateCarID(){

        FileDataReader fileDataReader = new FileDataReader();
        ArrayList<String> inputStrings = fileDataReader.readToStringArrayList("error_carID.txt").get();
        DataValidator dataValidator = new DataValidator();
        Optional<ArrayList<String>> actualResult = dataValidator.validateData(Optional.of(inputStrings));
        Optional<ArrayList<String>> expectedResult = Optional.empty();

        assertEquals(actualResult, expectedResult);

    }


    @Test
    @BeforeMethod
    public void testValidateCars(){

        FileDataReader fileDataReader = new FileDataReader();
        ArrayList<String> inputStrings = fileDataReader.readToStringArrayList("error_car.txt").get();
        ArrayList<String> expectedStrings = new ArrayList<>();
        expectedStrings.add("Passenger,12354".toUpperCase());
        expectedStrings.add("40004,Passenger,36,120,SECOND,");
        DataValidator dataValidator = new DataValidator();
        Optional<ArrayList<String>> actualResult = dataValidator.validateData(Optional.of(inputStrings));
        Optional<ArrayList<String>> expectedResult = Optional.of(expectedStrings);

        assertEquals(actualResult, expectedResult);

    }

    @Test
    @BeforeMethod
    public void testValidateTrainType(){

        DataValidator dataValidator = new DataValidator();
        Optional<String> actualResult = dataValidator.validateTrainType("mixed,.");
        Optional<String> expectedResult = Optional.of("MIXED");

        assertEquals(actualResult, expectedResult);
    }

}
