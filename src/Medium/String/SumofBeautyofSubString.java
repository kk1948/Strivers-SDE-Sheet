package Medium.String;

public class SumofBeautyofSubString {


//    Approach
//    Iterate through all possible substrings of the input string.
//    For each substring, maintain a frequency count of characters.
//    Calculate the beauty for each substring by finding the difference between the maximum and minimum frequency (excluding zero frequencies).
//    Sum up the beauties of all substrings and return the result.
    
    public static int getminCount(int[] freq){
        int mincount = Integer.MAX_VALUE;
        for(int i = 0 ; i<26; i++){
            if(freq[i]!= 0){
                mincount = Math.min(mincount, freq[i]);
            }
        }
        return mincount;
    }

    public static int getmaxCount(int[] freq){
        int maxcount = 0;
        for(int i = 0 ; i<26; i++){

            maxcount = Math.max(maxcount, freq[i]);

        }
        return maxcount;
    }

    public static int beautySum(String s){
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];
            for(int j = i; j<s.length();j++){
                freq[s.charAt(j) - 'a']++;
                int beauty = getmaxCount(freq) - getminCount(freq);
                sum += beauty;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        String s  = "aabcb";
        String s1  = "aabcbaa";
        int result = beautySum(s1);
        System.out.println(result);  // 17
    }
}
