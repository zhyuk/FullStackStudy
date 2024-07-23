package first;

public class Car {
       int wheel;
       String p;
       
       public Car() {
    	   wheel = 4;
    	   p = "부품";
       }
       
       public void carWheel(int wh) {
    	   wheel = wh;
    	  System.out.println("바퀴의 개수 " + wh);
       }
       
       public void carParts(String po) {
    	   p = po;
    	   System.out.println(po);
    	  
       }      
}
