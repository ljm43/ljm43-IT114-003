package Module5.Part5;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.*;
import java.awt.event.*;


// Step 1: Create a new class extending JFrame
public class ChatClientGUI extends JFrame {
    // UI Components for Connection Panel
    private JPanel connectionPanel;
    private JTextField usernameField;
    private JTextField hostField;
    private JTextField portField;
    private JButton connectButton;
    
    // UI Components for Chat Panel
    private JPanel chatPanel;
    private JTextPane chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private JList<String> userList;
    private DefaultListModel<String> userListModel;
    
    // Basic constructor
    public ChatClientGUI() {
        setTitle("Chat Client");
        setLayout(new CardLayout());
        initializeUI();
    }
    
    private void initializeUI() {
        // Create connection panel
        createConnectionPanel();
        
        // Create chat panel
        createChatPanel();
        
        // Add both panels to frame
        add(connectionPanel, "connect");
        add(chatPanel, "chat");
        
        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Show connection panel first
        ((CardLayout)getContentPane().getLayout()).show(getContentPane(), "connect");
    }
    
    private void createConnectionPanel() {
        connectionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Username field
        usernameField = new JTextField(20);
        // Prevent spaces in username
        usernameField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    e.consume();
                }
            }
        });
        
        // Add components to panel
        gbc.gridx = 0; gbc.gridy = 0;
        connectionPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        connectionPanel.add(usernameField, gbc);
        
        // Host field
        hostField = new JTextField("localhost", 20);
        gbc.gridx = 0; gbc.gridy = 1;
        connectionPanel.add(new JLabel("Host:"), gbc);
        gbc.gridx = 1;
        connectionPanel.add(hostField, gbc);
        
        // Port field
        portField = new JTextField("3000", 20);
        gbc.gridx = 0; gbc.gridy = 2;
        connectionPanel.add(new JLabel("Port:"), gbc);
        gbc.gridx = 1;
        connectionPanel.add(portField, gbc);
        
        // Connect button
        connectButton = new JButton("Connect");
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        connectionPanel.add(connectButton, gbc);
    }
    
    private void createChatPanel() {
        chatPanel = new JPanel(new BorderLayout());
        
        // User list panel (LEFT)
        userListModel = new DefaultListModel<>();
        userList = new JList<>(userListModel);
        chatPanel.add(new JScrollPane(userList), BorderLayout.WEST);
        
        // Chat area (CENTER)
        chatArea = new JTextPane();
        chatArea.setEditable(false);
        chatPanel.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        
        // Message input panel (BOTTOM)
        JPanel inputPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        sendButton = new JButton("Send");
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        chatPanel.add(inputPanel, BorderLayout.SOUTH);
    }
    public JButton getConnectButton() {
        return connectButton;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getHostField() {
        return hostField;
    }

    public JTextField getPortField() {
        return portField;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public JTextField getMessageField() {
        return messageField;
    }

    public DefaultListModel<String> getUserListModel() {
        return userListModel;
    }

    // Method to switch to chat panel
    public void switchToChat() {
        ((CardLayout)getContentPane().getLayout()).show(getContentPane(), "chat");
    }

    // Method to append text to chat area
    public void appendToChatArea(String message) {
        SwingUtilities.invokeLater(() -> {
            try {
                Document doc = chatArea.getDocument();
                doc.insertString(doc.getLength(), message + "\n", null);
                // Auto-scroll to bottom
                chatArea.setCaretPosition(doc.getLength());
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChatClientGUI().setVisible(true);
        });
    }
}