public class SizeBasedModel extends ModellingStrategy {

  public String printMemory( Directory directory ){

    String str = directory.getInfo();
    String[] lines = str.split("\n");
    String newStr = "{";
    String fileSize;

    for( String thisLine: lines ) {

      // end of directory
      if ( thisLine.contains("- DIRECTORY END")) {
        newStr = newStr + " ]";
      }
      // file component
      else if(thisLine.contains("File Size:")) {
        thisLine = thisLine.substring(thisLine.indexOf(":"));
        fileSize = thisLine.replaceAll("[\\D]", "");
        newStr = newStr + " (" + fileSize + ")";
      }
      // start of directory
      else if(thisLine.contains("-") ) {
        newStr = newStr + " [";
      }
    }
    newStr = newStr + " }";
    return newStr;
  }
}
