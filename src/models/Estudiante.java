package models;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

public class Estudiante {
    public static Function getNombre;
    private String nombre;
    private String cedula;
    private List<Double> calificaciones;

    public Estudiante(String nombre, String cedula, List<Double> calificaciones) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.calificaciones = calificaciones;
    }

    // Ingreso de Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    public int getPromedio() {
        double suma = 0;
        for (Double nota : calificaciones) {
            suma += nota;
        }
        return (int)(suma / calificaciones.size());
    }

    public int getPorcentajeUnicos() {
        String nombreLimpio = nombre.replaceAll("\\s+", "").toLowerCase();
        Set<Character> unicos = new HashSet<>();
        for (char c : nombreLimpio.toCharArray()) {
            unicos.add(c);
        }
        if (nombreLimpio.length() == 0) return 0;
        return (unicos.size() * 100) / nombreLimpio.length();
    }

    @Override
    public String toString() {
        return String.format("%s (%s) Porcentaje de caracteres únicos: %d%%, Promedio: %d",
                nombre, cedula, getPorcentajeUnicos(), getPromedio());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(cedula, that.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}