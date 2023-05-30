package wydatki;

import java.util.Scanner;

public class ExpensesApp {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(true) { 
            System.out.printf("1. Wyświetl wszystkie wydatki");
            System.out.printf("2. Wyświetlwydatki z wybranego miesiąca");
            System.out.printf("3. Dodaj wydatek");
            System.out.printf("4. Zakończ aplikacje");
            System.out.printf("Wybierz opcję");

            int choice = Integer.parseInt(scanner.nextLine());

            
        }
    }
}
