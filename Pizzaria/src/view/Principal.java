package view;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import entity.Pizza;
import entity.Tabuleiro;
import tad.Lista2;
import util.Msg;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

public class Principal extends Shell {
	private Label label;
	public static Lista2 l2 = new Lista2();
	private static CTabFolder tabFolder;
	private static CTabItem tabItem;
	private int pos = 1, jogador;
	public Tabuleiro t = new Tabuleiro();
	private Label label_1;
	private String log = "SEQU�NCIA DE JOGADAS\n";

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
		setImage(SWTResourceManager.getImage(Principal.class, "/img/PizzaEdited.png"));
		setModified(true);

		Button btnCalabresa = new Button(this, SWT.NONE);
		btnCalabresa.setEnabled(false);
		btnCalabresa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = l2.buscaElmt("Calabresa");
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnCalabresa.setBounds(10, 103, 75, 25);
		btnCalabresa.setText("Calabresa");

		Button btnPortuguesa = new Button(this, SWT.NONE);
		btnPortuguesa.setEnabled(false);
		btnPortuguesa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = l2.buscaElmt("Portuguesa");
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnPortuguesa.setBounds(91, 103, 75, 25);
		btnPortuguesa.setText("Portuguesa");

		Button btnMarguerita = new Button(this, SWT.NONE);
		btnMarguerita.setEnabled(false);
		btnMarguerita.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = l2.buscaElmt("Marguerita");
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnMarguerita.setBounds(10, 41, 75, 25);
		btnMarguerita.setText("Marguerita");

		Button btnVegetariana = new Button(this, SWT.NONE);
		btnVegetariana.setEnabled(false);
		btnVegetariana.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = l2.buscaElmt("Vegetariana");
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnVegetariana.setBounds(91, 41, 75, 25);
		btnVegetariana.setText("Vegetariana");

		Button btnRomana = new Button(this, SWT.NONE);
		btnRomana.setEnabled(false);
		btnRomana.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = l2.buscaElmt("Romana");
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnRomana.setBounds(10, 72, 75, 25);
		btnRomana.setText("Romana");

		Button btnToscana = new Button(this, SWT.NONE);
		btnToscana.setEnabled(false);
		btnToscana.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pizza p = l2.buscaElmt("Toscana");
				String s = p.mostraPizza();
				label.setText(s);
			}
		});
		btnToscana.setBounds(91, 72, 75, 25);
		btnToscana.setText("Toscana");

		label = new Label(this, SWT.NONE);
		label.setBounds(171, 0, 114, 130);

		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);

		MenuItem mntmarquivo = new MenuItem(menu, SWT.CASCADE);
		mntmarquivo.setText("&O Jogo");

		Menu menu_1 = new Menu(mntmarquivo);
		mntmarquivo.setMenu(menu_1);

		MenuItem mntmNovoJogo = new MenuItem(menu_1, SWT.NONE);
		mntmNovoJogo.setText("&Nova Pizzaria");

		MenuItem mntmRegistro = new MenuItem(menu_1, SWT.NONE);
		mntmRegistro.setText("&Hist�rico da Partida");
		mntmRegistro.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Msg.mensagem("Hist�rico da Partida", log, "INFORMACAO", getShell());

			}
		});

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmsair = new MenuItem(menu_1, SWT.NONE);
		mntmsair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sair();
			}
		});
		mntmsair.setText("&Sair");

		MenuItem mntmajuda = new MenuItem(menu, SWT.CASCADE);
		mntmajuda.setText("&Ajuda");

		Menu menu_2 = new Menu(mntmajuda);
		mntmajuda.setMenu(menu_2);

		MenuItem mntmsobre = new MenuItem(menu_2, SWT.NONE);
		mntmsobre.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Msg.mensagem("Sobre",
						"Desenvolvido por:\n\nHuellinton Mota\nRenan Rocha\nVinicius Albini\n\nCurso de Ci�ncia da Computa��o - UNISUL\n2016/02",
						Msg.INFORMACAO, getShell());
			}
		});
		mntmsobre.setText("&Sobre");

		MenuItem mntmajuda_1 = new MenuItem(menu_2, SWT.NONE);
		mntmajuda_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Msg.mensagem("Como Jogar",
						"1. Clique na op��o \"O Jogo\"\n" + "2. Clique em \"Nova Pizzaria\"\n"
								+ "3. Selecione a quantidade de participantes e depois suas respectivas pizzas para jogar\n"
								+ "4. Para iniciar a partida, clique em \"Rolar dado\", dando in�cio as a��es que ser�o indicadas na tela\n"
								+ "5. Para ver o andamento da pizza, clique no bot�o referente a ela e veja seus ingredientes.\n",
						Msg.INFORMACAO, getShell());
			}
		});
		mntmajuda_1.setText("&Instru��es");

		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setBounds(0, 134, 572, 287);
		tabFolder.setSelectionBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		Button btnJogarDado = new Button(this, SWT.NONE);
		btnJogarDado.setToolTipText("");
		btnJogarDado.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnJogarDado.setEnabled(false);
		btnJogarDado.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String winner;
				Random r = new Random();
				pos += r.nextInt(6) + 1;
				l2.movePos(jogador);
				label_1.setText("Jogador " + jogador + " (" + l2.atual.p.getSabor() + ") parou em "
						+ t.jogada(l2.atual.p, pos));
				if (jogador < l2.comprimento())
					jogador++;
				else
					jogador = 1;
				winner = confereVencedor(l2);
				if (!winner.equals("")) {
					log += "\n" + label_1.getText() + " e " + winner;
					Msg.mensagem("Winner, Winner, chicken dinner!", winner, Msg.AVISO, getShell());
				} else {
					log += "\n" + label_1.getText();
				}
			}
		});
		btnJogarDado.setBounds(10, 10, 75, 25);
		btnJogarDado.setText("Jogar dado");

		mntmNovoJogo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				NovoJogo ng = new NovoJogo(getShell(), getStyle());
				l2 = ng.open();
				if (ng.shell.isDisposed()) {
					btnJogarDado.setEnabled(true);
					if (l2.buscaElmt(btnCalabresa.getText()) != null) {
						btnCalabresa.setEnabled(true);
					}
					if (l2.buscaElmt(btnMarguerita.getText()) != null)
						btnMarguerita.setEnabled(true);
					if (l2.buscaElmt(btnPortuguesa.getText()) != null)
						btnPortuguesa.setEnabled(true);
					if (l2.buscaElmt(btnRomana.getText()) != null)
						btnRomana.setEnabled(true);
					if (l2.buscaElmt(btnToscana.getText()) != null)
						btnToscana.setEnabled(true);
					if (l2.buscaElmt(btnVegetariana.getText()) != null)
						btnVegetariana.setEnabled(true);
				}
			}
		});

		label_1 = new Label(this, SWT.NONE);
		label_1.setAlignment(SWT.CENTER);
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_1.setBounds(307, 0, 255, 130);
		label_1.setText("...");
		jogador = 1;

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

	public static void openComposite1() {
		tabItem = jaAberto("Ganhou ingrs");
		if (tabItem == null) {
			tabItem = new CTabItem(tabFolder, SWT.NONE);
			tabItem.setShowClose(true);
			tabItem.setText("Ganhou ingrs");
			Composite composite = new GanheIng(tabFolder, SWT.NONE);
			tabItem.setControl(composite);
			tabFolder.setSelection(tabItem);
		} else {
			tabFolder.setSelection(tabItem);
		}
	}

	public static void closeComposite() {
		tabItem.dispose();
	}

	public static void openComposite2() {
		tabItem = jaAberto("Perdeu ingrs");
		if (tabItem == null) {
			tabItem = new CTabItem(tabFolder, SWT.NONE);
			tabItem.setShowClose(true);
			tabItem.setText("Perdeu ingrs");
			Composite composite = new PercaIng(tabFolder, SWT.NONE);
			tabItem.setControl(composite);
			tabFolder.setSelection(tabItem);
		} else {
			tabFolder.setSelection(tabItem);
		}
	}

	public static void openComposite3() {
		tabItem = jaAberto("Pegou ingrs");
		if (tabItem == null) {
			tabItem = new CTabItem(tabFolder, SWT.NONE);
			tabItem.setShowClose(true);
			tabItem.setText("Pegou ingrs");
			Composite composite = new PegueIngs(tabFolder, SWT.NONE);
			tabItem.setControl(composite);
			tabFolder.setSelection(tabItem);
		} else {
			tabFolder.setSelection(tabItem);
		}
	}

	private String confereVencedor(Lista2 l2) {
		int size = l2.comprimento();
		for (int i = 1; i <= size; i++) {
			l2.movePos(i);
			int j = 1;
			// System.out.println(l2.atual.p.listaIng.retornaNaPos(6).controle);
			while (j < 6 && l2.atual.p.listaIng.retornaNaPos(j).controle == 1) {
				j++;
			}
			if (j > 5) {
				return "Jogador da pizza " + l2.atual.p.getSabor() + " venceu";
			}
		}
		return "";
	}

	private static CTabItem jaAberto(String nome) {
		for (CTabItem item : tabFolder.getItems()) {
			if (item.getText().equals(nome))
				return item;
		}
		return null;
	}

	private void sair() {
		if (Msg.mensagem("Sair", "Deseja sair do jogo?", "SIMNAO", getShell()) == SWT.YES) {
			System.exit(0);
		}

	}
}
