// Oliver Benjamin CSE 146

import java.io.*;
import java.util.*;

public class SheepSchedulerProgram {
    private List<Sheep> sheepList;
    private MinHeap<Sheep> sheepHeap;

    public SheepSchedulerProgram(String fileName) throws IOException {
        sheepList = readFile(fileName);
        sheepHeap = new MinHeap<>();
    }


    // reads file and parses each line into a name, shearingtime and arrival time and then stores it in a sheep object until the next line is null (no more sheep schedules)
    private List<Sheep> readFile(String fileName) throws IOException {
        List<Sheep> sheep = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // splits file into individual lines to prevent error
                String[] parts = line.split("\t");
                String name = parts[0];
                int shearingTime = Integer.parseInt(parts[1]);
                int arrivalTime = Integer.parseInt(parts[2]);
                sheep.add(new Sheep(name, shearingTime, arrivalTime));
            }
        }
        return sheep;
    }

    public void simulateShearing() {
        Collections.sort(sheepList, Comparator.comparingInt(Sheep::getArrivalTime));

        int currentTime = 0;
        System.out.println("Sheep Shearing Schedule:");

        for (Sheep sheep : sheepList) {
            while (!sheepHeap.isEmpty() && currentTime < sheep.getArrivalTime()) {
                System.out.println("Time " + currentTime + ": " + sheepHeap.remove());
                currentTime++;
            }

            sheepHeap.add(sheep);
            currentTime = Math.max(currentTime, sheep.getArrivalTime());
        }

        while (!sheepHeap.isEmpty()) {
            System.out.println("Time " + currentTime + ": " + sheepHeap.remove());
            currentTime++;
        }
    }
}
