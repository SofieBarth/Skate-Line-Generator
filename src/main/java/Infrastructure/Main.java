package Infrastructure;

import UI.SkatelineApp;
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

        SkatelineApp.main(args);
    }

    //lineGenerationTerminal();
    public static void lineGenerationTerminal() {
        Tricklist list = new Tricklist();
        SkateTrick[] trickListAll = list.trickListAll;
        SkateTrick[] beginnerTricks = list.beginnerTricks;
        SkateTrick[] intermediateTricks = list.intermediateTricks;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of tricks for the Skate-Line:");
        int numberOfTricks = -1;
        boolean valid = false;

        while (!valid) {
            if (scanner.hasNextInt()) {
                numberOfTricks = scanner.nextInt();
                if (numberOfTricks > 0) {
                    valid = true;
                } else {
                    System.out.println("Input number is invalid, number must be > 0.");
                }
            } else {
                System.out.println("Input invalid, must be a number > 0");
                scanner.next();
            }
        }

        System.out.println("Your line with " + numberOfTricks + " tricks was generated as follows:");
        scanner.close();

        List<SkateTrick> newSkateLine = generateSkateLine(trickListAll, numberOfTricks);
        printArray(newSkateLine);
    }
}