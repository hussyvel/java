import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grupo implements ActionListener {
	String tela = "";
	
  // criamos um JFrame chamado 'janela'
  JFrame janela = new JFrame();
  
  // criamos um JPanel chamado painel1
  JPanel painePessoaFJ = jPanelPessoaConsultar();
  JPanel painelCadastrarPessoa = jPanelCadastrarPessoa();
  JPanel painelPessoaEditar = jPanelEditarPessoa();
  JPanel painelExcluirPessoa = jPanelExcluirPessoa();
  
  JPanel painel3 = jPanelCadastrarPessoa();
  // criamos um JPanel chamado painel4
  JPanel painel4 = new JPanel();
  // criamos um JPanel chamado painel5
  JPanel painel5 = new JPanel();
  
  
  
  //Painel generico
  JLabel generico = new JLabel("Selecione um sub menu.", JLabel.CENTER);
  
  // criamos dois botoes e um painel para alternar entre os paineis
  JPanel painelSelecao = new JPanel();
  
  JButton botao1 = new JButton("Pessoa");
  JButton botaoPessoaFJ = new JButton("Pessoa F/J");
  JButton botao3 = new JButton("Pessoa Endereco");
  JButton botao4 = new JButton("Pessoa Telefone");
  JButton botao5 = new JButton("Pessoa Contato");
  
  JButton botaoCon = new JButton("Consultar");
  JButton botaoCad = new JButton("Cadastrar");
  JButton botaoEdi = new JButton("Editar");
  JButton botaoExc = new JButton("Excluir");
  
  
  JPanel painelCard = new JPanel();
  
  public static void main(String args[]) {
    new Grupo();
  }
  
  private Grupo() {
    // definimos o t�tulo da janela
    janela.setTitle("Exemplo de um CardLayout");
    // definimos a largura e a altura da janela
    janela.setSize(800, 500); 
	// define a posi��o da janela na tela
    janela.setLocation(50, 50); 
	// define que ao fechar a janela, encerre a aplica��o
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	// definimos o layout da janela
    janela.setLayout(new BorderLayout()); 
	
	
	// definimos o painelselecao com o
	// GridLayout e incluimos os botoes
    painelSelecao.setLayout(new GridLayout(2, 2));
    //painelSelecao.add(botao1);
    painelSelecao.add(botaoPessoaFJ);
	painelSelecao.add(botao3);
	painelSelecao.add(botao4);
	painelSelecao.add(botao5);
	
	painelSelecao.add(botaoCon);
	painelSelecao.add(botaoCad);
	painelSelecao.add(botaoEdi);
	painelSelecao.add(botaoExc);
	
	// definimos o layout do painelCard
    painelCard.setLayout(new CardLayout()); 
	
	// adicionamos os paineis quem cont�m
	// os rotulos ao painelCard
	painelCard.add(generico, "generico");
	//Telas Pessoa
    painelCard.add(painePessoaFJ, "painePessoaFJ");
	painelCard.add(painelCadastrarPessoa, "painelCadastrarPessoa");
    painelCard.add(painelPessoaEditar, "painelPessoaEditar"); 
	painelCard.add(painelExcluirPessoa, "painelExcluirPessoa"); 
	
	painelCard.add(painel3, "p3"); 
	painelCard.add(painel4, "p4"); 
	painelCard.add(painel5, "p5"); 
	
	// adicionamos os paineis � janela
    janela.add("North", painelSelecao);
    janela.add("Center", painelCard); 
	
	
	// registra os botoes para tratarmos os                                
	// eventos gerados por eles
    botaoPessoaFJ.addActionListener(this);
	botao3.addActionListener(this); 
	botao4.addActionListener(this); 
	botao5.addActionListener(this); 
	
	botaoCon.addActionListener(this);
	botaoCad.addActionListener(this);
	botaoEdi.addActionListener(this);
	botaoExc.addActionListener(this);
	
	CardLayout cl = (CardLayout) painelCard.getLayout();
	cl.show(painelCard, "generico");

	// mostramos a janela
    janela.setVisible(true);
  } 
  
  public JPanel jPanelCadastrarPessoa(){
	JButton btnLimpar = new JButton();
	JButton btnCadastro = new JButton();

	JTextField txfNome = new JTextField();
	JTextField txfEmail = new JTextField();
	JTextField txfTipo = new JTextField();
	JTextField txfCpfCnpj = new JTextField();

	JLabel lblNome = new JLabel();
	JLabel lblEmail = new JLabel();
	JLabel lblTipo = new JLabel();
	JLabel lblCpfCnpj = new JLabel();
	
	JPanel pnl1 = new JPanel();
    pnl1.setLayout(new GridBagLayout());
    GridBagConstraints grid = new GridBagConstraints();
    grid.fill = GridBagConstraints.HORIZONTAL;

    lblNome.setText("Nome Pessoa: ");
    grid.gridx = 0;
    grid.gridy = 0;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(lblNome, grid);

    grid.gridx = 1;
    grid.gridy = 0;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(txfNome, grid);
	
	lblEmail.setText("Email Pessoa: ");
    grid.gridx = 0;
    grid.gridy = 2;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(lblEmail, grid);

    grid.gridx = 1;
    grid.gridy = 2;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(txfEmail, grid);
	
	JRadioButton rb1= new JRadioButton("Pessoa Fisica");
	JRadioButton rb2= new JRadioButton("Pessoa Juridica");
	ButtonGroup grupo= new ButtonGroup();
	grupo.add(rb1);
	grupo.add(rb2);
	
	grid.gridx = 0;
    grid.gridy = 3;
    grid.insets = new Insets(5, 0, 0, 10);
	pnl1.add(rb1,grid);
	
	grid.gridx = 1;
    grid.gridy = 3;
    grid.insets = new Insets(5, 0, 0, 10);
	pnl1.add(rb2,grid);
	
	lblCpfCnpj.setText("CPF / CNPJ Pessoa: ");
    grid.gridx = 0;
    grid.gridy = 4;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(lblCpfCnpj, grid);

    grid.gridx = 1;
    grid.gridy = 4;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(txfCpfCnpj, grid);
	
	
	
	JPanel buttons = new JPanel();
    buttons.setLayout(new FlowLayout());

    btnCadastro.setText("Cadastrar");
    btnCadastro.addActionListener(this);
    btnLimpar.setText("Limpar");
    btnLimpar.addActionListener(this);

    buttons.add(btnLimpar);
    buttons.add(btnCadastro);
	
	grid.gridx = 1;
    grid.gridy = 5;
    grid.insets = new Insets(10, 10, 0, 10);
    pnl1.add(buttons, grid);
	
	return pnl1;
  }
  
  
  public JPanel jPanelPessoaConsultar(){
	JButton btnLimpar = new JButton();
	JButton btnCadastro = new JButton();

	JTextField txfNome = new JTextField();

	JLabel lblNome = new JLabel();
	
	JPanel pnl1 = new JPanel();
    pnl1.setLayout(new GridBagLayout());
    GridBagConstraints grid = new GridBagConstraints();
    grid.fill = GridBagConstraints.HORIZONTAL;

    lblNome.setText("Nome Pessoa: ");
    grid.gridx = 0;
    grid.gridy = 0;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(lblNome, grid);

    grid.gridx = 1;
    grid.gridy = 0;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(txfNome, grid);
	
	JPanel buttons = new JPanel();
    buttons.setLayout(new FlowLayout());

    btnCadastro.setText("Consultar");
    btnCadastro.addActionListener(this);
    btnLimpar.setText("Limpar");
    btnLimpar.addActionListener(this);

    buttons.add(btnLimpar);
    buttons.add(btnCadastro);
	
	grid.gridx = 1;
    grid.gridy = 1;
    grid.insets = new Insets(10, 10, 0, 10);
    pnl1.add(buttons, grid);
	
	return pnl1;
  }
  
  public JPanel jPanelExcluirPessoa(){
	JButton btnLimpar = new JButton();
	JButton btnCadastro = new JButton();

	JTextField txfNome = new JTextField();

	JLabel lblNome = new JLabel();
	
	JPanel pnl1 = new JPanel();
    pnl1.setLayout(new GridBagLayout());
    GridBagConstraints grid = new GridBagConstraints();
    grid.fill = GridBagConstraints.HORIZONTAL;

    lblNome.setText("Nome Pessoa: ");
    grid.gridx = 0;
    grid.gridy = 0;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(lblNome, grid);

    grid.gridx = 1;
    grid.gridy = 0;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(txfNome, grid);
	
	JPanel buttons = new JPanel();
    buttons.setLayout(new FlowLayout());

    btnCadastro.setText("Excluir");
    btnCadastro.addActionListener(this);
    btnLimpar.setText("Limpar");
    btnLimpar.addActionListener(this);

    buttons.add(btnLimpar);
    buttons.add(btnCadastro);
	
	grid.gridx = 1;
    grid.gridy = 1;
    grid.insets = new Insets(10, 10, 0, 10);
    pnl1.add(buttons, grid);
	
	return pnl1;
  }
  
  public JPanel jPanelEditarPessoa(){
	JButton btnLimpar = new JButton();
	JButton btnCadastro = new JButton();

	JTextField txfNome = new JTextField();
	JTextField txfEmail = new JTextField();

	JLabel lblNome = new JLabel();
	JLabel lblEmail = new JLabel();
	
	JPanel pnl1 = new JPanel();
    pnl1.setLayout(new GridBagLayout());
    GridBagConstraints grid = new GridBagConstraints();
    grid.fill = GridBagConstraints.HORIZONTAL;

    lblNome.setText("Nome Pessoa: ");
    grid.gridx = 0;
    grid.gridy = 0;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(lblNome, grid);

    grid.gridx = 1;
    grid.gridy = 0;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(txfNome, grid);
	
	lblEmail.setText("Email Pessoa: ");
    grid.gridx = 0;
    grid.gridy = 2;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(lblEmail, grid);

    grid.gridx = 1;
    grid.gridy = 2;
    grid.insets = new Insets(5, 0, 0, 10);
    pnl1.add(txfEmail, grid);
	
	JPanel buttons = new JPanel();
    buttons.setLayout(new FlowLayout());
	
	btnCadastro.setText("Cadastrar");
    btnCadastro.addActionListener(this);
    btnLimpar.setText("Limpar");
    btnLimpar.addActionListener(this);

    buttons.add(btnLimpar);
    buttons.add(btnCadastro);
	
	grid.gridx = 1;
    grid.gridy = 3;
    grid.insets = new Insets(10, 10, 0, 10);
    pnl1.add(buttons, grid);
	
	return pnl1;
  }
  
  // veremos este metodo com mais detalhe no proximo topico
  public void actionPerformed(ActionEvent e) {
    CardLayout cl = (CardLayout) painelCard.getLayout();
    if (e.getSource() == botaoPessoaFJ) {
      cl.show(painelCard, "generico");
	  this.tela = "pessoa";
    }
	if (e.getSource() == botao3) {
      cl.show(painelCard, "generico");
	  this.tela = "pessoaEnd";
    }
	if (e.getSource() == botao4) {
      cl.show(painelCard, "generico");
	  this.tela = "pessoaTel";
    }
	if (e.getSource() == botao5) {
      cl.show(painelCard, "generico");
	  this.tela = "pessoaConta";
    }
	
	if (e.getSource() == botaoCon && this.tela == "pessoa") {
      cl.show(painelCard, "painePessoaFJ");
    } 
	if (e.getSource() == botaoCad && this.tela == "pessoa") {
      cl.show(painelCard, "painelCadastrarPessoa");
    }
	if (e.getSource() == botaoEdi && this.tela == "pessoa") {
      cl.show(painelCard, "painelPessoaEditar");
    }
	if (e.getSource() == botaoExc && this.tela == "pessoa") {
      cl.show(painelCard, "painelExcluirPessoa");
    }
	
	if (e.getSource() == botaoCon && this.tela == "pessoaFJ") {
      cl.show(painelCard, "p2");
    }
	if (e.getSource() == botaoCad && this.tela == "pessoaFJ") {
      cl.show(painelCard, "p3");
    }
	if (e.getSource() == botaoEdi && this.tela == "pessoaFJ") {
      cl.show(painelCard, "p2");
    }
	if (e.getSource() == botaoExc && this.tela == "pessoaFJ") {
      cl.show(painelCard, "p2");
    }
	
	if (e.getSource() == botaoCon && this.tela == "pessoaEnd") {
      cl.show(painelCard, "p2");
    }
	if (e.getSource() == botaoCad && this.tela == "pessoaEnd") {
      cl.show(painelCard, "p3");
    }
	if (e.getSource() == botaoEdi && this.tela == "pessoaEnd") {
      cl.show(painelCard, "p2");
    }
	if (e.getSource() == botaoExc && this.tela == "pessoaEnd") {
      cl.show(painelCard, "p2");
    }
	if (e.getSource() == botaoCon && this.tela == "pessoaTel") {
      cl.show(painelCard, "p2");
    }
	if (e.getSource() == botaoCad && this.tela == "pessoaTel") {
      cl.show(painelCard, "p3");
    }
	if (e.getSource() == botaoEdi && this.tela == "pessoaTel") {
      cl.show(painelCard, "p2");
    }
	if (e.getSource() == botaoExc && this.tela == "pessoaTel") {
      cl.show(painelCard, "p2");
    }
	
	if (e.getSource() == botaoCon && this.tela == "pessoaConta") {
      cl.show(painelCard, "p2");
    }
	if (e.getSource() == botaoCad && this.tela == "pessoaConta") {
      cl.show(painelCard, "p3");
    }
	if (e.getSource() == botaoEdi && this.tela == "pessoaConta") {
      cl.show(painelCard, "p2");
    }
	if (e.getSource() == botaoExc && this.tela == "pessoaConta") {
      cl.show(painelCard, "p2");
    }
  }
}