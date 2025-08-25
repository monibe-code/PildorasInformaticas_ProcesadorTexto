package procesador3;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class Procesador3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador mimarco=new MarcoProcesador();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoProcesador extends JFrame{
	public MarcoProcesador() {
		setBounds(500,300,550,550);
		add(new LaminaProcesador());
		setVisible(true);
	}
}

class LaminaProcesador extends JPanel{
	public LaminaProcesador() {

		
		setLayout(new BorderLayout());
		JPanel laminamenu= new JPanel();
		JMenuBar barra= new JMenuBar();

		//-----------------------------------------------------
		fuente= new JMenu("Fuente");
		estilo= new JMenu("Estilo");
		tamagno= new JMenu("Tamaño");
		//--------------------------------------------------------
		//Creación de los elementos del menú
		configura_menu("Arial", "fuente", "Arial", 9, 10,"");
		configura_menu("Courier", "fuente", "Courier", 9, 10,"");
		configura_menu("Verdana", "fuente", "Verdana", 9, 10,"");
		
		//--------------------------------------------------------
		//creación JMenuItem con método configura_menu
		configura_menu("Negrita", "estilo", "", Font.BOLD,1,"src/Procesador3/imagenes/negrita.gif");
		configura_menu("Cursiva", "estilo", "", Font.ITALIC,1,"src/Procesador3/imagenes/cursiva.gif");
		//----------------------------------------------------------
		//creación de JRadioButtonMenuItem para los tamaños
		ButtonGroup migrupo= new ButtonGroup();
		JRadioButtonMenuItem tam12= new JRadioButtonMenuItem("12", true);
		JRadioButtonMenuItem tam16= new JRadioButtonMenuItem("16", false);
		JRadioButtonMenuItem tam18= new JRadioButtonMenuItem("18", false);
		JRadioButtonMenuItem tam20= new JRadioButtonMenuItem("20", false);
		tam12.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 12));
		tam16.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 16));
		tam18.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 18));
		tam20.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 20));
//		//atajo de teclado para tam20
//		tam20.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		migrupo.add(tam12);
		migrupo.add(tam16);
		migrupo.add(tam18);
		migrupo.add(tam20);
		tamagno.add(tam12);
		tamagno.add(tam16);
		tamagno.add(tam18);
		tamagno.add(tam20);
		//---------------------------------------------------------
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tamagno);
		
		laminamenu.add(barra);
		add(laminamenu, BorderLayout.NORTH);
		
		
		miarea=new JTextPane();
		add(miarea, BorderLayout.CENTER);
		
		//----------------------------------------------------------
		JPopupMenu emergente= new JPopupMenu();
		JMenuItem negritaE= new JMenuItem("Negrita");
		JMenuItem cursivaE= new JMenuItem("Cursiva");
		negritaE.addActionListener(new StyledEditorKit.BoldAction() );
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		emergente.add(negritaE);
		emergente.add(cursivaE);
		//ahora debemos especificar dónde va a hacer efecto (en el JTextPane)
		miarea.setComponentPopupMenu(emergente);
		//--------------------------------------------------------
		//Creación barra herramientas a la izquierda
		JToolBar barraHerramientas= new JToolBar();
		JButton negritaBarra= new JButton(new ImageIcon("src/Procesador3/imagenes/negrita.gif"));
		JButton cursivaBarra= new JButton(new ImageIcon("src/Procesador3/imagenes/cursiva.gif"));
		JButton subraBarra= new JButton(new ImageIcon("src/Procesador3/imagenes/subrayado.gif"));
		JButton azulBarra= new JButton(new ImageIcon("src/Procesador3/imagenes/bolaAzul.gif"));
		JButton amarilloBarra= new JButton(new ImageIcon("src/Procesador3/imagenes/bolaAmarilla.gif"));
		JButton rojoBarra= new JButton(new ImageIcon("src/Procesador3/imagenes/bolaRoja.gif"));
		JButton derechaBarra= new JButton(new ImageIcon("src/Procesador3/imagenes/derecha.gif"));
		JButton centradoBarra= new JButton(new ImageIcon("src/Procesador3/imagenes/centrado.gif"));
		JButton izquierdaBarra= new JButton(new ImageIcon("src/Procesador3/imagenes/izquierda.gif"));

		
		//---------------------------------------------------------
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		subraBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Azul",Color.BLUE));
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Azul",Color.YELLOW));
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Azul",Color.RED));
		derechaBarra.addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 0));
		centradoBarra.addActionListener(new StyledEditorKit.AlignmentAction("Centrado",1));
		izquierdaBarra.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 2));

		//---------------------------------------------------------
		
		barraHerramientas.add(negritaBarra);
		barraHerramientas.add(cursivaBarra);
		barraHerramientas.add(subraBarra);
		barraHerramientas.add(azulBarra);
		barraHerramientas.add(amarilloBarra);
		barraHerramientas.add(rojoBarra);
		barraHerramientas.add(derechaBarra);
		barraHerramientas.add(centradoBarra);
		barraHerramientas.add(izquierdaBarra);
	
		barraHerramientas.setOrientation(1);
		add(barraHerramientas, BorderLayout.WEST);
		}
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam,String ruta_icono ) {
		JMenuItem elem_menu= new JMenuItem(rotulo, new ImageIcon(ruta_icono));
		if(menu=="fuente") {
			fuente.add(elem_menu);
			if(tipo_letra=="Arial") {
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Arial"));
			}else if(tipo_letra=="Courier") {
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Courier"));

			}else  if(tipo_letra=="Verdana") {
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Verdana"));

			}

		}else if(menu=="estilo") {
			estilo.add(elem_menu);
			if(estilos==Font.BOLD) {
				elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				elem_menu.addActionListener(new StyledEditorKit.BoldAction());
			}else if(estilos==Font.ITALIC) {
				elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
				elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		}
		
	}

	
	private JTextPane miarea;
	private JMenu fuente, estilo, tamagno;
}

