package main.Enum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum ClasificacionEnum {
    EARLYCHILHOOD("EARLYCHILHOOD"),
    EVERYONE("EVERYONE"),
    EVERYONE10PLUS("EVERYONE 10+"),
    TEEN("TEEN"),
    MATURE17PLUS("MATURE 17+"),
    ADULTSONLY18PLUS("ADULTS ONLY 18+"),
    RATINGPENDING("RATING PENDING");

    private final String clasificacion;
    private static final List<String> listClasificacion;

    ClasificacionEnum(String clasificacion){
        this.clasificacion = clasificacion;
    }

    static {
        listClasificacion = new ArrayList<>();
        for (ClasificacionEnum clasificacionEnum : ClasificacionEnum.values()) {
            listClasificacion.add(clasificacionEnum.getClasificacion());
        }
    }

    public String getClasificacion(){
        return clasificacion;
    }

    public static List<String> getListClasificacion(){
        return Collections.unmodifiableList(listClasificacion);
    }
}
