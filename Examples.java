import java.util.*;
import java.lang.*;


public class Examples {
    public static void main (String[] args) {
        Examples examples = new Examples();
        examples.run();
    }

    public void run() {
        FizzBuzz fizzy = new FizzBuzz(42);
        CountChars char_count = new CountChars("aaddsbklsdhahdsa");
        fizzy.output();
        char_count.output();
    }

    private class FizzBuzz {
        private Integer number;

        public FizzBuzz(Integer n) {
            number = n;
        }

        public void output() {
            for (int i = 1; i <= number; i++) {
                StringBuilder output = new StringBuilder();
                if (i % 3 == 0) {
                    output.append("Fizz ");
                }
                if (i % 5 == 0) {
                    output.append("Buzz");
                }
                if (output.length() == 0) {
                    output.append(Integer.toString(i));
                }
                System.out.println(output);
            }
        }
    }

    private class CountChars {
        private String char_string;

        public CountChars(String string) {
            char_string = string;
        }

        public void output() {
            HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
            for (int i = 0; i < char_string.length(); i++) {
                String char_at_i = String.valueOf(char_string.charAt(i));
                if (!hash_map.containsKey(char_at_i)) {
                    hash_map.put(char_at_i, 1);
                } else {
                    Integer count = hash_map.get(char_at_i);
                    hash_map.put(char_at_i, count + 1);
                }
            }
            Integer largest_value = 1;
            StringBuilder chars = new StringBuilder();
            for (Map.Entry<String, Integer> entry : hash_map.entrySet())
            {
                if (entry.getValue() > largest_value) {
                    largest_value = entry.getValue();
                }
            }

            for (Map.Entry<String, Integer> entry : hash_map.entrySet())
            {
                if (entry.getValue() == largest_value) {
                    chars.append(entry.getKey());
                }
            }
            System.out.println(chars + ", " + largest_value);
        }
    }
}

