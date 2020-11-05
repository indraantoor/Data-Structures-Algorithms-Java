public class Recursion {

    // Used Example Of Factorial
    public class Factorial {
        public int recursiveFactorial(int n) {
            if (n > 0) {
                System.out.println("Execution of: " + n);
                return n * recursiveFactorial(n - 1);
            } else {
                return 1;
            }
        }

        public void main(String[] args) {
            int recursiveSolution = recursiveFactorial(4);
            System.out.println(recursiveSolution);
        }
    }
}
