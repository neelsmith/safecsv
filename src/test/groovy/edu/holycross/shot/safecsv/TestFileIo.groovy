package edu.holycross.shot.safecsv 


import static org.junit.Assert.*
import org.junit.Test


/** Class to test cite library's CtsUrn class. 
*/
class TestFileIo extends GroovyTestCase {


  // 6 lines, each with 3 columns
  File testFile = new File("testdata/test1.csv")
  
  
  void testQuotedComman() {
    SafeCsvReader safecsv = new SafeCsvReader(testFile)
    ArrayList csv = safecsv.readAll()

    Integer expectedRows = 6
    assert csv.size() == expectedRows
    Integer expectedColumns = 3
    csv.each {
      assert it.size() == expectedColumns
    }
  }
 
}
