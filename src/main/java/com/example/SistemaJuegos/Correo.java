package com.example.SistemaJuegos;

import java.util.Date;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage; 

/**
 * Gestiona el envío de correos electrónicos desde el sistema.
 *
 * @author Daniel Carreño
 * @version 1.0
 */

public class Correo {

    private static final String CORREO_REMITENTE = System.getenv("correSistema");
    private static final String CLAVE_APLICACION = System.getenv("claveSistema");


    /**
     * Envía un correo electrónico al destinatario indicado.
     *
     * @param correoDestino dirección de correo del destinatario
     * @param asunto asunto del correo electrónico
     * @param mensaje contenido del correo electrónico
     * @return true si el correo fue enviado correctamente, o false si ocurrió un error
     */
    

    public static boolean enviarCorreo(String correoDestino, String asunto, String mensaje) {

        if (CORREO_REMITENTE == null || CLAVE_APLICACION == null) {
            System.err.println("No se configuraron las credenciales del correo");
            return false;
        }

        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");

        propiedades.put("mail.smtp.connectiontimeout", "10000");
        propiedades.put("mail.smtp.timeout", "10000");
        propiedades.put("mail.smtp.writetimeout", "10000");

        Session session = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREO_REMITENTE, CLAVE_APLICACION);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(CORREO_REMITENTE));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestino));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);
            System.out.println("\nCorreo enviado exitosamente a " + correoDestino + "\n");
            return true;

        } catch (MessagingException e) {
            System.out.println("No se pudo enviar el correo a " + correoDestino);
            System.err.println("Motivo: La dirección de correo no es válida u ocurrió un problema con el servidor.");    
            return false;
        }
    }

    /*
    * Correo después de comprar entradas para un partido
    */

    public static boolean enviarCorreoCompraEntrada(
        String correoAficionado, String nombres, 
        String apellidos, String codigoCompra, 
        Date fechaCompra, String seleccionLocal, 
        String seleccionVisitante, String codigoPartido, 
        Zona zona, int cantidad, double valorPagado) {

        String asunto = "Compra de entrada realizada";

        String mensaje = "Estimado/a " + nombres + " "
                + apellidos + ",\n\n"

                + "Su compra ha sido registrada exitosamente "
                + "con el código " + codigoCompra
                + " el día " + fechaCompra + ".\n\n"

                + "Partido: " + seleccionLocal
                + " vs " + seleccionVisitante + "\n"

                + "Código del partido: "
                + codigoPartido + "\n"

                + "Zona: " + zona + "\n"

                + "Cantidad: " + cantidad + "\n"

                + "Valor pagado: $" + String.format("%.2f", valorPagado)
                + "\n\n"

                + "Gracias por adquirir sus entradas para el mundial. "
                + "Recuerde reservar el código de compra para futuras consultas.";

        return enviarCorreo(correoAficionado, asunto, mensaje);

    }

    /*
    * Correo después de comprar un kit de entradas
    */

    public static boolean enviarCorreoCompraKit(
        String correoAficionado, String nombres, String apellidos,
        String codigoCompra, Date fechaCompra, String nombreKit,
        int cantidadEntradas, double valorPagado) {

        String asunto = "Compra de kit de entradas realizada";

        String mensaje =
                "Estimado/a " + nombres + " " + apellidos + ",\n\n"

                + "Su compra del kit de entradas ha sido registrada exitosamente con el código "
                + codigoCompra + " el día " + fechaCompra + ".\n\n"

                + "Kit adquirido: " + nombreKit + "\n"
                + "Cantidad de entradas: " + cantidadEntradas + "\n"
                + "Valor pagado: $" + String.format("%.2f", valorPagado) + "\n\n"

                + "Gracias por adquirir su kit de entradas para el Mundial. "
                + "Recuerde conservar el código de compra para futuras consultas.";

        return enviarCorreo(correoAficionado, asunto, mensaje);
    }

    /*
    * Correo con el reporte de compras del organizador
    */

    public static boolean enviarCorreoReporteCompras(
        String correoOrganizador, String nombres,
        String apellidos, Date fechaReporte, int totalCompras,
        int totalEntradas, int totalKits, double montoTotal) {

        String asunto = "Reporte de compras registradas";

        String mensaje =
            "Estimado/a " + nombres + " " + apellidos + ",\n\n"

            + "Se ha generado el reporte de compras del sistema.\n\n"

            + "Fecha de generación del reporte: " + fechaReporte + "\n"

            + "Total de compras registradas: " + totalCompras + "\n"

            + "Total de compras de entradas individuales: " + totalEntradas + "\n"

            + "Total de compras de kits: " + totalKits + "\n"

            + "Monto total recaudado: $" + String.format("%.2f", montoTotal);

        
        return enviarCorreo(correoOrganizador, asunto, mensaje);
    }

}
