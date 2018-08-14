
import java.util.Iterator;
import java.util.List;

public class GeradorObservacao { 

	// Nota: Poderia ser isolado em um arquivo de constantes.
	private final String PONTO = ".";
	private final String SEPARADOR_E = " e ";
	private final String SEPARADOR_VIRGULA = ", ";
	private final String MSG_FATURA_SINGULAR = "Fatura da nota fiscal de simples remessa: ";
	private final String MSG_FATURA_PLURAL = "Fatura das notas fiscais de simples remessa: ";

	// O método agora é responsável pela geração da String Observação.
	public String geraObservacao(List<Integer> lista) {
		StringBuilder texto = new StringBuilder();
		if (lista != null && !lista.isEmpty()) {
			if (lista.size() >= 2) {
				texto.append(MSG_FATURA_PLURAL);
			} else {
				texto.append(MSG_FATURA_SINGULAR);
			}
			String codigos = this.retornaCodigos(lista);
			texto.append(codigos).append(PONTO);
			return texto.toString();
		}
		return "";
	}

	// Foram removidas as concatenações de início e fim. O metódo agora reflete a sua assinatura.
	private String retornaCodigos(List<Integer> lista) {
		StringBuilder codigos = new StringBuilder();
		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer codigo = iterator.next();
			if (codigos.length() == 0) {
				codigos.append(EMPTY);
			} else if (iterator.hasNext()) {
				codigos.append(VIRGULA);
			} else {
				codigos.append(E);
			}
			codigos.append(codigo);
		}
		return codigos;
	}
}