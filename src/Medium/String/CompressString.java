package Medium.String;

public class CompressString {

    /// Given an array of characters chars, compress it using the following algorithm:
    ///
    /// Begin with an empty string s. For each group of consecutive repeating characters in chars:
    ///
    /// If the group's length is 1, append the character to s.
    /// Otherwise, append the character followed by the group's length.

    /// Example 1:
    ///
    /// Input: chars = ["a","a","b","b","c","c","c"]
    /// Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
    /// Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
    /// Example 2:
    ///
    /// Input: chars = ["a"]
    /// Output: Return 1, and the first character of the input array should be: ["a"]
    /// Explanation: The only group is "a", which remains uncompressed since it's a single character.


    public static int compressString(char[] chars){


//        int writeIndex = 0;   // where we write compressed result
//        int count = 1;        // count of repeating characters
//
//        // loop runs till <= length to handle last group
//        for (int i = 1; i <= chars.length; i++) {
//
//            // 👉 IF group ended
//            if (i == chars.length || chars[i] != chars[i - 1]) {
//
//                // write the character that finished
//                chars[writeIndex] = chars[i - 1];
//                writeIndex++;
//
//                // write count if more than 1
//                if (count > 1) {
//                    String countStr = String.valueOf(count);
//                    for (int j = 0; j < countStr.length(); j++) {
//                        chars[writeIndex] = countStr.charAt(j);
//                        writeIndex++;
//                    }
//                }
//
//                // reset count for next group
//                count = 1;
//            }
//
//            // 👉 IF same character, increase count
//            if (i < chars.length && chars[i] == chars[i - 1]) {
//                count++;
//            }
//        }
//
//        return writeIndex;

        int writeIndex = 0;
        int count = 1;

        for (int i = 1; i <= chars.length; i++) {

            // group ended OR end of array
            if (i == chars.length || chars[i] != chars[i - 1]) {

                // write character
                chars[writeIndex] = chars[i - 1];
                writeIndex++;

                // write count if needed
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[writeIndex] = countStr.charAt(j);
                        writeIndex++;
                    }
                }

                // reset count
                count = 1;

            } else {
                // same character → increase count
                count++;
            }
        }

        return writeIndex;

    }


    public static void main(String[] args) {
           char[] chars = {'a','a','b','b','c','c','c'};
           int result = compressString(chars);
        System.out.println(result);
    }

}
