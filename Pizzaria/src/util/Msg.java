	package util;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Msg {
	
	public static final String AVISO="AVISO", PERGUNTA="PERGUNTA", ERRO="ERRO",INFORMACAO="INFORMACAO", SIMNAO="SIMNAO", SIMNAOCANCELA="SIMNAOCANCELA";
	
	public static int mensagem(String titulo, String texto, String conf, Shell shell){
		
		MessageBox m;
		
		switch (conf) {
		case "AVISO":
			m = new MessageBox(shell, SWT.ICON_WARNING);
			break;
			
		case "PERGUNTA":
			m = new MessageBox(shell, SWT.ICON_QUESTION);
			break;
			
		case "ERRO":
			m = new MessageBox(shell, SWT.ICON_ERROR);
			break;
			
		case "INFORMACAO":
			m = new MessageBox(shell, SWT.ICON_INFORMATION);
			break;
			
		case "SIMNAO":
			m = new MessageBox(shell, SWT.YES|SWT.NO|SWT.ICON_QUESTION);
			break;
			
		case "SIMNAOCANCELA":
			m = new MessageBox(shell, SWT.YES|SWT.NO|SWT.CANCEL|SWT.ICON_QUESTION);
			break;
			

		default:
			m = new MessageBox(shell, SWT.None);
			break;
		}
		
		m.setText(titulo);
		m.setMessage(texto);
		return m.open();
		
		
		
	}
	
}
