package edu.holycross.shot.safecsv 


import static org.junit.Assert.*
import org.junit.Test


/** Class to test cite library's CtsUrn class. 
*/
class TestFileIo extends GroovyTestCase {


  
  void testQuoted() {
    // 6 lines, each with 3 columns
    File testFile = new File("testdata/test1.csv")
  
    SafeCsvReader safecsv = new SafeCsvReader(testFile)
    ArrayList csv = safecsv.readAll()

    Integer expectedRows = 6
    assert csv.size() == expectedRows
    Integer expectedColumns = 3
    csv.each {
      assert it.size() == expectedColumns
    }
  }

  void testFunnyGreek() {
    // 1 line with 7 columns, including Unicode
    // that breaks OpenCSVReader:
    File greekFile = new File("testdata/greek.csv")
    SafeCsvReader safecsv = new SafeCsvReader(greekFile)
    ArrayList csv = safecsv.readAll()
    Integer expectedRows = 1
    assert csv.size() == expectedRows
    Integer expectedColumns = 7
    csv.each { c ->
      println  c
      assert c.size() == expectedColumns
    }
  }


  
}
