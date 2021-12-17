public class Administrativo extends Employee {
    private int _salarioBaseMensual =2000;
    private int _bonus = 100;

    Administrativo(String nombre) {
        super(nombre);
    }

    int Sueldo() {
        return _salarioBaseMensual + _bonus;
    }
}
