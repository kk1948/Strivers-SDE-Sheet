package Easy.String;

public class OneStringisRotationofAnother {
    public static void main(String[] args) {
        String s = "abcde"; String goal = "abced";
        boolean result = oneStringRotationofAnother(s, goal);
        System.out.println(result);
    }

    private  static  boolean oneStringRotationofAnother(String s, String goal){

        String concat = s + s;
        if(concat.contains(goal)) {
            return true;
        }
        return false;
    }
}
