import java.util.ArrayList;

public class Directory extends DirectoryComponent {

  // Properties
  String directoryName;
  ArrayList<DirectoryComponent> directoryComponents = new ArrayList<DirectoryComponent>();
  int itemCount;
  ModellingStrategy modelling;

  //Constructors
  public Directory() {
    this.directoryName = null;
    this.itemCount = 0;
  }
  public Directory( String directoryName ) {
    this.directoryName = directoryName;
    this.itemCount = 0;
  }

  // Methods
  public String getInfo() {

    StringBuilder structureStr = new StringBuilder();

    structureStr.append( "- " + directoryName + "\n" );
    for (DirectoryComponent component : directoryComponents) {
      structureStr.append(component.getInfo());
    }
    structureStr.append( "- DIRECTORY END | " + directoryName + "\n" );
    return structureStr.toString();
  }

  public void addComponent( DirectoryComponent component ) {
    itemCount++;
    directoryComponents.add(component);
  }

  public String getDirectoryName() {
    return directoryName;
  }

  public ArrayList<DirectoryComponent> getFileComponents() {
    return directoryComponents;
  }

  public int getItemCount() {
    return itemCount;
  }

  public void setDirectoryName(String directoryName) {
    this.directoryName = directoryName;
  }

  public void setItemCount(int itemCount) {
    this.itemCount = itemCount;
  }

  public String applyMemoryRepresentation( ){
    return modelling.printMemory(this);
  }

  public void adjustMemoryRepresentation( ModellingStrategy modelling ) {
    this.modelling = modelling;
  }

}
