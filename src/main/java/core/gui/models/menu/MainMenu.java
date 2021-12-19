package core.gui.models.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import core.gui.models.ElementsGroup;
import core.gui.models.menu.items.MenuItem;
import core.gui.models.menu.items.SubMenuItem;

public class MainMenu extends JMenuBar implements ElementsGroup {
    private static final long serialVersionUID = 1L;
    private final MenuItem[] elements;

    public MainMenu(MenuItem[] menuElements) {
        super();
        this.elements = menuElements;
    }

    @Override
    public void create() {
        for (MenuItem menuElement : elements) {
            JMenu addedElement = add(creatItem(menuElement.getName()));
            for (SubMenuItem subElement : menuElement.getElements()) {
                addSubElement(addedElement, subElement);
            }
        }
    }

    private void addSubElement(JMenu element, SubMenuItem subMenuElement) {
        JMenuItem open = new JMenuItem(subMenuElement.getName());
        element.add(open);
        element.addSeparator();
        open.addActionListener(arg0 -> subMenuElement.getController().apply());
    }

    private JMenu creatItem(String itemName) {
        return new JMenu(itemName);
    }
}
