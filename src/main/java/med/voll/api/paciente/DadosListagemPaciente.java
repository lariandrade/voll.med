package med.voll.api.paciente;

import med.voll.api.medico.Medico;

public record DadosListagemPaciente(Long id, String nome, String email, String CPF) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
