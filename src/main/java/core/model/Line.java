package core.model;

import core.model.type.StructureType;
import core.utils.MathFunctions;
import java.awt.Point;

public class Line extends Structure {
    private static final int VISIBILITY_RADIUS = 10;

    public Line(Point centerPosition, Point startPosition, Point endPosition) {
        super(centerPosition, StructureType.LINE);
        relativePoints.put("start", startPosition);
        relativePoints.put("end", endPosition);
    }

    public double getLength() {
        return relativePoints.get("start").distance(relativePoints.get("end"));
    }

    @Override
    public boolean isInside(Point position) {
        return position.distance(centerPosition) <= VISIBILITY_RADIUS;
    }
}
