package com.paint.paintPrimeraPractica.Respository;

import com.paint.paintPrimeraPractica.model.Canvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CanvasRepoImpl implements CanvasRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private final List<Canvas> canvasList = new ArrayList<>();

    public CanvasRepoImpl() {

    }

    @Override
    public Canvas buscarCanvas(int id) {
        return canvasList.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Canvas> buscarTodosCanvas() {
        return new ArrayList<>(canvasList);
    }

    @Override
    public void agregarCanvas(int id, String nombre, int idUser, String figurasJson,
                              String fechaCreacion, String fechaModificacion) {
        Canvas canvas = new Canvas(id, nombre, idUser, figurasJson, fechaCreacion, fechaModificacion);
        canvasList.add(canvas);
    }

    @Override
    public void eliminarCanvas(int id) {
        for (int i = 0; i < canvasList.size(); i++) {
            canvasList.removeIf(canvas-> canvas.getId()==id);
        }
    }

    @Override
    public void guardarFiguras(int id, String json) {
        buscarCanvas(id).setFigurasJson(json);
    }

    @Override
    public String buscarFigurasJson(int id) {
        Canvas canvas = buscarCanvas(id);

        return canvas.getFigurasJson();
    }

    @Override
    public String buscarNombre(int id) {
        Canvas canvas = buscarCanvas(id);

        return canvas.getNombre();
    }

    @Override
    public int buscarIdUser(int id) {
        Canvas canvas = buscarCanvas(id);
        return canvas.getIdUser();
    }

    @Override
    public void guardarNombre(int id, String nombre) {
        Canvas canvas = buscarCanvas(id);
        canvas.setNombre(nombre);
    }

    @Override
    public void guardarFechaModificacion(int id, String fechaModificacion) {
        Canvas canvas = buscarCanvas(id);
        canvas.setFechaModificacion(fechaModificacion);
    }
}
