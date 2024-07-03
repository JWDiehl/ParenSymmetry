//import jdk.internal.jimage.BasicImageReader;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.stream.Stream;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
//        Write a method isBalanced that takes a string, and produces true if balanced, false otherwise.
//        The method signature should be: public boolean isBalanced(String stringToTest);

        // implement this method - stack another version of an array - part of a collection
//        Stack<Character> stack = new Stack<>();

        int scale = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                //scale = scale - 1;
                scale--;
            } else if (s.charAt(i) == ')') {
                scale++;
            }
        }
        return scale == 0;
    }


//        for (char c : s.toCharArray()) {
//            // if we find c where there is an open bracket (of any kind) push to stack
//            if (c == '(' || c == '[' || c == '{') {
//                parenBal.add(c);
//
//            // if we find close bracket of any kind
//            } else if (c == ')' || c == ']' || c == '}') {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//
//                char top = stack.pop();
//                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
//                    return false;
//                }
//            }
//        }

//        // THis will be true if the stack is empty and all brackets are symmetrical
//        return stack.isEmpty();

    private void checkFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String x;

        while ((x = br.readLine()) != null) {
            System.out.println(isBalanced(x));
        }

//        //Path get a file path
//        BufferedReader br = new BufferedReader(new FileReader("TestStrings0.txt"));
//
//        Path filePath = Path.of(filename);
//        //File.lime(filePath) to call to a file and run
//        Stream<String> lines = File.lines(filePath);
//
//        //Iterator class goes through each line within the file
//        Iterator<String> iterator = lines.iterator();
//        // for next line, it will loop through and read
//        while ((iterator.hasNext()) == true) {
//            // this will store each line in a new variable
//            String line = iterator.next();
//
//
//        }
    }

    public static void main(String[] args) throws IOException {
        //instantiating a new object
        ParenSymmetry ps = new ParenSymmetry();

        //Calling method isBalanced and returning as a boolean
        Boolean b0 = ps.isBalanced("()");

        //converting to method printResult as "Success" or "Failure"
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

        //call to method
        ps.checkFile("TestStrings0.txt");
    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
