package mod.recovered.config;

import java.io.Serializable;

public class NationalLeagueConfig implements Serializable {
  private static final long serialVersionUID = 16L;

  private int pais = -1;
  private int divisao = -1;
  private int formula = 0;
  private int desempate = 0;
  private int nTimes = 0;
  private boolean doisTurnos = true;
  private int nGrupos = 0;
  private boolean jogosDentroGrupo = true;
  private boolean rebaixadoPeloGrupo = false;
  private int numeroTimesMataMata = 0;
  private boolean valido = false;
  private int nRebaixados = 2;
  private boolean[] duasVoltasMataMata = new boolean[]{true, true, true, true, true, true, true};
  private boolean classificaPeloGeral = false;
  private boolean melhoresTerceiros = false;
  private String nome = null;
  private String nomeDivisao = null;
  private int playoffRebaixamento = 0;
  private boolean[] duasVoltasplayoffReb = new boolean[3];
  private boolean[] duasVoltasMataMataSobe = new boolean[3];
  private int vagasSobemPeloMataMata = 0;
  private int rebaixadosDireto = 2;
  private int versaoArquivo = 0;

  public int getPais() {
    return pais;
  }

  public void setPais(int pais) {
    this.pais = pais;
  }

  public int getDivisao() {
    return divisao;
  }

  public void setDivisao(int divisao) {
    this.divisao = divisao;
  }

  public int getFormula() {
    return formula;
  }

  public void setFormula(int formula) {
    this.formula = formula;
  }

  public int getDesempate() {
    return desempate;
  }

  public void setDesempate(int desempate) {
    this.desempate = desempate;
  }

  public int getnTimes() {
    return nTimes;
  }

  public void setnTimes(int nTimes) {
    this.nTimes = nTimes;
  }

  public boolean isDoisTurnos() {
    return doisTurnos;
  }

  public void setDoisTurnos(boolean doisTurnos) {
    this.doisTurnos = doisTurnos;
  }

  public int getnGrupos() {
    return nGrupos;
  }

  public void setnGrupos(int nGrupos) {
    this.nGrupos = nGrupos;
  }

  public boolean isJogosDentroGrupo() {
    return jogosDentroGrupo;
  }

  public void setJogosDentroGrupo(boolean jogosDentroGrupo) {
    this.jogosDentroGrupo = jogosDentroGrupo;
  }

  public boolean isRebaixadoPeloGrupo() {
    return rebaixadoPeloGrupo;
  }

  public void setRebaixadoPeloGrupo(boolean rebaixadoPeloGrupo) {
    this.rebaixadoPeloGrupo = rebaixadoPeloGrupo;
  }

  public int getNumeroTimesMataMata() {
    return numeroTimesMataMata;
  }

  public void setNumeroTimesMataMata(int numeroTimesMataMata) {
    this.numeroTimesMataMata = numeroTimesMataMata;
  }

  public boolean isValido() {
    return valido;
  }

  public void setValido(boolean valido) {
    this.valido = valido;
  }

  public int getnRebaixados() {
    return nRebaixados;
  }

  public void setnRebaixados(int nRebaixados) {
    this.nRebaixados = nRebaixados;
  }

  public boolean[] getDuasVoltasMataMata() {
    return duasVoltasMataMata;
  }

  public void setDuasVoltasMataMata(boolean[] duasVoltasMataMata) {
    this.duasVoltasMataMata = duasVoltasMataMata;
  }

  public boolean isClassificaPeloGeral() {
    return classificaPeloGeral;
  }

  public void setClassificaPeloGeral(boolean classificaPeloGeral) {
    this.classificaPeloGeral = classificaPeloGeral;
  }

  public boolean isMelhoresTerceiros() {
    return melhoresTerceiros;
  }

  public void setMelhoresTerceiros(boolean melhoresTerceiros) {
    this.melhoresTerceiros = melhoresTerceiros;
  }

  public String getNome2() {
    return nome;
  }

  public void setNome2(String nome) {
    this.nome = nome;
  }

  public String getNomeDivisao() {
    return nomeDivisao;
  }

  public void setNomeDivisao(String nomeDivisao) {
    this.nomeDivisao = nomeDivisao;
  }

  public int getPlayoffRebaixamento() {
    return playoffRebaixamento;
  }

  public void setPlayoffRebaixamento(int playoffRebaixamento) {
    this.playoffRebaixamento = playoffRebaixamento;
  }

  public int getRebaixadosDireto() {
    return rebaixadosDireto;
  }

  public void setRebaixadosDireto(int rebaixadosDireto) {
    this.rebaixadosDireto = rebaixadosDireto;
  }

  public int getVersaoArquivo() {
    return versaoArquivo;
  }

  public void setVersaoArquivo(int versaoArquivo) {
    this.versaoArquivo = versaoArquivo;
  }

  public int getVagasSobemPeloMataMata() {
    return vagasSobemPeloMataMata;
  }

  public void setVagasSobemPeloMataMata(int vagasSobemPeloMataMata) {
    this.vagasSobemPeloMataMata = vagasSobemPeloMataMata;
  }

  public void setIdaVoltaMMSobe(boolean first, boolean second) {
    if (duasVoltasMataMataSobe == null) {
      duasVoltasMataMataSobe = new boolean[3];
    }
    duasVoltasMataMataSobe[0] = first;
    duasVoltasMataMataSobe[1] = second;
  }

  public boolean[] getDuasVoltasMataMataSobe() {
    if (duasVoltasMataMataSobe == null) {
      duasVoltasMataMataSobe = new boolean[3];
    }
    return duasVoltasMataMataSobe;
  }

  public boolean[] getDuasVoltasplayoffReb() {
    if (duasVoltasplayoffReb == null) {
      duasVoltasplayoffReb = new boolean[3];
    }
    return duasVoltasplayoffReb;
  }

  public void setDuasVoltasplayoffReb(boolean value) {
    if (duasVoltasplayoffReb == null) {
      duasVoltasplayoffReb = new boolean[3];
    }
    duasVoltasplayoffReb[0] = value;
  }
}
