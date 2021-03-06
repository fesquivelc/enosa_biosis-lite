/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.reportes;

import algoritmo.AnalisisAsistencia;
import com.personal.utiles.FechaUtil;
import controladores.AsignacionHorarioControlador;
import controladores.DetalleGrupoControlador;
import controladores.EmpleadoControlador;
import controladores.GrupoHorarioControlador;
import controladores.PeriodoControlador;
import entidades.DetalleGrupoHorario;
import entidades.GrupoHorario;
import entidades.Periodo;
import com.personal.utiles.FormularioUtil;
import com.personal.utiles.ReporteUtil;
import controladores.HorarioControlador;
import controladores.MarcacionControlador;
import entidades.AsignacionHorario;
import entidades.escalafon.Departamento;
import entidades.Horario;
import entidades.Jornada;
import entidades.Marcacion;
import entidades.escalafon.Empleado;
import java.awt.Component;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;
import utiles.UsuarioActivo;
import vistas.dialogos.DlgOficina;
import vistas.reportes.beans.RTardanzaFaltaBean;

/**
 *
 * @author RyuujiMD
 */
public class RptTardanzasFaltas extends javax.swing.JInternalFrame {

    /**
     * Creates new form RptRegistroAsistencia
     */
    private final ReporteUtil reporteador;
    private final DateFormat dfFecha;
    private final EmpleadoControlador ec;
    private final HorarioControlador hc = new HorarioControlador();
    private final List<Horario> horarioList;
    private Horario horarioSeleccionado;

    public RptTardanzasFaltas() {
        initComponents();

        horarioList = hc.buscarTodos();
        ec = new EmpleadoControlador();
        pc = new PeriodoControlador();
        dfFecha = new SimpleDateFormat("dd/MM/yyyy");
        reporteador = new ReporteUtil();
//        FormularioUtil.modeloSpinnerFechaHora(spFechaInicio, "dd/MM/yyyy");
//        FormularioUtil.modeloSpinnerFechaHora(spFechaFin, "dd/MM/yyyy");
        inicializar();
        bindeoSalvaje();
        controles();
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

        grpSeleccion = new javax.swing.ButtonGroup();
        grpOpcion = new javax.swing.ButtonGroup();
        pnlEmpleados = new javax.swing.JPanel();
        radGrupo = new javax.swing.JRadioButton();
        cboGrupoHorario = new javax.swing.JComboBox();
        radOficina = new javax.swing.JRadioButton();
        txtOficina = new javax.swing.JTextField();
        btnOficina = new javax.swing.JButton();
        pnlBotones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        pnlTab = new javax.swing.JTabbedPane();
        pnlOpciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboHorario = new javax.swing.JComboBox();
        radFalta = new javax.swing.JRadioButton();
        radTardanza = new javax.swing.JRadioButton();
        grpSeleccion.add(radGrupo);
        grpSeleccion.add(radOficina);

        grpOpcion.add(radFalta);
        grpOpcion.add(radTardanza);

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("REPORTE DE TARDANZAS Y FALTAS EN EL DÍA");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección de empleados"));
        pnlEmpleados.setLayout(new java.awt.GridBagLayout());

        radGrupo.setSelected(true);
        radGrupo.setText("Por grupo horario:");
        radGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radGrupoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radGrupo, gridBagConstraints);

        cboGrupoHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboGrupoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGrupoHorarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlEmpleados.add(cboGrupoHorario, gridBagConstraints);

        radOficina.setText("Por oficina:");
        radOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radOficinaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radOficina, gridBagConstraints);

        txtOficina.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlEmpleados.add(txtOficina, gridBagConstraints);

        btnOficina.setText("...");
        btnOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOficinaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnlEmpleados.add(btnOficina, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(pnlEmpleados, gridBagConstraints);

        pnlBotones.setLayout(new java.awt.GridBagLayout());

        jButton2.setText("GENERAR REPORTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBotones.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(pnlBotones, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(pnlTab, gridBagConstraints);

        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Elección de horario"));
        pnlOpciones.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Horario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlOpciones.add(jLabel1, gridBagConstraints);

        cboHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlOpciones.add(cboHorario, gridBagConstraints);

        radFalta.setSelected(true);
        radFalta.setText("Faltas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlOpciones.add(radFalta, gridBagConstraints);

        radTardanza.setText("Tardanzas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlOpciones.add(radTardanza, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(pnlOpciones, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        imprimir();
    }//GEN-LAST:event_jButton2ActionPerformed

    private GrupoHorario grupoSeleccionado;
    private void cboGrupoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGrupoHorarioActionPerformed
        // TODO add your handling code here:
        obtenerGrupo();
    }//GEN-LAST:event_cboGrupoHorarioActionPerformed

    private void radGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radGrupoActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radGrupoActionPerformed

    private void radOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radOficinaActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radOficinaActionPerformed

    private void btnOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOficinaActionPerformed
        // TODO add your handling code here:
        DlgOficina oficinas = new DlgOficina(this);
        oficinaSeleccionada = oficinas.getSeleccionado();
        if (oficinaSeleccionada != null) {
            txtOficina.setText(oficinaSeleccionada.getNombre());

        }
    }//GEN-LAST:event_btnOficinaActionPerformed

    private Departamento oficinaSeleccionada;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOficina;
    private javax.swing.JComboBox cboGrupoHorario;
    private javax.swing.JComboBox cboHorario;
    private javax.swing.ButtonGroup grpOpcion;
    private javax.swing.ButtonGroup grpSeleccion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlEmpleados;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JTabbedPane pnlTab;
    private javax.swing.JRadioButton radFalta;
    private javax.swing.JRadioButton radGrupo;
    private javax.swing.JRadioButton radOficina;
    private javax.swing.JRadioButton radTardanza;
    private javax.swing.JTextField txtOficina;
    // End of variables declaration//GEN-END:variables

    private List<Empleado> empleadoList;
    private List<Periodo> periodoList;
    private final PeriodoControlador pc;

    private void inicializar() {
        JasperViewer jv = new JasperViewer(null);
        pnlTab.add("Vista previa", jv.getContentPane());
        empleadoList = ObservableCollections.observableList(new ArrayList<Empleado>());
        periodoList = pc.buscarTodosOrden();
        grupoList = gc.buscarTodos();
    }

    private void controles() {
//        FormularioUtil.activarComponente(chkMarcaciones, radDetallado.isSelected());

//        FormularioUtil.activarComponente(spFechaInicio, radPorFecha.isSelected());
//        FormularioUtil.activarComponente(spFechaFin, radPorFecha.isSelected());
//        FormularioUtil.activarComponente(cboMes, radMes.isSelected());
//        FormularioUtil.activarComponente(cboPeriodo1, radMes.isSelected());
//        FormularioUtil.activarComponente(cboPeriodo, radAnio.isSelected());
        FormularioUtil.activarComponente(cboGrupoHorario, radGrupo.isSelected());
//        FormularioUtil.activarComponente(btnOficina, radGrupo.isSelected());

        FormularioUtil.activarComponente(btnOficina, radOficina.isSelected());
    }

    private List<GrupoHorario> grupoList;

    private void bindeoSalvaje() {

        BindingGroup bindeo = new BindingGroup();

//        JComboBoxBinding binding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, periodoList, cboPeriodo);
//        JComboBoxBinding binding2 = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, periodoList, cboPeriodo1);
        JComboBoxBinding binding3 = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, grupoList, cboGrupoHorario);
        JComboBoxBinding binding2 = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, horarioList, cboHorario);

//        bindeo.addBinding(binding);
//        bindeo.addBinding(binding2);
        bindeo.addBinding(binding3);
        bindeo.addBinding(binding2);
        bindeo.bind();

        DefaultListCellRenderer renderGrupo = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    if (value instanceof GrupoHorario) {
                        value = ((GrupoHorario) value).getNombre();
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }

        };
        DefaultListCellRenderer renderHorario = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    if (value instanceof Horario) {
                        value = ((Horario) value).getNombre();
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }

        };
        DefaultListCellRenderer renderPeriodo = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    if (value instanceof Periodo) {
                        value = ((Periodo) value).getAnio();
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }

        };

//        cboPeriodo.setRenderer(renderPeriodo);
//        cboPeriodo1.setRenderer(renderPeriodo);
        cboGrupoHorario.setRenderer(renderGrupo);
        cboHorario.setRenderer(renderHorario);
    }
    private AnalisisAsistencia analisis = new AnalisisAsistencia();
    private final MarcacionControlador mc = new MarcacionControlador();
    private final AsignacionHorarioControlador ahc = new AsignacionHorarioControlador();

    private void imprimir() {
        horarioSeleccionado = horarioList.get(cboHorario.getSelectedIndex());
        Date fecha = FechaUtil.soloFecha(new Date());
//        List<String> tardanzas = new ArrayList<>();
        List<Date> marcaciones = new ArrayList<>();
        List<RTardanzaFaltaBean> tardanzas = new ArrayList<>();
        List<String> faltas = new ArrayList<>();
        if (fecha.compareTo(horarioSeleccionado.getFechaInicio()) >= 0
                && fecha.compareTo(horarioSeleccionado.getFechaFin()) <= 0) {
            
            
            
            Jornada jornada = horarioSeleccionado.getTurnoList().get(0).getJornada();

            //SE ANALIZA PERSONA A PERSONA HASTA OBTENER UN LISTADO =D
            List<AsignacionHorario> asignaciones = horarioSeleccionado.getAsignacionHorarioList();
            List<Empleado> empleados = dnis(asignaciones);
            for (Empleado empleado : empleados) {
                //comprobamos persona a persona si ha llegado tarde o a falta
                Marcacion marcacion;
//                System.out.println("EMPLEADO: "+ah.getEmpleado());

                marcacion = mc.buscarXFechaXhora(empleado, fecha, jornada.getDesdeHE(), jornada.getToleranciaHE());
                if (marcacion == null) {
                    //SE DISCERNIRA SI ESTA EN FALTA
                    marcacion = mc.buscarXFechaXhora(empleado, fecha, jornada.getToleranciaHE(), jornada.getTardanzaHE());

                    if (marcacion == null) {
                        if (radFalta.isSelected()) {
                            faltas.add(empleado.getNroDocumento());
                        }

                    } else if (radTardanza.isSelected()) {
                        Empleado e = marcacion.getEmpleado();
                        RTardanzaFaltaBean bean = new RTardanzaFaltaBean();
                        bean.setCodigoModular(e.getFichaLaboral().getCodigoTrabajador());
                        bean.setDocumentoIdentidad(e.getNroDocumento());
                        bean.setHoraMarcacion(marcacion.getHora());
                        bean.setNombre(e.getPaterno() + " " + e.getMaterno() + " " + e.getNombre());
                        tardanzas.add(bean);
                    }
                } else {
                    //NO PROBLEM
                }
            }

            boolean procede = false;
            if (faltas.isEmpty() && radFalta.isSelected()) {
                System.out.println("FALTA NO PROCEDE");
                JOptionPane.showMessageDialog(this, "No hay empleados con falta el día de hoy", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);

            } else if (radFalta.isSelected()) {
                System.out.println("FALTA PROCEDE");
                procede = true;
            }

            if (tardanzas.isEmpty() && radTardanza.isSelected()) {
                System.out.println("TARDANZAS NO PROCEDE");
                JOptionPane.showMessageDialog(this, "No hay empleados con tardanza el día de hoy", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);

            } else if (radTardanza.isSelected()) {
                System.out.println("TARDANZAS PROCEDE");
                procede = true;
            }

            System.out.println("PROCEDE: " + procede);
            if (procede) {

                String titulo = radTardanza.isSelected() ? "REPORTE DE TARDANZAS EN EL DÍA" : "REPORTE DE FALTAS EN EL DÍA";
                String rutaFichero;
                String usuario = UsuarioActivo.getUsuario().getLogin();
//                List<String> listado = radTardanza.isSelected() ? tardanzas : faltas;
                File ficheroReporte;
                Component comp;
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("usuario", usuario);
                parametros.put("titulo", titulo);
                if (radTardanza.isSelected()) {
                    rutaFichero = "reportes/r_tardanzas.jasper";
                    ficheroReporte = new File(rutaFichero);
                    comp = reporteador.obtenerReporte(tardanzas, ficheroReporte, parametros);
                } else {
                    rutaFichero = "reportes/r_tardanzas_faltas_dia.jasper";
                    ficheroReporte = new File(rutaFichero);
                    reporteador.setConn(ec.getDao().getConexion());

                    parametros.put("listado", faltas);
                    comp = reporteador.obtenerReporte(ficheroReporte, parametros);

                }

                pnlTab.removeTabAt(0);

                pnlTab.add("Vista previa", comp);
            }

        } else {
            JOptionPane.showMessageDialog(this, "El horario no se encuentra vigente", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    boolean bandera = false;

//    private List<String> obtenerDNI() {
//
//        List<String> lista = new ArrayList<>();
//        if (radGrupo.isSelected()) {
//            obtenerGrupo();
//            List<DetalleGrupoHorario> detalleGrupo = dgc.buscarXGrupo(grupoSeleccionado);
//            for (DetalleGrupoHorario detalle : detalleGrupo) {                
//                lista.add(detalle.getEmpleado());
//            }
//        } else if (radOficina.isSelected()) {
//            List<EmpleadoBiostar> empleadoBiostar = oficinaSeleccionada.getEmpleadoList();
//            List<Integer> dniInt = dniInteger(empleadoBiostar);
//            List<Empleado> empleados = ec.buscarPorListaEnteros(dniInt);
//            for (Empleado empleado : empleados) {
//                lista.add(empleado.getNroDocumento());
//            }
//        }
//        
//        List<AsignacionHorario> listado = ahc.buscarXEmpleado(lista, horarioSeleccionado);
//        lista.clear();
//        for(AsignacionHorario asignacion : listado){
//            lista.add(asignacion.getEmpleado());
//        }
//
//        return lista;
//    }

//    private List<Integer> dniInteger(List<EmpleadoBiostar> empleados) {
//        List<Integer> dni = new ArrayList<>();
//        for (EmpleadoBiostar e : empleados) {
//            dni.add(e.getId());
//        }
//        return dni;
//    }
//
//    public void agregarEmpleado(Empleado empleado) {
//        empleadoList.add(empleado);
//        tblTabla.packAll();
//    }

    private GrupoHorarioControlador gc = new GrupoHorarioControlador();
    private DetalleGrupoControlador dgc = new DetalleGrupoControlador();

    private void obtenerGrupo() {
        int seleccionado = cboGrupoHorario.getSelectedIndex();
        if (seleccionado != -1) {
            grupoSeleccionado = this.grupoList.get(seleccionado);
        }
    }

    private List<Empleado> dnis(List<AsignacionHorario> asignaciones) {
        List<Empleado> listado = new ArrayList<>();
        for (AsignacionHorario ah : asignaciones) {
            if (ah.isPorGrupo()) {
                List<DetalleGrupoHorario> detalles = ah.getGrupoHorario().getDetalleGrupoHorarioList();
                for (DetalleGrupoHorario detalle : detalles) {
                    listado.add(detalle.getEmpleado());
                }
            } else {
                listado.add(ah.getEmpleado());
            }
        }
        return listado;
    }
}
