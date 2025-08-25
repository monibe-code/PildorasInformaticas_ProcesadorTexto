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
		setBounds(500,300,550,500);
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
		//construcción de los botones con el método configurabarra
		barraHerramientas=new JToolBar();
		configuraBarra("src/Procesador3/imagenes/negrita.gif").addActionListener(new StyledEditorKit.BoldAction());
		configuraBarra("src/Procesador3/imagenes/cursiva.gif").addActionListener(new StyledEditorKit.ItalicAction());
		configuraBarra("src/Procesador3/imagenes/subrayado.gif").addActionListener(new StyledEditorKit.UnderlineAction());
		barraHerramientas.addSeparator();
		configuraBarra("src/Procesador3/imagenes/bolaazul.gif").addActionListener(new StyledEditorKit.ForegroundAction("Azul",Color.BLUE));
		configuraBarra("src/Procesador3/imagenes/bolaamarilla.gif").addActionListener(new StyledEditorKit.ForegroundAction("Amarillo", Color.YELLOW));
		configuraBarra("src/Procesador3/imagenes/bolaroja.gif").addActionListener(new StyledEditorKit.ForegroundAction("Rojo", Color.RED));
		barraHerramientas.addSeparator();
		configuraBarra("src/Procesador3/imagenes/derecha.gif").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 0));
		configuraBarra("src/Procesador3/imagenes/centrado.gif").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		configuraBarra("src/Procesador3/imagenes/izquierda.gif").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 2));

		barraHerramientas.setOrientation(1);
		add(barraHerramientas, BorderLayout.WEST);
		}
	
	public JButton configuraBarra(String ruta) {
		JButton boton = new JButton(new ImageIcon(ruta));
		barraHerramientas.add(boton);
		return boton;
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
	private JToolBar barraHerramientas;
	private JButton negritaBarra, cursivaBarra, subraBarra, rojoBarra, amarilloBarra,azulBarra, izquierdaBarra, derechaBarra, centradoBarra;
	
}

