package PredavanjeCetiri;

import javax.swing.*;

public class CountSubstring {
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
            int k = i;
            for (int j = 0; j < rijec.length() && k <= max; ++j, ++k)
                if (recenica.charAt(k) != rijec.charAt(j))
                    continue OuterLoopLabel;

            ++counter;
            i = k - 1;
        }
        if (counter != 0)
            JOptionPane.showMessageDialog(null, "Rijec se ponavlja " + counter + " puta u stringu.");
        else
            JOptionPane.showMessageDialog(null, "Rijec se ne nalazi u stringu.");
    }
}
