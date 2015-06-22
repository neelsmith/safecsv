package edu.holycross.shot.safecsv 


import static org.junit.Assert.*
import org.junit.Test


/** Class to test cite library's CtsUrn class. 
*/
class TestEmpties extends GroovyTestCase {

  
  void testLineReader() {
    String empty1 = ",col2,col3   "
    SafeCsvReader safecsv = new SafeCsvReader(new File("/dev/null"))
    ArrayList cols = safecsv.parseLine(empty1)
    assert cols.size() == 3

    String empty2 = "col1,,col3   "
    cols = safecsv.parseLine(empty2)
    assert cols.size() == 3


    String empty3 = "col1,col3,"
    cols = safecsv.parseLine(empty3)
    assert cols.size() == 3

  }

 
}
