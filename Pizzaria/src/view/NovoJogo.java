package view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import entity.Pizza;
import tad.Lista2;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class NovoJogo extends Dialog {

	protected Lista2 result = new Lista2();
	protected Shell shell;
	private Label lblTexto;
	private Combo combo;
	private int jogadores, n=1;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public NovoJogo(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Lista2 open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText(getText());
		
		Button btnCalabresa = new Button(shell, SWT.NONE);
		
		btnCalabresa.setText("Calabresa");
		btnCalabresa.setBounds(126, 156, 75, 25);
		
		Button btnVegetariana = new Button(shell, SWT.NONE);
		
		btnVegetariana.setText("Vegetariana");
		btnVegetariana.setBounds(144, 104, 75, 25);
		
		Button btnRomana = new Button(shell, SWT.NONE);
		
		btnRomana.setText("Romana");
		btnRomana.setBounds(225, 104, 75, 25);
		
		Button btnToscana = new Button(shell, SWT.NONE);
		
		btnToscana.setText("Toscana");
		btnToscana.setBounds(306, 104, 75, 25);
		
		Button btnMarguerita = new Button(shell, SWT.NONE);
		
		btnMarguerita.setText("Marguerita");
		btnMarguerita.setBounds(63, 104, 75, 25);
		
		Button btnPortuguesa = new Button(shell, SWT.NONE);
		
		btnPortuguesa.setText("Portuguesa");
		btnPortuguesa.setBounds(225, 156, 75, 25);
		
		btnMarguerita.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.insereUltimo(new Pizza('m'));
				if (jogadores<=1){
					btnMarguerita.setEnabled(false);
					btnPortuguesa.setEnabled(false);
					btnRomana.setEnabled(false);
					btnToscana.setEnabled(false);
					btnVegetariana.setEnabled(false);
					btnCalabresa.setEnabled(false);
				}
				else{
					btnMarguerita.setEnabled(false);
					jogadores--;
				}
				lblTexto.setText("Jogador "+(n++)+" selecione sua pizza");
			}
		});
		
		btnVegetariana.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.insereUltimo(new Pizza('v'));
				if (jogadores<=1){
					btnMarguerita.setEnabled(false);
					btnPortuguesa.setEnabled(false);
					btnRomana.setEnabled(false);
					btnToscana.setEnabled(false);
					btnVegetariana.setEnabled(false);
					btnCalabresa.setEnabled(false);
				}
				else{
					btnVegetariana.setEnabled(false);
					jogadores--;
				}
				lblTexto.setText("Jogador "+(n++)+" selecione sua pizza");
			}
		});
		
		btnRomana.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.insereUltimo(new Pizza('r'));
				if (jogadores<=1){
					btnMarguerita.setEnabled(false);
					btnPortuguesa.setEnabled(false);
					btnRomana.setEnabled(false);
					btnToscana.setEnabled(false);
					btnVegetariana.setEnabled(false);
					btnCalabresa.setEnabled(false);
				}
				else{
					btnRomana.setEnabled(false);
					jogadores--;
				}
				lblTexto.setText("Jogador "+(n++)+" selecione sua pizza");
			}
		});
		
		btnToscana.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.insereUltimo(new Pizza('t'));
				if (jogadores<=1){
					btnMarguerita.setEnabled(false);
					btnPortuguesa.setEnabled(false);
					btnRomana.setEnabled(false);
					btnToscana.setEnabled(false);
					btnVegetariana.setEnabled(false);
					btnCalabresa.setEnabled(false);
				}
				else{
					btnToscana.setEnabled(false);
					jogadores--;
				}
				lblTexto.setText("Jogador "+(n++)+" selecione sua pizza");
			}
		});
		
		btnCalabresa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.insereUltimo(new Pizza('c'));
				if (jogadores<=1){
					btnMarguerita.setEnabled(false);
					btnPortuguesa.setEnabled(false);
					btnRomana.setEnabled(false);
					btnToscana.setEnabled(false);
					btnVegetariana.setEnabled(false);
					btnCalabresa.setEnabled(false);
				}
				else{
					btnCalabresa.setEnabled(false);
					jogadores--;
				}
				lblTexto.setText("Jogador "+(n++)+" selecione sua pizza");
			}
		});
		
		btnPortuguesa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result.insereUltimo(new Pizza('p'));
				if (jogadores<=1){
					btnMarguerita.setEnabled(false);
					btnPortuguesa.setEnabled(false);
					btnRomana.setEnabled(false);
					btnToscana.setEnabled(false);
					btnVegetariana.setEnabled(false);
					btnCalabresa.setEnabled(false);
				}
				else{
					btnPortuguesa.setEnabled(false);
					jogadores--;
				}
				lblTexto.setText("Jogador "+(n++)+" selecione sua pizza");
			}
		});
		
		lblTexto = new Label(shell, SWT.NONE);
		lblTexto.setAlignment(SWT.CENTER);
		lblTexto.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblTexto.setBounds(63, 0, 318, 25);
		lblTexto.setText("Selecione o n\u00BA de jogadores");
		
		combo = new Combo(shell, SWT.NONE);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (combo.getSelectionIndex()>=0){	
					jogadores = Integer.parseInt(combo.getText());
					System.out.println(jogadores);
					lblTexto.setText("Jogador 1, selecione sua pizza");
				}
			}
		});
		combo.setItems(new String[] {"2", "3", "4", "5", "6"});
		combo.setBounds(63, 45, 91, 23);

	}
}
