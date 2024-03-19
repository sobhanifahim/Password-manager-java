import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.security.SecureRandom;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Sobhani
 */
public class Userend extends javax.swing.JFrame {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/password_manager"; // Database URL - Specifies the location and details of the MySQL database
    private static final String USERNAME = "root"; // Database username - The username used to authenticate and connect to the database
    private static final String PASSWORD = "08420"; // Database password - The password used to authenticate and connect to the database
    // Encryption algorithm used for securing data
    private static final String ENCRYPTION_ALGORITHM = "AES";
    // Encryption key used for the AES algorithm (16 bytes for AES-128)
    private static final String ENCRYPTION_KEY = "Your16ByteKey123"; // Replace with your key
    
    
    private static Connection connection;
    /**
     * Creates new form Userend
     */
    private final int userId; //variable declaration
    private boolean showPasswords = false; //set show password to false
    public Userend(int userId) {
         // Initialize components of the user interface
        initComponents();  // Initialize components of the user interface
        connectToDatabase();
        this.userId = userId;  // Set the userId attribute of the current instance
        jComboBox1.removeAllItems(); // Clear existing items and populate a JComboBox with categories
        jComboBox1.addItem("Web");
        jComboBox1.addItem("Game");
        jComboBox1.addItem("Desktop App");
        displayUserPasswords(); // Display user passwords based on the selected category in the JComboBox

    }
    private void connectToDatabase() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database!");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    private Userend() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
 // Encrypts the given plain text using the specified encryption algorithm and key   
private String encrypt(String plainText) {
    try {
        Key key = generateKey();// Generate a key for encryption
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);// Create a Cipher instance using the specified encryption algorithm
        cipher.init(Cipher.ENCRYPT_MODE, key);// Initialize the cipher for encryption with the generated key
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());// Perform encryption on the input plain text
        return Base64.getEncoder().encodeToString(encryptedBytes); // Encode the encrypted bytes to a Base64 string for easier storage and transmission
    } catch (Exception e) {// Handle any exceptions that may occur during the encryption process
        e.printStackTrace();
        return null;// Return null in case of an error
    }
}
// Decrypts the given encrypted text using the specified encryption algorithm and key
private String decrypt(String encryptedText) {
    try {
        
        Key key = generateKey(); // Generate a key for decryption
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM); // Create a Cipher instance using the specified encryption algorithm
        cipher.init(Cipher.DECRYPT_MODE, key);// Initialize the cipher for decryption with the generated key
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);        // Decode the Base64-encoded encrypted text to obtain the encrypted bytes
        System.out.println("Encrypted Bytes: " + Arrays.toString(encryptedBytes));
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes); // Perform decryption on the encrypted bytes
        System.out.println("Generated Key (Decrypt): " + Arrays.toString(key.getEncoded()));
        System.out.println("Decrypted Bytes: " + Arrays.toString(decryptedBytes));
        return new String(decryptedBytes);// Convert the decrypted bytes to a string and return
    } catch (Exception e) {
        e.printStackTrace(); // Print the exception details
        return null;
    }
}
   private Key generateKey() {
    try {
        // Use a fixed key size of 16 bytes for AES-128
        byte[] keyData = Arrays.copyOf(ENCRYPTION_KEY.getBytes("UTF-8"), 16);
        return new SecretKeySpec(keyData, ENCRYPTION_ALGORITHM);
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        return null;
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Your Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 33, 0, 275);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_password.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 180, 6, 0);
        jPanel2.add(jLabel7, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("     Name of web/game/destop app :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("    Application User Name :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password for the category :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("  Select Type :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("    Enter App Name :");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Add Password");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Random Password");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("show");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Sort");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Decrypt");
        jToggleButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 2, true));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("log out");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 153), 2, true));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 25, 10, 25);
        jPanel3.add(jPanel4, gridBagConstraints);

        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Password Type", "User Name", "Application Name ", "Password", "Edit", "Delete"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(51, 51, 255));
        jTable2.setRowHeight(50);
        jTable2.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable2.setShowGrid(true);
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        MainAppUI mui= new MainAppUI();
        mui.show();
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        int[] selectedRows = jTable2.getSelectedRows();
        // Iterate over selected rows
        for (int selectedRow : selectedRows) {

            // Get the encrypted password from the selected row
            String encryptedPassword = (String) jTable2.getValueAt(selectedRow, 3);

            // Check if the password is already decrypted
            if (!isEncrypted(encryptedPassword)) {
                // If already decrypted, display an error message
                JOptionPane.showMessageDialog(this, "Error: Password is already decrypted", "Error", JOptionPane.ERROR_MESSAGE);
                continue;  // Move on to the next selected row
            }

            // Decrypt the password
            String decryptedPassword = decrypt(encryptedPassword);

            // Update the table with the decrypted password
            jTable2.setValueAt(decryptedPassword, selectedRow, 3);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        sortPasswordsByLastInsertedDate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        showPasswords = !showPasswords;

        // Refresh the displayed passwords in the table
        displayUserPasswords();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // Generate a 12-digit random password
        String randomPassword = generateRandomPassword(12);

        // Display the generated password in the jTextField2
        jTextField2.setText(randomPassword);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String appName= jTextField1.getText();
        String userName= jTextField4.getText();
        String password = jTextField2.getText();
        String passwordType = jComboBox1.getSelectedItem().toString();

        // Validate input
        if (passwordType.isEmpty() || appName.isEmpty() || userName.isEmpty()) {
            //System.out.println("Please fill in all fields.");
            JOptionPane.showMessageDialog(this, "Error: Please fill in all fields", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isPasswordValid(password)) {
            // If password is not valid, display a message and return
            JOptionPane.showMessageDialog(this, "Error: Password must contain minimum 8 digit, upper and lowercase , numbers and special character", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Database connection and insertion logic
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO userpassword (uid, ptype,puser_name, password_user, appname) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setString(2, passwordType);
                preparedStatement.setString(3, userName );
                preparedStatement.setString(4, password);
                preparedStatement.setString(5, appName);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    //System.out.println("Password added successfully!");
                    JOptionPane.showMessageDialog(this, "Success: Password added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    displayUserPasswords();
                } else {
                    //System.out.println("Failed to add password.");
                    JOptionPane.showMessageDialog(this, "Error: Failed to add password", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String searchAppName = jTextField3.getText();
        if (searchAppName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Please enter an app name to search", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Custom method to search and move row to the top
        searchAndMoveRowToTop(searchAppName);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
        
    
   // Function to check password complexity
        private boolean isPasswordValid(String password) {
            // Implement your password complexity requirements
            // For example, check for a minimum length of 8 characters, at least one uppercase letter, one lowercase letter, one digit, and one special character
            return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%&])[A-Za-z\\d@#$%&]{8,}$");
        }
    
        
    private boolean isEncrypted(String password) {
    try {
        // Decode the password from Base64
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        
        // If decoding is successful, consider it encrypted
        return true;
    } catch (IllegalArgumentException e) {
        // If decoding fails, consider it not encrypted
        return false;
    }
   }    
    private void sortPasswordsByLastInsertedDate() {
    DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();

    try {
        // Use the userId directly as it's a member variable
        String query = "SELECT ptype, appname, puser_name, password_user FROM userpassword WHERE uid = ? ORDER BY pid DESC";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Clear existing rows in the table
                tableModel.setRowCount(0);

                while (resultSet.next()) {
                    String passwordType = resultSet.getString("ptype");
                    String appName = resultSet.getString("appname");
                    String userName = resultSet.getString("puser_name");
                    String encryptpassword = resultSet.getString("password_user");
                    String password=encrypt(encryptpassword);

                    // Create buttons with custom renderer and editor
                    JButton editButton = new JButton("Edit");
                    JButton deleteButton = new JButton("Delete");

                    // Set the button names
                    editButton.setText("Edit");
                    deleteButton.setText("Delete");

                    // Add action listeners for the buttons
                    editButton.addActionListener(e -> handleButtonClicked("Edit", jTable2.getSelectedRow()));
                    deleteButton.addActionListener(e -> handleButtonClicked("Delete", jTable2.getSelectedRow()));

                    // Set custom renderer and editor for button columns
                    ButtonEditor editButtonEditor = new ButtonEditor(new JCheckBox());
                    editButtonEditor.setButtonType("Edit");
                    editButtonEditor.setSelectedRow(tableModel.getRowCount()); // Set the selected row
                    jTable2.getColumn("Edit").setCellRenderer(new ButtonRenderer());
                    jTable2.getColumn("Edit").setCellEditor(editButtonEditor);

                    ButtonEditor deleteButtonEditor = new ButtonEditor(new JCheckBox());
                    deleteButtonEditor.setButtonType("Delete");
                    jTable2.getColumn("Delete").setCellRenderer(new ButtonRenderer());
                    jTable2.getColumn("Delete").setCellEditor(deleteButtonEditor);

                    Object[] row = new Object[]{passwordType, appName,userName, password, editButton, deleteButton};
                    tableModel.addRow(row);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
// Generates a random password of the specified length using the given character set  
private String generateRandomPassword(int length) {
         String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digitChars = "0123456789";
        String specialChars = "@#$%&";

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each character class
        password.append(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));
        password.append(lowercaseChars.charAt(random.nextInt(lowercaseChars.length())));
        password.append(digitChars.charAt(random.nextInt(digitChars.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Generate the remaining characters randomly
        for (int i = 4; i < length; i++) {
            String allChars = uppercaseChars + lowercaseChars + digitChars + specialChars;
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the characters to make the password more random
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordArray[index];
            passwordArray[index] = passwordArray[i];
            passwordArray[i] = temp;
        }

        return new String(passwordArray); // Convert the StringBuilder to a String and return the generated random password
}
    
    // Updates a password in the database based on the specified parameters
 private void updatePasswordInDatabase(int rowIndex, String newPassword) {
    try { // SQL query to update the password in the database
        String updateQuery = "UPDATE userpassword SET password_user = ? WHERE uid = ? AND ptype = ? AND appname = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
             // Set parameters for the prepared statement
            updateStatement.setString(1, newPassword);
            updateStatement.setInt(2, userId);
            updateStatement.setString(3, (String) jTable2.getValueAt(rowIndex, 0)); // ptype
            updateStatement.setString(4, (String) jTable2.getValueAt(rowIndex, 1)); // appname
            // Execute the update query and get the number of affected rows
            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                // If the update is successful, print a success message
                JOptionPane.showMessageDialog(this, "Success: Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // If no rows were affected, the update failed
                
                JOptionPane.showMessageDialog(this, "Error: Failed to update password", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle any SQL exceptions that may occur
    }
}
   private void displayUserPasswords() {
    try {
        String query = "SELECT ptype, appname, puser_name, password_user FROM userpassword WHERE uid = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
                tableModel.setRowCount(0);

                // Set custom renderer and editor for button columns outside the loop
                TableColumn editColumn = jTable2.getColumn("Edit");
                editColumn.setCellRenderer(new ButtonRenderer());
                editColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

                TableColumn deleteColumn = jTable2.getColumn("Delete");
                deleteColumn.setCellRenderer(new ButtonRenderer());
                deleteColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

                while (resultSet.next()) {
                    String passwordType = resultSet.getString("ptype");
                    String appName = resultSet.getString("appname");
                    String userName = resultSet.getString("puser_name");
                    String encryptPassword = resultSet.getString("password_user");
                    String password = showPasswords ? encrypt(encryptPassword) : maskPassword(encryptPassword);

                    // Create buttons with custom renderer and editor
                    JButton editButton = new JButton("Edit");
                    JButton deleteButton = new JButton("Delete");

                    // Set the button names
                    editButton.setText("Edit");
                    deleteButton.setText("Delete");

                    int rowIndex = tableModel.getRowCount();
                    // Add action listeners for the buttons
                    editButton.addActionListener(e -> handleButtonClicked("Edit", jTable2.getSelectedRow()));
                    deleteButton.addActionListener(e -> handleButtonClicked("Delete", jTable2.getSelectedRow()));

                    // Set custom renderer and editor for button columns
                    ButtonEditor editButtonEditor = new ButtonEditor(new JCheckBox());
                    editButtonEditor.setButtonType("Edit");
                    editButtonEditor.setSelectedRow(rowIndex); // Set the selected row
                    jTable2.getColumn("Edit").setCellRenderer(new ButtonRenderer());
                    jTable2.getColumn("Edit").setCellEditor(editButtonEditor);

                    ButtonEditor deleteButtonEditor = new ButtonEditor(new JCheckBox());
                    deleteButtonEditor.setButtonType("Delete");
                    jTable2.getColumn("Delete").setCellRenderer(new ButtonRenderer());
                    jTable2.getColumn("Delete").setCellEditor(deleteButtonEditor);

                    Object[] row = new Object[]{passwordType, appName,userName, password, editButton, deleteButton};
                    tableModel.addRow(row);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Helper method to mask the password with asterisks
private String maskPassword(String password) {
    int length = password.length();
    return "\u2022".repeat(Math.max(0, length));
}
//render buttons
private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column == 4) {
            setBackground(new Color(135, 206, 250));
            jTable2.repaint();
            setText("Edit"); 
        } else if (column == 5) { 
            setBackground(new Color(255, 99, 71));
            jTable2.repaint();
            setText("Delete");
        }

        return this;
           
        }
        
    }

    // Custom button editor
public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String buttonType;
    private int selectedRow;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click (edit)
                fireEditingStopped();
                handleButtonClicked(buttonType, selectedRow);
            }
        });
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        setSelectedRow(row);
        button.setText(buttonType);
        return button;
    }
}

private void handleButtonClicked(String buttonType, int selectedRow) {
    switch (buttonType) {
        case "Edit":
            // Handle edit button click
            handleEditButton(selectedRow);
            break;
        case "Delete":
            // Handle delete button click
            
            handleDeleteButton(selectedRow);
            break;
        default:
            // Handle other button types if needed
            break;
    }
}


    private void handleEditButton(int rowIndex) {
    String newPassword = (String) jTable2.getValueAt(rowIndex, 3); // Assuming the password column is at index 2

    // Update the password in the database
    updatePasswordInDatabase(rowIndex, newPassword);
    }
    private void handleDeleteButton(int rowIndex) {
        // Implement logic to handle edit button action
        try {
        String passwordType = (String) jTable2.getValueAt(rowIndex, 0);
        String appName = (String) jTable2.getValueAt(rowIndex, 1);

        // Delete the password from the database
        String deleteQuery = "DELETE FROM userpassword WHERE uid = ? AND ptype = ? AND appname = ?";
        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
            deleteStatement.setInt(1, userId);
            deleteStatement.setString(2, passwordType);
            deleteStatement.setString(3, appName);

            int rowsAffected = deleteStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Success: Password deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                displayUserPasswords(); // Refresh the table after deletion
            } else {
                JOptionPane.showMessageDialog(this, "Error: Failed to delete password", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

private void searchAndMoveRowToTop(String searchAppName) {
    DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();

    for (int i = 0; i < tableModel.getRowCount(); i++) {
        String appName = (String) tableModel.getValueAt(i, 1); // Assuming app name is in the second column

        if (appName.equals(searchAppName)) {
            // Found the app name, move the row to the top
            Object[] rowData = new Object[tableModel.getColumnCount()];
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                rowData[j] = tableModel.getValueAt(i, j);
            }
            tableModel.removeRow(i);
            tableModel.insertRow(0, rowData);

            // Optional: Select the moved row
            jTable1.setRowSelectionInterval(0, 0);

            return; // Stop searching after the first occurrence
        }
    }

    JOptionPane.showMessageDialog(this, "Error: App name not found in the table", "Input Error", JOptionPane.ERROR_MESSAGE);
    
}

   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
    // Iterate over the installed look and feel options
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        // Check if the look and feel is "Windows"
        if ("Windows".equals(info.getName())) {
            // Set the look and feel to "Windows"
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
    // Handle any exceptions that may occur when setting the look and feel
    java.util.logging.Logger.getLogger(Userend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}

        //</editor-fold>
          
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Userend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
