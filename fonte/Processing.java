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
            // declarando uma variavel
            if("seed".equals(tokens[0])) {
                String variableName = tokens[1];
                String lineExpression[] = line.split(" ", 4); //apenas 4 agora para fazer uma operacao simples, como: seed[0] soma[1] =[2] 3+2[3]
                double variableValue = Expressions.expressionProcess(lineExpression[3], this.variables);
                this.variables.put(variableName, variableValue);//insere o nome(key) relacionado ao valor no banco de variáveis
            } else if("out".equals(tokens[0])) {
                String variableName = tokens[1];
                // System.out.println("got out");
                if (variableName.startsWith("\"")){
                    String content = line.replace("out \"", "");
                    content = content.replace("\"", "");
                    content = content.replace("\\n", "\n");
                    System.out.print(content);
                }else{
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
