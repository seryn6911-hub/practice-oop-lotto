// Scan.java
package lotto.view;

import java.util.Scanner;

public class Scan implements InputReader {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
