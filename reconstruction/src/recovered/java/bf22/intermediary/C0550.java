package bf22.intermediary;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import mod.recovered.model.Club;

class C0550 implements TreeSelectionListener {
   final bf22.intermediary.C0398 uy;
   C0550(C0398 c0398) {
      this.uy = c0398;
   }

   @Override
   public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
      DefaultMutableTreeNode var2 = (DefaultMutableTreeNode)C0398.c(this.uy).getLastSelectedPathComponent();
      if (var2 != null) {
         Object var3 = var2.getUserObject();
         if (var2.isLeaf() && var3 instanceof Club) {
            Club var4 = (Club)var3;
            this.uy.F(var4);
         }
      }
   }
}
