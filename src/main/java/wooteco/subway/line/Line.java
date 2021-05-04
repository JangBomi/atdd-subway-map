package wooteco.subway.line;

import java.util.List;
import java.util.Objects;
import wooteco.subway.station.Station;

public final class Line {
    private Long id;
    private String name;
    private String color;
    private List<Station> stations;

    public Line() {
    }

    public Line(final Long id, final String name, final String color) {
        this(id, name, color, null);
    }

    public Line(final String name, final String color) {
        this(null, name, color, null);
    }

    public Line(final Long id, final String name, final String color, final List<Station> stations) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.stations = stations;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void update(final String name, final String color) {
        this.name = name;
        this.color = color;
    }

    public boolean sameName(final Line persistLine) {
        return this.name.equals(persistLine.name);
    }

    public boolean isId(final Long id) {
        return this.id.equals(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return id.equals(line.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
