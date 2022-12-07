package gui.contents.main;

import database.OrderListDB;
import database.OrderManagementDB;
import gui.contents.sub.GuideSubPanel;
import gui.contents.sub.SubOrderlist;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.List;
public class OrderList extends JPanel implements ActionListener, MouseListener{
	private List<List<String>> OrderList;
	int Ordersize = 0;

	String[][] data = {//주문번호 그림 이름 갯수 단가 배송일자 배송상태
			{"190011","/images/nullimage.png","족구화1","1","29800","2022-11-01","상품준비중","81"}
	};
	String[] selectdata = data[0];
	private DecimalFormat formatter = new DecimalFormat("###,###");
	private JPanel[] titlepanel; // 타이틀 패널

	private JPanel[] listpanel; // 금액 제목 갯수 묶음 패널
	private JPanel[] listPanel3;
	private JPanel[] listpanel2; //그림 배송완료 포함 패널


	private JPanel[][] listdetailpanel; //데이터 패널 레이블
	private JLabel[][] listdetaillabel;

	private JLabel[] yyyy; // 타이틀에 들어갈 배송일자

	private Font font1 = new Font(Setup.font, Font.BOLD, 18);
	private Font font2 = new Font(Setup.font, Font.BOLD, 14);
	private Font font3 = new Font(Setup.font, Font.BOLD, 16);

	private Font starfont = new Font(Setup.font, Font.BOLD, 10);
	int y=0;
	private JPanel p = new JPanel(); // 메인
	private JPanel p2 = new JPanel(); //서브
	private JPanel p3 = new JPanel();
	private String[] request= data[0];
	private int selectPanel = -1;
	@Override
	public void mouseClicked(MouseEvent e) {
		int a = Setup.CustomerNum;
		OrderList = OrderListDB.OrderList(a);
		Ordersize = OrderList.size();
		for(int i=0;i<Ordersize;i++) {
			if (selectPanel != -1) {
				if (e.getSource() == listpanel[selectPanel]) {
						Setup.changePanel(p2, new GuideSubPanel("상품을 선택해서 정보를 변경할 수 있습니다."));
						listpanel[selectPanel].setBorder(null);
						selectPanel = -1;
						return;
				}else if (e.getSource() == listpanel[i]) {
					for(int j=0;j<8;j++) {
						request[j] = OrderList.get(i).get(j) + "";
					}
					listpanel[selectPanel].setBorder(null);
					selectPanel = i;
					Setup.changePanel(p2, new SubOrderlist(request,OrderListDB.ismyReview(Setup.CustomerNum, Integer.parseInt(OrderList.get(i).get(7)))));
					listpanel[selectPanel].setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
					return;
				}
			}else if (e.getSource() == listpanel[i]) {
				for(int j=0;j<8;j++) {
					request[j] = OrderList.get(i).get(j) + "";
				}
				selectPanel = i;
				Setup.changePanel(p2, new SubOrderlist(request,OrderListDB.ismyReview(Setup.CustomerNum, Integer.parseInt(OrderList.get(i).get(7)))));
				listpanel[selectPanel].setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
				return;
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public OrderList() {
		int a = Setup.CustomerNum;
		OrderList = OrderListDB.OrderList(a);
		Ordersize = OrderList.size();
		if(Ordersize == 0 || OrderList == null) {
			JPanel noselpanel = new JPanel();
			JLabel nosel = new JLabel("주문하신 상품이 없어요");
			nosel.setFont(font1);
			noselpanel.add(nosel);
			this.add(noselpanel);
		}else {
			titlepanel = new JPanel[Ordersize]; // 타이틀 패널
			listpanel = new JPanel[Ordersize]; // 금액 제목 갯수 묶음 패널
			listpanel2 = new JPanel[Ordersize]; //그림 배송완료 포함 패널
			listPanel3 = new JPanel[Ordersize];
			listdetailpanel = new JPanel[Ordersize][8]; //데이터 패널 레이블
			listdetaillabel = new JLabel[Ordersize][8];
			yyyy = new JLabel[Ordersize];
			for(int i=0;i<Ordersize;i++) {
				titlepanel[i] = new JPanel();
				listpanel[i] = new JPanel();
				listpanel2[i] = new JPanel();
				listPanel3[i] = new JPanel();
				titlepanel[i].setBackground(Setup.white);
				listpanel[i].setBackground(Setup.white);
				listpanel2[i].setOpaque(false);
				yyyy[i] = new JLabel();
			}

			for(int i=0;i<Ordersize;i++) {
				for(int j=0;j<8;j++) {
					listdetailpanel[i][j] = new JPanel();
					listdetailpanel[i][j].setOpaque(false);
					listdetaillabel[i][j] = new JLabel();
					listdetaillabel[i][j].setText(OrderList.get(i).get(j));
					listdetailpanel[i][j].add(listdetaillabel[i][j]);
					//주문번호 그림1 이름2 갯수3 단가4 배송일자5 배송상태6
					if(j==1) {
						listdetaillabel[i][j].setText("");
						listdetaillabel[i][j].setIcon(Setup.imageSetSize
								(new ImageIcon(OrderManagementDB.productImageLoad(Integer.parseInt(OrderList.get(i).get(7)))),80,80));
					}else if(j==2) {
						listdetaillabel[i][j].setFont(font1);
					}else if(j==3) {
						listdetaillabel[i][j].setText("수량 "+OrderList.get(i).get(j)+"개");
						listdetaillabel[i][j].setFont(font2);
					}else if(j==4) {
						String won = formatter.format(Integer.parseInt(OrderList.get(i).get(3))*Integer.parseInt(OrderList.get(i).get(4)));
						listdetaillabel[i][j].setForeground(Setup.magenta);
						listdetaillabel[i][j].setText(won+"원");
						listdetaillabel[i][j].setFont(font3);
					}
					else if(j==5) {
						listdetaillabel[i][j].setText("  " + OrderList.get(i).get(j).replace("-", ". "));
						listdetaillabel[i][j].setForeground(Setup.darkGray);
						listdetaillabel[i][j].setFont(font1);
					}else {
						listdetaillabel[i][j].setFont(font1);
					}
				}
			}
			GridBagLayout ProductManageLayout = new GridBagLayout();
			ProductManageLayout.columnWidths = new int[]{675, 0};//985 675
			ProductManageLayout.rowHeights = new int[]{685};
			ProductManageLayout.columnWeights = new double[]{0.0, 1.0};

			this.setLayout(ProductManageLayout);
			// 메인 레이아웃
			for(int j=0;j<8;j++) {
				request[j] = OrderList.get(0).get(j)+"";
			}

			p = new JPanel(); // 메인
			p2 = new JPanel(); //서브
			p3 = new GuideSubPanel("상품을 선택해서 정보를 변경할 수 있습니다.");
			p2.add(p3);
			GridBagConstraints productBagCon = new GridBagConstraints();
			productBagCon.insets = new Insets(0, 0, 0, 5);
			productBagCon.fill = GridBagConstraints.BOTH;
			productBagCon.anchor=GridBagConstraints.CENTER;

			this.add(p, productBagCon);
			productBagCon.gridx=1;
			this.add(p2, productBagCon);
			p2.add(new JLabel("상품을 클릭하여 리뷰를 작성해"),productBagCon);
			p2.setLayout(new CardLayout());
			p.setLayout(new CardLayout());

			JScrollPane sc = new JScrollPane();
			Setup.changeScrollBar(sc);
			p.add(sc);

			JPanel panel = new JPanel(); // 스크롤

			panel.setBackground(Setup.bgLightGray);
			sc.setBorder(null);
			panel.setLayout(null);
			sc.setViewportView(panel);

			GridBagLayout titleLayout = new GridBagLayout();
			titleLayout.columnWidths = new int[] {675};//675
			titleLayout.rowHeights = new int[] {35};

			GridBagConstraints titleGBC = new GridBagConstraints();
			titleGBC.anchor=GridBagConstraints.WEST;

			GridBagLayout listLayout = new GridBagLayout();
			listLayout.columnWidths = new int[] {130,570};
			listLayout.rowHeights = new int[] {30,120};

			GridBagLayout listLayout2 = new GridBagLayout();
			listLayout2.columnWidths = new int[] {570};
			listLayout2.rowHeights = new int[] {35,25,60};

			for(int i=0;i<Ordersize;i++) {
				titlepanel[i].setLayout(titleLayout);
				listpanel[i].setLayout(listLayout);
				listpanel2[i].setLayout(listLayout2);
				listpanel[i].addMouseListener(this);
			}
			GridBagConstraints test = new GridBagConstraints();
			GridBagConstraints test2 = new GridBagConstraints();
			for(int i=0;i<Ordersize;i++) {
				if(i==0 || !OrderList.get(i).get(0).equals(OrderList.get(i-1).get(0))) {
					if(i==0) {
						panel.add(titlepanel[i]);
						titlepanel[i].setBounds(0, y, 665, 35);
						y+=35;
						titlepanel[i].add(listdetailpanel[i][5],titleGBC);
						y+=2;
					}else {
						y+=7;
						panel.add(titlepanel[i]);
						titlepanel[i].setBounds(0, y, 665, 35);
						y+=35;
						titlepanel[i].add(listdetailpanel[i][5],titleGBC);
						y+=2;
					}
					panel.add(listpanel[i]);
					listpanel[i].setBounds(0, y, 665, 150);
					y+=150;

					test.gridx=0;
					test.gridy=0;

					listpanel[i].add(listdetailpanel[i][6],test);
					test.gridx=0;
					test.gridy=1;
					listpanel[i].add(listdetailpanel[i][1],test);
					test.gridx=1;
					test.gridy=1;
					listpanel[i].add(listpanel2[i],test);


					test2.gridx=0;
					test2.gridy=0;
					test2.fill=GridBagConstraints.NONE;
					test2.anchor = GridBagConstraints.SOUTHWEST;
					listpanel2[i].add(listdetailpanel[i][2],test2);
					test2.gridx=0;
					test2.gridy=1;
					test2.anchor = GridBagConstraints.WEST;
					listpanel2[i].add(listdetailpanel[i][3],test2);
					test2.gridx=0;
					test2.gridy=2;
					test2.anchor = GridBagConstraints.NORTHWEST;
					listpanel2[i].add(listdetailpanel[i][4],test2);
					y+=2;
				}else {

					panel.add(listpanel[i]);
					listpanel[i].setBounds(0, y, 665, 150);
					y+=150;

					test.gridx=0;
					test.gridy=0;

					listpanel[i].add(listdetailpanel[i][6],test);
					test.gridx=0;
					test.gridy=1;
					test.insets = new Insets(0, 10, 0, 0);
					listpanel[i].add(listdetailpanel[i][1],test);
					test.gridx=1;
					test.gridy=1;
					test.insets = new Insets(0, 0, 0, 0);
					listpanel[i].add(listpanel2[i],test);
					test2.gridx=0;
					test2.gridy=0;
					test2.fill =GridBagConstraints.VERTICAL;
					test2.anchor = GridBagConstraints.WEST;
					listpanel2[i].add(listdetailpanel[i][2],test2);
					test2.gridx=0;
					test2.gridy=1;
					listpanel2[i].add(listdetailpanel[i][3],test2);
					test2.gridx=0;
					test2.gridy=2;
					listpanel2[i].add(listdetailpanel[i][4],test2);
					y+=2;
				}
			}
			panel.setPreferredSize(new Dimension(sc.getWidth(), y));
		}
	}
}
