# safecsv

A JVM library  for reading CSV files without damaging content in Unicode characters beyond the basic multilingual plane.

## Why?

Some widely used libraries for working with `.csv` files read arrays of bytes or streams of characters, and fail to preserve Unicode codepoints outside the basic multilingual plane.  `safecsv` reads `.csv` sources by Unicode codepoint, so it is reliable rather than fast.

More information:  <http://neelsmith.github.io/safecsv/>


## Example: basic usage

This script (in groovy) reads a `.csv` file and prints the first column of every row:

    import edu.holycross.shot.safecsv.SafeCsvReader

    SafeCsvReader srcReader = new SafeCsvReader("CSVFILE")
    srcReader.readAll().each { record ->
        println("First column is " + record[0])
    }


## Example: delimited text file with header line

This script (in groovy) reads a `.csv` file and prints the first column of every row labelled with the value from the corresponding header column:

    import edu.holycross.shot.safecsv.SafeCsvReader

    boolean hasHeader = true
    SafeCsvReader srcReader = new SafeCsvReader("CSVFILE", true)
    def headers = srcReader.readHeader()
    srcReader.readAll().each { record ->
        println("Column " + headers[0] + ": " + record[0])
    }
