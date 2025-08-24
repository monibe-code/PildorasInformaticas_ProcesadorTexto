package procesador3;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;


public class Procesador3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador mimarco=new MarcoProcesador();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoProcesador extends JFrame{
	public MarcoProcesador() {
		setBounds(500,300,550,400);
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
				elem_menu.addActionListener(new StyledEditorKit.BoldAction());
			}else if(estilos==Font.ITALIC) {
				elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		}
		
	}

	
	private JTextPane miarea;
	private JMenu fuente, estilo, tamagno;
}

