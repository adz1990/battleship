package views;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.logging.Logger;

import javax.swing.JPanel;

import models.BattleGrid;
import controllers.PlacementController;

public class BattleGridView extends JPanel {
    
    private static final Logger logger = Logger.getLogger(BattleGridView.class.getName());

    /** Size of the grid used by the game. */
    private final int        GRID_SIZE;

    /** Grid gap size in pixels. */
    private final static int GRID_GAP = 3;

    public BattleGridView(PlacementController con, BattleGrid grid) {

        GRID_SIZE = grid.gridSize();

        this.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE, GRID_GAP, GRID_GAP));

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                BattleGridSquare square = new BattleGridSquare(i, j);
                square.addPlacementClickListener(this, con, grid);
                this.add(square);
                
                square.setSquareBackground(grid);
            }
        }
        
        logger.finer("Created BattleGridView");
    }
    
    public void redrawSquareBackgrounds(BattleGrid grid) {
        for(Component square : this.getComponents()) {
            BattleGridSquare sq = (BattleGridSquare) square;
            sq.setSquareBackground(grid);
        }
    }

}
