package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class BookReaderController {
	
	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
	}

	private void createWindow(GeneralWordCounter counter, String title, 
												int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(new GridLayout(2,1));
		Container pane = frame.getContentPane();
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(width*7, height*2);
		frame.setLocation(1000, 200); //temporärt
		
		//////////////////////////////////////
//		wordList = counter.getWordList();
		JList<Map.Entry<String, Integer>> list = new JList<>();
		SortedListModel<Map.Entry<String, Integer>> model = 
											new SortedListModel<>(counter.getWordList());
		list.setModel(model);
//		list.getModel();

//		model.sort(new WordCountComparator());							
//		model.sort((e1, e2) -> e2.getValue() - e1.getValue()); 			//Antal
//		model.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey())); 	//Alfabetisk
		
		JScrollPane scrollPane = new JScrollPane(list);
		pane.add(scrollPane);
		
		//////////////////////////////////////////
		
		JPanel panel = new JPanel();
		JButton alpha = new JButton("Alphabetical");
		JButton freq = new JButton("Frequency");
		panel.add(alpha);
		panel.add(freq);
		
		alpha.addActionListener(event -> {
			model.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
		});
		
		freq.addActionListener(event -> {
			model.sort((e1, e2) -> e2.getValue() - e1.getValue());
		});
		
		JTextField searchField = new JTextField(20);
		panel.add(searchField);
		
		JButton find = new JButton("Find");
		panel.add(find);
		find.addActionListener(event -> {
			String word = searchField.getText().toLowerCase().trim();
			for (int i=0 ; i<model.getSize() ; i++) {
				if (model.getElementAt(i).getKey().equals(word)) {
					list.ensureIndexIsVisible(i);
					list.setSelectedIndex(i);
					return;
				}
			} JOptionPane.showMessageDialog(null, "Word not found", "", JOptionPane.ERROR_MESSAGE);
		});
		
		frame.getRootPane().setDefaultButton(find);
		
		
		pane.add(panel, BorderLayout.SOUTH);
		
		
		
		
		/*
		
		JList<Map.Entry<String, Integer>> list = new JList<>(
				new SortedListModel<Map.Entry<String, Integer>>(counter.getWordList()));
		
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
			
		list.getCellRenderer();
		
		JLabel label = new JLabel();
		JPanel panel = new JPanel();
		frame.add(pane);
		*/
		
	}
	
//	public void searchForWord(String word) {
//		System.out.println(word);
////		
////		for (int i=0 ; i<model.length() ; )
//		return;
//	}
}























