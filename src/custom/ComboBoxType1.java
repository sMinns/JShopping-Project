package custom;

import gui.common.Frame;
import system.Setup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class ComboBoxType1 extends JComboBox {
    public ComboBoxType1(String[] items, int size) {
        setModel(new DefaultComboBoxModel(items));
        this.setRenderer(new MyComboBoxRenderer());
        this.setEditor(new MyComboBoxEditor());
        this.setPreferredSize(new Dimension(size, 35));
        this.setEditable(true);
        this.setUI(new MyComboBoxUI());
        this.setMaximumRowCount(15);
    }
    
    //버튼 누르면 뜨는 목록
    private class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
        public MyComboBoxRenderer() {
            setOpaque(true);
            setPreferredSize(new Dimension(100, 26));
            setBackground(Color.WHITE);
        }
        @Override
        public Component getListCellRendererComponent(JList l, Object val,
                                                      int i, boolean isSelected, boolean cellHasFocus) {
            setText(" " + val.toString());
            Color foreground;
            Font font;
            if (isSelected) {
                foreground = Setup.magenta;
                font = new Font(Setup.font, Font.BOLD, 12);
            } else {
                foreground = Setup.darkGray;
                font = new Font(Setup.font, Font.PLAIN, 12);
            }
            setForeground(foreground);
            setFont(font);
            setBorder(new EmptyBorder(0, 0 ,0 , 0));
            return this;
        }
    }
    //선택한 선택한 값
    private class MyComboBoxEditor extends BasicComboBoxEditor {
        private JLabel l = new JLabel();
        private JPanel p = new JPanel();
        private Object objSelected;
        public MyComboBoxEditor() {
            l.setOpaque(false);
            l.setFont(new Font(Setup.font, Font.PLAIN, 12));
            l.setForeground(new Color(34, 34, 34));
            p.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 8));
            p.add(l);
            p.setBackground(Color.white);
        }
        public Component getEditorComponent() {
            return this.p;
        }
        public Object getItem() {
            return this.objSelected.toString();
        }
        public void setItem(Object item) {
            this.objSelected = item;
            l.setText(item.toString());
        }
    }
    //목록 여는 버튼
    private class MyComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            ImageIcon Image = new ImageIcon(ComboBoxType1.class.getResource("/images/combobutton.png"));
            JButton button = new JButton(Image);
            button.setBackground(Color.white);
            button.setBorderPainted(false);
            return button;
        }
    }
}