public class File extends DirectoryComponent {

  // Properties
  String fileName;
  String extension;
  int fileSize;

  // Constructors
  public File() {
    this.fileName = null;
    this.extension = null;
    this.fileSize = 0;
  }

  public File( String fileName, String extension, int fileSize ) {
    this.fileName = fileName;
    this.extension = extension;
    this.fileSize = fileSize;
  }

  // Methods
  public String getInfo() {
    return ( this.fileName + "." + this.extension + " | File Size: " + this.fileSize + " kb\n" );
  }

  public int getFileSize() {
    return fileSize;
  }

  public String getFileName() {
    return fileName;
  }

  public String getExtension() {
    return extension;
  }

  public void setFileSize(int fileSize) {
    this.fileSize = fileSize;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }
}
