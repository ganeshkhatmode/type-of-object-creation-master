package com.gk.createobject;

import java.io.Serializable;

public class Bank implements Cloneable,Serializable{

	int bankId;

	public Bank() {
		System.out.println("Create constructor...");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	
	
}
