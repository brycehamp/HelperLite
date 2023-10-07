public class BasicCalculator {

    private double answer;

    private double add(double a, double b) {
        answer = a + b;
        return answer;
    }

    private double subtract(double a, double b) {
        answer = a - b;
        return answer;
    }

    private double multiply(double a, double b) {
        answer = a*b;
        return answer;
    }

    private double divide(double a, double b) {
        answer = a/b;
        return answer;
    }

    /* 
    /  Converts the string input to usable numbers in double format,
    /  then uses basic operation methods above to return the solution.
    */
    public double solve(String s) {
        double fNum = 0;
        double lNum = 0;
        double solution = -1; // in case there is an issue
        String fString = "";
        String lString = "";

        /*---------------------separates the string into two numbers---------------------*/
        
        // loops through string until an operator is reached to create fString
        int i = 0;
        while (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/') {
            fString += s.charAt(i);
            i++;
            // x will end up being equal to the point in the string after the operator 
        }

        // converts the string to a double
        fNum = Double.parseDouble(fString);

        // loops through the rest of the string to create the string representation of the second number
        for (int l = i+1; l < s.length(); l++) {
            lString += s.charAt(l);
        }

        // converts the string to a double
        lNum = Double.parseDouble(lString);

        // at this point, both numbers should be saved

        /*--------------------------------performs math-------------------------------*/

        if (s.contains("+")) {
            solution = add(fNum, lNum);
        }

        if (s.contains("-")) {
            solution = subtract(fNum, lNum);
        }

        if (s.contains("*")) {
            solution = multiply(fNum, lNum);
        }

        if (s.contains("/")) {
            solution = divide(fNum, lNum);
        }

        return solution;
    }
}
