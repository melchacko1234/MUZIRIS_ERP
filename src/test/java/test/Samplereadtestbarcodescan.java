package test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Readingbarcode_excel;

public class Samplereadtestbarcodescan {
	
	
	
	
	//@Test (dataProvider = "Testdata1" )
	    public void myTest (String val) {
	        //System.out.println("Passed Parameter Is : " + val);
	    }
	  
	 //@DataProvider(name="Testdata1")
	  public Object [][]  myTest1 () throws IOException {
		  
		  Readingbarcode_excel rd= new Readingbarcode_excel();
		  
		  Object [][] arr= rd.xlsx();
		  
		 System.out.println("Test is success "+ arr[3][0]);
		return arr;
		  
	  }
	       
	  
	}


