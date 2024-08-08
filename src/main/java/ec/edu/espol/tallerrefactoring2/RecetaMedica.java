package ec.edu.espol.tallerrefactoring2;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecetaMedica {
    private LocalDateTime fechaHora;
    private Paciente paciente;
    private Medico medico;
    private List<Medicamento> medicamentos;

    public RecetaMedica(LocalDateTime fechaHora, Paciente paciente, Medico medico, List<Medicamento> medicamentos) {
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.medicamentos = new ArrayList<Medicamento>();
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
