/* This program caculates the amount of students that pass 
 * @author  John Omage
* @version 1.0
* @since   Year-Month-Day
*/

// import
import java.io.*;
import java.util.Scanner;
	 /**.
  // main
  */
 public class PassOrFail {

  /**
   * * Required javadoc.
 */
  
  public static void main(String[] args) {
    
    try {
      // create file
      File myObj = new File("DATA10.txt");
      
      // create to write files
      FileWriter myWriter = new FileWriter("DATA10Answers.txt");
      
      // allow scanner to read text file 
      Scanner myReader = new Scanner(myObj);
      
      // declare var
      int honourRoll = 0;
      
      while (myReader.hasNextLine()) {
        
        // set string to scanner next line
        String line = myReader.nextLine();
        
        // print out the weights
        //System.out.println("Weights: " + line);
        
        // split string marks into individual weights
        String [] lineArray = line.split(" ");
        
        // convert each weight to integer
        float wTest = Integer.parseInt(lineArray[0]);
        float wAssignments = Integer.parseInt(lineArray[1]);
        float wProjects = Integer.parseInt(lineArray[2]);
        float wQuizzes = Integer.parseInt(lineArray[3]);
        
        // read numOfStudents next line
        String lineNumberStu = myReader.nextLine();
        
        // convert to int 
        int numOfStudents = Integer.parseInt(lineNumberStu);
        
        // print number of students
        //System.out.println("There are " + numOfStudents + " students.");
        
        // declare variable
        int numPassed = 0;
        int numFailed = 0;
        // for loop until index is greater than numStudent
        for (int i = 0; i < numOfStudents; i++) {
          
          // read the marks
          String lineMarks = myReader.nextLine();
          
          // split string marks into individual weights
          String [] lineMarksArray = lineMarks.split(" ");
          
          // convert marks to float
          float initialTest = Float.parseFloat(lineMarksArray[0]);
          float initialAssignments = Float.parseFloat(lineMarksArray[1]);
          float initialProjects = Float.parseFloat(lineMarksArray[2]);
          float initialQuizzes = Float.parseFloat(lineMarksArray[3]);
          
          // calculate the average
          float markTest = (wTest * initialTest);
          float markAssignments = (wAssignments * initialAssignments);
          float markProjects = (wProjects * initialProjects);
          float markQuizzes = (wQuizzes * initialQuizzes);
          float stuAvg = (markTest + markAssignments + markProjects + markQuizzes);
          stuAvg = stuAvg / (wTest + wAssignments + wProjects + wQuizzes);
          
          //System.out.println(stuAvg);
          
          // check to see how many students
          // passed 
          if (stuAvg >= 50) {
            numPassed++;
          } 
          
          // check to see how many students got
          // on the honour roll
          if (stuAvg >= 80) {
            honourRoll++;
          } 
          
          // check to see how many failed + increment
          if (stuAvg < 50) {
            numFailed++;
          }
        }
        // print num passed
        System.out.println(numPassed);
        
        // write to text solutions 
        myWriter.write("passed: " +  numPassed + "\n\r");
        myWriter.write("failed: " + numFailed + "\n\r");
        
      }
      
      // print honour roll
      System.out.println("Students on honour roll: " + honourRoll);
      
      // write to text solutions
      myWriter.write("Students on honour roll: " + honourRoll);
      
      // close the write 
      myWriter.close();
      
    } catch (IOException e) {
      // print error
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
