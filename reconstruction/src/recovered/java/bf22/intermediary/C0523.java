package bf22.intermediary;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import mod.recovered.model.Club;

class C0523 implements TreeSelectionListener {
   final bf22.intermediary.C0512 afI;
   C0523(C0512 c0512) {
      this.afI = c0512;
   }

   @Override
   public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
      DefaultMutableTreeNode var2 = (DefaultMutableTreeNode)C0512.g(this.afI).getLastSelectedPathComponent();
      if (var2 != null) {
         Object var3 = var2.getUserObject();
         if (var2.isLeaf() && var3 instanceof Club) {
            Club var4 = (Club)var3;
            C0512.a(this.afI, var4);
         }
      }
   }
}
