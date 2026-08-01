package mod.recovered.config;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.io.Serializable;

public class GameOptions implements Serializable {
  private static final long serialVersionUID = 1L;

  private boolean jogaEstadual = true;
  private boolean jogaRegionais = true;
  private boolean usaGrupoPadraoEstadual = true;
  private boolean jogaIntClubes = true;
  private boolean jogaSelecoesAll = true;
  private boolean[] jogaSelecoes = new boolean[]{true, true, true, true, true, true, true};
  private boolean salarioMensal = true;
  private boolean habilidadeIndividual = true;
  private boolean jogaIntano1 = true;
  private boolean gruposIntPadrao = false;
  private boolean[] verJint = new boolean[]{
      true, true, false, false, false, false, true, true, true, true, true,
      true, true, true, true, false, true, true, true, true, true};
  private int autoSalvar = 0;
  private int velocidade = 4;
  private int velocidadeNH = 4;
  private int verDecisaoPenNaoHumano = 0;
  private int verMudancaTecnicos = 1;
  private int verJanelaSubs = 1;
  private int avisoTerminoContrato = 0;
  private boolean autoRenovaContrato = true;
  private boolean usaCorPlacar = true;
  private int corPlacar = 0;
  private boolean usaSons = true;
  private boolean negritoCasa = true;
  private boolean usaCoresLista = false;
  private Color[] coresLista = null;
  private boolean verEstaduaisAgrupados = false;
  private boolean ignoraLigas = true;
  private boolean ignoraEstadual = true;
  private boolean UsarGruposReaisCopa = false;
  private boolean[] jogaRegionaisTodos = new boolean[]{true, true, true, true};
  private boolean conviteRegionais = false;
  private int regionaisSemHumanos = 0;
  private boolean verMundias = false;
  private boolean verSuperCopas = false;
  private boolean novoFormatoCopa = true;
  private int corTema = 0;
  private boolean verLeiloes = false;

  public boolean isJogaEstadual() {
    return jogaEstadual;
  }

  public void setJogaEstadual(boolean value) {
    jogaEstadual = value;
  }

  public boolean isJogaRegionais() {
    return jogaRegionais;
  }

  public void setJogaRegionais(boolean value) {
    jogaRegionais = value;
  }

  public boolean isUsaGrupoPadraoEstadual() {
    return usaGrupoPadraoEstadual;
  }

  public void setUsaGrupoPadraoEstadual(boolean value) {
    usaGrupoPadraoEstadual = value;
  }

  public boolean isJogaIntClubes() {
    return jogaIntClubes;
  }

  public void setJogaIntClubes(boolean value) {
    jogaIntClubes = value;
  }

  public boolean[] getJogaSelecoes() {
    return jogaSelecoes;
  }

  public void setJogaSelecoes(boolean[] value) {
    jogaSelecoes = value;
  }

  public boolean isSalarioMensal() {
    return salarioMensal;
  }

  public void setSalarioMensal(boolean value) {
    salarioMensal = value;
  }

  public boolean isHabilidadeIndividual() {
    return habilidadeIndividual;
  }

  public void setHabilidadeIndividual(boolean value) {
    habilidadeIndividual = value;
  }

  public boolean isJogaIntano1() {
    return jogaIntano1;
  }

  public void setJogaIntano1(boolean value) {
    jogaIntano1 = value;
  }

  public boolean isGruposIntPadrao() {
    return gruposIntPadrao;
  }

  public void setGruposIntPadrao(boolean value) {
    gruposIntPadrao = value;
  }

  public boolean[] getVerJint() {
    return verJint;
  }

  public void setVerJint(boolean value, int index) {
    verJint[index] = value;
    GamePersistence.careerState.setVerJint(value, index);
  }

  public void setVerJint(boolean[] value) {
    verJint = value;
    GamePersistence.careerState.setVerJint(value);
  }

  public static long getSerialversionuid() {
    return 1L;
  }

  public boolean isJogaSelecoesAll() {
    return jogaSelecoesAll;
  }

  public void setJogaSelecoesAll(boolean value) {
    jogaSelecoesAll = value;
  }

  public boolean isNegritoCasa() {
    return negritoCasa;
  }

  public void setNegritoCasa(boolean value) {
    negritoCasa = value;
    GamePersistence.careerState.setNegritoCasa(value);
  }

  public int getAutoSalvar() {
    return autoSalvar;
  }

  public void setAutoSalvar(int value) {
    autoSalvar = value;
    GamePersistence.careerState.setAutoSalvar(value);
  }

  public int getVelocidade() {
    return velocidade;
  }

  public void setVelocidade(int value) {
    velocidade = value;
    GamePersistence.careerState.setVelocidade(value);
  }

  public int getVelocidadeNH() {
    return velocidadeNH;
  }

  public void setVelocidadeNH(int value) {
    velocidadeNH = value;
    GamePersistence.careerState.setVelocidadeNH(value);
  }

  public int getAvisoTerminoContrato() {
    return avisoTerminoContrato;
  }

  public void setAvisoTerminoContrato(int value) {
    avisoTerminoContrato = value;
    GamePersistence.careerState.setAvisoTerminoContrato(value);
  }

  public int getVerDecisaoPenNaoHumano() {
    return verDecisaoPenNaoHumano;
  }

  public void setVerDecisaoPenNaoHumano(int value) {
    verDecisaoPenNaoHumano = value;
    GamePersistence.careerState.setVerDecisaoPenNaoHumano(value);
  }

  public int getVerMudancaTecnicos() {
    return verMudancaTecnicos;
  }

  public void setVerMudancaTecnicos(int value) {
    verMudancaTecnicos = value;
    GamePersistence.careerState.setVerMudancaTecnicos(value);
  }

  public int getVerJanelaSubs() {
    return verJanelaSubs;
  }

  public void setVerJanelaSubs(int value) {
    verJanelaSubs = value;
    GamePersistence.careerState.setVerJanelaSubs(value);
  }

  public boolean isAutoRenovaContrato() {
    return autoRenovaContrato;
  }

  public void setAutoRenovaContrato(boolean value) {
    autoRenovaContrato = value;
    GamePersistence.careerState.setAutoRenovaContrato(value);
  }

  public boolean isUsaCorPlacar() {
    return usaCorPlacar;
  }

  public void setUsaCorPlacar(boolean value) {
    usaCorPlacar = value;
    GamePersistence.careerState.setUsaCorPlacar(value);
  }

  public int getCorPlacar() {
    return corPlacar;
  }

  public void setCorPlacar(int value) {
    corPlacar = value;
    GamePersistence.careerState.setCorPlacar(value);
  }

  public boolean isUsaSons() {
    return usaSons;
  }

  public void setUsaSons(boolean value) {
    usaSons = value;
    GamePersistence.careerState.setUsaSons(value);
  }

  public boolean isUsaCoresLista() {
    return usaCoresLista;
  }

  public void setUsaCoresLista(boolean value) {
    usaCoresLista = value;
    GamePersistence.careerState.setUsaCoresLista(value);
  }

  public boolean isVerEstaduaisAgrupados() {
    return verEstaduaisAgrupados;
  }

  public void setVerEstaduaisAgrupados(boolean value) {
    verEstaduaisAgrupados = value;
    GamePersistence.careerState.setVerEstaduaisAgrupados(value);
  }

  public Color[] getCoresLista() {
    if (coresLista == null) {
      coresLista = new Color[5];
      coresLista[0] = new Color(148, 148, 73);
      coresLista[1] = new Color(179, 179, 100);
      coresLista[2] = new Color(192, 192, 129);
      coresLista[3] = new Color(209, 209, 163);
      coresLista[4] = new Color(222, 222, 188);
    }
    return coresLista;
  }

  public void setCoresLista(Color[] value) {
    coresLista = value;
    GamePersistence.careerState.setCoresLista(value);
  }

  public boolean isIgnoraLigas() {
    return ignoraLigas;
  }

  public void setIgnoraLigas(boolean value) {
    ignoraLigas = value;
    GamePersistence.careerState.setIgnoraLigas(value);
  }

  public boolean isIgnoraEstadual() {
    return ignoraEstadual;
  }

  public void setIgnoraEstadual(boolean value) {
    ignoraEstadual = value;
    GamePersistence.careerState.setIgnoraEstadual(value);
  }

  public boolean isUsarGruposReaisCopa() {
    return UsarGruposReaisCopa;
  }

  public void setUsarGruposReaisCopa(boolean value) {
    UsarGruposReaisCopa = value;
    GamePersistence.careerState.setUsarGruposReaisCopa(value);
  }

  public boolean[] getJogaRegionaisTodos() {
    return jogaRegionaisTodos;
  }

  public void setJogaRegionaisTodos(boolean[] value) {
    jogaRegionaisTodos = value;
  }

  public boolean isConviteRegionais() {
    return conviteRegionais;
  }

  public void setConviteRegionais(boolean value) {
    conviteRegionais = value;
  }

  public int getRegionaisSemHumanos() {
    return regionaisSemHumanos;
  }

  public void setRegionaisSemHumanos(int value) {
    regionaisSemHumanos = value;
  }

  public boolean isNovoFormatoCopa() {
    return novoFormatoCopa;
  }

  public void setNovoFormatoCopa(boolean value) {
    novoFormatoCopa = value;
  }

  public int getCorTema() {
    return corTema;
  }

  public void setCorTema(int value) {
    corTema = value;
  }

  public boolean isVerLeiloes() {
    return verLeiloes;
  }

  public void setVerLeiloes(boolean value) {
    verLeiloes = value;
    GamePersistence.careerState.setVerLeiloes(value);
  }
}
