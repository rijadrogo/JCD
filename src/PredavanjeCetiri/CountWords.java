package PredavanjeCetiri;

import javax.swing.*;

public class CountWords {
    public static void main(String[] args) {
        String recenica = JOptionPane.showInputDialog("Unesite recenicu: ");
        String rijec = JOptionPane.showInputDialog("Unesite rijec:");
        if (rijec.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Niste unijeli rijec.");
            return;
        }

        int max = recenica.length() - rijec.length();
        int counter = 0;
        OuterLoopLabel:
        for (int i = 0; i <= max; ++i) {

            if (recenica.charAt(i) == ' ')
                continue;

            int pocetakRijeci = i;
            while (i < recenica.length() && recenica.charAt(i) != ' ')
                ++i;

            if (i - pocetakRijeci == rijec.length()) {
                for (int j = 0; j < rijec.length(); ++j) {
                    if (recenica.charAt(pocetakRijeci++) != rijec.charAt(j))
                        continue OuterLoopLabel;
                }
                ++counter;
            }
        }

        if (counter != 0)
            JOptionPane.showMessageDialog(null, "Rijec se nalazi " + counter + " puta u stringu.");
        else
            JOptionPane.showMessageDialog(null, "Rijec se ne nalazi u stringu.");
    }
}
