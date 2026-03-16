import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Tricklist list = new Tricklist();
        SkateTrick[] trickListAll = list.trickListAll;
        SkateTrick[] beginnerTricks = list.beginnerTricks;
        SkateTrick[] intermediateTricks = list.intermediateTricks;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of tricks for the Skate-Line:");
        int numberOfTricks = scanner.nextInt();
        System.out.println("Your line with " + numberOfTricks + " tricks was generated as follows:");

        List<SkateTrick> newSkateLine = generateSkateLine(beginnerTricks, numberOfTricks);
        printArray(newSkateLine);
    }
    public static List<SkateTrick> generateSkateLine(SkateTrick[] tricklist, int trickcount) {
        //sorting of list in two different lists -> from: Normal or from: Fakie
        List<SkateTrick> tricksFromNormal = Arrays.stream(tricklist)
                .filter(trick -> trick.from == Direction.REGULAR)
                .toList();

        if (tricksFromNormal.isEmpty()) {
            System.out.println("No elements found");
            return List.of();
        }
        List<SkateTrick> tricksFromFakie = Arrays.stream(tricklist)
                .filter(trick -> trick.from == Direction.FAKIE)
                .toList();

        if (tricksFromFakie.isEmpty()) {
            System.out.println("No elements found");
            return List.of();
        }
        //first trick is randomly chosen, trick from list: tricksFromNormal
        Random random = new Random();
        SkateTrick firstSkateTrick = tricksFromNormal.get(random.nextInt(tricksFromNormal.size()));
        //first trick added to list: line
        List<SkateTrick> line = new ArrayList<>();
        line.add(firstSkateTrick);

        //list: line is filled with more randomly chosen tricks
        for (int i = 1; i < trickcount-1; i++) {
            if (line.get(i-1).to == Direction.REGULAR) {
                SkateTrick nextSkateTrick = tricksFromNormal.get(random.nextInt(tricksFromNormal.size()));
                line.add(nextSkateTrick);
            } else {
                SkateTrick nextSkateTrick = tricksFromFakie.get(random.nextInt(tricksFromFakie.size()));
                line.add(nextSkateTrick);
            }
        }
        //tricklists need to be modified for last trick, last trick has to be to: REGULAR
        List<SkateTrick> tricksFromNormalToNormal = tricksFromNormal.stream()
                .filter(trick -> trick.from == Direction.REGULAR && trick.to == Direction.REGULAR)
                .toList();

        if (tricksFromNormalToNormal.isEmpty()) {
            System.out.println("No elements found");
            return List.of();
        }
        List<SkateTrick> tricksFromFakieToNormal = tricksFromFakie.stream()
                .filter(trick -> trick.from == Direction.FAKIE && trick.to == Direction.REGULAR)
                .toList();

        if (tricksFromFakieToNormal.isEmpty()) {
            System.out.println("No elements found");
            return List.of();
        }
        if (line.get(trickcount-2).to == Direction.REGULAR) {
            SkateTrick lastSkateTrick = tricksFromNormalToNormal.get(random.nextInt(tricksFromNormalToNormal.size()));
            line.add(lastSkateTrick);
        } else {
            SkateTrick lastSkateTrick = tricksFromFakieToNormal.get(random.nextInt(tricksFromFakieToNormal.size()));
            line.add(lastSkateTrick);
        }
        return line;
    }
    public static void printArray(List<SkateTrick> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).name);
        }
    }
}

