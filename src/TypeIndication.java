public class TypeIndication extends FunctionalityDecorator {

  DirectoryComponent component;

  public TypeIndication( DirectoryComponent component ){
    this.component = component;
  }

  public String getInfo() {

    String str = component.getInfo();
    String[] lines = str.split("\n");
    String newStr = "";

    for( String thisLine: lines ) {

      // end of directory
      if ( thisLine.contains("- DIRECTORY END")) {
        thisLine = "(!) " + thisLine;
      }
      // file  component
      else if(thisLine.contains("File Size:")) {
        thisLine = "(f) " + thisLine;
      }
      // start of directory
      else if(thisLine.contains("-")) {
        thisLine = "(d) " + thisLine;
      }
      newStr = newStr + "\n" + thisLine;
    }
    return newStr;
  }
}
