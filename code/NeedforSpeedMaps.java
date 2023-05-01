package code;

import java.util.*;

public class NeedforSpeedMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> info = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
            String cars = scanner.nextLine();
            String car = cars.split("\\|")[0];
            int mileage = Integer.parseInt(cars.split("\\|")[1]);
            int fuel = Integer.parseInt(cars.split("\\|")[2]);

            info.put(car,new ArrayList<>());
            info.get(car).add(0,mileage);
            info.get(car).add(1,fuel);

        }
        String command = scanner.nextLine();
        while(!command.equals("Stop")) {
            if(command.contains("Drive")) {
                String currentCar = command.split(":")[1];
                int distance = Integer.parseInt(command.split(" : ")[2]);
                int fuel = Integer.parseInt(command.split(" : ")[3]);
                int currentFuel = info.get(currentCar).get(1);
                if(currentFuel < fuel) {
                    System.out.println("Not enough fuel to make that ride");
                } else {
                    int currentMileage = info.get(currentCar).get(0);
                    currentMileage+=distance;
                    currentFuel-=fuel;
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", currentCar,distance,fuel);
                    if(currentMileage >= 100000){
                        info.remove(currentCar);
                        System.out.printf("Time to sell the %s!", currentCar);
                    }
                }

            } else if(command.contains("Refuel")) {
                String car = command.split(" : ")[1];
                int fuel = Integer.parseInt(command.split(" : ")[2]);
                int currentFuel = info.get(car).get(1);
                currentFuel+=fuel;
                if(currentFuel > 75) {
                    info.get(car).set(1,75);
                    System.out.printf("%s refueled with %d liters%n", car , fuel);
                }

            } else if(command.contains("Revert ")) {
                String car = command.split(" : ")[1];
                int distance = Integer.parseInt(command.split(" : ")[2]);
                int mileage = info.get(car).get(0);
                mileage -= distance;
                if (mileage <= 10000) {
                    info.get(car).set(0, 10000);
                } else {


                    System.out.printf("%s mileage decreased by %d kilometers", car, distance);

                }
            }

            command = scanner.nextLine();
        }
        info.entrySet().forEach(entry -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        });
    }
}

