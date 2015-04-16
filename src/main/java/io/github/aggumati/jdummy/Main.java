package io.github.aggumati.jdummy;

import io.github.aggumati.jdummy.model.TestModel;

public class Main {
	public static void main(String[] args) {
		Dummy<TestModel> test = new Dummy<TestModel>(TestModel.class);
		try {
			System.out.println(test.generateList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
