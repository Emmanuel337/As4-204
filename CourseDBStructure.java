import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

  protected LinkedList<CourseDBElement>[] hashTable;

  
 
  @Override
  public void add(CourseDBElement element) {
     
    int index = getHashIndex(element);

    if (hashTable[index] == null) {
      hashTable[index] = new LinkedList<CourseDBElement>();
      hashTable[index].add(element);
    } else {
      if (hashTable[index].contains(element))
        return;
      else
        hashTable[index].add(element);
    }
  }

  @SuppressWarnings("unchecked")
  public CourseDBStructure(String string, int i) {
    hashTable = new LinkedList[i];
  }

  private int getHashIndex(CourseDBElement element) {
	    int hashIndex = element.hashCode() % hashTable.length;
	    if (hashIndex < 0) {
	      hashIndex += hashTable.length;
	    }
	    return hashIndex;
	  }
   
  @Override
  public CourseDBElement get(int crn) throws IOException {

    CourseDBElement temp = new CourseDBElement();

    temp.setCRN(crn);
    int index = getHashIndex(temp);
    LinkedList<CourseDBElement> list = hashTable[index];

    return list.stream().filter(c -> c.getCRN() == crn).findAny().orElseThrow(IOException::new);
  }

  @SuppressWarnings("unchecked")
  public CourseDBStructure(int i) {
    hashTable = new LinkedList[i];
  }
   
  @Override
  public int getTableSize() {
    return hashTable.length;
  }

   
  

}