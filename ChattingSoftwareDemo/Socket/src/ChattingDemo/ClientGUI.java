package ChattingDemo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class ClientGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField inputName;
    private JLabel lblIp;
    private JTextField inputIP;
    private JLabel lblPort;
    private JTextField inputPort;
    private JPanel panel;
    private JButton btnNewButton;
    private JPanel panel_1;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;

    // ________________________________________
    Socket socket = null;
    String ip = "";
    int port = 0;
    String name = "";
    BufferedReader bf = null;
    DataOutputStream os = null;

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    ClientGUI frame = new ClientGUI();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public ClientGUI() {
	initComponents();
    }

    private void initComponents() {
	setTitle("CLIENT");
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 822, 716);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	contentPane.add(getLblNewLabel());
	contentPane.add(getInputName());
	contentPane.add(getLblIp());
	contentPane.add(getInputIP());
	contentPane.add(getLblPort());
	contentPane.add(getInputPort());
	contentPane.add(getPanel_1());
	contentPane.add(getBtnNewButton());
	contentPane.add(getPanel_1_1());
	contentPane.add(getLblNewLabel_2());
    }

    public JLabel getLblNewLabel() {
	if (lblNewLabel == null) {
	    lblNewLabel = new JLabel("Name");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
	    lblNewLabel.setBounds(23, 13, 131, 51);
	}
	return lblNewLabel;
    }

    public JTextField getInputName() {
	if (inputName == null) {
	    inputName = new JTextField();
	    inputName.setBounds(90, 26, 131, 31);
	    inputName.setColumns(10);
	}
	return inputName;
    }

    public JLabel getLblIp() {
	if (lblIp == null) {
	    lblIp = new JLabel("IP ");
	    lblIp.setFont(new Font("Tahoma", Font.BOLD, 21));
	    lblIp.setBounds(257, 13, 131, 51);
	}
	return lblIp;
    }

    public JTextField getInputIP() {
	if (inputIP == null) {
	    inputIP = new JTextField();
	    inputIP.setColumns(10);
	    inputIP.setBounds(287, 26, 131, 31);
	}
	return inputIP;
    }

    public JLabel getLblPort() {
	if (lblPort == null) {
	    lblPort = new JLabel("Port");
	    lblPort.setFont(new Font("Tahoma", Font.BOLD, 21));
	    lblPort.setBounds(460, 13, 131, 51);
	}
	return lblPort;
    }

    public JTextField getInputPort() {
	if (inputPort == null) {
	    inputPort = new JTextField();
	    inputPort.setColumns(10);
	    inputPort.setBounds(511, 26, 131, 31);
	}
	return inputPort;
    }

    public JPanel getPanel_1() {
	if (panel == null) {
	    panel = new JPanel();
	    panel.setBackground(Color.LIGHT_GRAY);
	    panel.setBorder(new MatteBorder(1, 1, 1, 1, Color.RED));
	    panel.setBounds(12, 72, 792, 554);
	    panel.setLayout(new GridLayout(1, 1, 1, 1));
	    panel.add(getLblNewLabel_1());
	}
	return panel;
    }

    public JButton getBtnNewButton() {
	if (btnNewButton == null) {
	    btnNewButton = new JButton("Connect");
	    btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    try {
			// Lấy dữ liệu bao gồm name,ip,port
			ip = inputIP.getText();
			port = Integer.parseInt(inputPort.getText());
			name = inputName.getText();

			// Tạo một socket bằng ip và port ở trên
			socket = new Socket(ip, port);

			// Validation__________________________
			if (name.isEmpty()) throw new Exception("Empty Name");
			if (socket == null) throw new Exception("Null Socket");

			// Tạo một ChatPanel
			panel.removeAll();
			ChatPanel chatPanel = new ChatPanel(socket, name, "Manager");
			panel.add(chatPanel);
			panel.updateUI();

			// Cho ChatPanel này "chạy" để kiểm tra tin nhắn đến và đi
			Thread t = new Thread(chatPanel);
			t.start();

			// chatPanel.os.write(13);
			// chatPanel.os.write(10);
			// chatPanel.os.flush();

			// Thông báo chạy thành công
			JOptionPane.showMessageDialog(contentPane, "Connect success", "Connected",
			                JOptionPane.INFORMATION_MESSAGE);
		    } catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane,
			                "Error while connect, please check details try again!\nDetails: " + e,
			                "Error while connect", JOptionPane.ERROR_MESSAGE);
		    }
		}
	    });
	    btnNewButton.setBackground(Color.ORANGE);
	    btnNewButton.setForeground(Color.CYAN);
	    btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btnNewButton.setBounds(658, 13, 146, 51);
	}
	return btnNewButton;
    }

    public JPanel getPanel_1_1() {
	if (panel_1 == null) {
	    panel_1 = new JPanel();
	    panel_1.setBorder(new LineBorder(Color.BLACK, 2));
	    panel_1.setBounds(12, 13, 792, 51);
	}
	return panel_1;
    }

    public JLabel getLblNewLabel_1() {
	if (lblNewLabel_1 == null) {
	    lblNewLabel_1 = new JLabel("Type infomation above to connect");
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
	    lblNewLabel_1.setForeground(Color.RED);
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}
	return lblNewLabel_1;
    }

    public JLabel getLblNewLabel_2() {
	if (lblNewLabel_2 == null) {
	    lblNewLabel_2 = new JLabel("DoanDucTin_SE1403");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
	    lblNewLabel_2.setBounds(658, 639, 146, 32);
	}
	return lblNewLabel_2;
    }
}
