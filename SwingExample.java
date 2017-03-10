import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
 
public class SwingExample implements Runnable {

    @Override
    public void run() {
        // Create the window
        JFrame f = new JFrame("Взвешивание продуктов");
        // Sets the behavior for when the window is closed
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Add a layout manager so that the button is not placed on top of the label
        f.setLayout(new FlowLayout());
        BufferedReader abc = null;
		try {
			abc = new BufferedReader(new FileReader("c:\\Users\\admin\\workspace\\Test\\src\\goods prices.txt")); //?
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
        List<String> goodsList = new ArrayList<String>();
        List<Float> pricesList = new ArrayList<Float>();
        String line = null;
		try {
			line = abc.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        while(line != null) {
            goodsList.add(line);
            try {
				line = abc.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				try {
					abc.close();
				} catch (IOException e2) {
					e2.printStackTrace();
					return;
				}
				return;
			}
            pricesList.add(Float.parseFloat(line));
            try {
				line = abc.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				try {
					abc.close();
				} catch (IOException e2) {
					e2.printStackTrace();
					return;
				}
				return;
			}
        }
        try {
			abc.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        String[] goods = {};
        JList<String> Goods = new JList<String>(goodsList.toArray(goods)); //?
        Goods.setSelectedIndex(0);
        f.add(Goods);
        f.add(new JLabel("Вес, г"));
        JTextField Weight = new JTextField("0", 4);
        f.add(Weight);
        JButton btn = new JButton("Рассчитать");
        f.add(btn);
        f.add(new JLabel("Стомость: "));
        JLabel priceLabel = new JLabel("0.0");
        f.add(priceLabel);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	float p = pricesList.get(Goods.getSelectedIndex()) * Float.parseFloat(Weight.getText()) / 1000.0f;
            	priceLabel.setText(Float.toString(p));
            	f.pack();
            }          
         });
        // Arrange the components inside the window
        f.pack();
        // By default, the window is not visible. Make it visible.
        f.setVisible(true);
    }

}