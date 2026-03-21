import data.Tricklist;
import model.SkateTrick;

import java.util.List;
import java.util.Scanner;

import static logic.LineGeneration.generateSkateLine;
import static logic.LineGeneration.printArray;

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

        List<SkateTrick> newSkateLine = generateSkateLine(trickListAll, numberOfTricks);
        printArray(newSkateLine);
    }
}