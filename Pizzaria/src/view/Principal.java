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
				Pizza p = l2.buscaElmt("Calabresa");
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
				Pizza p = l2.buscaElmt("Portuguesa");
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
				Pizza p = l2.buscaElmt("Marguerita");
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
				Pizza p = l2.buscaElmt("Vegetariana");
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
				Pizza p = l2.buscaElmt("Romana");
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
		mntmarquivo.setText("&Arquivo");

		Menu menu_1 = new Menu(mntmarquivo);
		mntmarquivo.setMenu(menu_1);

		MenuItem mntmNovoJogo = new MenuItem(menu_1, SWT.NONE);
		mntmNovoJogo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				NovoJogo ng = new NovoJogo(getShell(), getStyle());
				l2 = ng.open();
			}
		});
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
		mntmsobre.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Msg.mensagem("Sobre", "Pizzaria Maluca\nDesenvolvido por Huellinton Mota, Renan Rocha e Vinicius Albini", Msg.INFORMACAO, getShell());
			}
		});
		mntmsobre.setText("&Sobre");

		MenuItem mntmajuda_1 = new MenuItem(menu_2, SWT.NONE);
		mntmajuda_1.setText("&Ajuda");
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setBounds(0, 134, 572, 287);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		Button btnJogarDado = new Button(this, SWT.NONE);
		btnJogarDado.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String winner;
				Random r = new Random();
				pos+= r.nextInt(6)+1;
				l2.movePos(jogador);
				label_1.setText("Jogador "+jogador+" ("+l2.atual.p.getSabor()+") parou em "+t.jogada(l2.atual.p, pos));
				if(jogador<l2.comprimento())
					jogador++;
				else
					jogador = 1;
				winner = confereVencedor(l2);
				if (!winner.equals("")){
					Msg.mensagem("Winner, Winner, chicken dinner!", winner, Msg.AVISO, getShell());
				}
			}
		});
		btnJogarDado.setBounds(10, 10, 75, 25);
		btnJogarDado.setText("Jogar dado");
		
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
	
	public static void openComposite1(){
		tabItem = jaAberto("Ganhou ingrs");
		if(tabItem==null){
			tabItem = new CTabItem(tabFolder, SWT.NONE);
			tabItem.setShowClose(true);
			tabItem.setText("Ganhou ingrs");
			Composite composite = new GanheIng(tabFolder, SWT.NONE);
			tabItem.setControl(composite);
			tabFolder.setSelection(tabItem);
		}else{
			tabFolder.setSelection(tabItem);
		}
	}
	
	public static void closeComposite(){
		tabItem.dispose();
	}
	
	public static void openComposite2(){
		tabItem = jaAberto("Perdeu ingrs");
		if(tabItem==null){
			tabItem = new CTabItem(tabFolder, SWT.NONE);
			tabItem.setShowClose(true);
			tabItem.setText("Perdeu ingrs");
			Composite composite = new PercaIng(tabFolder, SWT.NONE);
			tabItem.setControl(composite);
			tabFolder.setSelection(tabItem);
		}else{
			tabFolder.setSelection(tabItem);
		}
	}
	
	public static void openComposite3(){
		tabItem = jaAberto("Pegou ingrs");
		if(tabItem==null){
			tabItem = new CTabItem(tabFolder, SWT.NONE);
			tabItem.setShowClose(true);
			tabItem.setText("Pegou ingrs");
			Composite composite = new PegueIngs(tabFolder, SWT.NONE);
			tabItem.setControl(composite);
			tabFolder.setSelection(tabItem);
		}else{
			tabFolder.setSelection(tabItem);
		}
	}
	
	private String confereVencedor(Lista2 l2){
		int size = l2.comprimento();
		for(int i=1;i<=size;i++){
			l2.movePos(i);
			int j=1;
			//System.out.println(l2.atual.p.listaIng.retornaNaPos(6).controle);
			while(j<6 && l2.atual.p.listaIng.retornaNaPos(j).controle==1){
				j++;
			}
			if (j>=5){
				return "Jogador da pizza "+l2.atual.p.getSabor()+" venceu";
			}
		}
		return "";
	}
	
	private static CTabItem jaAberto(String nome){
		for (CTabItem item : tabFolder.getItems()) {
			if(item.getText().equals(nome))
				return item;
		}
		return null;
	}
}
