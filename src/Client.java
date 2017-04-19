import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;


public class Client extends JPanel implements TreeSelectionListener {
	public JEditorPane contentPane;
    public JTree tree;
    public DefaultMutableTreeNode root;
    
	public Client(){
		super(new GridLayout(1,0));
        
        root = new DefaultMutableTreeNode(
        		new Group("Katalog"));
        createNodes(root);
 
        tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
 
        tree.addTreeSelectionListener(this);
 
        JScrollPane treeView = new JScrollPane(tree);
 
        contentPane = new JEditorPane();
        
        
        contentPane.setEditable(false);
        JScrollPane contentView = new JScrollPane(contentPane);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(treeView);
        splitPane.setRightComponent(contentView);
 
        Dimension minimumSize = new Dimension(100, 50);
        contentView.setMinimumSize(minimumSize);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(400); 
 
        splitPane.setPreferredSize(new Dimension(1200, 700));
 
        add(splitPane);
	}
	
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node =  (DefaultMutableTreeNode)tree
				.getLastSelectedPathComponent();

		if (node == null)
			return;

		Object nodeInfo = node.getUserObject();
		
			Part part = (Part) nodeInfo;
			
			//Wy�wietlamy dane klikni�tego obiektu w drzewie
			displayData(part);
		
	}
	
	 private void displayData(Part part) {
		 contentPane.setFont(new java.awt.Font("Arial", Font.PLAIN, 18));
		 
		 /*Traktujemy wszystkie obiekty w jednakowy spos�b
		  wywo�uj�c metod� getData()*/
		 contentPane.setText(part.getData());
	}

	private void createNodes(DefaultMutableTreeNode root) {
	    	DefaultMutableTreeNode category = null;
	        DefaultMutableTreeNode part = null;
	 
	        Part zawieszenie = new Group("Zawieszenie");
	        zawieszenie.setData("zesp� element�w ��cz�cych ko�a z reszt� pojazdu. "
	        		+ "Zawieszenie przenosi si�y powstaj�ce na styku ko�a z jezdni� na "
	        		+ "nadwozie. Zapewnia komfort jazdy oraz stateczno�� i sterowno�� "
	        		+ "pojazdu.");
	        category = new DefaultMutableTreeNode(zawieszenie);
	        root.add(category);

	        Part amortyzator = new SimplePart("amortyzator");
	        amortyzator.setPrice(32.50);
	        amortyzator.setData("mechanizm, kt�rego zadaniem jest przechwyci�"
	        		+ " i rozproszy� nadmiar energii w uk�adzie mechanicznym. "
	        		+ "U�ywany jest w celu zabezpieczenia urz�dzenia lub operatora "
	        		+ "przed negatywnym oddzia�ywaniem drga� i zwi�kszenia komfortu "
	        		+ "eksploatacji.");
	        zawieszenie.addPart(amortyzator);
	        part = new DefaultMutableTreeNode(amortyzator);
	        category.add(part);
	        
	        Part sprezyna = new SimplePart("spr�yna");
	        sprezyna.setPrice(342.50);
	        sprezyna.setData("Utrzymuj� mas� pojazdu i �agodz� drgania wynikaj�ce "
	        		+ "z poruszania si� pojazdu po nier�wnej nawierzchni. Wyd�u�aj� "
	        		+ "�ywotno�� amortyzator�w oraz innych element�w uk�adu "
	        		+ "jezdnego(opony, elementy metalowo-gumowe zawieszenia)."
	        		+ "Spr�yny wraz z amortyzatorami w uk�adzie zawieszenia zapewniaj� "
	        		+ "utrzymanie przyczepno�ci k� i umo�liwiaj� bezpieczne prowadzenie "
	        		+ "pojazdu.");
	        zawieszenie.addPart(sprezyna);
	        part = new DefaultMutableTreeNode(sprezyna);
	        category.add(part);
	        
	        Part nadwozie = new Group("Nadwozie");
	        nadwozie.setData("Elementy nadzwozia pojazdu.");
	        category = new DefaultMutableTreeNode(nadwozie);
	        root.add(category);
	        
	        Part lampa_p = new SimplePart("Lampa przednia");
	        lampa_p.setData("Lampa przednia sk�ada si� z szeregu element�w"
	        		+ "takich jak np. klosz, elementy elektroniczne, �ar�wki, odb�y�niki,"
	        		+ "uchwyty monta�owe.");
	        lampa_p.setPrice(167.9);
	        nadwozie.addPart(lampa_p);
	        part = new DefaultMutableTreeNode(lampa_p);
	        category.add(part);
	        
	        Part drzwi_p_l = new SimplePart("Drzwi przednie lewe");
	        drzwi_p_l.setData("Drzwi przeznaczone do pojazdu Nissan Almera 2000");
	        drzwi_p_l.setPrice(839.90);
	        nadwozie.addPart(drzwi_p_l);
	        part = new DefaultMutableTreeNode(drzwi_p_l);
	        category.add(part);
	        
	        Part klampa = new SimplePart("Klapa baga�nika");
	        klampa.setData("Klapa baga�nika do pojazdu Nissan Almera 2000");
	        klampa.setPrice(310);
	        nadwozie.addPart(klampa);
	        part = new DefaultMutableTreeNode(klampa);
	        category.add(part);
	        
	        Part blotnik_p = new SimplePart("B�otnik prawy przedni");
	        blotnik_p.setData("B�otnik prawy przedni do pojazdu Nissan Almera 2000");
	        blotnik_p.setPrice(156.5);
	        nadwozie.addPart(blotnik_p);
	        part = new DefaultMutableTreeNode(blotnik_p);
	        category.add(part);
	        
	        Part nakretka = new SimplePart("nakr�tka");
	        nakretka.setPrice(1.35);
	        nakretka.setData("Nakr�tka uniwersalna 10\"");
	        part = new DefaultMutableTreeNode(nakretka);
	        root.add(part);
	        
	        Part felga = new SimplePart("Felga stalowa");
	        felga.setPrice(680.3);
	        felga.setData("Felga stalowa w rozmiarze 18\". Rozstaw �rub 4x100.");
	        part = new DefaultMutableTreeNode(felga);
	        root.add(part);
		}
	 
    public static void main(String[] args) {
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

	protected static void createAndShowGUI() {
		
        JFrame frame = new JFrame("Katalog cz�ci");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Client newContentPane = new Client();
        
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
 
        frame.pack();
        frame.setVisible(true);
	}
	
}