package io.github.aggumati.jdummy;

import io.github.aggumati.jdummy.model.TestModelBlank;

public class Main {
	public static void main(String[] args) {
		Dummy<TestModelBlank> test = new Dummy<TestModelBlank>(TestModelBlank.class);
		try {
			System.out.println(test.generateList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
