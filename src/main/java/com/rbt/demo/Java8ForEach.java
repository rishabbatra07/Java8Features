package com.rbt.demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

//Consumer Interface in Java8
//Accept method in consumer


	@FunctionalInterface
	interface Rectangle {
	    int calculate(int length,int breadth);
	}
  
	class Car {
		private final int horsePowers = 0;
		private final int topSpeed = 0;
		private final int numDoors = 0;
		private String color = "";
		Car(String color){
    	this.color=color;
		}
		public String getColor() {
		// TODO Auto-generated method stub
			return color;
		}
	}

public class Java8ForEach {

			public static void main(String[] args) {	
			List<String> nameList= new ArrayList<String>();
			for(int start=0; start<10; start++) nameList.add("rish"+start);
			Iterator<String> it= nameList.iterator();
			while(it.hasNext()) {
				String name=it.next();
			//	System.out.println("Iterator Value::"+name);
				
			}
			//Role of Consumer in resolving iterator issues
			nameList.forEach(new Consumer<String>(){
				@Override
				public void accept(String name) {
					System.out.println("Iterator Value:"+name);
					
				}
				
			});
			
			
			//Why functional interfaces
			 new Thread(new Runnable() {
		            @Override public void run()
		            {
		                System.out.println("New thread created");
		            }
		        }).start();
	
			//Role of Functional Interfaces		
			 //@FunctionalInterface annotation is used to ensure that the functional interface can’t have more than one abstract method. 
			 new Thread(()->{
			 		System.out.println("thread start using functional interface");
			 	}).start();
			 
			 
			  	int a = 5;

		        // lambda expression to define the calculate method
		        Rectangle area = (int length,int breadth) -> length * breadth;
		        int ans = area.calculate(4,5);
		        System.out.println("Area of Rectangle is "+ans);

		    
		        List<Car> cars=new ArrayList<>();
		        cars.add(new Car("yellow"));
		        cars.add(new Car("green"));
		        cars.add(new Car("red"));
		       
		        //old way
		        /*
		        Collections.sort(cars, new Comparator<Car>(){
		            @Override
		            public int compare(final Car lhs, final Car rhs) {
		                return lhs.getColor.compareTo(rhs.getColor());
		            }
		        });*/
		       // new way with functional Interfaces
		        Collections.sort(cars, (firstCar, otherCar) -> firstCar.getColor().compareTo(otherCar.getColor()));
		        cars.forEach(new Consumer<Car>() {

					@Override
					public void accept(Car t) {
						// TODO Auto-generated method stub
						System.out.println("Iterator Value:"+t.getColor());
					}
		        	
		        });
		        
		  //In above examples Runnable and Comparable shown with functional Interfaces

	}
}
	