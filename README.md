
# jdummy

Short Description : 
jdummy is library for generating dummy data. this library is annotation based dummy generated. the annotation should be set on every field of the classes that we will generate.

What the main feature ? 
- List Dummy Data Generated
- Single Object Dummy Data Generated

What we need ? 
- POJO Class (private field, getter setter for every single filed is mandatory)
- field with interface or enum as type won't be processed.
- String, Integer, Date data type can be generated automatically without any annotation, except you put @DummyIgnore. it will be ignore (won't be processed).
- put one of the annotation on the class field : 
	+ @DummyAddress : generated dummy short address. the data type is string.
	+ @DummyBusinessName : generated dummy business name. it's usually used for sample of company name. the data type is String.
	+ @DummyLongAddress : generated dummy long address contains of address and city. the data type is string.
	+ @DummyCity : generated dummy city. the data type is string.
	+ @DummyDate : generated dummy date, now we only support generate random date between first and the last date of current month. the data type is java.util.Date.
	+ @DummyFirstName : generated dummy first name. the data type is string.
	+ @DummyLastName : generated dummy last name. the data type is string.
	+ @DummyFullName : generated dummy full name. the data type is string.
	+ @DummyNumber : generated dummy number. now we only support 5 character length of the number. the data type is Integer.
	+ @DummyIgnore : this annotated field will be ignore (won't be processed)
	
How To Use ? 
```
public static void main(String[] args) {
	Dummy<TestModel> test = new Dummy<TestModel>(TestModel.class);
	try {
		System.out.println(test.generateList());
	} catch (Exception e) {
		e.printStackTrace();
	}
}
```
