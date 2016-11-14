package view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import entity.Pizza;
import entity.SorteAzar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PercaIng extends Composite {
	private Label lblPizza;
	public Pizza p;
	private Button button;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Button button_4;
	private static int ings;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PercaIng(Composite parent, int style) {
		super(parent, style);
		
		Label lblPercaIngredientes = new Label(this, SWT.NONE);
		lblPercaIngredientes.setBounds(10, 10, 105, 15);
		lblPercaIngredientes.setText("Perca Ingrediente(s)");
		
		lblPizza = new Label(this, SWT.NONE);
		lblPizza.setBounds(32, 40, 83, 15);
		lblPizza.setText("...");
		
		button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				p.listaIng.buscaElmt(button.getText()).controle=0;
				button.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button.setBounds(69, 78, 75, 25);
		button.setText("...");
		
		button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				p.listaIng.buscaElmt(button_1.getText()).controle=0;
				button_1.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button_1.setText("...");
		button_1.setBounds(150, 78, 75, 25);
		
		button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				p.listaIng.buscaElmt(button_2.getText()).controle=0;
				button_2.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button_2.setText("...");
		button_2.setBounds(231, 78, 75, 25);
		
		button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				p.listaIng.buscaElmt(button_3.getText()).controle=0;
				button_3.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button_3.setText("...");
		button_3.setBounds(312, 78, 75, 25);
		
		button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				p.listaIng.buscaElmt(button_4.getText()).controle=0;
				button_4.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button_4.setText("...");
		button_4.setBounds(189, 109, 75, 25);
		
		getPizza(SorteAzar.piz);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void getPizza(Pizza piz){
		p = piz;
		lblPizza.setText(p.getSabor());
		button.setText(p.listaIng.retornaNaPos(1).ingrdiente);
		button_1.setText(p.listaIng.retornaNaPos(2).ingrdiente);
		button_2.setText(p.listaIng.retornaNaPos(3).ingrdiente);
		button_3.setText(p.listaIng.retornaNaPos(4).ingrdiente);
		button_4.setText(p.listaIng.retornaNaPos(5).ingrdiente);
		if(p.listaIng.retornaNaPos(1).controle==0){button.setEnabled(false);}
		if(p.listaIng.retornaNaPos(2).controle==0){button_1.setEnabled(false);}
		if(p.listaIng.retornaNaPos(3).controle==0){button_2.setEnabled(false);}
		if(p.listaIng.retornaNaPos(4).controle==0){button_3.setEnabled(false);}
		if(p.listaIng.retornaNaPos(5).controle==0){button_4.setEnabled(false);}
	}
	
	public static void getNum(int n){
		ings = n;
	}

}
