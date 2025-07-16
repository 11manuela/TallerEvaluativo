package Registro;
import java.time.LocalDate;

import java.time.format.DateTimeParseException;

public class Consulta {

    /* ─── Atributos ───────────────────────────────────────────── */
    private String      codigo;
    private LocalDate   fecha;
    private Veterinario veterinario;
    private Mascota     mascota;

    /* ─── Constructores ───────────────────────────────────────── */

    /** Constructor principal: recibe la fecha como LocalDate. */
    public Consulta(String codigo,
                    LocalDate fecha,
                    Veterinario veterinario,
                    Mascota mascota) {

        setCodigo(codigo);
        setFecha(fecha);
        setVeterinario(veterinario);
        setMascota(mascota);
    }

    /**
     * Constructor de conveniencia: recibe la fecha como String
     * en formato ISO (aaaa‑MM‑dd).  Internamente la convierte.
     */
    public Consulta(String codigo,
                    String fechaTexto,
                    Veterinario veterinario,
                    Mascota mascota) {

        this(codigo, parseFecha(fechaTexto), veterinario, mascota);
    }

    /* ─── Getters / Setters con validación ────────────────────── */

    public String getCodigo() { return codigo; }
    public void   setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank())
            throw new IllegalArgumentException("Código inválido");
        this.codigo = codigo.trim();
    }

    public LocalDate getFecha() { return fecha; }
    public void      setFecha(LocalDate fecha) {
        if (fecha == null)
            throw new IllegalArgumentException("Fecha requerida");
        this.fecha = fecha;
    }

    public Veterinario getVeterinario() { return veterinario; }
    public void        setVeterinario(Veterinario veterinario) {
        if (veterinario == null)
            throw new IllegalArgumentException("Veterinario requerido");
        this.veterinario = veterinario;
    }

    public Mascota getMascota() { return mascota; }
    public void    setMascota(Mascota mascota) {
        if (mascota == null)
            throw new IllegalArgumentException("Mascota requerida");
        this.mascota = mascota;
    }

    /* ─── Métodos utilitarios ─────────────────────────────────── */

    private static LocalDate parseFecha(String texto) {
        try {
            return LocalDate.parse(texto);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException(
                    "Formato de fecha inválido (use aaaa‑MM‑dd)", ex);
        }
    }

    public void mostrarConsulta() {
        System.out.println("Código: " + codigo);
        System.out.println("Fecha : " + fecha);
        System.out.println("Veterinario: " +
                (veterinario != null ? veterinario.getNombre() : "‑‑"));
        System.out.println("Mascota: " +
                (mascota != null ? mascota.getNombre() : "‑‑"));

    }
}
