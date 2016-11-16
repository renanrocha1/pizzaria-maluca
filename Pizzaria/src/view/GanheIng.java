package view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import entity.Pizza;
import entity.SorteAzar;
import entity.Tabuleiro;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GanheIng extends Composite {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Label lblPizza;
	public Pizza piz;
	private static int ings = 0;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GanheIng(Composite parent, int style) {
		super(parent, style);
		
		Label lblGanhouIngredientes = new Label(this, SWT.NONE);
		lblGanhouIngredientes.setBounds(10, 10, 118, 15);
		lblGanhouIngredientes.setText("Ganhou ingrediente(s)");
		
		btn1 = new Button(this, SWT.NONE);
		btn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz.listaIng.buscaElmt(btn1.getText()).controle=1;
				btn1.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		btn1.setBounds(54, 95, 75, 25);
		btn1.setText("...");
		
		btn2 = new Button(this, SWT.NONE);
		btn2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz.listaIng.buscaElmt(btn2.getText()).controle=1;
				btn2.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		btn2.setText("...");
		btn2.setBounds(135, 95, 75, 25);
		
		btn3 = new Button(this, SWT.NONE);
		btn3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz.listaIng.buscaElmt(btn3.getText()).controle=1;
				btn3.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		btn3.setText("...");
		btn3.setBounds(216, 95, 75, 25);
		
		btn4 = new Button(this, SWT.NONE);
		btn4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz.listaIng.buscaElmt(btn4.getText()).controle=1;
				btn4.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		btn4.setText("...");
		btn4.setBounds(297, 95, 75, 25);
		
		btn5 = new Button(this, SWT.NONE);
		btn5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz.listaIng.buscaElmt(btn5.getText()).controle=1;
				btn5.setEnabled(false);
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		btn5.setText("...");
		btn5.setBounds(177, 126, 75, 25);
		
		lblPizza = new Label(this, SWT.NONE);
		lblPizza.setBounds(30, 30, 396, 66);
		lblPizza.setText("...");
		getPizza(SorteAzar.piz);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void getPizza(Pizza p){
		piz = p;
		lblPizza.setText(p.getSabor()+".\n"+Tabuleiro.setSA());
		btn1.setText(p.listaIng.retornaNaPos(1).ingrdiente);
		btn2.setText(p.listaIng.retornaNaPos(2).ingrdiente);
		btn3.setText(p.listaIng.retornaNaPos(3).ingrdiente);
		btn4.setText(p.listaIng.retornaNaPos(4).ingrdiente);
		btn5.setText(p.listaIng.retornaNaPos(5).ingrdiente);
		if(p.listaIng.retornaNaPos(1).controle==1){btn1.setEnabled(false);}
		if(p.listaIng.retornaNaPos(2).controle==1){btn2.setEnabled(false);}
		if(p.listaIng.retornaNaPos(3).controle==1){btn3.setEnabled(false);}
		if(p.listaIng.retornaNaPos(4).controle==1){btn4.setEnabled(false);}
		if(p.listaIng.retornaNaPos(5).controle==1){btn5.setEnabled(false);}
	}
	
	public static void getNum(int n){
		ings = n;
	}
	
	
}
