package view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import entity.Pizza;
import entity.SorteAzar;
import entity.Tabuleiro;
import tad.Lista2;
import util.Msg;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PegueIngs extends Composite {
	private static int ings = 1;
	public Pizza myp = SorteAzar.piz, piz2;
	private Combo combo;
	private Button button;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Button button_4;
	private Label lblPegueIngredientesDe;
	private Button button_5;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PegueIngs(Composite parent, int style) {
		super(parent, style);

		lblPegueIngredientesDe = new Label(this, SWT.NONE);
		lblPegueIngredientesDe.setBounds(10, 10, 390, 31);
		lblPegueIngredientesDe.setText(myp.getSabor()+".\n"+Tabuleiro.setSA());

		combo = new Combo(this, SWT.NONE);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if(combo.getSelectionIndex()>=0)
					getIngs(Principal.l2);
			}
		});
		combo.setItems(new String[] {});
		combo.setBounds(74, 47, 286, 23);
		combo.setText("Selecione de qual pizza voce quer os ingredientes");

		button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					piz2.listaIng.buscaElmt(button.getText()).controle=0;
					myp.listaIng.buscaElmt(button.getText()).controle=1;
					ings--;
					if(ings==0)
						Principal.closeComposite();
				}
				catch(Exception ex)
				{
					Msg.mensagem("INGREDIENTE DESNECESSÁRIO", "Você não precisa desse ingrediente!", "AVISO", getShell());
				}
			}
		});
		button.setBounds(74, 90, 75, 25);
		button.setText("...");

		button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					piz2.listaIng.buscaElmt(button_1.getText()).controle=0;
					myp.listaIng.buscaElmt(button_1.getText()).controle=1;
					ings--;
					if(ings==0)
						Principal.closeComposite();
				}
				catch(Exception ex)
				{
					Msg.mensagem("INGREDIENTE DESNECESSÁRIO", "Você não precisa desse ingrediente!", "AVISO", getShell());
				}
			}
		});
		button_1.setText("...");
		button_1.setBounds(155, 90, 75, 25);

		button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					piz2.listaIng.buscaElmt(button_2.getText()).controle=0;
					myp.listaIng.buscaElmt(button_2.getText()).controle=1;
					ings--;
					if(ings==0)
						Principal.closeComposite();
				}
				catch(Exception ex)
				{
					Msg.mensagem("INGREDIENTE DESNECESSÁRIO", "Você não precisa desse ingrediente!", "AVISO", getShell());
				}

			}
		});
		button_2.setText("...");
		button_2.setBounds(236, 90, 75, 25);

		button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					piz2.listaIng.buscaElmt(button_3.getText()).controle=0;
					myp.listaIng.buscaElmt(button_3.getText()).controle=1;
					ings--;
					if(ings==0)
						Principal.closeComposite();

				}
				catch(Exception ex)
				{
					Msg.mensagem("INGREDIENTE DESNECESSÁRIO", "Você não precisa desse ingrediente!", "AVISO", getShell());
				}
			}
		});
		button_3.setText("...");
		button_3.setBounds(117, 121, 75, 25);

		button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					piz2.listaIng.buscaElmt(button_4.getText()).controle=0;
					myp.listaIng.buscaElmt(button_4.getText()).controle=1;
					ings--;
					if(ings==0)
						Principal.closeComposite();
				}
				catch(Exception ex)
				{
					Msg.mensagem("INGREDIENTE DESNECESSÁRIO", "Você não precisa desse ingrediente!", "AVISO", getShell());
				}
			}
		});
		button_4.setText("...");
		button_4.setBounds(207, 121, 75, 25);

		button_5 = new Button(this, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent e)
			{
				Principal.closeComposite();
			}
		});
		button_5.setText("Parece que não há ingredientes para você :/");
		button_5.setBounds(100, 160, 300, 25);

		limpaCombo(Principal.l2);
		//combo.remove(myp.getSabor());
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void getIngs(Lista2 l){
		piz2 = l.buscaElmt(combo.getText());
		button.setText(piz2.listaIng.retornaNaPos(1).ingrdiente);
		int temIngredientes = 0;
		if(piz2.listaIng.retornaNaPos(1).controle==0 || myp.listaIng.buscaElmt(button.getText())!=null && myp.listaIng.buscaElmt(button.getText()).controle==1)
		{
			button.setEnabled(false);
		}
		else
		{
			button.setEnabled(true);
			temIngredientes++;
		}
		
		button_1.setText(piz2.listaIng.retornaNaPos(2).ingrdiente);
		if(piz2.listaIng.retornaNaPos(2).controle==0 || myp.listaIng.buscaElmt(button_1.getText())!=null && myp.listaIng.buscaElmt(button_1.getText()).controle==1)
		{
			button_1.setEnabled(false);
		}
		else
		{
			button_1.setEnabled(true);
			temIngredientes++;
		}
		
		button_2.setText(piz2.listaIng.retornaNaPos(3).ingrdiente);
		if(piz2.listaIng.retornaNaPos(3).controle==0 || myp.listaIng.buscaElmt(button_2.getText())!=null && myp.listaIng.buscaElmt(button_2.getText()).controle==1)
		{
			button_2.setEnabled(false);
		}
		else
		{
			button_2.setEnabled(true);
			temIngredientes++;
		}
		
		button_3.setText(piz2.listaIng.retornaNaPos(4).ingrdiente);
		if(piz2.listaIng.retornaNaPos(4).controle==0 || myp.listaIng.buscaElmt(button_3.getText())!=null && myp.listaIng.buscaElmt(button_3.getText()).controle==1)
		{
			button_3.setEnabled(false);
		}
		else
		{
			button_3.setEnabled(true);
			temIngredientes++;
		}
		
		button_4.setText(piz2.listaIng.retornaNaPos(5).ingrdiente);
		if(piz2.listaIng.retornaNaPos(5).controle==0 || myp.listaIng.buscaElmt(button_4.getText())!=null && myp.listaIng.buscaElmt(button_4.getText()).controle==1)
		{
			button_4.setEnabled(false);
		}
		else
		{
			button_4.setEnabled(true);
			temIngredientes++;
		}
		
		if (temIngredientes > 0)
		{
			button_5.setEnabled(false);
		}
		else
		{
			button_5.setEnabled(true);
		}
	}

	public void limpaCombo(Lista2 l){
		for(int i=1;i<=l.comprimento();i++){
			combo.add(l.retornaNaPos(i).p.getSabor());
		}
		combo.remove(myp.getSabor());
	}

	public static void getNum(int n){
		ings = n;
	}
}
