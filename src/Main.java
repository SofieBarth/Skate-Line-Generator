import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Tricklist list = new Tricklist();
        SkateTrick[] tricklist1 = list.trickliste1;

        List<SkateTrick> newSkateLine = generateSkateLine(tricklist1,6);
        printArray(newSkateLine);
    }
    public static List<SkateTrick> generateSkateLine(SkateTrick[] tricklist, int trickcount) {
        //Tricklisten erstellen, Sortierung von From: Normal/Fakie und To: NORMAL/FAKIE
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
        //ersten Trick aus Listen wählen, muss from: NORMAL erfüllen
        Random random = new Random();
        SkateTrick firstSkateTrick = tricksFromNormal.get(random.nextInt(tricksFromNormal.size()));
        //ersten Trick zur finalen Liste (Skate-Line) zufügen
        List<SkateTrick> line = new ArrayList<>();
        line.add(firstSkateTrick);

        //Skate-Line durch weitere Tricks ergänzen
        for (int i = 1; i < trickcount; i++) {
            if (line.get(i-1).to == Direction.REGULAR) {
                SkateTrick nextSkateTrick = tricksFromNormal.get(random.nextInt(tricksFromNormal.size()));
                line.add(nextSkateTrick);
            } else {
                SkateTrick nextSkateTrick = tricksFromFakie.get(random.nextInt(tricksFromFakie.size()));
                line.add(nextSkateTrick);
            }
        }
        //Tricklisten für letzten Trick erstellen, da letzter Trick to: REGULAR sein soll
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
        if (line.get(trickcount-1).to == Direction.REGULAR) {
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

