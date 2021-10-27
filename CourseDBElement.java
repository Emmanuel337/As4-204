
public class CourseDBElement implements Comparable {

  private String courseID;
  private int CRN;
  private int credits;
  private String Room;
  private String instructor;

  public CourseDBElement(String courseID, int CRN, int credits, String Room, String instructor) {
    this.courseID = courseID;
    this.CRN = CRN;
    this.credits = credits;
    this.Room = Room;
    this.instructor = instructor;
  }

  public CourseDBElement() {
    this.courseID = "";
    this.CRN = 0;
    this.credits = 0;
    this.Room = "";
    this.instructor = "";
  }

  
  
  public String getRoom() {
    return Room;
  }

  
  public void setcourseID(String courseID) {
    this.courseID = courseID;
  }

  public String getInstructor() {
	    return instructor;
	  }
   
  public int getCRN() {
    return CRN;
  }

   
  public void setCRN(int CRN) {
    CRN = CRN;
  }
  
  public String getcourseID() {
	    return courseID;
	  }
   
  public int getCredits() {
    return credits;
  }

   
  public void setCredits(int credits) {
    this.credits = credits;
  }

   
   
  public void setRoom(String Room) {
    this.Room = Room;
  }

  
  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  @Override
  public int compareTo(CourseDBElement element) {
    return Integer.compare(this.getCRN(), element.getCRN());
  }
  
   
  @Override
  public int hashCode() {
    String s = String.valueOf(getCRN());
    long hash = 0;
    int prime = 31;
    for (int i = 0; i < s.length(); i++) {
      hash = prime * hash + s.charAt(i);
    }
    return (int) hash;
  }

   
  @Override
  public String toString() {
    return "\nCourse:" + courseID + " CRN:" + CRN + " Credits:" + credits + " Instructor:"
        + instructor + " Room:" + Room;
  }

   
  
  @Override
  public boolean equals(Object obj) {
    if (obj == null){
        return false;
    }

    if (obj == this) {
        return true;
    } 

    if (!(obj instanceof CourseDBElement)) {
        return false;
    }
    CourseDBElement cde = (CourseDBElement) obj;
    return this.getCRN() == cde.getCRN();
}

}