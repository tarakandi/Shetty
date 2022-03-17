package Test;

import org.testng.annotations.Test;

public class APITest {
  @Test
  public void firstAPI() 
  {
	  System.out.println("This is not an API Test");
	  System.out.println("Test out pull request from cmd");
	  System.out.println("Switch to master branch");
  }
  
  public void secondAPI()
  {
	  System.out.println("myBranch");
  }
  
  public void myAPI()
  {
	  System.out.println("This is to test branching more");
  }
  
}
