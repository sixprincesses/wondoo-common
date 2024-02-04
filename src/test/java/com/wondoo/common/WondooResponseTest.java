package com.wondoo.common;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WondooResponseTest {

    @Nested
    class HasExceptionTest {
        @Test
        void returnTrueTest() {
            /* Given */
            CoffeeGroundResponse<String> response = CoffeeGroundResponse.failed(new RuntimeException());

            /* When */
            boolean condition = response.hasException();

            /* Then */
            assertTrue(condition);
        }

        @Test
        void returnFalseTest() {
            /* Given */
            CoffeeGroundResponse<String> response = CoffeeGroundResponse.ok("wondoo");

            /* When */
            boolean condition = response.hasException();

            /* Then */
            assertFalse(condition);
        }
    }


    @Nested
    class IsSuccess {
        @Test
        void returnTrueTest() {
            /* Given */
            CoffeeGroundResponse<String> response = CoffeeGroundResponse.ok("wondoo");

            /* When */
            boolean condition = response.isSuccess();

            /* Then */
            assertTrue(condition);
        }

        @Test
        void returnFalseTest() {
            /* Given */
            CoffeeGroundResponse<String> response = CoffeeGroundResponse.failed(new RuntimeException());

            /* When */
            boolean condition = response.isSuccess();

            /* Then */
            assertFalse(condition);
        }
    }

    @Nested
    class GetOrDefault {
        @Test
        void getDefaultValueTest() {
            /* Given */
            String defaultValue = "wondoo";
            CoffeeGroundResponse<String> response = CoffeeGroundResponse.failed(new RuntimeException());

            /* When */
            String value = response.getOfDefault(defaultValue);

            /* Then */
            assertEquals(value, defaultValue);
        }
    }

    @Nested
    class Constructor {
        @Test
        void generateWondooResponseByValueTest() {
            /* Given */
            String value = "wondoo";

            /* When */
            CoffeeGroundResponse<String> response = CoffeeGroundResponse.ok(value);

            /* Then */
            assertEquals(response.getValue(), value);
        }

        @Test
        void generateWondooResponseByExceptionTest() {
            /* Given */
            RuntimeException exception = new RuntimeException();

            /* When */
            CoffeeGroundResponse<String> response = CoffeeGroundResponse.failed(exception);

            /* Then */
            assertEquals(response.getException(), exception);
        }
    }
}