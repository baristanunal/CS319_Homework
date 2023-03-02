public class TypeBasedModel extends ModellingStrategy {

  public String printMemory( Directory directory ){

    String str = directory.getInfo();
    String[] lines = str.split("\n");
    String newStr = "{";
    int depth = 0;

    for( String thisLine: lines ) {

      // end of directory
      if ( thisLine.contains("- DIRECTORY END")) {
        depth--;
        newStr = newStr + " EOD" + depth + "]";
      }
      // file component
      else if(thisLine.contains("File Size:")) {
        newStr = newStr + " (F)";
      }
      // start of directory
      else if(thisLine.contains("-") ) {
        newStr = newStr + " [D" + depth;
        depth++;
      }
    }
    newStr = newStr + " }";
    return newStr;
  }

}
