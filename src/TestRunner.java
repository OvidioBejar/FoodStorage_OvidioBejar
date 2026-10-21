import java.time.LocalDate;

// This code will help us verify whether the structure is correct
public class TestRunner {

    private static int passed = 0;
    private static int failed = 0;

    private static void check(String testName, boolean condition) {
        if (condition) {
            System.out.println("PASS - " + testName);
            passed++;
        } else {
            System.out.println("FAIL - " + testName);
            failed++;
        }
    }
}
