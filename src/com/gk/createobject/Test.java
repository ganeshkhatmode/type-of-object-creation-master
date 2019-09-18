package com.gk.createobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException, IOException {
		/**
		 * 1) To create object using new keywords
		 */
		Bank bank = new Bank();
		bank.bankId = 101;
		System.out.println(bank);
		System.out.println(bank.bankId);
		System.out.println("*********************************");
		/**
		 * 2) To create object using newInstance() method They are two type of using
		 * newInstance() method i) using Class Class ii) using Class Constructor
		 */
//		Bank b2 = Bank.class.newInstance();
		Bank b2 = (Bank) Class.forName("com.gk.createobject.Bank").newInstance();
		b2.bankId = 101;
		System.out.println(b2);
		System.out.println(b2.bankId);
		System.out.println("*******************************");
		Constructor b3 = Bank.class.getConstructor();
		Bank b31 = (Bank) b3.newInstance();
		b31.bankId = 103;
        System.out.println(b31);
        System.out.println(b31.bankId);
        System.out.println("*********************");
        /**
         * 4) To using Clonable interface and clone() method
         * suppose b31 object copy create as it is then we are using clone() method
         * but check here constructor is not create if you are using clone method
         */
       Bank b4 =  (Bank) b31.clone();
       System.out.println(b4);
       System.out.println(b4.bankId);
       System.out.println("********************");
       /**
        * 5) To create object using deSerializable
        *   First to create Serializable object
        *   add new object create and write in file
        *   
        */
       //Serializable
//       FileOutputStream fos = new FileOutputStream("object.txt");
//       ObjectOutputStream oos = new ObjectOutputStream(fos);
//       Bank b5 = new Bank();
//       oos.writeObject(b5);
       
       //DeSerializable
       FileInputStream fis = new FileInputStream("object.txt");
       ObjectInputStream ois = new ObjectInputStream(fis);
       Bank b6 =  (Bank) ois.readObject();
       System.out.println(b6);
       b6.bankId = 106;
       System.out.println(b6.bankId);
    /**
     * Last two way have not called constructor
     * 1) Clone()
     * 2) Deserializable concept       
     */
       
        
	}

}
