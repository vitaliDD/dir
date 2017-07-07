package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

public class UI {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        MainWindow(scanner);

    }

    private void MainWindow(Scanner scanner) {

        Matcher mUI = null;
        Pattern pUI = null;
        String otvet = "";
        StringBuilder sb = new StringBuilder("Viberite operaciyu:");
        sb.append("\n1-Skachka i parsing");
        sb.append("\n2-Pokazat' vseh doctorov");
        sb.append("\n3-Sortirovka doctorov");
        sb.append("\n4-Poisk doctora po specializacii");
        sb.append("\n5-Poisk podhodyaschego doctora dlya pacienta");
        sb.append("\n6-Zavershenie raboty etogo chudesnogo prilozheniya  ");
        while (true) {
            do {

                System.out.println(sb);
                otvet = scanner.nextLine();
                pUI = Pattern.compile("[1-6]");
                mUI = pUI.matcher(otvet);
                if (!mUI.matches()) {
                    System.out.println("Ne vernii vibor, poprobuite escho raz!!!");
                }
            } while (!mUI.matches());

            switch (otvet) {
                case "1":
                    ChooseParse(scanner);
                    break;

                case "2":
                    showDocs();
                    break;

                case "3":
                    chooseSort(scanner);
                    break;

                case "4":
                    chooseDoctor(scanner);

                    break;
                case "5":
                    chooseDegree(scanner);
                    break;
                case "6":
                    System.out.println("Spasibo za polzovanie! Vsego dobrogo! Schastya i zdoroviya!");
                    System.exit(0);
            }
        }
    }

    private void showDocs() {
        Manager.getManager().show();

    }

    private void ChooseParse(Scanner scanner) {
        Matcher mCP = null;
        Pattern pCP = Pattern.compile("[1-3]");;
        String otvet = "";
        do {
            System.out.println("Vvedite v kakom formate trebuetsya skachat' i parsit' bazu dannih:"
                    + "\n1 - XML\n2 - Json\n3 - vihod v predidyschee menu");
            otvet = scanner.nextLine();
            mCP = pCP.matcher(otvet);
            if (!mCP.matches()) {
                System.out.println("Ne vernii vibor, poprobuite escho raz!!!");
            }
        } while (!mCP.matches());
        switch (otvet) {
            case "1":
            case "2":
                Manager.getManager().parsef(SuperAdapter.convertStr(otvet));
                break;
            default:
                return;

        }
        // System.out.println("PRODOLZHeNIE");

    }

    private void chooseSort(Scanner scanner) {
        Matcher mCS = null;
        Pattern pCS = Pattern.compile("[1-3]");
        String otvet = "";
        do {
            System.out.println(new StringBuilder("Vvedite kakoi vid sortirovki zhelaete: "
                    + "\n1 - po imeni\n2 - po date rozhdeniya\n3 - vihod v predidyschee menu"));

            otvet = scanner.nextLine();

            mCS = pCS.matcher(otvet);
            if (!mCS.matches()) {
                System.out.println("Ne vernii vibor, poprobuite escho raz!!!");
            }
        } while (!mCS.matches());
        try {
            switch (otvet) {
                case "1":
                    Manager.getManager().sort(1);
                    System.out.println("Sortirovka po imeni vipolnena uspeshno!");
                    break;

                case "2":
                    Manager.getManager().sort(2);
                    System.out.println("Sortirovla po date rozhdeniya vipolnena uspeshno!");
                    break;

                default:
                    return;
            }
        } catch (Exception e) {
            System.err.println("Oshibka sortirovki!Proverte, chtobi baza "
                    + "doctorov bila skachana! : " + e.toString());

        }

    }

    private void chooseDegree(Scanner scanner) {
        int sizeHm = Manager.getManager().retHmDegree().size();
        Pattern pCD = Pattern.compile("0||[1-9]+||`");
        Matcher mCD = null;
        String otvet = "";
        boolean flag = false;

        do {
            System.out.println("Ukazhite nyzhnyuy degree iz sleduyuschih ili '`' dlya vihoda: ");
            System.out.println(Manager.getManager().retHmDegree().toString());
            otvet = scanner.nextLine();
            mCD = pCD.matcher(otvet);
            if (otvet.equals("`")) {
                break;
            }
            if (!otvet.equals("") && mCD.matches() && SuperAdapter.convertStr(otvet) < sizeHm) {
                // System.out.println("otvet: " + otvet);
                String spec = Manager.getManager().retHmDegree().get(SuperAdapter.convertStr(otvet));
                // System.out.println("value: " + spec);
                ArrayList<Doctors> arD = Manager.getManager().searchDegrees(spec);
                System.out.println(arD.toString());
                continue;
            }
            System.out.println("Ne vernii vibor, poprobuite escho raz!!!");
        } while (true);

    }

    private void chooseDoctor(Scanner scanner) {
        int sizeHm = Manager.getManager().retHmType().size();
        Pattern pCD = Pattern.compile("0||[1-9]+||`");
        Matcher mCD = null;
        String otvet = "";
        boolean flag = false;

        do {
            System.out.println("Ukazhite nyzhnyuy specializaciyu iz sleduyuschih ili '`' dlya vihoda: ");
            System.out.println(Manager.getManager().retHmType().toString());
            otvet = scanner.nextLine();
            mCD = pCD.matcher(otvet);
            if (otvet.equals("`")) {

                break;
            }
            if (!otvet.equals("") && mCD.matches() && SuperAdapter.convertStr(otvet) < sizeHm) {
                // System.out.println("otvet: " + otvet);
                String spec = Manager.getManager().retHmType().get(SuperAdapter.convertStr(otvet));
                //  System.out.println("value: " + spec);
                ArrayList<Doctors> arD = Manager.getManager().searchTypes(spec);
                System.out.println(arD.toString());
                continue;
            }
            System.out.println("Ne vernii vibor, poprobuite escho raz!!!");

        } while (true);

    }

}
