package io.github.aggumati.jdummy;

import io.github.aggumati.jdummy.model.TestModelBlank;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println((new Dummy(TestModelBlank.class)).generateList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
