package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ImcView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelNome, panelCalculo;
	private JLabel labelNome, labelPeso, labelAltura, labelIdade, labelTitulo,
			labelNomeTitulo;
	private JTextField textNome, textPeso, TextAltura;
	private JSpinner spinnerIdade;
	private JButton buttonEntrar, buttonCalcular, buttonLimpar;

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
		setIconImage(new ImageIcon(getClass().getClassLoader().getResource(
				"Image/imc.png")).getImage());

		/*
		 * _________________________________________________________________
		 * ######## INSERE UMA IMAGEM COMO FUNDO DE TELA ###################
		 */
		setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader()
				.getResource("Image/fundosite.jpg"))));

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
		 * __________________________________________________________________
		 * ########### REDIMENCAO DA TELA ###################################
		 * Deixa a janela, redimensionável (true) ou não (false)
		 */
		setResizable(false);

		/*
		 * ___________________________________________________________________
		 * ####### CENTRALIZA A JANELA NO CENTRO DA TELA #####################
		 * Deixa o JFrame alinhado em algum ponto da tela, por exemplo, ‘null’
		 * deixa alinhado no centro
		 */
		setLocationRelativeTo(null);

		/*
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
		 * ____________________________________________________________________
		 * ############# VISIBILIDADE DA JANELA ###############################
		 * Deixando a janela visível (true), ou invisível (false)
		 */
		setVisible(true);

		/*
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
		 * _____________________________________________________________________
		 * ############ INSTANCIA O 2o JPANEL ##################################
		 */
		panelCalculo = new JPanel(null);
		panelCalculo.setBounds(290, 0, 600, 600);
		panelCalculo.setOpaque(false);
		panelCalculo.setVisible(false);
		panelCalculo.setBorder(BorderFactory
				.createLineBorder(new Color(0, 0, 0)));
		this.add(panelCalculo);

		/*
		 * _____________________________________________________________________
		 * ############### INSTANCIA O LABEL ###################################
		 */
		labelTitulo = new JLabel("Calcule seu IMC:");
		labelTitulo.setFont(new Font("Times New Roman", Font.BOLD, 50));
		labelTitulo.setBounds(85, 85, 400, 100);
		panelNome.add(labelTitulo);

		/*
		 * _____________________________________________________________________
		 * ############### INSTANCIA O LABEL NOME ##############################
		 */
		labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelNome.setBounds(85, 200, 60, 60);
		panelNome.add(labelNome);

		/*
		 * _____________________________________________________________________
		 * ############### INSTANCIA O TEXTFIELD NOME ##########################
		 */
		textNome = new JTextField();
		textNome.setBounds(85, 240, 400, 30);
		textNome.grabFocus();
		panelNome.add(textNome);
		

		/*
		 * _____________________________________________________________________
		 * ############### INSTANCIA O BUTTON ENTRAR ###########################
		 */
		buttonEntrar = new JButton("Entrar");
		buttonEntrar.setBounds(240, 300, 100,40);
		buttonEntrar.setFocusPainted(false);;
		panelNome.add(buttonEntrar);
		panelNome.repaint();

	}

}
