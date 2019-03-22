package com.fermod.eventdispatcher.observer;

import static org.junit.Assume.assumeNoException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.fermod.eventdispatcher.data.serializable.PersonTest;

class ObservableValueTest {

	static File tempFile;
	boolean eventInvoked;

	@BeforeEach
	void beforeEach() {
		initTempFile("SerializedObjectTest");
		eventInvoked = false;
	}

	private void initTempFile(String fileName) {
		try {
			tempFile = File.createTempFile(fileName, ".tmp");
			tempFile.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(tempFile != null) {
				tempFile.delete();
			}
		}
	}

	@DisplayName("Test Event - Method Invocation")
	@ParameterizedTest
	@CsvSource({"30, 10", "-2, 10", "11, 10"})
	void testEventMethodInvocation(int expected, int value, TestInfo testInfo) {

		try {
			ObservedValue<Integer> observedValue = new ObservedValue<>(10);
			observedValue.registerListener((oldVAlue, newValue) -> {
				eventInvoked = true;
				assertAll("EventValues",
					() -> assertEquals(oldVAlue, (Integer)value, () -> "New value missmatch in event invocation."),
					() -> assertEquals(newValue, (Integer)expected, () -> "Old value missmatch in event invocation.")
				);
			});

			observedValue.set(expected);

			assertTrue(eventInvoked, () -> "Event method not invoked.");
		} catch (Exception e) {
			fail("Unexpected exception thrown in " + testInfo.getClass().getSimpleName() + "\n\tCase: " + testInfo.getDisplayName(), e);
		}
	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - Boolean")
	@ParameterizedTest
	@CsvSource({"true", "false"})	
	void testSerialization(boolean expected) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		ObservedValue<Boolean> observedValue = new ObservedValue<>(expected);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<Boolean> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<Boolean>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expected, value.get());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - Byte")
	@ParameterizedTest
	@CsvSource({"65"})		
	void testSerialization(byte expected) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		ObservedValue<Byte> observedValue = new ObservedValue<>(expected);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<Byte> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<Byte>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expected, value.get());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - Char")
	@ParameterizedTest
	@CsvSource({"A", "T"})		
	void testSerialization(char expected) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		ObservedValue<Character> observedValue = new ObservedValue<>(expected);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<Character> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<Character>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expected, value.get());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - Short")
	@ParameterizedTest
	@CsvSource({"65"})		
	void testSerialization(short expected) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		ObservedValue<Short> observedValue = new ObservedValue<>(expected);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<Short> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<Short>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expected, value.get());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - Int")
	@ParameterizedTest
	@CsvSource({"65"})		
	void testSerialization(int expected) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		ObservedValue<Integer> observedValue = new ObservedValue<>(expected);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<Integer> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<Integer>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expected, value.get());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - Long")
	@ParameterizedTest
	@CsvSource({"65"})		
	void testSerialization(long expected) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		ObservedValue<Long> observedValue = new ObservedValue<>(expected);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<Long> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<Long>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expected, value.get());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - Float")
	@ParameterizedTest
	@CsvSource({"65f"})		
	void testSerialization(float expected) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		ObservedValue<Float> observedValue = new ObservedValue<>(expected);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<Float> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<Float>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expected, value.get());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - Double")
	@ParameterizedTest
	@CsvSource({"65.55"})	
	void testSerialization(double expected) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		ObservedValue<Double> observedValue = new ObservedValue<>(expected);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<Double> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<Double>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expected, value.get());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - String")
	@ParameterizedTest
	@CsvSource({"'Test of string', 'Another test'"})		
	void testSerialization(String expected) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		ObservedValue<String> observedValue = new ObservedValue<>(expected);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<String> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<String>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expected, value.get());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test Serialization - Object")
	@ParameterizedTest
	@CsvSource({"Paco, 44", "Lola, 41"})
	void testSerialization(String name, int age) {

		assumeTrue(tempFile != null);
		File file = tempFile;

		PersonTest expectedTestClass = new PersonTest(name, age);
		ObservedValue<PersonTest> observedValue = new ObservedValue<PersonTest>(expectedTestClass);

		serialiceToFile(file, observedValue);
		assumeTrue(file.length() > 0);

		ObservedValue<PersonTest> value = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			try(ObjectInputStream objectInputStream	= new ObjectInputStream(fileInputStream)) {
				value = (ObservedValue<PersonTest>) objectInputStream.readObject();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertEquals(expectedTestClass, value.get(), "" + observedValue.get().hashCode() + " " + value.hashCode());				
	}

	private <T> void serialiceToFile(File file, T value) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
				objectOutputStream.writeObject(value);	
				objectOutputStream.flush();
			}
		} catch (Exception e) {
			assumeNoException(e);
		}
	}

}