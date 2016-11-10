package view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class NovoJogo extends Dialog {

	protected Object result;
	protected Shell shell;
	private Label lblTexto;

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
	public Object open() {
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
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setText("Calabresa");
		btnNewButton.setBounds(126, 156, 75, 25);
		
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
		
		lblTexto = new Label(shell, SWT.NONE);
		lblTexto.setAlignment(SWT.CENTER);
		lblTexto.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblTexto.setBounds(63, 0, 318, 25);
		lblTexto.setText("Selecione o n\u00BA de jogadores");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				lblTexto.setText("Jogador 1, selecione sua pizza");
			}
		});
		combo.setItems(new String[] {"2", "3", "4", "5", "6"});
		combo.setBounds(63, 45, 91, 23);

	}
}
