package Tugas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Tugas2Anggi extends JFrame {
    private JTextField nameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JSpinner transactionFrequencySpinner;
    private JSpinner birthDateSpinner;
    private JList<String> accountTypeList;
    private JTextArea outputArea;

    public Tugas2Anggi() {
        setTitle("Form Pendaftaran Nasabah Bank");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel untuk input
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Set Font yang akan digunakan
        Font labelFont = new Font("Arial", Font.BOLD, 12);
        Font inputFont = new Font("Arial", Font.PLAIN, 10);
        Font outputFont = new Font("Arial", Font.PLAIN, 12);

        // Input Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setFont(labelFont);
        panel.add(nameLabel, gbc);
        
        gbc.gridx = 1;
        nameField = new JTextField();
        nameField.setFont(inputFont);
        nameField.setPreferredSize(new Dimension(200, 30)); // Atur ukuran preferensi
        panel.add(nameField, gbc);

        // Input Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        panel.add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        passwordField = new JPasswordField();
        passwordField.setFont(inputFont);
        passwordField.setPreferredSize(new Dimension(200, 30)); // Atur ukuran preferensi
        panel.add(passwordField, gbc);

        // Input Konfirmasi Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel confirmPasswordLabel = new JLabel("Konfirmasi Password:");
        confirmPasswordLabel.setFont(labelFont);
        panel.add(confirmPasswordLabel, gbc);
        
        gbc.gridx = 1;
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(inputFont);
        confirmPasswordField.setPreferredSize(new Dimension(200, 30)); // Atur ukuran preferensi
        panel.add(confirmPasswordField, gbc);

        // Input Frekuensi Transaksi
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel transactionFrequencyLabel = new JLabel("Frekuensi Transaksi/Bulan:");
        transactionFrequencyLabel.setFont(labelFont);
        panel.add(transactionFrequencyLabel, gbc);
        
        gbc.gridx = 1;
        transactionFrequencySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        panel.add(transactionFrequencySpinner, gbc);

        // Input Tanggal Lahir
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel birthDateLabel = new JLabel("Tanggal Lahir:");
        birthDateLabel.setFont(labelFont);
        panel.add(birthDateLabel, gbc);
        
        gbc.gridx = 1;
        birthDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(birthDateSpinner, "dd/MM/yyyy");
        birthDateSpinner.setEditor(dateEditor);
        panel.add(birthDateSpinner, gbc);

        // Input Jenis Tabungan
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel accountTypeLabel = new JLabel("Jenis Tabungan:");
        accountTypeLabel.setFont(labelFont);
        panel.add(accountTypeLabel, gbc);
        
        gbc.gridx = 1;
        String[] accountTypes = {"Tabungan", "Tabungan Darurat", "Tabungan Pendidikan", "Tabungan Pensiun"};
        accountTypeList = new JList<>(accountTypes);
        accountTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        accountTypeList.setFont(inputFont);
        panel.add(new JScrollPane(accountTypeList), gbc);

        // Output Area
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2; // Membuat area output mengambil dua kolom
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        outputArea.setFont(outputFont);
        panel.add(new JScrollPane(outputArea), gbc);

        // Tombol Submit
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1; // Reset ke satu kolom
        JButton submitButton = new JButton("Daftar");
        submitButton.setFont(labelFont);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        panel.add(submitButton, gbc);

        // Tombol Reset
        gbc.gridx = 1; // Pindah ke kolom kedua
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(labelFont);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm(); // Panggil metode resetForm
            }
        });
        panel.add(resetButton, gbc);

        // Tombol Exit
        gbc.gridx = 0;
        gbc.gridy = 8; // Letakkan di bawah tombol submit dan reset
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(labelFont);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Keluar dari aplikasi
            }
        });
        panel.add(exitButton, gbc);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menu.setFont(labelFont);
        
        // Menu Item Reset
        JMenuItem resetItem = new JMenuItem("Reset");
        resetItem.setFont(inputFont);
        resetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        menu.add(resetItem);
        
        // Menu Item Exit
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(inputFont);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Keluar dari aplikasi
            }
        });
        menu.add(exitItem);
        
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Menggunakan JScrollPane untuk panel utama
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane); // Tambahkan scrollPane ke frame
    }

    private void register() {
        String name = nameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        int transactionFrequency = (Integer) transactionFrequencySpinner.getValue();
        Date birthDate = (Date) birthDateSpinner.getValue();
        String accountType = accountTypeList.getSelectedValue();

        StringBuilder output = new StringBuilder();
        output.append("Nama: ").append(name).append("\n");
        output.append("Jenis Tabungan: ").append(accountType).append("\n");
        output.append("Frekuensi Transaksi: ").append(transactionFrequency).append(" kali/bulan\n");
        output.append("Tanggal Lahir: ").append(new SimpleDateFormat("dd/MM/yyyy").format(birthDate)).append("\n");

        // Validasi Password
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            output.append("Password tidak boleh kosong.\n");
        } else if (password.equals(confirmPassword)) {
            output.append("Password cocok.\n");
        } else {
            output.append("Password tidak cocok.\n");
        }

        outputArea.setText(output.toString());
    }

    private void resetForm() {
        nameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        transactionFrequencySpinner.setValue(1);
        birthDateSpinner.setValue(new Date());
        accountTypeList.clearSelection();
        outputArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tugas2Anggi form = new Tugas2Anggi();
            form.setVisible(true);
        });
    }
}
