package com.perficient.techbootcampMaxTybar;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
/*
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
*/

@SpringBootTest
class TechbootcampMaxTybarApplicationTests {

	TechbootcampMaxTybarApplication TestClass;

	@BeforeEach
	void setUp() {
		TestClass = new TechbootcampMaxTybarApplication();
	}

	/*
	@Test
	@DisplayName("Simple multiplcation should work")
	void testMultiply() {
        assertEquals(20, TestClass.multiply(4, 5),     
                "Regular multiplication should work"); 
    }

    @RepeatedTest(5)                                    
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        assertEquals(0, TestClass.multiply(0, 5), "Multiple with zero should be zero");
        assertEquals(0, TestClass.multiply(5, 0), "Multiple with zero should be zero");
    }

	@Test
	void testMock() {
		// mock creation
		List mockedList = mock(List.class);
		// using mock object - it does not throw any "unexpected interaction" exception
		mockedList.add("one");
		mockedList.clear();
		// selective, explicit, highly readable verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
	*/
}

