package core;

import core.controller.MouseController;
import core.controller.SettingController;
import core.controller.colors.BlackController;
import core.controller.colors.BlueController;
import core.controller.colors.DarkGreyController;
import core.controller.colors.GreenController;
import core.controller.colors.RedController;
import core.controller.colors.WhiteController;
import core.controller.menu.ClearController;
import core.controller.menu.RedoController;
import core.controller.menu.TestController;
import core.controller.menu.UndoController;
import core.controller.mouse.LeftDoubleClickController;
import core.controller.mouse.MiddleClickController;
import core.controller.mouse.RightDoubleClickController;
import core.controller.mouse.RightPressController;
import core.controller.mouse.RightReleaseController;
import core.controller.panel.CircleModeController;
import core.controller.panel.HighlightModeController;
import core.controller.panel.ImageExtractModeController;
import core.controller.panel.LayerModeController;
import core.controller.panel.LineModeButton;
import core.controller.panel.MoveModeController;
import core.controller.panel.PictureModeController;
import core.controller.panel.RectModeController;
import core.controller.panel.TextModeController;
import core.controller.setting.HeightController;
import core.controller.setting.RadiusController;
import core.controller.setting.StrokeController;
import core.controller.setting.TextContentController;
import core.controller.setting.TextSizeContentController;
import core.controller.setting.WidthController;
import core.controller.setting.XController;
import core.controller.setting.YController;
import core.gui.models.menu.items.MenuItem;
import core.gui.models.menu.items.SubMenuItem;
import core.gui.models.panels.bottom.ColorButton;
import core.gui.models.panels.left.LeftPanelButton;
import core.service.scene.structure.create.CircleCreator;
import core.service.scene.structure.create.LineCreator;
import core.service.scene.structure.create.RectCreator;
import core.service.scene.structure.create.StructureCreator;
import core.session.enums.CreatingMode;
import core.utils.sys.Machine;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class Config {
    public static final String DEFAULT_IMAGE_FILE_PATH = "src/main/resources/image.png";

    public static final int WINDOW_HEIGHT = (int) (Machine.getScreenHeight() * 0.7);
    public static final int WINDOW_WIDTH = (int) (Machine.getScreenWidth() * 0.7);
    public static final int WINDOW_POSITION_X =
            Machine.getScreenWidth() / 2 - Config.WINDOW_WIDTH / 2;
    public static final int WINDOW_POSITION_Y =
            Machine.getScreenHeight() / 2 - Config.WINDOW_HEIGHT / 2;
    public static final String TITLE = "Pain Extreme 3000";
    public static final String MOUSE_POSITION_PATTERN = "Mouse position: X: %d; Y: %d;";
    public static final String USAGE_MEMORY_PATTERN = "Usage memory: %s";
    public static final Color LEFT_PANEL_BG_COLOR = Color.DARK_GRAY;
    public static final Color RIGHT_PANEL_BG_COLOR = Color.WHITE;
    public static final Color BOTTOM_PANEL_BG_COLOR = Color.WHITE;
    public static final Color PANEL_BG_COLOR = Color.GRAY;
    public static final Color CANVAS_BG_COLOR = Color.GRAY;
    public static final CreatingMode DEFAULT_CREATING_MODE = CreatingMode.HIGHLIGHTING;
    public static final Color DEFAULT_COLOR = Color.BLACK;
    public static final int DEFAULT_STROKE = 2;
    public static final int RELATIVE_POINTS_VISIBILITY_RADIUS = 15;
    public static final int CLONE_SHIFT_DISTANCE = 25;
    public static final BasicStroke BASIC_STROKE
            = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
            0, new float[]{9}, 0);
    public static final Map<CreatingMode, StructureCreator> STRUCTURE_CREATOR_MAP
            = new HashMap<>();
    public static final Map<String, MouseController> MOUSE_CONTROLLER_MAP
            = new HashMap<>();
    public static final Map<String, SettingController> STRUCTURE_SETTING_CONTROLLER_MAP
            = new HashMap<>();

    public static final MenuItem[] MENU_ELEMENTS = new MenuItem[] {
            new MenuItem("Edit", new SubMenuItem[] {
                    new SubMenuItem("Undo", new UndoController()),
                    new SubMenuItem("Redo", new RedoController()),
                    new SubMenuItem("Clear", new ClearController())
            }),
            new MenuItem("Tests", new SubMenuItem[] {
                    new SubMenuItem("Test 1", new TestController())
            }),
    };

    public static final LeftPanelButton[] LEFT_PANEL_BUTTONS = new LeftPanelButton[] {
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/camera_icon_25x25.png"),
                    CreatingMode.IMAGE_EXTRACT.toString(), new ImageExtractModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/hand_icon_25x25.png"),
                    CreatingMode.MOVING.toString(), new MoveModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/dashed_rect_icon_25x25.png"),
                    CreatingMode.HIGHLIGHTING.toString(), new HighlightModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/line_icon_25x25.png"),
                    CreatingMode.LINE.toString(), new LineModeButton()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/circle_icon_25x25.png"),
                    CreatingMode.CIRCLE.toString(), new CircleModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/rect_icon_25x25.png"),
                    CreatingMode.RECT.toString(), new RectModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/text_icon_25x25.png"),
                    CreatingMode.TEXT.toString(), new TextModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/layer_icon_25x25.png"),
                    CreatingMode.LAYER.toString(), new LayerModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/picture_icon_25x25.png"),
                    CreatingMode.PICTURE.toString(), new PictureModeController())
    };

    public static final ColorButton[] COLOR_BUTTONS = new ColorButton[] {
            new ColorButton(Color.RED, "red", new RedController()),
            new ColorButton(Color.GREEN, "green", new GreenController()),
            new ColorButton(Color.BLUE, "blue", new BlueController()),
            new ColorButton(Color.BLACK, "black", new BlackController()),
            new ColorButton(Color.DARK_GRAY, "dark_grey", new DarkGreyController()),
            new ColorButton(Color.WHITE, "white", new WhiteController()),
    };
    public static final String DEFAULT_TEXT_CONTENT = "Text";
    public static final int MAX_HISTORY_SIZE = 10;

    static {
        fillUpStructureCreatorMap();
        fillUpMouseControllerMap();
        fillUpStructureSettingControllerMap();
    }

    private static void fillUpStructureSettingControllerMap() {
        STRUCTURE_SETTING_CONTROLLER_MAP.put("Radius", new RadiusController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("Height", new HeightController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("Width", new WidthController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("X", new XController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("Y", new YController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("Stroke", new StrokeController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("Text", new TextContentController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("Size", new TextSizeContentController());
    }

    private static void fillUpMouseControllerMap() {
        MOUSE_CONTROLLER_MAP.put("left_double_click", new LeftDoubleClickController());
        MOUSE_CONTROLLER_MAP.put("right_double_click", new RightDoubleClickController());
        MOUSE_CONTROLLER_MAP.put("right_press", new RightPressController());
        MOUSE_CONTROLLER_MAP.put("right_release", new RightReleaseController());
        MOUSE_CONTROLLER_MAP.put("middle_click", new MiddleClickController());
    }

    private static void fillUpStructureCreatorMap() {
        STRUCTURE_CREATOR_MAP.put(CreatingMode.CIRCLE, new CircleCreator());
        STRUCTURE_CREATOR_MAP.put(CreatingMode.LINE, new LineCreator());
        STRUCTURE_CREATOR_MAP.put(CreatingMode.RECT, new RectCreator());
    }
}
