package cr.com.aluraHotel.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ValidarInputsController {
	private boolean puedeSeguir;

	public boolean validarInputs(List<JTextField> inputs) {
		// TODO Auto-generated method stub
		List<JTextField> validos = new ArrayList<JTextField>();
		inputs.forEach(input -> {
			boolean esValido = input.getText().isEmpty();
			if(!esValido) {
				validos.add(input);	
			}
		});
		
		puedeSeguir = validos.size() == inputs.size();
		validos.forEach(input -> System.out.println(input.getName()));
		return puedeSeguir;
		
	}
	
	public boolean validarDates(List<JDateChooser> choosers) {
		// TODO Auto-generated method stub
		List<JDateChooser> validos = new ArrayList<JDateChooser>();
		choosers.forEach(input -> {
			boolean esValido = input.getDate() == null;
			if(!esValido) {
				validos.add(input);	
			}
		});
		
		puedeSeguir = validos.size() == choosers.size();
		validos.forEach(input -> System.out.println(input.getName()));
		return puedeSeguir;
		
	}
	
	public boolean validarTxt(List<JFormattedTextField> inputs) {
		// TODO Auto-generated method stub
		List<JFormattedTextField> validos = new ArrayList<JFormattedTextField>();
		inputs.forEach(input -> {
			boolean esValido = input.getText().isEmpty();
			if(!esValido) {
				validos.add(input);	
			}
		});
		
		puedeSeguir = validos.size() == inputs.size();
		validos.forEach(input -> System.out.println(input.getName()));
		return puedeSeguir;
		
	}

}





