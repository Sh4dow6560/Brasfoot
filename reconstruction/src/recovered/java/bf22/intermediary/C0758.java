package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;

public class C0758 extends JLayeredPane {
   @Override
   public String getToolTipText(MouseEvent mouseEvent) {
      new Point(mouseEvent.getX(), mouseEvent.getY());
      if (C0795.W(mouseEvent.getX(), mouseEvent.getY())) {
         int var3 = C0795.T(mouseEvent.getX(), mouseEvent.getY());
         if (var3 >= 1 && ((C0795)C0132.oa().get(var3)).x() != null) {
            String var4 = "";
            if (var3 <= 25 && GameConstants.sE[var3][0] != ((C0795)C0132.oa().get(var3)).x().getPosicao()) {
               var4 = "Improvisado como " + GameConstants.rH[GameConstants.sE[var3][0]];
            }

            Double var5 = ((C0795)C0132.oa().get(var3)).x().F();
            String var6 = String.format("%.2f", var5);
            if (var5 < 2.0) {
               var6 = "--";
            }

            if (!GamePersistence.careerState.isHabilidadeIndividual()) {
               return "<html>"
                  + ((C0795)C0132.oa().get(var3)).x().getNome()
                  + "(F:"
                  + Integer.toString(((C0795)C0132.oa().get(var3)).x().getOverallStrength())
                  + " E:"
                  + Integer.toString(((C0795)C0132.oa().get(var3)).x().fp())
                  + ")"
                  + "<br><b>Posicão original:</b> "
                  + GameConstants.rH[((C0795)C0132.oa().get(var3)).x().getPosicao()]
                  + "<br><b>Lado original:</b> "
                  + GameConstants.rK[((C0795)C0132.oa().get(var3)).x().getLado()]
                  + "<br><b>Idade:</b> "
                  + Integer.toString(((C0795)C0132.oa().get(var3)).x().getIdade())
                  + "<br><b>Caract:</b> "
                  + GameConstants.qN[((C0795)C0132.oa().get(var3)).x().getCr1()]
                  + "/"
                  + GameConstants.qN[((C0795)C0132.oa().get(var3)).x().getCr2()]
                  + "<br><b>Nota média</b>: "
                  + var6
                  + "<br>"
                  + var4
                  + "</html>";
            }

            return "<html>"
               + ((C0795)C0132.oa().get(var3)).x().getNome()
               + "(E:"
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().fp())
               + ")"
               + "<br><b>Posicão original:</b> "
               + GameConstants.rH[((C0795)C0132.oa().get(var3)).x().getPosicao()]
               + "<br><b>Lado original:</b> "
               + GameConstants.rK[((C0795)C0132.oa().get(var3)).x().getLado()]
               + "<br><b>Idade:</b> "
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getIdade())
               + "<br><b>Caract:</b> "
               + GameConstants.qN[((C0795)C0132.oa().get(var3)).x().getCr1()]
               + "/"
               + GameConstants.qN[((C0795)C0132.oa().get(var3)).x().getCr2()]
               + "<br><b>Gol: "
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getGoalkeeping())
               + "<br><b>Des: "
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getTackling())
               + "<br><b>Arm: "
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getPlaymaking())
               + "<br><b>Fin: "
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getFinishing())
               + "<br><b>Vel: "
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getSpeed())
               + "<br><b>Tec: "
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getTechnique())
               + "<br><b>Pas: "
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getPassing())
               + "<br><b>Nota média</b>: "
               + var6
               + "<br>"
               + var4
               + "</html>";
         }
      }

      return super.getToolTipText(mouseEvent);
   }
}
