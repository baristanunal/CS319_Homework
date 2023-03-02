public class Indentation extends FunctionalityDecorator {

  DirectoryComponent component;

  public Indentation( DirectoryComponent component ){
    this.component = component;
  }

  /*
  public String getInfo() {

    StringBuilder str = new StringBuilder(component.getInfo());
    int depth = 0;
    int indexNL = 0;
    int offset = 0;
    StringBuilder tempStr = new StringBuilder(component.getInfo());

    while( tempStr.indexOf("\n") != str.length() ) {

      indexNL = tempStr.indexOf("\n");
      System.out.println( "next newLine: " + tempStr.indexOf("\n"));
      offset = offset + indexNL;
      System.out.println( "offset: " + offset);

      if (tempStr.length() > indexNL + 15 && tempStr.substring(indexNL + 1, indexNL + 16).equals("- DIRECTORY END")) {
        depth--;
        for (int j = 0; j < depth; j++) {
          str.insert(indexNL + 1 + offset, "\t");
        }
      } else if (str.substring(indexNL + 1, indexNL + 2).equals("-")) {
        for (int j = 0; j < depth; j++) {
          str.insert(indexNL + 1 + offset, "\t");
        }
        depth++;
      } else {
        for (int j = 0; j < depth; j++) {
          str.insert(indexNL + 1 + offset, "\t");
        }
      }
      tempStr = new StringBuilder( tempStr.substring( indexNL + 1 ) );
    }
    return str.toString();
  }

   */

  public String getInfo() {

    String str = component.getInfo();
    int depth = 0;
    String[] lines = str.split("\n");
    String newStr = "";

    for( String thisLine: lines ) {

      // end of directory
      if ( thisLine.contains("- DIRECTORY END")) {
        depth--;
        for (int j = 0; j < depth; j++) {
          thisLine = "\t" + thisLine;
        }
      }
      // file component
      else if(thisLine.contains("File Size:")) {
        for (int j = 0; j < depth; j++) {
          thisLine = "\t" + thisLine;
        }
      }
      // start of directory
      else if(thisLine.contains("-") ) {
        for (int j = 0; j < depth; j++) {
          thisLine = "\t" + thisLine;
        }
        depth++;
      }
      newStr = newStr + "\n" + thisLine;
    }
    return newStr;
  }
}
