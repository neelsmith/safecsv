package edu.holycross.shot.safecsv

class SafeCsvReader {


  String columnDelimiter = ","
  String quotation = '"'
  
  File srcFile
  
  SafeCsvReader(File csv) {
    srcFile = csv
  }


  
  ArrayList readAll() {
    ArrayList csvContent = []
    srcFile.eachLine {
      ArrayList oneLine = parseLine(it)
      csvContent.add (oneLine)
    }

    return csvContent
  }

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


  /** Parses a String delimited according to safecsv
   * syntax into an ArrayList.
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