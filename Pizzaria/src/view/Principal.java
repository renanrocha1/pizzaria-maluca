package view;

import java.awt.TextArea;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import entity.Pizza;

import util.Msg;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class Principal extends Shell {
	private Label label;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Principal shell = new Principal(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public Principal(Display display) {
		super(display, SWT.SHELL_TRIM);
		setModified(true);

		Button btnCalabresa = new Button(this, SWT.NONE);
		btnCalabresa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = new Pizza('c');
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnCalabresa.setBounds(10, 103, 75, 25);
		btnCalabresa.setText("Calabresa");

		Button btnPortuguesa = new Button(this, SWT.NONE);
		btnPortuguesa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = new Pizza('p');
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnPortuguesa.setBounds(91, 103, 75, 25);
		btnPortuguesa.setText("Portuguesa");

		Button btnMarguerita = new Button(this, SWT.NONE);
		btnMarguerita.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = new Pizza('m');
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnMarguerita.setBounds(10, 41, 75, 25);
		btnMarguerita.setText("Marguerita");

		Button btnVegetariana = new Button(this, SWT.NONE);
		btnVegetariana.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = new Pizza('v');
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnVegetariana.setBounds(91, 41, 75, 25);
		btnVegetariana.setText("Vegetariana");

		Button btnRomana = new Button(this, SWT.NONE);
		btnRomana.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = new Pizza('r');
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnRomana.setBounds(10, 72, 75, 25);
		btnRomana.setText("Romana");

		Button btnToscana = new Button(this, SWT.NONE);
		btnToscana.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = new Pizza('t');
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnToscana.setBounds(91, 72, 75, 25);
		btnToscana.setText("Toscana");

		label = new Label(this, SWT.NONE);
		label.setBounds(10, 144, 552, 287);

		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);

		MenuItem mntmarquivo = new MenuItem(menu, SWT.CASCADE);
		mntmarquivo.setText("&Arquivo");

		Menu menu_1 = new Menu(mntmarquivo);
		mntmarquivo.setMenu(menu_1);

		MenuItem mntmNovoJogo = new MenuItem(menu_1, SWT.NONE);
		mntmNovoJogo.setText("&Novo Jogo");

		MenuItem mntminstrues = new MenuItem(menu_1, SWT.NONE);
		mntminstrues.setText("&Instru\u00E7\u00F5es");

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmsair = new MenuItem(menu_1, SWT.NONE);
		mntmsair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (Msg.mensagem("Sair", "Deseja sair do jogo?", "SimNao", getShell()) == SWT.YES) {
					System.exit(0);
				}
			}
		});
		mntmsair.setText("&Sair");

		MenuItem mntmajuda = new MenuItem(menu, SWT.CASCADE);
		mntmajuda.setText("&Ajuda");

		Menu menu_2 = new Menu(mntmajuda);
		mntmajuda.setMenu(menu_2);

		MenuItem mntmsobre = new MenuItem(menu_2, SWT.NONE);
		mntmsobre.setText("&Sobre");

		MenuItem mntmajuda_1 = new MenuItem(menu_2, SWT.NONE);
		mntmajuda_1.setText("&Ajuda");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Pizzaria Maluca");
		setSize(588, 480);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
