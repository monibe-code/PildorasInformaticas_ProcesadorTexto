package procesador3;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

import java.awt.*;
import java.awt.event.*;

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
		//Creación de los elementos del menú
		configura_menu("Arial", "fuente", "Arial", 9, 10, "");
		configura_menu("Courier", "fuente", "Courier", 9, 10, "");
		configura_menu("Verdana", "fuente", "Verdana", 9, 10,"");
		
		//--------------------------------------------------------
		configura_menu("Negrita", "estilo", "", Font.BOLD, 1,"bin/procesador3/negrita.gif");
		configura_menu("Cursiva", "estilo", "", Font.ITALIC, 1, "bin/procesador3/cursiva.gif");
		//----------------------------------------------------------
		configura_menu("12", "tamaño", "", 9, 12, "");
		configura_menu("16", "tamaño", "", 9, 16,"");
		configura_menu("18", "tamaño", "", 9, 18,"");
		configura_menu("20", "tamaño", "", 9, 20,"");
		//---------------------------------------------------------
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tamagno);
		
		laminamenu.add(barra);
		add(laminamenu, BorderLayout.NORTH);
		
		
		miarea=new JTextPane();
		add(miarea, BorderLayout.CENTER);
		
		
		
	}
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam, String ruta_icono) {
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
			elem_menu.addActionListener(new StyledEditorKit.BoldAction() );
			}else if(estilos==Font.ITALIC) {
				elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		}else if(menu=="tamaño") {
			tamagno.add(elem_menu);
			elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", tam));
		}
		
	}

	
	private JTextPane miarea;
	private JMenu fuente, estilo, tamagno;
}

