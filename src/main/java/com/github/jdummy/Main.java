package com.github.jdummy;

import com.github.jdummy.model.TestModel;

public class Main {
	public static void main(String[] args) {
		Dummy<TestModel> test = new Dummy<TestModel>(TestModel.class);
		System.out.println(test.generateList());
	}
}
