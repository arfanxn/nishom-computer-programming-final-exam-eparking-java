/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author arfanxn
 */
public class EPBorderLayoutPanel extends JPanel {

    public static final int NORTH = 1;
    public static final int NORTHEAST = 2;
    public static final int EAST = 3;
    public static final int SOUTHEAST = 4;
    public static final int SOUTH = 5;
    public static final int SOUTHWEST = 6;
    public static final int WEST = 7;
    public static final int NORTHWEST = 8;

    private int layoutConstraint;
    private JPanel mainComponentPanel;
    private Component mainComponent;

    public JPanel getMainComponentPanel() {
        return mainComponentPanel;
    }

    public Component getMainComponent() {
        return this.mainComponent;
    }

    public EPBorderLayoutPanel(Component mainComponent, int layoutConstraint) {
        this.mainComponent = mainComponent;
        this.layoutConstraint = layoutConstraint;
        this.setLayout(new BorderLayout());
        this.mainComponentPanel = new JPanel();
        this.mainComponentPanel.setLayout(new BorderLayout());

        switch (this.layoutConstraint) {
            case NORTH -> {
                this.mainComponentPanel.add(mainComponent, BorderLayout.CENTER);
                this.add(mainComponentPanel, BorderLayout.NORTH);
                System.out.println("Executed");
                break;
            }
            case NORTHEAST -> {
                this.mainComponentPanel.add(mainComponent, BorderLayout.EAST);
                this.add(mainComponentPanel, BorderLayout.NORTH);
                break;
            }
            case EAST -> {
                this.mainComponentPanel.add(mainComponent, BorderLayout.CENTER);
                this.add(mainComponentPanel, BorderLayout.EAST);
                break;
            }
            case SOUTHEAST -> {
                this.mainComponentPanel.add(mainComponent, BorderLayout.EAST);
                this.add(mainComponentPanel, BorderLayout.SOUTH);
                break;
            }
            case SOUTH -> {
                this.mainComponentPanel.add(mainComponent, BorderLayout.CENTER);
                this.add(mainComponentPanel, BorderLayout.SOUTH);
                break;
            }
            case SOUTHWEST -> {
                this.mainComponentPanel.add(mainComponent, BorderLayout.WEST);
                this.add(mainComponentPanel, BorderLayout.SOUTH);
                break;
            }
            case WEST -> {
                this.mainComponentPanel.add(mainComponent, BorderLayout.CENTER);
                this.add(mainComponentPanel, BorderLayout.WEST);
                break;
            }
            case NORTHWEST -> {
                this.mainComponentPanel.add(mainComponent, BorderLayout.WEST);
                this.add(mainComponentPanel, BorderLayout.NORTH);
                break;
            }
        }

        this.setVisible(true);
        this.mainComponentPanel.setVisible(true);
    }
}
