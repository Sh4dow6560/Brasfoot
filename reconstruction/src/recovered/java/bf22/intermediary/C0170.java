package bf22.intermediary;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import mod.recovered.model.Player;

class C0170 implements TreeSelectionListener {
   final bf22.intermediary.C0164 BW;
   C0170(C0164 c0164) {
      this.BW = c0164;
   }

   @Override
   public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
      DefaultMutableTreeNode var2 = (DefaultMutableTreeNode)C0164.f(this.BW).getLastSelectedPathComponent();
      if (var2 != null) {
         Object var3 = var2.getUserObject();
         if (var2.isLeaf() && var3 instanceof Player) {
            Player var4 = (Player)var3;
            C0164.a(this.BW, var4);
         }
      }
   }
}
