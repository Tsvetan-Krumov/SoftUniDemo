import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class dog {




        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            double total = 0;
            for (int i = 0; i < numbers.size() / 2; i++) {
                int firstNum = numbers.get(i);
                total +=firstNum;

                if(firstNum==0){
                    total = total * 0.8;




                }

            }
            double total2 = 0;
            for (int i = numbers.size() - 1 ; i > numbers.size() / 2 ; i--) {
                int secondNum = numbers.get(i);
                total2+=secondNum;
                if(secondNum==0){
                    total2 = total2*0.8;
                }
            }
            if(total > total2) {
                System.out.printf("The winner is right with total time: %.1f", total2);

            } else {
                System.out.printf("The winner is left with total time: %.1f", total);
            }

        }
    }


