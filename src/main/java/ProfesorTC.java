public class ProfesorTC extends Employee {
    private int _salarioBaseMensual =2000;
    private int _comision = 500;

    ProfesorTC(String nombre) {
        super(nombre);
    }

    int Sueldo() {
        return _salarioBaseMensual + _comision;
    }
}
