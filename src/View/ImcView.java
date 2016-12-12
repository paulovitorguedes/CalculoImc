package View;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

public class ImcView extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelNome, panelCalculo, panelGenero;
	private JLabel labelNome, labelPeso, labelAltura, labelMetro, labelCm,
			labelIdade, labelTitulo, labelNomeTitulo, labelCalculoTitulo,
			labelWoman, labelMen, labelKilo, labelGrama;
	private JTextField textNome, textMetro, textCm, textKilo, textGrama;
	private JSpinner spinnerIdade;
	private SpinnerModel spinnerNumberModel;
	private JRadioButton radioMan, radioWoman;
	private ButtonGroup groupRadioGerero;
	private JButton buttonEntrar, buttonCalcular, buttonLimpar,
			buttonNovoCalculo;
	private ImageIcon imgMan, imgWoman;
	private String nomeTitulo;
	private Border blackline;
	private TitledBorder title;

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
		 * ############ INSTANCIA O 1o JPANEL ##################################
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
		 * ############ INSTANCIA O 2o JPANEL ##################################
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
		 * ############ INSTANCIA O 3o JPANEL ##################################
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
		 * ######### ADICIONANDO OS ATRIBUTOS NO 1o PANEL (panelNome) ##########
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
		 * ------- ADICIONANDO OS ATRIBUTOS NO 2o PANEL (panelCalculo) ---------
		 */

		labelCalculoTitulo = new JLabel("Calculo IMC de:");
		labelCalculoTitulo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelCalculoTitulo.setBounds(85, 55, 400, 100);
		panelCalculo.add(labelCalculoTitulo);

		labelNomeTitulo = new JLabel();
		labelNomeTitulo.setFont(new Font("Times New Roman", Font.BOLD, 40));
		labelNomeTitulo.setBounds(85, 100, 500, 100);
		panelCalculo.add(labelNomeTitulo);

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
		buttonCalcular.addActionListener(this);
		panelCalculo.add(buttonCalcular);

		buttonLimpar = new JButton("Limpar");
		buttonLimpar.setBounds(200, 550, 90, 40);
		buttonLimpar.addActionListener(this);
		panelCalculo.add(buttonLimpar);
	}

	// ________________________
	// FIM DO METODO CONSTRUTOR

	/*
	 * _____________________________________________________________________
	 * 
	 * ################## ACAO DO BUTTON ENTRAR ############################
	 */
	public void acaoEntrar() {
		nomeTitulo = textNome.getText().toString();

		if (!nomeTitulo.equals("")) {
			labelNomeTitulo.setText(nomeTitulo);
		} else {
			labelNomeTitulo.setText("Sem Nome ...");
		}

		panelNome.setVisible(false);
		panelCalculo.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == buttonEntrar) {
			acaoEntrar();
		}

		if (arg0.getSource() == buttonCalcular) {

			if (textMetro.getText().toString().equals("")
					|| textCm.getText().toString().equals("")
					|| textKilo.getText().toString().equals("")
					|| textGrama.getText().toString().equals("")) {

				showMessageDialog(null,
						"Favor preencher todos os campos obrigatórios",
						"Alerta", JOptionPane.INFORMATION_MESSAGE);

			} else if (!radioMan.isSelected() && !radioWoman.isSelected()) {

				showMessageDialog(null, "Favor informar o genero", "Alerta",
						JOptionPane.INFORMATION_MESSAGE);

			} else {

				try {
					double altura = Double.parseDouble(textMetro.getText()
							+ "." + textCm.getText());
					double peso = Double.parseDouble(textKilo.getText() + "."
							+ textGrama.getText());
					int idade = Integer.parseInt(spinnerIdade.getValue()
							.toString());

					double imc = peso / Math.pow(altura, 2);

					String resultado = "";
					if (radioMan.isSelected() && idade >= 16) {

						if (imc < 20.7) {
							resultado = "Abaixo do peso";
						} else if (imc >= 20.7 && imc < 26.5) {
							resultado = "Peso Ideal";
						} else if (imc >= 26.5 && imc < 27.9) {
							resultado = "Pouco acima do peso";
						} else if (imc >= 27.9 && imc < 31.2) {
							resultado = "Acima do peso";
						} else {
							resultado = "Obeso";
						}

						JOptionPane.showMessageDialog(null, "Seu IMC é: " + imc
								+ ".\nResultado: " + resultado + ".", "Aterta",
								INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null,
								"Site em Construção", "Aterta",
								JOptionPane.WARNING_MESSAGE);
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valores Inválios",
							"Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}

		}

		if (arg0.getSource() == buttonLimpar) {

			textCm.setText("");
			textGrama.setText("");
			textKilo.setText("");
			textMetro.setText("");
			spinnerIdade.setValue(16);
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			acaoEntrar();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
