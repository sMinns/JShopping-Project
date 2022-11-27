package event;

import database.AddProductDB;
import database.CategoryDB;
import gui.common.Frame;
import gui.contents.main.ProductManagement;
import gui.contents.sub.AddProduct;
import system.Setup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AddProductEvent implements ActionListener {
    AddProduct a;
    String file;
    public AddProductEvent(AddProduct a) {
        this.a = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == a.getAddButton()) {

            if(file == null) {
                a.setImageStroke(1);
                return;
            }else a.setImageStroke(0);

            if (a.getProductName().equals("")) {
                a.focusProductName();
                return;
            }

            if (a.getProductPrice().equals("")) {
                a.focusProductPrice();
                return;
            }

            if (a.getProductStock().equals("")) {
                a.focusProductStock();
                return;
            }

            LocalDate now = LocalDate.now();

            int canum = CategoryDB.returnCategoryNum(a.getCategory());
            String[] str = {a.getProductName(), file, a.getProductStat(), String.valueOf(now)};
            int[] ints = {canum, Integer.parseInt(a.getProductPrice()), Integer.parseInt(a.getProductStock()),
                    Setup.CustomerNum};

            if(AddProductDB.addProduct(str, ints)) {
                Setup.changePanel(Frame.contentLayeredPanel, new ProductManagement(a.getText()));
            }
        }

        if(e.getSource() == a.getImageButton()) {
            JFileChooser fileComponent = new JFileChooser();
            fileComponent.setMultiSelectionEnabled(false);
            if(fileComponent.showOpenDialog(a) == JFileChooser.APPROVE_OPTION) {
                file = fileComponent.getSelectedFile().toString();
                a.setImage(file);
                a.setImageStroke(0);
            }
        }
    }
}
