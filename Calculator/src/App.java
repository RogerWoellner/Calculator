import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static float n1, n2, res;
    public static int op;
    public static boolean menu = true;
    public static Scanner in = new Scanner(System.in);
    public static Resultados resultados = new Resultados(new ArrayList<String>());
    public static String localArquivo = "src/log/log.ser";
    public static void main(String[] args) throws Exception {
        try {
            File arquivo = new File(localArquivo);
            if(arquivo.exists() && arquivo.isFile()){
            ObjectInputStream ler = new ObjectInputStream(new FileInputStream(localArquivo));
            resultados = (Resultados) ler.readObject();
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo");
        }
        
        do{
            System.out.println("Escolha uma das opções: \n" +
                "1 - Somar\n" +
                "2 - Subtrair\n" +
                "3 - Dividir\n" +
                "4 - Multiplicar\n" +
                "9 - Ver Resultados\n" +
                "0 - Sair"        
            );
            op = in.nextInt();
            switch (op) {
                case 1:
                    solicitarNumeros();
                    res = Calculadora.somar(n1, n2); 
                    salvarResultado("soma");
                break;

                case 2:
                    solicitarNumeros();
                    res = Calculadora.subtrair(n1, n2);    
                    salvarResultado("subtração");
                break;

                case 3:
                    solicitarNumeros();
                    res = Calculadora.dividir(n1, n2);    
                    salvarResultado("divisão"); 
                break;

                case 4:
                    solicitarNumeros();
                    res = Calculadora.multiplicar(n1, n2);    
                    salvarResultado("multiplicação");  
                break;
            
                case 9:
                    System.out.println(resultados);
                break;
            
                case 0:
                    menu = false;
                    try {
                        File arquivoSalvar = new File(localArquivo);
                        arquivoSalvar.getParentFile().mkdirs();

                        FileOutputStream file = new FileOutputStream (localArquivo);
                        ObjectOutputStream salvar = new ObjectOutputStream(file);
                        salvar.writeObject(resultados);
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar o objeto");
                    }
                    
                break;
            }
        }while(menu);
    }

    public static void solicitarNumeros() {
        System.out.println("Digite um número");
        n1 = in.nextFloat();
        System.out.println("Digite outro número");
        n2 = in.nextFloat();        
    }

    public static void salvarResultado(String operador) {
        String resultado = "A Operação de " + operador + " entre os números " + n1 + " e " + n2 + " é " + res;

        System.out.println(resultado);
        resultados.adicionaResultado(resultado);
    }

}
