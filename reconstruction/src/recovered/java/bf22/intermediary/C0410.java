package bf22.intermediary;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import mod.recovered.model.Club;

class C0410 implements TreeSelectionListener {
   final bf22.intermediary.C0404 Ma;
   C0410(C0404 c0404) {
      this.Ma = c0404;
   }

   @Override
   public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
      DefaultMutableTreeNode var2 = (DefaultMutableTreeNode)C0404.e(this.Ma).getLastSelectedPathComponent();
      if (var2 != null) {
         Object var3 = var2.getUserObject();
         if (var2.isLeaf() && var3 instanceof Club) {
            Club var4 = (Club)var3;
            this.Ma.F(var4);
         }
      }
   }
}
