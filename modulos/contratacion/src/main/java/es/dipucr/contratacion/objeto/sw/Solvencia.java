package es.dipucr.contratacion.objeto.sw;


public class Solvencia {
	private SolvenciaTecnica[] solvenciaTecn;
	private SolvenciaEconomica[] solvenciaEconomica;
	
	public SolvenciaTecnica[] getSolvenciaTecn() {
		return solvenciaTecn;
	}
	public void setSolvenciaTecn(SolvenciaTecnica[] solvenciaTecn) {
		this.solvenciaTecn = solvenciaTecn;
	}
	public SolvenciaEconomica[] getSolvenciaEconomica() {
		return solvenciaEconomica;
	}
	public void setSolvenciaEconomica(SolvenciaEconomica[] solvenciaEconomica) {
		this.solvenciaEconomica = solvenciaEconomica;
	}
}
