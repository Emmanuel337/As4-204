 import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

 
public class CourseDBManager implements CourseDBManagerInterface {

  private CourseDBStructure cs;

  public CourseDBManager() {
    cs = new CourseDBStructure(10);
  }

  @Override
  public ArrayList<String> showAll() {
    ArrayList<CourseDBElement> tmp = new ArrayList<>();
    ArrayList<String> list;
    for (int i = 0; i < cs.getTableSize(); i++) {
      if (cs.hashTable[i] != null) {
        tmp.addAll(cs.hashTable[i]);
      }
    }
    list = (ArrayList<String>) tmp.stream().map(s -> s.toString()).collect(Collectors.toList());
    return list;
  }

 
  @Override
  public void add(String id, int crn, int credits, String roomNum, String instructor) {
	  
    CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
    cs.add(element);
  }

  
  @Override
  public CourseDBElement get(int crn) {
    try {
      return cs.get(crn);
    } catch (IOException e) {
      System.out.println("Exception was thrown in Manager get CRN");
      e.getMessage();
    }
    return null;
  }

   
  @Override
  public void readFile(File input) throws FileNotFoundException {
    InputStream in = new FileInputStream(input);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    List<String[]> list = br.lines().map(s -> s.split(" ")).collect(Collectors.toList());
    for (String[] ar : list) {
      if (ar.length > 5) {
        StringBuilder instructor = new StringBuilder();
        for (int i = 4; i < ar.length; i++) {
          instructor.append(ar[i] + " ");
        }
        cs.add(new CourseDBElement(ar[0], Integer.valueOf(ar[1]), Integer.valueOf(ar[2]), ar[3],
            instructor.toString().trim()));
   } else {
     cs.add(new CourseDBElement(ar[0], Integer.valueOf(ar[1]), Integer.valueOf(ar[2]), ar[3],
            ar[4]));
   }
  }
  }

  

}