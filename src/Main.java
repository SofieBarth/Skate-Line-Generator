import java.util.ArrayList;
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
        List<SkateTrick> tricksFromRegular = Tricklist.filterTricklist(tricklist, Direction.REGULAR);
        List<SkateTrick> tricksFromFakie = Tricklist.filterTricklist(tricklist, Direction.FAKIE);

        //first trick is randomly chosen, trick from list: tricksFromNormal
        Random random = new Random();
        SkateTrick firstSkateTrick = tricksFromRegular.get(random.nextInt(tricksFromRegular.size()));
        //first trick added to list: line
        List<SkateTrick> line = new ArrayList<>();
        line.add(firstSkateTrick);

        //list: line is filled with more randomly chosen tricks
        for (int i = 1; i < trickcount - 1; i++) {
            if (line.get(i - 1).to == Direction.REGULAR) {
                SkateTrick nextSkateTrick = tricksFromRegular.get(random.nextInt(tricksFromRegular.size()));
                line.add(nextSkateTrick);
            } else {
                SkateTrick nextSkateTrick = tricksFromFakie.get(random.nextInt(tricksFromFakie.size()));
                line.add(nextSkateTrick);
            }
        }

        SkateTrick lastSkateTrick;
        List<SkateTrick> listForLastTrick;

        //tricklists need to be modified for last trick, last trick has to be to: REGULAR
        if (line.get(trickcount - 2).to == Direction.REGULAR) {
            listForLastTrick = Tricklist.filterTricksForLastTrick(tricksFromRegular, Direction.REGULAR);
        } else {
            listForLastTrick = Tricklist.filterTricksForLastTrick(tricksFromFakie, Direction.FAKIE);
        }

        lastSkateTrick = listForLastTrick.get(random.nextInt(listForLastTrick.size()));
        line.add(lastSkateTrick);

        return line;
    }

    public static void printArray(List<SkateTrick> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).name);
        }
    }
}

