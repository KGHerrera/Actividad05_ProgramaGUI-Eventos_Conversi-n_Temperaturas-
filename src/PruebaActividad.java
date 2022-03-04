import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;


class ConvensorTemperaturas {
	
	public double deCelFah (double c){
		return Math.round((c * 9/5 + 32)*100.0)/100.0;
	}
	
	public double deCelKel (double c){
		return Math.round((c + 273.15)*100.0)/100.0;
	}
	
	public double deCelRank (double c){
		return Math.round((c * 9/5 + 491.67)*100.0)/100.0;
	}
	
	//=================================
	
	public double deFahCel (double f){
		return Math.round(((f - 32) * 5/9)*100.0)/100.0;
	}
	
	public double deFahKel (double f){
		return Math.round(((f - 32) * 5/9 + 273.15)*100.0)/100.0;
	}
	
	public double deFahRank (double f){
		return Math.round((f + 459.67)*100.0)/100.0;
	}
	
	//=================================
	
	public double deKelCel (double k){
		return Math.round((k - 273.15)*100.0)/100.0;
	}
	
	public double deKelFah (double k){
		return Math.round(((k - 273.15) * 9/5 + 32 )*100.0)/100.0;
	}
	
	public double deKelRank (double k){
		return Math.round((k * 1.8)*100.0)/100.0;
	}
	
	//=================================
	
	public double deRankCel (double r){
		return Math.round(((r - 491.67) * 5/9)*100.0)/100.0;
	}
	
	public double deRankFah (double r){
		return Math.round((r - 459.67)*100.0)/100.0;
	}
	
	public double deRankKel (double r){
		return Math.round((r * 5/9)*100.0)/100.0;
	}
	
}

class VentanaInicio extends JFrame implements ActionListener, KeyListener{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JTextField cajaGrados;
	JFormattedTextField cajaResultado;
	JComboBox<String> comboGradosUno, comboGradosDos;
	
	ConvensorTemperaturas c1;
	DecimalFormat formato = new java.text.DecimalFormat("0.00"); 
	
	byte index1, index2, prueba = 0, prueba2 = 1;
	double grados;
	String temperaturas[] = {"Celcius","Fahrenheit","Kelvin","Rankine"};
	
	public VentanaInicio() {
		
		Font font1 = new Font("Calibri", Font.BOLD , 20);
		getContentPane().setLayout(gbl);
		
		gbc.insets = new Insets(5,15,5,15);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ventana Principal");
		setSize(960, 620);
		setLocationRelativeTo(null);
		setVisible(true);
		gbc.fill = GridBagConstraints.BOTH;
		
		c1 = new ConvensorTemperaturas();
		
		JLabel txtConversor = new JLabel("Conversor Temperaturas");
		txtConversor.setFont(font1);
		alinearComponente(txtConversor, 0, 0, 3, 1);
		
		JLabel txtConvertir = new JLabel("Convertir");
		alinearComponente(txtConvertir, 0, 1, 1, 1);
		
		cajaGrados = new JTextField(8);
		alinearComponente(cajaGrados, 1, 1, 1, 1);
		cajaGrados.addKeyListener(this);
		
		comboGradosUno = new JComboBox<String>(temperaturas);
		alinearComponente(comboGradosUno, 3, 1, 1, 1);
		comboGradosUno.addActionListener(this);
		
		JLabel txtConvertirA = new JLabel("A: ");
		alinearComponente(txtConvertirA, 0, 2, 1, 1);
		
		comboGradosDos = new JComboBox<String>(temperaturas);
		alinearComponente(comboGradosDos, 1, 2, 1, 1);
		comboGradosDos.setSelectedIndex(1);
		comboGradosDos.addActionListener(this);
		
		JLabel txtIgual = new JLabel(" = ");
		alinearComponente(txtIgual, 2, 2, 1, 1);
		
		cajaResultado = new JFormattedTextField(formato);
		cajaResultado.setEditable(false);
		
		alinearComponente(cajaResultado, 3, 2, 1, 1);
		
		pack();
	}
	
	public void alinearComponente(Component c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		
		gbc.gridwidth = w;
		gbc.gridheight = h;
		
		gbl.setConstraints(c, gbc);
		add(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		index1 = (byte) comboGradosUno.getSelectedIndex();
		index2 = (byte) comboGradosDos.getSelectedIndex();
		try {
			
			grados = Double.parseDouble(cajaGrados.getText());
			
		} catch (Exception e2) {
			
			
		}
		
			
		if (e.getSource() == comboGradosDos || e.getSource() == comboGradosUno) {
			
			if(!cajaGrados.getText().equals("")) {
				if(index1 == index2) {
					cajaResultado.setText(cajaGrados.getText());
				}
				
				else if (index1 == 0 && index2 == 1) 
					cajaResultado.setText((String.valueOf(c1.deCelFah(grados))));
				
				
				else if (index1 == 0 && index2 == 2) 
					cajaResultado.setText((String.valueOf(c1.deCelKel(grados))));
				
				
				else if (index1 == 0 && index2 == 3) 
					cajaResultado.setText((String.valueOf(c1.deCelRank(grados))));
				
				
				
				else if (index1 == 1 && index2 == 0) 
					cajaResultado.setText((String.valueOf(c1.deFahCel(grados))));
				
				
				else if (index1 == 1 && index2 == 2) 
					cajaResultado.setText((String.valueOf(c1.deFahKel(grados))));
				
				
				else if (index1 == 1 && index2 == 3) 
					cajaResultado.setText((String.valueOf(c1.deFahRank(grados))));
				
				
				
				else if (index1 == 2 && index2 == 0) 
					cajaResultado.setText((String.valueOf(c1.deKelCel(grados))));
				
				
				else if (index1 == 2 && index2 == 1) 
					cajaResultado.setText((String.valueOf(c1.deKelFah(grados))));
				
				
				else if (index1 == 2 && index2 == 3) 
					cajaResultado.setText((String.valueOf(c1.deKelRank(grados))));
				
				
				
				else if (index1 == 3 && index2 == 0) 
					cajaResultado.setText((String.valueOf(c1.deRankCel(grados))));
				
				
				else if (index1 == 3 && index2 == 1) 
					cajaResultado.setText((String.valueOf(c1.deRankFah(grados))));
				
				
				else if (index1 == 3 && index2 == 2) 
					cajaResultado.setText((String.valueOf(c1.deRankKel(grados))));
			
			}
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == cajaGrados) {
			if (Character.isDigit(e.getKeyChar()) || ((byte)e.getKeyChar() == 46)){
				
				if (cajaGrados.getText().contains(".") && e.getKeyChar() == '.') {
					e.consume();
				}
				
			}else {
				e.consume();
			}
			
			//System.out.println((byte)e.getKeyChar());
		}
	
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class PruebaActividad {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		
			@Override
			public void run() {				
				// TODO Auto-generated method stub
				new VentanaInicio();
			
			}
		});
	}
	
	
}