/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Conexion.HibernateUtil;
import Entidad.ClsEntidadEmpleadoHib;
import Entidad.ClsEntidadMonedaHib;
import Negocio.*;
import java.math.BigDecimal;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.*;
import javax.swing.JDesktopPane;
import org.hibernate.Session;


public class FrmPrincipal extends javax.swing.JFrame {
   public int intEstado; 
   public String strUsuario; 
   public String strIdEmpleado;
   public String strNombreEmpleado;
   public String strTipo; 
   public String idAcceso;
   static ResultSet rs=null;
      private boolean mFullScreen = false;
   //---------------------Privilegios--------------------
    String p_venta,p_compra,p_producto,p_proveedor,p_empleado;
    String p_cliente,p_categoria,p_tipodoc,p_tipouser,p_anularv,p_anularc;
    String p_estadoprod,p_ventare,p_ventade,p_estadistica,p_comprare,p_comprade,p_pass,p_respaldar,p_restaurar,p_caja;
    String p_cuentas, p_descuento;
    //----------------------------------------------------
    
    private static FrmPrincipal instance = null;
    
    private ClsEntidadMonedaHib dolar;
    
    private final DecimalFormat decimalFormater = new DecimalFormat("#0.##");
    
    private ClsEntidadEmpleadoHib empleado;

    
   public FrmPrincipal() {
       
       instance = this;
       
        initComponents();
        JMIniciarSesion.setEnabled(false);
        
        Date date=new Date();
        String format=new String("dd/MM/yyyy");
        SimpleDateFormat formato=new SimpleDateFormat(format);
        lblFecha.setText(formato.format(date));
        //---------------------ANCHO Y ALTO DEL FORM----------------------
        //this.setSize(1024, 566);
        this.setExtendedState(MAXIMIZED_BOTH);
        //TODA LA PANTALLA
//    GraphicsEnvironment gEnv =
//                GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
//
//        setUndecorated(true);
//      setResizable(true);
      //Make it happen!
     // gDev.setFullScreenWindow(this);

            
        lblIdEmpleado.setVisible(false);
        lblUsuarioEmpleado.setVisible(false);
        lblEstado.setVisible(false);
        
        this.cargaTipoDeMonedaDefault();
   }
   
   public static FrmPrincipal getInstance(){
       return instance;
   }
   
   public String getPermisoDescuento(){
       return this.p_descuento;
   }
   
   public JDesktopPane getEscritorio(){
       return this.Escritorio;
   }

void BuscarPermisos(){
        String usuario=null;
        String tipo=null;
        int sen=1;int tu=1;
        usuario=strUsuario;
        tipo=strTipo;
        boolean encuentra=false;
    
            try{
                ClsTipoUsuario oTipoUsuario=new ClsTipoUsuario();
                
                rs= oTipoUsuario.consultarLoginPermisos(usuario,tipo);
                while (rs.next()&& sen==1) {
                    if(rs.getString(2).equals(strUsuario)&&rs.getString(3).equals(strTipo)) {
        
                            p_venta=rs.getString(4);
                            p_compra=rs.getString(5);
                            p_producto=rs.getString(6);
                            p_proveedor=rs.getString(7);
                            p_empleado=rs.getString(8);
                            p_cliente=rs.getString(9);
                            p_categoria=rs.getString(10);
                            p_tipodoc=rs.getString(11);
                            p_tipouser=rs.getString(12);
                            p_anularv=rs.getString(13);
                            p_anularc=rs.getString(14);
                            p_estadoprod=rs.getString(15);
                            p_ventare=rs.getString(16);
                            p_ventade=rs.getString(17);
                            p_estadistica=rs.getString(18);
                            p_comprare=rs.getString(19);
                            p_comprade=rs.getString(20);
                            p_pass=rs.getString(21);
                            p_respaldar=rs.getString(22);
                            p_restaurar=rs.getString(23);
                            p_caja=rs.getString(24);
                            p_cuentas=rs.getString(25);
                            p_descuento=rs.getString(26);
    
                            sen=2;
         
                    }
                   encuentra=true;
                   break;
                }
                if(sen==1) {
                    JOptionPane.showMessageDialog(this, "¡Código de Asistente no Registrado!");

                } else {
                              
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage());
                System.out.println(ex.getMessage());
            }        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        TBPrincipal = new javax.swing.JToolBar();
        mbtnEmpleado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mbtnCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        mbtnProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mbtnCompra = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        mbtnVenta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        mbtnCaja = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        mbtnEstado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblNombreEmpleado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblUsuarioEmpleado = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblIdEmpleado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTipoDeCambio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        JMIniciarSesion = new javax.swing.JMenuItem();
        JMCerrarSesion = new javax.swing.JMenuItem();
        JMSalir = new javax.swing.JMenuItem();
        mnuRegistro = new javax.swing.JMenu();
        mProducto = new javax.swing.JMenuItem();
        mCliente = new javax.swing.JMenuItem();
        mProveedor = new javax.swing.JMenuItem();
        mEmpleado = new javax.swing.JMenuItem();
        mnuOperaciones = new javax.swing.JMenu();
        mVenta = new javax.swing.JMenuItem();
        mCompra = new javax.swing.JMenuItem();
        mEstado = new javax.swing.JMenuItem();
        mnuInformes = new javax.swing.JMenu();
        mVentare = new javax.swing.JMenuItem();
        mVentade = new javax.swing.JMenuItem();
        mEstadistica = new javax.swing.JMenuItem();
        mComprare = new javax.swing.JMenuItem();
        mComprade = new javax.swing.JMenuItem();
        mnuMantenimiento = new javax.swing.JMenu();
        mCategoria = new javax.swing.JMenuItem();
        mTipodoc = new javax.swing.JMenuItem();
        mTipouser = new javax.swing.JMenuItem();
        mnuCuentas = new javax.swing.JMenu();
        mCuentas = new javax.swing.JMenuItem();
        mOperaciones = new javax.swing.JMenuItem();
        mGastosVarios = new javax.swing.JMenuItem();
        mnuAnulaciones = new javax.swing.JMenu();
        mAnularv = new javax.swing.JMenuItem();
        mAnularc = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        mCambiarpass = new javax.swing.JMenuItem();
        mCalculadora = new javax.swing.JMenuItem();
        mRespaldar = new javax.swing.JMenuItem();
        mRestaurar = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("La Casita Artesanal || Sistema de Ventas");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Escritorio.setBackground(new java.awt.Color(214, 232, 250));
        Escritorio.setAutoscrolls(true);
        getContentPane().add(Escritorio, java.awt.BorderLayout.CENTER);

        TBPrincipal.setRollover(true);

        mbtnEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/empleados_b.png"))); // NOI18N
        mbtnEmpleado.setText("Empleados");
        mbtnEmpleado.setFocusable(false);
        mbtnEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mbtnEmpleado.setPreferredSize(new java.awt.Dimension(55, 65));
        mbtnEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mbtnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnEmpleadoActionPerformed(evt);
            }
        });
        TBPrincipal.add(mbtnEmpleado);

        jLabel1.setText("   ");
        TBPrincipal.add(jLabel1);

        mbtnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cliente_b.png"))); // NOI18N
        mbtnCliente.setText("Clientes");
        mbtnCliente.setFocusable(false);
        mbtnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mbtnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mbtnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnClienteActionPerformed(evt);
            }
        });
        TBPrincipal.add(mbtnCliente);

        jLabel7.setText("   ");
        TBPrincipal.add(jLabel7);

        mbtnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/productos_b.png"))); // NOI18N
        mbtnProducto.setText("Productos");
        mbtnProducto.setFocusable(false);
        mbtnProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mbtnProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mbtnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnProductoActionPerformed(evt);
            }
        });
        TBPrincipal.add(mbtnProducto);

        jLabel2.setText("   ");
        TBPrincipal.add(jLabel2);

        mbtnCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/compra_b.png"))); // NOI18N
        mbtnCompra.setText("Compras");
        mbtnCompra.setFocusable(false);
        mbtnCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mbtnCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mbtnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnCompraActionPerformed(evt);
            }
        });
        TBPrincipal.add(mbtnCompra);

        jLabel3.setText("   ");
        TBPrincipal.add(jLabel3);

        mbtnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ventas_b.png"))); // NOI18N
        mbtnVenta.setText("Ventas");
        mbtnVenta.setFocusable(false);
        mbtnVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mbtnVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mbtnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnVentaActionPerformed(evt);
            }
        });
        TBPrincipal.add(mbtnVenta);

        jLabel4.setText("   ");
        TBPrincipal.add(jLabel4);

        mbtnCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/caja_b.png"))); // NOI18N
        mbtnCaja.setText("Caja");
        mbtnCaja.setFocusable(false);
        mbtnCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mbtnCaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mbtnCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnCajaActionPerformed(evt);
            }
        });
        TBPrincipal.add(mbtnCaja);

        jLabel6.setText("   ");
        TBPrincipal.add(jLabel6);

        mbtnEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estado_b.png"))); // NOI18N
        mbtnEstado.setText("Estado");
        mbtnEstado.setFocusable(false);
        mbtnEstado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mbtnEstado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mbtnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnEstadoActionPerformed(evt);
            }
        });
        TBPrincipal.add(mbtnEstado);

        getContentPane().add(TBPrincipal, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel8.setText("Nombre:");
        jPanel2.add(jLabel8);

        lblNombreEmpleado.setText("Nombres");
        jPanel2.add(lblNombreEmpleado);

        jLabel9.setText("Cargo:");
        jPanel2.add(jLabel9);

        lblTipo.setText("Tipo");
        jPanel2.add(lblTipo);

        jLabel10.setText("Fecha:");
        jPanel2.add(jLabel10);

        lblFecha.setText("Fecha");
        jPanel2.add(lblFecha);

        lblUsuarioEmpleado.setText("Usuario");
        jPanel2.add(lblUsuarioEmpleado);

        lblEstado.setText("Estado");
        jPanel2.add(lblEstado);

        lblIdEmpleado.setText("ID");
        jPanel2.add(lblIdEmpleado);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setText("Tipo de cambio (USD):");
        jPanel3.add(jLabel5);

        txtTipoDeCambio.setText("jTextField1");
        txtTipoDeCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoDeCambioActionPerformed(evt);
            }
        });
        jPanel3.add(txtTipoDeCambio);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        mnuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/folder.png"))); // NOI18N
        mnuArchivo.setText("Archivo");

        JMIniciarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        JMIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/connect.png"))); // NOI18N
        JMIniciarSesion.setText("Iniciar sesión");
        JMIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIniciarSesionActionPerformed(evt);
            }
        });
        mnuArchivo.add(JMIniciarSesion);

        JMCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        JMCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/disconnect.png"))); // NOI18N
        JMCerrarSesion.setText("Cerrar sesión");
        JMCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMCerrarSesionActionPerformed(evt);
            }
        });
        mnuArchivo.add(JMCerrarSesion);

        JMSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        JMSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/door_in.png"))); // NOI18N
        JMSalir.setText("Salir de la aplicación");
        JMSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(JMSalir);

        jMenuBar1.add(mnuArchivo);

        mnuRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/report_add.png"))); // NOI18N
        mnuRegistro.setText("Registro");

        mProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/productos_m.png"))); // NOI18N
        mProducto.setText("Producto");
        mProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mProductoActionPerformed(evt);
            }
        });
        mnuRegistro.add(mProducto);

        mCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cliente_m.png"))); // NOI18N
        mCliente.setText("Cliente");
        mCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mClienteActionPerformed(evt);
            }
        });
        mnuRegistro.add(mCliente);

        mProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/proveedores_m.png"))); // NOI18N
        mProveedor.setText("Proveedor");
        mProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mProveedorActionPerformed(evt);
            }
        });
        mnuRegistro.add(mProveedor);

        mEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/empleados_m.png"))); // NOI18N
        mEmpleado.setText("Empleado");
        mEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEmpleadoActionPerformed(evt);
            }
        });
        mnuRegistro.add(mEmpleado);

        jMenuBar1.add(mnuRegistro);

        mnuOperaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Operaciones.png"))); // NOI18N
        mnuOperaciones.setText("Operaciones");

        mVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        mVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ventas_m.png"))); // NOI18N
        mVenta.setText("Venta");
        mVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mVentaActionPerformed(evt);
            }
        });
        mnuOperaciones.add(mVenta);

        mCompra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        mCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/compra_m.png"))); // NOI18N
        mCompra.setText("Compra");
        mCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCompraActionPerformed(evt);
            }
        });
        mnuOperaciones.add(mCompra);

        mEstado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        mEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estado_m.png"))); // NOI18N
        mEstado.setText("Verificar Producto");
        mEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEstadoActionPerformed(evt);
            }
        });
        mnuOperaciones.add(mEstado);

        jMenuBar1.add(mnuOperaciones);

        mnuInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/report.png"))); // NOI18N
        mnuInformes.setText("Informes");

        mVentare.setText("Ventas y Cotizaciones");
        mVentare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mVentareActionPerformed(evt);
            }
        });
        mnuInformes.add(mVentare);

        mVentade.setText("Ventas Detalladas");
        mVentade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mVentadeActionPerformed(evt);
            }
        });
        mnuInformes.add(mVentade);

        mEstadistica.setText("Estadística Mensual");
        mEstadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEstadisticaActionPerformed(evt);
            }
        });
        mnuInformes.add(mEstadistica);

        mComprare.setText("Compras Realizadas");
        mComprare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mComprareActionPerformed(evt);
            }
        });
        mnuInformes.add(mComprare);

        mComprade.setText("Compras Detalladas");
        mComprade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCompradeActionPerformed(evt);
            }
        });
        mnuInformes.add(mComprade);

        jMenuBar1.add(mnuInformes);

        mnuMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Mantenimiento.png"))); // NOI18N
        mnuMantenimiento.setText("Mantenimiento");

        mCategoria.setText("Categoria");
        mCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCategoriaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mCategoria);

        mTipodoc.setText("Tipo de Documento");
        mTipodoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTipodocActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mTipodoc);

        mTipouser.setText("Tipo de Usuario");
        mTipouser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTipouserActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mTipouser);

        jMenuBar1.add(mnuMantenimiento);

        mnuCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/venta.png"))); // NOI18N
        mnuCuentas.setText("Cuentas");

        mCuentas.setText("Cuntas Bancarias y Caja");
        mCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCuentasActionPerformed(evt);
            }
        });
        mnuCuentas.add(mCuentas);

        mOperaciones.setText("Operaciones");
        mOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOperacionesActionPerformed(evt);
            }
        });
        mnuCuentas.add(mOperaciones);

        mGastosVarios.setText("Gastos Varios");
        mGastosVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGastosVariosActionPerformed(evt);
            }
        });
        mnuCuentas.add(mGastosVarios);

        jMenuBar1.add(mnuCuentas);

        mnuAnulaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/anular.png"))); // NOI18N
        mnuAnulaciones.setText("Anulaciones");

        mAnularv.setText("Anular Venta");
        mAnularv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAnularvActionPerformed(evt);
            }
        });
        mnuAnulaciones.add(mAnularv);

        mAnularc.setText("Anular Compra");
        mAnularc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAnularcActionPerformed(evt);
            }
        });
        mnuAnulaciones.add(mAnularc);

        jMenuBar1.add(mnuAnulaciones);

        mnuHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cog.png"))); // NOI18N
        mnuHerramientas.setText("Herramientas");

        mCambiarpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/group_key.png"))); // NOI18N
        mCambiarpass.setText("Cambiar contraseña");
        mCambiarpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCambiarpassActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mCambiarpass);

        mCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/calculator.png"))); // NOI18N
        mCalculadora.setText("Calculadora");
        mCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCalculadoraActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mCalculadora);

        mRespaldar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/database_save.png"))); // NOI18N
        mRespaldar.setText("Respaldar BD");
        mRespaldar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRespaldarActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mRespaldar);

        mRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/database_refresh.png"))); // NOI18N
        mRestaurar.setText("Restaurar BD");
        mRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRestaurarActionPerformed(evt);
            }
        });
        mnuHerramientas.add(mRestaurar);

        jMenuBar1.add(mnuHerramientas);

        mnuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/help.png"))); // NOI18N
        mnuAyuda.setText("Ayuda");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/help.png"))); // NOI18N
        jMenuItem1.setText("Ayuda");
        mnuAyuda.add(jMenuItem1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/comment.png"))); // NOI18N
        jMenuItem5.setText("Acerca de...");
        mnuAyuda.add(jMenuItem5);

        jMenuBar1.add(mnuAyuda);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1040, 604));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        BuscarPermisos();
        lblEstado.setText("Desconectado");
        if(intEstado==1){
            lblIdEmpleado.setText(strIdEmpleado);
            lblNombreEmpleado.setText(strNombreEmpleado);            
            lblUsuarioEmpleado.setText(strUsuario);
            lblTipo.setText(strTipo);
            lblEstado.setText("Conectado");
        }
        if(lblEstado.getText().equals("Desconectado")){
            mnuArchivo.setVisible(false);
            mnuMantenimiento.setVisible(false);
            TBPrincipal.setVisible(false);    
        }
         if(lblUsuarioEmpleado.getText().equals("Coordinador")){
            mnuRegistro.setVisible(false);
            mnuMantenimiento.setVisible(false);
            
          
        }
         
  //-------------------BLOQUEAR SERVICIOS DEL SISTEMA----------------
    if (p_venta.equals("1")){
        mVenta.setEnabled(true);
        mbtnVenta.setEnabled(true);
    }else{
        mVenta.setEnabled(false);
        mbtnVenta.setEnabled(false);
    }
    if (p_compra.equals("1")){
        mCompra.setEnabled(true);
        mbtnCompra.setEnabled(true);
    }else{
        mCompra.setEnabled(false);
        mbtnCompra.setEnabled(false);
    }
    if (p_producto.equals("1")){
        mProducto.setEnabled(true);
        mbtnProducto.setEnabled(true);
    }else{
        mProducto.setEnabled(false);
        mbtnProducto.setEnabled(false);
    }
    if (p_proveedor.equals("1")){
        mProveedor.setEnabled(true);
    }else{
        mProveedor.setEnabled(false);
    }
    if (p_empleado.equals("1")){
        mEmpleado.setEnabled(true);
        mbtnEmpleado.setEnabled(true);
    }else{
        mEmpleado.setEnabled(false);
        mbtnEmpleado.setEnabled(false);
    }
    if (p_cliente.equals("1")){
        mCliente.setEnabled(true);
        mbtnCliente.setEnabled(true);
    }else{
        mCliente.setEnabled(false);
        mbtnCliente.setEnabled(false);
    }
    if (p_categoria.equals("1")){
        mCategoria.setEnabled(true);
    }else{
        mCategoria.setEnabled(false);
    }
    if (p_tipodoc.equals("1")){
        mTipodoc.setEnabled(true);
    }else{
        mTipodoc.setEnabled(false);
    }
    if (p_tipouser.equals("1")){
        mTipouser.setEnabled(true);
    }else{
        mTipouser.setEnabled(false);
    }    
    if (p_anularv.equals("1")){
        mAnularv.setEnabled(true);
    }else{
        mAnularv.setEnabled(false);
    }  
    if (p_anularc.equals("1")){
        mAnularc.setEnabled(true);
    }else{
        mAnularc.setEnabled(false);
    }  
    if (p_estadoprod.equals("1")){
        mEstado.setEnabled(true);
        mbtnEstado.setEnabled(true);
    }else{
        mEstado.setEnabled(false);
        mbtnEstado.setEnabled(false);
    }  
    if (p_ventare.equals("1")){
        mVentare.setEnabled(true);
    }else{
        mVentare.setEnabled(false);
    }  
    if (p_ventade.equals("1")){
        mVentade.setEnabled(true);
    }else{
        mVentade.setEnabled(false);
    }  
    if (p_estadistica.equals("1")){
        mEstadistica.setEnabled(true);
    }else{
        mEstadistica.setEnabled(false);
    }  
    if (p_comprare.equals("1")){
        mComprare.setEnabled(true);
    }else{
        mComprare.setEnabled(false);
    }  
    if (p_comprade.equals("1")){
        mComprade.setEnabled(true);
    }else{
        mComprade.setEnabled(false);
    }  
    if (p_pass.equals("1")){
        mCambiarpass.setEnabled(true);
    }else{
        mCambiarpass.setEnabled(false);
    }  
    if (p_respaldar.equals("1")){
        mRespaldar.setEnabled(true);
    }else{
        mRespaldar.setEnabled(false);
    } 
    if (p_restaurar.equals("1")){
        mRestaurar.setEnabled(true);
    }else{
        mRestaurar.setEnabled(false);
    } 
    if (p_caja.equals("1")){
        mbtnCaja.setEnabled(true);
    }else{
        mbtnCaja.setEnabled(false);
    }
    if (p_cuentas.equals("1")){
        mnuCuentas.setEnabled(true);
        mCuentas.setEnabled(true);
    }else{
        //mnuCuentas.setEnabled(false);
        mCuentas.setEnabled(false);
    }
    }//GEN-LAST:event_formComponentShown

    private void mCambiarpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCambiarpassActionPerformed
        Presentacion.FrmCambiarContraseña Cambiar=new Presentacion.FrmCambiarContraseña();
        Escritorio.add(Cambiar);
        Cambiar.show();
        Cambiar.IdEmpleado=lblIdEmpleado.getText();
       
    }//GEN-LAST:event_mCambiarpassActionPerformed

    private void JMSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMSalirActionPerformed
//        ClsAcceso acceso = new ClsAcceso();
//        acceso.modificarAcceso(idAcceso);
//        int slir = JOptionPane.showConfirmDialog(this, "¿Desea realmente cerrar la aplicación?","Mensaje del Sistema WorldEvent",0,3);
//        if(slir==JOptionPane.OK_OPTION)
//        {
//            System.exit(0);
//        }
        
    }//GEN-LAST:event_JMSalirActionPerformed

    private void mVentadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mVentadeActionPerformed
       Consultas.FrmVentasRealizadas_Detallado ventasdetalladas=new Consultas.FrmVentasRealizadas_Detallado();
       Escritorio.add(ventasdetalladas);
       ventasdetalladas.show(); 
    }//GEN-LAST:event_mVentadeActionPerformed

    private void mVentareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mVentareActionPerformed
       Consultas.FrmVentasRealizadas VentasRealizadas=new Consultas.FrmVentasRealizadas();
       Escritorio.add(VentasRealizadas);
       VentasRealizadas.show();
    }//GEN-LAST:event_mVentareActionPerformed

    private void mComprareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mComprareActionPerformed
       Consultas.FrmComprasRelizadas ComprasRelizadas=new Consultas.FrmComprasRelizadas();
       Escritorio.add(ComprasRelizadas);
       ComprasRelizadas.show();
    }//GEN-LAST:event_mComprareActionPerformed

    private void mRespaldarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRespaldarActionPerformed
        Backup.FrmRespaldarDB Respaldar=new Backup.FrmRespaldarDB();
        Escritorio.add(Respaldar);
        Respaldar.show();
    }//GEN-LAST:event_mRespaldarActionPerformed

    private void mRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRestaurarActionPerformed
        Backup.FrmRestaurarDB Restaurar=new Backup.FrmRestaurarDB();
        Escritorio.add(Restaurar);
        Restaurar.show();
    }//GEN-LAST:event_mRestaurarActionPerformed

    private void mCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCalculadoraActionPerformed
        try
        {
            Runtime obj = Runtime.getRuntime();
            obj.exec("C:\\WINDOWS\\system32\\CALC.EXE");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_mCalculadoraActionPerformed

    private void JMIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIniciarSesionActionPerformed
        this.dispose();
        Presentacion.FrmLogin Login=new Presentacion.FrmLogin();

        Login.show();



    }//GEN-LAST:event_JMIniciarSesionActionPerformed

    private void JMCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMCerrarSesionActionPerformed
        JMCerrarSesion.setEnabled(false);
        mnuRegistro.setEnabled(false);
        mnuOperaciones.setEnabled(false);
        mnuMantenimiento.setEnabled(false);
        mnuInformes.setEnabled(false);
        mnuHerramientas.setEnabled(false);
        mnuAnulaciones.setEnabled(false);
        TBPrincipal.setEnabled(false);
        mbtnEmpleado.setEnabled(false);
        mbtnCliente.setEnabled(false);
        mbtnProducto.setEnabled(false);
        mbtnCompra.setEnabled(false);
        mbtnVenta.setEnabled(false);
        mbtnCaja.setEnabled(false);
        mbtnEstado.setEnabled(false);
        mnuCuentas.setEnabled(false);
        JMIniciarSesion.setEnabled(true);
        
    }//GEN-LAST:event_JMCerrarSesionActionPerformed

    private void mCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCategoriaActionPerformed
        Presentacion.FrmCategoria Categoria=new Presentacion.FrmCategoria();
        Escritorio.add(Categoria);
        Categoria.show();
    }//GEN-LAST:event_mCategoriaActionPerformed

    private void mClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mClienteActionPerformed
        Presentacion.FrmCliente Cliente=new Presentacion.FrmCliente();
        Escritorio.add(Cliente);
        Cliente.show();
    }//GEN-LAST:event_mClienteActionPerformed

    private void mProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProveedorActionPerformed
        Presentacion.FrmProveedor Proveedor=new Presentacion.FrmProveedor();
        Escritorio.add(Proveedor);
        Proveedor.show();
    }//GEN-LAST:event_mProveedorActionPerformed

    private void mTipodocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTipodocActionPerformed
        Presentacion.FrmTipoDocumento Documento=new Presentacion.FrmTipoDocumento();
        Escritorio.add(Documento);
        Documento.show();
    }//GEN-LAST:event_mTipodocActionPerformed

    private void mTipouserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTipouserActionPerformed
        Presentacion.FrmTipoUsuario Usuario=new Presentacion.FrmTipoUsuario();
        Escritorio.add(Usuario);
        Usuario.show();
    }//GEN-LAST:event_mTipouserActionPerformed

    private void mProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProductoActionPerformed
        Presentacion.FrmProducto Producto=new Presentacion.FrmProducto();
        Escritorio.add(Producto);
        Producto.show();
    }//GEN-LAST:event_mProductoActionPerformed

    private void mVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mVentaActionPerformed
      
        Presentacion.FrmVenta venta=new Presentacion.FrmVenta();
        Escritorio.add(venta);
        venta.show();
        //venta.IdEmpleado=lblIdEmpleado.getText();
        venta.NombreEmpleado=lblNombreEmpleado.getText();

    }//GEN-LAST:event_mVentaActionPerformed

    private void mCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCompraActionPerformed
        Presentacion.FrmCompra compra=new Presentacion.FrmCompra();
        Escritorio.add(compra);
        compra.show();
        compra.IdEmpleado=lblIdEmpleado.getText();
        compra.NombreEmpleado=lblNombreEmpleado.getText();
    }//GEN-LAST:event_mCompraActionPerformed

    private void mEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEmpleadoActionPerformed
        Presentacion.FrmEmpleado Empleado=new Presentacion.FrmEmpleado();
        Escritorio.add(Empleado);
        Empleado.show();
    }//GEN-LAST:event_mEmpleadoActionPerformed

    private void mEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEstadoActionPerformed
        Presentacion.FrmProductoEstado ProductoEstado=new Presentacion.FrmProductoEstado();
        Escritorio.add(ProductoEstado);
        ProductoEstado.show();
    }//GEN-LAST:event_mEstadoActionPerformed

    private void mAnularvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAnularvActionPerformed
        Presentacion.FrmAnularVenta AnularVenta=new Presentacion.FrmAnularVenta();
        Escritorio.add(AnularVenta);
        AnularVenta.show();
    }//GEN-LAST:event_mAnularvActionPerformed

    private void mAnularcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAnularcActionPerformed
        Presentacion.FrmAnularCompra AnularCompra=new Presentacion.FrmAnularCompra();
        Escritorio.add(AnularCompra);
        AnularCompra.show();
    }//GEN-LAST:event_mAnularcActionPerformed

    private void mbtnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnProductoActionPerformed
        Presentacion.FrmProducto Producto=new Presentacion.FrmProducto();
        Escritorio.add(Producto);
        Producto.show();
    }//GEN-LAST:event_mbtnProductoActionPerformed

    private void mbtnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnClienteActionPerformed
        Presentacion.FrmCliente Cliente=new Presentacion.FrmCliente();
        Escritorio.add(Cliente);
        Cliente.show();
    }//GEN-LAST:event_mbtnClienteActionPerformed

    private void mbtnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnEmpleadoActionPerformed
        Presentacion.FrmEmpleado Empleado=new Presentacion.FrmEmpleado();
        Escritorio.add(Empleado);
        Empleado.show();
    }//GEN-LAST:event_mbtnEmpleadoActionPerformed

    private void mbtnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnVentaActionPerformed
        Presentacion.FrmVenta venta=new Presentacion.FrmVenta();
        Escritorio.add(venta);
        venta.show();
        //venta.IdEmpleado=lblIdEmpleado.getText();
        venta.NombreEmpleado=lblNombreEmpleado.getText();
    }//GEN-LAST:event_mbtnVentaActionPerformed

    private void mbtnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnCompraActionPerformed
        Presentacion.FrmCompra compra=new Presentacion.FrmCompra();
        Escritorio.add(compra);
        compra.show();
        compra.IdEmpleado=lblIdEmpleado.getText();
        compra.NombreEmpleado=lblNombreEmpleado.getText();
    }//GEN-LAST:event_mbtnCompraActionPerformed

    private void mbtnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnEstadoActionPerformed
        Presentacion.FrmProductoEstado ProductoEstado=new Presentacion.FrmProductoEstado();
        Escritorio.add(ProductoEstado);
        ProductoEstado.show();
    }//GEN-LAST:event_mbtnEstadoActionPerformed

    private void mbtnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnCajaActionPerformed
        Presentacion.FrmCaja Caja=new Presentacion.FrmCaja();
        Escritorio.add(Caja);
        Caja.show();
    }//GEN-LAST:event_mbtnCajaActionPerformed

    private void mEstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEstadisticaActionPerformed
        Consultas.FrmVentasMensuales Ventas=new Consultas.FrmVentasMensuales();
        Escritorio.add(Ventas);
        Ventas.show();
    }//GEN-LAST:event_mEstadisticaActionPerformed

    private void mCompradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCompradeActionPerformed
       Consultas.FrmComprasRealizadas_Detallado Compras=new Consultas.FrmComprasRealizadas_Detallado();
        Escritorio.add(Compras);
        Compras.show();
    }//GEN-LAST:event_mCompradeActionPerformed

    private void mCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCuentasActionPerformed
        // TODO add your handling code here:
        FrmCuentas cuentas = new FrmCuentas();
        Escritorio.add(cuentas);
        cuentas.show();
    }//GEN-LAST:event_mCuentasActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        //HibernateUtil.getInstance().shutdown();
    }//GEN-LAST:event_formWindowClosed

    private void txtTipoDeCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoDeCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoDeCambioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            BigDecimal tipo = new BigDecimal(this.txtTipoDeCambio.getText());

            Session session = HibernateUtil.getInstance().getSession();
            session.beginTransaction();

            //TODO, only updates the second entry (USD)
            //ClsEntidadMonedaHib moneda = new ClsEntidadMonedaHib(2);
            dolar.setTipoCambio(tipo);
            //
            session.update( dolar );
            session.getTransaction().commit();
            session.close();

            JOptionPane.showMessageDialog(this, "Tipo de cambio actualizado.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ah ocurrido un Error: " + e.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOperacionesActionPerformed
        // TODO add your handling code here:
        FrmOperaciones operaciones = new FrmOperaciones();
        Escritorio.add(operaciones);
        operaciones.setVisible(true);
        
        
    }//GEN-LAST:event_mOperacionesActionPerformed

    private void mGastosVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGastosVariosActionPerformed
        // TODO add your handling code here:
        FrmGastosVarios gastos = new FrmGastosVarios();
        Escritorio.add(gastos);
        gastos.setVisible(true);
    }//GEN-LAST:event_mGastosVariosActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem JMCerrarSesion;
    private javax.swing.JMenuItem JMIniciarSesion;
    private javax.swing.JMenuItem JMSalir;
    private javax.swing.JToolBar TBPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUsuarioEmpleado;
    private javax.swing.JMenuItem mAnularc;
    private javax.swing.JMenuItem mAnularv;
    private javax.swing.JMenuItem mCalculadora;
    private javax.swing.JMenuItem mCambiarpass;
    private javax.swing.JMenuItem mCategoria;
    private javax.swing.JMenuItem mCliente;
    private javax.swing.JMenuItem mCompra;
    private javax.swing.JMenuItem mComprade;
    private javax.swing.JMenuItem mComprare;
    private javax.swing.JMenuItem mCuentas;
    private javax.swing.JMenuItem mEmpleado;
    private javax.swing.JMenuItem mEstadistica;
    private javax.swing.JMenuItem mEstado;
    private javax.swing.JMenuItem mGastosVarios;
    private javax.swing.JMenuItem mOperaciones;
    private javax.swing.JMenuItem mProducto;
    private javax.swing.JMenuItem mProveedor;
    private javax.swing.JMenuItem mRespaldar;
    private javax.swing.JMenuItem mRestaurar;
    private javax.swing.JMenuItem mTipodoc;
    private javax.swing.JMenuItem mTipouser;
    private javax.swing.JMenuItem mVenta;
    private javax.swing.JMenuItem mVentade;
    private javax.swing.JMenuItem mVentare;
    private javax.swing.JButton mbtnCaja;
    private javax.swing.JButton mbtnCliente;
    private javax.swing.JButton mbtnCompra;
    private javax.swing.JButton mbtnEmpleado;
    private javax.swing.JButton mbtnEstado;
    private javax.swing.JButton mbtnProducto;
    private javax.swing.JButton mbtnVenta;
    private javax.swing.JMenu mnuAnulaciones;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenu mnuCuentas;
    private javax.swing.JMenu mnuHerramientas;
    private javax.swing.JMenu mnuInformes;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenu mnuOperaciones;
    private javax.swing.JMenu mnuRegistro;
    private javax.swing.JTextField txtTipoDeCambio;
    // End of variables declaration//GEN-END:variables

    private void cargaTipoDeMonedaDefault() {
        
        Session session = HibernateUtil.getInstance().getSession();
        session.beginTransaction();
        this.dolar = (ClsEntidadMonedaHib)session.createQuery("FROM ClsEntidadMonedaHib WHERE id = 2").list().get(0);
        //session.getTransaction().commit();
        session.close();
        
        this.txtTipoDeCambio.setText(dolar.getTipoCambio().toString());
        
    }
    
    public DecimalFormat getDecimalFormater(){
        return this.decimalFormater;
    }
    
    public void setEmpleado(ClsEntidadEmpleadoHib empleado){
        this.empleado = empleado;
    }
    
    public ClsEntidadEmpleadoHib getEmpleado(){
        return this.empleado;
    }
}
