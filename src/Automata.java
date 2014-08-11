
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * El lenguaje que acepta el autómata es el siguiente
 * L = { a^n b^n | n => 0 }
 * @author Edilson
 */
public class Automata {
    
    public static final String STATE1 = "S1";
    public static final String STATE2 = "S2";
    
    private DirectedSparseGraph<String, String> stateDiagram;
    private Stack<String> stack;
    
    public Automata() {
        this.stateDiagram = new DirectedSparseGraph();
        this.stack = new Stack();
        addLanguage();
    }
    
    private void addLanguage() {
        //States
        this.stateDiagram.addVertex(STATE1);
        this.stateDiagram.addVertex(STATE2);
        
        //Transitions
        this.stateDiagram.addEdge("b1", STATE1, STATE2);
        this.stateDiagram.addEdge("a", STATE1, STATE1);
        this.stateDiagram.addEdge("b2", STATE2, STATE2);
    }
    
    public boolean isFinalState(String state) {
        return state.equals(STATE1) || state.equals(STATE2);
    }
    
    public DirectedSparseGraph getStateDiagram() {
        return this.stateDiagram;
    }
    
    public boolean isValidInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'b') {
                if (input.charAt(i) == 'a') {
                    this.stack.push("a");
                } else {
                    try {
                        if (!this.stack.pop().equals("a")) {
                            return false;
                        }
                    } catch (EmptyStackException ex) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
}
