import java.io.Serializable;
import java.util.List;

public class Resultados implements Serializable{
    private List<String> resultados;

    public Resultados(List<String> resultados) {
        this.resultados = resultados;
    }

    public void adicionaResultado(String resultado){
        resultados.add(resultado);
    }

    public List<String> getResultados() {
        return resultados;
    }

    public void setResultados(List<String> resultados) {
        this.resultados = resultados;
    }

    @Override
    public String toString() {
        return "Resultados [" + resultados + "]";
    }    
}
