public class ProfesorTC extends Employee {
    private int salarioBaseMensual =2000;
    private int comision = 500;

    ProfesorTC(String nombre) {
        super(nombre);
    }

    int sueldo() {
        return salarioBaseMensual + comision;
    }
}
