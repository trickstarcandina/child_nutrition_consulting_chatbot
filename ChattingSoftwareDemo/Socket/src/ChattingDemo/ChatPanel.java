package ChattingDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatPanel extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private JButton btnNewButton;
    private JLabel lblNewLabel;
    private JLabel lblHistory;
    private JTextArea textArea_1;
    // ______________________________
    Socket socket = null;
    String sender;
    String receiver;
    BufferedReader bf = null;
    DataOutputStream os = null;

    // Một phương thức run được implement từ lớp Runable với mục đích kiểm tra tin
    // nhắn đến
    @Override
    public void run() {
	while (true) {
	    try {
		if (socket != null) {
		    String msg = "";
		    while ((msg = bf.readLine()) != null) {
			// Nếu có tin nhắn đến thì ghi vào lịch sử
			textArea_1.append(msg + "\n");
		    }
		}
	    } catch (Exception e) {
		// Do not change this because it spawn try-catch many time while running thread!
	    }
	}
    }

    public ChatPanel(Socket s, String sender, String receiver) {
	initComponents();
	socket = s;
	this.sender = sender;
	this.receiver = receiver;
	try {

	    GroupLayout groupLayout = new GroupLayout(this);
	    groupLayout.setHorizontalGroup(
	                    groupLayout.createParallelGroup(Alignment.LEADING)
	                                    .addGroup(groupLayout.createSequentialGroup().addGap(332)
	                                                    .addComponent(getLblHistory(), GroupLayout.DEFAULT_SIZE, 67,
	                                                                    Short.MAX_VALUE)
	                                                    .addGap(339))
	                                    .addGroup(groupLayout
	                                                    .createSequentialGroup().addGap(12)
	                                                    .addComponent(getTextArea_1(), GroupLayout.DEFAULT_SIZE, 714,
	                                                                    Short.MAX_VALUE)
	                                                    .addGap(12))
	                                    .addGroup(groupLayout.createSequentialGroup().addGap(12).addGroup(groupLayout
	                                                    .createParallelGroup(Alignment.LEADING)
	                                                    .addGroup(groupLayout.createSequentialGroup().addGap(168)
	                                                                    .addComponent(getLblNewLabel(),
	                                                                                    GroupLayout.DEFAULT_SIZE, 230,
	                                                                                    Short.MAX_VALUE)
	                                                                    .addGap(147))
	                                                    .addComponent(getTextArea(), GroupLayout.DEFAULT_SIZE, 545,
	                                                                    Short.MAX_VALUE))
	                                                    .addGap(12).addComponent(getBtnNewButton(), GroupLayout.DEFAULT_SIZE,
	                                                                    157, Short.MAX_VALUE)
	                                                    .addGap(12)));
	    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
	                    .createSequentialGroup().addComponent(getLblHistory(), GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
	                    .addGap(6).addComponent(getTextArea_1(), GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE).addGap(1)
	                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	                                    .addGroup(groupLayout.createSequentialGroup()
	                                                    .addComponent(getLblNewLabel(), GroupLayout.PREFERRED_SIZE, 27,
	                                                                    GroupLayout.PREFERRED_SIZE)
	                                                    .addComponent(getTextArea(), GroupLayout.DEFAULT_SIZE, 154,
	                                                                    Short.MAX_VALUE))
	                                    .addGroup(groupLayout.createSequentialGroup().addGap(26).addComponent(
	                                                    getBtnNewButton(), GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
	                    .addGap(13)));
	    bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    os = new DataOutputStream(socket.getOutputStream());

	    setLayout(groupLayout);
	    (new Thread(this)).start();
	} catch (Exception e) {
	    System.out.println("Error while create Main Panel");
	}

    }

    private void initComponents() {
    }

    public JTextArea getTextArea() {
	if (textArea == null) {
	    textArea = new JTextArea();
	    textArea.setFont(new Font("Arial", Font.PLAIN, 26));
	}
	return textArea;
    }

    public JButton getBtnNewButton() {
	if (btnNewButton == null) {
	    btnNewButton = new JButton("SEND");
	    btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    if (textArea.getText().isEmpty()) return;
		    try {
			os.writeBytes(sender + ": " + textArea.getText() + "\n");
			os.flush();
			textArea_1.append(sender + ": " + textArea.getText() + "\n");
			textArea.setText("");
		    } catch (Exception e) {
			System.out.println("Error while sendding messeger");
		    }
		}
	    });
	    btnNewButton.setBackground(Color.CYAN);
	    btnNewButton.setForeground(Color.RED);
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 26));
	}
	return btnNewButton;
    }

    public JLabel getLblNewLabel() {
	if (lblNewLabel == null) {
	    lblNewLabel = new JLabel("Type the mess here to send");
	    lblNewLabel.setForeground(Color.GRAY);
	    lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
	}
	return lblNewLabel;
    }

    public JLabel getLblHistory() {
	if (lblHistory == null) {
	    lblHistory = new JLabel("History");
	    lblHistory.setForeground(Color.GRAY);
	    lblHistory.setFont(new Font("Tahoma", Font.ITALIC, 18));
	}
	return lblHistory;
    }

    public JTextArea getTextArea_1() {
	if (textArea_1 == null) {
	    textArea_1 = new JTextArea();
	    textArea_1.setFont(new Font("Arial", Font.PLAIN, 30));
	}
	return textArea_1;
    }
}
