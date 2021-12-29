package core.controller.colors;

import core.App;
import core.controller.Controller;
import core.service.session.update.StructureUpdater;
import java.awt.Color;

public class DarkGreyController implements Controller {
    private final StructureUpdater structureUpdater
            = (StructureUpdater) App.injector.getInstance(StructureUpdater.class);

    @Override
    public void apply() {
        Color color = Color.DARK_GRAY;
        structureUpdater.updateChosenStructureColor(color);
    }
}
