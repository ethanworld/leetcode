package util;

/**
 * UnitTest
 */
public class UnitTest {

    static public void EXPERT_EQ(int a, int b) {
        if (a != b) {
            throw new NumberFormatException("faild: " + a + " != " + b);
        } else {
            System.out.println("successful!");
        }
    }

    static public void EXPERT_EQ(String a, String b) {
        if (!a.equals(b)) {
            throw new NumberFormatException("faild: " + a + " != " + b);
        } else {
            System.out.println("successful!");
        }
    }
}