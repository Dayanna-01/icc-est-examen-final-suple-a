package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import models.Estudiante;

public class EstudianteController {

    // Método A -> Ordenar Promedio
    public TreeSet<Estudiante> ordenarPorPromedio(List<Estudiante> estudiantes) {
        return new TreeSet<>(new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                int cmpPromedio = Integer.compare(e2.getPromedio(), e1.getPromedio());
                if (cmpPromedio != 0)
                return cmpPromedio;

                int cmpNombre = e1.getNombre().compareTo(e2.getNombre());
                if (cmpNombre != 0)
                return cmpNombre;

                return e1.getCedula().compareTo(e2.getCedula());
            }
        }) {{
            addAll(estudiantes);
        }};
    }

    // Metodo B -> ClasificarPorcentaje
        public Map<String, List<Estudiante>> clasificarPorPorcentaje(Set<Estudiante> estudiantes) {
        Map<String, List<Estudiante>> mapa = new HashMap<>();

        for (Estudiante est : estudiantes) {
            int porcentaje = est.getPorcentajeUnicos();
            String categoria;

            if (porcentaje >= 90) {
                categoria = "A";
            } else if (porcentaje >= 70) {
                categoria = "B";
            } else if (porcentaje >= 50) {
                categoria = "C";
            } else if (porcentaje >= 30) {
                categoria = "D";
            } else {
                categoria = "E";
            }

            mapa.computeIfAbsent(categoria, k -> new LinkedList<>()).add(est);
        }

        return mapa;
    }

    //Metodo C -> Estudiantes Destacados
    public List<Estudiante> obtenerEstudiantesDestacados(List<Estudiante> estudiantes) {
        List<Estudiante> destacados = new ArrayList<>();

        for (Estudiante est : estudiantes) {
            if (est.getPromedio() > 7) {
                destacados.add(est);
            }
        }

        destacados.sort(Comparator.comparing(Estudiante::getNombre)); //Usa el comparador para listar en orden al nombre ascendentemente
        return destacados; //returna vacio si no se encontró 
    }
    
    //Metodo D -> Buscar Nombre
        public Estudiante buscarPorNombre(List<Estudiante> estudiantesOrdenados, String nombre) {
        int left = 0, right = estudiantesOrdenados.size() - 1;

        while (left <= right) {
            /*int mid = (left + right) / 2;
            Estudiante midEst = estudiantesOrdenados.get(mid);
            int cmp = midEst.getNombre().compareTo(nombre);

            if (cmp == 0) return midEst;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;*/ // a esto quitale el mid y el midEst
        }
        return null;
    }
}