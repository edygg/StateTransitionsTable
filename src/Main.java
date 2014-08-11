
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Edilson
 */
public class Main {
    
    public static void main(String args[]) {
        Automata aut = new Automata();
        VisualizationImageServer vs = new VisualizationImageServer(
                new CircleLayout(aut.getStateDiagram()), 
                new Dimension(300, 300)
        );
        vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        
        JFrame frame = new JFrame();
        frame.getContentPane().add(vs);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        String input = JOptionPane.showInputDialog(frame, "Input string: ");
        if (aut.isValidInput(input)) {
            JOptionPane.showMessageDialog(frame, "It\'s valid", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "It\'s invalid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
