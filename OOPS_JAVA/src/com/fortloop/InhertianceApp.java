package com.fortloop;

// class - textual rep of how an object looks like in a memory
//whatever we write in class is actually the property of an object as a class is used to describe an object
//pid ,price do not belong to class.... self explananotry 
// constructor and the methds belong to class
//if u wantn anything to belong to class name it static!!
 class Product{
	 //attributes
	 private int pid;
	 String name;
	 int price;
	 
	 
	 //constructor
	 Product(){
		 System.out.println("Product constructed\n");
	 }
	 
	 //methods (behaviour)
	 //we have this mtd to write data in pdt obj
	 void setProductDetails(int pid,String name, int price) {
		 this.pid=pid;
		 this.name=name;
		 this.price=price;
	 }
	 
	 void showProductDetails() {
		 System.out.println("pid "+pid);// notice we havn't used the this keyword, if we want we can also use it
		 System.out.println("name "+name);
		 System.out.println("price "+price); 
		 System.out.println("------------\n\n");
		 
	 }
	 
	 
	 // setter for pid as pid is private
	 void setPid(int pid) {
		 this.pid=pid;// this keyword refers to the current object
	 }
	 
	 // a getter method 
	 int getPid() {
		 return this.pid;// we can also avoid the this keyword
	 }
	 
 }
 
 // now lets move on to an inherited class
 class Mobile extends Product{
	 
	 String os;
	 int ram;
	 
	 
	 Mobile(){
		 System.out.println("Mobile constructed\n");
	 }
	 
	 /*
	  *we have redefined the same mtd from parent to child with diff inputs
	  *we hav 2 mtds in the child now
	  *both are different based on inputs 
	  * this is called method overriding
	  * */
	  
	 void setProductDetails(int pid,String name, int price, String os, int ram) {
		 this.setPid(pid);// as pid is private
		 this.name=name;
		 this.price=price;// notice that the inherited class has access its parents properties
		 this.os=os;
		 this.ram=ram;
	 }
	 
	 void showProductDetails() {
		 System.out.println("pid "+this.getPid());//pid is private
		 System.out.println("name "+name);
		 System.out.println("price "+price); 
		 System.out.println("os "+os);
		 System.out.println("ram "+ram); 
		 System.out.println("------------\n\n");
		 
	 }
	 
 }

public class InhertianceApp {
	
	// main is executed by JVM when we run the program 

	public static void main(String[] args) {
		
		System.out.println("main pg started\n");
		// TODO Auto-generated method stub
		Product product = new Product();
		// product is not an object its a reference variable which holds the hashcode of the objetc in hex notation
		System.out.println("pdt: "+product);// 7852e922 hashcode
		
		//writing data in object
		product.setProductDetails(101, "iPhoneX",70000);
		
		//reading data from object
		product.showProductDetails();
		
		//writing data directly
		//this is because we havnt put private as the access modifier
		// even protected allows the inherited objects to edit its properties
		Product pdt2 = new Product();
		//pdt2.pid=201; cant be set as pid is private// so use a setter
		pdt2.name="cool";
		pdt2.price=341234;
		
		pdt2.setPid(98);// this is done as pid is private
		pdt2.showProductDetails(); // pid can be viewewd though it is private from a method of the class there is an other way below
		System.out.println("pdt2 pid : "+pdt2.getPid());
		
		
		
		Mobile mob = new Mobile();
		/// first parent class is constructed and then the inherited class -> rule of inheritance
		
		mob.setProductDetails(90, "Iphone", 1000,"IOS",2);/// notice that this method is from the Mobile class,
		//suppose if the method was not there, then the complier would searched for it in the parent class of mobile and have executed it
		mob.showProductDetails();
		 
		
	}

}

//polymorphism 

//types - compile time polymorphism or static polymorphism -overloading
// run time poly - method overriding 
