package com.java8.features;

@FunctionalInterface
public interface LambdaInterface {
	
	void method();
	default String method1() {
		return "this is functional interface";
	}

}
