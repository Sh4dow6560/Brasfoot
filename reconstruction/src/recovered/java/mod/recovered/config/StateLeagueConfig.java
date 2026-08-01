package mod.recovered.config;

import mod.recovered.core.GameConstants;
import java.io.Serializable;

public class StateLeagueConfig implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id = -1;
  private int divisao = -1;
  private int formula = 0;
  private int nRebaixados = 2;
  private int desempate = 0;
  private int[] finaisIdaVolta = new int[]{2, 2, 2};

  public int getnTimes() {
    return GameConstants.sL[formula][0];
  }

  public StateLeagueConfig(int id, int divisao) {
    setId(id);
    setDivisao(divisao);
  }

  public StateLeagueConfig(int[] values) {
    setId(values[0]);
    setDivisao(values[1]);
    setFormula(values[2]);
    setnRebaixados(values[3]);
    setDesempate(values[4]);
    setFinaisIdaVolta(values[5], values[6], values[7]);
  }

  public void setFinaisIdaVolta(int first, int second, int third) {
    finaisIdaVolta[0] = first;
    finaisIdaVolta[1] = second;
    finaisIdaVolta[2] = third;
  }

  public boolean[] getFinaisIdaVoltaFormatado() {
    boolean[] formatted = new boolean[]{false, false, false, true, true, true, true};
    if (finaisIdaVolta[0] == 2) {
      formatted[0] = true;
    }
    if (finaisIdaVolta[1] == 2) {
      formatted[1] = true;
    }
    if (finaisIdaVolta[2] == 2) {
      formatted[2] = true;
    }
    return formatted;
  }

  public void setFinaisIdaVoltaComIndex(int index, int value) {
    if (value == 1 || value == 2) {
      finaisIdaVolta[index] = value;
    }
  }

  public String getFinaisIdaVoltaString() {
    return Integer.toString(finaisIdaVolta[0]) + ","
        + finaisIdaVolta[1] + "," + finaisIdaVolta[2];
  }

  public int getId() {
    return id;
  }

  public String getIdString() {
    return Integer.toString(id);
  }

  public void setId(int id) {
    this.id = id >= 0 && id <= 26 ? id : -1;
  }

  public int getDivisao() {
    return divisao;
  }

  public String getDivisaoString() {
    return Integer.toString(divisao);
  }

  public void setDivisao(int divisao) {
    if (divisao <= 4) {
      this.divisao = divisao;
    }
  }

  public int getFormula() {
    return formula;
  }

  public String getFormulaString() {
    return Integer.toString(formula);
  }

  public void setFormula(int formula) {
    this.formula = formula < GameConstants.sL.length ? formula : 0;
  }

  public int getnRebaixados() {
    return nRebaixados;
  }

  public String getnRebaixadosString() {
    return Integer.toString(nRebaixados);
  }

  public void setnRebaixados(int nRebaixados) {
    if (nRebaixados > 0 && nRebaixados <= 4) {
      this.nRebaixados = nRebaixados;
    }
  }

  public int getDesempate() {
    return desempate;
  }

  public String getDesempateString() {
    return Integer.toString(desempate);
  }

  public void setDesempate(int desempate) {
    if (desempate == 0 || desempate == 1) {
      this.desempate = desempate;
    }
  }
}
