package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;

public class C0757 extends JLayeredPane {
   @Override
   public String getToolTipText(MouseEvent mouseEvent) {
      new Point(mouseEvent.getX(), mouseEvent.getY());
      if (C0795.V(mouseEvent.getX(), mouseEvent.getY())) {
         int var3 = C0795.S(mouseEvent.getX(), mouseEvent.getY());
         if (var3 >= 1 && ((C0795)C0132.oa().get(var3)).x() != null) {
            String var4 = "";
            Double var5 = 0.0;
            if (var3 >= 0 && var3 < C0132.oa().size()) {
               var5 = ((C0795)C0132.oa().get(var3)).x().F();
            }

            String var6 = String.format("%.2f", var5);
            if (var5 < 2.0) {
               var6 = "--";
            }

            if (var3 <= 25 && GameConstants.sE[var3][0] != ((C0795)C0132.oa().get(var3)).x().getPosicao()) {
               var4 = "Improvisado como " + GameConstants.rH[GameConstants.sE[var3][0]];
            }

            if (!GamePersistence.careerState.isHabilidadeIndividual()) {
               return "<html>"
                  + ((C0795)C0132.oa().get(var3)).x().getNome()
                  + "(F:"
                  + Integer.toString(((C0795)C0132.oa().get(var3)).x().getOverallStrength())
                  + " E:"
                  + Integer.toString(((C0795)C0132.oa().get(var3)).x().getEnergy())
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
               + " (E:"
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getEnergy())
               + ")"
               + "<br><b>Posicão original: </b>"
               + GameConstants.rH[((C0795)C0132.oa().get(var3)).x().getPosicao()]
               + "<br><b>Lado original: </b>"
               + GameConstants.rK[((C0795)C0132.oa().get(var3)).x().getLado()]
               + "<br><b>Idade: </b>"
               + Integer.toString(((C0795)C0132.oa().get(var3)).x().getIdade())
               + "<br><b>Caract: </b>"
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
      } else if (C0795.X(mouseEvent.getX(), mouseEvent.getY())) {
         int var7 = C0795.U(mouseEvent.getX(), mouseEvent.getY());
         Double var8 = 0.0;
         if (var7 >= 0 && var7 < C0132.oa().size()) {
            var8 = ((C0795)C0132.oa().get(var7)).x().F();
         }

         String var9 = String.format("%.2f", var8);
         if (var8 < 2.0) {
            var9 = "--";
         }

         if (var7 >= 1 && ((C0795)C0132.oa().get(var7)).x() != null) {
            if (!GamePersistence.careerState.isHabilidadeIndividual()) {
               return "<html>"
                  + ((C0795)C0132.oa().get(var7)).x().getNome()
                  + "<br><b>Posicão original:</b>"
                  + GameConstants.rH[((C0795)C0132.oa().get(var7)).x().getPosicao()]
                  + "<br><b>Lado original:</b>"
                  + GameConstants.rK[((C0795)C0132.oa().get(var7)).x().getLado()]
                  + "<br><b>Idade:</b>"
                  + Integer.toString(((C0795)C0132.oa().get(var7)).x().getIdade())
                  + "<br><b>Caract:</b>"
                  + GameConstants.qN[((C0795)C0132.oa().get(var7)).x().getCr1()]
                  + "/"
                  + GameConstants.qN[((C0795)C0132.oa().get(var7)).x().getCr2()]
                  + "<br><b>Nota média</b>: "
                  + var9
                  + "</html>";
            }

            return "<html>"
               + ((C0795)C0132.oa().get(var7)).x().getNome()
               + "<br><b>Posicão original:</b>"
               + GameConstants.rH[((C0795)C0132.oa().get(var7)).x().getPosicao()]
               + "<br><b>Lado original:</b>"
               + GameConstants.rK[((C0795)C0132.oa().get(var7)).x().getLado()]
               + "<br><b>Idade:</b>"
               + Integer.toString(((C0795)C0132.oa().get(var7)).x().getIdade())
               + "<br><b>Caract:</b>"
               + GameConstants.qN[((C0795)C0132.oa().get(var7)).x().getCr1()]
               + "/"
               + GameConstants.qN[((C0795)C0132.oa().get(var7)).x().getCr2()]
               + "<br><b>Gol: "
               + Integer.toString(((C0795)C0132.oa().get(var7)).x().getGoalkeeping())
               + "<br><b>Des:"
               + Integer.toString(((C0795)C0132.oa().get(var7)).x().getTackling())
               + "<br><b>Arm:"
               + Integer.toString(((C0795)C0132.oa().get(var7)).x().getPlaymaking())
               + "<br><b>Fin: "
               + Integer.toString(((C0795)C0132.oa().get(var7)).x().getFinishing())
               + "<br><b>Vel:"
               + Integer.toString(((C0795)C0132.oa().get(var7)).x().getSpeed())
               + "<br><b>Tec:"
               + Integer.toString(((C0795)C0132.oa().get(var7)).x().getTechnique())
               + "<br><b>Pas: "
               + Integer.toString(((C0795)C0132.oa().get(var7)).x().getPassing())
               + "<br><b>Nota média</b>: "
               + var9
               + "</html>";
         }
      }

      return super.getToolTipText(mouseEvent);
   }
}
