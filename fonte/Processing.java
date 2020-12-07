import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Processing {
    private String lines[];
    private Map<String, Double> variables;
    private int lineQnt;

    public Processing(String lineVetor[], int qntLine) {
        this.lineQnt = qntLine;
        this.lines = lineVetor;
        this.variables = new HashMap<String, Double>();
    }
    public void Process() {
        int lineCount = this.lineQnt;
        for(int i = 0; i < lineCount; i++){
            String line = this.lines[i];
            String tokens[] = line.split(" ");
            System.out.println("got here 1");
            // declarando uma variavel
            if("seed".equals(tokens[0])) {
                String variableName = tokens[1];
                String lineExpression[] = line.split(" ", 4); //apenas 4 agora para fazer uma operacao simples, como: seed[0] soma[1] =[2] 3+2[3]
                System.out.println("got seed");
                double variableValue = Expressions.expressionProcess(lineExpression[3], this.variables);
                this.variables.put(variableName, variableValue);//insere o nome(key) relacionado ao valor no banco de variáveis
            } else if("out".equals(tokens[0])) {
                String variableName = tokens[1];
                System.out.println("got out");
                if (variableName.startsWith("\"")){// se o conteudo do nomeVariavel comecar com aspas
                    String content = line.replace("print \"", "");
                    content = content.replace("\"", ""); // troque para espaço vazio
                    content = content.replace("\\n", "\n"); // troque para espaço vazio
                    System.out.print(content);
                }else{
                    // busca o valor da variavel do dicionario
                    if(this.variables.containsKey(variableName)){// se existe a variavel no hashmap
                        double value = this.variables.get(variableName);//obtenha o nome
                        System.out.println(value); // printa o valor obtido
                    }else {
                        System.out.println("Variavel "+variableName+" não definida");
                    }
                }
            } else if("in".equals(tokens[0])) {
                String variableName = tokens[1];

                Scanner teclado = new  Scanner(System.in);

                System.out.println("got in");
                
                if(this.variables.containsKey(variableName)){// se existe a variavel no hashmap
                    double typedValue = teclado.nextDouble();
                    this.variables.put(variableName, typedValue);
                }else {
                    System.out.println("Variavel "+variableName+" não definida");
                }
            }
        }
    }
}
//prox: criar condicionais das variaveis
// n poder escrever so out sem variavel seguinte


//ideia: fazer uma  variavel para numeros e outro para letras
