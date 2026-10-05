import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
public class TownChallenge {

    public static void main(String[] args) throws Exception {

        Scanner Keyboard = new Scanner(System.in);
        File file = new File("src/towns.txt");
        Scanner fileInput = new Scanner(file);
        String[] towns = new String[8];
        for (int i = 0; i < towns.length ; i++) {
            towns[i] = fileInput.nextLine();


        }

        System.out.println("How many set of results do you require: ");
        int numOfResults = Keyboard.nextInt();

        Random random = new Random();
        int homeScore , awayScore;
        int homes = 0, drows = 0, aways = 0;

        FileWriter fw = new FileWriter("src/results.txt", true);
        PrintWriter fileOutput = new PrintWriter(fw);


        for (int i = 0; i < numOfResults; i++){

            for (int j = 0; j <towns.length/2; j++){
                homeScore = random.nextInt(10);
                awayScore = random.nextInt(10);
                System.out.printf(" %-12s %3d %-12s %3d \n",
                        towns[j*2], homeScore, towns[j*2 + 1], awayScore);
                fileOutput.printf(" %-12s %3d %-12s %3d \n",
                        towns[j*2], homeScore, towns[j*2 + 1], awayScore);


                if (homeScore > awayScore){
                    homes++;
                }
                else if (homeScore < awayScore){
                    aways++;
                }
                else {
                    drows++;
                }

        }

            System.out.printf("Home Wins: %d, Away Wins: %d, Draws: %d\n", homes, aways, drows);
            fileOutput.printf("Home Wins: %d, Away Wins: %d, Draws: %d\n", homes, aways, drows);
    }

        fileOutput.close();
}

}