package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ImcView extends JFrame implements ActionListener, KeyListener,
		MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelNome, panelCalculo, panelGenero, panelRodape,
			panelResultado;
	private JLabel labelNome, labelPeso, labelAltura, labelMetro, labelCm,
			labelIdade, labelTitulo, labelNomeTitulo, labelCalculoTitulo,
			labelWoman, labelMen, labelKilo, labelGrama, labelLinkFonte,
			labelImcRodape, labelVersaoRodape, labelTabelaMan,
			labelResultadoCalculo;
	private JTextField textNome, textMetro, textCm, textKilo, textGrama;
	private JSpinner spinnerIdade;
	private SpinnerModel spinnerNumberModel;
	private JRadioButton radioMan, radioWoman;
	private ButtonGroup groupRadioGerero;
	private JButton buttonEntrar, buttonCalcular, buttonLimpar,
			buttonNovoCalculo;
	private ImageIcon imgMan, imgWoman, imgTabelaMan;
	private String nomeTitulo, resultado;
	private Border blackline;
	private TitledBorder title;
	private double imc;

	// _________________
	// METODO CONSTRUTOR
	public ImcView() {

		/*
		 * _______________________________________________________________
		 * ############### TITULO DA PAGINA ##############################
		 */
		super("::: Índice de massa corporal (IMC) :::");
		// this.setTitle("::: Índice de massa corporal (IMC) :::");

		/*
		 * _______________________________________________________________
		 * ############### ALTERA O ICONE JAVA ###########################
		 */
		setIconImage(new ImageIcon(this.getClass().getClassLoader()
				.getResource("Image/imc.png")).getImage());

		/*
		 * _________________________________________________________________
		 * ######## INSERE UMA IMAGEM COMO FUNDO DE TELA ###################
		 */
		setContentPane(new JLabel(new ImageIcon(this.getClass()
				.getClassLoader().getResource("Image/fundosite.jpg"))));

		/*
		 * _________________________________________________________________
		 * ######## SETA O TAMANHO DA JANELA ###############################
		 */
		setSize(900, 700);
		// this.setBounds(0, 0, 900, 700); // (x,y,W,H) Neste caso o x e y é
		// ignorado se tiver abaixo setado o setLocationRelativeTo(null);

		/*
		 * _________________________________________________________________
		 * ####### SETA O LAYOUT DO CONTAINER ##############################
		 * Monta o layout padrão de um JFrame, por exemplo, ‘null’ faz com que
		 * os componentes, não se sobreponham e não se conflitem com outros
		 * componentes
		 */
		this.getContentPane().setLayout(null);
		// Container container = getContentPane();
		// container.setLayout(null);

		/*
		 * __ ________________________________________________________________
		 * ########### REDIMENCAO DA TELA ###################################
		 * Deixa a janela, redimensionável (true) ou não (false)
		 */
		setResizable(false);

		/*
		 * 
		 * ___________________________________________________________________
		 * ####### CENTRALIZA A JANELA NO CENTRO DA TELA #####################
		 * Deixa o JFrame alinhado em algum ponto da tela, por exemplo, ‘null’
		 * deixa alinhado no centro
		 */
		setLocationRelativeTo(null);

		/*
		 * 
		 * ____________________________________________________________________
		 * ####### MANIPULA O FECHAMENTO DA JANELA ############################
		 * Método de como será fechado o frame, por exemplo, ‘EXIT_ON_CLOSE’ sai
		 * totalmente do sistema e da RAM, já o ‘DISPOSE_ON_CLOSE’ só sai da
		 * janela atual
		 */
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// addWindowListener(this);

		/*
		 * 
		 * ____________________________________________________________________
		 * ############# VISIBILIDADE DA JANELA ###############################
		 * Deixando a janela visível (true), ou invisível (false)
		 */
		setVisible(true);

		/*
		 * 
		 * _____________________________________________________________________
		 * ############ INSTANCIA O 1o JPANEL (Tela Inicio)#####################
		 */
		panelNome = new JPanel(null);
		panelNome.setBounds(290, 0, 600, 600);
		panelNome.setOpaque(false);
		panelNome.setVisible(true);
		// panelNome.setBorder(BorderFactory.createLineBorder(new Color(0, 0,
		// 0)));
		this.add(panelNome);

		/*
		 * 
		 * _____________________________________________________________________
		 * ############ INSTANCIA O JPANEL (Tela Calculo)####################
		 */
		panelCalculo = new JPanel(null);
		panelCalculo.setBounds(290, 0, 600, 600);
		panelCalculo.setOpaque(false);
		panelCalculo.setVisible(false);
		// panelCalculo.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(panelCalculo);

		/*
		 * 
		 * _____________________________________________________________________
		 * ############ INSTANCIA O JPANEL (Tela Resultados)####################
		 */
		panelResultado = new JPanel(null);
		panelResultado.setBounds(290, 0, 600, 600);
		panelResultado.setOpaque(false);
		panelResultado.setVisible(false);
		// panelCalculo.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(panelResultado);

		/*
		 * 
		 * _____________________________________________________________________
		 * ############ INSTANCIA O JPANEL (Genero)##########################
		 * Filtset Genero
		 */
		blackline = BorderFactory.createLineBorder(Color.black);
		title = BorderFactory.createTitledBorder(blackline, "Genero");

		panelGenero = new JPanel(null);
		panelGenero.setLayout(new GridLayout(1, 4));
		panelGenero.setBorder(title);
		panelGenero.setBounds(80, 420, 200, 110);
		panelGenero.setVisible(true);
		panelGenero.setOpaque(false);
		panelCalculo.add(panelGenero);

		/*
		 * 
		 * _____________________________________________________________________
		 * ############ INSTANCIA O JPANEL (Rodape)##########################
		 */

		panelRodape = new JPanel(null);
		panelRodape.setLayout(new BorderLayout(150, 150));
		panelRodape.setBounds(0, 631, 900, 40);
		panelRodape.setVisible(true);
		// panelRodape.setBorder(BorderFactory.createLineBorder(new Color(0, 0,
		// 0)));
		this.add(panelRodape);

		/*
		 * 
		 * _____________________________________________________________________
		 * ######### ADICIONANDO OS ATRIBUTOS NO PANEL (panelNome) ##########
		 */

		labelTitulo = new JLabel("Calcule seu IMC:");
		labelTitulo.setFont(new Font("Times New Roman", Font.BOLD, 50));
		labelTitulo.setBounds(85, 85, 400, 100);
		panelNome.add(labelTitulo);

		labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelNome.setBounds(85, 200, 60, 60);
		panelNome.add(labelNome);

		textNome = new JTextField();
		textNome.setBounds(85, 240, 400, 30);
		panelNome.add(textNome);
		textNome.requestFocus(true);
		textNome.addKeyListener(this);

		buttonEntrar = new JButton("Entrar");
		buttonEntrar.setBounds(240, 300, 100, 40);
		buttonEntrar.setFocusPainted(false);
		buttonEntrar.addActionListener(this);
		panelNome.add(buttonEntrar);
		panelNome.repaint();

		/*
		 * 
		 * _____________________________________________________________________
		 * ------- ADICIONANDO OS ATRIBUTOS NO PANEL (panelCalculo) ---------
		 */

		labelCalculoTitulo = new JLabel("Calculo IMC de:");
		labelCalculoTitulo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelCalculoTitulo.setBounds(85, 55, 400, 100);
		panelCalculo.add(labelCalculoTitulo);

		labelNomeTitulo = new JLabel();
		labelNomeTitulo.setFont(new Font("Times New Roman", Font.BOLD, 40));
		labelNomeTitulo.setBounds(85, 100, 500, 100);
		// panelCalculo.add(labelNomeTitulo);

		labelIdade = new JLabel("Idade:*");
		labelIdade.setFont(new Font("", Font.BOLD, 20));
		labelIdade.setBounds(85, 200, 160, 60);
		panelCalculo.add(labelIdade);

		// SpinnerNumberModel(a,b,c,d);
		// a = valor inserido no campo inicialmente
		// b = valor inicial do Spinner
		// c = valor final do Spinner
		// d = valor que ira alternar
		spinnerNumberModel = new SpinnerNumberModel(16, 16, 99, 1);
		spinnerIdade = new JSpinner(spinnerNumberModel);
		spinnerIdade.setBounds(85, 245, 60, 20);
		panelCalculo.add(spinnerIdade);

		labelAltura = new JLabel("Altura:*");
		labelAltura.setFont(new Font("", Font.BOLD, 20));
		labelAltura.setBounds(85, 270, 160, 60);
		panelCalculo.add(labelAltura);

		textMetro = new JTextField();
		textMetro.setBounds(85, 315, 40, 20);
		panelCalculo.add(textMetro);

		labelMetro = new JLabel("Metro(s)");
		labelMetro.setBounds(130, 295, 60, 60);
		panelCalculo.add(labelMetro);

		textCm = new JTextField();
		textCm.setBounds(185, 315, 40, 20);
		panelCalculo.add(textCm);

		labelCm = new JLabel("Centimetro(s)");
		labelCm.setBounds(230, 295, 160, 60);
		panelCalculo.add(labelCm);

		labelPeso = new JLabel("Peso*");
		labelPeso.setFont(new Font("", Font.BOLD, 20));
		labelPeso.setBounds(85, 340, 160, 60);
		panelCalculo.add(labelPeso);

		textKilo = new JTextField();
		textKilo.setBounds(85, 385, 40, 20);
		panelCalculo.add(textKilo);

		labelKilo = new JLabel("Kilos");
		labelKilo.setBounds(130, 365, 60, 60);
		panelCalculo.add(labelKilo);

		textGrama = new JTextField();
		textGrama.setBounds(185, 385, 40, 20);
		panelCalculo.add(textGrama);

		labelGrama = new JLabel("Grama(s)");
		labelGrama.setBounds(230, 365, 160, 60);
		panelCalculo.add(labelGrama);

		imgMan = new ImageIcon(this.getClass().getClassLoader()
				.getResource("Image/manPQ.png"));
		labelMen = new JLabel(imgMan);
		// labelMen.setBounds(100, 450, 60, 110);
		panelGenero.add(labelMen);

		radioMan = new JRadioButton();
		// radioMan.setBounds(100, 450, 60, 110);
		radioMan.setOpaque(false);
		// radioMan.setBorder(null);;
		panelGenero.add(radioMan);

		imgWoman = new ImageIcon(this.getClass().getClassLoader()
				.getResource("Image/womanPQ.png"));
		labelWoman = new JLabel(imgWoman);
		// labelWoman.setBounds(165, 450, 60, 110);
		panelGenero.add(labelWoman);

		radioWoman = new JRadioButton();
		// radioWoman.setBounds(165, 450, 60, 110);
		radioWoman.setOpaque(false);
		panelGenero.add(radioWoman);

		groupRadioGerero = new ButtonGroup();
		groupRadioGerero.add(radioMan);
		groupRadioGerero.add(radioWoman);

		buttonCalcular = new JButton("Calcular");
		buttonCalcular.setBounds(90, 550, 90, 40);
		buttonCalcular.setFocusPainted(false);
		buttonCalcular.addActionListener(this);
		panelCalculo.add(buttonCalcular);

		buttonLimpar = new JButton("Limpar");
		buttonLimpar.setBounds(200, 550, 90, 40);
		buttonLimpar.setFocusPainted(false);
		buttonLimpar.addActionListener(this);
		panelCalculo.add(buttonLimpar);

		/*
		 * 
		 * _____________________________________________________________________
		 * ------- ADICIONANDO OS ATRIBUTOS NO PANEL (panelResultado) ---------
		 */

		labelResultadoCalculo = new JLabel();
		labelResultadoCalculo.setBounds(85, 150, 500, 100);
		panelResultado.add(labelResultadoCalculo);

		imgTabelaMan = new ImageIcon(this.getClass().getClassLoader()
				.getResource("Image/imcTabelaMen.png"));
		labelTabelaMan = new JLabel(imgTabelaMan);
		labelTabelaMan.setBounds(20, 360, 510, 190);

		buttonNovoCalculo = new JButton("Novo Cálculo");
		buttonNovoCalculo.setBounds(200, 550, 110, 40);
		buttonNovoCalculo.setFocusPainted(false);
		buttonNovoCalculo.addActionListener(this);
		panelResultado.add(buttonNovoCalculo);

		/*
		 * 
		 * _____________________________________________________________________
		 * ------- ADICIONANDO OS ATRIBUTOS NO PANEL (Rodapé) ---------
		 */

		labelLinkFonte = new JLabel("    http://indicedemassacorporal.com/");
		labelImcRodape = new JLabel("::::SEU INDICE DE MASSA CORPORAL::::");
		labelVersaoRodape = new JLabel(getVersao());
		panelRodape.add(labelLinkFonte, BorderLayout.WEST);
		panelRodape.add(labelImcRodape, BorderLayout.CENTER);
		labelLinkFonte.addMouseListener(this);
		panelRodape.add(labelVersaoRodape, BorderLayout.EAST);

		panelRodape.revalidate();
	}

	// ________________________
	// FIM DO METODO CONSTRUTOR

	/*
	 * _____________________________________________________________________
	 * 
	 * ################## LIMPA TEXT ################################
	 */
	public void limpaText() {
		textNome.setText("");
		textCm.setText("");
		textGrama.setText("");
		textKilo.setText("");
		textMetro.setText("");
		spinnerIdade.setValue(16);
	}

	/*
	 * _____________________________________________________________________
	 * 
	 * ################## VERSAO DO SIATEMA ################################
	 */

	public String getVersao() {
		return "V-IMC:0001SE         ";
	}

	/*
	 * _____________________________________________________________________
	 * 
	 * ################## ACAO DO BUTTON ENTRAR ############################
	 */
	public void acaoEntrar() {

		nomeTitulo = textNome.getText().toString().toUpperCase();

		if (!nomeTitulo.equals("")) {
			labelNomeTitulo.setText(nomeTitulo);
		} else {
			labelNomeTitulo.setText("Sem Nome ...");
		}

		panelCalculo.add(labelNomeTitulo);
		panelNome.setVisible(false);
		panelCalculo.setVisible(true);
	}

	/*
	 * _____________________________________________________________________
	 * 
	 * ################## ACAO DO Hyperlink ################################
	 */
	public void hyperlink(String link) {

		try {
			Desktop.getDesktop().browse(new java.net.URI(link));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * _____________________________________________________________________
	 * 
	 * $$$$$$$$$$$$$$$$$$$$$ ActionPerformed $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	 * _____________________________________________________________________
	 */

	// /////ACÃO BOTAO ENTRAR
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == buttonEntrar) {
			acaoEntrar();

		}

		// /////ACÃO BOTAO CALCULAR
		if (arg0.getSource() == buttonCalcular) {
			/*
			 * if (textMetro.getText().trim().isEmpty() ||
			 * textCm.getText().trim().isEmpty() ||
			 * textKilo.getText().trim().isEmpty() ||
			 * textGrama.getText().trim().isEmpty()) {
			 * 
			 * showMessageDialog(null,
			 * "Favor preencher todos os campos obrigatórios", "Alerta",
			 * JOptionPane.INFORMATION_MESSAGE);
			 * 
			 * // verifica se o genero foi selecionado } else if
			 * (!radioMan.isSelected() && !radioWoman.isSelected()) {
			 * 
			 * showMessageDialog(null, "Favor informar o genero", "Alerta",
			 * JOptionPane.INFORMATION_MESSAGE);
			 * 
			 * } else {
			 */
			// verifica a autenticidade dos valores inseridos
			try {
				double altura = Double.parseDouble(textMetro.getText() + "."
						+ textCm.getText());
				double peso = Double.parseDouble(textKilo.getText() + "."
						+ textGrama.getText());
				int idade = Integer
						.parseInt(spinnerIdade.getValue().toString());

				// Calcula o IMC (peso dividido pelo quadrado da altura)
				imc = peso / Math.pow(altura, 2);

				// inserção dos atributos no PANEL RESULTADO
				panelResultado.add(labelNomeTitulo);

				if (radioMan.isSelected() && idade >= 16) {

					if (imc < 20.7) {
						resultado = "abaixo do peso";
					} else if (imc >= 20.7 && imc < 26.5) {
						resultado = "com peso Ideal";
					} else if (imc >= 26.5 && imc < 27.9) {
						resultado = "pouco acima do peso";
					} else if (imc >= 27.9 && imc < 31.2) {
						resultado = "acima do peso";
					} else {
						resultado = "obeso";
					}
					labelResultadoCalculo.setText("O cálculo do seu IMC é: "
							+ Math.round(imc) + " e você esta " + resultado);

					panelResultado.add(labelTabelaMan);
					panelCalculo.setVisible(false);
					panelResultado.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Site em Construção",
							"Aterta", JOptionPane.WARNING_MESSAGE);
				}

				// Ocorre caso algum valor informado não for número
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Valores Inválios",
						"Alerta", JOptionPane.ERROR_MESSAGE);
			}
			// }

		}

		// /////ACÃO BOTAO NOVO CÁLCULO
		if (arg0.getSource() == buttonNovoCalculo) {

			limpaText();
			panelResultado.setVisible(false);
			panelNome.setVisible(true);
		}

		// /////ACÃO BOTAO LIMPAR
		if (arg0.getSource() == buttonLimpar) {
			limpaText();
		}
	}

	/*
	 * _____________________________________________________________________
	 * 
	 * ################## EVENTO DO TECLADO ################################
	 */
	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			acaoEntrar();
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {

	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}

	/*
	 * _____________________________________________________________________
	 * 
	 * ################## EVENTO DO MOUSE ##################################
	 */
	@Override
	public void mouseClicked(MouseEvent me) {
		hyperlink("http://indicedemassacorporal.com/");
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		if (me.getSource() == labelLinkFonte) {
			labelLinkFonte.setForeground(Color.BLUE);
			getContentPane().setCursor(
					Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	}

	@Override
	public void mouseExited(MouseEvent me) {
		labelLinkFonte.setForeground(Color.BLACK);
		getContentPane().setCursor(
				Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent me) {
	}

	@Override
	public void mouseReleased(MouseEvent me) {
	}
}
