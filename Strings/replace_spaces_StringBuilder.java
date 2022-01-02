package com.Strings;

public class replace_spaces_StringBuilder {

        public static StringBuilder replaceSpaces(StringBuilder str) {
            // To store result.
            StringBuilder res = new StringBuilder();

            // Variable to store length.
            int len = str.length();

            // Iterate the length of the string.
            for (int i = 0; i < len; i++) {
                // Add "@40" in place of space.
                if (str.charAt(i) == ' ') {
                    res.append("@40");
                }
                // Add character to result.
                else {
                    res.append(str.charAt(i));
                }
            }
            // Return result.
            return res;
        }
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder("Once in a blue moon");
        System.out.println(replaceSpaces(str));
    }
}
