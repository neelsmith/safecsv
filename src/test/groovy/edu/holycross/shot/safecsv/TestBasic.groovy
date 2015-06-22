package edu.holycross.shot.safecsv 


import static org.junit.Assert.*
import org.junit.Test


/** Class to test cite library's CtsUrn class. 
*/
class TestBasic extends GroovyTestCase {

  
  void testLineReader() {
    String simplest = "  col1,col2,col3   "
    SafeCsvReader safecsv = new SafeCsvReader(new File("/dev/null"))
    assert safecsv.stripWhiteSpace(simplest) == "col1,col2,col3"
  }

  void testColumnParser() {
    String simplest = "  col1,col2,col3   "
    SafeCsvReader safecsv = new SafeCsvReader(new File("/dev/null"))
    ArrayList cols = safecsv.parseLine(simplest)
    assert cols.size() == 3
  }

  
 
}
