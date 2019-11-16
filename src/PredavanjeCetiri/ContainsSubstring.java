package PredavanjeCetiri;

import javax.swing.*;

public class ContainsSubstring {
    public static void main(String[] args) {
        String recenica = JOptionPane.showInputDialog("Unesite recenicu: ");
        String rijec = JOptionPane.showInputDialog("Unesite rijec:");
        if (rijec.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Niste unijeli rijec");
            return;
        }
        int max = recenica.length() - rijec.length();
        boolean contains = false;
        OuterLoopLabel:
        for (int i = 0; i <= max; i++) {
            int k = i;
            for (int j = 0; j < rijec.length() && k <= max; j++) {
                if (recenica.charAt(k++) != rijec.charAt(j))
                    continue OuterLoopLabel;
            }
            contains = true;
            break;
        }
        if (contains)
            JOptionPane.showMessageDialog(null, "Rijec se nalazi u stringu.");
        else
            JOptionPane.showMessageDialog(null, "Rijec se ne nalazi u stringu.");
    }
}
