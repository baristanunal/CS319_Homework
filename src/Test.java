import java.lang.reflect.Type;

public class Test {

  public static void main(String[] args) {

    System.out.println("Hello world!");

    // Creating the files and directories.
    File interstellar_hd = new File( "Interstellar_2014_hd", "mp4", 354536  );
    File suspiria_sd = new File( "Suspiria_1977_sd", "mov", 235642 );
    File scream_sd = new File( "Scream_1996_sd", "mp4", 343542 );
    File theShining_hd = new File( "TheShining_1980", "avi", 823213 );
    File killBillVol1_hd = new File( "KillBillVol1_2003_hd", "mp4", 198493 );
    File et_sd = new File( "ETTheExtraTerrestrial_1982_sd", "mp4", 538102 );
    File contact_sd = new File( "Contact_1997_sd", "avi", 335421 );
    File matrix_sd = new File( "TheMatrix_1999_sd", "mp4", 435254 );
    File mi4_hd = new File( "MissionImpossible4_2011_hd", "mov", 653120 );
    Directory movies = new Directory( "movies" );
    Directory movies_hd = new Directory("HD_Movies");
    Directory movies_sd = new Directory("SD_Movies");
    Directory horrorMovies_hd = new Directory( "HD_Horror" );
    Directory horrorMovies_sd = new Directory( "SD_Horror" );
    Directory actionMovies_hd = new Directory( "HD_Action" );
    Directory actionMovies_sd = new Directory( "SD_Action" );
    Directory scienceFictionMovies_hd = new Directory( "HD_SciFi" );
    Directory scienceFictionMovies_sd = new Directory( "SD_SciFi" );

    // Adding the directory components to the memory.
    scienceFictionMovies_hd.addComponent(interstellar_hd);
    scienceFictionMovies_sd.addComponent(contact_sd);
    scienceFictionMovies_sd.addComponent(et_sd);
    scienceFictionMovies_sd.addComponent(matrix_sd);
    horrorMovies_sd.addComponent(suspiria_sd);
    horrorMovies_hd.addComponent(theShining_hd);
    horrorMovies_sd.addComponent(scream_sd);
    actionMovies_hd.addComponent(killBillVol1_hd);
    actionMovies_hd.addComponent(mi4_hd);
    movies_sd.addComponent(horrorMovies_sd);
    movies_sd.addComponent(actionMovies_sd);
    movies_sd.addComponent(scienceFictionMovies_sd);
    movies_hd.addComponent(horrorMovies_hd);
    movies_hd.addComponent(actionMovies_hd);
    movies_hd.addComponent(scienceFictionMovies_hd);
    movies.addComponent(movies_hd);
    movies.addComponent(movies_sd);


    // PART 1

    // Directory info without indentation, without type indication.
    System.out.println("\nPART 1");
    System.out.println( "\nDirectory info without indentation, without type indication:" );
    System.out.println( movies.getInfo() );


    // PART 2
    System.out.println("\nPART 2");

    // CASE 1: Directory info with indentation, without type indication.
    System.out.print( "\nDirectory info with indentation, without type indication:" );
    Indentation moviesWithIndentation = new Indentation(movies);
    System.out.println( moviesWithIndentation.getInfo() );

    // CASE 2: Directory info without indentation, with type indication.
    System.out.print( "\nDirectory info without indentation, with type indication:" );
    TypeIndication moviesWithTypeIndication = new TypeIndication(movies);
    System.out.println( moviesWithTypeIndication.getInfo() );

    // CASE 3: Directory info with both, indentation applied first.
    System.out.print( "\nDirectory info with indentation, with type indication:" );
    TypeIndication moviesWithBothIndentFirst = new TypeIndication(moviesWithIndentation);
    System.out.println( moviesWithBothIndentFirst.getInfo() );

    // CASE 4: Directory info with both, type indication applied first.
    System.out.print( "\nDirectory info without indentation, with type indication:" );
    Indentation moviesWithBothTypeFirst = new Indentation(moviesWithTypeIndication);
    System.out.println( moviesWithBothTypeFirst.getInfo() );


    // PART 3
    System.out.print( "\n\nPART 3 \nSize-Based Model:\n" );
    SizeBasedModel sizeBasedModel = new SizeBasedModel();
    movies.adjustMemoryRepresentation( sizeBasedModel );
    System.out.println( movies.applyMemoryRepresentation() );

    System.out.print( "\nType-Based Model:\n" );
    TypeBasedModel typeBasedModel = new TypeBasedModel();
    movies.adjustMemoryRepresentation( typeBasedModel );
    System.out.println( movies.applyMemoryRepresentation() );

  }

}
