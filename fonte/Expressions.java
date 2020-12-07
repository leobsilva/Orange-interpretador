import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Expressions {
    static public boolean oNumber(String value) {
        boolean oNum = value.matches("-?\\d+(\\.\\d+)?");
        if(oNum){
            return true;
        } else {
            return false;
        }
    }

    static private boolean oOperation(String value) {
        if (value.equals("+")) {
            return true;
        } else if (value.equals("-")) {
            return true;
        } else if (value.equals("*")) {
            return true;
        } else if (value.equals("/")) {
            return true;
        } else {
            return false;
        }
    }

    static public double expressionProcess(String expression, Map<String, Double>variables) {
        String elements[] = expression.split(" ");
        ArrayList<String> elementsList = new ArrayList(Arrays.asList(elements));
        for(int i = 0; i < elementsList.size(); i++) {
            String element = elementsList.get(i);
            if(!oNumber(element) && !oOperation(element)) {
                if(variables.containsKey(element)){
                    Double value = variables.get(element);
                    String stringValue = Double.toString(value);
                    elementsList.set(i,stringValue);
                } else {
                    System.out.println("A variavel nao existe!");
                    return 0;
                }
            }
        }
        for(int j = 0; j < elementsList.size(); j++) {
            String element = elementsList.get(j);
            if(element.equals("*") || element.equals("/")){
                double antValue = Double.parseDouble(elementsList.get(j-1));
                double proxValue = Double.parseDouble(elementsList.get(j+1));
                double result = 0;
                if(element.equals("/")) {
                    result = antValue/proxValue;
                } else {
                    result = antValue*proxValue;
                }
                elementsList.remove(j-1);
                elementsList.remove(j-1);
                String resultValue = Double.toString(result);

                elementsList.set(j-1, resultValue);
                j = 0; 
            }
        }
        for(int j = 0; j < elementsList.size(); j++) {
            String element = elementsList.get(j);
            if(element.equals("+") || element.equals("-")){
                double antValue = Double.parseDouble(elementsList.get(j-1));
                double proxValue = Double.parseDouble(elementsList.get(j+1));
                double result = 0;
                if(element.equals("+")) {
                    result = antValue+proxValue;
                } else {
                    result = antValue-proxValue;
                }
                elementsList.remove(j-1);
                elementsList.remove(j-1);
                String resultValue = Double.toString(result);

                elementsList.set(j-1, resultValue);
                j = 0; 
            }
        }
        if(elementsList.size() != 1) {
            System.out.println("Erro inesperado");
            return 0;
        } else {
            double firstElement = Double.parseDouble(elementsList.get(0));
            return firstElement;
        }
    }
}