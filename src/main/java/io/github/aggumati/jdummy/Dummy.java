package io.github.aggumati.jdummy;

import io.github.aggumati.jdummy.config.DummyAddress;
import io.github.aggumati.jdummy.config.DummyBusinessName;
import io.github.aggumati.jdummy.config.DummyCity;
import io.github.aggumati.jdummy.config.DummyDate;
import io.github.aggumati.jdummy.config.DummyFirstName;
import io.github.aggumati.jdummy.config.DummyFullName;
import io.github.aggumati.jdummy.config.DummyIgnore;
import io.github.aggumati.jdummy.config.DummyLastName;
import io.github.aggumati.jdummy.config.DummyLongAddress;
import io.github.aggumati.jdummy.config.DummyNumber;
import io.github.aggumati.util.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;

public class Dummy<T extends Object> {
	
	private Class<T> clazz;
	
	public Dummy (Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public List<T> generateList() {
		return generateList( 20);
	}
	
	public List<T> generateList(int rows) {
		List<T> result = new ArrayList<T>();
		for(int i = 0; i<rows; i++)
			result.add(generateObject());
		return result;
	}
	
	public T generateObject() {
		DataFactory dataFactory = new DataFactory(); 
		
		try {
			T t = clazz.newInstance();
			Class<?> cls = t.getClass();
			
			Field[] allFields = cls.getDeclaredFields();
			
			for (int idx = 0; idx < allFields.length; idx++) {
				Field fieldTmp = allFields[idx];
				if (!fieldTmp.isAnnotationPresent(DummyIgnore.class) && !fieldTmp.getType().isInterface() && !fieldTmp.getType().isEnum()) {
					String methodName = "set"+StringUtil.capitalizeFirst(fieldTmp.getName());
					if (fieldTmp.isAnnotationPresent(DummyFullName.class)) {
						cls.getMethod(methodName, fieldTmp.getType()).invoke(t, dataFactory.getName());
					} else if (fieldTmp.isAnnotationPresent(DummyFirstName.class)) {
						cls.getMethod(methodName, fieldTmp.getType()).invoke(t, dataFactory.getFirstName());
					} else if (fieldTmp.isAnnotationPresent(DummyLastName.class)) {
						cls.getMethod(methodName, fieldTmp.getType()).invoke(t, dataFactory.getLastName());
					} else if (fieldTmp.isAnnotationPresent(DummyCity.class)) {
						cls.getMethod(methodName, fieldTmp.getType()).invoke(t, dataFactory.getCity());
					} else if (fieldTmp.isAnnotationPresent(DummyBusinessName.class)) {
						cls.getMethod(methodName, fieldTmp.getType()).invoke(t, dataFactory.getBusinessName());
					} else if (fieldTmp.isAnnotationPresent(DummyAddress.class)) {
						cls.getMethod(methodName, fieldTmp.getType()).invoke(t, dataFactory.getAddress());
					} else if (fieldTmp.isAnnotationPresent(DummyLongAddress.class)) {
						cls.getMethod(methodName, fieldTmp.getType()).invoke(t, dataFactory.getAddress() + " " + dataFactory.getAddress() + ", " + dataFactory.getCity());
					} else if (fieldTmp.isAnnotationPresent(DummyNumber.class)) {
						cls.getMethod(methodName, fieldTmp.getType()).invoke(t, new Integer(dataFactory.getNumberText(5)));
					} else if (fieldTmp.isAnnotationPresent(DummyDate.class)) {
						cls.getMethod(methodName, fieldTmp.getType()).invoke(t, dataFactory.getDate(new Date(), 1, 31));
					} 
				}
			}
			return t;
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	private void generate(Field fieldTmp) {
		
	}
}
