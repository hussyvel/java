package CursoNelio.JavaApplication5.src.CursoJava;

import javax.swing.JOptionPane;
public class AnaliseDeCheque {

    public static void main(String[] args) {

        float saldo, valor_cheque, saldo_atual;

        valor_cheque = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor do cheque : "));

        saldo = 500;
        saldo_atual = saldo - valor_cheque;

        if (valor_cheque <= saldo)
            System.out.println("Cheque descontado, saldo atual : " + saldo_atual);
        else
            System.out.println("Cheque não pode ser descontado, saldo insuficiente!");

    }

}