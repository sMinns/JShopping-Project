package event;

import database.CategoryDB;
import database.ProductManagementDB;
import gui.common.Frame;
import gui.contents.main.ProductManagement;
import gui.contents.sub.ChangeProductInfo;
import system.Setup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ChangeProductInfoEvent implements ActionListener {
    ChangeProductInfo c;
    public ChangeProductInfoEvent(ChangeProductInfo c) {
        this.c = c;
    }
    String file;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == c.getChangeButton()) {
            if (c.getProductName().equals("")) {
                c.focusProductName();
                return;
            }

            if (c.getProductPrice().equals("")) {
                c.focusProductPrice();
                return;
            }

            if (c.getProductStock().equals("")) {
                c.focusProductStock();
                return;
            }
            LocalDate now = LocalDate.now();

            int canum = CategoryDB.returnCategoryNum(c.getCategory());
            String[] str = {file, c.getProductName(), String.valueOf(canum),
                    c.getProductPrice(), c.getProductStock(), c.getProductStat()};

            if(ProductManagementDB.updateProductInfo(str, c.getPrnum())) {
                Setup.changePanel(Frame.contentLayeredPanel, new ProductManagement(c.getText()));
            }
        }

        if(e.getSource() == c.getDeleteButton()) {
            if(ProductManagementDB.deleteProduct(Integer.parseInt(c.getPrnum()))) {
                Setup.changePanel(Frame.contentLayeredPanel, new ProductManagement(c.getText()));
            }
        }

        if(e.getSource() == c.getImageButton()) {
            JFileChooser fileComponent = new JFileChooser();
            fileComponent.setMultiSelectionEnabled(false);
            if(fileComponent.showOpenDialog(c) == JFileChooser.APPROVE_OPTION) {
                file = fileComponent.getSelectedFile().toString();
                c.setImage(file);
            }
        }
    }
}
