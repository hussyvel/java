import javax.swing.*;//biblioteca dos botões 
import java.awt.*;//biblioteca do evento clicar
import java.awt.event.*;//biblioteca do evento clicar
 
// a classe Mat torna-se subclasse de JFrame e implementa as
// interfaces da classe ActionListener
public class Calculadora extends JFrame implements ActionListener {
 
        // declarando objetos membros da classe
        static Box Tela;
        static JButton botao;//vai somar
        static JButton botao2;//vai subtrair
        static JButton botao3;//vai multiplica
        static JButton botao4;//vai dividir
       
        static JTextField entrada1;//entrada do primeiro valor
        static JTextField entrada2;//entrada do segundo valor
        static JTextField saida;//resultado da operação
        float v1=0,v2=0,total = 0;
       
        // O metodo ActionListener faz os botoes iteragirem com caixa de texto
        public void actionPerformed(ActionEvent evento) {
           
           //Exceções (tratamento de erro)
           try{ 
           v1= Float.parseFloat(entrada1.getText()) ;
           v2= Float.parseFloat(entrada2.getText()) ;
            }
            catch (NumberFormatException erro) 
            { 
            saida.setText("ERRO"); 
            return; 
            } 

            //condicionando eventos
           if (evento.getSource()==botao) 
           total=v1 + v2;
           
           if (evento.getSource()==botao2) 
               total=v1 - v2;
           
           if (evento.getSource()==botao3) 
               total=v1 * v2;
           
           if (evento.getSource()==botao4) 
               total=v1 / v2;
           
           //saida do resultado
           saida.setText(""+total);
        };
 
        public static void main(String[] args) {
 
               
                //criando  constructor da classe Mat
                // este constructor se encarrega de montar Tela, botoes e caixas de texto
           Calculadora frame = new Calculadora("");
 
                frame.add(Tela);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(212, 258);
                frame.setVisible(true);

                //atributos (propriedades) dos objetos             
                botao.setLocation(0,0);
                botao2.setLocation(50,0);
                botao3.setLocation(100,0);
                botao4.setLocation(150,0);
               
                saida.setLocation(48,150);
                saida.setSize(100,40); 
                saida.setForeground(Color.black); 
                saida.setBackground(Color.BLUE);     
                saida.setOpaque(true);
                saida.setEditable(false);//Não permite escrever(apenas leitura) 
               
                entrada1.setLocation(48,50);
                entrada1.setSize(100,40); 
                entrada1.setForeground(Color.black); 
                entrada1.setBackground(Color.white);     
                entrada1.setOpaque(true);
       
                entrada2.setLocation(48,100);
                entrada2.setSize(100,40); 
                entrada2.setForeground(Color.black); 
                entrada2.setBackground(Color.white);     
                entrada2.setOpaque(true);
       
        }
 
//o trabalho de criar os objetos tela, botoes e cx de texto é
//feito no constructor da classe
        public Calculadora(String S) {
 
                // super chama o constructor da classe JFrame
                super(S);
 
                // construindo instancia do objeto
                Tela = new Box(BoxLayout.Y_AXIS);
                botao = new JButton("+");
                botao2 = new JButton("-");
                botao3 = new JButton("x");
                botao4 = new JButton("/");
               
                saida = new JTextField("");
                entrada1 = new JTextField("");
                entrada2 = new JTextField("");
               
                // botões ganha uma  ActionListener(para ações)
                botao.addActionListener(this);
                botao2.addActionListener(this);
                botao3.addActionListener(this);
                botao4.addActionListener(this);
               
                //inserindo objetos na tela (frame)
                Tela.add(botao);//botao inserido na tela
                Tela.add(botao2);//botao2 inserido na tela
                Tela.add(botao3);//botao3 inserido na tela
                Tela.add(botao4);//botao4 inserido na tela
                Tela.add(saida);//textofield inserido na tela
                Tela.add(entrada1);//textofield inserido na tela
                Tela.add(entrada2);//textofield inserido na tela
       
        }
}


