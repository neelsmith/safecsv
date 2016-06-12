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


  void testQuoted() {
    String quoted = '  col1,"col2",col3'
    SafeCsvReader safecsv = new SafeCsvReader(new File("/dev/null"))
    ArrayList cols = safecsv.parseLine(quoted)
    assert cols.size() == 3
  }

  void testQuotedComma() {
    String quoted = '  first column,"column with internal comma, here",trailer '
    SafeCsvReader safecsv = new SafeCsvReader(new File("/dev/null"))
    ArrayList cols = safecsv.parseLine(quoted)
    assert cols.size() == 3
    assert cols[0] == "first column"
    assert cols[1] == "column with internal comma, here"
    assert cols[2] == "trailer"

  }

}
