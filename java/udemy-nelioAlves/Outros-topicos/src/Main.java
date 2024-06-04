public class Main {
    public static void main(String[] args) {

        //bitwise (& = e(, (| = ou), (^ ou-exclusivo)

        int mask = 0b100000;
        int n = 32;

        if((n & mask) != 0 ) {
            System.out.println("6th bit is true.");
        } else {
            System.out.println("6th bit is false.");
        }

        //lastIndexOf
        String str = "abcabcabcdabc";
        System.out.println(str.lastIndexOf("abc",8));

        //split()
        String s = "potato apple lemon orange";

        String[] vect = s.split(" ");
        System.out.println(vect[0]);
        System.out.println(vect[1]);
        System.out.println(vect[2]);
        System.out.println(vect[3]);
    }
}