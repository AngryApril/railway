package edu.epam.training.railway.test;

import edu.epam.training.railway.main.service.FileDataReader;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by alexey.valiev on 5/21/19.
 */
public class FileDataReaderTest {


    @Test
    @BeforeMethod
    public void testReadToStringArrayList(){

        FileDataReader fileDataReader = new FileDataReader();
        ArrayList<String> expected = new ArrayList<>();
        Optional<ArrayList<String>> actual = fileDataReader.readToStringArrayList("empty.txt");

        assertEquals(actual, Optional.of(expected));

    }


    @Test
    @BeforeMethod
    public void testFileNotFound(){
        FileDataReader fileDataReader = new FileDataReader();

        Optional<ArrayList<String>> actual = fileDataReader.readToStringArrayList("carXDTUFYI567");

        assertEquals(actual, Optional.empty());
    }

}
