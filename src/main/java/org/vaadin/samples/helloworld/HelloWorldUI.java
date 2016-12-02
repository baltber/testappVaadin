package org.vaadin.samples.helloworld;



import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


@Title("My UI")
@Theme("valo")
public class HelloWorldUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        // Create the root content layout
        VerticalLayout root = new VerticalLayout();

        root.setSizeFull();
        setContent(root);

        //root structure
        VerticalLayout layout1 = new VerticalLayout();
        layout1.setMargin(true);
        layout1.setSizeFull();


        VerticalLayout layout2 = new VerticalLayout();
        layout2.setMargin(true);
        layout2.setSizeFull();

        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
        splitPanel.setSplitPosition(30, Unit.PERCENTAGE);

        //left structure
        //TreeTable

        TreeTable treeTable = new TreeTable("Files");
        treeTable.setSizeFull();

        treeTable.addContainerProperty("Name", String.class, null);
        treeTable.addContainerProperty("Number", Integer.class, null);
        treeTable.addItem(new Object[]{"Menu", null}, 0);
        treeTable.addItem(new Object[]{"Beverages", null}, 1);
        treeTable.setParent(1, 0);
        treeTable.addItem(new Object[]{"Foods", null}, 2);
        treeTable.setParent(2, 0);
        treeTable.addItem(new Object[]{"Coffee", 23}, 3);
        treeTable.addItem(new Object[]{"Tea", 42}, 4);
        treeTable.setParent(3, 1);
        treeTable.setParent(4, 1);
        treeTable.addItem(new Object[]{"Bread", 13}, 5);
        treeTable.addItem(new Object[]{"Cake", 11}, 6);
        treeTable.setParent(5, 2);
        treeTable.setParent(6, 2);


        //Buttons left
        HorizontalLayout layoutForButtons = new HorizontalLayout();
                layoutForButtons.setWidth(300, Unit.PIXELS);
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        layoutForButtons.addComponent(button1);
        layoutForButtons.addComponent(button2);
        layoutForButtons.addComponent(button3);


        //Add to left Panel
        layout1.addComponent(treeTable);
        layout1.addComponent(layoutForButtons);
        layout1.setExpandRatio(treeTable,1);
        splitPanel.setFirstComponent(layout1);


        //Right structure
        //For label
         Label label = new Label("LABEL");
         label.setWidth(100, Unit.PERCENTAGE);

        //Tabsheet
        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();
        tabSheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

        for (int i = 1; i < 8; i++) {
            final VerticalLayout layout = new VerticalLayout();
            layout.setMargin(true);
            tabSheet.addTab(layout, "Tab " + i);
        }

        // Right buttons
        HorizontalLayout layoutForButtons2 = new HorizontalLayout();
        layoutForButtons2.setWidth(300, Unit.PIXELS);
        Button button4 = new Button("button4");
        Button button5 = new Button("button5");
        Button button6 = new Button("button6");
        layoutForButtons2.addComponent(button4);
        layoutForButtons2.addComponent(button5);
        layoutForButtons2.addComponent(button6);

        //Add Right components
        layout2.addComponent(label);
        layout2.addComponent(tabSheet);
        layout2.addComponent(layoutForButtons2);
        layout2.setExpandRatio(tabSheet, 1);
        splitPanel.setSecondComponent(layout2);

        root.addComponent(splitPanel);

    }





}