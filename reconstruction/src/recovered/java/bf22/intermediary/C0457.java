package bf22.intermediary;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import mod.recovered.model.Club;

class C0457 implements TreeSelectionListener {
   final bf22.intermediary.C0452 MV;
   C0457(C0452 c0452) {
      this.MV = c0452;
   }

   @Override
   public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
      DefaultMutableTreeNode var2 = (DefaultMutableTreeNode)C0452.j(this.MV).getLastSelectedPathComponent();
      if (var2 != null) {
         Object var3 = var2.getUserObject();
         if (var2.isLeaf() && var3 instanceof Club) {
            Club var4 = (Club)var3;
            this.MV.F(var4);
         }
      }
   }
}
