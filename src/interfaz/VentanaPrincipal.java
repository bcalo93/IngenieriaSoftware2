/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author marce
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final String PERRO_POR_DEFECTO = "images/perroPorDefecto.png";

    private Sistema sistema;
    private boolean agregarMascotaSeleccionada;
    private boolean agregarUsuarioSeleccionado;
    private String rutaImagenAgregar;
    private Fecha fechaSeleccionada;
    private String rutaImagenRuta;

    public VentanaPrincipal(Sistema sis) {
        sistema = sis;
        fechaSeleccionada = new Fecha();
        initComponents();
        this.panelPadrinos.add(new PanelPadrino(sistema, this.panelPadrinos.getWidth(), 
                this.panelPadrinos.getHeight()));
        this.setLocationRelativeTo(null);
        try {
            perroLblFoto.setIcon(new ImageIcon(ImageIO.read(this.getClass()
                    .getResource(PERRO_POR_DEFECTO))
                    .getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        perroBtnEditar.setVisible(false);
        btnBorrar.setVisible(false);
        perroBtnGuardar.setVisible(false);
        calPanHoraPersonalizada.setVisible(false);
        calPanVeterinaria.setVisible(false);
        calComboVeterinaria.setVisible(false);
        calBtnVerRuta.setVisible(false);
        calBtnGroupVeterinaria.clearSelection();
        calBtnVeterinariaNo.setSelected(true);
        calBtnGroupRepetir.clearSelection();
        calBtnGroupRealizada.clearSelection();
        calBtnRealizadaNo.setSelected(true);
        calTxtTipoAlimento.setVisible(false);
        calLblTipoAlimento.setVisible(false);
        calPanVeterinaria.setVisible(false);
        calBtnEditar.setVisible(false);
        calLblHorarios.setVisible(false);
        rutaImagenAgregar = "";
        rutaImagenRuta = "";
        agregarMascotaSeleccionada = true;
        agregarUsuarioSeleccionado = true;
        calPanRuta.setVisible(false);
        this.setSize(950, 625);
    }

    public void resetearPestanaPerros() {
        setearListaMascotas();
        if (perroComboPerros.getItemCount() != 0) {
            Mascota mascotaSeleccionada = sistema.buscarMascotaPorNombre(perroComboPerros.getSelectedItem().toString());
            perroLblNombre.setText(mascotaSeleccionada.getNombre().toUpperCase());
            perroLblPeso.setText("Pesa:       " + mascotaSeleccionada.getPeso());
            perroLblAltura.setText("Mide:       " + mascotaSeleccionada.getAltura());
            perroLblComentarios.setText("" + mascotaSeleccionada.getComentarios());
            perroLblFoto.setIcon(mascotaSeleccionada.getFoto());
            perroBtnEditar.setVisible(true);
            btnBorrar.setVisible(true);
            ocultarAgregarMascota();
        } else {
            perroLblNombre.setText("Nombre:");
            perroLblPeso.setText("Peso:");
            perroLblAltura.setText("Altura:");
            perroLblComentarios.setText("Comentarios:");
            perroLblFoto.setIcon(crearIcono(PERRO_POR_DEFECTO, 100));
            perroBtnEditar.setVisible(false);
            btnBorrar.setVisible(false);
            mostrarAgregarMascota();
        }
        rutaImagenAgregar = "";
    }

    public void inicializarPestanaUsuarios() {

        resetearListaUsuarios();
        if (usuarioComboUsuarios.getItemCount() != 0) {
            Usuario usuarioSeleccionado = sistema.buscarUsuarioPorNombre(
                    usuarioComboUsuarios.getSelectedItem().toString());
            usuarioLblNombre.setText("Nombre: " + usuarioSeleccionado
                    .getNombre());
            usuarioLblMail.setText("Mail: " + usuarioSeleccionado.getMail());
        } else {
            usuarioLblNombre.setText("Nombre: ");
            usuarioLblMail.setText("Mail: ");
        }
        ocultarAgregarUsuario();
        agregarUsuarioSeleccionado = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        calBtnGroupRepetir = new javax.swing.ButtonGroup();
        calBtnGroupVeterinaria = new javax.swing.ButtonGroup();
        calBtnGroupRealizada = new javax.swing.ButtonGroup();
        panel = new javax.swing.JTabbedPane();
        panCalendario = new javax.swing.JPanel();
        calDayChooser = new com.toedter.calendar.JDayChooser();
        calMonthChooser = new com.toedter.calendar.JMonthChooser();
        calYearChooser = new com.toedter.calendar.JYearChooser();
        calScrollActividades = new javax.swing.JScrollPane();
        calLstActividades = new javax.swing.JList<>();
        btnGuardarActividad = new javax.swing.JButton();
        calLblTipo = new javax.swing.JLabel();
        calLblUsuario = new javax.swing.JLabel();
        calLblPerro = new javax.swing.JLabel();
        calLblFecha = new javax.swing.JLabel();
        calComboTipo = new javax.swing.JComboBox<>();
        calComboUsuario = new javax.swing.JComboBox<>();
        calComboPerro = new javax.swing.JComboBox<>();
        calComboHora = new javax.swing.JComboBox<>();
        calLblHora = new javax.swing.JLabel();
        calPanHoraPersonalizada = new javax.swing.JPanel();
        calPanLblMinutos = new javax.swing.JLabel();
        calPanSpinMinutos = new javax.swing.JSpinner();
        calPanSpinHora = new javax.swing.JSpinner();
        calPanLblHora = new javax.swing.JLabel();
        calLblFechaResp = new javax.swing.JLabel();
        calLblTituloFecha = new javax.swing.JLabel();
        calLblTituloActividad = new javax.swing.JLabel();
        calLblNombre = new javax.swing.JLabel();
        calTxtNombreResp = new javax.swing.JTextField();
        calPanVeterinaria = new javax.swing.JPanel();
        calLblVeterinaria = new javax.swing.JLabel();
        calBtnVeterinariaSi = new javax.swing.JRadioButton();
        calBtnVeterinariaNo = new javax.swing.JRadioButton();
        calComboVeterinaria = new javax.swing.JComboBox<>();
        calLblMotivo = new javax.swing.JLabel();
        calComboMotivo = new javax.swing.JComboBox<>();
        calLblHorarios = new javax.swing.JLabel();
        calTxtTipoAlimento = new javax.swing.JTextField();
        calLblTipoAlimento = new javax.swing.JLabel();
        calLblActividadesDelDia = new javax.swing.JLabel();
        calScrollInfoAct = new javax.swing.JScrollPane();
        calTxtAreaInfoAct = new javax.swing.JTextArea();
        calLblInfoActividad = new javax.swing.JLabel();
        calBtnEditar = new javax.swing.JButton();
        calLblRealizada = new javax.swing.JLabel();
        calBtnRealizadaSi = new javax.swing.JRadioButton();
        calBtnRealizadaNo = new javax.swing.JRadioButton();
        calPanRuta = new javax.swing.JPanel();
        calSpinDistancia = new javax.swing.JSpinner();
        calLblKilometros = new javax.swing.JLabel();
        calBtnRuta = new javax.swing.JButton();
        calLblRuta = new javax.swing.JLabel();
        calLblDistancia = new javax.swing.JLabel();
        calBtnAgregarDatos = new javax.swing.JButton();
        calLblAdvertencia = new javax.swing.JLabel();
        calBtnVerRuta = new javax.swing.JButton();
        panUsuarios = new javax.swing.JPanel();
        usuarioLblUsuarios = new javax.swing.JLabel();
        usuarioComboUsuarios = new javax.swing.JComboBox<>();
        usuarioLblNombre = new javax.swing.JLabel();
        usuarioLblMail = new javax.swing.JLabel();
        usuarioTxtNombre = new javax.swing.JTextField();
        usuarioTxtMail = new javax.swing.JTextField();
        usuarioBtnAgregar = new javax.swing.JButton();
        usuarioLblActividades = new javax.swing.JLabel();
        usuarioScrollActividades = new javax.swing.JScrollPane();
        usuarioLstActividades = new javax.swing.JList<>();
        usuarioLblActividad = new javax.swing.JLabel();
        usuarioLblFecha = new javax.swing.JLabel();
        usuarioScrollFechas = new javax.swing.JScrollPane();
        usuarioLstFechas = new javax.swing.JList<>();
        usuarioLblAdvertencia = new javax.swing.JLabel();
        panPerros = new javax.swing.JPanel();
        perroBtnAgregar = new javax.swing.JButton();
        perroLblPerros = new javax.swing.JLabel();
        perroPanInformacion = new javax.swing.JPanel();
        perroPanFoto = new javax.swing.JPanel();
        perroLblFoto = new javax.swing.JLabel();
        perroLblAltura = new javax.swing.JLabel();
        perroLblNombre = new javax.swing.JLabel();
        perroLblPeso = new javax.swing.JLabel();
        perroTxtNombre = new javax.swing.JTextField();
        perroBtnExaminar = new javax.swing.JButton();
        perroLblFotoBoton = new javax.swing.JLabel();
        perroSpinAltura = new javax.swing.JSpinner();
        perroSpinPeso = new javax.swing.JSpinner();
        calLblCentimetros = new javax.swing.JLabel();
        calLblKilogramos = new javax.swing.JLabel();
        comboTipoMascota = new javax.swing.JComboBox<>();
        labelTipo = new javax.swing.JLabel();
        perroComboPerros = new javax.swing.JComboBox<>();
        perroBtnEditar = new javax.swing.JButton();
        perroBtnGuardar = new javax.swing.JButton();
        perroLblAdvertencia = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        perroTxtComentarios = new javax.swing.JTextField();
        perroLblComentarios = new javax.swing.JLabel();
        panelPadrinos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Pets");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });

        calDayChooser.setBorder(new javax.swing.border.MatteBorder(null));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, calMonthChooser, org.jdesktop.beansbinding.ELProperty.create("${month}"), calDayChooser, org.jdesktop.beansbinding.BeanProperty.create("month"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, calYearChooser, org.jdesktop.beansbinding.ELProperty.create("${year}"), calDayChooser, org.jdesktop.beansbinding.BeanProperty.create("year"));
        bindingGroup.addBinding(binding);

        calDayChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calDayChooserPropertyChange(evt);
            }
        });

        calMonthChooser.setBorder(new javax.swing.border.MatteBorder(null));
        calMonthChooser.setToolTipText("");

        calYearChooser.setBorder(new javax.swing.border.MatteBorder(null));

        calLstActividades.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                calLstActividadesValueChanged(evt);
            }
        });
        calScrollActividades.setViewportView(calLstActividades);

        btnGuardarActividad.setText("Guardar Actividad");
        btnGuardarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActividadActionPerformed(evt);
            }
        });

        calLblTipo.setText("Tipo de actividad:");

        calLblUsuario.setText("Usuario:");

        calLblPerro.setText("Perro:");

        calLblFecha.setText("Fecha:");

        calComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paseo", "Alimentación", "Otra" }));
        calComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calComboTipoActionPerformed(evt);
            }
        });

        calComboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahora", "Personalizado" }));
        calComboHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calComboHoraActionPerformed(evt);
            }
        });

        calLblHora.setText("Hora");

        calPanLblMinutos.setText("Minutos");

        calPanSpinMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 5));

        calPanSpinHora.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));

        calPanLblHora.setText("Hora");

        javax.swing.GroupLayout calPanHoraPersonalizadaLayout = new javax.swing.GroupLayout(calPanHoraPersonalizada);
        calPanHoraPersonalizada.setLayout(calPanHoraPersonalizadaLayout);
        calPanHoraPersonalizadaLayout.setHorizontalGroup(
            calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanHoraPersonalizadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calPanLblHora)
                    .addComponent(calPanLblMinutos))
                .addGap(18, 18, 18)
                .addGroup(calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(calPanSpinMinutos)
                    .addComponent(calPanSpinHora))
                .addContainerGap())
        );
        calPanHoraPersonalizadaLayout.setVerticalGroup(
            calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanHoraPersonalizadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calPanLblHora)
                    .addComponent(calPanSpinHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calPanLblMinutos)
                    .addComponent(calPanSpinMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        calLblTituloFecha.setText("Fecha");

        calLblTituloActividad.setText("Actividad");

        calLblNombre.setText("Nombre:");

        calTxtNombreResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calTxtNombreRespActionPerformed(evt);
            }
        });

        calLblVeterinaria.setText("Veterinaria:");

        calBtnGroupVeterinaria.add(calBtnVeterinariaSi);
        calBtnVeterinariaSi.setText("Si");
        calBtnVeterinariaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnVeterinariaSiActionPerformed(evt);
            }
        });

        calBtnGroupVeterinaria.add(calBtnVeterinariaNo);
        calBtnVeterinariaNo.setText("No");
        calBtnVeterinariaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnVeterinariaNoActionPerformed(evt);
            }
        });

        calComboVeterinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calComboVeterinariaActionPerformed(evt);
            }
        });

        calLblMotivo.setText("Motivo:");

        calComboMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corte de Pelo", "Corte de Uñas", "Visita Médica", "Otro" }));

        javax.swing.GroupLayout calPanVeterinariaLayout = new javax.swing.GroupLayout(calPanVeterinaria);
        calPanVeterinaria.setLayout(calPanVeterinariaLayout);
        calPanVeterinariaLayout.setHorizontalGroup(
            calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanVeterinariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(calLblHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(calPanVeterinariaLayout.createSequentialGroup()
                        .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calLblVeterinaria)
                            .addComponent(calLblMotivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(calComboVeterinaria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calComboMotivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(calPanVeterinariaLayout.createSequentialGroup()
                                .addComponent(calBtnVeterinariaSi)
                                .addGap(18, 18, 18)
                                .addComponent(calBtnVeterinariaNo)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        calPanVeterinariaLayout.setVerticalGroup(
            calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanVeterinariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calLblVeterinaria)
                    .addComponent(calBtnVeterinariaSi)
                    .addComponent(calBtnVeterinariaNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calComboVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calComboMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calLblMotivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calLblHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        calTxtTipoAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calTxtTipoAlimentoActionPerformed(evt);
            }
        });

        calLblTipoAlimento.setText("Tipo Alimento:");

        calLblActividadesDelDia.setText("Actividades del Día:");

        calTxtAreaInfoAct.setColumns(20);
        calTxtAreaInfoAct.setRows(5);
        calScrollInfoAct.setViewportView(calTxtAreaInfoAct);

        calLblInfoActividad.setText("Información de la Actividad: ");

        calBtnEditar.setText("Editar");
        calBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnEditarActionPerformed(evt);
            }
        });

        calLblRealizada.setText("Fue realizada:");

        calBtnGroupRealizada.add(calBtnRealizadaSi);
        calBtnRealizadaSi.setText("Si");
        calBtnRealizadaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnRealizadaSiActionPerformed(evt);
            }
        });

        calBtnGroupRealizada.add(calBtnRealizadaNo);
        calBtnRealizadaNo.setText("No");
        calBtnRealizadaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnRealizadaNoActionPerformed(evt);
            }
        });

        calSpinDistancia.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));

        calLblKilometros.setText("Kilómetros");

        calBtnRuta.setText("Agregar Ruta");
        calBtnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnRutaActionPerformed(evt);
            }
        });

        calLblRuta.setText("Ruta:");

        calLblDistancia.setText("Distancia:");

        javax.swing.GroupLayout calPanRutaLayout = new javax.swing.GroupLayout(calPanRuta);
        calPanRuta.setLayout(calPanRutaLayout);
        calPanRutaLayout.setHorizontalGroup(
            calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanRutaLayout.createSequentialGroup()
                .addGroup(calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calLblRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calLblDistancia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGroup(calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calPanRutaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(calSpinDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calLblKilometros))
                    .addGroup(calPanRutaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(calBtnRuta)))
                .addContainerGap())
        );
        calPanRutaLayout.setVerticalGroup(
            calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calPanRutaLayout.createSequentialGroup()
                .addGroup(calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calBtnRuta)
                    .addComponent(calLblRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calSpinDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calLblKilometros)
                    .addComponent(calLblDistancia))
                .addGap(49, 49, 49))
        );

        calBtnAgregarDatos.setText("Agregar Datos Precargados");
        calBtnAgregarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnAgregarDatosActionPerformed(evt);
            }
        });

        calBtnVerRuta.setText("Ver Ruta");
        calBtnVerRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnVerRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCalendarioLayout = new javax.swing.GroupLayout(panCalendario);
        panCalendario.setLayout(panCalendarioLayout);
        panCalendarioLayout.setHorizontalGroup(
            panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarioLayout.createSequentialGroup()
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calDayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addComponent(calLblActividadesDelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCalendarioLayout.createSequentialGroup()
                                        .addComponent(calScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calLblInfoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(calScrollInfoAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addComponent(calMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(calLblTituloFecha)))
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(calBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(calBtnAgregarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(calLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addComponent(calPanRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(calBtnVerRuta))
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(calTxtTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panCalendarioLayout.createSequentialGroup()
                                                    .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(calLblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(calLblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(calLblPerro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(calLblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(calLblHora))
                                                        .addComponent(calLblNombre))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(calComboTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(calComboUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE)
                                                        .addComponent(calComboPerro, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE)
                                                        .addComponent(calLblFechaResp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(calTxtNombreResp)
                                                        .addComponent(calComboHora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(calLblRealizada)
                                                    .addComponent(calLblTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addComponent(calBtnRealizadaSi)
                                                .addGap(18, 18, 18)
                                                .addComponent(calBtnRealizadaNo)))
                                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(calPanVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(calPanHoraPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCalendarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calLblTituloActividad)
                        .addGap(291, 291, 291))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnGuardarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panCalendarioLayout.setVerticalGroup(
            panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarioLayout.createSequentialGroup()
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblTipo)
                                    .addComponent(calComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblNombre)
                                    .addComponent(calTxtNombreResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblUsuario)
                                    .addComponent(calComboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(calPanVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calLblPerro)
                            .addComponent(calComboPerro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(calLblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(calLblFechaResp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblHora)
                                    .addComponent(calComboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblRealizada)
                                    .addComponent(calBtnRealizadaSi)
                                    .addComponent(calBtnRealizadaNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(calTxtTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(calPanHoraPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calPanRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calBtnVerRuta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calBtnEditar)
                        .addGap(12, 12, 12)
                        .addComponent(calLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calBtnAgregarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calLblTituloFecha)
                            .addComponent(calLblTituloActividad))
                        .addGap(3, 3, 3)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calDayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calLblActividadesDelDia)
                            .addComponent(calLblInfoActividad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addComponent(calScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(calScrollInfoAct))))
                .addGap(326, 326, 326))
        );

        panel.addTab("Calendario", panCalendario);

        usuarioLblUsuarios.setText("Usuario");

        usuarioComboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioComboUsuariosActionPerformed(evt);
            }
        });

        usuarioLblNombre.setText("Nombre:");

        usuarioLblMail.setText("Mail:");

        usuarioTxtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTxtMailActionPerformed(evt);
            }
        });

        usuarioBtnAgregar.setText("Agregar Usuario");
        usuarioBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioBtnAgregarActionPerformed(evt);
            }
        });

        usuarioLblActividades.setText("Próximas Actividades");

        usuarioScrollActividades.setViewportView(usuarioLstActividades);

        usuarioLblActividad.setText("Activiad:");

        usuarioLblFecha.setText("Fecha");

        usuarioScrollFechas.setViewportView(usuarioLstFechas);

        javax.swing.GroupLayout panUsuariosLayout = new javax.swing.GroupLayout(panUsuarios);
        panUsuarios.setLayout(panUsuariosLayout);
        panUsuariosLayout.setHorizontalGroup(
            panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioLblUsuarios)
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(usuarioComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panUsuariosLayout.createSequentialGroup()
                                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(usuarioLblNombre)
                                            .addComponent(usuarioLblMail))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(usuarioTxtMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(usuarioTxtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(usuarioLblAdvertencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(39, 39, 39))
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(usuarioBtnAgregar)
                        .addGap(102, 102, 102)))
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarioLblActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioLblActividad)
                            .addComponent(usuarioScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioLblFecha)
                            .addComponent(usuarioScrollFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(89, 89, 89))
        );
        panUsuariosLayout.setVerticalGroup(
            panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUsuariosLayout.createSequentialGroup()
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioLblNombre)
                            .addComponent(usuarioTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioTxtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioLblMail))
                        .addGap(18, 18, 18)
                        .addComponent(usuarioLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioBtnAgregar))
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(usuarioLblActividades)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(usuarioLblActividad)
                                    .addComponent(usuarioLblFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usuarioScrollFechas)
                                    .addComponent(usuarioScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(usuarioLblUsuarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(561, Short.MAX_VALUE))
        );

        panel.addTab("Usuarios", panUsuarios);

        perroBtnAgregar.setText("Ingresar Perro");
        perroBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perroBtnAgregarActionPerformed(evt);
            }
        });

        perroLblPerros.setText("Perros");

        javax.swing.GroupLayout perroPanFotoLayout = new javax.swing.GroupLayout(perroPanFoto);
        perroPanFoto.setLayout(perroPanFotoLayout);
        perroPanFotoLayout.setHorizontalGroup(
            perroPanFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(perroPanFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(perroLblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        perroPanFotoLayout.setVerticalGroup(
            perroPanFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(perroPanFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(perroLblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        perroLblAltura.setText("Altura:");

        perroLblNombre.setText("Nombre:");

        perroLblPeso.setText("Peso");

        perroTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perroTxtNombreActionPerformed(evt);
            }
        });

        perroBtnExaminar.setText("Examinar");
        perroBtnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perroBtnExaminarActionPerformed(evt);
            }
        });

        perroLblFotoBoton.setText("Foto:");

        perroSpinAltura.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        perroSpinPeso.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.1d));

        calLblCentimetros.setText("Centímetros");

        calLblKilogramos.setText("Kilogramos");

        comboTipoMascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perro", "Gato", "Caballo", "Vaca" }));

        labelTipo.setText("Tipo:");

        javax.swing.GroupLayout perroPanInformacionLayout = new javax.swing.GroupLayout(perroPanInformacion);
        perroPanInformacion.setLayout(perroPanInformacionLayout);
        perroPanInformacionLayout.setHorizontalGroup(
            perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perroPanInformacionLayout.createSequentialGroup()
                .addComponent(perroPanFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(perroLblAltura)
                    .addComponent(perroLblNombre)
                    .addComponent(perroLblFotoBoton)
                    .addComponent(perroLblPeso)
                    .addComponent(labelTipo))
                .addGap(31, 31, 31)
                .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboTipoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(perroTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(perroBtnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(perroPanInformacionLayout.createSequentialGroup()
                            .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(perroSpinPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                .addComponent(perroSpinAltura))
                            .addGap(18, 18, 18)
                            .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(calLblCentimetros)
                                .addComponent(calLblKilogramos)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        perroPanInformacionLayout.setVerticalGroup(
            perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(perroPanInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(perroPanInformacionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(perroTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(perroLblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTipoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(perroSpinAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(perroLblAltura)
                            .addComponent(calLblCentimetros))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(perroSpinPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(perroLblPeso)
                            .addComponent(calLblKilogramos)))
                    .addComponent(perroPanFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(perroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perroBtnExaminar)
                    .addComponent(perroLblFotoBoton))
                .addContainerGap())
        );

        perroComboPerros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perroComboPerrosMouseClicked(evt);
            }
        });
        perroComboPerros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perroComboPerrosActionPerformed(evt);
            }
        });

        perroBtnEditar.setText("Editar");
        perroBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perroBtnEditarActionPerformed(evt);
            }
        });

        perroBtnGuardar.setText("Guardar");
        perroBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perroBtnGuardarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        perroLblComentarios.setText("Comentarios");

        javax.swing.GroupLayout panPerrosLayout = new javax.swing.GroupLayout(panPerros);
        panPerros.setLayout(panPerrosLayout);
        panPerrosLayout.setHorizontalGroup(
            panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPerrosLayout.createSequentialGroup()
                .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(perroLblPerros)
                            .addComponent(perroComboPerros, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPerrosLayout.createSequentialGroup()
                        .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(perroBtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addGap(12, 12, 12)))
                .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(perroBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(perroBtnAgregar)))
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(perroLblAdvertencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panPerrosLayout.createSequentialGroup()
                                .addComponent(perroTxtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panPerrosLayout.createSequentialGroup()
                                .addComponent(perroLblComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(perroPanInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(152, 152, 152))
        );
        panPerrosLayout.setVerticalGroup(
            panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPerrosLayout.createSequentialGroup()
                .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addContainerGap(367, Short.MAX_VALUE)
                        .addComponent(perroLblComentarios))
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(perroPanInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panPerrosLayout.createSequentialGroup()
                                .addComponent(perroLblPerros)
                                .addGap(18, 18, 18)
                                .addComponent(perroComboPerros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(perroBtnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrar)))
                        .addGap(0, 172, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(perroTxtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(perroLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(perroBtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(perroBtnAgregar)
                .addContainerGap(345, Short.MAX_VALUE))
        );

        panel.addTab("Perros", panPerros);

        javax.swing.GroupLayout panelPadrinosLayout = new javax.swing.GroupLayout(panelPadrinos);
        panelPadrinos.setLayout(panelPadrinosLayout);
        panelPadrinosLayout.setHorizontalGroup(
            panelPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 899, Short.MAX_VALUE)
        );
        panelPadrinosLayout.setVerticalGroup(
            panelPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        panel.addTab("Padrinos", panelPadrinos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void perroBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perroBtnAgregarActionPerformed
        if (!agregarMascotaSeleccionada) {
            mostrarAgregarMascota();
        } else {
            Mascota mascotaAgregar = new Mascota(perroTxtNombre.getText(),
                    Integer.parseInt(perroSpinAltura.getValue().toString()),
                    Double.parseDouble(perroSpinPeso.getValue().toString()),
                    perroTxtComentarios.getText(),(String)comboTipoMascota
                            .getSelectedItem());
            if(validarFormularioMascota(mascotaAgregar)) {
                if (rutaImagenAgregar.equals("")) {
                    try {
                        mascotaAgregar.setFoto(
                                new ImageIcon(ImageIO.read(this.getClass()
                                        .getResource(PERRO_POR_DEFECTO))
                                        .getScaledInstance(100, 100, 
                                                java.awt.Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                } else {
                    File imagen = new File(rutaImagenAgregar);
                    mascotaAgregar.setFoto(crearIcono(imagen, 100));
                    rutaImagenAgregar = "";
                }
                sistema.anadirMascota(mascotaAgregar);
                perroTxtNombre.setText("");
                perroSpinPeso.setValue((Object) 0.0);
                perroSpinAltura.setValue((Object) 0.0);
                perroTxtComentarios.setText("");
                perroLblAdvertencia.setText("");
                ocultarAgregarMascota();
                setearListaMascotas();
                perroComboPerros.setSelectedIndex(sistema.getMascotas().size() - 1);
                btnBorrar.setVisible(true);
            }
        }
    }//GEN-LAST:event_perroBtnAgregarActionPerformed

    
    private boolean validarFormularioMascota(Mascota mascota) {
        boolean resultado = false;
        if (!mascota.nombreValido()) {
            perroLblAdvertencia.setText("Por favor ingrese un nombre");
            
        } else if (!mascota.alturaValida()) {
            perroLblAdvertencia.setText("Por favor ingrese una altura válida");
            
        } else if (!mascota.pesoValido()) {
            perroLblAdvertencia.setText("Por favor ingrese un peso válido");
            
        } else {
            resultado = true;
            
        }
        return resultado;
    }
    
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
    private void usuarioBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioBtnAgregarActionPerformed
        if (agregarUsuarioSeleccionado == false) {
            mostrarAgregarUsuario();
        } else {
            if (usuarioTxtNombre.getText().equals("")) {
                usuarioLblAdvertencia.setText("Por favor ingrese un nombre para el usuario");
            } else if (usuarioTxtMail.getText().equals("")) {
                usuarioLblAdvertencia.setText("Por favor ingrese un email para el usuario");
            } else if (!isValidEmailAddress(usuarioTxtMail.getText())) {
                usuarioLblAdvertencia.setText("Por favor ingrese un email correcto");
            } else {
                Usuario usuarioAgregar = new Usuario(usuarioTxtNombre.getText(), 
                        usuarioTxtMail.getText());
                sistema.anadirUsuario(usuarioAgregar);
                usuarioTxtNombre.setText("");
                usuarioTxtMail.setText("");
                ocultarAgregarUsuario();
                resetearListaUsuarios();
                usuarioLblAdvertencia.setText("");
            }
        }
    }//GEN-LAST:event_usuarioBtnAgregarActionPerformed

    private void usuarioComboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioComboUsuariosActionPerformed
        ocultarAgregarUsuario();
        if (usuarioComboUsuarios.getItemCount() > 0) {
            Usuario usuarioSeleccionado = sistema.buscarUsuarioPorNombre(
                    usuarioComboUsuarios.getSelectedItem().toString());
            usuarioLblNombre.setText("Nombre: " + usuarioSeleccionado
                    .getNombre());
            usuarioLblMail.setText("Mail: " + usuarioSeleccionado.getMail());
            int cantidadActividades = usuarioSeleccionado.getActividades().size();
            String[] arrayActividades = new String[cantidadActividades];
            String[] arrayFechas = new String[cantidadActividades];
            for (int i = 0; i < cantidadActividades; i++) {
                arrayActividades[i] = usuarioSeleccionado.getActividades()
                        .get(i).getNombre();
                Fecha fechaActividad = usuarioSeleccionado.getActividades()
                        .get(i).getFecha();
                arrayFechas[i] = fechaActividad.getDia() + "/" + 
                        fechaActividad.getMes() + "/" + fechaActividad.getAno();
            }
            usuarioLstActividades.setListData(arrayActividades);
            usuarioLstFechas.setListData(arrayFechas);
        } else {
            usuarioLblNombre.setText("Nombre: ");
            usuarioLblMail.setText("Mail: ");
            String[] arrayVacio = new String[0];
            usuarioLstActividades.setListData(arrayVacio);
            usuarioLstFechas.setListData(arrayVacio);
        }
    }//GEN-LAST:event_usuarioComboUsuariosActionPerformed

    private void setearListaDeVeterinarias() {
        if (calComboVeterinaria.getItemCount() > 0) {
            calComboVeterinaria.removeAllItems();
        }
        for (int i = 0; i < sistema.getVeterinarias().size(); i++) {
            calComboVeterinaria.addItem(sistema.getVeterinarias().get(i).getNombre());
        }
    }

    private void mostrarAgregarMascota() {
        agregarMascotaSeleccionada = true;
        mostrarFormularioMascota();
        perroLblFoto.setIcon(crearIcono(PERRO_POR_DEFECTO, 100));
    }
    
    private void mostrarFormularioMascota() {
        perroLblNombre.setText("Nombre:");
        perroLblPeso.setText("Peso:");
        perroLblAltura.setText("Altura:");
        perroLblComentarios.setText("Comentarios:");
        labelTipo.setText("Tipo:");
        perroTxtNombre.setVisible(true);
        perroSpinPeso.setVisible(true);
        perroSpinAltura.setVisible(true);
        perroTxtComentarios.setVisible(true);
        perroLblFotoBoton.setVisible(true);
        perroBtnExaminar.setVisible(true);
        comboTipoMascota.setVisible(true);
    }

    private void ocultarAgregarMascota() {
        perroTxtNombre.setVisible(false);
        perroTxtNombre.setText("");
        perroSpinPeso.setVisible(false);
        perroSpinPeso.setValue(0.0);
        perroSpinAltura.setVisible(false);
        perroSpinAltura.setValue(0.0);
        perroTxtComentarios.setVisible(false);
        perroTxtComentarios.setText("");
        comboTipoMascota.setSelectedIndex(0);
        comboTipoMascota.setVisible(false);
        perroLblFotoBoton.setVisible(false);
        perroBtnExaminar.setVisible(false);
        agregarMascotaSeleccionada = false;
    }

    private void mostrarEditarMascota() {
        perroBtnGuardar.setVisible(true);
        perroBtnAgregar.setVisible(false);
        agregarMascotaSeleccionada = true;
        mostrarFormularioMascota();
        Mascota mascotaSeleccionada = sistema.buscarMascotaPorNombre(perroComboPerros
                .getSelectedItem().toString());
        perroLblFoto.setIcon(mascotaSeleccionada.getFoto());
        perroTxtNombre.setText(mascotaSeleccionada.getNombre());
        perroSpinPeso.setValue(mascotaSeleccionada.getPeso());
        perroSpinAltura.setValue(mascotaSeleccionada.getAltura());
        perroTxtComentarios.setText("" + mascotaSeleccionada.getComentarios());
        comboTipoMascota.setSelectedItem(mascotaSeleccionada.getTipo());
    }

    private void setearListaMascotas() {
        if (perroComboPerros.getItemCount() > 0) {
            perroComboPerros.removeAllItems();
        }
        if (calComboPerro.getItemCount() > 0) {
            calComboPerro.removeAllItems();
        }
        for (int i = 0; i < sistema.getMascotas().size(); i++) {
            perroComboPerros.addItem(sistema.getMascotas().get(i).getNombre());
            calComboPerro.addItem(sistema.getMascotas().get(i).getNombre());
        }

    }

    private void mostrarAgregarUsuario() {
        agregarUsuarioSeleccionado = true;
        usuarioLblNombre.setText("Nombre:");
        usuarioLblMail.setText("Mail:");
        usuarioTxtNombre.setVisible(true);
        usuarioTxtMail.setVisible(true);
    }

    private void ocultarAgregarUsuario() {
        usuarioTxtNombre.setVisible(false);
        usuarioTxtMail.setVisible(false);
        agregarUsuarioSeleccionado = false;
    }

    private void resetearListaUsuarios() {
        if (usuarioComboUsuarios.getItemCount() > 0) {
            usuarioComboUsuarios.removeAllItems();
        }
        if (calComboUsuario.getItemCount() > 0) {
            calComboUsuario.removeAllItems();
        }
        for (int i = 0; i < sistema.getUsuarios().size(); i++) {
            usuarioComboUsuarios.addItem(sistema.getUsuarios().get(i)
                    .getNombre());
            calComboUsuario.addItem(sistema.getUsuarios().get(i).getNombre());
        }
    }

    private void usuarioTxtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTxtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTxtMailActionPerformed

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelMouseClicked

    private void perroComboPerrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perroComboPerrosMouseClicked

    }//GEN-LAST:event_perroComboPerrosMouseClicked

    private void perroComboPerrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perroComboPerrosActionPerformed
        ocultarAgregarMascota();
        if (perroComboPerros.getItemCount() > 0) {
            Mascota mascotaSeleccionada = sistema.buscarMascotaPorNombre(
                    perroComboPerros.getSelectedItem().toString());
            perroLblNombre.setText(mascotaSeleccionada.getNombre().toUpperCase());
            perroLblPeso.setText("Pesa:       " + mascotaSeleccionada.getPeso());
            perroLblAltura.setText("Mide:       " + mascotaSeleccionada
                    .getAltura());
            perroLblComentarios.setText("" + mascotaSeleccionada.getComentarios());
            labelTipo.setText("Tipo:       " + mascotaSeleccionada.getTipo());
            perroLblFoto.setIcon(mascotaSeleccionada.getFoto());
            perroBtnGuardar.setVisible(false);
            perroBtnEditar.setVisible(true);
            perroBtnAgregar.setVisible(true);
        } else {
            perroLblNombre.setText("Nombre: ");
            perroLblPeso.setText("Peso ");
            perroLblAltura.setText("Altura: ");
            perroLblComentarios.setText("Comentarios: ");
            labelTipo.setText("Tipo: ");
            try {
                perroLblFoto.setIcon(new ImageIcon(ImageIO.read(this.getClass()
                        .getResource(PERRO_POR_DEFECTO))
                        .getScaledInstance(100, 100, 
                                java.awt.Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_perroComboPerrosActionPerformed

    private void perroBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perroBtnEditarActionPerformed
        mostrarEditarMascota();
    }//GEN-LAST:event_perroBtnEditarActionPerformed

    private void perroBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perroBtnGuardarActionPerformed
        String valor = perroSpinAltura.getValue() + "";
        double altura = Double.parseDouble(valor);
        valor = perroSpinPeso.getValue() + "";
        double peso = Double.parseDouble(valor);
        
        Mascota nuevosValores = new Mascota(perroTxtNombre.getText(),
                altura, peso, perroTxtComentarios.getText(), 
                (String)comboTipoMascota.getSelectedItem());
        if(validarFormularioMascota(nuevosValores)) {
            Mascota mascotaSeleccionada = sistema.buscarMascotaPorNombre(
                perroComboPerros.getSelectedItem().toString());
            mascotaSeleccionada.actualizar(nuevosValores);
        if (!rutaImagenAgregar.equals("")) {
            File imagen = new File(rutaImagenAgregar);
            mascotaSeleccionada.setFoto(crearIcono(imagen, 100));
            rutaImagenAgregar = "";
        }
        ocultarAgregarMascota();
        int pos = perroComboPerros.getSelectedIndex();
        setearListaMascotas();
        perroComboPerros.setSelectedIndex(pos);
        }
    }//GEN-LAST:event_perroBtnGuardarActionPerformed

    private void calBtnAgregarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnAgregarDatosActionPerformed
        try {
            Usuario persona = new Usuario("Alex", "alexkmass@gmail.com");
            sistema.anadirUsuario(persona);
            Mascota rasta = new Mascota("Rasta", 50, 23, 
                    "Es un buen perro, le gusta comer", "Perro");
            rasta.setFoto(new ImageIcon(ImageIO.read(this.getClass()
                    .getResource(PERRO_POR_DEFECTO))
                    .getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            sistema.anadirMascota(rasta);
            Usuario persona2 = new Usuario("Marcelo", "marcelo@gmail.com");
            sistema.anadirUsuario(persona2);
            Mascota ori = new Mascota("Ori", 50, 23, "Es un buen perro", "Perro");
            ori.setFoto(new ImageIcon(ImageIO.read(this.getClass()
                    .getResource("images/perroFoto.png"))
                    .getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            sistema.anadirMascota(ori);
            Fecha fecha = new Fecha(22, 11, 2018);
            sistema.anadirFecha(fecha);
            LocalTime hora = LocalTime.now();
            Paseo act = new Paseo("Paseo Rasta", persona, rasta, 0.0, false, 
                    hora, fecha);
            act.setRuta(new ImageIcon(ImageIO.read(this.getClass()
                    .getResource("images/rutaPorDefecto.png"))
                    .getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH)));
            sistema.anadirActividad(act);
            sistema.getPaseos().add(act);
            hora = LocalTime.now();
            Alimentacion act2 = new Alimentacion("Alimentación de Ori", persona, 
                    ori, "DogChow", false, hora, fecha);
            sistema.anadirActividad(act2);
            sistema.getAlimentaciones().add(act2);
            ActividadCualquiera act3 = new ActividadCualquiera(
                    "Ir a una cita con Rasta", persona, rasta, true, hora, fecha);
            sistema.anadirActividad(act3);
            sistema.getActsCualquieras().add(act3);
            Veterinaria vet1 = new Veterinaria("Pocitos", new ArrayList<>(), 8, 16);
            sistema.getVeterinarias().add(vet1);
            Veterinaria vet2 = new Veterinaria("Carrasco", new ArrayList<>(), 10, 15);
            sistema.getVeterinarias().add(vet2);
            Veterinaria vet3 = new Veterinaria("Cordon", new ArrayList<>(), 8, 23);
            sistema.getVeterinarias().add(vet3);
            VisitaVeterinaria visita = new VisitaVeterinaria("Visita a VetCordon", 
                    hora, persona, rasta, false, fecha, vet3, "Rasta tiene fiebre");
            sistema.anadirActividad(visita);
            sistema.getVisitas().add(visita);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        resetearPestanaPerros();
        inicializarPestanaUsuarios();
        setearListaDeVeterinarias();
        calBtnAgregarDatos.setVisible(false);
        int dia = calDayChooser.getDay();
        int mes = calMonthChooser.getMonth() + 1;
        int ano = calYearChooser.getYear();
        ArrayList<Actividad> listaActividades = sistema.listaActividadesPorFecha(
                dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        calLstActividades.setListData(arrActividades);

        calLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_calBtnAgregarDatosActionPerformed

    private void calBtnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnRutaActionPerformed
        JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        elegirImagen.setFileFilter(filter);
        int result = elegirImagen.showDialog(this, "Elija una imagen");
        if (result == JFileChooser.APPROVE_OPTION) {
            File imgSeleccionada = elegirImagen.getSelectedFile();
            rutaImagenRuta = imgSeleccionada.getAbsolutePath();
        } else {
            calLblAdvertencia.setText("No se pudo ingresar la ruta correctamente");
        }
    }//GEN-LAST:event_calBtnRutaActionPerformed

    private void calBtnRealizadaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnRealizadaNoActionPerformed
        calPanRuta.setVisible(false);
    }//GEN-LAST:event_calBtnRealizadaNoActionPerformed

    private void calBtnRealizadaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnRealizadaSiActionPerformed
        if (calComboTipo.getSelectedIndex() == 0) {
            calPanRuta.setVisible(true);
        } else {
            calPanRuta.setVisible(false);
        }
    }//GEN-LAST:event_calBtnRealizadaSiActionPerformed

    private void calBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnEditarActionPerformed
        calLstActividades.setEnabled(false);
        String nombreAct = calLstActividades.getSelectedValue();
        Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
        calBtnVeterinariaNo.setSelected(true);
        calBtnVeterinariaNoActionPerformed(evt);
        calBtnGroupRealizada.clearSelection();
        calBtnRealizadaNo.setSelected(true);
        if (paseo != null) {
            if (paseo.getFueRealizado()) {
                calBtnRealizadaSi.setSelected(true);
            }
            calPanRuta.setVisible(true);
            calComboTipo.setSelectedIndex(0);
            if (paseo.getFueRealizado()) {
                calPanRuta.setVisible(true);
            }
            if (paseo.getRuta() == null) {
                calBtnVerRuta.setVisible(false);
            }
            calTxtNombreResp.setText(nombreAct);
            calComboUsuario.setSelectedItem(paseo.getUsuario().getNombre());
            calComboPerro.setSelectedItem(paseo.getMascota().getNombre());
            calLblFechaResp.setText(paseo.getFecha().getDia() + "/" + 
                    paseo.getFecha().getMes() + "/" + paseo.getFecha().getAno());
            calComboHora.setSelectedIndex(1);
            int hora = paseo.getHora().getHour();
            String horaString = "" + hora;
            if (hora < 10) {
                horaString = "0" + horaString;
            }
            calPanSpinHora.setValue((Object) horaString);
            calPanSpinMinutos.setValue(paseo.getHora().getMinute());
            sistema.eliminarActividad(paseo);
            sistema.getPaseos().remove(paseo);
        } else {
            Alimentacion alim = sistema.buscarAlimentacionPorNombre(nombreAct);
            if (alim != null) {
                if (alim.getFueRealizado()) {
                    calBtnRealizadaSi.setSelected(true);
                }
                calComboTipo.setSelectedIndex(1);
                calTxtNombreResp.setText(nombreAct);
                calComboUsuario.setSelectedItem(alim.getUsuario().getNombre());
                calComboPerro.setSelectedItem(alim.getMascota().getNombre());
                calLblFechaResp.setText(alim.getFecha().getDia() + "/" + alim
                        .getFecha().getMes() + "/" + alim.getFecha().getAno());
                calComboHora.setSelectedIndex(1);
                int hora = alim.getHora().getHour();
                String horaString = "" + hora;
                if (hora < 10) {
                    horaString = "0" + horaString;
                }
                calPanSpinHora.setValue((Object) horaString);
                calPanSpinMinutos.setValue(alim.getHora().getMinute());
                calTxtTipoAlimento.setText(alim.getTipoAlimento());
                calTxtTipoAlimento.setVisible(true);
                sistema.eliminarActividad(alim);
                sistema.getAlimentaciones().remove(alim);
            } else {
                VisitaVeterinaria visita = sistema.buscarVisitaPorNombre(nombreAct);
                if (visita != null) {
                    if (visita.getFueRealizado()) {
                        calBtnRealizadaSi.setSelected(true);
                    }
                    calComboTipo.setSelectedIndex(2);
                    calTxtNombreResp.setText(nombreAct);
                    calComboUsuario.setSelectedItem(visita.getUsuario().getNombre());
                    calComboPerro.setSelectedItem(visita.getMascota().getNombre());
                    calLblFechaResp.setText(visita.getFecha().getDia() + "/" + 
                            visita.getFecha().getMes() + "/" + visita.getFecha()
                                    .getAno());
                    calComboHora.setSelectedIndex(1);
                    int hora = visita.getHora().getHour();
                    String horaString = "" + hora;
                    if (hora < 10) {
                        horaString = "0" + horaString;
                    }
                    calPanSpinHora.setValue((Object) horaString);
                    calPanSpinMinutos.setValue(visita.getHora().getMinute());
                    calBtnVeterinariaSi.setSelected(true);
                    calComboVeterinaria.setSelectedItem(visita.getVeterinaria()
                            .getNombre());
                    calComboMotivo.setSelectedItem(visita.getMotivo());
                    calPanVeterinaria.setVisible(true);
                    calLblHorarios.setVisible(true);
                    visita.getVeterinaria().getActividadesAgendadas()
                            .remove(visita);
                    sistema.eliminarActividad(visita);
                    sistema.getVisitas().remove(visita);
                } else {
                    ActividadCualquiera actividad = sistema
                            .buscarActCualquieraPorNombre(nombreAct);
                    if (actividad.getFueRealizado()) {
                        calBtnRealizadaSi.setSelected(true);
                    }
                    calComboTipo.setSelectedIndex(2);
                    calTxtNombreResp.setText(nombreAct);
                    calComboUsuario.setSelectedItem(actividad.getUsuario()
                            .getNombre());
                    calComboPerro.setSelectedItem(actividad.getMascota()
                            .getNombre());
                    calLblFechaResp.setText(actividad.getFecha().getDia() + "/" 
                            + actividad.getFecha().getMes() + "/" 
                            + actividad.getFecha().getAno());
                    calComboHora.setSelectedIndex(1);
                    int hora = actividad.getHora().getHour();
                    String horaString = "" + hora;
                    if (hora < 10) {
                        horaString = "0" + horaString;
                    }
                    calPanSpinHora.setValue((Object) horaString);
                    calPanSpinMinutos.setValue(actividad.getHora().getMinute());
                    calTxtTipoAlimento.setVisible(true);
                    sistema.eliminarActividad(actividad);
                    sistema.getActsCualquieras().remove(actividad);
                }
            }
        }
        calLblAdvertencia.setText("Edite la actividad y agreguela");
        calBtnEditar.setVisible(false);
    }//GEN-LAST:event_calBtnEditarActionPerformed

    private void calTxtTipoAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calTxtTipoAlimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calTxtTipoAlimentoActionPerformed

    private void calComboVeterinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calComboVeterinariaActionPerformed
        Veterinaria vet = sistema.buscarVetPorNombre((String) calComboVeterinaria
                .getSelectedItem());
        calLblHorarios.setVisible(true);
        calLblHorarios.setText("Horarios: " + vet.getHoraInicial() + " - " + 
                vet.getHoraFinal());
    }//GEN-LAST:event_calComboVeterinariaActionPerformed

    private void calBtnVeterinariaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnVeterinariaNoActionPerformed
        calComboVeterinaria.setVisible(false);
        calComboMotivo.setVisible(false);
        calLblMotivo.setVisible(false);
        calLblHorarios.setVisible(false);
    }//GEN-LAST:event_calBtnVeterinariaNoActionPerformed

    private void calBtnVeterinariaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnVeterinariaSiActionPerformed
        calComboVeterinaria.setVisible(true);
        calComboMotivo.setVisible(true);
        calLblMotivo.setVisible(true);
        calLblHorarios.setVisible(true);
    }//GEN-LAST:event_calBtnVeterinariaSiActionPerformed

    private void calTxtNombreRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calTxtNombreRespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calTxtNombreRespActionPerformed

    private void calComboHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calComboHoraActionPerformed
        if (calComboHora.getSelectedIndex() == 0) {
            calPanHoraPersonalizada.setVisible(false);
        } else {
            calPanHoraPersonalizada.setVisible(true);
        }
    }//GEN-LAST:event_calComboHoraActionPerformed

    private void calComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calComboTipoActionPerformed
        if (calComboTipo.getSelectedIndex() == 2) {
            if (calBtnVeterinariaSi.isSelected()) {
                cambiarVisibilidadVeterinaria(true, true);
            } else {
                cambiarVisibilidadVeterinaria(true, false);
            }
        } else {
            cambiarVisibilidadVeterinaria(false, false);
        }
        if (calComboTipo.getSelectedIndex() == 1) {
            calLblTipoAlimento.setVisible(true);
            calTxtTipoAlimento.setVisible(true);
        } else {
            calLblTipoAlimento.setVisible(false);
            calTxtTipoAlimento.setVisible(false);
            calTxtTipoAlimento.setText("");
        }
        if (calComboTipo.getSelectedIndex() == 0 && calBtnRealizadaSi.isSelected()) {
            calPanRuta.setVisible(true);
        } else {
            calPanRuta.setVisible(false);
        }
    }//GEN-LAST:event_calComboTipoActionPerformed

    private void btnGuardarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActividadActionPerformed
        String nombreAct = calTxtNombreResp.getText();
        boolean fueRealizada = !calBtnRealizadaNo.isSelected();
        
        if (nombreAct.equals("")) {
            calLblAdvertencia.setText("No se ingresó un nombre, ingrese el nombre de la actividad.");
        } else if (calComboUsuario.getItemCount() == 0) {
            calLblAdvertencia.setText("Por favor, ingrese un usuario para agregar una actividad.");
        } else if (calComboPerro.getItemCount() == 0) {
            calLblAdvertencia.setText("Por favor, ingrese un perro para agregar una actividad.");
        } else {
            Usuario usuario = sistema.buscarUsuarioPorNombre((String) calComboUsuario.getSelectedItem());
            Mascota mascota = sistema.buscarMascotaPorNombre((String) calComboPerro.getSelectedItem());
            LocalTime time;
            if (((String) calComboHora.getSelectedItem()).equals("Ahora")) {
                time = LocalTime.now();
            } else {
                String hora = calPanSpinHora.getValue() + "";
                String min = calPanSpinMinutos.getValue() + "";
                time = LocalTime.of(Integer.parseInt(hora), Integer.parseInt(min));
            }
            if (calBtnVeterinariaSi.isSelected()) {
                Veterinaria vet = sistema.buscarVetPorNombre((String) calComboVeterinaria.getSelectedItem());
                String motivo = (String) calComboMotivo.getSelectedItem();
                VisitaVeterinaria visita = new VisitaVeterinaria(nombreAct, time, 
                        usuario, mascota, fueRealizada, fechaSeleccionada, vet, motivo);
                if (vet.agendarActividad(visita)) {
                    sistema.anadirActividad(visita);
                    sistema.getVisitas().add(visita);
                    if (calComboHora.getSelectedIndex() != 0) {
                        timerNuevo(visita);
                    }
                    calLblAdvertencia.setText("Se agrego la visita a la veterinaria con éxito");
                    calLstActividades.setEnabled(true);
                    calBtnEditar.setVisible(false);
                    calTxtNombreResp.setText("");
                    calPanVeterinaria.setVisible(false);
                    calLblHorarios.setVisible(false);
                } else {
                    calLblAdvertencia.setText("La veterinaria no tiene horarios disponibles en ese horario, por favor ingrse una "
                            + "hora distinta entre las " + vet.getHoraInicial() + " y las " + vet.getHoraFinal());
                }
            } else {
                String tipoAct = (String) calComboTipo.getSelectedItem();
                if (tipoAct.equals("Paseo")) {
                    Paseo paseo = new Paseo(nombreAct, usuario, mascota, 0, fueRealizada, time, fechaSeleccionada);
                    double distanciaPaseo = Double.parseDouble(calSpinDistancia.getValue().toString());
                    if (distanciaPaseo != 0.0) {
                        paseo.setDistancia(distanciaPaseo);
                    }
                    sistema.anadirActividad(paseo);
                    sistema.getPaseos().add(paseo);
                    if (calComboHora.getSelectedIndex() != 0) {
                        timerNuevo(paseo);
                    }
                    if (!rutaImagenRuta.equals("")) {
                        File imagen = new File(rutaImagenRuta);
                        paseo.setRuta(crearIcono(imagen, 500));
                        rutaImagenRuta = "";
                    }
                    calLblAdvertencia.setText("Se añadió el paseo correctamente al calendario");
                    calLstActividades.setEnabled(true);
                    calTxtNombreResp.setText("");
                    calBtnEditar.setVisible(false);
                    calPanRuta.setVisible(false);
                } else {
                    if (tipoAct.equals("Alimentación")) {
                        String tipoAlimento = calTxtTipoAlimento.getText();
                        if (tipoAlimento.equals("")) {
                            calLblAdvertencia.setText("No se ingresó el tipo del alimento, ingrse el tipo del alimento");
                        } else {
                            Alimentacion alim = new Alimentacion(nombreAct, usuario, mascota, tipoAlimento, fueRealizada, time, fechaSeleccionada);
                            sistema.anadirActividad(alim);
                            sistema.getAlimentaciones().add(alim);
                            if (calComboHora.getSelectedIndex() != 0) {
                                timerNuevo(alim);
                            }
                            calLblAdvertencia.setText("Se añadió la alimentación correctamente al calendario");
                            calTxtNombreResp.setText("");
                            calTxtTipoAlimento.setText("");
                            calBtnEditar.setVisible(false);
                            calLstActividades.setEnabled(true);
                        }
                    } else {
                        ActividadCualquiera actividad = new ActividadCualquiera(nombreAct, usuario, mascota, fueRealizada, time, fechaSeleccionada);
                        sistema.anadirActividad(actividad);
                        sistema.getActsCualquieras().add(actividad);
                        if (calComboHora.getSelectedIndex() != 0) {
                            timerNuevo(actividad);
                        }
                        calLblAdvertencia.setText("Se añadió la actividad correctamente al calendario");
                        calTxtNombreResp.setText("");
                        calBtnEditar.setVisible(false);
                        calLstActividades.setEnabled(true);
                    }
                }
            }
        }
        calPanRuta.setVisible(false);
        int dia = calDayChooser.getDay();
        int mes = calMonthChooser.getMonth() + 1;
        int ano = calYearChooser.getYear();
        ArrayList<Actividad> listaActividades = sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        calLstActividades.setListData(arrActividades);

        calLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_btnGuardarActividadActionPerformed

    private void calLstActividadesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_calLstActividadesValueChanged
        String nombreAct = calLstActividades.getSelectedValue();
        String cero = "";
        calBtnVerRuta.setVisible(false);
        if (nombreAct != null) {
            Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
            if (paseo != null) {
                calBtnVerRuta.setVisible(true);
                if (paseo.getHora().getMinute() < 10) {
                    cero = "0";
                }
                String fueRealizada = "No";
                if (paseo.getFueRealizado()) {
                    fueRealizada = "Si";
                }
                if (paseo.getDistancia() == 0.0) {
                    calTxtAreaInfoAct.setText("Nombre: " + paseo.getNombre() + "\n"
                            + "Usuario responsable: " + paseo.getUsuario().getNombre() + "\n"
                            + "Mascota: " + paseo.getMascota().getNombre() + "\n"
                            + "Realizada: " + fueRealizada + "\n"
                            + "Hora: " + paseo.getHora().getHour() + ":" + cero + paseo.getHora().getMinute());
                } else {
                    calTxtAreaInfoAct.setText("Nombre: " + paseo.getNombre() + "\n"
                            + "Usuario responsable: " + paseo.getUsuario().getNombre() + "\n"
                            + "Mascota: " + paseo.getMascota().getNombre() + "\n"
                            + "Realizada: " + fueRealizada + "\n"
                            + "Hora: " + paseo.getHora().getHour() + ":" + cero + paseo.getHora().getMinute() + "\n"
                            + "Distancia: " + paseo.getDistancia() + "kilómetros");
                }
            } else {
                Alimentacion alim = sistema.buscarAlimentacionPorNombre(nombreAct);
                if (alim != null) {
                    if (alim.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    String fueRealizada = "No";
                    if (alim.getFueRealizado()) {
                        fueRealizada = "Si";
                    }

                    calTxtAreaInfoAct.setText("Nombre: " + alim.getNombre() + "\n"
                            + "Usuario responsable: " + alim.getUsuario().getNombre() + "\n"
                            + "Mascota: " + alim.getMascota().getNombre() + "\n"
                            + "Realizada: " + fueRealizada + "\n"
                            + "Tipo Alimento: " + alim.getTipoAlimento() + "\n"
                            + "Hora: " + alim.getHora().getHour() + ":" + cero + alim.getHora().getMinute());
                } else {
                    VisitaVeterinaria visita = sistema.buscarVisitaPorNombre(nombreAct);
                    if (visita != null) {
                        if (visita.getHora().getMinute() < 10) {
                            cero = "0";
                        }
                        String fueRealizada = "No";
                        if (visita.getFueRealizado()) {
                            fueRealizada = "Si";
                        }
                        calTxtAreaInfoAct.setText("Nombre: " + visita.getNombre() + "\n"
                                + "Usuario responsable: " + visita.getUsuario().getNombre() + "\n"
                                + "Mascota: " + visita.getMascota().getNombre() + "\n"
                                + "Realizada: " + fueRealizada + "\n"
                                + "Motivo: " + visita.getMotivo() + "\n"
                                + "Veterinaria: " + visita.getVeterinaria().getNombre() + "\n"
                                + "Hora: " + visita.getHora().getHour() + ":" + cero + visita.getHora().getMinute());
                    } else {
                        ActividadCualquiera act = sistema.buscarActCualquieraPorNombre(nombreAct);
                        if (act.getHora().getMinute() < 10) {
                            cero = "0";
                        }
                        String fueRealizada = "No";
                        if (act.getFueRealizado()) {
                            fueRealizada = "Si";
                        }

                        calTxtAreaInfoAct.setText("Nombre: " + act.getNombre() + "\n"
                                + "Usuario responsable: " + act.getUsuario().getNombre() + "\n"
                                + "Mascota: " + act.getMascota().getNombre() + "\n"
                                + "Realizada: " + fueRealizada + "\n"
                                + "Hora: " + act.getHora().getHour() + ":" + cero + act.getHora().getMinute());
                    }
                }
            }
            calBtnEditar.setVisible(true);
        } else {
            calTxtAreaInfoAct.setText("Seleccione un paseo para" + "\n"
                    + "poder ver su información");
        }
    }//GEN-LAST:event_calLstActividadesValueChanged

    private void calDayChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calDayChooserPropertyChange
        int dia = calDayChooser.getDay();
        int mes = calMonthChooser.getMonth() + 1;
        int ano = calYearChooser.getYear();
        ArrayList<Actividad> listaActividades = sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        calLstActividades.setListData(arrActividades);

        calLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_calDayChooserPropertyChange

    private void calBtnVerRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnVerRutaActionPerformed
        String nombreAct = calLstActividades.getSelectedValue();
        Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
        if (paseo != null) {
            if (paseo.getRuta() != null) {
                try {
                    new VentanaFotoRuta(paseo).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                calLblAdvertencia.setText("No hay ruta agregada a este paseo");
            }
        }
    }//GEN-LAST:event_calBtnVerRutaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        Object nombreMascota = perroComboPerros.getSelectedItem();
        if(nombreMascota != null) {
            sistema.getMascotas().removeIf(perro -> perro.getNombre()
                    .equals(nombreMascota));
            resetearPestanaPerros();
            if(sistema.getMascotas().size() > 0) {
                perroComboPerros.setSelectedIndex(0);  
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void perroBtnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perroBtnExaminarActionPerformed
        JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        elegirImagen.setFileFilter(filter);
        int result = elegirImagen.showDialog(this, "Elija una imagen");
        if (result == JFileChooser.APPROVE_OPTION) {
            File imgSeleccionada = elegirImagen.getSelectedFile();
            rutaImagenAgregar = imgSeleccionada.getAbsolutePath();
            perroLblFoto.setIcon(crearIcono(imgSeleccionada, 100));
        } else {
            perroLblAdvertencia.setText("No se ha podido ingresar la imágen de forma correcta");
        }
    }//GEN-LAST:event_perroBtnExaminarActionPerformed

    private void perroTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perroTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perroTxtNombreActionPerformed

    private void cambiarVisibilidadVeterinaria(boolean opcionCombo, boolean usaVeterinaria) {
        calPanVeterinaria.setVisible(opcionCombo);
        calBtnVeterinariaSi.setSelected(usaVeterinaria);
        calBtnVeterinariaNo.setSelected(!usaVeterinaria);
        calComboVeterinaria.setVisible(usaVeterinaria);
        calComboMotivo.setVisible(usaVeterinaria);
        calLblMotivo.setVisible(usaVeterinaria);
        calLblHorarios.setVisible(opcionCombo);
    }

    private ImageIcon crearIcono(String ruta, int tamano) {
        ImageIcon retorno = null;
        try {
            retorno = new ImageIcon(ImageIO.read(getClass().getResource(ruta)).getScaledInstance(tamano, -1, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.out.println(e);
        }
        return retorno;
    }

    private ImageIcon crearIcono(File file, int tamano) {
        ImageIcon retorno = null;
        try {
            retorno = new ImageIcon(ImageIO.read(file).getScaledInstance(tamano, -1, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.out.println(e);
        }
        return retorno;
    }
    
    public void timerNuevo(final Actividad act) {
        int horaActividad = act.getHora().getHour() * 60 + act.getHora().getMinute();
        int horaActual = LocalTime.now().getHour() * 60 + LocalTime.now().getMinute();
        int tiempoRestanteMinutos = horaActividad - horaActual;
        try {
            ActionListener notificacion = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    mostrarNotificacion(act);
                }
            };
            int tiempoRestanteMilisegundos = tiempoRestanteMinutos * 60000;
            Timer timer = new Timer(tiempoRestanteMilisegundos, notificacion);
            timer.setRepeats(false);
            timer.start();
        } catch (ArithmeticException e) {

        }
    }

    public void mostrarNotificacion(Actividad actividad) {
        String nombreAct = actividad.getNombre();
        Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
        String cuerpo;
        String cero = "";
        if (paseo != null) {
            if (actividad.getHora().getMinute() < 10) {
                cero = "0";
            }
            cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                    + "Te recordamos que debes pasear a "
                    + actividad.getMascota().getNombre() + " hoy a las "
                    + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                    + "No lo olvides!";
        } else {
            Alimentacion alimentacion = sistema.buscarAlimentacionPorNombre(nombreAct);
            if (alimentacion != null) {
                if (actividad.getHora().getMinute() < 10) {
                    cero = "0";
                }
                cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                        + "Te recordamos que debes alimentar a "
                        + actividad.getMascota().getNombre() + " con " + alimentacion.getTipoAlimento()
                        + " hoy a las " + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                        + "No lo olvides!";
            } else {
                VisitaVeterinaria visita = sistema.buscarVisitaPorNombre(nombreAct);
                if (visita != null) {
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes llevar a "
                            + visita.getMascota().getNombre() + "a la veterinaria " + visita.getVeterinaria().getNombre()
                            + "para realizar un/una " + visita.getMotivo() + " hoy a las "
                            + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                } else {
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    ActividadCualquiera actividadCualquiera = sistema.buscarActCualquieraPorNombre(nombreAct);
                    cuerpo = "Hola " + actividadCualquiera.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes " + actividadCualquiera.getNombre() + " con "
                            + actividadCualquiera.getMascota().getNombre() + " hoy a las "
                            + actividadCualquiera.getHora().getHour() + ":" + cero + actividadCualquiera.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                }
            }
        }
        JFrame ventana = this;
        JOptionPane.showMessageDialog(ventana, cuerpo, "Notificación", 1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardarActividad;
    private javax.swing.JButton calBtnAgregarDatos;
    private javax.swing.JButton calBtnEditar;
    private javax.swing.ButtonGroup calBtnGroupRealizada;
    private javax.swing.ButtonGroup calBtnGroupRepetir;
    private javax.swing.ButtonGroup calBtnGroupVeterinaria;
    private javax.swing.JRadioButton calBtnRealizadaNo;
    private javax.swing.JRadioButton calBtnRealizadaSi;
    private javax.swing.JButton calBtnRuta;
    private javax.swing.JButton calBtnVerRuta;
    private javax.swing.JRadioButton calBtnVeterinariaNo;
    private javax.swing.JRadioButton calBtnVeterinariaSi;
    private javax.swing.JComboBox<String> calComboHora;
    private javax.swing.JComboBox<String> calComboMotivo;
    private javax.swing.JComboBox<String> calComboPerro;
    private javax.swing.JComboBox<String> calComboTipo;
    private javax.swing.JComboBox<String> calComboUsuario;
    private javax.swing.JComboBox<String> calComboVeterinaria;
    private com.toedter.calendar.JDayChooser calDayChooser;
    private javax.swing.JLabel calLblActividadesDelDia;
    private javax.swing.JLabel calLblAdvertencia;
    private javax.swing.JLabel calLblCentimetros;
    private javax.swing.JLabel calLblDistancia;
    private javax.swing.JLabel calLblFecha;
    private javax.swing.JLabel calLblFechaResp;
    private javax.swing.JLabel calLblHora;
    private javax.swing.JLabel calLblHorarios;
    private javax.swing.JLabel calLblInfoActividad;
    private javax.swing.JLabel calLblKilogramos;
    private javax.swing.JLabel calLblKilometros;
    private javax.swing.JLabel calLblMotivo;
    private javax.swing.JLabel calLblNombre;
    private javax.swing.JLabel calLblPerro;
    private javax.swing.JLabel calLblRealizada;
    private javax.swing.JLabel calLblRuta;
    private javax.swing.JLabel calLblTipo;
    private javax.swing.JLabel calLblTipoAlimento;
    private javax.swing.JLabel calLblTituloActividad;
    private javax.swing.JLabel calLblTituloFecha;
    private javax.swing.JLabel calLblUsuario;
    private javax.swing.JLabel calLblVeterinaria;
    private javax.swing.JList<String> calLstActividades;
    private com.toedter.calendar.JMonthChooser calMonthChooser;
    private javax.swing.JPanel calPanHoraPersonalizada;
    private javax.swing.JLabel calPanLblHora;
    private javax.swing.JLabel calPanLblMinutos;
    private javax.swing.JPanel calPanRuta;
    private javax.swing.JSpinner calPanSpinHora;
    private javax.swing.JSpinner calPanSpinMinutos;
    private javax.swing.JPanel calPanVeterinaria;
    private javax.swing.JScrollPane calScrollActividades;
    private javax.swing.JScrollPane calScrollInfoAct;
    private javax.swing.JSpinner calSpinDistancia;
    private javax.swing.JTextArea calTxtAreaInfoAct;
    private javax.swing.JTextField calTxtNombreResp;
    private javax.swing.JTextField calTxtTipoAlimento;
    private com.toedter.calendar.JYearChooser calYearChooser;
    private javax.swing.JComboBox<String> comboTipoMascota;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JPanel panCalendario;
    private javax.swing.JPanel panPerros;
    private javax.swing.JPanel panUsuarios;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JButton perroBtnAgregar;
    private javax.swing.JButton perroBtnEditar;
    private javax.swing.JButton perroBtnExaminar;
    private javax.swing.JButton perroBtnGuardar;
    private javax.swing.JComboBox<String> perroComboPerros;
    private javax.swing.JLabel perroLblAdvertencia;
    private javax.swing.JLabel perroLblAltura;
    private javax.swing.JLabel perroLblComentarios;
    private javax.swing.JLabel perroLblFoto;
    private javax.swing.JLabel perroLblFotoBoton;
    private javax.swing.JLabel perroLblNombre;
    private javax.swing.JLabel perroLblPerros;
    private javax.swing.JLabel perroLblPeso;
    private javax.swing.JPanel perroPanFoto;
    private javax.swing.JPanel perroPanInformacion;
    private javax.swing.JSpinner perroSpinAltura;
    private javax.swing.JSpinner perroSpinPeso;
    private javax.swing.JTextField perroTxtComentarios;
    private javax.swing.JTextField perroTxtNombre;
    private javax.swing.JButton usuarioBtnAgregar;
    private javax.swing.JComboBox<String> usuarioComboUsuarios;
    private javax.swing.JLabel usuarioLblActividad;
    private javax.swing.JLabel usuarioLblActividades;
    private javax.swing.JLabel usuarioLblAdvertencia;
    private javax.swing.JLabel usuarioLblFecha;
    private javax.swing.JLabel usuarioLblMail;
    private javax.swing.JLabel usuarioLblNombre;
    private javax.swing.JLabel usuarioLblUsuarios;
    private javax.swing.JList<String> usuarioLstActividades;
    private javax.swing.JList<String> usuarioLstFechas;
    private javax.swing.JScrollPane usuarioScrollActividades;
    private javax.swing.JScrollPane usuarioScrollFechas;
    private javax.swing.JTextField usuarioTxtMail;
    private javax.swing.JTextField usuarioTxtNombre;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    private javax.swing.JPanel panelPadrinos;
    // End of variables declaration//GEN-END:variables
}
