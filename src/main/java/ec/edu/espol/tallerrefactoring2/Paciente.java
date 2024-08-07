package ec.edu.espol.tallerrefactoring2;
public class Paciente extends Persona {
    public static final int ADULTO_MAYOR_EDAD = 65;
    public HistorialMedico historialMedico;
    public Paciente(String nombre, int edad, String genero, String direccion, String telefono, String correoElectronico) {
        super(nombre, edad, genero, direccion, telefono, correoElectronico);
        this.historialMedico = new HistorialMedico();
    }

    public boolean esAdultoMayor(){
        return super.getEdad()>=ADULTO_MAYOR_EDAD;
    }
}