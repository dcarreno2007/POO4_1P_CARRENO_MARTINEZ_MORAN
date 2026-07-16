package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.example.SistemaJuegos.Aficionado;
import com.example.SistemaJuegos.Compra;
import com.example.SistemaJuegos.Correo;
import com.example.SistemaJuegos.Kit;
import com.example.SistemaJuegos.ManejoArchivos;
import com.example.SistemaJuegos.Organizador;
import com.example.SistemaJuegos.Partido;
import com.example.SistemaJuegos.Reporte;
import com.example.SistemaJuegos.TipoCompra;
import com.example.SistemaJuegos.TipoUsuario;
import com.example.SistemaJuegos.Usuario;
import com.example.SistemaJuegos.Zona;

/**
 * Gestiona las operaciones principales del sistema.
 *
 * @author Daniel Carreño
 * @version 1.0
 */

public class Sistema{
    private final ArrayList<Partido> partidos = new ArrayList<>();
    private final ArrayList<Kit> kits = new ArrayList<>();
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final ArrayList<Compra> compras = new ArrayList<>();

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public ArrayList<Kit> getKits() {
        return kits;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

        /**
     * Inicia la ejecución del sistema, carga los archivos
     * y permite autenticar al usuario.
     *
     * @param args argumentos de la línea de comandos
     */

    public static void main(String[] args) {

        Sistema s = new Sistema();

        s.cargarUsuarios();

        s.cargarPartidos("src/main/java/com/example/SistemaJuegos/partidos.txt");
        s.cargarKits("src/main/java/com/example/SistemaJuegos/kits.txt");
        s.cargarCompras("src/main/java/com/example/SistemaJuegos/compras.txt");
        
        System.out.println("Sistema cargado correctamente.");

        Scanner sc = new Scanner(System.in);

        Usuario usuario = s.iniciarSesion(sc);
        if (usuario != null && s.verificarIdentidad(usuario, sc)) {
            s.mostrarMenu(usuario, sc);
        }
        sc.close();
    }

        /**
     * Solicita las credenciales del usuario y verifica
     * si coinciden con un usuario registrado.
     *
     * @param sc lector utilizado para ingresar los datos por consola
     * @return el usuario autenticado o null si las credenciales son incorrectas
     */

    public Usuario iniciarSesion(Scanner sc) {

        System.out.println();
        System.out.println("===== INICIO DE SESIÓN =====");

        System.out.print("Usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = sc.nextLine();

        System.out.println("\033[1A\r\2Contraseña: " + "*".repeat(contrasena.length()) + "\n");

        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
                System.out.println("Usuario autenticado correctamente.\n");
                return u;
            }
        }
        System.out.println("Usuario o contraseña incorrectos.");
        System.out.println("No se pudo iniciar sesión.");
        System.out.println("Saliendo del sistema...");
        return null;
    }

        /**
     * Verifica la identidad del usuario mediante la confirmación
     * de sus datos registrados.
     *
     * @param usuario usuario que inició sesión
     * @param sc lector utilizado para ingresar la respuesta por consola
     * @return true si la identidad es confirmada, o false si es rechazada
     */

    public boolean verificarIdentidad(Usuario usuario, Scanner sc) {
        if (usuario instanceof Aficionado) {
            Aficionado af = (Aficionado) usuario;

            System.out.println("Rol detectado: AFICIONADO\n");
            System.out.println("Bienvenido/a, " + af.getNombres() + " " + af.getApellidos());
            System.out.println("Celular registrado: " + af.getCelular() + "\n");
            System.out.print("¿Este número de celular es correcto? (S/N): ");

        } else if (usuario instanceof Organizador) {
            Organizador org = (Organizador) usuario;

            System.out.println("Rol detectado: ORGANIZADOR\n");
            System.out.println("Bienvenido/a, " + org.getNombres() + " " + org.getApellidos());
            System.out.println("Empresa asignada: " + org.getEmpresa() + "\n");
            System.out.print("¿Esta empresa es correcta? (S/N): ");
        }

        String respuesta = sc.nextLine().trim().toUpperCase();

        if (respuesta.equals("S")) {
            System.out.println("\nIdentidad confirmada.\n");
            return true;
        } else {
            System.out.println("\nVerificación fallida.");
            System.out.println("Por motivos de seguridad se cerrará sesión.");
            System.out.println("\nSaliendo del sistema...");
            return false;
        }
    }

        /**
     * Muestra el menú correspondiente al tipo de usuario
     * y ejecuta la opción seleccionada.
     *
     * @param usuario usuario autenticado en el sistema
     * @param sc lector utilizado para ingresar datos por consola
     */
    
    public void mostrarMenu(Usuario usuario, Scanner sc) {
        if (usuario instanceof Aficionado) {
            Aficionado af = (Aficionado) usuario;
            int opcion = -1;
            boolean primeraVez = true;

            while (opcion != 5) {
                System.err.println("Menú de Aficionado:");
                System.out.println("1. Consultar partidos");
                System.out.println("2. Comprar entrada");
                System.out.println("3. Comprar kit de entradas");
                System.out.println("4. Consultar entradas");
                System.out.println("5. Salir");

                if (primeraVez) {
                    System.out.print("Seleccione una opción: ");
                } else {
                    System.out.print("Seleccione otra opción: ");
                }

                opcion = leerEntero(sc);

                switch (opcion) {
                    case 1:
                        af.consultarPartidos(partidos);
                        primeraVez = false;
                        break;
                    case 2:
                        comprarEntrada(af, sc);
                        primeraVez = false;
                        break;
                    case 3:
                        comprarKit(af, sc);
                        primeraVez = false;
                        break;
                    case 4:
                        af.consultarEntradas(compras);
                        primeraVez = false;
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            }

        } else if (usuario instanceof Organizador) {
            boolean primeraVez = true;
            Organizador org = (Organizador) usuario;
            int opcion = -1;
            while (opcion != 3) {

                System.out.println("1. Consultar entradas");
                System.out.println("2. Generar reporte");
                System.out.println("3. Salir");

                if (primeraVez) {
                    System.out.print("Seleccione una opción: ");
                } else {
                    System.out.print("Seleccione otra opción: ");
                }

                opcion = leerEntero(sc);

                switch (opcion) {
                    case 1:
                        org.consultarEntradas(compras);
                        break;
                    case 2:
                        Reporte reporte = org.generarReporte(compras);
                        System.out.println(reporte.generarResumen());
                        notificar(org, reporte.getFechaGen(), reporte.getTotalCompras(), reporte.getTotalEntradas(), reporte.getTotalKits(), reporte.getMontoTotal(), sc);
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion inválida");
                }
            }
        }
    }

    /**
     * Lee y valida un número entero ingresado por consola.
     *
     * @param sc lector utilizado para ingresar el número
     * @return número entero ingresado correctamente
     */

    private int leerEntero(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese una cantidad válida.");
            }
        }
    }

        /**
     * Gestiona la compra de entradas para un partido.
     *
     * @param aficionado aficionado que realiza la compra
     * @param scanner lector utilizado para ingresar los datos de la compra
     */

    public void comprarEntrada(Aficionado aficionado, Scanner scanner) {

        aficionado.consultarPartidos(partidos);

        System.out.print("Ingrese el código del partido que desea comprar: ");
        String codigoPartido = scanner.nextLine();

        Partido partido = buscarPartido(codigoPartido);

        if (partido == null) {
            System.out.println("El partido no existe.");
            System.out.println("La compra ha sido cancelada.");
            return;
        }

        System.out.print("Ingrese la zona (GENERAL, PREFERENCIAL, VIP): ");

        String zonaTexto = scanner.nextLine().trim().toUpperCase();

        Zona zona;

        try {
            zona = Zona.valueOf(zonaTexto);
        } catch (IllegalArgumentException e) {
            System.out.println("Zona no válida.");
            return;
        }

        System.out.print("Ingrese la cantidad de entradas que desea comprar: ");
        int cantidad = leerEntero(scanner);

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            System.out.println("La compra ha sido cancelada.");
            return;
        }

        if (!partido.validarStock(zona, cantidad)) {
            System.out.println("No hay suficientes entradas disponibles para la zona seleccionada.");
            System.out.println("La compra ha sido cancelada.");
            return;
        }

        double precioUnitario = partido.obtenerPrecioEntrada(zona.name());

        double valorTotal = precioUnitario * cantidad;

        System.out.println("Valor total a pagar: $" + valorTotal);

        System.out.print("Ingrese el número de tarjeta: ");
        String numeroTarjeta = scanner.nextLine();

        if (numeroTarjeta.isBlank()) {
            System.out.println("El número de tarjeta no puede estar vacío.");
            System.out.println("La compra ha sido cancelada.");
            return;
        }

        // Simular pago
        System.out.println("Pago procesado exitosamente.");

        Compra compra = aficionado.comprar(partido, zona, cantidad);

        if (compra != null) {
            registrarCompra(compra);

            System.out.println("\nCompra realizada exitosamente.\n");
            System.out.println("Código de compra generado: " + compra.getCodigo());

            notificar(aficionado, compra, scanner);
        }

    }

        /**
     * Gestiona la compra de un kit de entradas.
     *
     * @param aficionado aficionado que realiza la compra
     * @param scanner lector utilizado para ingresar los datos de la compra
     */

    public void comprarKit(Aficionado aficionado, Scanner scanner) {

        mostrarKits();

        System.out.print("Código del kit: ");
        String codigoKit = scanner.nextLine();

        Kit kit = buscarKit(codigoKit);

        if (kit == null) {
            System.out.println("El kit no existe.");
            System.out.println("La compra ha sido cancelada.");
            return;
        }

        if (!kit.validarDisponibilidad()) {
            System.out.println("El kit no está disponible.");
            return;
        }

        System.out.println("Partidos incluidos:");

        for (Partido partido : kit.getPartidosIncluidos()) {
            System.out.println(
                    "- " + partido.getSeleccionLocal()
                    + " vs "
                    + partido.getSeleccionVisitante()
            );
        }

        System.out.printf(
                "Precio total: $%.2f%n",
                kit.getPrecio()
        );

        System.out.print("Número de tarjeta: ");
        String tarjeta = scanner.nextLine();

        if (tarjeta.isBlank()) {
            System.out.println("Número de tarjeta inválido.");
            return;
        }

        Compra compra = aficionado.comprar(kit);

        if (compra != null) {
            registrarCompra(compra);
            notificar(aficionado, compra, kit, scanner);
            System.out.println("Kit comprado correctamente.");
            System.out.println("Código de compra generado: " + compra.getCodigo());
        }
    }
    
        /**
     * Registra una compra en la lista del sistema
     * y la guarda en el archivo de compras.
     *
     * @param compra compra que será registrada
     */

    public void registrarCompra(Compra compra) {

        compras.add(compra);

        ManejoArchivos.EscribirArchivo(
                "src/main/java/com/example/SistemaJuegos/compras.txt",
                compra.toString()
        );
    }

    /**
     * Carga los usuarios, aficionados y organizadores
     * desde sus respectivos archivos.
    */

    public void cargarUsuarios() {
        usuarios.clear();
        ArrayList<String> lineasUsuarios = ManejoArchivos.LeeFichero("src/main/java/com/example/SistemaJuegos/usuarios.txt");
        ArrayList<String> lineasAficionados = ManejoArchivos.LeeFichero("src/main/java/com/example/SistemaJuegos/aficionados.txt");
        ArrayList<String> lineasOrganizadores = ManejoArchivos.LeeFichero("src/main/java/com/example/SistemaJuegos/organizadores.txt");

        for (int i = 1; i < lineasUsuarios.size(); i++) {
            String[] datosUsuario = lineasUsuarios.get(i).split("\\|");
            String codigoUnico = datosUsuario[0].trim();
            String cedula = datosUsuario[1].trim();
            String nombres = datosUsuario[2].trim();
            String apellidos = datosUsuario[3].trim();
            String usuario = datosUsuario[4].trim();
            String contrasena = datosUsuario[5].trim();
            String correo = datosUsuario[6].trim();
            TipoUsuario rol = TipoUsuario.valueOf(datosUsuario[7].trim());

            if (rol == TipoUsuario.A) {
                String[] datosAficionado = buscarDatosPorCodigo(lineasAficionados, codigoUnico);
                if (datosAficionado != null) {
                    String paisFav = datosAficionado[5].trim();
                    String celular = datosAficionado[4].trim();

                    Aficionado aficionado = new Aficionado(
                            codigoUnico,
                            cedula,
                            nombres,
                            apellidos,
                            usuario,
                            contrasena,
                            correo,
                            rol,
                            paisFav,
                            celular
                    );
                    usuarios.add(aficionado);
                } else {
                    System.out.println("No se encontraron datos del afiicionado con código único: " + codigoUnico);
                }
    
            } else if (rol == TipoUsuario.O) {
                String[] datosOrganizador = buscarDatosPorCodigo(lineasOrganizadores, codigoUnico);
                if (datosOrganizador != null) {
                    String empresa = datosOrganizador[4].trim();
                    String cargo = datosOrganizador[5].trim();

                    Organizador organizador = new Organizador(
                            codigoUnico,
                            cedula,
                            nombres,
                            apellidos,
                            usuario,
                            contrasena,
                            correo,
                            rol,
                            empresa,
                            cargo
                    );
                    usuarios.add(organizador);
                } else {
                    System.out.println("No se encontraron datos del organizador con código único: " + codigoUnico);
                }
            }
        }
    }

    /**
     * Busca los datos asociados a un código único
     * dentro de una lista de líneas.
     *
     * @param lineas líneas leídas desde el archivo
     * @param codigoBuscado código único que se desea encontrar
     * @return arreglo con los datos encontrados o null si no existe
     */

    private String[] buscarDatosPorCodigo(ArrayList<String> lineas, String codigoBuscado) {
        for (int i = 1; i < lineas.size(); i++) {
            String[] datos = lineas.get(i).split("\\|");
            if (datos[0].trim().equalsIgnoreCase(codigoBuscado)) {
                return datos;
            }
        }
        return null;
    }

    /**
     * Carga los partidos almacenados en un archivo.
     *
     * @param ruta ubicación del archivo de partidos
     */

    public void cargarPartidos(String ruta) {

        ArrayList<String> lineas = ManejoArchivos.LeeFichero(ruta);

        for (int i = 1; i < lineas.size(); i++) {

            String[] d = lineas.get(i).split("\\|");

            Date fecha = parsearFecha(d[3]);

            Partido p = new Partido(
                    d[0], 
                    d[1], 
                    d[2], 
                    fecha, 
                    d[4], 
                    Integer.parseInt(d[6]), 
                    d[5], 
                    Integer.parseInt(d[7]), 
                    Integer.parseInt(d[8]), 
                    Integer.parseInt(d[9]), 
                    d[10] 
            );

            partidos.add(p);
        }
    }

    /**
     * Carga los kits de entradas almacenados en un archivo.
     *
     * @param ruta ubicación del archivo de kits
     */
    
    public void cargarKits(String ruta) {

        ArrayList<String> lineas = ManejoArchivos.LeeFichero(ruta);

        for (int i = 1; i < lineas.size(); i++) {

            String[] d = lineas.get(i).split("\\|");

            String codigo = d[0];
            String nombre = d[1];
            String descripcion = d[2];

            String[] codigosPartidos = d[3].split(",");

            double precio = Double.parseDouble(d[4]);
            int disponibles = Integer.parseInt(d[5]);

            ArrayList<Partido> partidosKit = new ArrayList<>();

            for (String cod : codigosPartidos) {
                Partido p = buscarPartido(cod.trim());
                if (p != null) {
                    partidosKit.add(p);
                }
            }

            Kit k = new Kit(
                    codigo,
                    nombre,
                    descripcion,
                    partidosKit,
                    precio,
                    disponibles);

            kits.add(k);
        }
    }

    /**
     * Carga las compras almacenadas en un archivo.
     *
     * @param ruta ubicación del archivo de compras
     */

    public void cargarCompras(String ruta) {

        ArrayList<String> lineas = ManejoArchivos.LeeFichero(ruta);

        for (int i = 1; i < lineas.size(); i++) {

            String[] d = lineas.get(i).split("\\|");

            String codigo = d[0];
            TipoCompra tipo = TipoCompra.valueOf(d[1]);
            String codigoReferencia = d[2];
            Date fecha = parsearFecha(d[3]);
            int cantidad = Integer.parseInt(d[4]);
            double valorPagado = Double.parseDouble(d[5]);
            String codigoAficionado = d[6];

            Zona zona = null;

            if (d.length > 7 && !d[7].equals("SIN_ZONA") && !d[7].isBlank()) {
                zona = Zona.valueOf(d[7].trim().toUpperCase());
            }

            Compra c = new Compra(codigo, tipo, codigoReferencia, fecha, cantidad, valorPagado, codigoAficionado, zona);
            compras.add(c);
            Compra.actualizarContadorDesdeCodigo(codigo);
        }
    }

    /**
     * Convierte una fecha en formato de texto
     * a un objeto Date.
     *
     * @param fechaTexto fecha escrita en formato yyyy-MM-dd
     * @return fecha convertida o la fecha actual si ocurre un error
     */

    private Date parsearFecha(String fechaTexto) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            return formato.parse(fechaTexto);
        } catch (ParseException e) {
            System.out.println("Error al leer la fecha: " + fechaTexto);
            return new Date();
        }
    }

    /**
     * Busca un partido mediante su código.
     *
     * @param codigo código del partido que se desea encontrar
     * @return partido encontrado o null si no existe
     */

    public Partido buscarPartido(String codigo) {

        for (Partido p : partidos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }

        return null;
    }

    /**
     * Busca un kit de entradas mediante su código.
     *
     * @param codigo código del kit que se desea encontrar
     * @return kit encontrado o null si no existe
     */

    public Kit buscarKit(String codigo) {

        for (Kit k : kits) {
            if (k.getCodigo().equalsIgnoreCase(codigo)) {
                return k;
            }
        }

        return null;
    }

    /**
     * Muestra los kits disponibles junto con sus códigos,
     * partidos incluidos, precios y disponibilidad.
     */

    public void mostrarKits() {

        System.out.println("===== KITS DISPONIBLES =====\n");

        int numero = 1;

        for (Kit k : kits) {
            System.out.println(numero + ". " + k.getNombre() + " | Código: " + k.getCodigo());
            System.out.println("Incluye:");

            for (Partido partido : k.getPartidosIncluidos()) {
                System.out.println("- " + partido.getSeleccionLocal() + " vs " + partido.getSeleccionVisitante());
            }

            System.out.printf("%nPrecio: $%.2f%n", k.getPrecio());
            System.out.println("Disponibles: " + k.getDisponibles());
            System.out.println();

            numero++;
        }
    }

    // Sistema de notificaciones

    /**
     * Envía por correo la confirmación de una compra
     * individual de entradas.
     *
     * @param aficionado aficionado que realizó la compra
     * @param compra compra individual registrada
     * @param scanner lector utilizado para seleccionar el correo de destino
     */

    public void notificar(Aficionado aficionado, Compra compra, Scanner scanner) {

        Partido partido = buscarPartido(compra.getCodigoReferencia());

        if (partido == null) {
            System.out.println("No se pudo enviar el correo porque no se encontró el partido.");
            return;
        }

        String correoNuevo = null;

        while (true) { 
            System.out.print("\n¿Desea enviar a un email no registrado? (S/N): ");
            String opcion = scanner.nextLine().trim().toUpperCase();

            if (opcion.equals("S") || opcion.equals("N")) {
                System.out.print("\nIngrese el nuevo correo: ");
                correoNuevo = scanner.nextLine().trim();
                break;
            }

            System.out.println("Opción inválida. Ingrese únicamente S o N.");
        }

        String correoDestino = (correoNuevo != null && !correoNuevo.isBlank()) ? correoNuevo : aficionado.getCorreo();

        boolean enviado = Correo.enviarCorreoCompraEntrada(
            correoDestino,
            aficionado.getNombres(),
            aficionado.getApellidos(),
            compra.getCodigo(),
            compra.getFechaCompra(),
            partido.getSeleccionLocal(),
            partido.getSeleccionVisitante(),
            partido.getCodigo(),
            compra.getZona(),
            compra.getCantidad(),
            compra.getValorPagado());
        
        if (!enviado) {
            System.out.println("La compra fue generada, pero no se pudo enviar el correo.");
        }
    }

    /**
     * Envía por correo la confirmación de la compra
     * de un kit de entradas.
     *
     * @param aficionado aficionado que realizó la compra
     * @param compra compra del kit registrada
     * @param kit kit de entradas adquirido
     * @param scanner lector utilizado para seleccionar el correo de destino
     */

    public void notificar(Aficionado aficionado, Compra compra, Kit kit, Scanner scanner) {
        
        if (kit.getPartidosIncluidos().isEmpty()) {
            System.out.println("No se pudo enviar el correo porque el kit no incluye partidos.");
            return;
        }

        int cantidadEntradas = kit.getPartidosIncluidos().size();

        String correoNuevo = null;

        System.out.print("¿Desea enviar a un email no registrado? (S/N): ");

        String opcion = scanner.nextLine().trim().toUpperCase();

        if (opcion.equals("S")) {
            System.out.println("\nIngrese el nuevo correo: ");
            correoNuevo = scanner.nextLine().trim();
        }

        String correoDestino = (correoNuevo != null && !correoNuevo.isBlank()) ? correoNuevo : aficionado.getCorreo();

        boolean enviado = Correo.enviarCorreoCompraKit(correoDestino, aficionado.getNombres(), aficionado.getApellidos(), compra.getCodigo(), compra.getFechaCompra(), kit.getNombre(), cantidadEntradas, compra.getValorPagado());

        if (!enviado) {
            System.out.println("El kit fue comprado, pero no se pudo enviar el correo.");
        }
    }

    /**
     * Envía por correo el reporte de compras generado
     * por el organizador.
     *
     * @param organizador organizador que generó el reporte
     * @param fechaReporte fecha de generación del reporte
     * @param totalCompras cantidad total de compras registradas
     * @param totalEntradas cantidad total de entradas individuales
     * @param totalKits cantidad total de kits vendidos
     * @param montoTotal monto total recaudado
     * @param scanner lector utilizado para seleccionar el correo de destino
     */

    public void notificar(Organizador organizador, Date fechaReporte, int totalCompras, int totalEntradas, int totalKits, double montoTotal, Scanner scanner) {

        String opcion;

        while (true) {
            System.out.print(
                    "¿Desea enviar el reporte a un email no registrado? (S/N): "
            );

            opcion = scanner.nextLine().trim().toUpperCase();

            if (opcion.equals("S") || opcion.equals("N")) {
                break;
            }

            System.out.println(
                    "Opción inválida. Ingrese únicamente S o N."
            );
        }

        String correoDestino;

        if (opcion.equals("S")) {
            System.out.print("Ingrese el nuevo correo: ");
            correoDestino = scanner.nextLine().trim();
        } else {
            correoDestino = organizador.getCorreo();
        }

        boolean enviado = Correo.enviarCorreoReporteCompras(
            correoDestino,
            organizador.getNombres(),
            organizador.getApellidos(),
            fechaReporte,
            totalCompras,
            totalEntradas,
            totalKits,
            montoTotal
        );

        if (!enviado) {
            System.out.println(
                    "El reporte fue generado, pero no se pudo enviar el correo."
            );
        }
    }    
}