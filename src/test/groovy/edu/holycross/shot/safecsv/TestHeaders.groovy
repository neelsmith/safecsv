package edu.holycross.shot.safecsv


import static org.junit.Assert.*
import org.junit.Test


/** Class to test cite library's CtsUrn class.
*/
class TestHeaders extends GroovyTestCase {


  boolean withHeader = true

  void testHeader() {
    // Test file has header + 2 data lines, each 3 columns
    Integer expectedRows = 2
    Integer expectedColumns = 3
    File hdrFile = new File("testdata/headerfile.csv")


    SafeCsvReader safecsv = new SafeCsvReader(hdrFile, withHeader)

    ArrayList hdr = safecsv.readHeader()
    assert hdr.size() == expectedColumns

    ArrayList csv = safecsv.readAll()
    assert csv.size() == expectedRows
    csv.each { c ->
      println  c
      assert c.size() == expectedColumns
    }
  }





}
