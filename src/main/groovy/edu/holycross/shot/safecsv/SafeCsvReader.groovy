package edu.holycross.shot.safecsv

class SafeCsvReader {

  /** Configurable string value for column delimiter.*/
  String columnDelimiter = ","
  /** Configurable string value for quoting and turning of column delimiter.*/
  String quotation = '"'

  /** Delimited text file to read.*/
  File srcFile

  /** Whether or not to treat file as having a header */
  boolean withHeader


  /** Constructor assuming no header line.
   * @param csv Delimited text file to read.
   */
  SafeCsvReader(File csv) {
    srcFile = csv
    withHeader = false
  }


  /** Constructor specifying whether or not to read a header line.
   * @param csv Delimited text file to read.
   * @param hasHeader True if csv file includes a header line 
   * we should omit.
   */
  SafeCsvReader(File csv, boolean hasHeader) {
    srcFile = csv
    withHeader = hasHeader
  }



  /** Parses the first line csv file and return an array of
   * of strings.
   * @returens ArrayList of column values for header line. 
   */
  ArrayList readHeader() {
    return parseLine(srcFile.readLines()[0])
  }


  /** Parses csv file and return a two-dimensional array list
   * of lines correctly parsed into columns. If withHeader is
   * true, omits the first ine of the file.
   * @returns ArrayList of lines, each of which is an ArrayList
   * of columns.
   */
  ArrayList readAll() {
    ArrayList csvContent = []
    boolean headerSeen = false
    srcFile.eachLine { l ->
      if (withHeader && headerSeen == false) {
	// skip line
	headerSeen = true
      } else {
	ArrayList oneLine = parseLine(l)
	csvContent.add (oneLine)
      }
    }
    return csvContent
  }




  /** Strips leading and trailing white space from a string without
   * damaging Unicode characters outside the BMP.
   * @param s String to trim.
   * @returns A String with no leading or trailing white space.
   */
  String stripWhiteSpace(s) {
    boolean inContent = false
    
    String stripLeadingWhite = ""
    int max = s.codePointCount(0, s.length() - 1)
     (0..max).each { idx ->
      int cp = s.codePointAt(idx)
      String charAsStr =  new String(Character.toChars(cp))
      if ((!inContent ) && (charAsStr ==~ /\s/)) {
      } else {
	stripLeadingWhite += charAsStr
	inContent = true
      }
     }

     StringBuilder stripped = new StringBuilder()
     inContent = false
     int max2 = stripLeadingWhite.codePointCount(0, stripLeadingWhite.length() - 1)
     (max2..0).each { idx ->
       int cp = stripLeadingWhite.codePointAt(idx)
       String charAsStr =  new String(Character.toChars(cp))
       if ((!inContent ) && (charAsStr ==~ /\s/)) {
      } else {
	 stripped.insert(0, charAsStr)
	inContent = true
      }
     }
     return stripped.toString()
  }


  /** Parses a String for a single record or line and
   * delimited according to safecsv syntax into an ArrayList.
   * @param s The String to parse.
   * @returns An ordered list of Strings.
   */
  ArrayList parseLine(String s) {
    ArrayList valuesByColumn = []

    String ln = stripWhiteSpace(s)
    
    boolean inQuoted = false
    StringBuilder columnValue = new StringBuilder()
    int max = ln.codePointCount(0, ln.length() - 1)
     (0..max).each { idx ->
      int cp = ln.codePointAt(idx)
      String charAsStr =  new String(Character.toChars(cp))


      if  (charAsStr == quotation) {
	inQuoted = !inQuoted
	
      } else  if ((charAsStr == columnDelimiter) && (!inQuoted)) {
	  valuesByColumn.add(columnValue.toString())
	  columnValue.setLength(0)
	
      } else {
	columnValue.append(charAsStr)
      }
      
     }
     valuesByColumn.add(columnValue.toString())
    return valuesByColumn    
  }
}