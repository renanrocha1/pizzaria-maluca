package view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import entity.Pizza;
import entity.SorteAzar;
import tad.Lista2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PegueIngs extends Composite {
	private static int ings = 1;
	public Pizza myp, piz2;
	private Combo combo;
	private Button button;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Button button_4;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PegueIngs(Composite parent, int style) {
		super(parent, style);
		
		Label lblPegueIngredientesDe = new Label(this, SWT.NONE);
		lblPegueIngredientesDe.setBounds(10, 10, 233, 15);
		lblPegueIngredientesDe.setText("Pegue ingrediente(s) de outro(s) jogador(es)");
		
		combo = new Combo(this, SWT.NONE);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				getIngs(Principal.l2);
			}
		});
		combo.setItems(new String[] {"Calabresa", "Portuguesa", "Toscana", "Marguerita", "Romana", "Vegetariana"});
		combo.setBounds(74, 47, 286, 23);
		combo.setText("Selecione de qual pizza voce quer os ingredientes");
		
		button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz2.listaIng.buscaElmt(button.getText()).controle=0;
				myp.listaIng.buscaElmt(button.getText()).controle=1;
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button.setBounds(74, 90, 75, 25);
		button.setText("...");
		
		button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz2.listaIng.buscaElmt(button_1.getText()).controle=0;
				myp.listaIng.buscaElmt(button_1.getText()).controle=1;
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button_1.setText("...");
		button_1.setBounds(155, 90, 75, 25);
		
		button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz2.listaIng.buscaElmt(button_2.getText()).controle=0;
				myp.listaIng.buscaElmt(button_2.getText()).controle=1;
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button_2.setText("...");
		button_2.setBounds(236, 90, 75, 25);
		
		button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz2.listaIng.buscaElmt(button_3.getText()).controle=0;
				myp.listaIng.buscaElmt(button_3.getText()).controle=1;
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button_3.setText("...");
		button_3.setBounds(117, 121, 75, 25);
		
		button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				piz2.listaIng.buscaElmt(button_4.getText()).controle=0;
				myp.listaIng.buscaElmt(button_4.getText()).controle=1;
				ings--;
				if(ings==0)
					Principal.closeComposite();
			}
		});
		button_4.setText("...");
		button_4.setBounds(207, 121, 75, 25);
		
		myp = SorteAzar.piz;
		combo.remove(myp.getSabor());
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public void getIngs(Lista2 l){
		System.out.println(l.buscaElmt(combo.getText()));
		piz2 = l.buscaElmt(combo.getText());
		button.setText(piz2.listaIng.retornaNaPos(1).ingrdiente);
		button_1.setText(piz2.listaIng.retornaNaPos(2).ingrdiente);
		button_2.setText(piz2.listaIng.retornaNaPos(3).ingrdiente);
		button_3.setText(piz2.listaIng.retornaNaPos(4).ingrdiente);
		button_4.setText(piz2.listaIng.retornaNaPos(5).ingrdiente);
	}
	
	public static void getNum(int n){
		ings = n;
	}
}
